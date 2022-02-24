package com.mango.prjmango.windows.account.editprofile;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.utilities.Fonts;
import com.mango.prjmango.utilities.Images;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import lombok.Getter;

/**
 * The user interface design of the Edit Profile page.
 */
public class EditProfileView extends JPanel {

    private final Color DARK_GREY = new Color(19, 18, 18);
    private final Color LIGHT_GREY = new Color(216, 216, 216);

    @Getter private JLabel editProfileHeaderLabel;
    @Getter private JLabel firstNameLabel;
    @Getter private JLabel lastNameLabel;
    @Getter private JLabel emailLabel;
    @Getter private JLabel saveLabel;

    @Getter private JTextField firstNameTextField;
    @Getter private JTextField lastNameTextField;
    @Getter private JTextField emailTextField;

    /**
     * Constructor. Calls methods that create the GUI.
     */
    public EditProfileView() {
        setOpaque(false);

        createComponents();
        createLayout();
    }

    private void createComponents() {
        editProfileHeaderLabel = createLabel("Edit Profile", 24);
        firstNameLabel         = createLabel("First Name", 18);
        lastNameLabel          = createLabel("Last Name", 18);
        emailLabel             = createLabel("Email", 18);

        saveLabel = new JLabel(Images.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());

        firstNameTextField = createTextField(LoggedInUser.getFirstName());
        lastNameTextField  = createTextField(LoggedInUser.getLastName());
        emailTextField     = createTextField(LoggedInUser.getEmail());
    }

    private void createLayout() {
        GroupLayout editProfilePanelLayout = new GroupLayout(this);
        setLayout(editProfilePanelLayout);
        editProfilePanelLayout.setHorizontalGroup(
                editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, editProfilePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(editProfilePanelLayout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING,
                                                        false)
                                                .addGroup(editProfilePanelLayout.createSequentialGroup()
                                                        .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(firstNameLabel)
                                                                .addComponent(
                                                                        firstNameTextField,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        209,
                                                                        GroupLayout.PREFERRED_SIZE))
                                                        .addGap(96, 96, 96)
                                                        .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(lastNameLabel)
                                                                .addComponent(
                                                                        lastNameTextField,
                                                                        GroupLayout.PREFERRED_SIZE,
                                                                        209,
                                                                        GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(emailLabel)
                                                .addComponent(emailTextField))
                                        .addComponent(saveLabel)
                                        .addComponent(editProfileHeaderLabel))
                                .addContainerGap(309, Short.MAX_VALUE))
        );
        editProfilePanelLayout.setVerticalGroup(
                editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editProfilePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(editProfileHeaderLabel)
                                .addGap(67, 67, 67)
                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastNameLabel)
                                        .addComponent(firstNameLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(
                                                firstNameTextField,
                                                GroupLayout.PREFERRED_SIZE,
                                                32,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(
                                                lastNameTextField,
                                                GroupLayout.PREFERRED_SIZE,
                                                32,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addComponent(emailLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(
                                        emailTextField,
                                        GroupLayout.PREFERRED_SIZE,
                                        32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveLabel)
                                .addContainerGap(653, Short.MAX_VALUE))
        );
    }

    private JTextField createTextField(String text) {
        JTextField textField = new JTextField(text);
        textField.setMargin(new Insets(0, 5, 0, 5));
        textField.setBackground(DARK_GREY);
        textField.setForeground(LIGHT_GREY);
        textField.setCaretColor(LIGHT_GREY);
        textField.setFont(Fonts.SEGOE_UI_16.getFont());
        return textField;
    }

    private JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, fontSize));
        label.setForeground(LIGHT_GREY);
        return label;
    }
}
