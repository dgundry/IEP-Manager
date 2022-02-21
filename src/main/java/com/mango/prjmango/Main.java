package com.mango.prjmango;

import com.mango.prjmango.utilities.DatabaseConnection;
import com.mango.prjmango.windows.MainWindowView;
import com.mango.prjmango.windows.sideoptions.SideOptionsController;
import com.mango.prjmango.windows.sideoptions.SideOptionsView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.apache.commons.lang.SystemUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Individualized Educational Plans Management Tool
 *
 * @author Emily Robey
 * @author Wes Noffsinger
 * @author Devin Grundy
 * @author Patrick Weaver
 * @author Kellen Campbell
 */
@SpringBootApplication
public class Main {

	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public static final int SCREEN_WIDTH = (int) screenSize.getWidth();
	public static final int SCREEN_HEIGHT = (int) screenSize.getHeight();

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static MainFrame frame;

	public static LoggedInUser activeUser;

	/**
	 * Initialize start of the application. Connects to the database and instantiates
	 * classes that create the GUI.
	 *
	 * @param args the command line arguments passed in when running the application.
	 */
	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);

		DatabaseConnection connection = new DatabaseConnection();

		Thread thread = new Thread(connection);
		thread.start();

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			//frame = new MainFrame();
			//frame.setLoginPage();

			String os = SystemUtils.OS_NAME;
			if (os.contains("Windows")) {
				SideOptionsView sideOptionsView = new SideOptionsView();
				new SideOptionsController(sideOptionsView);

				MainWindowView view = new MainWindowView();
				view.setLoginPage();
			} else {
				System.out.println("On a Mac");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
