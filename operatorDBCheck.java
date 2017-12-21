import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class operatorDBCheck {
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
		private Statement stmt=null,stmt1=null,stmt2=null,stmt3=null,stmt4=null,stmt4_1=null;
		private Statement stmt5=null,stmt6=null,stmt7_1=null,stmt7_2=null,stmt8=null;
		private String sql,sql1,sql2,sql3,sql4,sql4_1,sql5,sql6,sql7_1,sql7_2,sql8;
		private ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rs7,rs8;
		private String roiValue,minAmountValue,maxAmountValue,minTenureValue,maxTenureValue,yearlyIncomeValue;
		private String Customer_Name,loan_Name,Principle_Amount,Balance,Total_EMI,EMI_Submitted;
		private ArrayList<String> loanTypeArrayList,loanDetailsArrayList;
		private String loanIDDB,customerNameDB,principleAmountDB,balanceDB,dateOfApprovalDB,loanNameDB;
		private int loanTypeID,emi_submitted,balance,total,balance_left,emiPerMonth;
		private int tenure,interest;
		public operatorDBCheck(){
			
			
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
		
		
		public Boolean operatorLoginCheck(String username,String password){
			
			try {
				// Execute a query
				stmt= conn.createStatement();
		
				sql="Select Username,Password FROM operator WHERE Username='" + username + "' AND Password='" + password + " ';";
				
				
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
		
		public void loanTypeSelectionUpdate(String selectedLoanType){
		
			
			try {
				// Execute a query
				stmt1= conn.createStatement();
		
				sql1="Select Rate_Of_Interest,Minimum_Amount,Maximum_Amount,Minimum_Tenure,Maximum_Tenure,Yearly_Income FROM loan_type WHERE Loan_Name='"+selectedLoanType+"';";                        
				
				
				rs1 = stmt1.executeQuery(sql1);
			
			while(rs1.next()){
				// retrieve data from result set
				
				roiValue=rs1.getString("Rate_Of_Interest");
				minAmountValue=rs1.getString("Minimum_Amount");
				maxAmountValue=rs1.getString("Maximum_Amount");
				minTenureValue=rs1.getString("Minimum_Tenure");
				maxTenureValue=rs1.getString("Maximum_Tenure");
				yearlyIncomeValue=rs1.getString("Yearly_Income");
				
			}
				
			rs1.close();
			stmt1.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
			
			
			
		}


		
public Boolean newCustomerRegistrationInDB(String firstNameDB,String lastNameDB,String gender,String cityDB,String stateDB,String phoneNoDB,String emailIDDB,String occupationDB,String annualIncomeDB,String addressDB){
		
			
			try {
				// Execute a query
				stmt2= conn.createStatement();
		
				sql2="INSERT INTO customer (Customer_Name,Gender,Email_ID,Address,City,State,Phone,Occupation,Annual_Income) VALUES ('"+firstNameDB+" "+lastNameDB+"','"+gender.charAt(0)+"','"+emailIDDB+"','"+addressDB+"','"+cityDB+"','"+stateDB+"','"+phoneNoDB+"','"+occupationDB+"','"+annualIncomeDB+"');";          
				
				stmt2.executeUpdate(sql2);
				
		
			stmt2.close();
			successful=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return successful;
			
		}
		
		public ArrayList getLoanType(){
			
			try{
				// Execute a query
							stmt3= conn.createStatement();
							
							sql3="SELECT Loan_Name FROM loan_type;"  ;          
							
							rs3=stmt3.executeQuery(sql3);
							loanTypeArrayList=new ArrayList<String>();
							while(rs3.next()){
								
								loanTypeArrayList.add(rs3.getString("Loan_Name"));
								
							}
							rs3.close();
							stmt3.close();
							

							} catch(SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						
				
				return (loanTypeArrayList);
			
			
		}
		
		
		
public Boolean applyForLoanInDB(int custIDinDB,String loanTypeinDB,String loanAmountinDB,int tenureYearsinDB,int tenureMonthsinDB){
		
			
			try {
				// Execute a query
				
				stmt4_1=conn.createStatement();
				sql4_1="SELECT Loan_Type_ID FROM loan_type where Loan_Name='"+loanTypeinDB+"';";
				
				rs4=stmt4_1.executeQuery(sql4_1);
				while(rs4.next())
				loanTypeID=Integer.parseInt(rs4.getString("Loan_Type_ID"));
				
				rs4.close();
				stmt4_1.close();
				
				stmt4= conn.createStatement();
		
		
		tenure=tenureYearsinDB+tenureMonthsinDB;
		
sql4="INSERT INTO customer_loan (C_ID,Loan_Type_ID,Loan_Status,Principle_Amount,Balance,Total_EMI,EMI_Submitted,Date_Of_submission) VALUES ('"+custIDinDB+"','"+loanTypeID+"','Not Approved','"+loanAmountinDB+"','"+loanAmountinDB+"','"+tenure+"','0',CURRENT_DATE());";	
				stmt4.executeUpdate(sql4);
		
			stmt4.close();
			successful=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				successful=false;
				e.printStackTrace();
				
			}
		return successful;
			
		}
		
		
// to get interest rate of particular loan type
public int getInterestOfLoanType(String selectedLoanType){
	
	try{
		// Execute a query
					stmt5= conn.createStatement();
					
					sql5="SELECT Rate_Of_Interest FROM loan_type WHERE Loan_Name='"+selectedLoanType+"';"  ;          
					
					rs5=stmt5.executeQuery(sql5);
					loanTypeArrayList=new ArrayList<String>();
					while(rs5.next()){
						
						interest=Integer.parseInt(rs5.getString("Rate_Of_Interest"));
						
					}
					rs5.close();
					stmt5.close();
					

					} catch(SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		return interest;
	
	
}
		
public Boolean getEMIDetails(String C_ID){
	
	
	try {
		// Execute a query
		stmt6= conn.createStatement();

sql6="Select customer.Customer_Name,loan_type.Loan_Name,customer_loan.Principle_Amount,customer_loan.Balance,customer_loan.Total_EMI,customer_loan.EMI_Submitted from customer,customer_loan,loan_type where customer.C_ID=customer_loan.C_ID AND customer.C_ID='"+C_ID+"' AND customer_loan.Loan_Type_ID=loan_type.Loan_Type_ID;";
		
		rs6 = stmt6.executeQuery(sql6);
	if(rs6.next()){
	do{
		// retrieve data from result set
		
		Customer_Name=rs6.getString("customer.Customer_Name");
		loan_Name=rs6.getString("loan_type.Loan_Name");
		Principle_Amount=rs6.getString("customer_loan.Principle_Amount");
		Balance=rs6.getString("customer_loan.Balance");
		Total_EMI=rs6.getString("customer_loan.Total_EMI");
		EMI_Submitted=rs6.getString("customer_loan.EMI_Submitted");
		successful=true;
	}while(rs6.next());
	}
	else{
		JOptionPane.showMessageDialog(null, "No Customer Found", "No Customer", JOptionPane.ERROR_MESSAGE);
	}
		
	rs6.close();
	stmt6.close();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return successful;
}


public Boolean paymentUpdateInDB(String custIDinDB,int noOfEMIToPay){
	
	
	try {
		// Execute a query
		
		stmt7_1=conn.createStatement();
		
		
sql7_1="SELECT EMI_Submitted,Balance,Total_EMI from customer_loan where C_ID='"+custIDinDB+"';";

rs7=stmt7_1.executeQuery(sql7_1);
if(rs7.next()){
do{
emi_submitted=Integer.parseInt(rs7.getString("EMI_Submitted"));
balance=Integer.parseInt(rs7.getString("Balance"));
total = Integer.parseInt(rs7.getString("Total_EMI"));

System.out.println(emi_submitted+" "+balance+" "+total);
}while(rs7.next());
}
else{
	JOptionPane.showMessageDialog(null, "No Customer Found", "No Customer", JOptionPane.ERROR_MESSAGE);

}
rs7.close();
	stmt7_1.close();
	
	
	emiPerMonth=balance/total;
	System.out.println(emiPerMonth);

	balance_left = balance - ((emiPerMonth)*noOfEMIToPay);
	
	stmt7_2=conn.createStatement();
	
	sql7_2="UPDATE customer_loan SET EMI_Submitted="+(emi_submitted+noOfEMIToPay)+",Balance="+balance_left+" WHERE C_ID='"+custIDinDB+"';";
	stmt7_2.executeUpdate(sql7_2);
	stmt7_2.close();
	
	successful=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return successful;
	
}

		
public void getLoanInformation(String C_ID){
	
	
	try {
		// Execute a query
		stmt8= conn.createStatement();

		sql8="Select Loan_ID,Customer_Name,Principle_Amount,Balance,Date_Of_Approval,Loan_Name FROM customer_loan,customer,loan_type where customer_loan.C_ID='"+C_ID+"' AND customer.C_ID=customer_loan.C_ID AND customer_loan.Loan_Type_ID=loan_type.Loan_Type_ID;";
		
		rs8 = stmt8.executeQuery(sql8);
	
	if(rs8.next()){
			do{
				// retrieve data from result set
				
				loanIDDB=rs8.getString("Loan_ID");
				customerNameDB=rs8.getString("Customer_Name");
				principleAmountDB=rs8.getString("Principle_Amount");
				balanceDB=rs8.getString("Balance");
				dateOfApprovalDB=rs8.getString("Date_Of_Approval");
				loanNameDB=rs8.getString("Loan_Name");
			}while(rs8.next());	
	}
	else{
		JOptionPane.showMessageDialog(null, "No Customer Found or Customer Not Yet applied for Loan", "No Customer", JOptionPane.ERROR_MESSAGE);
		loanIDDB="";
		customerNameDB="";
		principleAmountDB="";
		balanceDB="";
		dateOfApprovalDB="";
		loanNameDB="";
	}
		
		
	
	rs8.close();
	stmt8.close();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	
	
	
}

		
		
		public String getRoiValue() {
			return roiValue;
		}


		public String getMinAmountValue() {
			return minAmountValue;
		}


		public String getMaxAmountValue() {
			return maxAmountValue;
		}


		public String getMinTenureValue() {
			return minTenureValue;
		}


		public String getMaxTenureValue() {
			return maxTenureValue;
		}


		public String getYearlyIncomeValue() {
			return yearlyIncomeValue;
		}


		public String getCustomer_Name() {
			return Customer_Name;
		}


		public String getLoan_Name() {
			return loan_Name;
		}


		public String getPrinciple_Amount() {
			return Principle_Amount;
		}


		public String getTotal_EMI() {
			return Total_EMI;
		}


		public String getEMI_Submitted() {
			return EMI_Submitted;
		}


		public String getBalance() {
			return Balance;
		}


		public String getLoanIDDB() {
			return loanIDDB;
		}


		public String getCustomerNameDB() {
			return customerNameDB;
		}


		public String getPrincipleAmountDB() {
			return principleAmountDB;
		}


		public String getBalanceDB() {
			return balanceDB;
		}


		public String getDateOfApprovalDB() {
			return dateOfApprovalDB;
		}


		public String getLoanNameDB() {
			return loanNameDB;
		}
		
		
		
		
}
