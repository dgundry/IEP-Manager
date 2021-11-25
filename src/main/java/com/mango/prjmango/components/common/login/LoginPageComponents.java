package com.mango.prjmango.components.common.login;

import com.mango.prjmango.components.FontType;
import com.mango.prjmango.components.RoundedPanel;
import com.mango.prjmango.createaccount.CreateAccountView;
import com.mango.prjmango.createaccount.password.PasswordView;
import com.mango.prjmango.createaccount.securityquestions.SecurityQuestionsView;
import com.mango.prjmango.forgotpassword.email.EmailView;
import com.mango.prjmango.forgotpassword.password.ChangePasswordView;
import com.mango.prjmango.forgotpassword.securityquestions.AnswerSecurityQuestionsView;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.utilities.ImageIcons;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * This class creates the <b>commonly displayed</b> components
 * that are found on the following pages:
 * <ul>
 *     <li>{@link LoginPageView}</li>
 *     <li>{@link PasswordView}</li>
 *     <li>{@link SecurityQuestionsView}</li>
 *     <li>{@link CreateAccountView}</li>
 *     <li>{@link EmailView}</li>
 *     <li>{@link ChangePasswordView}</li>
 *     <li>{@link AnswerSecurityQuestionsView}</li>
 * </ul>
 *
 * @author  Kellen Campbell
 * @version 1.0
 * @since   2021-11-23
 */
public class LoginPageComponents {

    /**
     * Creates the commonly used components that you see on any of the views
     * with the login, create account, or forgot password pages.
     *
     * @param parent the parent container that will hold these components
     */
    public static void setCommonComponents(RoundedPanel parent) {
        JLabel schoolLogo = new JLabel(ImageIcons.SCHOOL_LOGO_ICON);
        schoolLogo.setBounds(
                (int) (parent.getWidth() * 0.5) - 50,
                (int) (parent.getHeight() * 0.05),
                (229 / 2),
                110);

        JLabel mangoLogo = new JLabel(ImageIcons.MANGO_LOGO_ICON);
        mangoLogo.setBounds(
                (int) (parent.getWidth() * 0.5) - 25,
                (parent.getHeight() - 75),
                50,
                50);

        JLabel titleHeader = new JLabel("IEP Manager", SwingConstants.CENTER);
        titleHeader.setBounds(0, (int) (parent.getHeight() * 0.28) , parent.getWidth(),45);
        titleHeader.setFont(FontType.FONT_35_BOLD);
        titleHeader.setForeground(Color.WHITE);

        JSeparator separatorHeader = new JSeparator(SwingConstants.CENTER);
        separatorHeader.setBounds(
                (int) (parent.getWidth() * 0.5) - (int) (parent.getWidth() * 0.20),
                (int) (parent.getHeight() * 0.45),
                (int) (parent.getWidth() * 0.40),
                1);
        separatorHeader.setBackground(Color.WHITE);

        parent.add(schoolLogo);
        parent.add(mangoLogo);
        parent.add(titleHeader);
        parent.add(separatorHeader);
    }
}
