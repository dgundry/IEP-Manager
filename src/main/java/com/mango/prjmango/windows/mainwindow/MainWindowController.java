package com.mango.prjmango.windows.mainwindow;

import java.awt.event.WindowAdapter;

public class MainWindowController {

    public MainWindowController(MainWindowView view) {
        view.getFrame().addWindowListener(new WindowAdapter() {
            //Pop up message when closing?
            //disconnect from database
        });
    }
}
