package coreJava;

public class UniqueNumberArray {

	public void uniqueNumber(int arr[],int ele)
	{
		int count=0;
		for (int i = 0; i < arr.length; i++) 
		{
			if(ele==arr[i])
				count++;
		}
		if(count==1)
		{
			System.out.println("Unique Number is :- " + ele);
		}
	}
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 2, 1, 32, 4, 5, 5, 6, 6 };
		

		for (int i = 0; i < arr.length; i++) {
			new UniqueNumberArray().uniqueNumber(arr, arr[i]);
		}
		

	}

}
