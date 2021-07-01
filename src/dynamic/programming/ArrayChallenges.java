package dynamic.programming;

import java.util.Arrays;

public class ArrayChallenges {
	
	public static void printKLargestFromArrayUsingDefaultSort(Integer[] arr, int k) {
		Arrays.sort(arr, java.util.Collections.reverseOrder());
		for(int i=0; i<k; i++)
			System.out.print(arr[i]+"->");
		
		System.out.println(Arrays.toString(arr));
		
		int len = arr.length;
		Arrays.sort(arr);
		for(int i=len-1; i>len-1-k; i--)
			System.out.print(arr[i]+"->");
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void printKLargestFromArrayUsingBubbleSort(Integer[] arr, int k) {
		int counter=0;
		int len = arr.length;
		for(int i=0; i<len-1; i++) {
			counter++;
			for(int j=0; j<len-1; j++) {
				counter++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i=len-1; i>len-1-k; i--)
			System.out.print(arr[i]+"->");
		
		System.out.println(Arrays.toString(arr)+"->"+counter);
	}
	
	public static void printKLargestFromArrayUsingOptimizedBubbleSort(Integer[] arr, int k) {
		int counter=0;
		int len = arr.length;
		// We need not sort the entire list. Just the final k elements needs to be sorted out.
		for(int i=0; i<k; i++) {
			counter++;
			// We skip the final sorted elements for improving time complexity
			for(int j=0; j<len-1-i; j++) {
				counter++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i=len-1; i>len-1-k; i--)
			System.out.print(arr[i]+"->");
		
		System.out.println(Arrays.toString(arr)+"->"+counter);
	}
	
	public static boolean doesInputHadPythagoreanTripletUsingBruteForce(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					int a = arr[i] * arr[i], b = arr[j] * arr[j], c = arr[k] * arr[k];
					if(a+b==c || b+c==a || c+a==b)
						return true;
				}
			}
		}
		return false;
	}
	
	public static boolean doesInputHadPythagoreanTripletUsingSquaringAndSorting(int[] arr) {
		int n = arr.length;
		for (int i=0; i<n; i++)
			arr[i] = arr[i] * arr[i];
		
		Arrays.sort(arr);
		
		// Start from last element of list (as that is the largest), skip first 2 (to be used for summing for a triplet)
		// Here is where we are being a bit efficient
		for(int i=n-1; i>=2; i--) {
			// Have 2 variables - one from left most and one from right most (before i) to do the math
			// Keep incrementing / decrementing low and high variables to do the math
			int low = 0;
			int high = i-1;
			
			// Do math until low < high
			// another efficiency gain
			while(low < high) {
				
				// Perfect match
				if(arr[low] + arr[high] == arr[i])
					return true;
				
				// went too high, try decrementing your high and redo the math for the same arr[i]
				else if (arr[low] + arr[high] > arr[i])
					high--;
				
				// went too low, try incrementing your low and redo the math for the same arr[i]
				else
					low++;
			}
			// Now both low and high must have met, so, we'll try the math on a different arr[i]
		}
		// Seems like nothing worked out in the entire loop, so simply return false
		return false;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1, 23, 12, 9, 30, 2, 50};
		printKLargestFromArrayUsingDefaultSort(arr, 3);
		arr = new Integer[] {1, 23, 12, 9, 30, 2, 50};
		printKLargestFromArrayUsingBubbleSort(arr, 3);
		arr = new Integer[] {1, 23, 12, 9, 30, 2, 50};
		printKLargestFromArrayUsingOptimizedBubbleSort(arr, 3);
		
		int[] ar = {3, 1, 4, 6, 5, 2};
		System.out.println(doesInputHadPythagoreanTripletUsingBruteForce(ar));
		System.out.println(doesInputHadPythagoreanTripletUsingSquaringAndSorting(ar));
	}

}
