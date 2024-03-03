import java.io.*;
import javax.swing.*;
import java.awt.event.*;


class receivedata extends JFrame implements ActionListener
{

	
	
    JButton jButton1;
	JButton jButton2;
	
	

		JPanel panel=new JPanel();
	static JTextArea text=new JTextArea();
JScrollPane pane=new JScrollPane(text);


	public receivedata(int f)throws Exception
	{
		jButton1=new JButton();
	    jButton2=new JButton();
		jButton1.setText("Clear");
		jButton2.setText("Cancel");
        panel.setLayout(null);
		panel.add(pane);
		panel.add(jButton1);
		panel.add(jButton2);
		pane.setBounds(5,5,390,350);
		jButton1.setBounds(75,400,100,25);
		jButton2.setBounds(200,400,100,25);
		add(panel);
		
		
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		setSize(400,500);
        setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==jButton1)
			{
				text.setText("");
				
			}
			if(e.getSource()==jButton2)
			{
		     dispose();
			}

		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

		
	}
	
}
