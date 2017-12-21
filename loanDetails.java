import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class loanDetails extends JPanel {

	private JPanel contentPane,firstPanel,secondPanel;
private JLabel customerIDLabel;
private JButton searchButton,backButton,custInfo;
private JTextField custIDValue;
private JComboBox loanTypeComboBox;
private JScrollPane scrollPane;
private JTable loanDetailsTable;
private DefaultTableModel tableModel;
private ArrayList<String> loanTypeArrayList;

private JLabel loanNoLabel,customerIDLabel2,customerNameLabel,principleAmountLabel,balanceLabel,dateofApprovalLabel,loanTypeLabel;
private JLabel loanNoValue,customerIDValue2,customerNameValue,principleAmountValue,balanceValue,dateofApprovalValue,loanTypeValue;
private String custIDInDB,loanIDInDB;

operatorDBCheck op=new operatorDBCheck();

	
	public loanDetails() {
		setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setVisible(true);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(new Color(242,221,241));
		
		add(contentPane,BorderLayout.CENTER);
		
		firstPanel=new JPanel();
		firstPanel.setBackground(new Color(173,216,230));
		
		secondPanel=new JPanel();
		secondPanel.setBackground(new Color(173,216,230));
		
		customerIDLabel=new JLabel("Customer ID");
		customerNameLabel=new JLabel("Customer Name");
		loanNoLabel=new JLabel("Loan No.");
		loanTypeLabel=new JLabel("Loan Type");
		
		searchButton=new JButton("Search");
		backButton=new JButton("Back");
		custInfo=new JButton("Customer Information");
		
		
		custIDValue=new JTextField(10);
	//	custNameValue=new JTextField(10);
	//	loanNoValue=new JTextField(10);
		
		loanTypeArrayList=new ArrayList<String>();
		loanTypeArrayList=op.getLoanType();
		loanTypeComboBox=new JComboBox();
		for(String value:loanTypeArrayList){
			loanTypeComboBox.addItem(value);
		}
		
		
		contentPane.add(firstPanel,BorderLayout.NORTH);
		contentPane.add(secondPanel,BorderLayout.CENTER);
		
		firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		firstPanel.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.insets=new Insets(10,10,10,10);
		c.gridx=0;
		c.gridy=0;
		firstPanel.add(customerIDLabel,c);
	/*	c.gridx=1;
		c.gridy=0;
	
		firstPanel.add(loanNoLabel,c);  */
		c.gridx=0;
		c.gridy=1;
		firstPanel.add(custIDValue,c);
	/*	c.gridx=1;
		c.gridy=1;
		firstPanel.add(loanNoValue,c); */
		c.gridx=2;
		c.gridy=1;
		firstPanel.add(searchButton,c);
		
		c.gridx=3;
		c.gridy=1;
		firstPanel.add(custInfo,c);
				
		/*
		 * Second Panel
		 */
		
		
		String [] header={ "Loan NO.","Customer ID","Customer Name","Principle Amount","Balance","Date Of Approval","Loan Type"};
		String[][] data = {{""},{""},{""},{""},{""},{""},{""},{""}};
		
			
	//		tableModel =new DefaultTableModel(data,header);
	//		loanDetailsTable=new JTable(tableModel);
			
	//		loanDetailsTable.setPreferredScrollableViewportSize(new Dimension(770,150));
	//		loanDetailsTable.setFillsViewportHeight(true);
	//		loanDetailsTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			
	//		scrollPane = new JScrollPane(loanDetailsTable);
	//		 scrollPane.setVisible(true);
	//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
			
	//		secondPanel.add(scrollPane);
			
		loanNoLabel=new JLabel("Loan NO. :-");
		customerIDLabel2=new JLabel("Customer ID :-");
		customerNameLabel=new JLabel("Customer Name :-");
		principleAmountLabel=new JLabel("Principle Amount :-");
		balanceLabel=new JLabel("Balance :-");
		dateofApprovalLabel=new JLabel("Date Of Approval :-");
		loanTypeLabel=new JLabel("Loan Type :-");
		loanNoValue=new JLabel();
		customerIDValue2=new JLabel();
		customerNameValue=new JLabel();
		principleAmountValue=new JLabel();
		balanceValue=new JLabel();
		dateofApprovalValue=new JLabel();
		loanTypeValue=new JLabel();
	
		
		
		
		secondPanel.setLayout(new GridBagLayout());
		GridBagConstraints d=new GridBagConstraints();
		d.insets=new Insets(10,10,10,10);
		d.gridx=0;
		d.gridy=0;
		secondPanel.add(customerIDLabel2,d);
		d.gridx=0;
		d.gridy=1;
		secondPanel.add(loanNoLabel,d);
		d.gridx=0;
		d.gridy=2;
		secondPanel.add(customerNameLabel,d);
		d.gridx=0;
		d.gridy=3;
		secondPanel.add(principleAmountLabel,d);
		d.gridx=0;
		d.gridy=4;
		secondPanel.add(balanceLabel,d);
		d.gridx=0;
		d.gridy=5;
		secondPanel.add(dateofApprovalLabel,d);
		d.gridx=0;
		d.gridy=6;
		secondPanel.add(loanTypeLabel,d);
			
		
		d.gridx=1;
		d.gridy=0;
		secondPanel.add(customerIDValue2,d);
		d.gridx=1;
		d.gridy=1;
		secondPanel.add(loanNoValue,d);
		d.gridx=1;
		d.gridy=2;
		secondPanel.add(customerNameValue,d);
		d.gridx=1;
		d.gridy=3;
		secondPanel.add(principleAmountValue,d);
		d.gridx=1;
		d.gridy=4;
		secondPanel.add(balanceValue,d);
		d.gridx=1;
		d.gridy=5;
		secondPanel.add(dateofApprovalValue,d);
		d.gridx=1;
		d.gridy=6;
		secondPanel.add(loanTypeValue,d);
		
		
			searchButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					custIDInDB=custIDValue.getText().toString();
					loanIDInDB=loanNoValue.getText().toString();
					
						if(custIDInDB.isEmpty()==false )
						{
							op.getLoanInformation(custIDInDB);
							customerIDValue2.setText(custIDInDB);
							loanNoValue.setText(op.getLoanIDDB().toString());
							customerNameValue.setText(op.getCustomerNameDB().toString());
							principleAmountValue.setText(op.getPrincipleAmountDB().toString());
							balanceValue.setText(op.getBalanceDB().toString());
							
							loanTypeValue.setText(op.getLoanNameDB());
							if(op.getDateOfApprovalDB()==null)
							dateofApprovalValue.setText("Not yet Approved");
							else
								dateofApprovalValue.setText(op.getDateOfApprovalDB().toString());
						}
					
				}
				
			});
			
			
			
			custInfo.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					custinfo cu =new custinfo();
					cu.setVisible(true);
					
				}
				
			});
			
			
	}

}
