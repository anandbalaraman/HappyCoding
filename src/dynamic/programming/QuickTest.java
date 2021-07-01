package dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;

public class QuickTest {
	
	private void m1() {
		System.out.println("q1 m1");
	}
	
	private static void m2() {
		System.out.println("q1 m2");
	}

	// @Mock
	// SFTPTransferService service;

	// @Rule
	// public MockitoRule rule = MockitoJUnit.rule();

	static int permutationCounter = 0;

	static void findOneMissingNumberFromIntArray() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
				29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54,
				55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
				81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };
		int missingNbrMath = (arr.length + 1) * (arr.length + 2) / 2;

		for (int i : arr) {
			missingNbrMath -= i;
		}
		System.out.println("missing number is: " + missingNbrMath);
	}

	static boolean palindromeCheck(String str) {
		return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
	}

	static String removeCharViaLooping(String str, char ch) {
		char[] strChars = str.toCharArray();
		StringBuilder cleanedStr = new StringBuilder();
		for (char strChar : strChars) {
			if (strChar != ch)
				cleanedStr.append(strChar);
		}
		System.out.println("Input String: " + str);
		System.out.println("Cleaned String: " + cleanedStr);
		return cleanedStr.toString();
	}

	public static String removeCharViaRecursion(String str, char ch) {
		int i = str.indexOf(ch);
//		System.out.println("Input String: " + str);
		if (i != -1)
			return removeCharViaRecursion(str.substring(0, i) + str.substring(i + 1, str.length()), ch);
		else {
			System.out.println("Cleaned String: " + str);
			return str;
		}
	}

	public static void printPermutations(String str) {
		permutationCounter = 0;
		calculatePermutations("", str);
		System.out.println("Total permutations: " + permutationCounter+" for input: "+str);
	}

	public static void calculatePermutations(String lockedChars, String permutateChars) {
		if (permutateChars.isEmpty()) {
			permutationCounter++;
			System.out.println("--Permutation calc: "+lockedChars + permutateChars);
		} else {
			for (int i = 0; i < permutateChars.length(); i++) {
				calculatePermutations(lockedChars + permutateChars.charAt(i),
						permutateChars.substring(0, i) + permutateChars.substring(i + 1, permutateChars.length()));
			}
		}
	}

	public static void printSecondHighestNumber(Integer[] intArray) throws InterruptedException {
		List<Integer> inputList = Arrays.asList(intArray);
		Collections.sort(inputList);
		Set<Integer> inputSet = new HashSet<Integer>(inputList);

		if (inputSet.size() >= 2)
			System.out.println("Second highest number: " + inputSet.toArray()[inputSet.size() - 2]+" in the input: "+inputList);
		else
			System.out.println("Input array does not contain a second highest number. The first highest number is: "
					+ inputSet.toArray()[0]+" in the input: "+inputList);
	}
	
	static void printSecondHighestNumber2(int[] in) {
		if(in.length<=2)
			System.out.println("Not enough elements to compare");
		else {
			int firstMax=0, secondMax=0;
			for(int i : in) {
				if(i!=firstMax) {
					if(i>firstMax) {
						secondMax = firstMax;
						firstMax = i;
					}
					else if(i>secondMax)
						secondMax = i;
				}
			}
			System.out.println("Second highest number: " + secondMax+" in the input: "+Arrays.toString(in));
		}
	}
	
	public static boolean isStringRotated(String str1, String str2) {
		return (str1.length() == str2.length() && (str1 + str1).contains(str2));
	}

	public static String rotateString(String str, int offset) {
		if (offset < 0)
			offset = str.length() + offset;
		return (str.substring(offset) + str.substring(0, offset));
	}

	public static void findFirstNonRepeatingChar(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i + 1).toLowerCase().contains(("" + str.charAt(i)).toLowerCase()))
				continue;
			else {
				System.out.println("First non repeating char is: " + str.charAt(i)+ " for input String: "+str);
				break;
			}
		}
	}

	public static boolean areParenthesesBalanced2(String str) {
		Map<Character, Character> mappings = new HashMap<>();
		mappings.put('(', ')');
		mappings.put('[', ']');
		mappings.put('{', '}');

		Stack<Character> stc = new Stack<>();
		for (Character c : str.toCharArray()) {
			
			// If we see an open parenthesis (from key), push a close parenthesis into stack
			if (mappings.containsKey(c))
				stc.push(mappings.get(c));
			
			// Or, if we have closed parenthesis (from value), try popping it,
			// it must be exactly this character, else we have a mismatch
			else if (mappings.containsValue(c)) {
				if (mappings.isEmpty() || stc.pop() != c)
					return false;
			}
		}

		// Finally stack should be empty if all pushed parenthesis are popped in order correctly
		System.out.println("Parentheses result: "+stc.isEmpty()+" for input: "+str);
		return stc.isEmpty();
	}

	public static boolean areParenthesesBalanced(String str) {

		boolean result = true;
		Map<Character, Integer> parMap = new HashMap<Character, Integer>();
		parMap.put('(', 0);
		parMap.put('[', 0);
		parMap.put('{', 0);
		parMap.put(')', 0);
		parMap.put(']', 0);
		parMap.put('}', 0);
		for (char c : str.toCharArray()) {
			parMap.put(c, Integer.parseInt(parMap.get(c).toString()) + 1);
		}
		if (parMap.get('(') != parMap.get(')'))
			result = false;
		else if (parMap.get('[') != parMap.get(']'))
			result = false;
		else if (parMap.get('{') != parMap.get('}'))
			result = false;
		
		System.out.println("Parentheses result: "+result+" for input: "+str);
		return result;
	}

	public static void recursiveBubbleSort(int[] arr, int size) {
		if (size <= 1)
			return;
		else {
			for (int i = 0; i < size - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			recursiveBubbleSort(arr, size - 1);
		}
	}

	public static int recursiveFibonacciUpto(int n) {
		if (n <= 1)
			return n;
		else
			return recursiveFibonacciUpto(n - 1) + recursiveFibonacciUpto(n - 2);
	}

	public static int recursiveFactorialUpto(int n) {
		if (n <= 1)
			return 1;
		else
			return n * recursiveFactorialUpto(n - 1);
	}

	static int counter = 0;

	static boolean isHappyNumber(int n) {
		if (n < 4)
			return false;
		// Strip down the numbers by last digit, one by one and square them
		else {
			int sum = 0;
			while (n / 10 >= 1 && counter < 14) {
				// System.out.println(" in loop: sum: "+sum+" n: "+n);
				sum += (int) Math.pow(n % 10, 2);
				n = n / 10;
				// without this counter, the job goes ON and ON !!
				counter++;
				// System.out.println(" after updated in loop: sum: "+sum+" input: "+n);
			}
			sum += (int) Math.pow(n % 10, 2);
			System.out.println(" finished loop: sum: " + sum + " input: " + n);
			if (sum == 1)
				return true;
			// now manipulate re-do the check for new sum, if we are looping within limits
			else if (counter < 14)
				return isHappyNumber(sum);
			else
				return false;
		}
	}

	static void printDecodedString(String inputStr) {
		StringBuilder finalStr = new StringBuilder();
		String[] subStr = inputStr.split("\\]");

		for (String str : subStr) {
			if (str.contains("[")) {
				String[] tempStr = str.split("\\[");

				// Extract any prefixing alphabets
				finalStr.append(tempStr[0].replaceAll("[0-9]+", ""));

				int n = Integer.parseInt(tempStr[0].replaceAll("[a-zA-Z]+", ""));
				// Iterate and append the strings 'n' times
				while (n > 0) {
					finalStr.append(tempStr[1]);
					n--;
				}
			} else
				finalStr.append(str);
		}
		System.out.println("Input String: " + inputStr + "	Decoded string: " + finalStr);
	}
	
	static void courseSchedule(String num, String in) {
		int n = Integer.parseInt(num);
		String[] courseArr = in.split(",");
		Map<Integer, String[]> courseMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		
		for(String str : courseArr) {
			String[] courseDep = str.split(" ");
			courseMap.put(Integer.parseInt(courseDep[0]), courseDep);
		}
		
		// add all courses without dependencies in order
		for(int i=0; i<n; i++) {
			if(courseMap.containsKey(i)) {
				continue;
			}
			else {
				result.add(i);
			}
		}
		
		// now check for each element
		for(int i=0; i<n; i++) {
			if(courseMap.containsKey(i)) {
				String[] courses = courseMap.get(i);
				for(int j=1; j<courses.length; j++) {
					if(result.contains(Integer.parseInt(courses[j]))){
						if(j==courses.length-1 && !result.contains(Integer.parseInt(courses[0])))
							result.add(Integer.parseInt(courses[0]));
						else
							continue;
					}
					// pull dependencies for this course
					else {
						String[] subCourses = courseMap.get(Integer.parseInt(courses[j]));
						for(int k=1; k<subCourses.length; k++) {
							if(result.contains(Integer.parseInt(courses[k]))){
								continue;
							}
							else
								result.add(Integer.parseInt(courses[k]));
						}
						result.add(Integer.parseInt(courses[0]));
					}
				}
			}
		}
		
		System.out.println("Course schedule: "+result);
	}
	
	static void printMaxPalindromicString(String input) {
		String pStr = input.substring(0,1);
		StringBuilder tempStr1 = new StringBuilder();
		StringBuilder tempStr2 = new StringBuilder();

		char c[]=input.toCharArray();
		for(int i=0; i<c.length; i++) {
			// clean up temp strings everytime you loop in
			tempStr1.setLength(0);
			tempStr2.setLength(0);
			if(i+1<c.length) {
				// pick 2 characters to check for palindrome
				tempStr1.append(c[i]).append(c[i+1]);
				// find last occurrence of the reversed 2 characters
				int lastInd = input.lastIndexOf(tempStr1.reverse().toString());
				if(lastInd >= i) {
					tempStr2.append(input.substring(i, lastInd+2));
					System.out.println("--Testing palindromic string: "+tempStr2);
					// check for palindrome
					if(tempStr2.length()>pStr.length() && palindromeCheck(tempStr2.toString())) {
						pStr = tempStr2.toString();
					}
					else if(tempStr2.length()<pStr.length())
						break;
					else
						continue;
				}
			}
		}
		System.out.println("InputString: "+input+"\n\t MaxPalindromicString: "+pStr+"\n\t of length: "+pStr.length());
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
//		printMaxPalindromicString("aaaabbaa");
//		printMaxPalindromicString("forgeeksskeegfor");
//		printMaxPalindromicString("vnrtysfrzrmzlygfv");
//		printMaxPalindromicString("qrrc");
//		printMaxPalindromicString("wqecyjyibfjykmjfq"); // code breaks here
		
		// DP based
		courseSchedule("4", "1 0,2 0,3 1,3 2");
		courseSchedule("6", "5 4,2 1 0,0 3,1 5");
		courseSchedule("9", "6 2 0,5 3,7 4 8,2 1 0,1 7 5 0");
		courseSchedule("7", "1 0,0 3,0 2,3 2,2 5,4 5,5 6,2 4"); // correct answer is [6,5,4,2,3,0,1]
		
		// string a number
		System.out.println(Pattern.matches("\\d+", "789545454524574444"));
		// Alternatively / Logically
		System.out.println("123".matches("[0-9]+"));
		System.out.println(NumberUtils.isNumber("789545454524574444"));
		System.out.println(NumberUtils.isDigits("789545454524574444"));
		
		// string contains number
		System.out.println(Pattern.matches(".*\\d+.*", "sdarfdgfgkluh876sadfkjh"));
		
		// string contains characters
		System.out.println(Pattern.matches(".*\\D+.*", "sdarfdgfgkluh876sadfkjh"));
		
		// extract digits/characters from string
		// convert to char array and filter necessary ones
		// use string replaceAll function to replace unnecessary characters with ""
		// use new Scanner(str).useDelimiter("[^\\d]+").nextInt()... use next() instead of nextInt() to get the digits as string
		
		
		
		findOneMissingNumberFromIntArray();

		System.out.println("Palindrome check: "+palindromeCheck("Madam"));

		removeCharViaLooping(
				"Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, "
				+ "search engine, cloud computing, software, and hardware. It is considered one of the Big Four technology companies, alongside Amazon, Apple and Facebook.", 'a');
		removeCharViaRecursion(
				"Google LLC is an American multinational technology company that specializes in Internet-related services and products, which include online advertising technologies, "
				+ "search engine, cloud computing, software, and hardware. It is considered one of the Big Four technology companies, alongside Amazon, Apple and Facebook.", 'a');

		printPermutations("1234");

		printSecondHighestNumber(new Integer[] { 1, 5, 3, 4, 5 });
		printSecondHighestNumber2(new int[] { 1, 5, 3, 4, 5 });
		printSecondHighestNumber(new Integer[] { 5, 5, 5, 5, 5 });
		printSecondHighestNumber2(new int[] { 5, 5, 5, 5, 5 });

		System.out.println(isStringRotated("ABCD", "CDAB"));
		System.out.println(isStringRotated("amazon", "azonam"));

		System.out.println(rotateString("ABCD", -1));
		System.out.println(rotateString("ABCD", 1));

		findFirstNonRepeatingChar("Madam");

		System.out.println(areParenthesesBalanced("{{}[[[[[[)))"));
		System.out.println(areParenthesesBalanced("{{{[[[(((]]]}}}))){([})]"));
		System.out.println(areParenthesesBalanced2("{{}[[[[[[)))"));
		System.out.println(areParenthesesBalanced2("{{{[[[(((]]]}}}))){([})]"));

		System.out.println(recursiveFactorialUpto(5));

		System.out.println(recursiveFibonacciUpto(6));

		System.out.println(isHappyNumber(100));
		System.out.println(isHappyNumber(19));
		System.out.println(isHappyNumber(200));

		printDecodedString("zz10[a]5[b]ccc");

		int[] arr = { 5, 4, 3, 2, 1 };
		recursiveBubbleSort(arr, 5);
		System.out.println(Arrays.toString(arr));

		// Runnable myLambda = () -> {
		// System.out.println("Hello LAMBDA World !!");
		// System.out.println("How are you?");
		// };
		// myLambda.run();
		
	}

	// @Test
	// public void testSomething() throws Exception {
	// Mockito.when(service.getFile(null, null, null, null)).thenReturn(true);
	// Assert.assertTrue(service.getFile(null, null, null, null));
	// Mockito.verify(service).getFile(null, null, null, null);
	// System.out.println(" print something");
	// }

	@Test
	public void testSomethingMore() throws Exception {
		// Assert.assertTrue(service.getFile(null, null, null, null));
		System.out.println("    print something more");
	}

	@Before
	public void doSomethingBefore() {
		System.out.println("print something BEFORE");
	}

	@BeforeClass
	public static void initBefore() {
		System.out.println("print something BEFORE-CLASS INIT");
	}

	@After
	public void doSomethingAfter() {
		System.out.println("print something After");
	}

	@AfterClass
	public static void end() {
		System.out.println("print something AFTER-CLASS END");
	}
}
