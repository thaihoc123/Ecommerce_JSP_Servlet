package Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/webbanhang","root","thaihoc2002pro");
            System.out.print("connected");
        }
        return connection;
    }
}
