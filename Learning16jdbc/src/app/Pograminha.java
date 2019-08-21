package app;
import db.DB;
import java.sql.Connection;

public class Pograminha {

	public static void main(String[] args) {
		
		Connection conn = DB.getConn();
		DB.closeConnection();

	}

}
