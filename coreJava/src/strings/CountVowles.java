package strings;

public class CountVowles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str= "Code Karo or Karte Raho";
		int vowCount=0;
		int consonetCount=0;
		int space=0;
		for(int i=0; i<str.length(); i++)
		{
			char ch= str.charAt(i);
			if(ch=='A'||ch=='E'||ch=='I'||ch=='O'
					||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
			{
				vowCount++;
			}
			else if(ch==' ')
				space++;
			else
				consonetCount++;
		}
		System.out.println("Vowels Count is "+vowCount);
		System.out.println("Consonent Count is "+consonetCount);
		System.out.println("space Count is "+space);
	}

}
