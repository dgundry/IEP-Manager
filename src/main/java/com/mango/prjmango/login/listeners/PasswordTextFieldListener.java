package com.mango.prjmango.login.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import javax.swing.JPasswordField;

public class PasswordTextFieldListener implements FocusListener {

    private final JPasswordField passwordField;
    private final String originalText;

    private static final String DEFAULT_TEXT = "Password";

    private char[] originalPassword;

    public PasswordTextFieldListener(JPasswordField passwordField, String originalText) {
        this.passwordField = passwordField;
        this.originalText = originalText;
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the focus event
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (Arrays.equals(passwordField.getPassword(), DEFAULT_TEXT.toCharArray())) {
            passwordField.setText("");
        } else {
            passwordField.setText(String.valueOf(originalPassword));
        }

        passwordField.setEchoChar('•');
    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the focus event
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (passwordField.getPassword().length == 0) {
            passwordField.setText(DEFAULT_TEXT);
            passwordField.setEchoChar((char) 0);
        } else {
            originalPassword = passwordField.getPassword();
            passwordField.setText(String.valueOf(originalPassword));
        }
    }
}
