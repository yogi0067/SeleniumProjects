package coreJava;

import java.util.ArrayList;

import java.util.Scanner;

public class ArraylistHacker {
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> arr= new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> arr1= new ArrayList<ArrayList<Integer>>();
		int n;
		Scanner sc= new Scanner(System.in);
		
		n=sc.nextInt();
		ArrayList<Integer> ar = null;
		for(int i=1; i<=n; i++)
		{
			
			int d= sc.nextInt();
			ar= new ArrayList<Integer>();
			for(int j=1; j<=d; j++)
			{
				
				ar.add(sc.nextInt());
			}
			arr.add(ar);
			ar=null;
			
		}
		
		int q=sc.nextInt();
		for(int i=1; i<=q; i++)
		{
			
			
			ar= new ArrayList<Integer>();
			for(int j=1; j<=2; j++)
			{
				ar.add(sc.nextInt());
			}
			arr1.add(ar);
			ar=null;
			
		}
		
		
		
		for(int i=0; i<arr1.size(); i++)
		{
			try {	
			System.out.println(arr.get((arr1.get(i).get(0))-1).get((arr1.get(i).get(1))-1));}
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("ERROR!");
			}
		}
		
	}

}
