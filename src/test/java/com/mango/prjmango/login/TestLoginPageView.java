package com.mango.prjmango.login;

import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.testing.AssertJSwingTestCaseTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.swing.assertions.Assertions.assertThat;
import static org.assertj.swing.fixture.Containers.showInFrame;

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
     * On initial load, the Email text field contains the text "Email".
     * The does NOT enter any text and then proceeds to click in the password text field.
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

    @AfterEach
    public void tearDown() {
        frameFixture.cleanUp();
    }
}
