import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;


public class loanTypeSelection extends JPanel {

	private JPanel contentPane,loanTypeSelectionPanel, loanTypeDetailsPanel;
	
	private JLabel loanTypeLabel,roiLabel,minAmountLabel,maxAmountLabel,minTenureLabel,yearlyIncomeLabel,maxTenureLabel;
	private JLabel roiValueLabel,minAmountValueLabel,maxAmountValueLabel,minTenureValueLabel,yearlyIncomeValueLabel,maxTenureValueLabel;
	
	private JComboBox loanTypeSelectionComboBox; 
	
	private String selectedLoanType;
	operatorDBCheck o1=new operatorDBCheck();
private String loanType[]={"Personal","Home","Car","Business","Educational"};
	
	public loanTypeSelection() {
		setLayout(new BorderLayout());
		setVisible(true);
	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new BorderLayout());
		add(contentPane,BorderLayout.CENTER);
		loanTypeSelectionPanel = new JPanel();
		contentPane.add(loanTypeSelectionPanel,BorderLayout.NORTH);   // panel for loan type selection
		
		loanTypeLabel = new JLabel("LOAN TYPE");
		loanTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		loanTypeSelectionPanel.add(loanTypeLabel);
		
		loanTypeSelectionComboBox = new JComboBox(loanType);
		loanTypeSelectionPanel.add(loanTypeSelectionComboBox);
	
		loanTypeDetailsPanel=new JPanel();
		contentPane.add(loanTypeDetailsPanel,BorderLayout.CENTER);     // panel for loan type details
		
		loanTypeDetailsPanel.setBorder(BorderFactory.createEtchedBorder(4, Color.red, Color.blue));
		
		loanTypeDetailsPanel.setLayout(new GridLayout(6,2));
		loanTypeDetailsPanel.setBorder(new EmptyBorder(20, 80, 20, 80));
		
		//// Defining Labels
	
		roiLabel =new JLabel("RATE OF INTEREST ",SwingConstants.CENTER);
		roiValueLabel =new JLabel();
		minAmountLabel =new JLabel("MINIMUM AMOUNT ",SwingConstants.CENTER);
		minAmountValueLabel =new JLabel();
		maxAmountLabel =new JLabel("MAXIMUM AMOUNT",SwingConstants.CENTER);
		maxAmountValueLabel =new JLabel();
		minTenureLabel =new JLabel("MINIMUM TENURE",SwingConstants.CENTER);
		minTenureValueLabel =new JLabel();
		yearlyIncomeLabel =new JLabel("YEARLY INCOME",SwingConstants.CENTER);
		yearlyIncomeValueLabel =new JLabel();
		maxTenureLabel =new JLabel("MAXIMUM TENURE",SwingConstants.CENTER);
		maxTenureValueLabel =new JLabel();
		
		// END of defining Labels
		
		//adding border to labels
		
		roiLabel.setBorder(BorderFactory.createLineBorder(Color.black));				// for creating border of label
		roiLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));			// for increasing size of label
		minAmountLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		minAmountLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		maxAmountLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		maxAmountLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		minTenureLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		minTenureLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		yearlyIncomeLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		yearlyIncomeLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		maxTenureLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		maxTenureLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		roiValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		roiValueLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		minAmountValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		minAmountValueLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		maxAmountValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		maxAmountValueLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		minTenureValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		minTenureValueLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		yearlyIncomeValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		yearlyIncomeValueLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		maxTenureValueLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		maxTenureValueLabel.setFont(new Font(null, roiLabel.getFont().getStyle(), 15));
		
		// End of Adding border to labels
		
		
		//// Adding Labels in loanTypeDetailsPanel
		loanTypeDetailsPanel.add(roiLabel);
		loanTypeDetailsPanel.add(roiValueLabel);
		loanTypeDetailsPanel.add(minAmountLabel);
		loanTypeDetailsPanel.add(minAmountValueLabel);
		loanTypeDetailsPanel.add(maxAmountLabel);
		loanTypeDetailsPanel.add(maxAmountValueLabel);
		loanTypeDetailsPanel.add(minTenureLabel);
		loanTypeDetailsPanel.add(minTenureValueLabel);
		loanTypeDetailsPanel.add(yearlyIncomeLabel);
		loanTypeDetailsPanel.add(yearlyIncomeValueLabel);
		loanTypeDetailsPanel.add(maxTenureLabel);
		loanTypeDetailsPanel.add(maxTenureValueLabel);
	
		//// End of adding Label in loanTypeDetailsPanel
		
		
		
		
		loanTypeSelectionComboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				selectedLoanType= loanTypeSelectionComboBox.getSelectedItem().toString();   //for getting string of value selected in JComboBox
		
				// specifying value of particular labels 
				
				switch(selectedLoanType)
				{
				case "Home":
					
					o1.loanTypeSelectionUpdate(selectedLoanType);
					roiValueLabel.setText(o1.getRoiValue());
					minAmountValueLabel.setText(o1.getMinAmountValue());
						maxAmountValueLabel.setText(o1.getMaxAmountValue());
						minTenureValueLabel.setText(o1.getMinTenureValue());
						yearlyIncomeValueLabel.setText(o1.getYearlyIncomeValue());
						maxTenureValueLabel.setText(o1.getMaxTenureValue());
				break;
				case "car":
					o1.loanTypeSelectionUpdate(selectedLoanType);
					roiValueLabel.setText(o1.getRoiValue());
					minAmountValueLabel.setText(o1.getMinAmountValue());
						maxAmountValueLabel.setText(o1.getMaxAmountValue());
						minTenureValueLabel.setText(o1.getMinTenureValue());
						yearlyIncomeValueLabel.setText(o1.getYearlyIncomeValue());
						maxTenureValueLabel.setText(o1.getMaxTenureValue());
				break;
				
				case "Personal":
					o1.loanTypeSelectionUpdate(selectedLoanType);
					roiValueLabel.setText(o1.getRoiValue());
					minAmountValueLabel.setText(o1.getMinAmountValue());
						maxAmountValueLabel.setText(o1.getMaxAmountValue());
						minTenureValueLabel.setText(o1.getMinTenureValue());
						yearlyIncomeValueLabel.setText(o1.getYearlyIncomeValue());
						maxTenureValueLabel.setText(o1.getMaxTenureValue());
				break;
				
				case "Business":
					o1.loanTypeSelectionUpdate(selectedLoanType);
					roiValueLabel.setText(o1.getRoiValue());
					minAmountValueLabel.setText(o1.getMinAmountValue());
						maxAmountValueLabel.setText(o1.getMaxAmountValue());
						minTenureValueLabel.setText(o1.getMinTenureValue());
						yearlyIncomeValueLabel.setText(o1.getYearlyIncomeValue());
						maxTenureValueLabel.setText(o1.getMaxTenureValue());
						break;
						
				case "Educational":
					o1.loanTypeSelectionUpdate(selectedLoanType);
					roiValueLabel.setText(o1.getRoiValue());
					minAmountValueLabel.setText(o1.getMinAmountValue());
						maxAmountValueLabel.setText(o1.getMaxAmountValue());
						minTenureValueLabel.setText(o1.getMinTenureValue());
						yearlyIncomeValueLabel.setText(o1.getYearlyIncomeValue());
						maxTenureValueLabel.setText(o1.getMaxTenureValue());
						break;
						
				default:
					o1.loanTypeSelectionUpdate(selectedLoanType);
					roiValueLabel.setText(o1.getRoiValue());
					minAmountValueLabel.setText(o1.getMinAmountValue());
						maxAmountValueLabel.setText(o1.getMaxAmountValue());
						minTenureValueLabel.setText(o1.getMinTenureValue());
						yearlyIncomeValueLabel.setText(o1.getYearlyIncomeValue());
						maxTenureValueLabel.setText(o1.getMaxTenureValue());
					
					break;
					
				}		
				
				// end of specifying value of particular labels 
			}
			
		});
		
	
		
		
		
	}

}
