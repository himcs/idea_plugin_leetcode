// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.himcs.view;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.jetbrains.annotations.NotNull;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class LeetCodeComponent {

  private final JPanel myMainPanel;
  private final JBTextField myURLText = new JBTextField();

  public LeetCodeComponent() {
    myMainPanel = FormBuilder.createFormBuilder()
        .addLabeledComponent(new JBLabel("URL:"), myURLText, 1, false)
        .addComponentFillVertically(new JPanel(), 0)
        .getPanel();
  }

  public JPanel getPanel() {
    return myMainPanel;
  }

  public JComponent getPreferredFocusedComponent() {
    return myURLText;
  }

  @NotNull
  public String getURLText() {
    return myURLText.getText();
  }

  public void setURLText(@NotNull String newText) {
    myURLText.setText(newText);
  }


}
