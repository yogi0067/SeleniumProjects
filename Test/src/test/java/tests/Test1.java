package tests;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(n);
            int sum=0;
            for(int j=0; j<n;j++)
            {
            	sum=0;
            	for(int k=0; k<=j; k++)
	           	 {
            		int cof=(int) Math.pow(2, k);
            		sum=sum+(cof*b);
	           	 } 
            	System.out.print(a+sum+ " ");
            }
            System.out.println();
         }
        in.close();
    }
}
