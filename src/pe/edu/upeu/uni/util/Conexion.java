package pe.edu.upeu.uni.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	 private static final String URL = "jdbc:mysql://localhost:3306/bduni?characterEncoding=latin1";
		private static final String DRIVER="com.mysql.jdbc.Driver";
		private static final String USER="root";
		private static final String PASS = "";
		private static Connection cx = null;
	 
	 public static Connection getConexion() {
		 try {
			Class.forName(DRIVER);
			if(cx==null) {
				cx = DriverManager.getConnection(URL, USER, PASS);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		 return cx;
	 }
}
