package strings;

import java.util.ArrayList;

public class StringArrayListTricky {
	public static void main(String[] args) {
		
		
		ArrayList<String> str= new ArrayList<String>();
		
		str.add("");
		for(String st:str)
		{
			System.out.println(st.length());
		}
		str.add(null);
		for(String st:str)
		{
			System.out.println(st.length());
		}
	}

}
