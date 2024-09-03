package com.spglob.prac;
import java.sql.*;
import java.util.Scanner; 


public class Main {
	
//	private static String url = "jdbc:mysql://localhost:3306/MJ";
	private static String url = "jdbc:mysql://localhost:3306/BANK";
	private static String name = "root";
	private static String password = "12345";
	
	public static void main(String[] args) {
		
		System.out.println("Hello ! this example for database connectivity! ");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){ 
			e.printStackTrace();
		}
		
		try {
			
			// for connection we used connection interface 
			Connection databaseConnection = DriverManager.getConnection(url,name,password);
			
			
			
			/*                   SELECT QUERIES                     */
			
			// for run sql queries we used statement interface
			//	Statement statement = databaseConnection.createStatement();
			
			// for storing these queries we used result set because query return the table
			// so we need to store this table in the result set
			// String query = "SELECT * FROM STUDENT";
			//	ResultSet resultSet = statement.executeQuery(query);
			//		while(resultSet.next()) {
			//				int id = resultSet.getInt("ID");
			//				String name = resultSet.getString("fullName");
			//				System.out.println("id :  " + id  + "   name :  " + name);
			//
			//		}
			//			
			
			
			/*                   UPDATE QUERIES                      */
//			Statement statement = databaseConnection.createStatement();
//			String InsertQuery = String.format("INSERT INTO STUDENT(fullName) Values('%s')","Rohit");
//			int rowsAffected = statement.executeUpdate(InsertQuery);
//			if(rowsAffected > 0) {
//				System.out.print("Rows Affected ");
//			}else {
//				System.out.print("Rows Not Affected ");
//			}
//			
//			
			
			/* 					UPDATE QUERIES  					*/
//			Statement statement =  databaseConnection.createStatement();
//			String  UpdateQuery =  String.format("UPDATE STUDENT SET fullName='%s' WHERE fullName = '%s'", "MJ","mihir");
//			int rowsAffected = statement.executeUpdate(UpdateQuery);
//			if(rowsAffected > 0) {
//				System.out.print("Rows Affected ");
//			}else {
//				System.out.print("Rows Not Affected ");
//			}
//			
			
			/* 					DELETE QUERY  						*/
//			Statement statement =  databaseConnection.createStatement();
//			String  deleteQuery =  String.format("DELETE FROM STUDENT WHERE fullName ='MJ' ");
//			int rowsAffected = statement.executeUpdate(deleteQuery);
//			if(rowsAffected > 0) {
//				System.out.print("Rows Affected ");
//			}else {
//				System.out.print("Rows Not Affected ");
//			}
//			
			
			
			/* 					Prepared Statements          		
			 * In this we can not write repeatedly queries  */
			
			
//			String queries =  "INSERT INTO STUDENT(fullName) values(?)";
//			PreparedStatement preparedStatement = databaseConnection.prepareStatement(queries);
//			preparedStatement.setString(1, "MIHIR");
//			int rowsAffected = preparedStatement.executeUpdate();
//			if(rowsAffected > 0) {
//				System.out.print("Rows Affected ");
//			}else {
//				System.out.print("Rows Not Affected ");
//			}
			
//			
//			String query = "SELECT ID from STUDENT WHERE ID = ?";
//			PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
//			preparedStatement.setInt(1, 1);
//			ResultSet resultSet  = preparedStatement.executeQuery();
//			if(resultSet.next()){
//				System.out.println(resultSet.getInt("ID"));
//			}else {
//				System.out.println("ID not Found");
//			}
//			
			
			/* 				Batch Processing  						*/
			/* It stores the data in the form of batches then run all the queries
			 * that are stored in Batches*/
			
//			Scanner sc =  new Scanner(System.in);
//			Statement statement = databaseConnection.createStatement();
//			while(true) {
//				System.out.print("Enter name : ");
//				String name = sc.next();
//				System.out.println("Enter More Data(Y/N) :  ");
//				String choice = sc.next();
//				String query = String.format("INSERT INTO STUDENT(fullName) values('%s')",name);
//				statement.addBatch(query);
//				if(choice.toUpperCase().equals("N")) {
//					break;
//				}
//			}
//			
//		
//			
//			int rows[] = statement.executeBatch();
//			for(int i=0;i<rows.length;i++) {
//				if(rows[i] == 0) {
//					System.out.println("Query : " + i + "not executed Successfully" );
//				}
//			}
//			sc.close();
			
			
//			Scanner sc =  new Scanner(System.in);
//			String query = "INSERT INTO STUDENT(fullname) Values(?)";
//			PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
//			
//			while(true) {
//				System.out.print("Enter name : ");
//				String name = sc.next();
//				preparedStatement.setString(1, name);
//				System.out.println("Enter More Data(Y/N) :  ");
//				String choice = sc.next();
//				preparedStatement.addBatch();
//				if(choice.toUpperCase().equals("N")) {
//					break;
//				}
//			}
//			
//			int rows[] = preparedStatement.executeBatch();
//			for(int i=0;i<rows.length;i++) {
//				if(rows[i] == 0) {
//					System.out.println("Query : " + i + "not executed Successfully" );
//				}
//			}
//			sc.close();
//			
			
			
			
			/* 						Transaction Handling 				*/
//			String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_no = ?  ";
//			String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_no = ? ";
//			PreparedStatement debitPs = databaseConnection.prepareStatement(debitQuery);
//			PreparedStatement creditPs = databaseConnection.prepareStatement(creditQuery);
//			
//			Scanner sc = new Scanner(System.in);
//			
//			System.out.print("enter account no : ");
//			int acc = sc.nextInt();
//
//			System.out.print("enter amount : ");
//			double amount = sc.nextDouble();
//			
//			
//			
//			debitPs.setDouble(1, amount);
//			debitPs.setInt(2,acc);
//			creditPs.setDouble(1,amount);
//			creditPs.setInt(2,acc);
			
//			if(isSuff(databaseConnection,123,amount)) {
//				int afRow1 = debitPs.executeUpdate();
//				int afRow2 = creditPs.executeUpdate();
//				
//			}else{
//				System.out.println("Amount not exists");
//			}
			
			debitPs.executeUpdate();
			creditPs.executeUpdate();
			sc.close();
			
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
//	static boolean isSuff(Connection con , int accNo , double amount) {
//		try {
//			String query = "SELECT balance From accounts where account_no = ?";
//			PreparedStatement pre = con.prepareStatement(query);
//			pre.setInt(1, accNo);
//			ResultSet result =  pre.executeQuery();
//			if(result.next()) {
//				double curr_bal =  result.getDouble("balance");
//				if(amount > curr_bal) {
//					return false;
//				}else {
//					return true;
//				}
//			}
//		}catch(SQLException e) {
//			e.getMessage();
//		}
//	}

}
