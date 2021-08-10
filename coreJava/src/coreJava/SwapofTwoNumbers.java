package coreJava;

public class SwapofTwoNumbers {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		System.out.println("Before Swaping :- "+a+"  "+ b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("After Swaping :- "+a+"  "+ b);
		
		a=a*b;
		b=a/b;
		a=a/b;
		
		System.out.println("Before Swaping :- "+a+"  "+ b);
	}
}
