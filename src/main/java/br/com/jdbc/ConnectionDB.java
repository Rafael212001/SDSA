package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionDB {
	
	private static Connection con;
	private static String dns = "jdbc:mysql:\\10.87.210.5:8081\\phpmyamin";
	private static String user = "root";
	private static String pass = "";
	
	public static Connection getConnection(){
		try {
			if(con == null || con.isClosed()){
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					con = DriverManager.getConnection(dns,user,pass);
					System.out.println("DB conectado com sucesso!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Erro ao conectar no DB");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
