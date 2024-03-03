import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*;
 import java.sql.*;
 import java.io.*;
 import java.net.*;
 import java.util.*;

 public class networkserver extends JFrame 
 { 
 	
 	private JPanel contentPane;
   
	private dataconnect z;
	ResultSet rs;
	Connection cs;
	Statement st;
	Vector v,v1,v2;
	static ServerSocket sersoc;
	static Socket soc,soc1;
	ObjectInputStream dis,dis1;
	ObjectOutputStream dos,dos1;
	InputStream is;
	OutputStream os;
 	
  String n="",ip="";
  String a[]=new String[100];
 static networkserver m;
 int portno=5000,port;
 link find;
 int number;
 String bgp="127.0.0.1";
 	public networkserver()throws Exception
 	{ 
 		super(); 
		z = new dataconnect();
 	st=z.connect();
 		  st.execute("delete nodeinformation");
		   st.execute("delete connection");
		    st.execute("delete possiblepath");
			st.execute("delete pda");
   new connectnodes();
 		
 	} 
  
 	
 
  
 		
 	
 		
 		
  
 	
 	 
 	
	

	 
  
		
 
	public void listen()throws Exception
	 {
     
      int port=0;
	  dis=new ObjectInputStream(soc.getInputStream());
	  String request=(String)dis.readObject();
	System.out.println("recived:"+request);
	  if(request.equals("path"))
		 {
	
		   String nodes=(String)dis.readObject();
	  String array[]=nodes.split("&");
	  	  System.out.println("nodes:"+nodes);
         find= new link(array[0],array[1]);
		  rs=st.executeQuery("Select PortNo from nodeinformation where Status='ON' ");
				  if(rs.next())
			 {
		   rs=st.executeQuery("Select path from possiblepath where destination='"+array[1]+"' ");
		   v1=new Vector();
	  while(rs.next())
		 {
		 
		v1.add(rs.getString(1));
		 }
		 System.out.println(" v1"+v1);
			 }
System.out.println("send v1");

	  
			
				  
			 
			
		 System.out.println(" v1"+v1);
/*dos=new ObjectOutputStream(soc.getOutputStream());

dos.writeObject(v1);*/

			System.out.println(" v1 size"+v1.size());
		
		
			
			
			String path= find.bestcost(4,array[1]);
		
			
			 System.out.println("path:"+path);
			 

			 //-----------------------------------
 st.execute("delete possiblepath");
			st.execute("delete pda");
			  
         find= new link(array[2],array[1]);
		  rs=st.executeQuery("Select PortNo from nodeinformation where Status='ON' ");
				  if(rs.next())
			 {
		   rs=st.executeQuery("Select path from possiblepath where destination='"+array[1]+"' ");
		   v2=new Vector();
	  while(rs.next())
		 {
		 
		v2.add(rs.getString(1));
		 }
		 System.out.println(" v1"+v2);
			 }
System.out.println("send v2");

	  
			
				  
			 
			
		 System.out.println(" v2"+v2);
/*dos=new ObjectOutputStream(soc.getOutputStream());

dos.writeObject(v1);*/

			System.out.println(" v2 size"+v2.size());
		
		
			
			
			String path1= find.bestcost(4,array[1]);
		
			
			 System.out.println("path1:"+path1);
			 
			
System.out.println("send v1");
soc1=new Socket("127.0.0.1",5000);
dos1=new ObjectOutputStream(soc1.getOutputStream());
String ph=array[2]+"&"+path1;
dos1.writeObject(ph);	
dos1=new ObjectOutputStream(soc1.getOutputStream());
String ph1=array[0]+"&"+path;
dos1.writeObject(ph1);	
  dis1=new ObjectInputStream(soc1.getInputStream());
String result=(String)dis1.readObject();
System.out.println("result:"+result);
if(result.equals("yes"))
			 {

		dos=new ObjectOutputStream(soc.getOutputStream());

dos.writeObject(path);	 
			 }
			 else
			 {
dos=new ObjectOutputStream(soc.getOutputStream());

dos.writeObject("attacker");	
			 }
			 
		 }
		 else if(request.equals("portno"))
		 {
 String nodes=(String)dis.readObject();
	  
	  	  System.out.println("nodes:"+nodes);
       
		   rs=st.executeQuery("Select PortNo from nodeinformation where NodeName='"+nodes+"' ");
		   
	  if(rs.next())
		 {
		 //System.out.println("p:"+rs.getString(1));
		 port=Integer.parseInt(rs.getString(1));
		 }
	 rs=st.executeQuery("Select SystemName from nodeinformation where NodeName='"+nodes+"' ");
		   
	  if(rs.next())
		 {
		 ip=rs.getString(1);
		 }
dos=new ObjectOutputStream(soc.getOutputStream());

 String p=String.valueOf(port);
 System.out.println("p:"+p);
 System.out.println("ip:"+ip);
dos.writeObject(p);
dos.writeObject(ip);
System.out.println("send 1");
	
		 }
else if(request.equals("port"))
		 {
		
	  System.out.println("1");
	  String nodes=(String)dis.readObject();
	  
	  	  System.out.println("nodes:"+nodes);
       
		   rs=st.executeQuery("Select PortNo from nodeinformation where NodeName='"+nodes+"' ");
		   
	  if(rs.next())
		 {
		 //System.out.println("p:"+rs.getString(1));
		 port=Integer.parseInt(rs.getString(1));
		 }
	 rs=st.executeQuery("Select SystemName from nodeinformation where NodeName='"+nodes+"' ");
		   
	  if(rs.next())
		 {
		 ip=rs.getString(1);
		 }
dos=new ObjectOutputStream(soc.getOutputStream());

 String p=String.valueOf(port);
 System.out.println("p:"+p);
 System.out.println("ip:"+ip);
dos.writeObject(p);
dos.writeObject(ip);
System.out.println("send 1");
	
			
		 }
		 else if(request.equals("neighbours"))
		 {
			 Vector nv=new Vector();
			 dis=new ObjectInputStream(soc.getInputStream());
 String neigh=(String)dis.readObject();
       rs=st.executeQuery("Select Neighbour from Connection where NodeName='"+neigh+"'");
	  while(rs.next())
		 {
		  nv.addElement(rs.getString(1));
		 }
dos=new ObjectOutputStream(soc.getOutputStream());

dos.writeObject(nv);
		 }
		 else if(request.equals("path1"))
		 {
			 Vector nv1=new Vector();
			// dis=new ObjectInputStream(soc.getInputStream());
 String neigh1=(String)dis.readObject();
       rs=st.executeQuery("Select Neighbour from Connection where NodeName='"+neigh1+"'");
	  while(rs.next())
		 {
		  nv1.addElement(rs.getString(1));
		 }
dos=new ObjectOutputStream(soc.getOutputStream());

dos.writeObject(nv1);

		 }
		  else if (request.equals("exit"))
		 {
			  dis=new ObjectInputStream(soc.getInputStream());
			String nn=(String)dis.readObject();
			 System.out.println("z:"+nn);
			 
			st.executeUpdate( "update nodeinformation set PortNo='0' where NodeName='"+nn+"'" );

		 }

else if(request.equals("user"))
		 {
	
	dis=new ObjectInputStream(soc.getInputStream());
	System.out.println("1");
 String details=(String)dis.readObject();
 System.out.println("2");
String z[]=details.split("&");
System.out.println("3");
 rs=st.executeQuery("Select PortNo from nodeinformation where NodeName='"+z[0]+"' ");
		   
	  if(rs.next())
		 {
		 //System.out.println("p:"+rs.getString(1));
		 number=Integer.parseInt(rs.getString(1));
		 }
		 if(number==0)
			 {
st.executeUpdate( "update nodeinformation set PortNo='"+z[2]+"' where NodeName='"+z[0]+"'" );
System.out.println("4");
st.executeUpdate( "update nodeinformation set SystemName='"+z[1]+"' where NodeName='"+z[0]+"'" );
System.out.println("5");
			 }
			 else
			 {
System.out.println(number);
			 }

//dos=new ObjectOutputStream(soc.getOutputStream());
// port=port+1;
 
System.out.println("8");
		 }
         else
		 {
	 dos=new ObjectOutputStream(soc.getOutputStream());
portno=portno+1;

 String p=String.valueOf(portno);
 System.out.println("p:"+p);


 
	 dos.writeObject(p);
	
System.out.println("send");
		 }
	 }
	 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
 //============================= Testing ================================// 
 //=                                                                    =// 
 //= The following main method is just for testing this class you built.=// 
 //= After testing,you may simply delete it.                            =// 
 //======================================================================// 
 	public static void main(String[] args) 
 	{ 
 		JFrame.setDefaultLookAndFeelDecorated(true); 
 		JDialog.setDefaultLookAndFeelDecorated(true); 
 		try 
 		{ 
			
			sersoc=new ServerSocket(1500);
			m=new networkserver();
			while(true)
			{
			soc=sersoc.accept();
			m.listen();
			} 
 			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
 		} 
 		catch (Exception ex) 
 		{ 
 			System.out.println("Failed loading L&F: "); 
 			System.out.println(ex); 
 		} 
 		
 	} 
 //= End of Testing = 
  
  
 } 