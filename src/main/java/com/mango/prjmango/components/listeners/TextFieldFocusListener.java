package com.mango.prjmango.components.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * This class handles user interaction with a specified {@link JTextField}
 */
public class TextFieldFocusListener implements FocusListener {

    private final JTextField textField;
    private final String ORIGINAL_TEXT;

    /**
     * Constructor. Initializes instance variables that will be used in the {@link FocusListener}
     * methods.
     *
     * @param textField    the specified {@link JTextField}
     * @param originalText the original text of the {@link JTextField}
     */
    public TextFieldFocusListener(JTextField textField, String originalText) {
        this.textField = textField;
        this.ORIGINAL_TEXT = originalText;
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e the {@link FocusEvent}
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals(ORIGINAL_TEXT)) {
            textField.setText("");
        }
    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e the {@link FocusEvent}
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().trim().isEmpty()) {
            textField.setText(ORIGINAL_TEXT);
        }
    }
}
