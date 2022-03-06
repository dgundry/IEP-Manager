package com.mango.prjmango.windows.account.passwordsecurity;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.DatabaseCommands;
import com.mango.prjmango.windows.common.Fonts;
import com.mango.prjmango.windows.common.ImageIcons;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import lombok.Getter;

/**
 * The user interface design of the Password & Security page.
 */
public class PasswordSecurityView extends JPanel {

    private JPanel passwordChangePanel;
    private JPanel securityQuestionsChangePanel;

    @Getter private JLabel saveLabel;

    private JLabel passwordSecurityHeaderLabel;
    private JLabel confirmNewPassLabel;
    private JLabel currentPasswordLabel;
    private JLabel newPasswordLabel;
    private JLabel securityQuestionTwoLabel;
    private JLabel answerOneLabel;
    private JLabel securityQuestionOneLabel;
    private JLabel answerTwoLabel;

    private JPasswordField confirmNewPassTextBox;
    private JPasswordField currentPasswordTextBox;
    private JPasswordField newPasswordTextBox;

    @Getter private JTextField answerOneTextBox;
    @Getter private JTextField answerTwoTextBox;

    @Getter private JComboBox<String> securityQuestionOneDropDown;
    @Getter private JComboBox<String> securityQuestionTwoDropDown;

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public PasswordSecurityView() {
        setOpaque(false);
        createComponents();
        createPasswordPanelLayout();
        createSecurityQuestionsChangePanel();
        createLayout();
    }

    private void createComponents() {
        passwordChangePanel          = createPanel("Password");
        securityQuestionsChangePanel = createPanel("Security Questions");

        saveLabel = new JLabel(ImageIcons.PASSWORD_SECURITY_SAVE_NO_HOVER.getImageIcon());

        passwordSecurityHeaderLabel = createLabel("Password & Security",  Fonts.SEGOE_UI_24.getFont());
        confirmNewPassLabel         = createLabel("Confirm New Password", Fonts.SEGOE_UI_18.getFont());
        currentPasswordLabel        = createLabel("Current Password",     Fonts.SEGOE_UI_18.getFont());
        newPasswordLabel            = createLabel("New Password",         Fonts.SEGOE_UI_18.getFont());
        securityQuestionTwoLabel    = createLabel("Security Question #2", Fonts.SEGOE_UI_18.getFont());
        securityQuestionOneLabel    = createLabel("Security Question #1", Fonts.SEGOE_UI_18.getFont());
        answerOneLabel              = createLabel("Answer",               Fonts.SEGOE_UI_18.getFont());
        answerTwoLabel              = createLabel("Answer",               Fonts.SEGOE_UI_18.getFont());

        currentPasswordTextBox = createPasswordField(String.valueOf(LoggedInUser.getPassword()));

        confirmNewPassTextBox  = createPasswordField("");
        newPasswordTextBox     = createPasswordField("");

        answerTwoTextBox       = createTextField();
        answerOneTextBox       = createTextField();

        securityQuestionOneDropDown = createComboBox();
        securityQuestionTwoDropDown = createComboBox();

        populateSecurityQuestions();
    }

    private void createLayout() {
        GroupLayout passwordSecurityPanelLayout = new GroupLayout(this);
        setLayout(passwordSecurityPanelLayout);
        passwordSecurityPanelLayout.setHorizontalGroup(
                passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(passwordSecurityHeaderLabel)
                                                .addComponent(passwordChangePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(securityQuestionsChangePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        passwordSecurityPanelLayout.setVerticalGroup(
                passwordSecurityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordSecurityPanelLayout.createSequentialGroup()
                                .addComponent(passwordSecurityHeaderLabel)
                                .addGap(18, 18, 18)
                                .addComponent(passwordChangePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(securityQuestionsChangePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 202, Short.MAX_VALUE))
        );
    }

    private void createPasswordPanelLayout() {
        GroupLayout passwordChangePanelLayout = new GroupLayout(passwordChangePanel);
        passwordChangePanel.setLayout(passwordChangePanelLayout);
        passwordChangePanelLayout.setHorizontalGroup(
                passwordChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordChangePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(passwordChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(confirmNewPassLabel)
                                        .addComponent(confirmNewPassTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(currentPasswordTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(currentPasswordLabel)
                                        .addComponent(newPasswordLabel)
                                        .addComponent(newPasswordTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        passwordChangePanelLayout.setVerticalGroup(
                passwordChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordChangePanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(currentPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentPasswordTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newPasswordTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(confirmNewPassLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmNewPassTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void createSecurityQuestionsChangePanel() {
        GroupLayout securityQuestionsChangePanelLayout = new GroupLayout(securityQuestionsChangePanel);
        securityQuestionsChangePanel.setLayout(securityQuestionsChangePanelLayout);
        securityQuestionsChangePanelLayout.setHorizontalGroup(
                securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(securityQuestionsChangePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(securityQuestionTwoDropDown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(answerTwoTextBox)
                                                        .addComponent(securityQuestionTwoLabel)
                                                        .addComponent(answerOneLabel)
                                                        .addComponent(answerOneTextBox)
                                                        .addComponent(securityQuestionOneDropDown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(securityQuestionOneLabel)
                                                .addComponent(answerTwoLabel)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        securityQuestionsChangePanelLayout.setVerticalGroup(
                securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(securityQuestionsChangePanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(securityQuestionOneLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(securityQuestionOneDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerOneLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(answerOneTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(securityQuestionTwoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(securityQuestionTwoDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerTwoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answerTwoTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(LIGHT_GREY);
        return label;
    }

    private JPanel createPanel(String text) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createTitledBorder(null, text, 1, 2, Fonts.SEGOE_UI_18.getFont(), LIGHT_GREY));
        panel.setForeground(LIGHT_GREY);
        return panel;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        textField.setBackground(DARK_GREY);
        textField.setForeground(LIGHT_GREY);
        textField.setCaretColor(LIGHT_GREY);
        textField.setMargin(new Insets(0, 5, 0, 5));
        return textField;
    }

    private JPasswordField createPasswordField(String text) {
        JPasswordField passwordField = new JPasswordField(text);
        passwordField.setBackground(DARK_GREY);
        passwordField.setForeground(LIGHT_GREY);
        passwordField.setCaretColor(LIGHT_GREY);
        passwordField.setFont(Fonts.SEGOE_UI_16.getFont());
        passwordField.setMargin(new Insets(0, 5, 0, 5));
        return passwordField;
    }

    private JComboBox<String> createComboBox() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBackground(DARK_GREY);
        comboBox.setFont(Fonts.SEGOE_UI_18.getFont());
        comboBox.setForeground(LIGHT_GREY);
        return comboBox;
    }

    private void populateSecurityQuestions() {
        List<String> securityQuestionList1 = DatabaseCommands.getDropDownQuestions();
        List<String> securityQuestionList2 = DatabaseCommands.getDropDownQuestions();

        List<Integer> securityQuestionIndexes = DatabaseCommands.getUserSecurityQuestionIndexes(LoggedInUser.getTeacherId());
        LoggedInUser.setSecurityQuestion1Index(securityQuestionIndexes.get(0));
        LoggedInUser.setSecurityQuestion2Index(securityQuestionIndexes.get(1));

        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>(new Vector<>(securityQuestionList1));
        DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>(new Vector<>(securityQuestionList2));

        String question1 = DatabaseCommands.getUserSecurityQuestion(LoggedInUser.getSecurityQuestion1Index());
        String question2 = DatabaseCommands.getUserSecurityQuestion(LoggedInUser.getSecurityQuestion2Index());
        model1.setSelectedItem(question1);
        model2.setSelectedItem(question2);

        securityQuestionOneDropDown.setModel(model1);
        securityQuestionTwoDropDown.setModel(model2);
    }
}
