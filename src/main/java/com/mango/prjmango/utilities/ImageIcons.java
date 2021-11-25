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

    private static final String SCHOOL_LOGO = "src/main/java/com/mango/prjmango/utilities/images/PawLogo.png";
    private static final String MANGO_LOGO = "src/main/java/com/mango/prjmango/utilities/images/Mango3.png";
    private static final String CHECK_MARK = "src/main/java/com/mango/prjmango/utilities/images/Check_Mark.png";
    private static final String OK_BUTTON_NO_HOVER = "src/main/java/com/mango/prjmango/utilities/images/Ok_Button_No_Hover.png";
    private static final String OK_BUTTON_HOVER = "src/main/java/com/mango/prjmango/utilities/images/Ok_Button_Hover.png";

    /**
     * <img src="src/main/java/com/mango/prjmango/utilities/images/PawLogo.png" width="50" height="50">
     */
    public static final ImageIcon SCHOOL_LOGO_ICON = new ImageIcon(getScaledImage(SCHOOL_LOGO, 115, 110));

    /**
     * <img src="src/main/java/com/mango/prjmango/utilities/images/Mango3.png" width="50" height="50">
     */
    public static final ImageIcon MANGO_LOGO_ICON = new ImageIcon(getScaledImage(MANGO_LOGO, 50, 50));

    /**
     * <img src="src/main/java/com/mango/prjmango/utilities/images/Check_Mark.png" width="50" height="50">
     */
    public static final ImageIcon CHECK_MARK_ICON = new ImageIcon(getScaledImage(CHECK_MARK, 100, 83));

    /**
     * <img src="src/main/java/com/mango/prjmango/utilities/images/Ok_Button_No_Hover.png".png" width="50" height="50">
     */
    public static final ImageIcon OK_NO_HOVER_ICON = new ImageIcon(getScaledImage(OK_BUTTON_NO_HOVER, 132, 31));

    /**
     * <img src="src/main/java/com/mango/prjmango/utilities/images/Ok_Button_Hover.png" width="50" height="50">
     */
    public static final ImageIcon OK_HOVER_ICON = new ImageIcon(getScaledImage(OK_BUTTON_HOVER, 132, 31));

    private static Image getScaledImage(String path, int width, int height) {
        return new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
