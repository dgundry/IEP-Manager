package com.mango.prjmango.components;

import java.awt.Font;

/**
 * This class allows us to easily access the commonly used font but with different sizes.
 */
public class FontType {

    private static final String FONT_NAME = "Signika";

    public static final Font FONT_12_BOLD = new Font(FONT_NAME, Font.BOLD, 12);
    public static final Font FONT_20_BOLD = new Font(FONT_NAME, Font.BOLD, 20);
    public static final Font FONT_35_BOLD = new Font(FONT_NAME, Font.BOLD, 35);
}
