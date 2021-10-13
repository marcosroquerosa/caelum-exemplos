package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	//CREATE DATABASE IF NOT EXISTS `fj21` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
