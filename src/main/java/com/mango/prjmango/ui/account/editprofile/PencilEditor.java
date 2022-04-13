package com.mango.prjmango.ui.account.editprofile;

import com.mango.prjmango.ui.common.ImageIcons;
import lombok.Getter;
import lombok.Setter;
import javax.swing.JLabel;

/**
 * A {@link JLabel} with the pencil icon.
 */
public class PencilEditor extends JLabel {

    @Getter @Setter private boolean inEditMode = false;

    /**
     * Constructs a new {@link JLabel} with a pencil icon.
     */
    public PencilEditor() {
        super();
        setIcon(ImageIcons.EDIT_PROFILE_EDIT_ICON_NO_HOVER.getImageIcon());
    }
}
