package coreJava;

public class ArraySort {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 4, 1, 6, 5 };
		//0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2
		//-12, 11, -13, -5, 6, -7, 5, -3, -6

		int temp;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}

}
