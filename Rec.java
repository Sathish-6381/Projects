package play;

import java.util.*;

public class Rec {
// static int ans=Integer.MAX_VALUE;

	public static void main(String[] args) {
	    
	    String[][] nums= { {"5","3",".",".","7",".",".",".","."},
	    		           {"6",".",".","1","9","5",".",".","."},
	    	               {".","9","8",".",".",".",".","6","."},
                           {"8",".",".",".","6",".",".",".","3"},
                           {"4",".",".","8",".","3",".",".","1"},
                           {"7",".",".",".","2",".",".",".","6"},
                           {".","6",".",".",".",".","2","8","."},
                           {".",".",".","4","1","9",".",".","5"},
                           {".",".",".",".","8",".",".","7","9"}
	             		};
	 
	   
     
      
    Suduku(nums,0,0);
  
	}
	  
	   
	    
	   
	          
	
	public Rec() {
		
	}
	 public static ArrayList<String> Rec (String s,int current,int end,ArrayList<String> ar){
		 
	      if(current==end){
	        ar.add(s);
	        return ar;
	      }
	      String temp=new String();
	      for(int i=0;i<s.length();i++){
	        if(s.charAt(i)=='0'){
	            temp=temp+"01";
	        }
	        else    temp=temp+"10";
	      }
	     
	      return Rec(temp,current+1,end,ar);
	   
	    }
	 public static boolean C(String ar) {
		
		 return ar.contains("00");
	 }
	
	 public List<List<Integer>> permute(int[] nums) {
         if(nums.length==0){
            return null;
         }
         String temp=Arrays.toString(nums);
         return per("",temp);

        
    }
	 public static List<List<Integer>> per(String pro,String un){
	        if(un.length()==0){
	            List<List<Integer>> ar=new ArrayList<List<Integer>>();
	           List<Integer> ans=new ArrayList<>();
	           
	            for(int i=0;i<pro.length();i++){
	                ans.add(Integer.parseInt(""+pro.charAt(i)));
	            }
	           // System.out.println(ans);
	          ar.add(ans);
	          return ar;
	        }
	        char c=un.charAt(0);
	        List<List<Integer>> temp=new ArrayList<List<Integer>>();
	        for(int j=0;j<=pro.length();j++){
	            String s1=pro.substring(0,j);
	            String s3=pro.substring(j);
	            String s2=un.substring(1);
	            List<List<Integer>> tr=per(s1+""+c+s3,s2);
	            temp.addAll(tr);
        }
	        return temp;
	 }

	public static  void Suduku(String [][] n,int row,int col) {
       boolean b=true;
		for(int r=0;r<n.length;r++) {
		for(int i=0;i<n[0].length;i++) {
			if(n[r][i].equals("."))  {
			     row=r;
			     col=i;
				b=false;
				break;
				}
			}
		}
		if(b) {
			Pri(n);
			return;
		}
		for(int Value=1;Value<=9;Value++) {
			n[row][col]=""+Value;
			if(Valid(n)) {
				Suduku(n,row,col);
			}
			n[row][col]=".";
		}
		
		
	}
	public static boolean Valid(String [][] n){
		for(int i=0;i<n.length;i++) {
			for(int j=0;j<n.length;j++) {
				if(!(n[i][j].equals("."))) {
					for(int a=0;a<n.length;a++) {
						if(a==j) {
							continue;
						}
						if(n[i][a].equals(n[i][j])) {
							return false;
						}
					}
					for(int b=0;b<n.length;b++) {
						if(b==i) {
							continue;
						}
						if(n[b][j].equals(n[i][j])) {
							return false;
						}
					}
				}
			}
		}
		  for(int k=0;k<9;k+=3){
              for(int h=0;h<9;h+=3){
                    ArrayList<String> temp=new ArrayList<>();
              for(int x=k;x<k+3;x++){
              for(int y=h;y<h+3;y++){
                  if(temp.size()!=0 && temp.contains(n[x][y])){
                      return false;
                  }
                  if(!(n[x][y].equals("."))){
                      temp.add(n[x][y]);
                  }
              }
          }
              }
          }
		return true;
		
	}
	
	static ArrayList<String> Phone(String s1,String s3) {
		if(s3.length()==0) {
			ArrayList<String> ar= new ArrayList<>();
			System.out.println(s1);
			ar.add(s1);
			return ar;
		}
		String[] str= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		String ans=str[Integer.parseInt(""+s3.charAt(0))];
		ArrayList<String> arr=new ArrayList<>();
		for(int i=0;i<ans.length();i++) {
			String temp=""+ans.charAt(i);
			String temp2=s3.substring(1);
			arr.addAll(Phone(s1+temp,temp2));
		}
		return arr;
	}
	public static void Pri(String[][] n) {
		for(int i=0;i<n.length;i++) {
			for(int j=0;j<n[0].length;j++) {
				System.out.print(n[i][j]+" ");
				
			}
			System.out.println();
		}
	}
	static ArrayList<String> Route(String s,int r,int c) {
		if(r==1 && c==2) {
			ArrayList<String> ar=new ArrayList<>();
		    ar.add(s);
		    return ar;
		}
		if(r==1 && c==1) {
			 ArrayList<String> d=new ArrayList<>();
			 return d;
			 
		}
		ArrayList<String> list=new ArrayList<>();
		if(r<2 && c<2) {
			list.addAll(Route(s+"D ",r+1,c+1));
		}
		if(r<2) {
		ArrayList <String> a1=(Route(s+"V ",r+1,c));
		list.addAll(a1);
		}
		if(c<2) {
			ArrayList <String> a2=(Route(s+"H ",r,c+1));
			list.addAll(a2);
		}
		return list;
	}
	public static void  Nqueen(int[][] n,int row) {
		if( row==n.length) {
			
			printer(n);
			return ;
		}
		//List<List<String>> ans=new ArrayList<List<String>>();
		for(int i=0;i<n[0].length;i++) {
			n[row][i]=1;
			if(Checker(n)) {
				Nqueen(n,row+1);
				//ans.addAll(ntr);
			}
			n[row][i]=0;	
		}
		//return ans;
		
	}
	static void printer(int[][] n) {
		for(int i=0;i<n.length;i++) {
			for(int j=0;j<n[0].length;j++) {
				if(n[i][j]==1) {
					System.out.print(" Q ");
				}
				else {
					System.out.print(" . ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	public static boolean Checker (int [][] m ) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				if(m[i][j]==1) {
					for(int k=0;k<m[0].length;k++) {
						if(k==j ) {
							continue;
						}
						if(m[i][k]==1) {
						
							return false;
						}
					}
					for(int s=0;s<m.length;s++) {
						if(s==i) {
							continue;
						}
						if(m[s][j]==1) {
							return false;
						}
					 }
					int a=i;
					int b=j;
					while(a>0 && b>0) {
						if(m[--a][--b]==1) {
							return false;
						}
					}
					int c=i;
					int d=j;
					while(c>0 && d<m[0].length-1) {
						if(m[--c][++d]==1) {
							return false;
						}
					}
					
				}
				}
			}
		return true;
		}
	public static void paran(int n,String s) {
		if(n<=0) {
			System.out.println(s);
			return;
		}
		for(int i=1;i<=n;i++) {
			String temp=new String();
			temp=temp.concat(s);
			for(int j=0;j<i;j++) {
				temp=temp.concat("(");
			}
			for(int k=0;k<i;k++) {
				temp=temp.concat(")");
			}
			paran(n-i,temp);
		}
	}
	public static List<List<String>>convert(int[][]a){
		List<List<String>> ans=new ArrayList<List<String>>();
		for(int i=0;i<a.length;i++) {
			String s=new String();
			for(int j=0;j<a[0].length;j++) {
				if(a[i][j]==1) {
					s=s+"Q";
				}
				else s=s+".";
			}
			ArrayList<String> temp=new ArrayList<>();
			temp.add(s);
			ans.add(temp);
		}
		return ans;
	}
	public static void subset(int[] nums,ArrayList<Integer> ar) {
		System.out.println(ar);
		if(nums.length==0) {
			
			return ;
		}
		
		for(int i=0;i<nums.length;i++) {
			ar.add(nums[i]);
			subset(Arrays.copyOfRange(nums, i+1, nums.length),ar);
			
			ar.remove(ar.size()-1);
		}
		
	}
	public static boolean Search(int row,int col,char[][] c,String s,ArrayList<Integer> ar,int[][] ref) {
		
		if(s.length()==0) {
			return true;
		}
		boolean b1=false;
		boolean b2=false;
		boolean b3=false;
		boolean b4=false;
		if( rule(row,col+1,c) && ref[row][col+1]!=1 && c[row][col+1]==s.charAt(0)) {
			ref[row][col+1]=1;
			b1=Search(row,col+1,c,s.substring(1),ar,ref);
			
			ref[row][col+1]=0;
				
		}
		if(rule(row,col-1,c) && ref[row][col-1]!=1 && c[row][col-1]==s.charAt(0)) {
			ref[row][col-1]=1;
			b2=Search(row,col-1,c,s.substring(1),ar,ref);
			
			ref[row][col-1]=0;
			
	    }
		if(rule(row+1,col,c) &&ref[row+1][col]!=1 && c[row+1][col]==s.charAt(0)) {
			ref[row+1][col]=1;
			b3=Search(row+1,col,c,s.substring(1),ar,ref);
		
			ref[row+1][col]=0;
			
	   }
		if(rule(row-1,col,c) &&ref[row-1][col]!=1 && c[row-1][col]==s.charAt(0)) {
			ref[row-1][col]=1;
			b4=Search(row-1,col,c,s.substring(1),ar,ref);
			
			ref[row-1][col]=0;
			
	  }
		
		if(b1||b2||b3||b4) {
			return true;
		}
		return false;
		
		}
	
	public static boolean WordSearch(char[][] c,String s) {
		ArrayList<Integer> ar=new ArrayList<>();
		int [][] ref=new int[c.length][c[0].length];
		boolean b=false;
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				if(s.charAt(0)==c[i][j]) {
					ref[i][j]=1;
					b=Search(i,j,c,s.substring(1),ar,ref);
					if(b) {
						return true;
					}
					ref[i][j]=0;
				}
			}
		}
		return b;
		
	}
	
	public static boolean rule(int row,int col,char[][]c) {
		if(row<0 ||row>=c.length||col<0||col>=c[0].length) {
			return false;
		}
		return true;
	}
	
	public static List<String> Letter(char[] s,int start,List<String> list) {
		
		
		
		list.add(to(s));
		
		for(int i=start;i<s.length;i++) {
			if(s[i]>='a'&&s[i]<='z' || s[i]>='A'&&s[i]<='Z')  {
				String temp=""+s[i];
				char c=s[i];
				if(s[i]>='A'&&s[i]<='Z') {
					temp=temp.toLowerCase();
				}
				else temp=temp.toUpperCase();
				s[i]=temp.charAt(0);
				//System.out.println(s[i]);
				 list=Letter(s,i+1,list);
				
				s[i]=c;
			}
			
		}
		return list;
	}
	public static String to(char [] c) {
		String str=new String();
		for(char v:c) {
			str=str+""+v;
		}
		return str;
	}
	 public static ArrayList<String> Binary(char []c,int start,ArrayList<String> ans){
	        ans.add(to(c));
	        if(start==c.length){
	            return ans;
	        }
	        for(int i=start;i<c.length;i++){
	            c[i]='1';
	            ans=Binary(c,i+1,ans);
	            c[i]='0';
	        }
	        return ans;
	    }
	 public String find(String[] nums) {
		    String temp=nums[0];
		    String dummy=new String();
		    for(int x=0;x<temp.length();x++){
		        dummy=dummy+"0";
		    }
		    ArrayList<String> ans=new ArrayList<String>();
		    ans=Binary(dummy.toCharArray(),0,ans);
		    for(String s:nums){
		        if(!ans.contains(s)){
		          return s;
		        }
		    }
		        return null;
		    }
	 public static String Finder (ArrayList<String> list,String[] str) {
		 for(String s:str) {
			 if(list.contains(s)) {
				 list.remove(s);
			 }
			 else return s;
			 
		 }
		 if(list.size()==0)
		 return null;
		 else return list.get(0);
	 }
	 public static ArrayList<Integer> Jump(int[] arr,int index,int move,ArrayList<Integer> ans){
		 if(index>=arr.length-1) {
			
			 ans.add(move);
			 return ans;
		 }
		 for(int j=1;j<=arr[index];j++) {
			 ans=Jump(arr,index+j,move+1,ans); 
		 }
		 return ans;
	 }
	 public static ArrayList<String> Diff(int n,int k,String s,ArrayList<String> ans) {
		
		 if(s.length()==n) {
			 System.out.println(s);
			ans.add(s);
			 return ans;
		 }
		 if(s.length()>0) {
			 for(int i=0;i<10;i++) {
				 int x=Integer.parseInt(""+s.charAt(s.length()-1));
				 int temp=x-i;
				 temp=Math.abs(temp);
				 if(temp==k) {
					ans=Diff(n,k,s+""+i,ans);
				 }
			 } 
		 }
		 else {
			 for(int i=1;i<10;i++) {
			 ans=Diff(n,k,s+""+i,ans);
				 }
			 }
		 return ans;
		 }
		 
	 }
	 
	
	 
	   



