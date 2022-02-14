package com.mango.prjmango;

import com.mango.prjmango.utilities.DatabaseConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
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

			frame = new MainFrame();
			frame.setLoginPage();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
