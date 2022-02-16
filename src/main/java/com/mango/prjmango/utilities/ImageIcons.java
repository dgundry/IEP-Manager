package com.mango.prjmango.utilities;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class helps reduce the duplicated code throughout the application.
 * When {@link JLabel}'s are showing an image, you can create just grab the image from
 * this class. This helps if the same is shown on multiple pages.
 *
 * @author  Kellen Campbell
 * @version 1.0
 * @since   2021-11-25
 */
public class ImageIcons {

    private static final String CHECK_MARK = "src/main/java/com/mango/prjmango/utilities/images/Check_Mark.png";
    private static final String OK_BUTTON_NO_HOVER = "src/main/java/com/mango/prjmango/utilities/images/Ok_Button_No_Hover.png";
    private static final String OK_BUTTON_HOVER = "src/main/java/com/mango/prjmango/utilities/images/Ok_Button_Hover.png";
    public static final ImageIcon CHECK_MARK_ICON = new ImageIcon(getScaledImage(CHECK_MARK, 100, 83));

    public static final ImageIcon OK_NO_HOVER_ICON = new ImageIcon(getScaledImage(OK_BUTTON_NO_HOVER, 132, 31));

    public static final ImageIcon OK_HOVER_ICON = new ImageIcon(getScaledImage(OK_BUTTON_HOVER, 132, 31));

    private static Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
