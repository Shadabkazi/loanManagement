import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class operatorMainMenu extends JPanel{

	private JPanel bankNamePanel,innerPanel,mainPanel,blankPanel;
	private JLabel bankNameLabel;
	private JButton loanDetailsbtn,servicesbtn,applyForLoanbtn,paymentbtn,addNewCustomerbtn,logoutbtn;
private CardLayout cl;
	
	public operatorMainMenu() {
		setLayout(new BorderLayout());
		cl=new CardLayout();
		
		
		bankNamePanel = new JPanel();
		innerPanel=new JPanel();
		mainPanel=new JPanel();
		blankPanel=new JPanel();			// initial panel after loginScreen
		
		bankNameLabel=new JLabel("BANK NAME",SwingConstants.CENTER);
		bankNameLabel.setFont(new Font("Verdana", Font.BOLD, 35));
		
		//add(bankNamePanel,BorderLayout.NORTH);
		add(innerPanel,BorderLayout.NORTH);
		add(mainPanel,BorderLayout.CENTER);		
		innerPanel.setBackground(new Color(173,216,230));
		mainPanel.setBackground(new Color(173,216,230));
		blankPanel.setBackground(new Color(173,216,230));


		
		
		bankNamePanel.add(bankNameLabel);
		bankNamePanel.setBorder(new EmptyBorder(0,0,50,0));
		
		innerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,50));
		loanDetailsbtn=new JButton("Loan Details");
		servicesbtn=new JButton("Services");
		applyForLoanbtn=new JButton("Apply For Loan");
		paymentbtn=new JButton("Payment");
		addNewCustomerbtn=new JButton("Add New Customer");
logoutbtn=new JButton("Logout");		
		

		innerPanel.add(loanDetailsbtn);
		innerPanel.add(servicesbtn);
		innerPanel.add(applyForLoanbtn);
		innerPanel.add(paymentbtn);
		innerPanel.add(addNewCustomerbtn);
		innerPanel.add(logoutbtn);
		
		
		mainPanel.setLayout(cl);
		mainPanel.add(blankPanel, "1");
		loanDetails lDetails=new loanDetails();
		mainPanel.add(lDetails, "2");
		loanTypeSelection loanType=new loanTypeSelection();
		mainPanel.add(loanType, "3");
		applyForLoan applyLoan=new applyForLoan();
		mainPanel.add(applyLoan, "4");
		payment pay1=new payment();
		mainPanel.add(pay1, "5");
		newCustomerRegistration newCustomer=new newCustomerRegistration();
		mainPanel.add(newCustomer, "6");
		
		cl.show(mainPanel, "1"); 			// shows blank Panel on top
		
		
		
		/*
		 * adding actionListener to buttons
		 */
		
		loanDetailsbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "2");
				
			}
			
		});
		
		
		servicesbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "3");
			}
			
		});
		
		
		applyForLoanbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "4");
			}
			
		});
		paymentbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "5");
			}
			
		});
		addNewCustomerbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(mainPanel, "6");
			}
			
		});
		
		
		logoutbtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginScreen ls=new loginScreen();
				ls.setVisible(false);
				 ((Window) getRootPane().getParent()).dispose();
					ls.main(null);
				
			}
			
		});
		
	
		
	}



}
