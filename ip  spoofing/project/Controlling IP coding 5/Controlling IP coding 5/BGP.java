import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
public class BGP extends JFrame
{
	static ServerSocket sersoc;
	static Socket soc;

 	
 	private JPanel contentPane;
   
	private dataconnect z;
	

	ObjectInputStream dis;
	ObjectOutputStream dos;
	InputStream is;
	OutputStream os;
 	
static BGP m;
 
 int number;
 	public BGP()throws Exception
 	{ 
 		super(); 
		
 		
 	} 
  
 	
 
  
 		
 	
 		
 		
  
 	
 	 
 	
	

	 
  
		
 
	public void listen()throws Exception
	 {
     
     System.out.println("recived1");
	  dis=new ObjectInputStream(soc.getInputStream());
	  System.out.println("recived2");
	  String nname=(String)dis.readObject();
	System.out.println("recived:"+nname);
	 String z1[]=nname.split("&");
dis=new ObjectInputStream(soc.getInputStream());
	   nname=(String)dis.readObject();
	String z2[]=nname.split("&");
	String z1path=z1[1];
   String z2path=z2[1];
      String result=IDPFMatching(z1path,z2path);
		   dos=new ObjectOutputStream(soc.getOutputStream());
		   dos.writeObject(result);
	 
	 
	 }
  
  
  
  
  
  
  
  public String IDPFMatching(String z1p,String z2p)throws Exception
	{
String zp1=z1p;
String zp2=z2p;
String result="";
if(zp1.equals(zp2))
		{
result="yes";
		}
else
		{
result="no";
		}
return result;
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
			
			sersoc=new ServerSocket(5000);
			m=new BGP();
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


