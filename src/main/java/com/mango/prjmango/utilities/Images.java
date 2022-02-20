package com.mango.prjmango.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import lombok.Getter;

public enum Images {

    HOME_TAB_NO_HOVER("/images/home-tab-no-hover.png", 243, 44, true),
    HOME_TAB_HOVERED("/images/home-tab-hovered.png", 243, 44, true),

    ACCOUNT_TAB_NO_HOVER("/images/account-tab-no-hover.png", 243, 44, true),
    ACCOUNT_TAB_HOVERED("/images/account-tab-hovered.png", 243, 44, true),

    STUDENT_TAB_NO_HOVER("/images/students-tab-no-hover.png", 243, 44, true),
    STUDENT_TAB_HOVERED("/images/students-tab-hovered.png", 243, 44, true),

    ACTIVITIES_TAB_NO_HOVER("/images/activities-tab-no-hover.png", 243, 44, true),
    ACTIVITIES_TAB_HOVERED("/images/activities-tab-hovered.png", 243, 44, true),

    REPORTS_TAB_NO_HOVER("/images/reports-tab-no-hover.png", 243, 44, true),
    REPORTS_TAB_HOVERED("/images/reports-tab-hovered.png", 243, 44, true),

    LOG_OUT_NO_HOVER("/images/log-out-no-hover.png", 124, 28, true),
    LOG_OUT_HOVERED("/images/log-out-hovered.png", 124, 28, true),

    PAW_LOGO("/images/paw_logo.png", 112, 106, true),

    EDIT_PROFILE_NO_HOVER("/images/edit-profile-no-hover.png", 281, 30, true),
    EDIT_PROFILE_HOVERED("/images/edit-profile-hovered.png", 281, 30, true),
    EDIT_PROFILE_SELECTED("/images/edit-profile-selected.png", 281, 30, true),

    PASSWORD_SECURITY_NO_HOVER("/images/password-security-no-hover.png", 281, 30, true),
    PASSWORD_SECURITY_HOVERED("/images/password-security-hovered.png", 281, 30, true),
    PASSWORD_SECURITY_SELECTED("/images/password-security-selected.png", 281, 30, true);

    @Getter private ImageIcon imageIcon;
    @Getter private BufferedImage bufferedImage;

    Images(String path, int width, int height, boolean isImageIcon) {
        if (isImageIcon)
            this.imageIcon = getImageIcon(path, width, height);
        else
            this.bufferedImage = getBufferedImage(path);
    }

    private URL getResource(String path) {
        return Images.class.getResource(path);
    }

    private ImageIcon getImageIcon(String path, int width, int height) {
        BufferedImage image;
        ImageIcon icon = null;

        try {
            image = ImageIO.read(getResource(path));
            icon = new ImageIcon(getScaledImage(image, width, height));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return icon;
    }

    private BufferedImage getBufferedImage(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

    private static Image getScaledImage(BufferedImage image, int width, int height) {
        return new ImageIcon(image).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
