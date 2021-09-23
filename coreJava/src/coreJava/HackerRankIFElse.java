package coreJava;

import java.util.Scanner;

/*
 * If  is odd, print Weird
If  is even and in the inclusive range of 2 to 5, print Not Weird
If  is even and in the inclusive range of 6 to 20, print Weird
If  is even and greater than 20 , print Not Weird
 * */

public class HackerRankIFElse {
	
	  private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int N = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        if(N%2==0)
	        {
	        	if(N>=2 && N<=5)
	        	{
	        		System.out.println("Not Weird");
	        	}
	        	else if(N>5 && N<21)
	        	{
	        		System.out.println("Weird");
	        	}
	        	else
	        	{
	        		System.out.println("Not Weird");
	        	}
	        }
	        else
	        {
	        	System.out.println("Weird");
	        }
	        
	        
	        
	        scanner.close();
	    }

}
