package bank_stimulator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Font;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	 /*JFrame frame=new JFrame();
	static public void visible()
	{
		login frame = new login();
		frame.setVisible(false);
		
	}*/
//	static login frame = new login();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				login frame = new login();
					frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				//	System.out.print(acc);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//....................................................................................................................
	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	//********************************************************************************************	
		JLabel lblAccountNumber = new JLabel("Account number");
	    textField = new JTextField();
	    passwordField = new JPasswordField();
	    final JButton btnLogin = new JButton("Login");
	   JLabel lblPassword = new JLabel("Password");
	    textField.setColumns(10);
		//final String acc= textField.getText();
		 
		
	//...........................................................................................................	
		
	    btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 final String acc=textField.getText();
				final String pass=passwordField.getText();
				sqlquery ob=new sqlquery();
				//textField_2.setText(acc);
				String nm=ob.Query(acc,pass);
				//textField_1.setText(res);
				//JFrame frame1 = new JFrame();
				//frame1.setVisible(false);
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				if((nm.length())!=0)
				{
				//login x= new login();
				//x.visible();
				
					dispose();
					homescreen ob1=new homescreen();
					String arr[]={acc,nm,pass};
					ob1.main(arr);
					
					//contentPane.setVisible(false);
			
				}
				else
					JOptionPane.showMessageDialog(btnLogin, "Not exist");
			}
		});
		
		JButton btnsignup = new JButton("Sign Up");
		
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//login frame= new login();
				//frame.visible();
				dispose();
			//	sign_up frame=new sign_up();
			//	frame.setVisible(true);
				sign_up frame=new sign_up();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		
			}
		});
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				forgot_password frame=new forgot_password();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JLabel lblWelcomeToMy = new JLabel("Welcome to MY BANK");
		lblWelcomeToMy.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		
		
		
		
		
		
	//.....................................................................................................................
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPassword))
						.addComponent(lblAccountNumber))
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(textField))
					.addContainerGap(176, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(btnLogin)
					.addGap(88)
					.addComponent(btnsignup)
					.addGap(129))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(171, Short.MAX_VALUE)
					.addComponent(btnForgotPassword)
					.addGap(190))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(152)
					.addComponent(lblWelcomeToMy)
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(419, Short.MAX_VALUE)
					.addComponent(btnExit))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblWelcomeToMy)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAccountNumber))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnsignup))
					.addGap(18)
					.addComponent(btnForgotPassword)
					.addGap(14)
					.addComponent(btnExit))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
