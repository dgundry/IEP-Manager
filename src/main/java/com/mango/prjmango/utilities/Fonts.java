package com.mango.prjmango.utilities;

import java.awt.Font;
import lombok.Getter;

public enum Fonts {

    SEGOE_UI_12(12),
    SEGOE_UI_14(14),
    SEGOE_UI_16(16),
    SEGOE_UI_22(22),
    SEGOE_UI_26(26);

    @Getter
    private Font font;

    Fonts(int fontSize) {
        font = getFont(fontSize);
    }

    private Font getFont(int fontSize) {
        return new Font("Segoe UI", Font.PLAIN, fontSize);
    }
}
