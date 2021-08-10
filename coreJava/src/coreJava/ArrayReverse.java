package coreJava;

import java.util.ArrayList;

public class ArrayReverse {
	
	public Object[] reverseArray(int arr[],int len)
	{
		ArrayList<Integer> list= new ArrayList<>();
		
		
		for(int i=len-1; i>0; i--)
		{
			list.add(arr[i]);
		}
		return list.toArray();
	}

	public static void main(String[] args) {
		int arr[]= {3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 2}; 
		int length= arr.length;
		ArrayReverse onj= new ArrayReverse();
		Object[] reverse=onj.reverseArray(arr, length);
		for(int i=0; i<reverse.length; i++)
		{
			System.out.println(reverse[i]);
		}

	}

}
