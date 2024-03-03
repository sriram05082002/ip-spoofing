import java.sql.*;
import java.net.*;

public class dataconnect
{
	 public Connection cs;   
	 public Statement st;
	 public ResultSet rs;

	public Statement connect()
	{
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cs=DriverManager.getConnection("jdbc:odbc:server");
			st=cs.createStatement();
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return st;
		
	}
}
