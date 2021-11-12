package com.mango.prjmango;

import com.mango.prjmango.login.LoginPageController;
import com.mango.prjmango.login.LoginPageView;
import com.mango.prjmango.mainloginpage.MainLoginView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Individual Education Plan Management Tool
 *
 * @author Emily Robey
 * @author Wes Noffsinger
 * @author Devin Grundy
 * @author Patrick Weaver
 * @author Kellen Campbell
 */
@SpringBootApplication
public class Main {

	private static Connection connection = null;
	public static Connection getConnection(){
		return connection;
	}

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCREEN_WIDTH = (int) screenSize.getWidth();
	public static final int SCREEN_HEIGHT = (int) screenSize.getHeight();

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static final String TESTING_DB = "jdbc:sqlite:database\\testing.db";

	public static void setDatabase(String database) {
		try {
			connection = DriverManager.getConnection(database);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		try {
			String url = "jdbc:sqlite:database\\iepCipher.db";
			connection = DriverManager.getConnection(url);

			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

			//Comment out these lines and add new code to test out views
			LoginPageView loginPageView = new LoginPageView();
			new LoginPageController(loginPageView);

			new MainLoginView();
			MainLoginView.setActivePanel(loginPageView);

			//Comment for testing TeacherView
			//TeacherView teacherView = new TeacherView();
			//new TeacherController(teacherView);

			//Comment for testing EditAccountView
			// EditAccountView editAccountView = new EditAccountView();
			//new EditAccountController(editAccountView);

			//Comment for testing CreateAStudentView:
			//CreateAStudentView createAStudent = new CreateAStudentView();
			//new StudentController(createAStudent);

			//MainLoginView.setActivePanel(teacherView.getTeacherPanel());

		} catch (SQLException
				| ClassNotFoundException
				| InstantiationException
				| IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}
