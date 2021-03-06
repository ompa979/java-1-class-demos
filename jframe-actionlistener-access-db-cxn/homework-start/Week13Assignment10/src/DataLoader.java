import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataLoader {

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		
		
		Connection con = null;
		
		try {

			con = DriverManager.getConnection(FormLoader.connectionString, "SA", "");
			

			String teamsTable = "CREATE TABLE IF NOT EXISTS teams " + 
					" (intTeamID INTEGER, strTeam VARCHAR(50), strMascot VARCHAR(50));";
			
			con.createStatement().executeUpdate(teamsTable);

			con.createStatement().executeUpdate(
					"INSERT INTO teams VALUES(1, 'The Gators', 'Fuzzy the Gator'); ");

			con.createStatement().executeUpdate(
					"INSERT INTO teams VALUES(2, 'The Wizards', 'Harry Potter'); ");
			
			
	        
		} catch (SQLException e) {
			throw e;
		} finally {
			con.close();
			System.out.println("Program complete");
		}
	}

}
