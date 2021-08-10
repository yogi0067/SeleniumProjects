package coreJava;

public class MaxFrom2DArray {
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 9 }, { 8, 6, 0 } };
		// System.out.println(a.length +""+ a[0].length);
		int min = a[0][0];
		int max=0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] < min) {
					for(int k=0; k<a.length;k++)
					{
						if(a[k][j]>max)
						{
							max=a[k][j];
						}
					}
					
					

				}
			}
		}
		System.out.println(max);
	}
	

}
