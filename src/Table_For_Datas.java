
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Table_For_Datas {

	public static void main(String[] args) throws ClassNotFoundException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://dijkstra2.ug.bcc.bilkent.edu.tr/emir_acimis","emir.acimis","xcqjgigkp");	
			Statement statement = con.createStatement();
			statement.executeUpdate("CREATE TABLE Player" +
					"(cid CHAR(12) , name VARCHAR(50), bdate DATE, address VARCHAR(50), city VARCHAR(20), nationality VARCHAR(20)" +
					", PRIMARY KEY(cid) )ENGINE=INNODB;");
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
