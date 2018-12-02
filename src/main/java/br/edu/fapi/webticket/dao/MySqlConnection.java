package br.edu.fapi.webticket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	public static String url = "jdbc:mysql://localhost:3306/webticket";
	public static String usuario = "root";
	public static String senha = "123456";

	public static Connection abrirConexao() throws SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		return DriverManager.getConnection(url, usuario, senha);
	}
}
