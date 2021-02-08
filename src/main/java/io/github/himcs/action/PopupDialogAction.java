// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.himcs.action;

import com.intellij.ide.util.DirectoryUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiManager;
import io.github.himcs.model.CodeSnippetsItem;
import io.github.himcs.model.Data;
import io.github.himcs.model.Question;
import io.github.himcs.model.Response;
import io.github.himcs.model.TopicTagsItem;
import io.github.himcs.util.LeetCodeUtil;
import java.util.List;
import java.util.Optional;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Action class to demonstrate how to interact with the IntelliJ Platform. The only action this
 * class performs is to provide the user with a popup dialog as feedback. Typically this class is
 * instantiated by the IntelliJ Platform framework based on declarations in the plugin.xml file. But
 * when added at runtime this class is instantiated by an action group.
 */
public class PopupDialogAction extends AnAction {

  /**
   * This default constructor is used by the IntelliJ Platform framework to instantiate this class
   * based on plugin.xml declarations. Only needed in {@link PopupDialogAction} class because a
   * second constructor is overridden.
   *
   * @see AnAction#AnAction()
   */
  public PopupDialogAction() {
    super();
  }

  /**
   * This constructor is used to support dynamically added menu actions. It sets the text,
   * description to be displayed for the menu item. Otherwise, the default AnAction constructor is
   * used by the IntelliJ Platform.
   *
   * @param text        The text to be displayed as a menu item.
   * @param description The description of the menu item.
   * @param icon        The icon to be used with the menu item.
   */
  public PopupDialogAction(@Nullable String text, @Nullable String description,
      @Nullable Icon icon) {
    super(text, description, icon);
  }

  /**
   * Gives the user feedback when the dynamic action menu is chosen. Pops a simple message dialog.
   * See the psi_demo plugin for an example of how to use {@link AnActionEvent} to access data.
   *
   * @param event Event received when the associated menu item is chosen.
   */
  @Override
  public void actionPerformed(@NotNull AnActionEvent event) {
    doWork(event);
  }

  private void doWork(AnActionEvent event) {
    Project project = event.getProject();
    Response response = LeetCodeUtil
        .getResponseSync("https://leetcode-cn.com/problems/sparse-array-search-lcci/");
    Data data = response.getData();
    Question question = data.getQuestion();
    List<TopicTagsItem> topicTags = question.getTopicTags();
    TopicTagsItem topicTagsItem = topicTags.get(0);
    List<CodeSnippetsItem> codeSnippets = question.getCodeSnippets();
    Optional<CodeSnippetsItem> first = codeSnippets.stream()
        .filter(codeSnippetsItem -> "Java".equalsIgnoreCase(codeSnippetsItem.getLang()))
        .findFirst();
    CodeSnippetsItem codeSnippetsItem = first.get();
    String translatedTitle = question.getTranslatedTitle();
    String translatedContent = question.getTranslatedContent();
    String translatedName = topicTagsItem.getTranslatedName();
    String code = codeSnippetsItem.getCode();
    String questionId = question.getQuestionId();
    String packageName =
        "package " + translatedName + ".Q" + questionId + "_" + translatedTitle.trim();
    String sourceCode = packageName + ";\n\n/**\n" + translatedContent + "\n**/\n"
        + code;
    String fileName = "Solution.java";
    WriteCommandAction.runWriteCommandAction(project, () -> {
      writeFile(project, fileName, sourceCode);
    });
  }

  private void writeFile(Project project, String fileName, String sourceCode) {
    System.out.println("fileName:" + fileName);
    System.out.println("sourceCode:" + sourceCode);
    PsiDirectory psiDirectory = DirectoryUtil
        .mkdirs(PsiManager.getInstance(project), project.getBasePath());
    PsiFile originalFile = psiDirectory.findFile(fileName);
    PsiFileFactory psiFileFactory = PsiFileFactory.getInstance(project);
    PsiFile psiFile;
    if (originalFile == null) {
      System.out.println("originalFile is  null");
    }
    if (originalFile != null) {
      Document document = PsiDocumentManager.getInstance(project).getDocument(originalFile);
      assert document != null;
      document.replaceString(0, sourceCode.length(), sourceCode);
      psiFile = originalFile;
    } else {
      sourceCode = "test";
      psiFile = psiFileFactory.createFileFromText(fileName, sourceCode);
    }
    Document document = PsiDocumentManager.getInstance(project).getDocument(psiFile);
    if (document != null) {
      PsiDocumentManager.getInstance(project).commitDocument(document);
    } else {
      psiDirectory.add(psiFile);
    }

  }

  /**
   * Determines whether this menu item is available for the current context. Requires a project to
   * be open.
   *
   * @param e Event received when the associated group-id menu is chosen.
   */
  @Override
  public void update(AnActionEvent e) {
    // Set the availability based on whether a project is open
    Project project = e.getProject();
    e.getPresentation().setEnabledAndVisible(project != null);
  }

}
