package com.mango.prjmango.ui.common;

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

    ACCOUNT_TAB_NO_HOVER("/images/tabs/account-tab-no-hover.png", 243, 44),
    ACCOUNT_TAB_HOVERED("/images/tabs/account-tab-hovered.png", 243, 44),

    STUDENT_TAB_NO_HOVER("/images/tabs/students-tab-no-hover.png", 243, 44),
    STUDENT_TAB_HOVERED("/images/tabs/students-tab-hovered.png", 243, 44),

    ACTIVITIES_TAB_NO_HOVER("/images/tabs/activities-tab-no-hover.png", 243, 44),
    ACTIVITIES_TAB_HOVERED("/images/tabs/activities-tab-hovered.png", 243, 44),

    REPORTS_TAB_NO_HOVER("/images/tabs/reports-tab-no-hover.png", 243, 44),
    REPORTS_TAB_HOVERED("/images/tabs/reports-tab-hovered.png", 243, 44),

    LOG_OUT_NO_HOVER("/images/login/log-out-no-hover.png", 124, 28),
    LOG_OUT_HOVERED("/images/login/log-out-hovered.png", 124, 28),

    LOGIN_PANEL_BACKGROUND("/images/common/login-panel-background.png", 482, 646),
    ACTIVE_TAB_BACKGROUND("/images/common/active-tab-background.png", Main.rect.width, Main.rect.height),

    NEXT_NO_HOVER("/images/common/next-no-hover.png", 116, 31),
    NEXT_HOVERED("/images/common/next-hovered.png", 116, 31),

    BACK_NO_HOVER("/images/common/back-no-hover.png", 116, 31),
    BACK_HOVERED("/images/common/back-hovered.png", 116, 31),

    APP_EXIT_NO_HOVER("/images/common/exit-no-hover.png", 95, 31),
    APP_EXIT_HOVERED("/images/common/exit-hovered.png", 95, 31),

    APP_CANCEL_NO_HOVER("/images/common/cancel-no-hover.png", 95, 31),
    APP_CANCEL_HOVERED("/images/common/cancel-hovered.png", 95, 31),

    APP_LOG_OUT_NO_HOVER("/images/common/log-out-no-hover.png", 95, 31),
    APP_LOG_OUT_HOVERED("/images/common/log-out-hovered.png", 95, 31),

    EDIT_PROFILE_SAVE_NO_HOVER("/images/account/edit-profile/account-save-no-hover.png", 117, 47),
    EDIT_PROFILE_SAVE_HOVERED("/images/account/edit-profile/account-save-hovered.png", 117, 47),

    EDIT_PROFILE_EDIT_ICON_NO_HOVER("/images/account/edit-profile/edit-icon-no-hover.png", 28, 28),
    EDIT_PROFILE_EDIT_ICON_HOVERED("/images/account/edit-profile/edit-icon-hovered.png", 28, 28),

    EDIT_PROFILE_NO_HOVER("/images/account/edit-profile/edit-profile-no-hover.png", 290, 30),
    EDIT_PROFILE_HOVERED("/images/account/edit-profile/edit-profile-hovered.png", 290, 30),
    EDIT_PROFILE_SELECTED("/images/account/edit-profile/edit-profile-selected.png", 290, 30),

    PASSWORD_SECURITY_NO_HOVER("/images/account/password/password-security-no-hover.png", 290, 30),
    PASSWORD_SECURITY_HOVERED("/images/account/password/password-security-hovered.png", 290, 30),
    PASSWORD_SECURITY_SELECTED("/images/account/password/password-security-selected.png", 290, 30),

    PASSWORD_SECURITY_SAVE_NO_HOVER("/images/account/password/password-security-save-no-hover.png", 117, 47),
    PASSWORD_SECURITY_SAVE_HOVERED("/images/account/password/password-security-save-hovered.png", 117, 47),

    PASSWORD_OPEN_EYE_NO_HOVER("/images/account/password/open-eye-no-hover.png", 28, 28),
    PASSWORD_OPEN_EYE_HOVERED("/images/account/password/open-eye-hovered.png", 28, 28),

    PASSWORD_CLOSED_EYE_NO_HOVER("/images/account/password/closed-eye-no-hover.png", 28, 28),
    PASSWORD_CLOSED_EYE_HOVERED("/images/account/password/closed-eye-hovered.png", 28, 28),

    ACTIVITIES_MATH_NO_HOVER("/images/activities/math/math-no-hover.png", 290, 30),
    ACTIVITIES_MATH_HOVERED("/images/activities/math/math-hovered.png", 290, 30),
    ACTIVITIES_MATH_SELECTED("/images/activities/math/math-selected.png", 290, 30),

    ACTIVITIES_FRY_NO_HOVER("/images/activities/fry/fry-sight-words-no-hover.png", 290, 30),
    ACTIVITIES_FRY_HOVERED("/images/activities/fry/fry-sight-words-hovered.png", 290, 30),
    ACTIVITIES_FRY_SELECTED("/images/activities/fry/fry-sight-words-selected.png", 290, 30),

    ACTIVITIES_DOLCH_NO_HOVER("/images/activities/dolch/dolch-sight-words-no-hover.png", 290, 30),
    ACTIVITIES_DOLCH_HOVERED("/images/activities/dolch/dolch-sight-words-hovered.png", 290, 30),
    ACTIVITIES_DOLCH_SELECTED("/images/activities/dolch/dolch-sight-words-selected.png", 290, 30),

    ACTIVITIES_UPLOAD_NO_HOVER("/images/activities/upload/upload-no-hover.png", 290, 30),
    ACTIVITIES_UPLOAD_HOVERED("/images/activities/upload/upload-hovered.png", 290, 30),
    ACTIVITIES_UPLOAD_SELECTED("/images/activities/upload/upload-selected.png", 290, 30),

    FRY_BEGIN_NO_HOVER("/images/activities/fry/begin-no-hover.png", 164, 39),
    FRY_BEGIN_HOVERED("/images/activities/fry/begin-hovered.png", 164, 39),

    FRY_ASSIGNMENT_CORRECT_NO_HOVER("/images/activities/fry/correct-no-hover.png", 106, 59),
    FRY_ASSIGNMENT_CORRECT_HOVERED("/images/activities/fry/correct-hovered.png", 106, 59),

    FRY_ASSIGNMENT_INCORRECT_NO_HOVER("/images/activities/fry/incorrect-no-hover.png", 106, 59),
    FRY_ASSIGNMENT_INCORRECT_HOVERED("/images/activities/fry/incorrect-hovered.png", 106, 59),

    STUDENTS_VIEW_NO_HOVER("/images/students/view/my-students-no-hover.png", 290, 30),
    STUDENTS_VIEW_HOVERED("/images/students/view/my-students-hovered.png", 290, 30),
    STUDENTS_VIEW_SELECTED("/images/students/view/my-students-selected.png", 290, 30),

    STUDENTS_CREATE_NO_HOVER("/images/students/create/create-student-no-hover.png", 290, 30),
    STUDENTS_CREATE_HOVERED("/images/students/create/create-student-hovered.png", 290, 30),
    STUDENTS_CREATE_SELECTED("/images/students/create/create-student-selected.png", 290, 30),

    STUDENTS_EDIT_NO_HOVER("/images/students/edit/edit-student-no-hover.png", 290, 30),
    STUDENTS_EDIT_HOVERED("/images/students/edit/edit-student-hovered.png", 290, 30),
    STUDENTS_EDIT_SELECTED("/images/students/edit/edit-student-selected.png", 290, 30),

    CREATE_ACCOUNT_NO_HOVER("/images/common/create-account-no-hover.png", 116, 31),
    CREATE_ACCOUNT_HOVERED("/images/common/create-account-hovered.png", 116, 31),

    OK_BUTTON_NO_HOVER("/images/common/ok-button-no-hover.png", 116, 31),
    OK_BUTTON_HOVERED("/images/common/ok-button-hovered.png", 116, 31),

    RESET_PASSWORD_NO_HOVER("/images/forgot-password/reset-password-no-hover.png", 116, 31),
    RESET_PASSWORD_HOVERED("/images/forgot-password/reset-password-hovered.png", 116, 31);

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
