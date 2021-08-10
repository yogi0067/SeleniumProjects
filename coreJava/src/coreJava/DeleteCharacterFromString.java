package coreJava;

public class DeleteCharacterFromString {
	
	public static void main(String[] args) {
		String str= "YogeBshB";
		StringBuffer strbuf= new StringBuffer(str);
		
		char ch='B';
		for(int i=0; i<strbuf.length(); i++)
			
		{
			if(strbuf.charAt(i)==ch)
			{
				strbuf.deleteCharAt(i);
			}
		}System.out.println(strbuf);
	}
	

}
