package recipe.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static final String DB_DRIVER = new String("org.apache.derby.jdbc.ClientDriver");
	public static final String DB_URL = new String("jdbc:derby://localhost:1527/RecipesDB");

	private Connection connection;

	private static DBConnection instance = new DBConnection();

	private DBConnection() {
		try {
			// Connect to DB
			System.out.println("Loading the Derby jdbc driver...");
			Class.forName(DB_DRIVER).newInstance();

			System.out.println("Connecting to the SRSDB database on JavaDB server...");
			this.connection = DriverManager.getConnection(DB_URL);
			System.out.println("Successfully made the connection to SRSDB.");
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		return instance;
	}

	public Connection getConnection() {
		return this.connection;
	}

}
