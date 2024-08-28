package projects;
import java.util.*;
import java.sql.*;
public class Jdbc {

	public static void main(String[] args) throws Exception{
	String url="jdbc:mysql://localhost:3306/project";
	String name="root";
	String pass="Tsathi8098@";
	Connection con=DriverManager.getConnection(url,name,pass);
	con.setAutoCommit(false);
	CallableStatement st=con.prepareCall("{call GetEmp()}");
	ResultSet rs=st.executeQuery();
	//rs.next();
	while(rs.next()) {
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
	}
	
	
	
	
	
	con.close();
	
	}
	 public static int val(ArrayList<Integer> ar){
	        int sum=0;
	        int size=ar.size()-1;
	        int hel=1;
	        while(size>=0){
	          if(ar.get(size)==1){
	            sum+=hel;
	          }
	           hel*=2;
	           size--;
	        }
	        return sum;
	    }
	public static  void Rec(int[] in, int[] pos) {
		if(in.length==0 || pos.length==0) {
			return ;
		}
		Print(in);
		Print(pos);
	    
	    int index=Index(pos[pos.length-1],in);

       Rec(Arrays.copyOfRange(in,0,index),Arrays.copyOfRange(pos,0,index-1));
        Rec(Arrays.copyOfRange(in,index,in.length),Arrays.copyOfRange(pos,index-1,pos.length-1));
	
	}
	public static int Index(int a,int[] ar) {
		for(int i=0;i<ar.length;i++) {
			if(ar[i]==a) {
				return i+1;
			}
		}
		return Integer.MAX_VALUE;
	}
	public static void Print(int [] a) {
	
	for(int w:a) {
	System.out.print(w+" ");
	}
	System.out.println();
	}
	

}
