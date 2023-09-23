package M2;

import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        //Don't edit anything here
        int[] a1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] a2 = new int[]{0, 1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        int[] a3 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] a4 = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10};
        
        processArray(a1);
        processArray(a2);
        processArray(a3);
        processArray(a4);
    }
    static void processArray(int[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        System.out.println("Odds output:");
        //hint: use the arr variable; don't diretly use the a1-a4 variables
        //TODO add/edit code here
        
        // shc4, it114-005, 9/19/23
        /* This for-loop is going through the integers in the array 
         * and seeing if the remainder comes out to be 1 to indicate
         * it is odd.
        */
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%2 == 1){
                System.out.print(arr[i] + " ");
            }
        }
        //end add/edit section
        System.out.println();
        System.out.println("End process");
    }

}
    