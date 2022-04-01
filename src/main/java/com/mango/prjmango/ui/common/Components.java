package com.mango.prjmango.ui.common;

import com.mango.prjmango.ui.common.limitedtextfield.LimitedTextField;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedComboBox;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedPasswordField;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedTextArea;
import com.mango.prjmango.ui.common.roundedcomponents.RoundedTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;

/**
 * Utility class which allows for easy access to create new UI components while keeping a consistent look.
 */
public class Components {

    private Components() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates a new {@link JLabel}
     *
     * @param text            the text to display
     * @param font            the desired {@link Font}
     * @param foregroundColor the desired font {@link Color}
     * @return a new {@link JLabel}
     */
    public static JLabel JLabel(String text, Font font, Color foregroundColor) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foregroundColor);
        return label;
    }

    /**
     * Creates a new {@link JLabel}
     *
     * @param text            the text to display
     * @param font            the desired {@link Font}
     * @param foregroundColor the desired font {@link Color}
     * @param alignment       the font alignment
     * @return a new {@link JLabel}
     */
    public static JLabel JLabel(String text, Font font, Color foregroundColor, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(foregroundColor);
        label.setHorizontalAlignment(alignment);
        return label;
    }

    public static JTextField JTextField(String text, Font font, Color foregroundColor) {
        JTextField textField = new JTextField();
        textField.setOpaque(false);
        textField.setFont(font);
        textField.setForeground(foregroundColor);
        textField.setMargin(new Insets(0, 5, 0, 5));
        textField.setBorder(BorderFactory.createTitledBorder(
                null,
                text,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY));
        textField.setCaretColor(Colors.LIGHT_GREY);
        return textField;
    }

    /**
     * Creates a new rounded {@link JTextField}
     *
     * @param text the text to be within the {@link JTextField}
     * @return a new {@link JTextField}
     */
    public static JTextField JTextField(String text) {
        JTextField textField = new RoundedTextField(text);
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        textField.setBackground(Colors.DARK_GREY);
        textField.setForeground(Colors.LIGHT_GREY);
        textField.setCaretColor(Colors.LIGHT_GREY);
        textField.setMargin(new Insets(0, 5, 0, 5));
        return textField;
    }

    public static JTextField LimitedJTextField(String text, int limit) throws BadLocationException {
        JTextField textField = new RoundedTextField();
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        textField.setDocument(new LimitedTextField(limit));
        textField.getDocument().insertString(0, text, null);
        textField.setBackground(Colors.DARK_GREY);
        textField.setForeground(Colors.LIGHT_GREY);
        textField.setCaretColor(Colors.LIGHT_GREY);
        textField.setMargin(new Insets(0, 5, 0, 5));
        return textField;
    }

    /**
     * Creates a new rounded {@link JTextArea}
     *
     * @param text the text to be within the {@link JTextArea}
     * @return a new {@link JTextArea}
     */
    public static JTextArea JTextArea(String text) {
        JTextArea textArea = new RoundedTextArea(text);
        textArea.setMargin(new Insets(5, 5, 5, 5));
        textArea.setBackground(Colors.DARK_GREY);
        textArea.setForeground(Colors.LIGHT_GREY);
        textArea.setCaretColor(Colors.LIGHT_GREY);
        textArea.setFont(Fonts.SEGOE_UI_16.getFont());
        return textArea;
    }

    public static JPasswordField JPasswordField(String headerText) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setOpaque(false);
        passwordField.setFont(Fonts.SEGOE_UI_16.getFont());
        passwordField.setForeground(Colors.LIGHT_GREY);
        passwordField.setMargin(new Insets(0, 5, 0, 5));
        passwordField.setBorder(BorderFactory.createTitledBorder(
                null,
                headerText,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY));
        passwordField.setCaretColor(Colors.LIGHT_GREY);
        return passwordField;
    }

    /**
     * Creates a new rounded {@link JPasswordField}
     *
     * @return a new {@link JPasswordField}
     */
    public static JPasswordField JPasswordField() {
        JPasswordField passwordField = new RoundedPasswordField();
        passwordField.setBackground(Colors.DARK_GREY);
        passwordField.setForeground(Colors.LIGHT_GREY);
        passwordField.setCaretColor(Colors.LIGHT_GREY);
        passwordField.setFont(Fonts.SEGOE_UI_16.getFont());
        passwordField.setMargin(new Insets(5, 5, 5, 5));
        return passwordField;
    }

    /**
     * Creates a new {@link JSeparator}
     *
     * @param orientation sets the orientation
     *        0 = VERTICAL
     *        1 = HORIZONTAL
     * @return a new {@link JSeparator}
     */
    public static JSeparator JSeparator(int orientation) {
        JSeparator separator = new JSeparator();
        separator.setOrientation(orientation);
        separator.setForeground(Colors.LIGHT_GREY);
        return separator;
    }

    public static JComboBox<String> JComboBox(String headerText, List<String> list) {
        JComboBox<String> comboBox = new JComboBox<>(new Vector<>(list));
        comboBox.setOpaque(false);
        comboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        comboBox.setBackground(Colors.DARK_GREY);
        comboBox.setForeground(Colors.LIGHT_GREY);
        comboBox.setBorder(BorderFactory.createTitledBorder(
                null,
                headerText,
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION,
                Fonts.SEGOE_UI_14.getFont(),
                Colors.LIGHT_GREY));
        comboBox.setPreferredSize(new Dimension(56, 20));
        return comboBox;
    }

    public static JComboBox<String> JComboBox(List<String> list) {
        JComboBox<String> comboBox = new RoundedComboBox<>(list);
        comboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        comboBox.setBackground(Colors.DARK_GREY);
        comboBox.setForeground(Colors.LIGHT_GREY);
        return comboBox;
    }

    public static JComboBox<Object> JComboBox() {
        JComboBox<Object> comboBox = new RoundedComboBox<>();
        comboBox.setFont(Fonts.SEGOE_UI_16.getFont());
        comboBox.setBackground(Colors.DARK_GREY);
        comboBox.setForeground(Colors.LIGHT_GREY);
        return comboBox;
    }
}
