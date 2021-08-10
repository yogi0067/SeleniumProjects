package coreJava;

public class CountNoDigits {

	public static void main(String[] args) {
		int num=123232345;
		int count=0;
		while(num>0)
		{
			count++;
			num=num/10;
		}
		System.out.println(count);
		
	}
}
