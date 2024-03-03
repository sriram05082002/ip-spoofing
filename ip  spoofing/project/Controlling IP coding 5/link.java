

import java.sql.*;
import java.util.*;

public class link
{
	private dataconnect DB;
	private Statement st;
	private ResultSet rs;
	private String printPath = "";
	private int index = -1;
	private String stack[] = new String[100];
	private boolean flip = true,flip1 = true, flip2 = false;
	public static  Vector <String> vPathWeigth = new Vector<String>();
	private int weight = 0;
	private static String  strDest = "";
	private static String  strStart= ""; 
	
	public link( String start,String strDst )
	{
		try
		{
			DB= new dataconnect();
			st=DB.connect();

			
			strDest = strDst;
			strStart = start;
			flip = true;
			flip1 = true;
			flip2 = false;
				
			index = -1;
			weight = 0;
			getPath( start );

	   }
		catch( Exception e )
		{
			e.printStackTrace( );
		}  
	}
	

	public void getPath( String start )
	{
	  try
		{

		  st=DB.connect();

		  rs = st.executeQuery( "select * from connection where nodename like '"+start.trim( )+"'");

		
		 while( rs.next( ) )
		 {
			flip2  = true;
			if( flip == false )
			{
				for( int i=0;i < index;i++ )
				{
					stack[i] = stack[i+1];
				}
				index--;
				flip = true;
			}
			
			String check = rs.getString( 2 );
			
			String strarray[ ] = strStart.split( ">" );
			
			for( int i=0;i < strarray.length;i++ )
			{
				if( strarray[i].equalsIgnoreCase( check ))
				{
					flip1 = false;
				}
			}
			
			if( flip1 == true )
			{
				stack[ ++index ] = strStart + ">" + check;
			}
			
			flip1 = true;
		}   // end of while loop

		if( flip2 == true )
		{
			flip2 = false;
			for( int i = 0;i <= index;i++ )
			{
				findNode( stack[i] );
			}
		}
		else
		{
			for( int i = 0; i < index; i++ )
			{
				stack[ i ] = stack[ i+1 ];
			}
			index--;
			flip2 = true;
			findNode( stack[0] );
		}
		
		}catch( Exception e ) { e.printStackTrace( ); }

}

public void findNode( String nodePath )
{
	  strStart = nodePath;
	
	  int end = nodePath.lastIndexOf(">");
	 
      if(nodePath.substring(end + 1).equals(strDest))
	  {
		findWeight( nodePath );
		if( index != 0 )
		{
		  for( int i = 0; i <= index; i++ )
		  {
			stack[i] = stack[i+1];
		  }
		   index--;
		   flip = true;
		   strStart = stack[0];
		   findNode( stack[0] );
		}
	 }
	else
	{
	  flip = false;
	  getPath( nodePath.substring(end + 1) );

	}
}

	public void findWeight( String nodePath )
	{
		
		String[ ] strArray = nodePath.split(">");
		
		try
		{
			for( int i = 0;i < strArray.length-1;i++ )
			{
				st=DB.connect();
				rs = st.executeQuery("select * from connection where nodename  = '"+strArray[i].trim( )+"' and neighbour = '"+strArray[i+1].trim()+"'");
			
				while( rs.next( ))
				{
					weight += rs.getInt(3);
				}
			 }
			
			String pathweight =nodePath+"#"+weight;
			
if(rs.next())
			{
				System.out.println( "Already Exist" );
			}
           else
			{
			st.executeUpdate( "insert into possiblepath values( '"+strDest+"','"+nodePath+"',"+weight+",'0.0' )" );
			
			//limit = 0;
			weight = 0;
			}           
		
			vPathWeigth.add(pathweight);
			
		}	
		catch( Exception e )
		{
			e.printStackTrace( );
		}
	}



public String  bestcost(int f,String n)throws Exception
	{
float s1[]=new float[100];
	String s[]=new String[100];
	String path="";
	int i=0;
	
		if(f==4)
		{
			limit a = new limit();
			a.getval();
			rs = st.executeQuery("select * from pda where node='"+n+"' order by cost,delay ");
		}

			
				if( rs.next( ))
				{
					
					s[i]=rs.getString(1);
					
					s1[i]=Float.parseFloat(rs.getString(2));
					
				
					i++;
				}


				if(i==1)
		{
           path=s[0];
		   
		 
		}
		else
		{
				float z=s1[0];
                  path=s[0];
				for(int k=0;k<i-1;k++)
		
		{
		
            if(z>s1[k])
			{
				System.out.println("bestlimit:"+k);
				System.out.println("bestpath:"+s[k]);
				path=s[k];
				z=s1[k];
				
			}
		}
		 
		}
		
		return path;
	}
}
  		
			
		