package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector {

	public static ResultSet result;

	public static ResultSet defaultMethods(String queryvalue) throws SQLException {

		// Data Requirements
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String password = "root@123";
		String query = queryvalue;

		// Connection Establishment
		Connection connection = DriverManager.getConnection(url, username, password);

		// Execute Query
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(query);

		return result;
	}

	public static String getParticularData() throws SQLException {

		result = defaultMethods("select * from employees");

		result.next();

		String firstValue = result.getString(1);
		System.out.println(firstValue);

//		result.next();

		String secondValue = result.getString(3);
		System.out.println(secondValue);
		return secondValue;
	}

	public static void getAllData() throws SQLException {

		result = defaultMethods("select * from employees limit 5");

		while (result.next()) {

			String firstname = result.getString(3);
			System.out.println(firstname);
		}

	}

}