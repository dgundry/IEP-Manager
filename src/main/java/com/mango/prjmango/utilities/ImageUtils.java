package com.mango.prjmango.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Handles conversion from {@link BufferedImage} to {@link ImageIcon}
 */
public class ImageUtils {

    private ImageUtils() {
        throw new IllegalStateException("Utility class.");
    }

    /**
     * Returns an {@link ImageIcon} that is scaled smooth to the desired width & height.
     *
     * @param c      the class calling this method
     * @param path   the path to the image
     * @param width  the height of the image
     * @param height the width of the image
     * @return an {@link ImageIcon} that is scaled smooth to the desired width & height
     */
    public static ImageIcon getImageIcon(Class<?> c, String path, int width, int height) {
        BufferedImage image;
        ImageIcon icon = null;

        try {
            image = ImageIO.read(Objects.requireNonNull(c.getResource(path)));
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
