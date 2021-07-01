package dynamic.programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Practice {

	static int minCount = Integer.MAX_VALUE;
	static int iter = 0;

	static int findMinCoins(Integer arr[], int sum) {
		int count = 1;

		if (arr.length == 0)
			return 0;

		// For array with single number, find the closest possible multiples of
		// value to sum
		if (arr.length == 1 && sum % arr[0] == 0) {
			for (int multiplier = 1; multiplier <= Integer.MAX_VALUE; multiplier++) {
				if (arr[0] * multiplier <= sum) {
					count = multiplier;
				} else
					break;
			}
			return count;
		} else {
			System.err.println("Desired sum not possible using this arr value: " + arr[0]);
			System.out.println("Increase count to higher values");
			count++;
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int tempSum = 0;
		for (int i = 0; i < arr.length && arr[i] <= sum; count = 1, i++) {

			// If max value exactly equals the sum, then count=1
			if (arr[i] == sum)
				return 1;

			else {
				// First, multiply with same value and check for <=sum
				for (int multiplier = 1; multiplier <= Integer.MAX_VALUE && (sum - tempSum > 0); multiplier++) {
					if (arr[i] * multiplier <= sum) {
						tempSum = arr[i] * multiplier;
						count = multiplier;
					}
					// Now pick the next high number and repeat the process
					else {
						System.out
								.println("so far we have got count=" + count + " and (sum-tempSum)=" + (sum - tempSum));
						Integer tempArr[] = Arrays.copyOfRange(arr, 1, arr.length);
						System.out.println("try calling the function for tempArr:" + tempArr[0]);
						count = count + Practice.findMinCoins(tempArr, sum - tempSum);
						System.out.println("	Count so far (after recursion):" + count);
						break;
					}
				}
			}
			if (Practice.minCount > count)
				Practice.minCount = count;
		}

		return count;
	}

	static void reverseDigitsSumAndPrintPalindrome(Integer n) {
		if (n == null || n == 0)
			System.out.println(
					"Iteration number of reversing and summing up digits: " + iter + " Palindrome Value: " + n);
		else {
			StringBuilder nStr = new StringBuilder(n.toString());
			Integer sum = n + Integer.valueOf(nStr.reverse().toString());
			nStr = new StringBuilder(sum.toString());
			if (sum.toString().equalsIgnoreCase(nStr.reverse().toString())) {
				System.out.println(
						"Iteration number of reversing and summing up digits: " + iter + " Palindrome Value: " + nStr);
			} else {
				iter++;
				Practice.reverseDigitsSumAndPrintPalindrome(sum);
			}
		}
	}

	static void reverseDigits(Integer num) {
		System.out.println("Actual num:" + num);
		Integer revNum = 0;
		// Until there is a single digit, which cannot be reversed
		while (num / 10 > 0) {
			revNum = revNum * 10 + num % 10;
			num = num / 10;
		}
		// for that last single digit
		revNum = revNum * 10 + num;
		System.out.println("Reversed num:" + revNum);
	}

	public static String findLowestKthElementFromArray(int k, Integer[] array) {
		String val = null;
		// Sort and get unique elements
		Set<Integer> arr = new HashSet<Integer>(Arrays.asList(array));
		if (k > arr.size()) {
			val = null;
		} else {
			Integer[] arrSort = new Integer[arr.size()];
			arr.toArray(arrSort);
			val = arrSort[k - 1].toString();
		}
		return val;
	}

	public static String insertStarHyphenBetweenNumbers(String in) {
		StringBuilder out = new StringBuilder("");

		// Convert Integer to int array
		int[] input = new int[in.length()];
		for (int i=0; i<input.length; i++)
			input[i] = in.charAt(i) - '0';

		int prev = input[0];
		out.append(prev);

		// Iterate through the numbers
		for (int i=1; i<input.length; i++) {
			// if even, append '-'
			if (prev % 2 == 0 && input[i] % 2 == 0)
				out.append("*");
			else if (prev % 2 != 0 && input[i] % 2 != 0)
				out.append("-");
			out.append(input[i]);

			// switch prev number
			prev = input[i];
		}

		return out.toString();
	}

	public static int numDecodings(String s) {
		System.out.println("Input: " + s);
		int count = 0;
		
		if(s.length()>1 && Integer.parseInt(s)>0)
			count++;
		else
			return count;

		// convert the String to char array
		char[] in = s.toCharArray();

		// iterate through char array
		for (int i=0; i<in.length; i++) {
			if (i != in.length-1) {
				String doubleDgt = in[i] + "" + in[i + 1];
				Integer doubleDgtVal = Integer.parseInt(doubleDgt);
				// if integerOf((chars[i]+chars[i+1])-0) < 26 -> decode
				if (doubleDgtVal > 0 && doubleDgtVal < 27)
					count++;
			}
		}
		return count;
	}
	
	public static int numDecodings2(String s) {
		int a = 1, pre = 1, curr = 0;
		for (int i = 0; i < s.length(); i++) {
			curr = pre;
			if (s.charAt(i) == '0') {
				curr = 0;
				if (i - 1 >= 0) {
					if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
						curr += a;
				}
			} else if (i - 1 >= 0) {
				if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
					curr += a;
			}
			a = pre;
			pre = curr;
		}
		return pre;
	}
	
    public static String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }

        return strBuilder.toString();
    }

    public static String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }



	public static void main(String[] args) {
		Integer coinsArray[] = { 9, 6, 5, 1 };
		int sum = 11;
		findMinCoins(coinsArray, sum);
		System.out.println("Min Coins needed to reach sum value(" + sum + ") is: " + minCount);

		iter = 0;
		reverseDigitsSumAndPrintPalindrome(195);
		iter = 0;
		reverseDigitsSumAndPrintPalindrome(19);
		iter = 0;
		reverseDigitsSumAndPrintPalindrome(121);

		reverseDigits(5052136);

		Integer[] array = { 3, 2, 8, 2, 3 };
		System.out.println(findLowestKthElementFromArray(3, array));

		System.out.println(insertStarHyphenBetweenNumbers("21462675756"));
		System.out.println(insertStarHyphenBetweenNumbers("98676555533"));

		System.out.println(numDecodings("226"));
		System.out.println(numDecodings2("226"));
		
		System.out.println(numDecodings("1101"));
		System.out.println(numDecodings2("1101"));
		
        //original string
        String str = "Sony is going to introduce Internet TV soon";
        System.out.println("Original String: " + str);

        //reversed string using Stringbuffer
        String reverseStr = new StringBuffer(str).reverse().toString();
        System.out.println("Reverse String in Java using StringBuffer: " + reverseStr);

        //iterative method to reverse String in Java
        reverseStr = reverse(str);
        System.out.println("Reverse String in Java using Iteration: " + reverseStr);

        //recursive method to reverse String in Java
        reverseStr = reverseRecursively(str);
        System.out.println("Reverse String in Java using Recursion: " + reverseStr);

	}

}
