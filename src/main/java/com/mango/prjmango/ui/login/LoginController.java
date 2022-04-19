package com.mango.prjmango.ui.login;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.Main;
import com.mango.prjmango.outlines.MathOutlines;
import com.mango.prjmango.outlines.Outlines;
import com.mango.prjmango.assignment.Assignments;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.common.Images;
import com.mango.prjmango.ui.createaccount.basicinfo.BasicInfoController;
import com.mango.prjmango.ui.createaccount.basicinfo.BasicInfoView;
import com.mango.prjmango.ui.forgotpassword.email.EmailController;
import com.mango.prjmango.ui.forgotpassword.email.EmailView;
import com.mango.prjmango.ui.sideoptions.SideOptionsView;
import com.mango.prjmango.ui.students.StudentsController;
import com.mango.prjmango.ui.students.StudentsView;
import com.mango.prjmango.utilities.dbcommands.UserCommands;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Handles all user interaction with the main Login page.
 */
public class LoginController {

    /**
     * Constructor. Adds the {@link MouseListener}'s to specific {@link JLabel}'s that the user
     * will interact with.
     *
     * @param view the {@link LoginView}
     */
    public LoginController(LoginView view) {
        JLabel loginLabel = view.getLoginLabel();
        JLabel createAccountLabel = view.getCreateAccountLabel();
        JLabel forgotPasswordLabel = view.getForgotPasswordLabel();
        view.getPasswordField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(view);
                }
            }
        });
        view.getEmailField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(view);
                }
            }
        });
        loginLabel.addMouseListener(new LoginLabelMouseListener(view, loginLabel));
        createAccountLabel.addMouseListener(new CreateAccountLabelMouseListener(createAccountLabel));
        forgotPasswordLabel.addMouseListener(new ForgotPasswordLabelMouseListener(forgotPasswordLabel));
    }

    private static void login(LoginView view) {
        String enteredEmail = view.getEmailField().getText();
        char[] enteredPassword = view.getPasswordField().getPassword();

        if (!enteredEmail.equals("") && enteredPassword.length != 0) {
            if (UserCommands.isValidUser(enteredEmail, enteredPassword) == 1) {
                int teacherID = UserCommands.getTeacherId(enteredEmail);

                LoggedInUser user = new LoggedInUser(teacherID);
                Main.setActiveUser(user);
                Main.setStudents(new Students(teacherID));
                Main.setAssignments(new Assignments(teacherID));
                Main.setOutlines(new Outlines(teacherID));
                Main.setMathOutlines(new MathOutlines(teacherID));

                StudentsView studentsView = new StudentsView();
                new StudentsController(studentsView);
                MainWindowView.displayActiveTab(StudentsView.getStudentBackgroundLabel());

                SideOptionsView.updateWelcomeMessage();
            } else {
                view.getInvalidLabel().setText("Invalid email or password. Please try again.");
            }
        } else {
            view.getInvalidLabel().setText("Invalid email or password. Please try again.");
        }
    }

    private static class LoginLabelMouseListener implements MouseListener {

        private final LoginView view;
        private final JLabel label;

        /**
         * Constructor. Instantiate instance variables that will be used within the {@link MouseListener}
         * methods.
         *
         * @param view  the {@link LoginView} to access the specific {@link JComponent}'s
         * @param label the specific {@link JLabel}
         */
        public LoginLabelMouseListener(LoginView view, JLabel label) {
            this.view = view;
            this.label = label;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            login(view);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setIcon(Images.LOGIN_HOVERED.getImageIcon());
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setIcon(Images.LOGIN_NO_HOVER.getImageIcon());
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }

    private static class CreateAccountLabelMouseListener implements MouseListener {

        private final JLabel label;

        /**
         * Constructor. Instantiate instance variables that will be used within the {@link MouseListener}
         * methods.
         *
         * @param label the specific {@link JLabel}
         */
        public CreateAccountLabelMouseListener(JLabel label) {
            this.label = label;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            BasicInfoView basicInfoView = new BasicInfoView();
            new BasicInfoController(basicInfoView);
            MainWindowView.setActiveDisplay(basicInfoView);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setFont(label.getFont().deriveFont(Font.PLAIN));

            Font font = label.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            label.setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            label.setFont(label.getFont().deriveFont(Font.PLAIN));

            Font font = label.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            label.setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }

    private static class ForgotPasswordLabelMouseListener implements MouseListener {

        private final JLabel label;

        /**
         * Constructor. Instantiate instance variables that will be used within the {@link MouseListener}
         * methods.
         *
         * @param label the specific {@link JLabel}
         */
        public ForgotPasswordLabelMouseListener(JLabel label) {
            this.label = label;
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            EmailView emailView = new EmailView();
            new EmailController(emailView);
            MainWindowView.setActiveDisplay(emailView);
        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setFont(label.getFont().deriveFont(Font.PLAIN));

            Font font = label.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, 0);
            label.setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseExited(MouseEvent e) {
            label.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            label.setFont(label.getFont().deriveFont(Font.PLAIN));

            Font font = label.getFont();
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, -1);
            label.setFont(font.deriveFont(attributes));
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mousePressed(MouseEvent e) { /* Not needed */ }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e the {@link MouseEvent}
         */
        @Override
        public void mouseReleased(MouseEvent e) { /* Not needed */ }
    }
}
