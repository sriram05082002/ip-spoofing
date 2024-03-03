 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 
 import java.net.*;
 /** 
  * Summary description for userlogin 
  * 
  */ 
 public class userlogin extends JFrame 
 { 
	 public static ServerSocket ssoc1;

	public static Socket sousoc1,ss1;
 	// Variables declaration 
 	private JLabel userlabel; 
 	private JLabel jLabel2; 
 	private JLabel jLabel3; 
 	private JLabel jLabel4; 
 	private JLabel jLabel5; 
 	private JTextField userfield; 
 	private JPasswordField jPasswordField1; 
 	private JButton userlogin; 
 	private JButton clear; 
 	private JPanel contentPane; 
 	// End of variables declaration 
static   node pe1;
  public static String username="";
  static int n;
 	public userlogin() throws Exception
 	{ 
 		super(); 
 		initializeComponent(); 
 		
         
 		this.setVisible(true); 
 	} 
  
 	
 	private void initializeComponent() 
 	{ 
 		userlabel = new JLabel(); 
 		jLabel2 = new JLabel(); 
 		jLabel3 = new JLabel(); 
 		jLabel4 = new JLabel(); 
 		jLabel5 = new JLabel(); 
 		userfield = new JTextField(); 
 		jPasswordField1 = new JPasswordField(); 
 		userlogin = new JButton(); 
 		clear = new JButton(); 
 		contentPane = (JPanel)this.getContentPane(); 
  
 		// 
 		// userlabel 
 		// 
 		userlabel.setHorizontalAlignment(SwingConstants.CENTER); 
 		userlabel.setHorizontalTextPosition(SwingConstants.CENTER); 
 		userlabel.setText("UserName"); 
 		// 
 		
 	
 	
 
 		
 		jLabel3.setIcon(new ImageIcon("1.Bitmap"));
 		// 
 		// userfield 
 		// 
 		userfield.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				userfield_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// jPasswordField1 
 		// 
 		jPasswordField1.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				jPasswordField1_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// userlogin 
 		// 
 		userlogin.setText("userlogin"); 
 		userlogin.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				userlogin_actionPerformed(e); 
 			} 
  
 		}); 
 		// 
 		// clear 
 		// 
 		clear.setText("Clear"); 
 		clear.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) 
 			{ 
 				clear_actionPerformed(e); 
 			} 
  
 		}); 
 		
 		contentPane.setLayout(null); 
 		contentPane.setBackground(new Color(125, 155, 155)); 
 		addComponent(contentPane, userlabel, 76,100,70,18); 
 		addComponent(contentPane, jLabel3, 50,0,100,200); 
 		//addComponent(contentPane, jLabel5, -1,203,495,31); 
 		addComponent(contentPane, userfield, 202,100,100,25); 
 		addComponent(contentPane, userlogin, 50,170,100,28); 
 		addComponent(contentPane, clear, 170,170,100,28); 
 		
 		this.setTitle("Peer userlogin"); 
 		this.setLocation(new Point(19, 37)); 
 		this.setSize(new Dimension(400, 250)); 
 		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
 		this.setResizable(false); 
 	} 
  
 	/** Add Component Without a Layout Manager (Absolute Positioning) */ 
 	private void addComponent(Container container,Component c,int x,int y,int width,int height) 
 	{ 
 		c.setBounds(x,y,width,height); 
 		container.add(c); 
 	} 
  
 	// 
 	// TODO: Add any appropriate code in the following Event Handling Methods 
 	// 
 	private void userfield_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nuserfield_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void jPasswordField1_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\njPasswordField1_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void userlogin_actionPerformed(ActionEvent e) 
 	{ 
		try
		{
			username=userfield.getText();
			

System.out.println("server port:"+n);
		
		pe1.user(username);
	pe1.initializeComponent();
        dispose();
		
			
			
		}
		catch (Exception e1)
		{
		}
		
 		System.out.println("\nuserlogin_actionPerformed(ActionEvent e) called."); 
 		// TODO: Add any handling code here 
  
 	} 
  
 	private void clear_actionPerformed(ActionEvent e) 
 	{ 
 		System.out.println("\nclear_actionPerformed(ActionEvent e) called."); 
 		
  userfield.setText("");
 	} 
  
 	// 
 	// TODO: Add any method code to meet your needs in the following area 
 	// 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
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
 pe1=new node();
		new userlogin(); 
		
		n=pe1.connection();
		System.out.println("server port:"+n);
ssoc1=new ServerSocket(n);
		while(true)
		{
		ss1=ssoc1.accept();

		pe1.receiver();
		}
			
	
 		} 
 		catch (Exception ex) 
 		{ 
 			System.out.println("Failed loading L&F: "); 
 			System.out.println(ex); 
 		} 
 		
		
		
		
		
		
	
 	} 

  
  
 } 
  
 