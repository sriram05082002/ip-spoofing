import java.sql.*;
import java.sql.Connection.*;
import java.net.*;
class limit
{
	public Connection cs;
	public Statement st;
	public ResultSet rs,rs1,rs2;
	double val1,val2,result1,result2;
	int i,count = 0;
	double res1[] = new double[10];
	double res2[] = new double[10];
    String path[] = new String[10];
String n[] = new String[10];
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
			rs = st.executeQuery("select * from possiblepath");
			
		while(rs.next())
		{
			
			n[i]=rs.getString(1);
			path[i]=rs.getString(2);
			val1 = Double.parseDouble(rs.getString(3));
			val2 = Double.parseDouble(rs.getString(4));
			System.out.println("rtc path:"+path);
			System.out.println("\t"+val1+"\t"+val2);
			result1 = Math.ceil(val1);
			result2 = Math.ceil(val2);
			System.out.println("\t"+result1+"\t"+result2);
			res1[i]= result1;
			res2[i]= result2;
			i++;
		}
		try
		{
			rs2 = st.executeQuery("select count(*) from possiblepath");
			while(rs2.next())
			{
				count =Integer.parseInt(rs2.getString(1));
				System.out.println("Count :\t"+count);

			}
			
		}
		catch (Exception ex1)
		{
			ex1.printStackTrace();	
		}

		
			
		//st.execute("create table RTC (path varchar(20),limit varchar(20),delay varchar(20))");

		for (i=0;i<count;i++ ) 
		{
			System.out.println("inside for loop"+path[i]+"\t"+res1[i]+"\t"+res2[i]);
			st.executeUpdate("insert into pda values ('"+path[i]+"','"+res1[i]+"','"+res2[i]+"','"+n[i]+"')");
			
		}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		}



}
