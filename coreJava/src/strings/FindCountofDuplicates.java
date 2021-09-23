package strings;

import java.util.HashSet;
import java.util.Iterator;

public class FindCountofDuplicates {

	public static void findCountofDuplicates(char[] arr, String string) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (string.charAt(0) == arr[i]) {
				count++;
			}
		}
		if (count > 1) {
			System.out.println(string.charAt(0) + " is dupicate " + count + " times");
		}

	}

	public static void main(String[] args) {

		String str = "Fidelityinformation";
		char[] chr = str.toCharArray();

		HashSet<Character> chars = new HashSet<Character>();
		
		for (int i = 0; i < chr.length; i++) {
			chars.add(chr[i]);
		}

		Iterator test = chars.iterator();
		while (test.hasNext()) {
			findCountofDuplicates(chr, test.next().toString());
		}

	}

}
