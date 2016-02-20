package bank_stimulator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showtable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static String acc;
	static String name;
	public static void main(String[] args) {
		if(args.length!=0)
		{
		acc=args[0];
		name=args[1];
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showtable frame = new showtable();
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
	public showtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
			//Object[][] data= {};
			
			 String[] colHead= {
				"Sl no", "Date","Particular","Deposits","Withdraw","Balance"
			};
			 DefaultTableModel model=new DefaultTableModel();
			 model.setColumnIdentifiers(colHead);
			 JTable table = new JTable();
			 table.setModel(model);
			 table.setAutoResizeMode(NORMAL);
			 table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			// table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_ROW);
			 table.setFillsViewportHeight(true);
			 JScrollPane jsp=new JScrollPane(table);
			 //how to set table size
			 //
			 jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			 jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			 sqlacc ob=new sqlacc();
			 ob.ministatement(model,acc);
			 			 JLabel lblWelcome = new JLabel("Welcome");
			 lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
			 
			 JLabel lblYourLastFew = new JLabel("Your last few transactions are:");
			 
			 JLabel lblX = new JLabel("X");
			 lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
			 lblX.setText(name);
			 
			 JButton button = new JButton("<-Back");
			 button.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		dispose();
			 		homescreen frame=new homescreen();
			 		frame.setVisible(true);

					frame.setLocationRelativeTo(null);
			 	}
			 });
			 
		//	 if(!x)
			//		JOptionPane.showMessageDialog(null, "No Tranasction ");
				 
			 
			 GroupLayout gl_contentPane = new GroupLayout(contentPane);
			 gl_contentPane.setHorizontalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addGap(41)
			 					.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
			 				.addGroup(gl_contentPane.createSequentialGroup()
			 					.addContainerGap()
			 					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			 						.addGroup(gl_contentPane.createSequentialGroup()
			 							.addGap(10)
			 							.addComponent(lblYourLastFew))
			 						.addGroup(gl_contentPane.createSequentialGroup()
			 							.addComponent(lblWelcome)
			 							.addPreferredGap(ComponentPlacement.UNRELATED)
			 							.addComponent(lblX)))))
			 			.addContainerGap(3, Short.MAX_VALUE))
			 		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
			 			.addContainerGap(375, Short.MAX_VALUE)
			 			.addComponent(button)
			 			.addContainerGap())
			 );
			 gl_contentPane.setVerticalGroup(
			 	gl_contentPane.createParallelGroup(Alignment.LEADING)
			 		.addGroup(gl_contentPane.createSequentialGroup()
			 			.addGap(19)
			 			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
			 				.addComponent(lblWelcome)
			 				.addComponent(lblX))
			 			.addPreferredGap(ComponentPlacement.RELATED)
			 			.addComponent(lblYourLastFew)
			 			.addGap(7)
			 			.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
			 			.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
			 			.addComponent(button))
			 );
			 contentPane.setLayout(gl_contentPane);
		}
	}

