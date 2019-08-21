package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Classe para obter e fechar as conex�es ao banco
public class DB {
	// � feito de m�todos st�ticos

	private static Connection conn = null; // no jdbc, para se conectar ao banco, precisa de instanciar um objeto
											// Connection

	public static Connection getConn() {// metodo para conectar ao banco de dados
		if(conn == null) {
			try {
				Properties props = loadProperties(); //resgata as propriedades
				String url = props.getProperty("dburl"); //url do banco de dados
				conn = DriverManager.getConnection(url, props); //para obter conex�o ao banco, precisa do drivermanager
			}catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {//fecha conex�o
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new DBException (e.getMessage());
			}
		}
	}
	
	public static void closeStat(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}
	
	public static void closeResSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties() { // este abre o db.properties e armazena num objeto tipo Properties,
													// carregando as propriedades definidas no arquivo
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs); // o comando .load faz a leitura do arquivo Properties apontado pela inputstream
							// fs e armazena no objeto props
			return props;
		} catch (IOException e) {
			throw new DBException(e.getMessage());
		}

	}
}
