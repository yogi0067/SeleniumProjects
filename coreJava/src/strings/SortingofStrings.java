package strings;

public class SortingofStrings {

	public static void main(String[] args) {
		
		String str= "bAdc";
		char arr[]=str.toCharArray();
		
		for(int i=0; i<arr.length; i++) 
		{
			for(int j=0; j<arr.length; j++) 
			{
				 
				if(arr[i]<arr[j])
				{
					char chTemp=arr[i];
					arr[i]=arr[j];
					arr[j]=chTemp;
				}
			}
		}
		for(int i=0; i<arr.length; i++) 
		{
			System.out.print(arr[i]);
		}
	}
}
