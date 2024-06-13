package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {

	private static PreparedStatement preparedStatement;
	private static int executeUpdate;
	private static ResultSet res;

	public static void registringTheUser(Connection connection) throws SQLException {

		String query = "insert into Registration values (?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
        
		System.out.println("Enter the id : ");
		int id = sc.nextInt();
		System.out.println("Enter the name : ");
		String name = sc.next();
		System.out.println("Enter the email : ");
		String email = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		System.out.println("Enter user name : ");
		String userName = sc.next();
        
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, email);
		preparedStatement.setString(4, password);
		preparedStatement.setString(5, userName);

		executeUpdate = preparedStatement.executeUpdate();
		if (executeUpdate > 0)
			System.out.println("Register Successfully");
		else
			System.out.println("Register not Successful");
	}
	public static void login(Connection connection) throws SQLException {
		String query = "select * from Registration where user_name=? and pwd=?";
		preparedStatement = connection.prepareStatement(query);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter user name : ");
		String userName = sc.next();
		System.out.println("Enter pwd : ");
		String password = sc.next();

		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, password);

		res = preparedStatement.executeQuery();
		if (res != null)
			System.out.println("Login Successfully");
		else
			System.out.println("Login Failed");
	}
}
