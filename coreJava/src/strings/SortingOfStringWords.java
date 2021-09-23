package strings;

public class SortingOfStringWords {
	
	public String sortMethod(String str)
	{
		char [] arr= str.toCharArray();
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
		String result="";
		for(int i=0; i<arr.length; i++) 
		{
			result=result+arr[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str="my name is rajat";
		String [] str1=str.split(" ");
		String rev="";
		for(int i=0; i<str1.length; i++)
		{
			rev=rev+new SortingOfStringWords().sortMethod(str1[i])+" ";
		}
		System.out.println(rev);
	}
	
	

}
