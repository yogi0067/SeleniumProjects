package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchWordFromString {
	public static void main(String[] args) {
		String str = "This is Core java Practice";
		String[] arr = str.split(" ");
		System.out.println("Number of words =" + arr.length);
		String word="java";
		ArrayList<String> list= new ArrayList();
		//list=(ArrayList<String>) Arrays.asList(arr); Method2 optimized method
		for(String st1r :arr)
		{
			list.add(st1r);
		}
		System.out.println(list);
		System.out.println(list.contains(word));

	}

}
