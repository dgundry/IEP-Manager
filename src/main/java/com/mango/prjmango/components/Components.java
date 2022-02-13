package com.mango.prjmango.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This class acts as utility class which a developer can access methods
 * that create different kinds of {@link JComponent}'s.
 */
public class Components {

    private static final Insets MARGIN = new Insets(0, 5, 0, 5);

    /**
     * Creates a new {@link JLabel}
     *
     * @param text the display text
     * @param font the font
     * @return a new {@link JLabel}
     */
    public static JLabel JLabel(String text, Font font) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        return label;
    }

    /**
     * Creates a new {@link JTextField}
     *
     * @param text the display text
     * @return a new {@link JTextField}
     */
    public static JTextField JTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setBackground(Color.WHITE);
        textField.setMargin(MARGIN);
        return textField;
    }

    /**
     * Creates a new {@link JPasswordField}
     *
     * @param text            the display text
     * @param makeVisibleText if {@code true}, will display the visible to the user. If {@code false}, will display
     *                        '•' for each character typed.
     * @return a new {@link JPasswordField}
     */
    public static JPasswordField JPasswordField(String text, boolean makeVisibleText) {
        JPasswordField passwordField = new JPasswordField(text);
        passwordField.setBackground(Color.WHITE);
        passwordField.setEchoChar(makeVisibleText ? (char) 0 : '•');
        passwordField.setMargin(MARGIN);
        return passwordField;
    }

    /**
     * Creates a new {@link JButton}
     *
     * @param text the display text
     * @return a new {@link JButton}
     */
    public static JButton JButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(245,102,0));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setEnabled(true);
        return button;
    }

    /**
     * Creates a new {@link JButton}
     *
     * @param text      the display text
     * @param fontColor the specified font {@link Color}
     * @return a new {@link JButton}
     */
    public static JButton JButton(String text, Color fontColor) {
        JButton button = new JButton(text);
        button.setForeground(fontColor);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        return button;
    }

    /**
     * Creates a new {@link JButton}
     *
     * @param text            the display text
     * @param fontColor       the specified font {@link Color}
     * @param backgroundColor the specified background {@link Color}
     * @return a new {@link JButton}
     */
    public static JButton JButton(String text, Color fontColor, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setForeground(fontColor);
        button.setBackground(backgroundColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusable(false);
        return button;
    }

    /**
     * Creates a new {@link JComboBox} for the security questions
     *
     * @param securityQuestionList the {@link Vector} of {@link String}'s which contain the security questions
     * @return a new {@link JComboBox} for the security questions
     */
    public static JComboBox<String> JComboBox(List<String> securityQuestionList) {
        JComboBox<String> comboBox = new JComboBox<>(new Vector<>(securityQuestionList));
        comboBox.setSelectedIndex(0);
        comboBox.setBackground(Color.WHITE);
        return comboBox;
    }
}
