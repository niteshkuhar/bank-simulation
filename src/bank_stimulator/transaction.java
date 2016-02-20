package bank_stimulator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

public class transaction extends JFrame {

	protected static final GraphicsConfiguration String = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	static String acc;
	public static void main(String[] args) {
	//	login frame1=new login();
		//frame1.setVisible(false);
	if(args.length==1)
			acc=args[0];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transaction frame = new transaction();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public transaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
final JLabel lblRs = new JLabel("Rs:");
		
		textField = new JTextField();
		textField.setColumns(20);
	
		final JLabel lblParticulars = new JLabel("Particulars:");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransaction.setFont(new Font("Times New Roman", Font.BOLD, 23));
		
		final JRadioButton rdbtnWithdraw = new JRadioButton("Withdraw");
		final JRadioButton rdbtnDeposit = new JRadioButton("Deposit");
		JButton btnCancel = new JButton("Cancel");		
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnWithdraw);
		group.add(rdbtnDeposit);
		
btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblDate = new JLabel("Date:");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_2.setText(new SimpleDateFormat("dd-MM-YYYY").format(new Date()));
		final JButton btnProceed = new JButton("Proceed");	
btnProceed.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		
		
		
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String balance;
				String deposit;
				String withdraw;
				sqlacc obnew=new sqlacc();
				balance=obnew.Query(acc);
				
		//JOptionPane.showMessageDialog(btnProceed, balance);
			//	String acc;
				try{
				String date=textField_2.getText().trim();
				String particular=textField_1.getText().trim();
				String amount=textField.getText().trim();
				Double trans=Double.parseDouble(amount);
		if(particular.length()!=0&&(rdbtnWithdraw.isSelected() ||rdbtnDeposit.isSelected())&& trans>0 &&trans<=100000 )
		{
			if(rdbtnWithdraw.isSelected())
						{
				deposit="";
				// withdraw=textField.getText();
				//String balance="";
					double b;
				 if(balance.length()==0)
					  b=0.0;
				 else
				 b=Double.parseDouble(balance);
				double w= trans;    //  Double.parseDouble(withdraw);
				b=b-w;
				if(b<0.0)
				{
					JOptionPane.showMessageDialog(btnProceed, "Out of balance");
					
				}
				else
				{
				balance=Double.toString(b);
				withdraw=Double.toString(w);
				sqlacc ob1=new sqlacc();
				ob1.insert(acc,date,particular,deposit,withdraw,balance);
				JOptionPane.showMessageDialog(btnProceed, "Transaction successful..");
				}
				
				}
				if(rdbtnDeposit.isSelected())
				{
					withdraw="";
					 //deposit=textField.getText();
					//String balance="";
				 double b;
					 if(balance.length()==0)
					 	b=0.0;
					 else
						 b=Double.parseDouble(balance);
					double d=trans;         //Double.parseDouble(deposit);
					
				
					deposit=Double.toString(d);
					b=b+d;
					balance=Double.toString(b);
			//	DecimalFormat frm=new DecimalFormat();
			//	balance=frm.format(b);
				
					sqlacc ob1=new sqlacc();
					ob1.insert(acc,date,particular,deposit,withdraw,balance);
					JOptionPane.showMessageDialog(btnProceed, "Transaction successful..");
			
				}
		}
		else
				JOptionPane.showMessageDialog(btnProceed, "Fill data correctly...");
				}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(btnProceed, "Fill data correctly...");
				}
			}
				
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			homescreen frame=new homescreen();
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
		
		JLabel lblAmountShouldNot = new JLabel("Amount should not exceed Rs 100000/- per transaction");
		lblAmountShouldNot.setFont(new Font("Tahoma", Font.BOLD, 8));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(55, Short.MAX_VALUE)
					.addComponent(rdbtnWithdraw)
					.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
					.addComponent(rdbtnDeposit)
					.addGap(144))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addComponent(lblTransaction, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(190, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addComponent(btnProceed)
					.addGap(18)
					.addComponent(btnCancel)
					.addContainerGap(179, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(419, Short.MAX_VALUE)
					.addComponent(btnExit))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRs)
						.addComponent(lblDate)
						.addComponent(lblParticulars))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAmountShouldNot)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTransaction)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnDeposit)
						.addComponent(rdbtnWithdraw))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRs)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(lblAmountShouldNot)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblParticulars))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnProceed)
								.addComponent(btnCancel))
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
	}
