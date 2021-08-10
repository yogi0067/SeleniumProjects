package googleAPI;

import utilites.JsonParser;
import files.JsonDataFile;
import io.restassured.path.json.JsonPath;

public class JsonValidation {
	public static void main(String[] args) {
		
		
		JsonPath jp=  JsonParser.complexJson(JsonDataFile.getComplexJson());
		//print no of courses rstuned by API
		System.out.println("print no of courses returned by API");
		System.out.println(jp.getInt("courses.size()"));
		
		//Print Purchage amount
		System.out.println("print Purchage amount");
		int purchaseAmount=jp.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		//Print Title of First Course
		System.out.println("Print Title of First Course");
		System.out.println(jp.getString("courses[0].title"));
		
		//Print all courses and their price as well
		System.out.println("Print all courses and their price as well");
		for(int i=0; i<jp.getInt("courses.size()"); i++)
		{
			System.out.print(jp.getString("courses["+i+"].title")+ " ");
			System.out.println(jp.getString("courses["+i+"].price"));
		}
		
		//print no of copied sold by RPA Course
		System.out.println("print no of copied sold by RPA Course");
		for(int i=0; i<jp.getInt("courses.size()"); i++)
		{
			if(jp.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
			{
				System.out.println(jp.getString("courses["+i+"].copies"));
				break;
			}
				
			
		}
		//VErify if sum of all courses prices mathes with purchage amout
		System.out.println("VErify if sum of all courses prices mathes with purchage amout");
		int sum=0;
		for(int i=0; i<jp.getInt("courses.size()"); i++)
		{
			
				int copies=jp.getInt("courses["+i+"].copies");	
				int prices=jp.getInt("courses["+i+"].price");
				sum=sum+(copies*prices);
		}
		if(sum==purchaseAmount)
		{
			System.out.println("Sum "+sum+" and Purchage amount "+purchaseAmount+" is EQUAL");
		}
		else {
			System.out.println("Sum"+sum+" and Purchage amount"+purchaseAmount+" is NOT EQUAL");
		}
			
		
	}

}
