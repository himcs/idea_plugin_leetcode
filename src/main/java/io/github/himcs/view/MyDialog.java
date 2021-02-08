package io.github.himcs.view;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import javax.swing.JComponent;
import org.jetbrains.annotations.Nullable;

/**
 * @author mcs [lik0x01@sp.noahgroup.com]
 */
public class MyDialog extends DialogWrapper {

  LeetCodeComponent leetCodeComponent;
  Project project;
  public MyDialog(
      @Nullable Project project) {
    super(project, true);
    this.project = project;
    leetCodeComponent = new LeetCodeComponent();
    init();
    setTitle("LeetCode");
  }

  @Override
  protected @Nullable JComponent createCenterPanel() {
    return leetCodeComponent.getPanel();
  }

  @Override
  protected void doOKAction() {
    String urlText = leetCodeComponent.getURLText();
    Messages.showMessageDialog(project, urlText, "URL", Messages.getInformationIcon());
    super.doOKAction();
  }
}
