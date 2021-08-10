package coreJava;

public class InheritanceTrick2  extends InheritanceTricky{
	private InheritanceTrick2()
	{
		System.out.println();
		
	}
	
	public void test()
	{
		//super.test();
		System.out.println(" InheritanceTrickytest2");
	}
	public static void main(String[] args) {
		InheritanceTrick2 obj= new InheritanceTrick2();
		
		obj.test();
	}
}
