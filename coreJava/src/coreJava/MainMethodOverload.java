package coreJava;

public class MainMethodOverload {

		   public static void main(){
		      System.out.println("This is the overloaded main method");
		   }
		   public static void main(String args[]){
			   System.out.println("I am Actula main method from where executeion starts");
			   MainMethodOverload obj = new MainMethodOverload();
			   MainMethodOverload.main();
		   }
		
}
