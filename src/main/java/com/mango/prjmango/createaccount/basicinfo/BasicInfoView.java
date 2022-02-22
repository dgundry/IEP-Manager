package com.mango.prjmango.createaccount.basicinfo;

import com.mango.prjmango.Main;
import com.mango.prjmango.components.Components;
import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.components.common.login.LoginPageComponents;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lombok.Getter;

/**
 * This class creates the Basic Info page for the Create Account section.
 */
public class BasicInfoView extends RoundedPanel {

    @Getter private JButton nextButton;
    @Getter private JButton backButton;

    @Getter private JTextField firstNameText;
    @Getter private JTextField lastNameText;
    @Getter private JTextField emailText;

    /**
     * The constructor which sets up the GUI for the create account page.
     */
    public BasicInfoView() {
        setLayout(null);
        setBounds(
                (int) (Main.SCREEN_WIDTH * 0.5) - ((int) (Main.SCREEN_WIDTH * 0.16)),
                (int) (Main.SCREEN_HEIGHT * 0.125),
                (int) (Main.SCREEN_WIDTH * 0.3),
                (int) (Main.SCREEN_HEIGHT * 0.70));

        createComponents();
    }

    private void createComponents() {
        LoginPageComponents.setCommonComponents(this);

        JLabel createAccountHeader = Components.JLabel("Create Account", FontType.FONT_20_BOLD);
        createAccountHeader.setBounds(0, (int) (getHeight() * 0.38), getWidth(),30);

        JLabel enterFirstNameHeader = Components.JLabel("Enter First Name", FontType.FONT_12_BOLD);
        enterFirstNameHeader.setBounds(0,( int) (getHeight() * 0.48), getWidth(),15);

        JLabel enterLastNameHeader = Components.JLabel("Enter Last Name", FontType.FONT_12_BOLD);
        enterLastNameHeader.setBounds(0, (int) (getHeight() * 0.58), getWidth(),15);

        JLabel emailHeader = Components.JLabel("Enter Email", FontType.FONT_12_BOLD);
        emailHeader.setBounds(0, (int) (getHeight() * 0.68), getWidth(),15);

        firstNameText = Components.JTextField("First name");
        firstNameText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.51),
                (int) (getWidth() * 0.5),
                30);

        lastNameText = Components.JTextField("Last name");
        lastNameText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.61),
                (int) (getWidth() * 0.5),
                30);

        emailText = Components.JTextField("Email");
        emailText.setBounds(
                (int) (getWidth() * 0.5) - (int) (getWidth() * 0.25),
                (int) (getHeight() * 0.71),
                (int) (getWidth() * 0.5),
                30);

        nextButton = Components.JButton("Next");
        nextButton.setBounds(
                (int) (getWidth() * 0.65) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.20),
                30);

        backButton = Components.JButton("Back");
        backButton.setBounds(
                (int) (getWidth() * 0.35) - (int) (getWidth() * 0.10),
                (int) (getHeight() * 0.77),
                (int) (getWidth() * 0.20),
                30);

        add(createAccountHeader);
        add(enterFirstNameHeader);
        add(emailHeader);
        add(enterLastNameHeader);
        add(firstNameText);
        add(lastNameText);
        add(emailText);
        add(nextButton);
        add(backButton);
    }
}
