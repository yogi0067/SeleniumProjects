package coreJava;

import java.util.Scanner;

public class PrimeNumber {

	public boolean prime(int num) {
		int count = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count > 1) {
			return false;
		} else {
			return true;
		}

	}

	public static void main(String[] args) {
		//mehtod1 when we want to check single value
		int num = new Scanner(System.in).nextInt();
		boolean flag = new PrimeNumber().prime(num);
		if (flag) {
			System.out.println(num + " is  prime number");
		} else {
			System.out.println(num + " is not prime number");
		}
		
		//method2
		//when we want to check more value like 1 to 15
		
		for(int i=2; i<=15; i++)
		{
			 flag = new PrimeNumber().prime(i);
			if (flag) {
				System.out.println(i + " is  prime number");
			} else {
				System.out.println(i + " is not prime number");
			}
		}

	}
}
