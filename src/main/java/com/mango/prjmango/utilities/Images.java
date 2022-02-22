package com.mango.prjmango.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {

    public static ImageIcon getSchoolLogoIcon() {
        BufferedImage logo;
        ImageIcon logoIcon = null;

        try {
            logo = ImageIO.read(Images.class.getResource("/images/PawLogo.png"));
            logoIcon = new ImageIcon(getScaledImage(logo, 115, 110));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return logoIcon;
    }

    public static ImageIcon getMangoLocoIcon() {
        BufferedImage mangoImage;
        ImageIcon mangoImageIcon = null;

        try {
            mangoImage = ImageIO.read(Images.class.getResource("/images/Mango3.png"));
            mangoImageIcon = new ImageIcon(getScaledImage(mangoImage, 50, 50));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mangoImageIcon;
    }

    public static BufferedImage getOptionsTeacherPanelImage() {
        BufferedImage optionsTeacherPanel = null;

        try {
            optionsTeacherPanel = ImageIO.read(Images.class.getResource("/images/OptionsTeacherPanel.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return optionsTeacherPanel;
    }

    public static BufferedImage getGradientPanelImage() {
        BufferedImage gradientPanel = null;

        try {
            gradientPanel = ImageIO.read(Images.class.getResource("/images/GradientPanel.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gradientPanel;
    }

    public static BufferedImage getGreyImage() {
        BufferedImage grey = null;

        try {
            grey = ImageIO.read(Images.class.getResource("/images/grey.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return grey;
    }

    public static BufferedImage getBlackImage() {
        BufferedImage black = null;

        try {
            black = ImageIO.read(Images.class.getResource("/images/black.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return black;
    }

    public static BufferedImage getOrangeImage() {
        BufferedImage orange = null;

        try {
            orange = ImageIO.read(Images.class.getResource("/images/orange.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orange;
    }

    public static BufferedImage getBackgroundImage() {
        BufferedImage backgroundImage = null;

        try {
            backgroundImage = ImageIO.read(Images.class.getResource("/images/City-of-Lawrenceburg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return backgroundImage;
    }

    public static BufferedImage getBackgroundTeacherImage() {
        BufferedImage backgroundTeacherImage = null;

        try {
            backgroundTeacherImage = ImageIO.read(Images.class.getResource("/images/BackgroundTeacherImage.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return backgroundTeacherImage;
    }

    private static Image getScaledImage(BufferedImage image, int width, int height) {
        return new ImageIcon(image).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
