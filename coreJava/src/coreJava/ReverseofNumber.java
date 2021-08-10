package coreJava;

public class ReverseofNumber {

	public static void main(String[] args) {
		int number=123;
		int temp=number;
		int coff=0;
		int rev=0;
		while(number>0)
		{
			coff=number%10;
			rev=rev*10+coff;
			number=number/10;
		}
		System.out.println("Reverse of Number "+temp+" is :"+ rev);
	}
}
