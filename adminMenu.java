import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class adminMenu extends JPanel {

	private JPanel contentPane,bankNamePanel,innerPanel,mainPanel,blankPanel;
	private JLabel bankNameLabel;
	private JButton loanAddUpdatebtn,approveLoanbtn,dailyCollectionbtn,addOperatorbtn,removeOperatorbtn,logoutbtn;
	private CardLayout cl;
	
	public adminMenu() {
		setLayout(new BorderLayout());
		cl=new CardLayout();
		
		contentPane = new JPanel();
		mainPanel=new JPanel();
		blankPanel=new JPanel();
		
		
		mainPanel.setLayout(cl);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
	
		add(contentPane);
		Font defaultFont = new Font("Verdana", Font.BOLD, 15);

		
		
		innerPanel=new JPanel();
		
		
		contentPane.add(innerPanel,BorderLayout.NORTH);
		contentPane.add(mainPanel, BorderLayout.CENTER);

		innerPanel.setLayout(new FlowLayout());
		innerPanel.setFont(defaultFont);
		loanAddUpdatebtn=new JButton("Loan ADD/Update");
		loanAddUpdatebtn.setFont(defaultFont);
		approveLoanbtn=new JButton("Approve Loan");
		approveLoanbtn.setFont(defaultFont);
		dailyCollectionbtn=new JButton("Daily Collection");
		dailyCollectionbtn.setFont(defaultFont);
addOperatorbtn=new JButton("Add Operator");
addOperatorbtn.setFont(defaultFont);
removeOperatorbtn=new JButton("Remove Operator");
removeOperatorbtn.setFont(defaultFont);
logoutbtn=new JButton("Logout");

		innerPanel.add(loanAddUpdatebtn);
		innerPanel.add(approveLoanbtn);
	//	innerPanel.add(dailyCollectionbtn);
		innerPanel.add(addOperatorbtn);
		innerPanel.add(removeOperatorbtn);
		innerPanel.add(logoutbtn);
		
		logoutbtn.setFont(defaultFont);	
		
		mainPanel.add(blankPanel, "1");
		cl.show(mainPanel, "1");
		updateOrAddLoan addUpdate=new updateOrAddLoan();
		mainPanel.add(addUpdate, "2");
		approveLoan aLoan=new approveLoan();
		mainPanel.add(aLoan,"3");
	
		addOperator ao=new addOperator();
		mainPanel.add(ao, "5");
		removeOperator ro=new removeOperator();
		mainPanel.add(ro, "6");
		
		loanAddUpdatebtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				cl.show(mainPanel, "2");
			}
			
		});
		
	approveLoanbtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			cl.show(mainPanel, "3");
			
		}
		
	});
	

	addOperatorbtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			cl.show(mainPanel, "5");
		}
		
	});
	
	removeOperatorbtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
cl.show(mainPanel, "6");			
		}
		
	});
	
	
	logoutbtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			
		
		loginScreen ls=new loginScreen();
			ls.setVisible(false);
			 ((Window) getRootPane().getParent()).dispose();
				ls.main(null);
		
			
		}
		
	});
	}

}
