import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class approveLoan extends JPanel {

	private JPanel contentPane,firstPanel,secondPanel,thirdPanel;
private JLabel custIDLabel,custNameLabel,loanTypeLabel,loanStatusLabel;
private JLabel custNameValueLabel,loanTypeValueLabel,loanStatusValueLabel;
private JButton searchButton,approveButton,loanDetailsButton;
private JTextField custIDValue;
private String C_ID;
public Boolean successful;
adminDBCheck a=new adminDBCheck();
operatorDBCheck op=new operatorDBCheck();
private ArrayList<String> custDetailsArrayList;
	
	public approveLoan() {
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
		loanStatusLabel=new JLabel("Loan Status");
			
		custNameValueLabel=new JLabel();
		loanTypeValueLabel=new JLabel();
		loanStatusValueLabel=new JLabel();
		
		
		custIDValue=new JTextField(15);			// Declaring TextFields			
		
		
		searchButton=new JButton("Search");			//Declaring Buttons
		approveButton=new JButton("Approve");
		loanDetailsButton=new JButton("Loan Details");
		
		
		contentPane.add(firstPanel);		// Adding Panels to contentPane
		contentPane.add(secondPanel);
		contentPane.add(thirdPanel);
		
		
		firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		secondPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		thirdPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		
		
		/*
		 * First Panel
		 */
		firstPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
		
		firstPanel.add(custIDLabel);
		firstPanel.add(custIDValue);
		firstPanel.add(searchButton);
		firstPanel.add(loanDetailsButton);
		
		
		/*
		 * End of First Panel
		 */
		
		/*
		 * Second Panel
		 */
		
	
		//loanTypeValueLabel,principleAmountValueLabel,balanceAmountValueLabel,EMILeftValueLabel
		
		secondPanel.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.fill=GridBagConstraints.CENTER;
		c.insets=new Insets(10,10,10,10);
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
		secondPanel.add(loanStatusLabel, c);
		c.gridx=1;
		c.gridy=2;
		secondPanel.add(loanStatusValueLabel, c);
		
		/*
		 * End of Second Panel
		 */
		
		/*
		 * Third Panel
		 */
		
		thirdPanel.setLayout(new GridBagLayout());
		GridBagConstraints z=new GridBagConstraints();
		z.gridx=0;
		z.gridy=0;
		thirdPanel.add(approveButton,z);
		
		/*
		 * End of Third Panel
		 */
		
		
		
		/*
		 * Adding actionListeners
		 */
		
		approveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			successful=a.approveCustomerLoan(custIDValue.getText().toString());
				if(successful){
					a.getDetails(custIDValue.getText().toString());
					JOptionPane.showMessageDialog(null, "Loan Approved for "+a.getCustName(),"Approved", JOptionPane.INFORMATION_MESSAGE);
					loanStatusValueLabel.setText("");
					loanStatusValueLabel.setText(a.getLoanStatus());
				}
			}
			
		});
		
		searchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			
			a.getDetails(custIDValue.getText().toString());
	custNameValueLabel.setText(a.getCustName());
	loanTypeValueLabel.setText(a.getLoanName());
	loanStatusValueLabel.setText(a.getLoanStatus());
			}
			
		});
		
		loanDetailsButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				loaninfo l =new loaninfo();
				l.setVisible(true);
				
			}
			
		});
	}
}
