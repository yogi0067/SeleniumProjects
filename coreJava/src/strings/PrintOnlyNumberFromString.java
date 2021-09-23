package strings;

public class PrintOnlyNumberFromString {
	public static void main(String[] args) {
		
		String str= "abc123ab56h ;";
		
		for(int i=0; i<str.length()-1; i++)
		{
			if(str.charAt(i)<59 && str.charAt(i)>47)
			{
				System.out.println(str.charAt(i));
			}
		}
		
		
		
		
	}

}
