package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.SSLSession;

class abc {
	
	public static int count=0;
	
	public abc(int a)
	{
		
	}
	public void m1()
	{
		System.out.println("ava");
	}
	
	
	

}

  class abcd extends abc {
	  
	
	
	



	public abcd(int a) {
		super(a);
		// TODO Auto-generated constructor stub
	}
	public void m1() throws RuntimeException
	{
		System.out.println("aa");
	}
	public static void main(String[] args) {
		
		abc aa= new abcd(1);
		String arr[]= {"5","15","25"};
		Arrays.sort(arr);
		for(String a:arr)
		{
			System.out.println(a);
		}
	}
	

}
