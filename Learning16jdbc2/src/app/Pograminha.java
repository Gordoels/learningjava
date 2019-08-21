package app;
import db.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pograminha { //SET GLOBAL time_zone = '+3:00'; <--- na linha de cmd mysql caso o dê erro de timezone

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
	
			st = conn.createStatement(); //objeto statement instanciado
			
			rs = st.executeQuery("select * from department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); //comando sql consultando a tabela, trazendo o resultado para a variavel rs
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally { //fechar conexão por ultimo sempre
			DB.closeStat(st);
			DB.closeResSet(rs);
			DB.closeConnection();
		}
	}

}
