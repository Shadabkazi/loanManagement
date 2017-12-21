import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class adminDBCheck {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/loanmanagement";
	
	// Database Credentials
	static final String USER="root";
	static final String PASS="root";
	
	private String Username;
	private String Password;
	private Boolean successful=false;
	private Connection conn= null;
	private Statement stmt=null,stmt1=null,stmt2=null,stmt3=null,stmt4=null,stmt5=null,stmt6=null,stmt7=null;
	private String sql,sql1,sql2,sql3,sql4,sql5,sql6,sql7;
	private ResultSet rs,rs1,rs7;
	private String custName,loanName,loanStatus;
	private ArrayList<String> usernameArrayList,custDetailsArrayList;
	
	public adminDBCheck(){
		
		
		try{
			// Regsiter JDBC Driver
			Class.forName(JDBC_DRIVER);
			
			// open a connection
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			
		}
		catch(SQLException se){
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
}
	// For Checking admin login credentials
	public Boolean adminLoginCheck(String username,String password){
		
			try {
				// Execute a query
				stmt= conn.createStatement();
		
				sql="Select Username,Password FROM admin WHERE Username='" + username + "' AND Password='" + password + " ';";
				
				
				rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				// retrieve data from result set
				
				Username=rs.getString("Username");
				Password=rs.getString("Password");
			}
		
			
			if(username==null || password==null || Username==null || Password==null)
			{
				successful=false;
			}
			else if((Username.equals(username)) && (Password.equals(password))){
				
				successful=true;
				
			}
			else{
				
			}
				
			rs.close();
			stmt.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return successful;
	
}
	
	public Boolean addNewLoanTypeInDB(String newLoanTypeNameDB,String roiDB,String minAmountDB,String maxAmountDB,String minTenureDB,String maxTenureDB,String yearlyIncomeDB){
		
		try{
		// Execute a query
		stmt2= conn.createStatement();
		
		sql2="INSERT INTO loan_type (Loan_Name, Rate_Of_Interest, Minimum_Amount, Maximum_Amount, Minimum_Tenure, Maximum_Tenure, Yearly_Income) VALUES ('"+newLoanTypeNameDB+"','"+roiDB+"','"+minAmountDB+"','"+maxAmountDB+"','"+minTenureDB+"','"+maxTenureDB+"','"+yearlyIncomeDB+"');";
		System.out.println(sql2);
		stmt2.executeUpdate(sql2);
		
		
		stmt2.close();
		successful=true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return successful;
	}
	
	
	public Boolean updateLoanTypeInDB(String selectedLoanType,String roiDB,String minAmountDB,String maxAmountDB,String minTenureDB,String maxTenureDB,String yearlyIncomeDB){
		try{
			// Execute a query
			stmt1= conn.createStatement();
			
			sql1="UPDATE loan_type set Rate_Of_Interest='"+roiDB+"', Minimum_Amount='"+minAmountDB+"', Maximum_Amount='"+maxAmountDB+"', Minimum_Tenure='"+minTenureDB+"', Maximum_Tenure='"+maxTenureDB+"', Yearly_Income='"+yearlyIncomeDB+"' WHERE Loan_Name='"+selectedLoanType+"';";    
			
			stmt1.executeUpdate(sql1);
			
			
			stmt1.close();
			successful=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return successful;
	
	}
	
	
	public Boolean addOperatorInDB(String operatorName,String password){
		try{
			// Execute a query
			stmt3= conn.createStatement();
			
			sql3="INSERT INTO operator (Username,Password) Values ('"+operatorName+"','"+password+"');"  ;          
			
			stmt3.executeUpdate(sql3);
			stmt3.close();
			successful=true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return successful;
	
	}
	
	
	public ArrayList getOperatorName()
	{
		try{
		// Execute a query
					stmt4= conn.createStatement();
					
					sql4="SELECT Username FROM operator;"  ;          
					
					rs1=stmt4.executeQuery(sql4);
					usernameArrayList=new ArrayList<String>();
					while(rs1.next()){
						
						usernameArrayList.add(rs1.getString("Username"));
						
					}
					stmt4.close();
					

					} catch(SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
		
		return (usernameArrayList);
		
	}
	
	
	public Boolean removeSelectedOperator(String operatorName){
		try{
			// Execute a query
			stmt5= conn.createStatement();
			
			sql5="DELETE FROM operator WHERE Username='"+operatorName+"';";         
			
			stmt5.executeUpdate(sql5);
			
			
			stmt5.close();
			successful=true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return successful;
	
	}
	
	public Boolean approveCustomerLoan(String custID){
		
		try {
			// Execute a query
			
			stmt6=conn.createStatement();
			
	sql6="UPDATE customer_loan SET Loan_Status = 'Approved', Date_Of_Approval=CURRENT_DATE() WHERE C_ID='"+custID+"';";
	stmt6.executeUpdate(sql6);
		stmt6.close();
		
		
		successful=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return successful;
	}
	
	public void getDetails(String custID){
		try {
			// Execute a query
			stmt7=conn.createStatement();
	
			sql7="Select customer.Customer_Name,loan_type.Loan_Name,customer_loan.Loan_Status from customer,customer_loan,loan_type where customer.C_ID=customer_loan.C_ID AND customer.C_ID='"+custID+"' AND customer_loan.Loan_Type_ID=loan_type.Loan_Type_ID;";
			rs7=stmt7.executeQuery(sql7);
			if(rs7.next()){
				do{
					custName=rs7.getString("Customer_Name");
					loanName=rs7.getString("Loan_Name");
					loanStatus=rs7.getString("Loan_Status");
				}while(rs7.next());
			}
			else{
				custName="";
				loanName="";
				JOptionPane.showMessageDialog(null, "No Customer OR Loan Exists");
				
			}
				rs7.close();
			stmt7.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public String getUsername() {
		return Username;
	}




	public String getPassword() {
		return Password;
	}




	public Boolean getSuccessful() {
		return successful;
	}
	public String getCustName() {
		return custName;
	}
	public String getLoanName() {
		return loanName;
	}
	public String getLoanStatus() {
		return loanStatus;
	}


	


	
}