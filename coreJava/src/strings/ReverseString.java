package strings;

public class ReverseString {
	public static void main(String[] args) {
		
		String str= "lasnaB hsegoY";
		String rev="";
		
		for(int i=str.length()-1; i>=0; i--)
		{
			rev+=str.charAt(i);
		}
		System.out.println("Reverse of String \"" + str + "\" "
				+ "is :- " +rev);
			
		
	}
}
