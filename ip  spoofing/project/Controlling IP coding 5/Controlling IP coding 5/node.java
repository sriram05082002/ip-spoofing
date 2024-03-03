import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
 import javax.swing.border.*;



public class node extends JFrame
{
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTabbedPane jTabbedPane1;
	private JPanel contentPane;
	private JTextField jTextField1,sourcefield;
	private JTextField jComboBox1;
	private JTextPane jTextPane1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane5;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton5;
	private JTextArea sarea;
	
	private JPanel jPanel1;
	
	private JLabel jLabel5;
	private JTextPane jTextPane2;
	private JScrollPane jScrollPane2;
	private JButton jButton4;
	private JPanel jPanel2;

	String user,substr;
	String desdir,path1="";
	File f;
	String file;
	String msg,request1,port;
	String path,name[],guid;
	static node c;
Vector v1,d1;
int p,gui;
static ServerSocket sers;
static Socket sousoc1,soc;
ObjectInputStream osi;
ObjectOutputStream oso;
String sourcename,desname;

	networkname net=new networkname();
String server=net.orgin();

userlogin u;
		Font font = new Font("TimesRoman",Font.PLAIN,20);
receivedata rd;
	public node()throws Exception
	{
		super();
	
		
    }

	
	public void initializeComponent()
	{
		
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jTabbedPane1 = new JTabbedPane();
		contentPane = (JPanel)this.getContentPane();
		
		jTextField1 = new JTextField();
		sarea = new JTextArea();
		jComboBox1 = new JTextField();
		jTextPane1 = new JTextPane();
		jScrollPane1 = new JScrollPane();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jButton3 = new JButton();
		
		jPanel1 = new JPanel();
	
		jPanel2 = new JPanel();
		jLabel5 = new JLabel();
		
		sourcefield = new JTextField();
		
		jButton5 = new JButton();
		jScrollPane5 = new JScrollPane(sarea);
		
		
		
		jLabel2.setText("Source Name");
		
		
		jLabel3.setText("Data Details");
		
		jLabel1.setText("Destination Name");
		
		jLabel4.setText("Browse File");
		
		
		
		
		
		contentPane.setLayout(null);
		
		addComponent(contentPane, jPanel1, 0,0,543,500);
		
		jTextField1.setText("");
		jTextField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jTextField1_actionPerformed(e);
			}

		});
		
		
		
		
		jTextPane1.setText("");
		
		jScrollPane1.setViewportView(jTextPane1);
		
		jButton1.setText("Browse File");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				File f2;
				try{
		        System.out.println("\n LP file choose_actionPerformed(ActionEvent e) called.");
		        JFileChooser jf=new JFileChooser();
		        int m1=jf.showOpenDialog(null);				
				if(m1==JFileChooser.APPROVE_OPTION)
				{
				
				   f2=jf.getSelectedFile();
				   path=f2.getPath();
				   FileInputStream fis=new FileInputStream(path);
				   File f=new File(path); 
	               jTextField1.setText(path); 
	               byte blp[]=new byte[fis.available()];
	               fis.read(blp);			
			       msg=new String(blp);
			       jTextPane1.setText(msg);
		        }
		        }
				catch(Exception e1)
				{
					e1.printStackTrace();
				}

				

				jButton1_actionPerformed(e);
			}

		});
		
		jButton2.setText("Send");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
		soc=new Socket(server,1500);
		oso=new ObjectOutputStream(soc.getOutputStream());
		String sname=sourcefield.getText();
		String desname=jComboBox1.getText();
		oso.writeObject("path");
	    oso.writeObject(sourcename+"&"+desname+"&"+sname);
		osi=new ObjectInputStream(soc.getInputStream());
		String result=(String)osi.readObject();
		System.out.println("result:"+result);
		
		if(result.equals("attacker"))
					{
		   JOptionPane.showMessageDialog(null,"You are IP Spoofing Attacker");
					}
					else
					{
	   String node[]=result.split(">");
	   for(int z=1;z<node.length;z++)
						{
		   if(z==(node.length)-1)
							{
substr=node[z];

							}
							else
							{
substr=node[z]+">";
							}
						}
			  System.out.println(":"+node[1]);
			   System.out.println("substr:"+substr);
soc=new Socket(server,1500);
	   oso=new ObjectOutputStream(soc.getOutputStream());
	   System.out.println("2");
	   oso.writeObject("port");
	    oso.writeObject(node[1]);
		 System.out.println("3");
	    osi=new ObjectInputStream(soc.getInputStream());
           String num=(String)osi.readObject();
		   String ip=(String)osi.readObject();
		  
               System.out.println("port:"+num);
			   System.out.println("ip:"+ip);
			   int port =Integer.parseInt(num);
			   String data=jTextPane1.getText();
			   soc=new Socket(ip,port);
	   oso=new ObjectOutputStream(soc.getOutputStream());
	    oso.writeObject(substr);
		oso.writeObject(data);
osi=new ObjectInputStream(soc.getInputStream());
           num=(String)osi.readObject();
		   System.out.println("num:"+num);
		   
       
					}
		
		   jTextPane1.setText("");
			
			
				}
				

		 
					
				
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				jButton2_actionPerformed(e);

			}

		});
		
		jButton3.setText("Leave");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jButton3_actionPerformed(e);
			}

		});
		
		
		jPanel1.setLayout(null);
	
		addComponent(jPanel1, jLabel2, 25,100,100,25);
		addComponent(jPanel1, jLabel3, 50,230,100,25);
	    addComponent(jPanel1, jLabel4, 25,50,100,25);
		  
		addComponent(jPanel1, jTextField1, 144,50,180,25);
        addComponent(jPanel1,sourcefield, 144,100,100,25);
		addComponent(jPanel1, jLabel1, 25,150,100,25);
        addComponent(jPanel1,jComboBox1, 144,150,100,25);
		addComponent(jPanel1, jScrollPane1, 50,250,350,200);
		addComponent(jPanel1, jButton1, 410,50,100,25);
		addComponent(jPanel1, jButton2, 410,100,100,25);
		addComponent(jPanel1, jButton3, 410,150,100,25);
	addComponent(jPanel1, jButton5, 410,300,125,25);
	
		Border etched=BorderFactory.createEtchedBorder();
		Border border=BorderFactory.createTitledBorder(etched,"Node Frame",TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,font,Color.blue);
		jLabel5.setText("Received Data");
		
		
		
		

jButton5.setText("Received Data");
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					new receivedata(1);
				}
				catch (Exception ex)
				{
				}
				
				
			}

		});
		
		//jPanel1.setBackground(new Color(85, 85, 155)); 
		jPanel1.setBorder(border);
		this.setTitle("Node :    "+sourcename );
		this.setLocation(new Point(2, 0));
		this.setSize(new Dimension(550, 500));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	public int connection()throws Exception
	{
sousoc1=new Socket(server,1500);
 oso=new ObjectOutputStream(sousoc1.getOutputStream());
	 

	
	   oso.writeObject("hai");
	   
	   osi=new ObjectInputStream(sousoc1.getInputStream());
	   port=(String)osi.readObject();
	
	   System.out.println("port:"+port);
	
	   p=Integer.parseInt(port);
	  
	   return p;

	}

	public void user(String username)throws Exception
	{
	sousoc1=new Socket(server,1500);
	oso=new ObjectOutputStream(sousoc1.getOutputStream());
 oso.writeObject("user");
 sourcename=username;
  String ia=InetAddress.getLocalHost().getHostName();
 oso=new ObjectOutputStream(sousoc1.getOutputStream());
 oso.writeObject(username+"&"+ia+"&"+String.valueOf(p));
	    System.out.println("username:"+username);
		
		
	}

	private void jTabbedPane1_stateChanged(ChangeEvent e)
	{
		System.out.println("\njTabbedPane1_stateChanged(ChangeEvent e) called.");
		// TODO: Add any handling code here

	}

	private void jTextField1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njTextField1_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	

	private void jButton1_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
		
	}

	private void jButton2_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		
	}


private void jButton3_actionPerformed(ActionEvent e)
	{
		System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here
		try
		{
			soc=new Socket(server,1500);
			oso=new ObjectOutputStream(soc.getOutputStream());
		 oso.writeObject("exit");
		 System.out.println("1");
	  oso=new ObjectOutputStream(soc.getOutputStream());
       oso.writeObject(sourcename);
	   System.out.println("2");
dispose();
		}
		catch (Exception z)
		{
		}
		 
	}







public void receiver()throws Exception
	{
 osi=new ObjectInputStream(u.ss1.getInputStream());
	  String request=(String)osi.readObject();
	  // String sname=(String)osi.readObject();
		//System.out.println("recived:"+sname);
	System.out.println("recived1:"+request);
	String requestres[]=request.split(">");
	if(requestres[0].equals(sourcename))
		{
		System.out.println("rec");

		request1=(String)osi.readObject();
	   System.out.println("rec");
		rd.text.setText(request1);
		System.out.println("rec");
		}
		
		

		else
		{
			request1=(String)osi.readObject();
	   
		
String node[]=request.split(">");
for(int z=1;z<node.length;z++)
						{
	 if(z==(node.length)-1)
							{
		 substr=node[z];
							}
							else
							{
substr=node[z]+">";
							}
						}
			 
			  System.out.println(":"+node[1]);
			   System.out.println("substr:"+substr);
 soc=new Socket(server,1500);
	   oso=new ObjectOutputStream(soc.getOutputStream());
	   System.out.println("2");
	   oso.writeObject("port");
	    oso.writeObject(node[1]);
		 System.out.println("3");
	    osi=new ObjectInputStream(soc.getInputStream());
           String num=(String)osi.readObject();
		   String ip=(String)osi.readObject();
		  
               System.out.println("port:"+num);
			   System.out.println("ip:"+ip);
			   int port =Integer.parseInt(num);
			   soc=new Socket(ip,port);
	   oso=new ObjectOutputStream(soc.getOutputStream());
	    oso.writeObject(substr);
		oso.writeObject(request1);
osi=new ObjectInputStream(soc.getInputStream());
           num=(String)osi.readObject();
		   System.out.println("num:"+num);
		   
		}
		oso=new ObjectOutputStream(u.ss1.getOutputStream());
oso.writeObject("received");
		}





}
