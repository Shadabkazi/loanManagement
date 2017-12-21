import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class removeOperator extends JPanel {

	private JPanel contentPane,innerPanel;
	private JComboBox operatorSelect;
	private JButton removeBtn;
	private ArrayList<String> operatorNames;
	private String selectedOperatorName;
	private adminDBCheck dbCheck,dbCheck1;
	private Boolean successful;
	
	public removeOperator() {
		setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());
add(contentPane);
		GridBagConstraints d=new GridBagConstraints();
		
		innerPanel=new JPanel();
		
		dbCheck=new adminDBCheck();
		operatorNames=new ArrayList<String>();
		operatorNames=dbCheck.getOperatorName();
		operatorSelect=new JComboBox();
for(String value:operatorNames){
	operatorSelect.addItem(value);
}
	
	

removeBtn=new JButton("Remove");

contentPane.add(innerPanel,d);
innerPanel.setLayout(new GridBagLayout());
innerPanel.setPreferredSize(new Dimension(400,400));
innerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Remove Operator"));
GridBagConstraints c=new GridBagConstraints();
c.insets=new Insets(30,5,30,5);				// Distance between components

c.gridx=0;
c.gridy=0;
c.ipadx=10;
c.fill=GridBagConstraints.HORIZONTAL;			// For aligning components
innerPanel.add(operatorSelect,c);

//c.weightx=2.0;
c.gridwidth=2;
c.gridx=0;
c.gridy=3;
innerPanel.add(removeBtn,c);

removeBtn.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		selectedOperatorName=(String) operatorSelect.getSelectedItem();
successful=dbCheck.removeSelectedOperator(selectedOperatorName);

if(successful){
	operatorSelect.removeAllItems();
	operatorNames=dbCheck.getOperatorName();
	operatorSelect.setVisible(false);
	for(String value:operatorNames){
		operatorSelect.addItem(value);
	} 
	operatorSelect.setVisible(true);
	JOptionPane.showMessageDialog(null, "Operator "+selectedOperatorName+" deleted Successfully");
}
}
	
});
		



	}

	

}
