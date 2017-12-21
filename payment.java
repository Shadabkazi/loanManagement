import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class payment extends JPanel {

	private JPanel contentPane,firstPanel,secondPanel,thirdPanel;
private JLabel custIDLabel,custNameLabel,loanTypeLabel,principleAmountLabel,balanceAmountLabel,EMILeftLabel,noOfEMIToPayLabel;
private JLabel custNameValueLabel,loanTypeValueLabel,principleAmountValueLabel,balanceAmountValueLabel,EMILeftValueLabel;
private JButton searchButton,submitButton;
private JTextField custIDValue,noOfEMIToPayValue;
private String C_ID;
private int noOfEMIToPay;
private Boolean successful;

operatorDBCheck op=new operatorDBCheck();
	
	public payment() {
		setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		add(contentPane);
		
		firstPanel=new JPanel();			// Declaring Panels
		secondPanel=new JPanel();
		thirdPanel=new JPanel();
		
		custIDLabel=new JLabel("Customer ID");			// Declaring Labels
		custNameLabel=new JLabel("Customer Name");
		loanTypeLabel=new JLabel("Loan Type");
		principleAmountLabel=new JLabel("Principle Amount");
		balanceAmountLabel=new JLabel("Balance Amount");
		EMILeftLabel =new JLabel("EMI Left");
		noOfEMIToPayLabel=new JLabel("No. of EMI to pay");
			
		custNameValueLabel=new JLabel();
		loanTypeValueLabel=new JLabel();
		principleAmountValueLabel=new JLabel();
		balanceAmountValueLabel=new JLabel();
		EMILeftValueLabel =new JLabel();
		
		
		custIDValue=new JTextField(15);			// Declaring TextFields			
		noOfEMIToPayValue=new JTextField(15);
		
		
		searchButton=new JButton("Search");			//Declaring Buttons
		submitButton=new JButton("Submit");

		
		contentPane.add(firstPanel);		// Adding Panels to contentPane
		contentPane.add(secondPanel);
		contentPane.add(thirdPanel);
		
		
		firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		secondPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		thirdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		
		/*
		 * First Panel
		 */
		firstPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
		
		firstPanel.add(custIDLabel);
		firstPanel.add(custIDValue);
		firstPanel.add(searchButton);
		
		
		/*
		 * End of First Panel
		 */
		
		/*
		 * Second Panel
		 */
		
	
		//loanTypeValueLabel,principleAmountValueLabel,balanceAmountValueLabel,EMILeftValueLabel
		
		secondPanel.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.weightx=0.5;
		c.weighty=0.5;
		c.gridx=0;
		c.gridy=0;
		secondPanel.add(custNameLabel, c);
		c.gridx=1;
		c.gridy=0;
		secondPanel.add(custNameValueLabel, c);
		c.gridx=0;
		c.gridy=1;
		secondPanel.add(loanTypeLabel, c);
		c.gridx=1;
		c.gridy=1;
		secondPanel.add(loanTypeValueLabel, c);
		c.gridx=0;
		c.gridy=2;
		secondPanel.add(principleAmountLabel, c);
		c.gridx=1;
		c.gridy=2;
		secondPanel.add(principleAmountValueLabel, c);
		c.gridx=0;
		c.gridy=3;
		secondPanel.add(balanceAmountLabel, c);
		c.gridx=1;
		c.gridy=3;
		secondPanel.add(balanceAmountValueLabel, c);
		c.gridx=0;
		c.gridy=4;
		secondPanel.add(EMILeftLabel, c);
		c.gridx=1;
		c.gridy=4;
		secondPanel.add(EMILeftValueLabel, c);
		
		/*
		 * End of Second Panel
		 */
		
		/*
		 * Third Panel
		 */
		
		thirdPanel.setLayout(new GridBagLayout());
		GridBagConstraints d=new GridBagConstraints();
		d.insets=new Insets(10,10,10,10);
		
		d.gridx=0;
		d.gridy=0;
		thirdPanel.add(noOfEMIToPayLabel, d);
		d.gridx=1;
		d.gridy=0;
		thirdPanel.add(noOfEMIToPayValue, d);
		d.gridx=2;
		d.gridy=0;
		thirdPanel.add(submitButton, d);
		
		
		
		/*
		 * End of Third Panel
		 */
		
		
		
		/*
		 * Adding actionListeners
		 */
		
		searchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setC_ID(custIDValue.getText());
successful=op.getEMIDetails(C_ID);		
if(successful){
custNameValueLabel.setText(op.getCustomer_Name());
loanTypeValueLabel.setText(op.getLoan_Name());
principleAmountValueLabel.setText(op.getPrinciple_Amount());
balanceAmountValueLabel.setText(op.getBalance());
EMILeftValueLabel.setText(Integer.toString((Integer.parseInt(op.getTotal_EMI())-Integer.parseInt(op.getEMI_Submitted()))));
}
}
			
		});
	
		
		submitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
noOfEMIToPay=Integer.parseInt(noOfEMIToPayValue.getText());	
successful=op.paymentUpdateInDB(C_ID,noOfEMIToPay);
if(successful)
{
	JOptionPane.showMessageDialog(null, "EMI PAYMENT DONE", "EMI payment successful", JOptionPane.INFORMATION_MESSAGE);
}

			}
			
		});
		
		
	}


	public void setC_ID(String c_ID) {
		this.C_ID = c_ID;
	}

}
