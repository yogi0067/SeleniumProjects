package coreJava;



import java.util.*;

public class PalindromeNumber {
	public static void main(String[] args) {
		//Method one
		int number=12321;
		int temp=number;
		int rev=0;
		int coff;
		
		while(number>0)
		{
			coff=number%10;
			rev=rev*10+coff;
			number/=10;
			
		}
		if(temp==rev)
			System.out.println(temp +" is Palindrome number"+ rev);
		else
			System.out.println(temp +" is Not Palindrome number"+ rev);
		//Method2
		
		Scanner sc = new Scanner(System.in);
		String num= sc.nextLine();
		 String revStr="";
		for(int i=num.length()-1; i>=0; i--)
		{
			revStr=revStr+num.charAt(i);
		}
		if(num.equals(revStr))
		{
			System.out.println(num +" is Palindrome number "+ revStr);
		}
		else
			System.out.println(num +" is Not Palindrome number "+ revStr);
		
		
	}
}
