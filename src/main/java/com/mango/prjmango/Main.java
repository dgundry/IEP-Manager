package com.mango.prjmango;

import com.mango.prjmango.Outlines.Outlines;
import com.mango.prjmango.student.Students;
import com.mango.prjmango.ui.MainWindowView;
import com.mango.prjmango.ui.activities.SightWords;
import com.mango.prjmango.ui.login.LoginController;
import com.mango.prjmango.ui.login.LoginView;
import com.mango.prjmango.utilities.DatabaseConnection;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.UIManager;
import lombok.Getter;
import lombok.Setter;
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

	public static final Rectangle rect = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

	@Getter @Setter private static LoggedInUser activeUser;
	@Getter @Setter private static Students students;
	@Getter @Setter private static Outlines outlines;

	public static final SightWords SIGHT_WORDS = new SightWords();

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

			new MainWindowView();

			LoginView loginView = new LoginView();
			new LoginController(loginView);
			MainWindowView.setActiveDisplay(loginView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
