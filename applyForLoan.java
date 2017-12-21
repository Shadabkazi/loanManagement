import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class applyForLoan extends JPanel {

	private JPanel contentPane,leftPanel,rightPanel,leftFirstPanel,leftSecondPanel,leftThirdPanel,rightFirstPanel;
	private JLabel custIDLabel,loanTypeLabel,loanType2Label,loanAmountLabel,tenureLabel,tenure2Label,yearsLabel,monthsLabel,loanStatusLabel, amountLabel,interestLabel,inMonthsLabel,EMICalculatorLabel;
	private JTextField custIDValue,loanAmountValue,yearsValue,monthsValue,amountValue,interestValue,tenureValue,emiValue;
	private JComboBox loanTypeComboBox,loanType2ComboBox;
	private JButton applyForLoanButton,calculateEMIButton,backButton;
	private String loanType[];
	private String loanTypeinDB,loanAmountinDB;
	private int tenureYearsinDB,tenureMonthsinDB,custIDinDB;
	private Boolean Successful=false;
	
	private int P,N;
	double EMI;
	private float R;
	private ArrayList<String> loanTypeArrayList;
	private operatorDBCheck op1=new operatorDBCheck();
	
	public applyForLoan() {
		
		setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createTitledBorder("New Loan Form"));
		contentPane.setLayout(new GridLayout(1,2));
		add(contentPane);
		Font defaultFont = new Font("Verdana", Font.BOLD, 12);
		Font smallFont = new Font("Verdana", Font.BOLD, 9);

		
		leftPanel =new JPanel();			//Declaring Panels
		rightPanel=new JPanel();
		leftFirstPanel=new JPanel();
		leftSecondPanel=new JPanel();
		leftThirdPanel=new JPanel();
		rightFirstPanel=new JPanel();
		
		custIDLabel=new JLabel("Customer_ID");				// Declaring Label
		custIDLabel.setFont(defaultFont);
		loanTypeLabel=new JLabel("Loan Type");	
		loanTypeLabel.setFont(defaultFont);
		loanType2Label=new JLabel("Loan Type");	
		loanType2Label.setFont(defaultFont);
		loanAmountLabel=new JLabel("Loan Amount");	
		loanAmountLabel.setFont(defaultFont);
		tenureLabel=new JLabel("Tenure    ");	
		tenureLabel.setFont(defaultFont);
		tenure2Label=new JLabel("Tenure    ");	
		tenure2Label.setFont(defaultFont);
		yearsLabel=new JLabel("Years");	
		yearsLabel.setFont(smallFont);
		monthsLabel=new JLabel("Months");	
		monthsLabel.setFont(smallFont);
		loanStatusLabel=new JLabel("NOT YET APPLIED FOR LOAN");	
		loanStatusLabel.setFont(defaultFont);
		amountLabel=new JLabel("Amount");	
		amountLabel.setFont(defaultFont);
		interestLabel=new JLabel("Interest");	
		interestLabel.setFont(defaultFont);
		inMonthsLabel=new JLabel("(IN MONTHS)");	
		inMonthsLabel.setFont(smallFont);
		EMICalculatorLabel=new JLabel("EMI Calculator");
		EMICalculatorLabel.setFont(defaultFont);
		
		custIDValue=new JTextField(15);			//Declaring TextField
		loanAmountValue=new JTextField(15);
		yearsValue=new JTextField(5);
		yearsValue.setText("0");
		monthsValue=new JTextField(5);
		monthsValue.setText("0");
		amountValue=new JTextField(15);
		interestValue=new JTextField(5);
		tenureValue=new JTextField(15);
		emiValue=new JTextField(10);
		
		loanTypeArrayList=new ArrayList<String>();
		loanTypeArrayList=op1.getLoanType();
		
		loanTypeComboBox=new JComboBox();		//Declaring ComboBox
		loanType2ComboBox=new JComboBox();
		for(String value:loanTypeArrayList){				// Adding loan type names in jcombobox
			loanTypeComboBox.addItem(value);
			loanType2ComboBox.addItem(value);

		}
		
		applyForLoanButton=new JButton("Apply For Loan");
		calculateEMIButton=new JButton("Calculate EMI");
		backButton=new JButton("Back");
		
		
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		contentPane.add(leftPanel);
		contentPane.add(rightPanel);
		
		/*
		 * left Panel
		 */
		leftPanel.setLayout(new GridLayout(3,1));
		leftPanel.add(leftFirstPanel);
		
		/*
		 * left first panel
		 */
		leftFirstPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c=new GridBagConstraints();
		c.insets=new Insets(10,10,10,10);
		
		c.gridx=0;
		c.gridy=0;
		leftFirstPanel.add(custIDLabel,c);
		c.gridx=1;
		c.gridy=0;
		leftFirstPanel.add(custIDValue,c);
		c.gridx=0;
		c.gridy=1;
		leftFirstPanel.add(loanTypeLabel,c);
		c.gridx=1;
		c.gridy=1;
		c.fill=1;
		leftFirstPanel.add(loanTypeComboBox,c);
		
		c.gridx=0;
		c.gridy=2;
		leftFirstPanel.add(loanAmountLabel,c);
		c.gridx=1;
		c.gridy=2;
		leftFirstPanel.add(loanAmountValue,c);
		
		/*
		 * End of First Left panel
		 */
		
		leftPanel.add(leftSecondPanel);
		
		/*
		 * Start of Second Left Panel
		 */
		leftSecondPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));
		leftSecondPanel.setAlignmentY(CENTER_ALIGNMENT);
		leftSecondPanel.add(tenureLabel);
		leftSecondPanel.add(yearsLabel);
		leftSecondPanel.add(yearsValue);
		leftSecondPanel.add(monthsLabel);
		leftSecondPanel.add(monthsValue);
leftSecondPanel.add(applyForLoanButton);
/*
 * End of Second Left Panel
 */
		
leftPanel.add(leftThirdPanel);


/*
 * Left Third Panel
 */

leftThirdPanel.setLayout(new GridLayout(1,1));
loanStatusLabel.setHorizontalAlignment(JLabel.CENTER);
leftThirdPanel.add(loanStatusLabel);

/*
 * end of Left Third Panel
 */

/*
 * End of Left Panel
 */


/*
 * Right Panel
 */

rightPanel.setLayout(new GridBagLayout());
GridBagConstraints d=new GridBagConstraints();
d.gridwidth=2;
d.gridx=1;
d.gridy=0;
d.insets=new Insets(50,10,0,10);
rightPanel.add(EMICalculatorLabel,d);
d.fill=2;
d.gridx=1;
d.gridy=1;
rightPanel.add(rightFirstPanel,d);
d.weightx=1;
d.gridx=1;
d.gridy=2;
rightPanel.add(calculateEMIButton, d);
d.gridx=1;
d.gridy=3;
rightPanel.add(emiValue, d);


/*
 * right first panel
 */
rightFirstPanel.setLayout(new GridLayout(5,2));

rightFirstPanel.add(loanType2Label);
rightFirstPanel.add(loanType2ComboBox);
rightFirstPanel.add(amountLabel);
rightFirstPanel.add(amountValue);
rightFirstPanel.add(interestLabel);
rightFirstPanel.add(interestValue);
rightFirstPanel.add(tenure2Label);
rightFirstPanel.add(tenureValue);
rightFirstPanel.add(inMonthsLabel);

loanType2ComboBox.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		R=op1.getInterestOfLoanType(loanType2ComboBox.getSelectedItem().toString());
		interestValue.setText(Float.toString(R));
	}
	
});




/*
 * Adding ActionListeners for apply loan
 */


applyForLoanButton.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		setcustIDinDB(Integer.parseInt(custIDValue.getText()));
		setLoanTypeinDB(loanTypeComboBox.getSelectedItem().toString());
		setLoanAmountinDB(loanAmountValue.getText());
		setTenureYearsinDB((Integer.parseInt(yearsValue.getText())*12));
		setTenureMonthsinDB(Integer.parseInt(monthsValue.getText()));
		
		Successful=op1.applyForLoanInDB(custIDinDB, loanTypeinDB, loanAmountinDB, tenureYearsinDB, tenureMonthsinDB);
	if(Successful){
		loanStatusLabel.setText("Applied For Loan");
	}
	else{
		JOptionPane.showMessageDialog(null, "Error","Error",JOptionPane.ERROR_MESSAGE);
	}
	}
	
});
		





calculateEMIButton.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		P=Integer.parseInt(amountValue.getText());
		N=Integer.parseInt(tenureValue.getText());
		EMI=P*(R/12/100)*(Math.pow((1+(R/12/100)), N)/(Math.pow((1+(R/12/100)),N)-1));
		emiValue.setText(Double.toString(EMI));
	}
	
});

	}

	public void setcustIDinDB(int custIDinDB) {
		this.custIDinDB = custIDinDB;
	}

	public void setLoanTypeinDB(String loanTypeinDB) {
		this.loanTypeinDB = loanTypeinDB;
	}

	public void setLoanAmountinDB(String loanAmountinDB) {
		this.loanAmountinDB = loanAmountinDB;
	}

	public void setTenureYearsinDB(int tenureYearsinDB) {
		this.tenureYearsinDB = tenureYearsinDB;
	}

	public void setTenureMonthsinDB(int tenureMonthsinDB) {
		this.tenureMonthsinDB = tenureMonthsinDB;
	}

	public double getEMI() {
		return EMI;
	}
	
	

}
