package coreJava;

public class PalindromeNumber {
	public static void main(String[] args) {
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
		
	}
}
