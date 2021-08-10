package coreJava;

public class MinAndMaxElementfromArray {

	public int min(int arr[],int len)
	{
		int min=arr[0];
		for(int i=1;i<len; i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
			}
		}
		
		return min;
		
		
	}
	public int max(int arr[],int len)
	{
		int max=arr[0];
		for(int i=1;i<len; i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
		
		return max;
		
		
	}
	public static void main(String[] args) {
		
		int arr[]= { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 2}; 
		int length= arr.length;
		MinAndMaxElementfromArray obj= new MinAndMaxElementfromArray();
		
		System.out.println("Maximum Numer is :-" +obj.min(arr, length));
		System.out.println("Maximum Numer is :-" +obj.max(arr, length));
		
		
	}
}
