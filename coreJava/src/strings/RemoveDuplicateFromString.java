package strings;

import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicateFromString {

	
	public static void main(String[] args) {
		String str="Yogeeeesssshhhh";
		char chr[]= str.toCharArray();
		HashSet<Character> chars= new HashSet<Character>();
		
		for(int i=0; i<chr.length; i++)
		{
			chars.add(chr[i]);
		}
		
		Iterator test=chars.iterator();
		String str1="";
		while(test.hasNext())
		{
			str1=str1+test.next().toString();
		}
		System.out.println(str1);
	}
}
