package com.mango.prjmango.ui.common.limitedtextfield;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * Creates a character limited {@link Document} for a {@link JTextField}
 */
public class LimitedTextField extends PlainDocument {

    private final int limit;

    /**
     * Sets a {@link JTextField}'s character limit.
     *
     * @param limit the length of the limit
     */
    public LimitedTextField(int limit) {
        super();
        this.limit = limit;
    }

    /**
     * Inserts text into the text field.
     *
     * @param offset the starting offset
     * @param str    the text to input
     * @param attr   the {@link AttributeSet}, typically {@code null}
     * @throws BadLocationException the exception to throw
     */
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
