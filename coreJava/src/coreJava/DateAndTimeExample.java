package coreJava;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeExample {
		public static void main(String[] args) {
			//if you want to print only date then use class LocalDate
			LocalDate date= LocalDate.now();
			System.out.println(date); 
			
			//if you want to print  date and time both then use class LocalDateTime
			LocalDateTime myDateObj = LocalDateTime.now();
			System.out.println("Before formatting: " + myDateObj);
		    
		    //to format the date output
			
			/*Value	Example	Tryit
			 * 		Pattren    		Value	
					yyyy-MM-dd		"1988-09-29" 	
					dd/MM/yyyy		"29/09/1988"	
					dd-MMM-yyyy		"29-Sep-1988"	
					E, MMM dd yyyy	"Thu, Sep 29 1988"
					M-d-yy HH:mm:ss  8-7-21 19:01:48

			 */
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
			System.out.println("After formatting: " + date.format(myFormatObj));
			
			//if you want to include time then we use below datetime formater and datetime object
			myFormatObj=DateTimeFormatter.ofPattern("M-d-yy HH:mm:ss");
			System.out.println("After formatting: " + myDateObj.format(myFormatObj));
			
			
			
	}
}
