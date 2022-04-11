package com.mango.prjmango.ui.common;

import java.awt.Font;
import lombok.Getter;

public enum Fonts {

    SEGOE_UI_12(12),
    SEGOE_UI_14(14),
    SEGOE_UI_15(15),
    SEGOE_UI_16(16),
    SEGOE_UI_18(18),
    SEGOE_UI_19(19),
    SEGOE_UI_20(20),
    SEGOE_UI_22(22),
    SEGOE_UI_23(23),
    SEGOE_UI_24(24),
    SEGOE_UI_26(26),
    SEGOE_UI_50(50),
    SEGOE_UI_70(70);

    @Getter
    private Font font;

    Fonts(int fontSize) {
        font = getFont(fontSize);
    }

    private Font getFont(int fontSize) {
        return new Font("Segoe UI", Font.PLAIN, fontSize);
    }
}
