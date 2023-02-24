package beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connect {
	
	
	@SuppressWarnings("finally")
	public static Connection getConnection() throws IOException {
		
		Properties p = new Properties() ;
		FileInputStream f = new FileInputStream("C://Users/elmra/eclipse-workspace/AppWebMin/configDB.properties") ;
		p.load(f);
		System.out.println(p.getProperty("driver"));
		
		
		
		try {
			Class.forName(p.getProperty("driver")) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dbms = p.getProperty("dbms") ;
		String server = p.getProperty("server") ;
		String port = p.getProperty("port") ;
		String db = p.getProperty("db") ;
		
		String url = "jdbc:" + dbms + "://" + server + ":" + port + "/" + db ;
		String utilisateur = p.getProperty("user") ;
		String motDePasse = p.getProperty("password") ;
		System.out.println(url);
		Connection connexion = null;
		
		try {
			connexion = DriverManager.getConnection(url , utilisateur, motDePasse) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		finally {
			
			System.out.println("connexion");
			return connexion ;
			
			
		}
		
		//return connexion;
		
	}
	


}
