package com.mango.prjmango.ui.common.limitedtextfield;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import java.util.regex.Pattern;

/**
 * Handles the user input for {@link JTextField}'s based off a filter type and the character limit.
 */
public class JTextFieldFilter extends DocumentFilter {

    private Pattern regexCheck = null;

    private final Integer limit;

    /**
     * Constructs the filter for the {@link JTextField}
     *
     * @param type  the {@link FilterType}
     * @param limit the character limit
     */
    public JTextFieldFilter(FilterType type, Integer limit) {
        if (limit == null) {
            this.limit = Integer.MAX_VALUE;
        } else {
            this.limit = limit;
        }

        if (type == FilterType.NUMBERS_ONLY) {
            regexCheck = Pattern.compile("^[0-9]*");
        } else if (type == FilterType.CHARACTERS_ONLY) {
            regexCheck = Pattern.compile("^[a-zA-Z]*");
        } else if (type == FilterType.CHARACTERS_AND_NUMBERS) {
            regexCheck = Pattern.compile("^[a-zA-Z0-9]*");
        } else if (type == FilterType.MATH_CHARACTERS_AND_NUMBERS) {
            regexCheck = Pattern.compile("^-?[0-9]*");//-?\d+
        } else if (type == FilterType.MATH_CHARACTERS_AND_NUMBERS_WITH_DECIMAL_AND_MINUS) {
            regexCheck = Pattern.compile("^-?[0-9]*\\.?[0-9]*");//-?\d+\.\d+
        } else if (type == FilterType.MATH_NUMBERS_WITH_MINUS) {
            regexCheck = Pattern.compile("^-?[0-9]*");//-?\d+
        }
    }

    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));

        if (regexCheck.matcher(str).matches() && (sb.length() + str.length()) <= limit) {
            super.insertString(fb, offs, str, a);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
            throws BadLocationException {
        if (str == null) {
            return;
        }

        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));

        if (regexCheck.matcher(str).matches() && (sb.length() + str.length()) <= limit) {
            fb.replace(offset, length, str, attrs);
        }
    }
}
