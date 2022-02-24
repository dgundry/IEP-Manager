package com.mango.prjmango.utilities;

import com.mango.prjmango.Main;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import lombok.Getter;

public enum ImageIcons {

    PAW_LOGO("/images/common/paw_logo.png", 112, 106),
    MANGO_LOGO("/images/common/mango_logo.png", 46, 37),

    HOME_TAB_NO_HOVER("/images/tabs/home-tab-no-hover.png", 243, 44),
    HOME_TAB_HOVERED("/images/tabs/home-tab-hovered.png", 243, 44),

    ACCOUNT_TAB_NO_HOVER("/images/tabs/account-tab-no-hover.png", 243, 44),
    ACCOUNT_TAB_HOVERED("/images/tabs/account-tab-hovered.png", 243, 44),

    STUDENT_TAB_NO_HOVER("/images/tabs/students-tab-no-hover.png", 243, 44),
    STUDENT_TAB_HOVERED("/images/tabs/students-tab-hovered.png", 243, 44),

    ACTIVITIES_TAB_NO_HOVER("/images/tabs/activities-tab-no-hover.png", 243, 44),
    ACTIVITIES_TAB_HOVERED("/images/tabs/activities-tab-hovered.png", 243, 44),

    REPORTS_TAB_NO_HOVER("/images/tabs/reports-tab-no-hover.png", 243, 44),
    REPORTS_TAB_HOVERED("/images/tabs/reports-tab-hovered.png", 243, 44),

    LOG_OUT_NO_HOVER("/images/log-out-no-hover.png", 124, 28),
    LOG_OUT_HOVERED("/images/log-out-hovered.png", 124, 28),

    LOGIN_PANEL_BACKGROUND("/images/login-panel-background.png", 482, 646),
    ACTIVE_TAB_BACKGROUND("/images/common/active-tab-background.png", Main.rect.width, Main.rect.height),

    NEXT_NO_HOVER("/images/common/next-no-hover.png", 116, 31),
    NEXT_HOVERED("/images/common/next-hovered.png", 116, 31),

    BACK_NO_HOVER("/images/common/back-no-hover.png", 116, 31),
    BACK_HOVERED("/images/common/back-hovered.png", 116, 31);

    @Getter
    private ImageIcon imageIcon;

    ImageIcons(String path, int width, int height) {
        this.imageIcon = getImageIcon(path, width, height);
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

    private static Image getScaledImage(BufferedImage image, int width, int height) {
        return new ImageIcon(image).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
