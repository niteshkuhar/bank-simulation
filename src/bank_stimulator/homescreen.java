package bank_stimulator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.Icon;

public class homescreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static String acc="";
	static String name="";
	static String pass="";
	public static void main(String[] args) {
		if(args.length !=0)
			{acc=args[0];
			name=args[1];
			pass=args[2];
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homescreen frame = new homescreen();
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
	public homescreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		//JLabel lblNewLabel = new JLabel("New label");
				JLabel label = new JLabel("");
				String output="sign_up_images/"+acc+".jpg";
				 
				 label.setSize(100,100);
							
				//ImageIcon dp=new ImageIcon(output);
				//if(dp.getIconHeight()==0)
				File f=new File(output);
				if(f.exists())
				{
					ImageIcon dp=new ImageIcon(output);
				 label = new JLabel(dp);
				}
				else
				{ImageIcon dp=new ImageIcon("sign_up_images/none.jpg");
				 label = new JLabel(dp);
				}
						
				 //	if(label.getText()=="")
					
				
		
		
		
		JButton btnTransaction = new JButton("Transaction");
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				transaction ob1=new transaction();
				String arr[]={acc};
				ob1.main(arr);
	
				//transaction frame=new transaction();
				//frame.setVisible(true);
			}
		});
		
		JButton btnMiniStatement = new JButton("Mini Statement");
		btnMiniStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				showtable ob=new showtable();
				String arr[]={acc,name};
					ob.main(arr);
				
				
				
			}
		});
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				change_password frame=new change_password(acc,name,"home",pass);
				frame.setVisible(true);
			}
		});
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login frame=new login();
				frame.setVisible(true);

				frame.setLocationRelativeTo(null);
			}
		});
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblX = new JLabel("x");
		lblX.setText(name);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		final JButton btnBalanceEnquiray = new JButton("Balance Enquiry");
		btnBalanceEnquiray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sqlacc ob=new sqlacc();
				
				JOptionPane.showMessageDialog(btnBalanceEnquiray, "Your Account Balance is :"+ob.Query(acc));
				
				
				
			}
		});
		
		JButton button = new JButton("<-Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				login frame=new login();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		
		final JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String passchck=JOptionPane.showInputDialog(btnDeleteAccount, "Enter your password:");
				//JOptionPane.showMessageDialog(btnDeleteAccount,"Enterd password:"+pass);
				if(passchck.equals(pass))
				{
					sqlquery ob1=new sqlquery();
					ob1.deleteAccount(acc);
					sqlacc ob=new sqlacc();
					ob.deleteAcctable(acc);
					//delete table
					JOptionPane.showMessageDialog(btnDeleteAccount,"Account Deleted Successfully..");
					dispose();
					login frame=new login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				
				}
				else
						JOptionPane.showMessageDialog(btnDeleteAccount,"Sorry!! Incorrect Password");
			//	dispose();
			}
		});
		
		JButton btnComplaints = new JButton("Complaints");
		btnComplaints.setEnabled(false);
	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button)
								.addComponent(btnDeleteAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnChangePassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTransaction, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(lblWelcome)
							.addGap(18)
							.addComponent(lblX)))
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnBalanceEnquiray, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnMiniStatement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnComplaints, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(103, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(393, Short.MAX_VALUE)
					.addComponent(btnLogOut)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWelcome)
								.addComponent(lblX))
							.addGap(38))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTransaction)
						.addComponent(btnMiniStatement))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangePassword)
						.addComponent(btnBalanceEnquiray))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteAccount)
						.addComponent(btnComplaints))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogOut)
						.addComponent(button))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
