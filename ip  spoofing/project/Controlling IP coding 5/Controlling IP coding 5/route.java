import java.sql.*;
import java.sql.Connection.*;
import java.net.*;
class pda
{
	public Connection cs;
	public Statement st;
	public ResultSet rs,rs1,rs2;
	double val;
	double cel,flo;
	int i,count = 0,check = 0;
	double ceil[] = new double[10];
	double floor[] = new double[10];
	String path[] = new String[10];
	

	public Statement connect() throws Exception
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cs = DriverManager.getConnection("jdbc:odbc:server");
			st = cs.createStatement();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}

	public void getval() 
	{
		try
		{
		connect();
		
			rs = st.executeQuery("select path,delay from possiblepath");

		while(rs.next())
		{

			val = Double.parseDouble(rs.getString(1));
			System.out.println("\t"+val);
				cel = Math.ceil(val);
				flo = Math.floor(val);
			
			System.out.println("\t"+cel+"\t"+flo);
			ceil[i] = cel;
			floor[i] = flo;
			i++;
		}
		try
		{
			rs2 = st.executeQuery("select count(*) from possiblepath");
			while(rs2.next())
			{
				count =Integer.parseInt(rs2.getString(1));
				System.out.println("\t"+count);

			}
			
		}
		catch (Exception ex1)
		{
			ex1.printStackTrace();	
		}

			

		for (i=0;i<count;i++ )
		{
			try
		{
			rs2 = st.executeQuery("select count(*) from possiblepath");
			while(rs2.next())
			{
				check =Integer.parseInt(rs2.getString(1));
				System.out.println("\t"+check);

			}
			
		}
		catch (Exception ex1)
		{
			ex1.printStackTrace();	
		}
			System.out.println("inside for loop"+path[i]+"\t"+ceil[i]+"\t"+floor[i]);
			if (check%2 == 0)
			{
				st.executeUpdate("insert into pda values ('"+path[i]+"','"+ceil[i]+"')");
			}
			else
			{
				st.executeUpdate("insert into pda values ('"+path[i]+"','"+floor[i]+"')");
			}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		}


}
