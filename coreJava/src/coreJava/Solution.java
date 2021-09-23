package coreJava;
/*
1
9 4
0 1 1 0 0 1 1 0 1


4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0
35 33
0 0 1 1 1 1 1 1 0 1 1 1 1 0 1 0 1 1 0 1 1 1 0 1 0 1 0 1 0 0 1 1 1 1 0
68 4
0 1 1 0 1 1 1 1 1 1 1 0 1 1 0 1 1 1 1 0 0 0 0 1 1 0 1 0 1 1 0 1 0 1 0 1 1 0 0 1 0 1 1 1 1 1 0 1 0 1 1 1 1 1 1 1 1 0 1 1 0 0 0 1 0 1 0 1
3 1
0 0 1
51 0
0 1 1 0 0 0 1 1 0 1 1 0 0 1 1 1 1 1 1 1 1 1 0 1 1 0 0 1 1 1 0 0 0 1 0 1 1 0 1 1 1 1 1 0 1 1 1 0 1 1 0
57 15
0 0 0 1 1 1 1 0 0 0 0 1 0 1 1 1 0 1 1 0 1 0 1 0 0 1 1 1 0 1 0 0 0 0 0 1 0 0 1 0 1 1 0 1 1 1 1 1 1 0 1 0 1 0 1 1 1
81 74
0 1 0 1 0 1 1 1 0 1 0 0 0 1 1 1 1 0 1 0 1 0 1 1 1 0 1 1 0 1 0 1 1 1 0 1 0 0 1 0 0 1 1 1 1 1 0 0 1 1 0 1 0 1 0 0 1 0 1 1 1 0 0 1 1 0 1 0 1 0 1 1 0 0 1 1 1 1 1 1 1
67 22
0 0 1 1 1 1 1 1 1 1 1 1 0 1 0 1 1 1 0 1 1 1 1 0 0 0 0 0 1 0 1 0 1 0 1 0 1 0 1 1 1 1 1 1 0 1 1 0 0 1 1 1 0 1 0 1 1 1 0 1 1 0 1 0 1 1 0
69 49
0 0 0 0 1 1 0 0 0 1 1 0 1 0 0 0 1 0 0 1 1 0 0 1 1 1 0 0 1 1 1 1 1 1 1 0 1 0 1 1 0 1 1 1 1 0 1 1 0 1 0 0 1 1 1 0 0 0 1 0 1 1 1 0 1 0 1 0 0
19 13
0 1 1 0 0 1 0 0 0 1 0 1 0 1 1 0 0 1 0
 */
import java.util.Scanner;

public class Solution {

	public static boolean canWin(int leap, int[] game) {
		int i = 0;
		boolean flag = false;
		while (i < game.length) {

			try {
				
				if(game[i+1]==0)
				{
					i++;
				}
				else if(game[i+leap]==0)
				{
					i=i+leap;
				}
				else if(game[i-1]==0)
				{
					i--;
					if(game[i+leap]!=0)
					{
						flag=false;
						break;
					}
					else
					{
						i=i+leap;
						flag=true;
					}
				}
				if(i+leap>=(game.length-1) || i==game.length-1)
				{
					flag=true;
					break;
				}		
			} 
			catch (ArrayIndexOutOfBoundsException e) 
			{
				if(i+leap >=game.length || i == game.length-1)
				{
					flag=true;
					break;
				}
				if(i==0)
				{
					flag=false;
					break;
				}
			}

		}

		return flag;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			// System.out.println(game.length - 1);
			System.out.println((canWin(leap, game)) ? "YES" : "NO");
		}
		scan.close();
	}
}