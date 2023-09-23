package M2;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        //Don't edit anything here
        double[] a1 = new double[]{10.001, 11.591, 0.011, 5.991, 16.121, 0.131, 100.981, 1.001};
        double[] a2 = new double[]{1.99, 1.99, 0.99, 1.99, 0.99, 1.99, 0.99, 0.99};
        double[] a3 = new double[]{0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01, 0.01};
        double[] a4 = new double[]{10.01, -12.22, 0.23, 19.20, -5.13, 3.12};
        
        getTotal(a1);
        getTotal(a2);
        getTotal(a3);
        getTotal(a4);
    }
    static void getTotal(double[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        double total = 0;
        String totalOutput = "";
        //hint: use the arr variable; don't diretly use the a1-a4 variables
        //TODO add/edit code here
        // shc4, it114-005, 9/20/23
        /* This for-loop goes through each iteration and multiples the number
         * by 1000 and adds it to the total variable. After that the total variable would
         * be divide by 1000 to get the decimal back. I used String formatting
         * to format to two decimal places.
        */
        for(int i = 0; i < arr.length; i++){
            total += (arr[i]*1000);
        }
        total = total/1000;
        //set the double to a string variable
        //TODO ensure rounding is to two decimal places (i.e., 0.10, 0.01, 1.00)
        
        // edits made on 9/21/23
        // Link: https://mkyong.com/java/java-display-double-in-2-decimal-points/
        // Link: https://www.youtube.com/watch?v=G7IbADolOl4
        // This link helped me find how to formate the the numbers to two decimal places
        //totalOutput = total + "";
        totalOutput = String.format("%.2f", total);
        
        //end add/edit section
        System.out.println("Total is " + totalOutput);
        System.out.println("End process");
    }
    
}