package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/caelum", "root",
					"1234");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
