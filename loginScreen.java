import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;


public class loginScreen extends JFrame {

	private JPanel contentPane;
	private ImagePanel innerPanel;
private JLabel loginLabel,loginAsLabel,usernameLabel,passwordLabel,invalidLogin,loginIcon;
private JComboBox userAuthentication;
private JTextField usernameField;
private JPasswordField passwordField;

private JButton signInbtn;
private String typeOfUsers[]={"Operator","Administrator"};
private GridBagConstraints c;
private String Username,Password;

private Boolean loginAccess=false;
private CardLayout cl;

private static BufferedImage img;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					loginScreen frame = new loginScreen();
					frame.setVisible(true);
				    frame.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
				    frame.contentPane.setBackground(new Color(253,213,178));
				    /**img = ImageIO.read(new File("C:\\Users\\saqibmubarak\\workspace\\loanManagement1\\src\\bg.jpg"));
				    JLabel background = new JLabel();**/
					//background.setIcon((Icon) img);
				    
				    frame.getContentPane().setBackground(new Color(238, 232, 170));
				    frame.setLocationRelativeTo(null);
				    JRootPane rootPane = frame.getRootPane();
				    
				    
				    
				    /****new align middle*****/
				   // Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				   // frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				    /****new align middle ends*****/

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginScreen() {
		setTitle("HDFC Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(getMaximumSize());
		
		///setBounds(100, 100, 538, 324);
		contentPane = new JPanel();
		
		//new ImageIcon(ImageIO.read(new File("C:/Users/saqibmubarak/workspace/loanManagement1/src/"))
		//JLabel background = new JLabel();
		//background.setIcon((Icon) img);
		//innerPanel=new JPanel();
		innerPanel = new ImagePanel(new ImageIcon("C:\\Users\\saqibmubarak\\workspace\\loanManagement1\\src\\bg.jpg").getImage());
		innerPanel.setLayout(new GridBagLayout());
		innerPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		
		//innerPanel.setBackground(new Color(242,221,241));
		//innerPanel.setBounds(100, 100, 450, 300);
		
		loginIcon = new JLabel("",SwingConstants.CENTER);
		loginIcon.setIcon(new ImageIcon("C:\\Users\\saqibmubarak\\workspace\\loanManagement1\\src\\login1.png"));

		
		
		cl=new CardLayout();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(cl);
		
		
		Font defaultFont = new Font("Verdana", Font.BOLD, 15);
		
		loginLabel = new JLabel("Login",SwingConstants.CENTER);
		loginLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		loginLabel.setBorder(new EmptyBorder(60,0,20,0));
		loginAsLabel= new JLabel("Login As",SwingConstants.CENTER);
		loginAsLabel.setFont(defaultFont);
		usernameLabel=new JLabel("Username",SwingConstants.CENTER);
		usernameLabel.setFont(defaultFont);
		passwordLabel=new JLabel("Password",SwingConstants.CENTER);
		passwordLabel.setFont(defaultFont);
		invalidLogin=new JLabel("Invalid Username or password");
		
		userAuthentication=new JComboBox(typeOfUsers);
		usernameField=new JTextField(30);
		passwordField=new JPasswordField(30);
		passwordField.setEchoChar('*');
		
		signInbtn=new JButton("Sign in");
		
		
	
		c = new GridBagConstraints();
		contentPane.add(innerPanel,BorderLayout.CENTER);
		
		/**c.fill=GridBagConstraints.NORTH;
		
		
		c.gridx=1;
		c.gridy=0;
		**/
		
		
		
		c.fill=GridBagConstraints.VERTICAL;
		
		c.gridx=1;
		c.gridy=0;
		
		innerPanel.add(loginLabel, c);
		c.fill=GridBagConstraints.VERTICAL;
		c.gridx=0;
		c.gridy=0;
		
		c.insets=new Insets(10,10,10,10);
		innerPanel.add(loginIcon, c);
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		innerPanel.add(loginAsLabel,c);
		
		c.gridx = 1;
		c.gridy = 1;
		innerPanel.add(userAuthentication,c);
		innerPanel.add(usernameLabel,c);
		c.gridx = 0;
		c.gridy = 2;
		innerPanel.add(usernameLabel,c);
		
		c.gridx = 1;
		c.gridy = 2;
		innerPanel.add(usernameField,c);
		
		c.gridx = 0;
		c.gridy = 3;
		innerPanel.add(passwordLabel,c);
		c.gridx = 1;
		c.gridy = 3;
		innerPanel.add(passwordField,c);
		
c.fill=GridBagConstraints.CENTER;
c.gridx=1;
c.gridy=4;
innerPanel.add(signInbtn, c);
c.gridx=1;
c.gridy=5;
innerPanel.add(invalidLogin,c);
invalidLogin.setVisible(false);

signInbtn.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		checkLogin();
		
	}
	
});

	
contentPane.add(innerPanel, "1");

operatorMainMenu operatorMenu=new operatorMainMenu();
contentPane.add(operatorMenu, "2");
adminMenu admin=new adminMenu();
contentPane.add(admin, "3");

cl.show(contentPane, "1");

add(contentPane);

//entertopress
rootPane.setDefaultButton(signInbtn);

		
	}


	public void setUsername(String username) {
		Username = username;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void checkLogin() {
	if(userAuthentication.getSelectedIndex()==0)
	{
		setUsername(usernameField.getText());
		setPassword(passwordField.getText());
		operatorDBCheck o2=new operatorDBCheck();
		loginAccess=o2.operatorLoginCheck(Username,Password);
		if(loginAccess){
			cl.show(contentPane, "2");
		}
		else{
			invalidLogin.setVisible(true);
		}
			}
	else if(userAuthentication.getSelectedIndex()==1)
	{
	setUsername(usernameField.getText());
		setPassword(passwordField.getText());
		
		
		adminDBCheck o1=new adminDBCheck();
		
		loginAccess=o1.adminLoginCheck(Username, Password);
		
	if(loginAccess) {               
			cl.show(contentPane, "3");
	}
	else{
		invalidLogin.setVisible(true);
		
	}
		}
		
		
	}
	}


