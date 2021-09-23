package collections;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListFindDuplicate {
	
	public static void findDuplicate(Object s, ArrayList list)
	{
		int count=0;
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).equals(s));{
			count++;}
		}
		if(count >1)
		{
			System.out.println(s + " "+count);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		ArrayList list= new ArrayList();
		list.add("abc");
		list.add(1);
		list.add(1);
		list.add("abcd");
		list.add(2);
		
		
		HashSet set = new HashSet<>(list);
		
		for(Object s:set)
		{
			System.out.println(s);
			findDuplicate(s, list);
		}
		
	}

}
