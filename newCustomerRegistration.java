import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class newCustomerRegistration extends JPanel {

	private JPanel contentPane,innerPanel;
private JLabel firstNameLabel,lastNameLabel,genderLabel,addressLabel,cityLabel,stateLabel,phoneNoLabel,emailIDLabel,occupationLabel,annualIncomeLabel;
private JTextField firstNameValue,lastNameValue,cityValue,stateValue,phoneNoValue,emailIDValue,occupationValue,annualIncomeValue;
private JTextArea addressValue;
private JButton registerButton;
private JRadioButton male,female;
private ButtonGroup gender;
private Boolean successful;
private String firstNameDB,lastNameDB,genderDB,cityDB,stateDB,phoneNoDB,emailIDDB,occupationDB,annualIncomeDB,addressDB;
	
	public newCustomerRegistration() {
		setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		
		add(contentPane);
		
	/*
	 * declaring components	
	 */
	
		innerPanel=new JPanel();
		
		firstNameLabel=new JLabel("First Name");
		lastNameLabel=new JLabel("Last Name");
		genderLabel=new JLabel("Gender");
		addressLabel=new JLabel("Address");
		cityLabel=new JLabel("City");
		stateLabel=new JLabel("State");
		phoneNoLabel=new JLabel("Phone No.");
		emailIDLabel=new JLabel("Email ID");
		occupationLabel=new JLabel("Occupation");
		annualIncomeLabel=new JLabel("Annual Income");
		
		
		firstNameValue=new JTextField(15);
		lastNameValue=new JTextField(15);
		cityValue=new JTextField(15);
		stateValue=new JTextField(15);
		phoneNoValue=new JTextField(15);
		emailIDValue=new JTextField(15);
		occupationValue=new JTextField(15);
		annualIncomeValue=new JTextField(15);
		
		addressValue=new JTextArea();
		addressValue.setRows(3);
		addressValue.setColumns(3);
		addressValue.setLineWrap(true);
		
		registerButton=new JButton("Register");
		
		male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		
		gender=new ButtonGroup();
		gender.add(male);
		gender.add(female);
		
		
		/*
	 * End Of Declaring Components
	 */
		
		
		/*
		 * Inner Panel
		 */
		
		contentPane.add(innerPanel,BorderLayout.CENTER);
		innerPanel.setPreferredSize(new Dimension(600,600));
		innerPanel.setLayout(new GridBagLayout());
		
		innerPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
		GridBagConstraints c=new GridBagConstraints();
	
		c.insets=new Insets(10,10,10,10);
		c.fill=GridBagConstraints.HORIZONTAL;

		c.gridx=0;
		c.gridy=1;
		innerPanel.add(firstNameLabel, c);
		c.gridx=1;
		c.gridy=1;
		innerPanel.add(firstNameValue, c);
		c.gridx=0;
		c.gridy=2;
		innerPanel.add(lastNameLabel, c);
		c.gridx=1;
		c.gridy=2;
		innerPanel.add(lastNameValue, c);
		c.gridx=0;
		c.gridy=3;
		innerPanel.add(genderLabel, c);
		c.gridx=1;
		c.gridy=3;
		innerPanel.add(male, c);
		c.gridx=2;
		c.gridy=3;
		innerPanel.add(female, c);
		
		c.gridx=0;
		c.gridy=4;
		innerPanel.add(addressLabel, c);
		c.gridx=1;
		c.gridy=4;
		
		innerPanel.add(addressValue, c);
		c.gridx=0;
		c.gridy=5;
		innerPanel.add(cityLabel, c);
		c.gridx=1;
		c.gridy=5;
		innerPanel.add(cityValue, c);
		c.gridx=0;
		c.gridy=6;
		innerPanel.add(stateLabel, c);
		c.gridx=1;
		c.gridy=6;
		innerPanel.add(stateValue, c);
		c.gridx=0;
		c.gridy=7;
		innerPanel.add(phoneNoLabel, c);
		c.gridx=1;
		c.gridy=7;
		innerPanel.add(phoneNoValue, c);
		c.gridx=0;
		c.gridy=8;
		innerPanel.add(emailIDLabel, c);
		c.gridx=1;
		c.gridy=8;
		innerPanel.add(emailIDValue, c);
		c.gridx=0;
		c.gridy=9;
		innerPanel.add(occupationLabel, c);
		c.gridx=1;
		c.gridy=9;
		innerPanel.add(occupationValue, c);
		c.gridx=0;
		c.gridy=10;
		innerPanel.add(annualIncomeLabel, c);
		c.gridx=1;
		c.gridy=10;
		innerPanel.add(annualIncomeValue, c);
		c.gridx=1;
		c.gridy=11;
		innerPanel.add(registerButton, c);
	
		registerButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setFirstNameDB(firstNameValue.getText());
				setLastNameDB(lastNameValue.getText());
				if(male.isSelected())
					genderDB="Male";
				else{
					genderDB="Female";
				}
				setGenderDB(genderDB);
				setCityDB(cityValue.getText());
				setStateDB(stateValue.getText());
				setPhoneNoDB(phoneNoValue.getText());
				setEmailIDDB(emailIDValue.getText());
				setOccupationDB(occupationValue.getText());
				setAnnualIncomeDB(annualIncomeValue.getText());
				setAddressDB(addressValue.getText());
				
				
				operatorDBCheck o1=new operatorDBCheck();
				successful=o1.newCustomerRegistrationInDB(firstNameDB,lastNameDB,genderDB,cityDB,stateDB,phoneNoDB,emailIDDB,occupationDB,annualIncomeDB,addressDB);
				if(successful){
					JOptionPane.showMessageDialog(null, "Registration successful","Success",JOptionPane.INFORMATION_MESSAGE);
					firstNameValue.setText("");
					lastNameValue.setText("");
					cityValue.setText("");
					stateValue.setText("");
					phoneNoValue.setText("");
					emailIDValue.setText("");
					occupationValue.setText("");
					annualIncomeValue.setText("");
					addressValue.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "Something Went wrong","Failure",JOptionPane.ERROR_MESSAGE);

				}
			}
			
		});
		
		
	}

	public void setFirstNameDB(String firstNameDB) {
		this.firstNameDB = firstNameDB;
	}

	public void setLastNameDB(String lastNameDB) {
		this.lastNameDB = lastNameDB;
	}

	public void setGenderDB(String genderDB) {
		this.genderDB = genderDB;
	}

	public void setCityDB(String cityDB) {
		this.cityDB = cityDB;
	}

	public void setStateDB(String stateDB) {
		this.stateDB = stateDB;
	}

	public void setPhoneNoDB(String phoneNoDB) {
		this.phoneNoDB = phoneNoDB;
	}

	public void setEmailIDDB(String emailIDDB) {
		this.emailIDDB = emailIDDB;
	}

	public void setOccupationDB(String occupationDB) {
		this.occupationDB = occupationDB;
	}

	public void setAnnualIncomeDB(String annualIncomeDB) {
		this.annualIncomeDB = annualIncomeDB;
	}

	public void setAddressDB(String addressDB) {
		this.addressDB = addressDB;
	}

	
	
	
	
}
