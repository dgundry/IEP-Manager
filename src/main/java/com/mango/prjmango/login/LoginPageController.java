package com.mango.prjmango.login;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.MainFrame;
import com.mango.prjmango.components.listeners.ButtonMouseListener;
import com.mango.prjmango.forgotpassword.email.EmailController;
import com.mango.prjmango.forgotpassword.email.EmailView;
import com.mango.prjmango.login.listeners.EmailTextFieldListener;
import com.mango.prjmango.login.listeners.PasswordTextFieldListener;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.utilities.DatabaseCommands;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class handles all user interactions with the login page.
 */
public class LoginPageController {

    /**
     * Constructor. Initializes the listeners for specific {@link JComponent}'s that need them.
     *
     * @param loginPageView the {@link LoginPageView} to access {@link JComponent}'s
     */
    public LoginPageController(LoginPageView loginPageView) {
        JTextField emailTextField = loginPageView.getEmailText();
        JPasswordField passwordField = loginPageView.getPasswordText();

        emailTextField.addFocusListener(new EmailTextFieldListener(emailTextField, "Email"));
        passwordField.addFocusListener(new PasswordTextFieldListener(passwordField, "Password"));

        loginPageView.getLoginButton().addActionListener(new LoginButtonActionListener(loginPageView));
        loginPageView.getLoginButton().addMouseListener(new ButtonMouseListener(loginPageView.getLoginButton()));

        loginPageView.getForgotPasswordButton().addActionListener(new ForgotPasswordActionListener());
        loginPageView.getForgotPasswordButton().addMouseListener(new ButtonMouseListener(
                loginPageView.getForgotPasswordButton()));

        loginPageView.getCreateAccountButton().addActionListener(new CreateAccountButtonActionListener());
        loginPageView.getCreateAccountButton().addMouseListener(new ButtonMouseListener(
                loginPageView.getCreateAccountButton()));

    }

    private static class LoginButtonActionListener implements ActionListener {

        private final LoginPageView view;

        /**
         * Constructor. Initializes instance variables that will be used in the {@link ActionListener}
         * methods.
         *
         * @param view the {@link LoginPageView} to access {@link JComponent}'s
         */
        public LoginButtonActionListener(LoginPageView view) {
            this.view = view;
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String enteredEmail = view.getEmailText().getText();
            char[] enteredPassword = view.getPasswordText().getPassword();

            if (!enteredEmail.equals("") && enteredPassword.length != 0) {

                if (DatabaseCommands.isValidUser(enteredEmail, enteredPassword) == 1) {
                    System.out.println("Logged in");

                    int teacherID = DatabaseCommands.getTeacherId(enteredEmail);
                    LoggedInUser user = new LoggedInUser(teacherID);
                    Main.activeUser = user;
                    Main.students = new Students(teacherID);

//                    EditAccountView edit = new EditAccountView();
//                    new EditAccountController(edit);
//                    MainFrame.setTeacherView(edit);
//                    TeacherView teacherView = new TeacherView();
//                    new TeacherController(teacherView);


                } else {
                    // create custom error messages

                    JOptionPane.showMessageDialog(
                            MainFrame.getFrame(),
                            "Enter a Valid Password.",
                            "INVALID",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // create custom error messages

                JOptionPane.showMessageDialog(
                        MainFrame.getFrame(),
                        "Enter a Valid Email and/or Password.",
                        "INVALID",
                        JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private static class ForgotPasswordActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            EmailView emailView = new EmailView();
            new EmailController(emailView);
            MainFrame.setActivePanel(emailView);
        }
    }

    private static class CreateAccountButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the {@link ActionEvent}
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
