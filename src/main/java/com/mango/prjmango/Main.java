package com.mango.prjmango;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import lombok.Getter;
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

	@Getter private static Connection connection = null;

	public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCREEN_WIDTH = (int) screenSize.getWidth();
	public static final int SCREEN_HEIGHT = (int) screenSize.getHeight();

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static final String TESTING_DB = "jdbc:sqlite:database/testing.db";

	public static MainFrame frame;

	/**
	 * Connects to the desired database url that's passed in.
	 * Note: Mainly used for testing purposes.
	 *
	 * @param database the database url
	 */
	public static void setDatabase(String database) {
		try {
			connection = DriverManager.getConnection(database);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Initialize start of the application. Connects to the database and instantiates
	 * classes that create the GUI.
	 *
	 * @param args the command line arguments passed in when running the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		try {
			String url = "jdbc:sqlite:database/iepCipher.db";
			connection = DriverManager.getConnection(url);

			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

			frame = new MainFrame();
			frame.setLoginPage();
//			frame.setTeacherView(new EditAccountView());
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
