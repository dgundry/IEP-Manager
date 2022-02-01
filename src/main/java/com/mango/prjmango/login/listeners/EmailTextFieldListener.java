package com.mango.prjmango.login.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class EmailTextFieldListener implements FocusListener {

    private final JTextField TEXT_FIELD;

    private static final String DEFAULT_TEXT = "Email";

    private String originalText;

    public EmailTextFieldListener(JTextField textField, String originalText) {
        this.TEXT_FIELD = textField;
        this.originalText = originalText;
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the focus event
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (TEXT_FIELD.getText().equals(DEFAULT_TEXT)) {
            TEXT_FIELD.setText("");
        } else {
            TEXT_FIELD.setText(originalText);
        }
    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the focus event
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (TEXT_FIELD.getText().isEmpty()) {
            TEXT_FIELD.setText(DEFAULT_TEXT);
        } else {
            originalText = TEXT_FIELD.getText();
            TEXT_FIELD.setText(originalText);
        }
    }
}
