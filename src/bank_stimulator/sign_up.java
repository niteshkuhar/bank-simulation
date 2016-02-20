package bank_stimulator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComboBox;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class sign_up extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	File f;
	String acc;
	boolean img=false;
	int i=1;
	 JLabel lblimg = new JLabel("xxxxx");
	public static void main(String[] args) {
		//login.visible();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_up frame = new sign_up();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sign_up() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblGender = new JLabel("Gender:");
		
		JLabel lblMobile = new JLabel("Mobile:");
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		
		JLabel lblSequirityQuestion = new JLabel("Sequirity Question:");
		
		JLabel lblAnswer = new JLabel("Answer:");
		
		final JCheckBox chckbxIAgreTo = new JCheckBox("I agree to Terms And Condition Mention ");
		
		final JButton btnConfirm = new JButton("Confirm");
		
		JButton btnClear = new JButton("Clear");
		
	final JRadioButton rdbtnMale = new JRadioButton("Male");
		
		final JRadioButton rdbtnFemale = new JRadioButton("Female");
	ButtonGroup group=new ButtonGroup();
	group.add(rdbtnMale);
	group.add(rdbtnFemale);	
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("Your Native Place?");
		comboBox.addItem("Your Mother toungue?");
		comboBox.addItem("Your Mother's Native place?");
		comboBox.addItem("Which year is your favourite?");
		comboBox.addItem("Your Secret code?");
	//	JButton btnConfirm = new JButton("Confirm");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*dispose();
				sign_up frame=new sign_up();
				frame.setVisible(true);*/
				textField.setText("");
				textField_1.setText("");
				//textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
			chckbxIAgreTo.setSelected(false);
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				
				}
				});
	/*	image ob=new image();
		String ar[]={};
		ob.main(ar);
		*/
			
	
		
		btnConfirm.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	
		try{
			
		
		 final String name=textField.getText().trim();
			final String pass=passwordField.getText();
			final String pass1=passwordField_1.getText();
			final String que=(String) comboBox.getSelectedItem();
			final String ans=textField_3.getText();
			final String mob=textField_1.getText().trim();
			final String ag=textField_4.getText().trim();
			double ag1=Double.parseDouble(ag);
			double mob1=Double.parseDouble(mob);
			String gen="";
		//	File path="C:\Users\KUHAR\Desktop\man.jpg";
	
		if(rdbtnMale.isSelected())
			{
			gen=rdbtnMale.getText();
			//rdbtnFemale.setSelected(false);
			}
		if(rdbtnFemale.isSelected())
		{
				gen=rdbtnFemale.getText();	
			//	rdbtnMale.setSelected(false);
		}
				if(pass.equals(pass1) && (mob.length()==10) && name.length()!=0 &&ag.length()>0&& ag1>0&& ag1<100 &&que.length()!=0&&ans.length()!=0
					&& chckbxIAgreTo.isSelected()&&(rdbtnMale.isSelected()||rdbtnFemale.isSelected()))
			{
					
					
					
					
					sqlquery obnew=new sqlquery();
					 acc=obnew.genarateAcc();
					//textField.setText(acc);
					obnew.insert(acc,pass,name,gen,ag,que,ans,mob);
					obnew.createtable(acc);
						JOptionPane.showMessageDialog(btnConfirm, "Saved.Your Acc No is :'"+acc+"'.  Note it down for further use.");
					
					
					if(img)
					{
						String s="sign_up_images/demo"+(i-1)+".jpg";
						//String s="/"+f;
						
						//An Empty FILE length in string is 4.(Do not know why).
				
						String output="sign_up_images/"+acc+".jpg";
						
						//we can do it only by changing name
					try
					{				//resizing image
					BufferedImage bim= ImageIO.read(new FileInputStream(s));
					Image resizedImg=bim.getScaledInstance(100, 100, Image.SCALE_FAST);
					BufferedImage rBimg=new BufferedImage(100,100,bim.getType());
					Graphics2D g= rBimg.createGraphics();
					g.drawImage(resizedImg, 0, 0, null);
					g.dispose();
					ImageIO.write(rBimg, output.substring(output.indexOf(".")+1),new FileOutputStream(output));
				
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					}
			
					dispose();
					login frame=new login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
	}
			else
				JOptionPane.showMessageDialog(btnConfirm, "Your Data is Invalid . Enter data correctly And Completely!!!");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(btnConfirm, "Your Data is Invalid . Enter data correctly And Completely!!!");
		}
				
	}
});

	
		JButton btnbacktomenu = new JButton("<-Back");	
		btnbacktomenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();	
				login ob1=new login();
					String arr[]={""};
					ob1.main(arr);
		
			}
		});
	
	
	
		textField = new JTextField();
		textField.setColumns(10);
		
	//	final JRadioButton rdbtnMale = new JRadioButton("Male");
		
	//	final JRadioButton rdbtnFemale = new JRadioButton("Female");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblansweIsCasesensativeplease = new JLabel("*Answer is Case_Sensative.Please do remember.");
		lblansweIsCasesensativeplease.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		
		JLabel lblDidtsOnly = new JLabel("(*10 digits only)");
		lblDidtsOnly.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		
		//JLabel lblimg = new JLabel("xxxxx");
	ImageIcon dp=new ImageIcon("sign_up_images/none.jpg");
		 lblimg = new JLabel(dp);
		 
	 lblimg.setSize(100,100);
		

		JButton btnChangeDp = new JButton("Change DP");
		btnChangeDp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//lblimg.setIcon(null);
				try
				{
				JFileChooser filechooser= new JFileChooser(".");
				filechooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter= new FileNameExtensionFilter("JPG , PNG & GIF Images","jpg","png","gif");
				filechooser.setFileFilter(filter);
				filechooser.setDialogTitle("Select Image(Optional)");
			//	filechooser.
				int retval=filechooser.showOpenDialog(null);
				if(retval==JFileChooser.APPROVE_OPTION){
					f=filechooser.getSelectedFile();//.getName();
					//lblimg.setIcon(null);
					//JOptionPane.showMessageDialog(null, f);
					filechooser.setVisible(false);
				}
				
				if(retval==JFileChooser.CANCEL_OPTION){
					filechooser.setVisible(false);
			}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				String s="/"+f;
				//JOptionPane.showMessageDialog(null, s);
				String output="sign_up_images/demo"+i+".jpg";	
				//An Empty FILE length in string is 4.(Do not know why).
			if(s.length()!=5)
			{
				
				//JOptionPane.showMessageDialog(null, "Entred");
			try
			{				//resizing image
			BufferedImage bim= ImageIO.read(new FileInputStream(s));
			Image resizedImg=bim.getScaledInstance(100, 100, Image.SCALE_FAST);
			BufferedImage rBimg=new BufferedImage(100,100,bim.getType());
			Graphics2D g= rBimg.createGraphics();
			g.drawImage(resizedImg, 0, 0, null);
			g.dispose();
			ImageIO.write(rBimg, output.substring(output.indexOf(".")+1),new FileOutputStream(output));
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//////Image not changing on 2mnd input
			File x=new File(output);
		//	ImageIcon dp=new ImageIcon(output);
			//JOptionPane.showMessageDialog(null,dp);
			if(x.exists())
			{
		    ImageIcon dp=new ImageIcon(output);
			//	JOptionPane.showMessageDialog(null, dp);
		    lblimg.setIcon(dp);
			 img=true;
			 i++;
			// JOptionPane.showMessageDialog(null, "dp set");
			}
		/*	else
			{ImageIcon dp=new ImageIcon(output);
			 lblimg = new JLabel(dp);
			}
				*/
			
			}
			}
		});
		
		
		
		//lblansweIsCasesensativeplease.setMinimumSize();
	//	JComboBox comboBox = new JComboBox();
		
//
		
		  		
		

		
		
		
		
		
		
		
		//..........................................................................................................
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblConfirmPassword)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblAnswer)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnbacktomenu)
												.addComponent(lblSequirityQuestion)))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(56)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblGender)
										.addComponent(lblPassword)
										.addComponent(lblMobile))))
							.addGap(25))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(13)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_1, 163, 163, 163)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(textField))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(rdbtnMale)
											.addGap(16)
											.addComponent(rdbtnFemale)))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblAge)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(68)
									.addComponent(lblimg))
								.addComponent(lblDidtsOnly)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(passwordField_1, Alignment.LEADING)
									.addComponent(passwordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
									.addComponent(comboBox, Alignment.LEADING, 0, 265, Short.MAX_VALUE)
									.addComponent(textField_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
									.addComponent(lblansweIsCasesensativeplease, Alignment.LEADING))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(17)
									.addComponent(btnConfirm)
									.addGap(39)
									.addComponent(btnClear)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExit)
								.addComponent(btnChangeDp))))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(chckbxIAgreTo)
					.addContainerGap(274, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGender)
								.addComponent(rdbtnMale)
								.addComponent(rdbtnFemale)
								.addComponent(lblAge)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblMobile))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDidtsOnly)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblimg)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblConfirmPassword)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSequirityQuestion)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAnswer)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(lblansweIsCasesensativeplease, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxIAgreTo)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnClear)
								.addComponent(btnConfirm)
								.addComponent(btnbacktomenu)
								.addComponent(btnExit)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnChangeDp)))
					.addGap(50))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
