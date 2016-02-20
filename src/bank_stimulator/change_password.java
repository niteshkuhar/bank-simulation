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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class change_password extends JFrame {

	protected static final String String = null;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	
	static String old="";
	//static String acc="",pass,name;
	public static void main(String[] args) {
		/*forgot_password ob=new forgot_password();
		acc=ob.acc;
		pass=ob.pass;
		name=ob.name;
	*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					change_password frame = new change_password(String,String,String,String);
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
	public change_password(final String acc,String name,final String check,final String oldpass) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setEnabled(false);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setEnabled(false);
		
		if(check.equals("home"))
	{
			//JOptionPane.showMessageDialog(null,"enterd");
			
			passwordField_2.setEnabled(true);
			lblOldPassword.setEnabled(true);
			//old=passwordField_2.getText();
		}
		JLabel lblAccNo = new JLabel("Acc No:");
		
		JLabel label = new JLabel("");
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel label_1 = new JLabel("");
		
		JLabel lblNewPassword = new JLabel("New password:");
		
		JLabel lblReconfirmPassword = new JLabel("Re-Confirm Password:");
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		
		label.setText(acc);
		label_1.setText(name);
		

		
		final JButton btnSavePassword = new JButton("Save Password");
		btnSavePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String p=passwordField.getText().trim();
				String p1=passwordField_1.getText().trim();
				old=passwordField_2.getText();
				sqlquery ob1=new sqlquery();
				
			//	JOptionPane.showMessageDialog(btnSavePassword,"old Password :"+oldpass);
				//JOptionPane.showMessageDialog(btnSavePassword,"old enterd Password:"+old);
				
				
				if(p.length()!=0&&p.equals(p1) && acc.length()!=0 && old.equals(oldpass) )
				{
					 if(ob1.changepassword(acc,p))
				
				{
					
					JOptionPane.showMessageDialog(btnSavePassword,"Password successfully saved!!");
					dispose();
					login frame=new login();
					frame.setVisible(true);

					frame.setLocationRelativeTo(null);
										
						
			//call Sql for update and tgen print msg for success
				}
				}
				else
					JOptionPane.showMessageDialog(btnSavePassword,"Check password again!!");
			
			
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			
			if(check.equals("forgot"))
		{
				login frame=new login();
				frame.setVisible(true);

				frame.setLocationRelativeTo(null);
		
			}
			if(check.equals("home"))
			{
					homescreen frame=new homescreen();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
			
				}
			}
		});
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAccNo)
									.addGap(18)
									.addComponent(label))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewPassword)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(label_1)
									.addComponent(lblReconfirmPassword))
								.addComponent(lblOldPassword))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField_2)
								.addComponent(passwordField_1)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(153)
							.addComponent(btnSavePassword)
							.addGap(18)
							.addComponent(btnCancel)))
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(419, Short.MAX_VALUE)
					.addComponent(btnExit))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccNo)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(label_1))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOldPassword)
						.addComponent(passwordField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReconfirmPassword))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSavePassword)
						.addComponent(btnCancel))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnExit))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
