package coreJava;

public class FabonacciSeries {
	public static void main(String[] args) {
		
		int a=0;
		int b=1;
		System.out.print(a+" "+b);
		int c=0;
		while(c<15)
		{c=a+b;
			System.out.print(" "+c);
			a=b;
			b=c;
			
		}
		
	}
}
