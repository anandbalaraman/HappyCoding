package dynamic.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QuickCode {
	
	public static void main(String[] args) {
//		printPermutationsPalindrome("ABC");
//		System.out.println("===== new case ======");
//		printPermutationsPalindrome("AAB");
		
		Map<String, List<String>> mgrMap = new HashMap();
		List<String> empList1 = new ArrayList();
		List<String> empList2 = new ArrayList();
		
		empList1.add("m1emp1");
		empList2.add("m2emp1");
		
		mgrMap.put("m1", empList1);
		mgrMap.put("m2", empList2);
		
		mgrMap.get("m1").add("m1emp2");
		
		Set<Entry<String, List<String>>> entries = mgrMap.entrySet();
		for(Entry<String, List<String>> entry:entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue().toString());
		}
	}
	
	static void printPermutationsPalindrome(String str) {
		calculatePermutations("", str);
	}
	
	static void calculatePermutations(String lockedChars, String permutateChars) {
		if (permutateChars.isEmpty()) {
			System.out.println("--Permutator output: "+lockedChars + permutateChars + " isPalindrome(): "+checkPalindrome(lockedChars + permutateChars));
		} else {
			for (int i = 0; i < permutateChars.length(); i++) {
				calculatePermutations(lockedChars + permutateChars.charAt(i),
						permutateChars.substring(0, i) + permutateChars.substring(i + 1, permutateChars.length()));
			}
		}
	}
	
	static boolean checkPalindrome(String str) {
		return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
	}

}
