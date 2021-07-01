package dynamic.programming;

import java.util.Arrays;

class FindDup {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1, 3, 6, 6};
        new FindDup().printRepeating(num);
        
    }
    
    /**
     * Check the sign of A[abs(A[i])]
     * if   positive then make it negative by A[abs(A[i])] = -A[abs(A[i])]
     * else this element (ith element of list) is a duplication
     */
    public void printRepeating(int[] num) {
        if (num == null || num.length == 0) return;
        for (int i = 0; i < num.length; i++) {
        	System.out.println("i: "+i+"\t num[i]: "+num[i]+ "\t Math.abs(num[i]): "+Math.abs(num[i])+"\t num[Math.abs(num[i])]: "+num[Math.abs(num[i])]);
            if (num[Math.abs(num[i])] < 0) { // duplicate
                System.out.println(Math.abs(num[i])); // print dups
            } else { // set flag
                num[Math.abs(num[i])] = -num[Math.abs(num[i])]; // mark
            }
            System.out.println("\t\t num[] : "+Arrays.toString(num)+"\n");
        }
    }
}