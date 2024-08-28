package projects;

public class Customers {
      int id;
	  int acc_no;
	  String name;
      protected int balance=10000;
	   String password;
	 
	 public Customers(String name, String password,Customers cr) {
		
		 this.name=name;
		 this.password=password;
		 this.balance=balance;
		 this.acc_no=++cr.acc_no;
		 this.id=++cr.id;
	 } 
	 public Customers(int id,int acc,String name,int bal, String password) {
		 this.name=name;
		 this.password=password;
		 this.id=id;
		 this.balance=bal;
		 this.acc_no=acc;
	 } 
	 public Customers() {
		 
	 }
	 
	
	
	 
	
}
