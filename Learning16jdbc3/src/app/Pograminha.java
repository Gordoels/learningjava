package app;
import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pograminha { //SET GLOBAL time_zone = '+3:00'; <--- na linha de cmd mysql caso o dê erro de timezone

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		Connection conn = null;
		PreparedStatement pt = null; //preparedstatement é a inserção simples
		
		try {
			conn = DB.getConn();
			
			pt = conn.prepareStatement("INSERT INTO seller" //Comandos de inserção na base de dados
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)", //os '?' significam placeholders 
					Statement.RETURN_GENERATED_KEYS); // com este último parâmetro se recupera o id na inserção
			
			pt.setString(1, "Gódo Enéru");
			pt.setString(2, "godo@enerupotocon");
			pt.setDate(3, new java.sql.Date(sdf.parse("12/12/12").getTime()));
			pt.setDouble(4, 9999.9);
			pt.setInt(5, 4);
			
			int linhasAfetadas = pt.executeUpdate();//quando é uma operação que vai alterar os dados, você chama o executeUpdate, o linhasAfetadas é para saber quantas linhas foram alteradas
			
			if(linhasAfetadas >0) { // Este bloco if-else é usado para printar qual o id do dado inserido
				ResultSet rs = pt.getGeneratedKeys(); //retorna um objeto do tipo ResultSet
				while(rs.next()) {
					int id = rs.getInt(1); //retorna os elementos da primeira coluna
					System.out.println("Já era! ID = " + id);
				}
			}
			else {
				System.out.println("Nenhuma row afetada nhaw");
			}
			
			//System.out.println("Já foi, linhas afetadas: " + linhasAfetadas); //print para usar quando for a inserção simples
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}finally { //sempre se fecha a conexão por último
			DB.closeStat(pt);
			DB.closeConnection();
		}
	}

}
