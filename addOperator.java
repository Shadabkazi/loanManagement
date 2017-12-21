import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;



public class addOperator extends JPanel {

	private JPanel contentPane;
	private JPanel basePanel,innerPanel,downPanel;
	private JLabel userLabel,passLabel,retypePassLabel;
	private String UserField,PassField,reTypePassField;
	
	private JButton addButton,backButton;
	private JTextField userField;
	private JPasswordField passField,retypePassField;
	
	private Boolean successful=false;
	
	
	public addOperator() {
		setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		add(contentPane);
		
		basePanel =new JPanel(); 
		 basePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "ADD OPERATOR"));
		contentPane.add(basePanel,BorderLayout.CENTER);
		basePanel.setLayout(new BorderLayout());
		
		
		innerPanel=new JPanel();
		basePanel.add(innerPanel,BorderLayout.CENTER);
		innerPanel.setBorder(new EmptyBorder(15,80,15,80));

		GridBagLayout gl_innerPanel = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		innerPanel.setLayout(gl_innerPanel);
		
		// adding username label
		userLabel = new JLabel("Username");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets=new Insets(10,10,10,10);    // for space between components
		innerPanel.add(userLabel,c);
		userLabel.setHorizontalAlignment(JLabel.CENTER);
		userLabel.setFont(new Font(null, userLabel.getFont().getStyle(), 20));
	
		// adding password label 
		passLabel = new JLabel("Password");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		innerPanel.add(passLabel,c);
		passLabel.setFont(new Font(null, userLabel.getFont().getStyle(), 20));
		passLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// adding retype password label
		retypePassLabel = new JLabel("Retype Password");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		innerPanel.add(retypePassLabel,c);
		retypePassLabel.setFont(new Font(null, userLabel.getFont().getStyle(), 20));
		retypePassLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// adding username,password, retypepassword field
		userField =new JTextField();
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx =0;
		c.gridy = 1;
		innerPanel.add(userField,c);
		passField =new JPasswordField();
		passField.setEchoChar('*');
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		innerPanel.add(passField,c);
	
		retypePassField =new JPasswordField();
		retypePassField.setEchoChar('*');
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		innerPanel.add(retypePassField,c);
		
		
		//adding add button
		addButton =new JButton("Add");
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
	innerPanel.add(addButton,c);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		addButton.setBorder(BorderFactory.createMatteBorder(0, 95, 0, 95, getBackground()));
		
		addButton.addActionListener(new ActionListener(){			// adding actionListener for add operator 

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setUserField(userField.getText());
				setPassField(passField.getText());
				setreTypePassField(retypePassField.getText());
			
			adminDBCheck dbCheck=new adminDBCheck();
			if(PassField.equals(reTypePassField)){
				if(UserField.length()>2 || PassField.length()>2){
			successful=dbCheck.addOperatorInDB(UserField, PassField);
			
				}
			}
			if(successful){
			JOptionPane.showMessageDialog(null, "Operator Added Successfully");
			loginScreen ls=new loginScreen();
			ls.dispose();
			ls.repaint();
			ls.revalidate();
			removeOperator rm=  new removeOperator();
			rm.repaint();
			rm.revalidate();
			}
			else{
				JOptionPane.showMessageDialog(null, "Username not found OR Passwords Dont Match", "Invalid Password", JOptionPane.ERROR_MESSAGE);
			}
			}						
			
		});
		
	}


	public void setUserField(String UserField) {
		this.UserField = UserField;
	}


	public void setPassField(String PassField) {
		this.PassField = PassField;
	}

	public void setreTypePassField(String reTypePassField) {
		this.reTypePassField = reTypePassField;
	}
}
