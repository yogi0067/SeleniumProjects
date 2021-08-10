package coreJava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputOutput {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Please Enter Input String : ");
		String inputString= sc.nextLine();
		System.out.println("Hello, World.");
		System.out.println(inputString);
		
		
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate= DateFor.format(date);
		System.out.println();
		
	}
}
