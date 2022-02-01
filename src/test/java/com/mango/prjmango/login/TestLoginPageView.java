package com.mango.prjmango.login;

import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.swing.assertions.Assertions.assertThat;
import static org.assertj.swing.fixture.Containers.showInFrame;

/**
 * Tests for the login page and the JComponent's on that page.
 *
 * @author  Kellen Campbell
 * @version 1.0
 * @since   2021-11-23
 */
class TestLoginPageView extends AssertJSwingTestCaseTemplate {

    private FrameFixture frameFixture;

    private JTextComponentFixture emailText;
    private JTextComponentFixture passwordText;

    @BeforeEach
    public void setUp() {
        LoginPageView loginPageView = new LoginPageView();
        new LoginPageController(loginPageView);
        frameFixture = showInFrame(loginPageView);

        emailText = frameFixture.textBox("emailText");
        passwordText = frameFixture.textBox("passwordText");
    }

    /**
     * On initial load, the Email text field contains the text "Email".
     * When the text field gains focus by the user, the text will disappear.
     */
    @Test
    void emailTextFieldIsEmptyOnFocusTest() {
        //Act
        emailText.focus();

        //Assert
        assertThat(emailText.text()).isEmpty();
    }

    /**
     * On initial load, the Password text field contains the text "Password".
     * When the text field gains focus by the user, the text will disappear.
     */
    @Test
    void passwordTextFieldIsEmptyOnFocusTest() {
        //Act
        passwordText.focus();

        //Assert
        assertThat(passwordText.text()).isEmpty();
    }

    /**
     * On initial load, the Email text field contains the text "Email".
     * The user does NOT enter any text and then proceeds to click in the password text field.
     * The Email text field should insert the text "Email".
     */
    @Test
    void noTextWasEnteredInEmailTextFieldTest() {
        //Act
        emailText.focus();
        passwordText.focus();

        //Assert
        assertThat(emailText.text()).isEqualTo("Email");
    }

    /**
     * On initial load, the Password text field contains the text "Password".
     * The user does NOT enter any text and then proceeds to click in the email text field.
     * The Password text field should insert the text "Password".
     */
    @Test
    void noTextWasEnteredInPasswordTextFieldTest() {
        //Act
        passwordText.focus();
        emailText.focus();

        //Assert
        assertThat(passwordText.text()).isEqualTo("Password");
    }

    /**
     * When the user enters text into the Email text field and then
     * proceeds to go to the Password text field, the Email text field
     * should not reset. It should contain the new text they entered.
     */
    @Test
    void textWasEnteredInEmailTextFieldTest() {
        //Act
        emailText.focus();
        emailText.setText("kcampbell16@radford.edu");
        passwordText.focus();

        //Assert
        assertThat(emailText.text()).isNotEmpty();
    }

    /**
     * When the user enters text into the Password text field and then
     * proceeds to go to the Email text field, the Password text field
     * should not reset. It should contain the new text they entered.
     */
    @Test
    void textWasEnteredInPasswordTextFieldTest() {
        //Act
        passwordText.focus();
        passwordText.setText("admin");
        emailText.focus();

        //Assert
        assertThat(passwordText.text()).isNotEmpty();
    }

    @AfterEach
    public void tearDown() {
        frameFixture.cleanUp();
    }
}
