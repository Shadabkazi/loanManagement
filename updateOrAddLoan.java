import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class updateOrAddLoan extends JPanel {

	private JPanel contentPane;
	private JLabel newLoanType;
	private JTextField newLoanTypeName;
	private JTextField roitext;
	private JTextField minAmountText;
	private JTextField maxAmountText;
	private JTextField minTenureText;
	private JTextField maxTenureText;
	private JTextField yearlyIncomeText;
	private  GridBagConstraints gbc;
	private JComboBox typeSelectComboBox;
	private String selectedLoanType;
	private String typeOfLoans[]= {"Personal","Educational","Home","Car","Business","Add new Loan"};

	adminDBCheck dbCheck=new adminDBCheck();
	
	private String newLoanTypeNameDB,roiDB,minAmountDB,maxAmountDB,minTenureDB,maxTenureDB,yearlyIncomeDB;
	private int i=0;
	
	public updateOrAddLoan() {
		setLayout(new BorderLayout());
		Font defaultFont = new Font("Verdana", Font.BOLD, 15);
	
		contentPane = new JPanel();
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new GridBagLayout());
		 gbc = new GridBagConstraints();
		
		JLabel loanTypeLabel = new JLabel("Loan Type");
		loanTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loanTypeLabel.setFont(defaultFont);
		
		
		newLoanType=new JLabel("New Loan Type Name");
		newLoanType.setHorizontalAlignment(SwingConstants.CENTER);
		newLoanType.setFont(defaultFont);
		newLoanType.setVisible(false);
		newLoanTypeName=new JTextField(10);
		newLoanTypeName.setVisible(false);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	      gbc.gridy = i;
		
		contentPane.add(loanTypeLabel,gbc);
		 
		
		typeSelectComboBox = new JComboBox(typeOfLoans);
		typeSelectComboBox.setSelectedIndex(0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	      gbc.gridy = i++;
	      gbc.insets=new Insets(10,10,10,10);
		contentPane.add(typeSelectComboBox,gbc);
		
		JLabel roiLabel = new JLabel("Rate Of Interest");
		roiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roiLabel.setFont(defaultFont);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	      gbc.gridy = i;
		contentPane.add(roiLabel,gbc);
		
		roitext = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	      gbc.gridy = i++;
		contentPane.add(roitext,gbc);
		roitext.setColumns(10);
		
		JLabel minAmountLabel = new JLabel("Minimum Amount");
		minAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minAmountLabel.setFont(defaultFont);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	      gbc.gridy = i;
		contentPane.add(minAmountLabel,gbc);
		
		minAmountText = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	      gbc.gridy = i++;
		contentPane.add(minAmountText,gbc);
		minAmountText.setColumns(10);
		
		JLabel maxAmountLabel = new JLabel("Maximum Amount");
		maxAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxAmountLabel.setFont(defaultFont);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	      gbc.gridy = i;
		contentPane.add(maxAmountLabel,gbc);
		
		maxAmountText = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	      gbc.gridy = i++;
		contentPane.add(maxAmountText,gbc);
		maxAmountText.setColumns(10);
		
		JLabel minTenureLabel = new JLabel("Minimum Tenure");
		minTenureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minTenureLabel.setFont(defaultFont);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	      gbc.gridy = i;
		contentPane.add(minTenureLabel,gbc);
		
		minTenureText = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	      gbc.gridy = i++;
		contentPane.add(minTenureText,gbc);
		minTenureText.setColumns(10);
		
		JLabel maxTenureLabel = new JLabel("Maximum Tenure");
		maxTenureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxTenureLabel.setFont(defaultFont);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	      gbc.gridy = i;
		contentPane.add(maxTenureLabel,gbc);
		
		maxTenureText = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	      gbc.gridy = i++;
		contentPane.add(maxTenureText,gbc);
		maxTenureText.setColumns(10);
		
		JLabel yearlyIncomeLabel = new JLabel("Yearly Income");
		yearlyIncomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yearlyIncomeLabel.setFont(defaultFont);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	      gbc.gridy = i;
		contentPane.add(yearlyIncomeLabel,gbc);
		
		yearlyIncomeText = new JTextField();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
	      gbc.gridy = i++;
		contentPane.add(yearlyIncomeText,gbc);
		yearlyIncomeText.setColumns(10);
		
		JButton updateBtn = new JButton("Update");
		
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});gbc.fill = GridBagConstraints.EAST;
		gbc.gridx = 0;
	      gbc.gridy = i;
		
		contentPane.add(updateBtn,gbc);
		
		
		JButton addNewBtn = new JButton("Add New");
		gbc.fill = GridBagConstraints.EAST;
		gbc.gridx = 1;
	      gbc.gridy = i++;
		contentPane.add(addNewBtn,gbc);
		
	
		
		typeSelectComboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedLoanType=typeSelectComboBox.getSelectedItem().toString();	
				
		if(selectedLoanType=="Add new Loan"){
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
		      gbc.gridy = 0;
			contentPane.add(newLoanType, gbc);
			newLoanType.setVisible(true);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 3;
		      gbc.gridy = 0;
			contentPane.add(newLoanTypeName, gbc);
		newLoanTypeName.setVisible(true);
		}
		else{
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
		      gbc.gridy = 0;
			contentPane.add(newLoanType, gbc);
			newLoanType.setVisible(false);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 3;
		      gbc.gridy = 0;
			contentPane.add(newLoanTypeName, gbc);
			newLoanTypeName.setVisible(false);
		}
			}
		});
		

	
updateBtn.addActionListener(new ActionListener(){

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		setRoiDB(roitext.getText());
		setNewLoanTypeNameDB(selectedLoanType);
		setMinAmountDB(minAmountText.getText());
		setMaxAmountDB(maxAmountText.getText());
		setMinTenureDB(minTenureText.getText());
		setMaxTenureDB(maxTenureText.getText());
		setYearlyIncomeDB(yearlyIncomeText.getText());
		
		
		if(selectedLoanType!="Add new Loan"){
dbCheck.updateLoanTypeInDB(selectedLoanType,roiDB,minAmountDB,maxAmountDB,minTenureDB,maxTenureDB,yearlyIncomeDB);		
		JOptionPane.showMessageDialog(null, "Loan Data updated Successfully","Success",JOptionPane.INFORMATION_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null, "Click 'Add New' Button to add new Loan Type","Success",JOptionPane.OK_OPTION);
		}
	
	
	}
	
});
		

addNewBtn.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dbCheck.addNewLoanTypeInDB(newLoanTypeNameDB, roiDB, minAmountDB, maxAmountDB, minTenureDB, maxTenureDB, yearlyIncomeDB);
		JOptionPane.showMessageDialog(null, "New Loan Added Successfully","Success",JOptionPane.INFORMATION_MESSAGE);

	}
	
});

		add(contentPane);
	}

	public void setNewLoanTypeNameDB(String newLoanTypeNameDB) {
		this.newLoanTypeNameDB = newLoanTypeNameDB;
	}

	public void setRoiDB(String roiDB) {
		this.roiDB = roiDB;
	}

	public void setMinAmountDB(String minAmountDB) {
		this.minAmountDB = minAmountDB;
	}

	public void setMaxAmountDB(String maxAmountDB) {
		this.maxAmountDB = maxAmountDB;
	}

	public void setMinTenureDB(String minTenureDB) {
		this.minTenureDB = minTenureDB;
	}

	public void setMaxTenureDB(String maxTenureDB) {
		this.maxTenureDB = maxTenureDB;
	}

	public void setYearlyIncomeDB(String yearlyIncomeDB) {
		this.yearlyIncomeDB = yearlyIncomeDB;
	}
	

}
