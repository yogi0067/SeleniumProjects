package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;



public class CountOfNumberofarray {

	public static void countofelement(int arr[], String ele)
	{
		int count=0;
		
		for(int i=0; i<arr.length; i++)
		{
			if(Integer.parseInt(ele)==arr[i])
				count++;
		}
		
		System.out.println("Element"+ele+ "Count is :" +count);
	}
	public static void main(String[] args) {
		int arr[]= {2,3,4,5,2,3,5,2};
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++)
		{
			set.add(arr[i]);
		}
		Iterator test=set.iterator();
		 while(test.hasNext())
		 {
				countofelement(arr, test.next().toString());	
		 }
		
		
	}
	
}
