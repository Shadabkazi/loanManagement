

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class loaninfo extends JFrame {
	
	// JDBC driver name and database URL
			static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
			static final String DB_URL="jdbc:mysql://localhost/loanmanagement";
			
			// Database Credentials
			static final String USER="root";
			static final String PASS="root";
			
			private Connection conn= null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loaninfo frame = new loaninfo();
					frame.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loaninfo() {
		getContentPane().setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(BorderFactory.createTitledBorder("Loan Details"));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/**JLabel bg = new JLabel("New label");
		bg.setHorizontalAlignment(SwingConstants.CENTER);
		bg.setIcon(new ImageIcon("C:\\Users\\saqibmubarak\\workspace\\loanManagement1\\src\\bg.jpg"));
		contentPane.add(bg, BorderLayout.CENTER);**/
		//setSize(getMaximumSize());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(scrollPane, BorderLayout.NORTH);
		scrollPane.setOpaque(false);
		
		
		
		 JTable table = new JTable(){
			 public boolean isCellEditable(int row,int column){
				    return false;
				  }
		 };
		 table.setFocusTraversalKeysEnabled(false);
		 table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 table.setDragEnabled(true);
		 table.setName("Loan Details");
		 table.setUpdateSelectionOnSort(false);
		 table.setSurrendersFocusOnKeystroke(true);
		 table.setColumnSelectionAllowed(true);
	      table.setToolTipText("");
	      table.setCellSelectionEnabled(true);
		
		try{
			// Regsiter JDBC Driver
			Class.forName(JDBC_DRIVER);
			
			// open a connection
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			
		}
		catch(SQLException se){
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
     
     try
     {
   	  String query="Select customer.Customer_Name,customer.C_ID,loan_type.Loan_Name,customer_loan.Loan_ID,customer_loan.Principle_Amount,customer_loan.Loan_Status,customer_loan.Balance,customer_loan.Balance,customer_loan.Total_EMI,customer_loan.EMI_Submitted,customer_loan.Date_Of_Approval,customer_loan.Date_Of_submission"
   	  		+ " FROM customer,customer_loan,loan_type"
   	  		+ " where customer.C_ID=customer_loan.C_ID AND customer_loan.Loan_Type_ID=loan_type.Loan_Type_ID;";
   	  
   	//Select customer.Customer_Name,loan_type.Loan_Name,customer_loan.Loan_Status from customer,customer_loan,loan_type where customer.C_ID=customer_loan.C_ID AND customer.C_ID='"+custID+"' AND customer_loan.Loan_Type_ID=loan_type.Loan_Type_ID;
   	  PreparedStatement pst=(PreparedStatement) conn.prepareStatement(query);
   	  ResultSet rs = pst.executeQuery(); 
   	  table.setModel(DbUtils.resultSetToTableModel(rs));
         
         table.getColumnModel().getColumn(0).setMinWidth(25);
         scrollPane.setViewportView(table);
         
     }
     catch(Exception e)
     {
   	  e.printStackTrace();
     }
		
		
	}

}
