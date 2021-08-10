package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CountEachCharacterInString {

	public void countEachCharacter(char [] arr, String str) {
		
		int count=0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]==str.charAt(0))
				count++;
		}
		System.out.println( "Count of "+ str.charAt(0) +" is : "+ count);
	}
	
	public static void main(String[] args) {
		String str= new String("TestTEstesfdfd");;
		System.out.println(str);
		
		char arr[] = str.toCharArray();
		HashSet set = new HashSet();
		Set seT= new HashSet<>( Arrays.asList(arr));
		for(int i=0; i< arr.length; i++)
		{
			seT.add(arr[i]);
		}
		
		Iterator data = set.iterator();
		
		while(data.hasNext())
		{
			new CountEachCharacterInString().countEachCharacter(arr, data.next().toString());
		}
	}
}
