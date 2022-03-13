package com.mango.prjmango.ui.common;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import lombok.Getter;

public enum Images {

    LOGIN_NO_HOVER("/images/login/login-no-hover.png", 116, 31, true),
    LOGIN_HOVERED("/images/login/login-hovered.png", 116, 31, true),

    CLASSROOM_BACKGROUND("/images/common/classroom.jpg", 1440, 1024, false);

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
