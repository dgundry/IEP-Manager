package com.mango.prjmango.ui.account.editprofile;

import com.mango.prjmango.LoggedInUser;
import com.mango.prjmango.ui.common.Colors;
import com.mango.prjmango.ui.common.Components;
import com.mango.prjmango.ui.common.Fonts;
import com.mango.prjmango.ui.common.ImageIcons;
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

    private JLabel editProfileHeaderLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;

    @Getter private JLabel saveLabel;
    @Getter private JLabel firstNameEditLabel;
    @Getter private JLabel lastNameEditLabel;
    @Getter private JLabel emailEditLabel;
    @Getter private JLabel informationLabel;

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
        editProfileHeaderLabel = Components.JLabel("Edit Profile", Fonts.SEGOE_UI_24.getFont(), Colors.LIGHT_GREY);
        firstNameLabel         = Components.JLabel("First Name",   Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        lastNameLabel          = Components.JLabel("Last Name",    Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        emailLabel             = Components.JLabel("Email",        Fonts.SEGOE_UI_18.getFont(), Colors.LIGHT_GREY);
        informationLabel       = Components.JLabel("",             Fonts.SEGOE_UI_14.getFont(), Colors.LIGHT_GREY);

        saveLabel          = new JLabel(ImageIcons.EDIT_PROFILE_SAVE_NO_HOVER.getImageIcon());
        firstNameEditLabel = new JLabel(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
        lastNameEditLabel  = new JLabel(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
        emailEditLabel     = new JLabel(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());

        try {
            firstNameTextField = Components.LimitedJTextField(LoggedInUser.getFirstName(),12);
            firstNameTextField.setEnabled(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        lastNameTextField = Components.JTextField(LoggedInUser.getLastName());
        lastNameTextField.setEnabled(false);

        emailTextField = Components.JTextField(LoggedInUser.getEmail());
        emailTextField.setEnabled(false);
    }

    private void createLayout() {
        GroupLayout editProfilePanelLayout = new GroupLayout(this);
        setLayout(editProfilePanelLayout);
        editProfilePanelLayout.setHorizontalGroup(
                editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, editProfilePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(editProfileHeaderLabel)
                                        .addGroup(editProfilePanelLayout.createSequentialGroup()
                                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(editProfilePanelLayout.createSequentialGroup()
                                                                .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(informationLabel))
                                                        .addGroup(GroupLayout.Alignment.LEADING, editProfilePanelLayout.createSequentialGroup()
                                                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(firstNameLabel)
                                                                        .addGroup(editProfilePanelLayout.createSequentialGroup()
                                                                                .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(firstNameEditLabel)))
                                                                .addGap(52, 52, 52)
                                                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lastNameLabel)
                                                                        .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(emailLabel, GroupLayout.Alignment.LEADING)
                                                        .addComponent(emailTextField, GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lastNameEditLabel)
                                                        .addComponent(emailEditLabel))))
                                .addContainerGap(26, Short.MAX_VALUE))
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
                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(firstNameEditLabel))
                                        .addComponent(lastNameEditLabel))
                                .addGap(9, 9, 9)
                                .addComponent(emailLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailEditLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(editProfilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(informationLabel))
                                .addContainerGap(653, Short.MAX_VALUE))
        );
    }
}
