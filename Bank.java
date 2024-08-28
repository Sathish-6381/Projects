package projects;
import java.util.*;
import java.sql.*;
import java.io.*;
public class Bank {
	
	
   ArrayList<Customers> data;
 public Bank() {
	this.data=new ArrayList<>();
 }

  public static void main(String[] args) throws IOException, SQLException {
	Scanner sc=new Scanner(System.in);
	Bank br=new Bank();
	br.data=br.DataExtract();
	
	boolean b=true;
	while(b) {
		System.out.println("welcome to our Bank Services\n 1.Add new Customer\n 2.View Balance \n 3.Cash Deposit \n 4.Withdrawal \n 5.Money Transfer \n 6.Exit");
		int n=sc.nextInt();
		switch(n){
		case(1):{
			
			br.AddCustomer(sc,br.data.get(br.data.size()-1));
			br.data=br.DataExtract();
			System.out.println("New Account Created Succesfully");
			break;
		}
		case(2):{
			System.out.println("Please Enter your Account Number");
			int ac=sc.nextInt();
			System.out.println("Please Enter Your Account Password");
			String p=sc.next();
			int bal=viewBalance(ac,p,br.data);
			if(bal==-1) System.out.println("Invalid user name and Password");
			else System.out.println("Your Account balance is:  "+bal);
			break;
		}
		case(3):{
			System.out.println("Please Enter your Account Number");
			int ac=sc.nextInt();
			boolean jk=false;
			for(Customers c:br.data) {
				if(c.acc_no==ac) {
					jk=false;
					System.out.println("Please Enter The Amount to Deposit");
					int amo=sc.nextInt();
					c.balance+=amo;
					DataAssign(br.data);
					System.out.print("last transaction succesfully completed");		
					break;
					
				}
			}
			if(jk) {
				System.out.println("Your Entered  Invalid Account number");
			}
			break;
		}
		case(4):{
			System.out.println("Please Enter your Account Number  :\t ");
			int num=sc.nextInt();
			System.out.println("Please Enter The Password  :\t ");
			String p=sc.next();
			int gh=viewBalance(num,p,br.data);
			if(gh==-1) System.out.println("Invalid Password and Account Number");
			else {
			System.out.println("Please Enter The Withdrawal Amount  :\t ");
			int with=sc.nextInt();
			if((gh-with)>=1000) {
				for(Customers cr:br.data) {
					if(num==cr.acc_no) {
						cr.balance-=with;
						break;
					}
				}
			}
			else {
				System.out.println("You Can Not Withdraw This Amount of Money ");
			}
			}
			
			
			
			break;
		}
		case(5):{
			for(Customers s:br.data) {
				System.out.println(s.id+"  "+s.acc_no+"  "+s.name+"  "+s.balance+"  "+s.password);
				
			}
			break;
		}
		case(6):{
			b=false;
			break;
		}
		default:{
			System.out.println("Invalid Option");
			break;
		}
		
		
	}
	}
  }
  
	






 
  
  public  void AddCustomer(Scanner sc,Customers hn) throws IOException {
	  System.out.println("Please Enter your Name");
	  String name=sc.next();
	  
	  System.out.println("Please Enter your Password");
	  String pass=sc.next();
	  
	  System.out.println("Please Re-Enter your Password");
	  String repass=sc.next();
	  
	  if(!pass.equals(repass)) {
		  System.out.println("Your Entered Password is Mismatched");
		  AddCustomer(sc,hn);
	  }
	  else {
		  File f=new File("C:\\Project\\Account data.txt");
		  FileWriter fw=new FileWriter(f,true);
		  BufferedWriter br=new BufferedWriter(fw);
		  Customers cr=new Customers(name,encrypt(pass),hn);
		  String temp=cr.id+" "+cr.acc_no+" "+cr.name+" "+cr.balance+" "+cr.password;
		  br.newLine();
		  br.write(temp);
		  br.flush();
		  br.close();
	  }
	  
	  
  }
  public String toString(Customers c) {
	  return c.id+" "+c.acc_no+" "+c.name+" "+c.balance;
  }
  public static String encrypt(String s) {
	  
	  String ans=new String();
	  
	  for(char c:s.toCharArray()) {
	  if(c=='z') ans=ans+'a';
	  else if(c=='Z') ans=ans+'A';
	  else if(c=='9') ans=ans+'0';
	  else ans=ans+""+(++c);
	  }
	  return ans;
  }
  public static int viewBalance(int id,String pass,ArrayList<Customers> data) {
      for(Customers c:data) {
    	  if(c.acc_no==id && encrypt(pass).equals(c.password)) {
    		  return c.balance;
    	  }
      }
      return -1;

  }
  public static void DataAssign(ArrayList<Customers> data) throws IOException {
	  File f=new File("C:\\Project\\Account data.txt");
	  FileWriter fw=new FileWriter(f);
	  BufferedWriter br=new BufferedWriter(fw);
	  for(Customers cr:data) {
	  String temp=cr.id+" "+cr.acc_no+" "+cr.name+" "+cr.balance+" "+cr.password;
	  br.newLine();
	  br.write(temp);
	  
	  }
	  br.flush();
	  br.close();
	  
  }
  public   ArrayList<Customers> DataExtract() throws IOException, SQLException  {
	  String url="jdbc:mysql://localhost:3306/project";
		String name="root";
		String pass="Tsathi8098@";
		Connection con=DriverManager.getConnection(url,name,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from Accounts");
		ArrayList<Customers> data=new ArrayList<>();
		while(rs.next()) {
			Customers temp=new Customers(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5));
			data.add(temp);
		}
		return data;
  }
  
}
