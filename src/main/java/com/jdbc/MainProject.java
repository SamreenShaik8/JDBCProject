package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainProject {
private static Connection connection;

public static void main(String[] args) throws SQLException {
	System.out.println("Welcome to Employee_Management");
	
	System.out.println("Enter the operation you want to perform 1.Register, 2.Login, 3.Exit : ");
	
	connection = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
	
	Scanner sc=new Scanner(System.in);
	int option=sc.nextInt();
	
	switch(option)
	{
	case 1: Registration.registringTheUser(connection);
			main(null);
	case 2: Registration.login(connection);
	
	case 3: System.exit(0);
	
	default : System.out.println("Enter valid option");
	}
}
}
