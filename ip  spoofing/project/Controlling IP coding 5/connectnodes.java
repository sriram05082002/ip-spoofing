 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*;
 import java.sql.*;
 import java.util.*;
 import java.net.*;
 import java.io.*;
 import javax.swing.border.*;

 public class connectnodes extends JFrame 
 { 
 	// Variables declaration 
 	private JLabel jLabel1; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4,jLabel5; 
 	private JTextField jTextField1; 
	private JComboBox jComboBox1; 
 	private JComboBox jComboBox2; 
    private JTextField jTextField5; 
 	
 	private JButton jButton1; 
 	private JButton jButton2; 
	private JButton jButton3; 
	private JButton jButton4,jButton5; 
 	private JPanel contentPane; 
	private JPanel panel;
	public Runtime r;
	int n;
	int i=0;
	int portno;
	String nodename = "",node,des;
	String sysname = "";
	ResultSet rs;
	Connection cs;
	Statement st;
		Font font = new Font("TimesRoman",Font.PLAIN,20);
public Vector  totalpeer = new Vector();
 	// End of variables declaration 
  
  
 	public connectnodes() 
 	{ 
 		super(); 
		
	
 		initializeComponent(); 
 		
 		this.setVisible(true); 
 	} 
  
 	 
 	public void initializeComponent() 
 	{ 
 		jLabel1 = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
		jLabel5 = new JLabel(); 
		panel=new JPanel();
 		jTextField1 = new JTextField(); 
 		
		jTextField5 = new JTextField(); 
 	    jButton1 = new JButton(); 
 		jButton2 = new JButton(); 
			jButton3 = new JButton(); 
				jButton4 = new JButton(); 
				jButton5 = new JButton(); 
				jComboBox1 = new JComboBox(totalpeer); 
 		jComboBox2 = new JComboBox(totalpeer); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		
 		jLabel2.setText("Peer Name"); 
 		
 		
		jLabel3.setText("Source Node"); 
 		
 		
 		jLabel4.setText("Neighbour Node"); 
		jLabel5.setText("Enter no of Nodes"); 
 		
		
 		jButton1.setText("Submit"); 
 		jButton1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{
				
				if(i<=n)
				
		{
		jButton1_actionPerformed(e); 
			if(i==n-1)
			{
				connect();
				
  
				
				jComboBox1.setEnabled(true);
				jComboBox2.setEnabled(true);
				jButton1.setEnabled(false);
				jTextField1.setEnabled(false);
			}
 				
				i++;
		}
			
		
 			} 
 		}); 
 		
 		jButton2.setText("Clear"); 
 		jButton2.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				jTextField1.setText("");
			    jComboBox1.setSelectedItem("Select");
				jComboBox2.setSelectedItem("Select");
 				
 			} 
  
 		}); 
		jButton4.setText("Ok"); 
 		jButton4.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				try
				{
					String nodecount=jTextField5.getText();
				n=Integer.parseInt(nodecount);
				System.out.println("n:"+n);
				if(n!=0)
				{
					
				
				
				jTextField1.setEnabled(true);
				
				jButton1.setEnabled(true);
				
						jTextField5.setEnabled(false);
										jButton4.setEnabled(false);



				}
				}
				catch (Exception e1)
					{
					JOptionPane.showMessageDialog(null,"Please Enter Value");
				}
				
				
			
 				
 			} 
  
 		}); 
		jButton3.setText("Cancel"); 
 		jButton3.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
				dispose(); 				
 			} 
  
 		}); 

jButton5.setText("Connection"); 
 		jButton5.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
						jButton5_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// contentPane 
 		// 

			
		jTextField1.setEnabled(false);
				jComboBox1.setEnabled(false);
				jComboBox2.setEnabled(false);
				jButton1.setEnabled(false);
				
 		contentPane.setLayout(null); 
		 		panel.setLayout(null); 

 	
 	
 		addComponent(contentPane,panel, -5,-5,550,400); 
		addComponent(panel, jLabel2, 65,100,100,25); 
 		addComponent(panel, jLabel3, 65,150,100,25); 
 		addComponent(panel, jLabel4, 65,200,100,25); 
		addComponent(panel, jTextField1, 204,100,100,25); 
 		addComponent(panel, jComboBox1, 204,150,100,25); 
 		addComponent(panel,jComboBox2, 203,200,100,25); 
		addComponent(panel, jButton1, 400,85,100,25); 
 		addComponent(panel, jButton2, 400,120,100,25); 
		addComponent(panel, jButton3, 400,155,100,25); 
		addComponent(panel, jButton5, 400,190,100,25); 
        addComponent(panel, jLabel5, 65,50,100,25); 
 	    addComponent(panel,jTextField5, 203,50,100,25); 
 		addComponent(panel, jButton4, 400,50,100,25); 
 	    panel.setBackground(new Color(255,255,255));
		Border etched=BorderFactory.createEtchedBorder();
		Border border=BorderFactory.createTitledBorder(etched,"Node Registration",TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,font,Color.red);
		panel.setBorder(border);
 		this.setTitle("Network Construction"); 
 		this.setLocation(new Point(100, 100)); 
 		this.setSize(new Dimension(550, 400)); 
 		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
 		this.setResizable(false); 
 	} 
  
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	} 
  
 	
 	
 	
  
 	private void jButton1_actionPerformed(ActionEvent e) 
 	{ 

	
			nodename = jTextField1.getText();
			
			try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cs=DriverManager.getConnection("jdbc:odbc:server");
			st=cs.createStatement();
			rs= st.executeQuery("select * from NodeInformation where NodeName LIKE '"+nodename+"' ");  //OR SystemName LIKE '"+sysname+"'
            if(rs.next())
            {
            	JOptionPane.showMessageDialog(this,"The given Data already Exists");
				i--;
            }
            else
            	{	String query = "insert into NodeInformation values('"+nodename+"','0','192.168.1.4','ON')";
            		st.execute(query);	
            		JOptionPane.showMessageDialog(this,"Registration  Sucess fully Completed");
					jTextField1.setText("");
				   
            	  }
			}
			catch(Exception ee)
				{
				JOptionPane.showMessageDialog(this,"Specify the Correct PortNo");
				System.out.println("Connectivity Error");
				ee.printStackTrace();
				i--;
				}
				
				
			} 
  
 	private void jButton5_actionPerformed(ActionEvent e) 
 	{ 
		try
		{
			
		
		node = (String)jComboBox1.getSelectedItem();
		 des = (String)jComboBox2.getSelectedItem();
		
			System.out.println(""+node);
			System.out.println(""+des);
		
			if(node.equals("Select")||des.equals("Select"))
		{
			JOptionPane.showMessageDialog(this,"Specify the Nodes");
			}
			else if (node.equals(des))
			{
				JOptionPane.showMessageDialog(this,"Specify a Valid Neighbour");
			}
			
			else
		{
		

			try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cs=DriverManager.getConnection("jdbc:odbc:server");
			st=cs.createStatement();
			rs= st.executeQuery("select * from Connection where NodeName LIKE '"+node+"' AND Neighbour LIKE '"+des+"'");  //OR SystemName LIKE '"+sysname+"'
            System.out.println("1");
			if(rs.next())
            {
            	JOptionPane.showMessageDialog(this,"The given Data already Exists");
           }
            else
            	{
				
				String query = "insert into Connection values('"+node+"','"+des+"','1','0')";
				String query1= "insert into Connection values('"+des+"','"+node+"','1','0')";
				
            		st.executeUpdate(query);	
					
					st.executeUpdate(query1);

            		JOptionPane.showMessageDialog(this,"Connection Information Completed");
            	}
			}
			catch(SQLException ee)
				{
				JOptionPane.showMessageDialog(this,"Connectivity Error");
				System.out.println("Connectivity Error");
				ee.printStackTrace();
				}

  
 	} 
		}
		
		catch (Exception e3)
		{
			JOptionPane.showMessageDialog(this,"Exception");
			e3.printStackTrace();
			
		}

		}
  public Vector connect()
 {
     
     try
     {
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		 cs=DriverManager.getConnection("jdbc:odbc:server");
		 st=cs.createStatement();
         ResultSet rs=st.executeQuery("select NodeName from NodeInformation");
  		 totalpeer.add("Select");
		
         while(rs.next())
    	 {
		    totalpeer.addElement(rs.getString(1).trim());
			System.out.println(""+totalpeer);
         }
	 }
     catch (Exception ex)
     {
	   ex.printStackTrace();
     }
     return totalpeer;
  }
 	
  

	 
	
  
   

  
  
 } 