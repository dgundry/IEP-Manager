package com.mango.prjmango.components.dialogs;

import com.mango.prjmango.components.dialogs.account.AccountCreatedController;
import com.mango.prjmango.components.dialogs.account.AccountCreatedView;

/**
 * This class handles the multiple pop up messages that the
 * user will encounter. Instead of using the original JOptionPane
 * dialogs, these new dialogs will be used.
 *
 * @author  Kellen Campbell
 * @version 1.0
 * @since   2021-11-25
 */
public class Dialog {

    public static final int ACCOUNT_CREATED = 1;

    /**
     * Based off the message type passed in will determine
     * which dialog will appear.
     *
     * @param messageType the message type for the pop-up dialog
     */
    public static void openDialog(int messageType) {
        switch (messageType) {
            case ACCOUNT_CREATED:
                new AccountCreatedController(new AccountCreatedView());
                break;
            default:
                break;
        }
    }
}
