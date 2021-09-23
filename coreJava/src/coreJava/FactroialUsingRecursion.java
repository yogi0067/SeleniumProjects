package coreJava;

public class FactroialUsingRecursion {

	public int fact(int num) {
		if (num == 0)
			return 1;
		else {
			return num * fact(num - 1);
		}
	}

	public static void main(String[] args) {
		int num = 10;
		int fact = new FactroialUsingRecursion().fact(num);
		System.out.println(fact);
	}

}
