package com.mango.prjmango.windows.account.passwordsecurity;

import javax.swing.*;

/**
 * The user interface design of the Password & Security page.
 */
public class PasswordSecurityView extends JPanel {

    JPanel passwordChangePanel;
    JPanel securityQuestionsChangePanel;

    JLabel passwordSecurityHeaderLabel;
    JLabel saveLabel;
    JLabel ConfirmNewPassLabel;
    JLabel CurrentPasswordLabel;
    JLabel NewPasswordLabel;
    JLabel SecurityQuestionTwoLabel;
    JLabel AnswerOneLabel;
    JLabel SecurityQuestionOneLabel;
    JLabel AnswerTwoLabel;


    JTextField ConfirmNewPassTextBox;
    JTextField CurrentPasswordTextBox;
    JTextField NewPasswordTextBox;
    JTextField AnswerTwoTextBox;
    JTextField AnswerOneTextBox;

    JComboBox SecurityQuestionTwoDropDown;
    JComboBox SecurityQuestionOneDropDown;


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
    private void createComponents(){

        passwordChangePanel = new JPanel();
        passwordChangePanel.setBackground(new java.awt.Color(19, 18, 18));
        passwordChangePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", 1, 2, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(216, 216, 216))); // NOI18N
        passwordChangePanel.setForeground(new java.awt.Color(216, 216, 216));

        securityQuestionsChangePanel = new JPanel();
        securityQuestionsChangePanel.setBackground(new java.awt.Color(19, 18, 18));
        securityQuestionsChangePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Security Questions", 1, 2, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(216, 216, 216))); // NOI18N
        securityQuestionsChangePanel.setForeground(new java.awt.Color(216, 216, 216));

        passwordSecurityHeaderLabel = new JLabel();
        passwordSecurityHeaderLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordSecurityHeaderLabel.setForeground(new java.awt.Color(216, 216, 216));
        passwordSecurityHeaderLabel.setText("Password & Security");

        saveLabel = new JLabel();
        saveLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        saveLabel.setForeground(new java.awt.Color(216, 216, 216));
        //saveLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/main/resources/images/account-save-no-hover.png"))); // NOI18N
        saveLabel.setMaximumSize(new java.awt.Dimension(117, 43));
        saveLabel.setMinimumSize(new java.awt.Dimension(117, 43));
        saveLabel.setPreferredSize(new java.awt.Dimension(117, 43));

        ConfirmNewPassLabel = new JLabel();
        ConfirmNewPassLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ConfirmNewPassLabel.setForeground(new java.awt.Color(216, 216, 216));
        ConfirmNewPassLabel.setText("Confirm New Password");

        ConfirmNewPassTextBox = new JTextField();
        ConfirmNewPassTextBox.setBackground(new java.awt.Color(19, 18, 18));
        ConfirmNewPassTextBox.setForeground(new java.awt.Color(216, 216, 216));

        CurrentPasswordTextBox = new JTextField();
        CurrentPasswordTextBox.setBackground(new java.awt.Color(19, 18, 18));
        CurrentPasswordTextBox.setForeground(new java.awt.Color(216, 216, 216));

        CurrentPasswordLabel = new JLabel();
        CurrentPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CurrentPasswordLabel.setForeground(new java.awt.Color(216, 216, 216));
        CurrentPasswordLabel.setText("Current Password");

        NewPasswordLabel = new JLabel();
        NewPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NewPasswordLabel.setForeground(new java.awt.Color(216, 216, 216));
        NewPasswordLabel.setText("New Password");

        NewPasswordTextBox = new JTextField();
        NewPasswordTextBox.setBackground(new java.awt.Color(19, 18, 18));
        NewPasswordTextBox.setForeground(new java.awt.Color(216, 216, 216));

        SecurityQuestionTwoDropDown = new JComboBox();
        SecurityQuestionTwoDropDown.setBackground(new java.awt.Color(19, 18, 18));
        SecurityQuestionTwoDropDown.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SecurityQuestionTwoDropDown.setForeground(new java.awt.Color(216, 216, 216));
        SecurityQuestionTwoDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        AnswerTwoTextBox = new JTextField();
        AnswerTwoTextBox.setBackground(new java.awt.Color(19, 18, 18));
        AnswerTwoTextBox.setForeground(new java.awt.Color(216, 216, 216));

        SecurityQuestionTwoLabel = new JLabel();
        SecurityQuestionTwoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SecurityQuestionTwoLabel.setForeground(new java.awt.Color(216, 216, 216));
        SecurityQuestionTwoLabel.setText("Security Question #2");

        AnswerOneLabel = new JLabel();
        AnswerOneLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AnswerOneLabel.setForeground(new java.awt.Color(216, 216, 216));
        AnswerOneLabel.setText("Answer ");

        AnswerOneTextBox = new JTextField();
        AnswerOneTextBox.setBackground(new java.awt.Color(19, 18, 18));
        AnswerOneTextBox.setForeground(new java.awt.Color(216, 216, 216));

        SecurityQuestionOneDropDown = new JComboBox();
        SecurityQuestionOneDropDown.setBackground(new java.awt.Color(19, 18, 18));
        SecurityQuestionOneDropDown.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SecurityQuestionOneDropDown.setForeground(new java.awt.Color(216, 216, 216));
        SecurityQuestionOneDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SecurityQuestionOneLabel = new JLabel();
        SecurityQuestionOneLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SecurityQuestionOneLabel.setForeground(new java.awt.Color(216, 216, 216));
        SecurityQuestionOneLabel.setText("Security Question #1");

        AnswerTwoLabel = new JLabel();
        AnswerTwoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AnswerTwoLabel.setForeground(new java.awt.Color(216, 216, 216));
        AnswerTwoLabel.setText("Answer");



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
                                        .addComponent(ConfirmNewPassLabel)
                                        .addComponent(ConfirmNewPassTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CurrentPasswordTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CurrentPasswordLabel)
                                        .addComponent(NewPasswordLabel)
                                        .addComponent(NewPasswordTextBox, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        passwordChangePanelLayout.setVerticalGroup(
                passwordChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(passwordChangePanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(CurrentPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CurrentPasswordTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NewPasswordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NewPasswordTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(ConfirmNewPassLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConfirmNewPassTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


    }
    private void createSecurityQuestionsChangePanel(){

        GroupLayout securityQuestionsChangePanelLayout = new GroupLayout(securityQuestionsChangePanel);
        securityQuestionsChangePanel.setLayout(securityQuestionsChangePanelLayout);
        securityQuestionsChangePanelLayout.setHorizontalGroup(
                securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(securityQuestionsChangePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(SecurityQuestionTwoDropDown, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(AnswerTwoTextBox)
                                                        .addComponent(SecurityQuestionTwoLabel)
                                                        .addComponent(AnswerOneLabel)
                                                        .addComponent(AnswerOneTextBox)
                                                        .addComponent(SecurityQuestionOneDropDown, 0, 472, Short.MAX_VALUE))
                                                .addComponent(SecurityQuestionOneLabel)
                                                .addComponent(AnswerTwoLabel)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        securityQuestionsChangePanelLayout.setVerticalGroup(
                securityQuestionsChangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(securityQuestionsChangePanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(SecurityQuestionOneLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SecurityQuestionOneDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnswerOneLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AnswerOneTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SecurityQuestionTwoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SecurityQuestionTwoDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnswerTwoLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AnswerTwoTextBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

}
