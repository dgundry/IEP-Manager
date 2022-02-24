package com.mango.prjmango.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import lombok.Getter;

public enum Images {

    EDIT_PROFILE_NO_HOVER("/images/edit-profile-no-hover.png", 281, 30, true),
    EDIT_PROFILE_HOVERED("/images/edit-profile-hovered.png", 281, 30, true),
    EDIT_PROFILE_SELECTED("/images/edit-profile-selected.png", 281, 30, true),

    PASSWORD_SECURITY_NO_HOVER("/images/password-security-no-hover.png", 281, 30, true),
    PASSWORD_SECURITY_HOVERED("/images/password-security-hovered.png", 281, 30, true),
    PASSWORD_SECURITY_SELECTED("/images/password-security-selected.png", 281, 30, true),

    EDIT_PROFILE_SAVE_NO_HOVER("/images/account-save-no-hover.png", 117, 47, true),
    EDIT_PROFILE_SAVE_HOVERED("/images/account-save-hovered.png", 117, 47, true),

    LOGIN_NO_HOVER("/images/login-no-hover.png", 116, 31, true),
    LOGIN_HOVERED("/images/login-hovered.png", 116, 31, true),

    CLASSROOM_BACKGROUND("/images/classroom-background.png", 1440, 1024, false),

    APP_EXIT_NO_HOVER("/images/application-exit/exit-no-hover.png", 95, 31, true),
    APP_EXIT_HOVERED("/images/application-exit/exit-hovered.png", 95, 31, true),

    APP_CANCEL_NO_HOVER("/images/application-exit/cancel-no-hover.png", 95, 31, true),
    APP_CANCEL_HOVERED("/images/application-exit/cancel-hovered.png", 95, 31, true);

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
