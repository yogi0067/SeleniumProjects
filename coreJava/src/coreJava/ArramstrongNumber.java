package coreJava;

public class ArramstrongNumber {
	public static void main(String[] args) {
		int number=151;  // Try with 153
		int temp=number;
		int arm=0;
		int coff;
		
		while(number>0)
		{
			coff=number%10;
			arm=arm+(coff*coff*coff);
			number/=10;
			
		}
		if(temp==arm)
			System.out.println(temp +" is ArramString number "+ arm);
		else
			System.out.println(temp +" is Not ArramString number "+ arm);
	}
}
