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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class forgot_password extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgot_password frame = new forgot_password();
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
	public forgot_password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		
		final JLabel lblAccountNo = new JLabel("Account No:");
		
		 textField = new JTextField();
		textField.setColumns(10);
		
		final JLabel lblName = new JLabel("Name:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		final JLabel lblSequrityQuestion = new JLabel("Sequrity Question:");
		lblSequrityQuestion.setVisible(true);
		final JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setVisible(true);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setVisible(true);
		final JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setVisible(true);
	
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("Your Native Place?");
		comboBox.addItem("Your Mother toungue?");
		comboBox.addItem("Your Mother's Native place?");
		comboBox.addItem("Which year is your favourite?");
		comboBox.addItem("Your Secret code?");
	
		
		
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 final String acc=textField.getText().trim();
				 final String name=textField_1.getText().trim();
				//name=textField_1.getText();
				 //final String pass=passwordField.getText();
					//final String pass1=passwordField_1.getText();
					final String que=(String) comboBox.getSelectedItem();
					final String ans=textField_2.getText();
					
					//final String ag=textField_4.getText();
					
					
				//	if(pass.equals(pass1) && (mob.length()==10 || mob.length()==11) && name.length()!=0 &&ag.length()!=0&&que.length()!=0&&ans.length()!=0
				//			&& chckbxIAgreTo.isSelected()&&(rdbtnMale.isSelected()||rdbtnFemale.isSelected()))
					//{
					sqlquery obnew=new sqlquery();
					//String acc=obnew.genarateAcc();
					//textField.setText(acc);
					String pass=obnew.forget(acc,name,que,ans);
					//textField_1.setText(res);
					if(pass.length()!=0)
					{
						change_password frame=new change_password(acc,name,"forgot","");
						frame.setVisible(true);
						dispose();
					}
					//JOptionPane.showMessageDialog(btnChangePassword, "Your Password is :'"+pass+"'.");
					//dispose();
					//login frame=new login();
					//frame.setVisible(true);
			
					else
						JOptionPane.showMessageDialog(btnChangePassword, "Enter data correctly And Completely!!!");
					
					
						}
		});
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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
		

		
	   
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(153)
							.addComponent(btnChangePassword))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAnswer)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblSequrityQuestion)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAccountNo))))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox, 0, 231, Short.MAX_VALUE)
								.addComponent(textField_2))))
					.addContainerGap(69, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
					.addComponent(btnExit))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAccountNo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(label)))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSequrityQuestion)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(btnChangePassword))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAnswer)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(button)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
