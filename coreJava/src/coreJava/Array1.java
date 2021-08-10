/*
 Given an array arr[] and size of array is n and one another key x,
  and give you a segment size k. The task is to find that the key x 
  present in every segment of size k in arr[].
  Input : 
arr[] = { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3} 
x = 3 
k = 3 
Output : Yes 
There are 4 non-overlapping segments of size k in the array, 
{3, 5, 2}, {4, 9, 3}, {1, 7, 3} and {11, 12, 3}. 3 is present all segments.
 */

package coreJava;

public class Array1 {
	public static void main(String[] args) {
		
		int arr[]= { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 2}; 
		int length= arr.length;
		int value=11;
		int chunkarrysize=7;
		
		boolean flag= true;
		int i,j;
		
		for (i=0; i<length; i=i+chunkarrysize)
		{
			for(j=0; j<chunkarrysize; j++)
			{
				if(arr[i+j]==value)
					break;
			
			}
			if(j==chunkarrysize)
				flag=false;
		
		}
		
			
		
		if(flag)
			System.out.println("The element is avilable");
		else
			System.out.println("Element is not available");
	}
}
