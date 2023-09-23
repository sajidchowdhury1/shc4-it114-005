package M2;

import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {
        //Don't edit anything here
        Integer[] a1 = new Integer[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        Integer[] a2 = new Integer[]{-1, 1, -2, 2, 3, -3, -4, 5};
        Double[] a3 = new Double[]{-0.01, -0.0001, -.15};
        String[] a4 = new String[]{"-1", "2", "-3", "4", "-5", "5", "-6", "6", "-7", "7"};
        
        bePositive(a1);
        bePositive(a2);
        bePositive(a3);
        bePositive(a4);
    }
    // <T> turns this into a generic so it can take in any datatype, it'll be passed as an Object so casting is required
    static <T> void bePositive(T[] arr){
        System.out.println("Processing Array:" + Arrays.toString(arr));
        //your code should set the indexes of this array
        Object[] output = new Object[arr.length];
        //hint: use the arr variable; don't diretly use the a1-a4 variables
        //TODO convert each value to positive
        //set the result to the proper index of the output array
        //hint: don't forget to handle the data types properly, the result datatype should be the same as the original datatype
        
        // shc4 it114-005 9/22/23
        // Links: (Sources that I used for this problem)
        // 1) Math functions: https://www.w3schools.com/java/java_ref_math.asp
        // 2) Converting String to int: https://www.freecodecamp.org/news/java-string-to-int-how-to-convert-a-string-to-an-integer/
        // 3) Casting Wrappers into primitives: https://www.tutorialspoint.com/how-to-convert-wrapper-objects-to-primitive-types-in-java
        // 4) .getClass().getSimpleName(): https://www.tutorialspoint.com/java/lang/class_getsimplename.htm
        /* This for-loop iterates through each array. Depending on which datatype the iteration is on, it would go
         * through converting it to a primitive and use math.abs() to get a positive number. 
         * Another variable is made to put it back to its initial Wrapper or String datatype. 
         * Also it is placed into the new object array with its original datatype.
        */
        System.out.println("Positive output: ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i].getClass().getSimpleName().equals("Integer")){
                int x = Math.abs((int)arr[i]);
                Integer y = new Integer(x);
                output[i] = y;
                }
            else if(arr[i].getClass().getSimpleName().equals("Double")){
                double x = Math.abs((double)arr[i]);
                Double y = new Double(x);
                output[i] = y;
            }
            else if(arr[i].getClass().getSimpleName().equals("String")){
                int x = Math.abs(Integer.parseInt((String)arr[i]));
                String y = "" + x;
                output[i] = y;
            }
        }
        //end edit section

        StringBuilder sb = new StringBuilder();
        for(Object i : output){
            if(sb.length() > 0){
                sb.append(",");
            }
            sb.append(String.format("%s (%s)", i, i.getClass().getSimpleName().substring(0,1)));
        }
        System.out.println("Result: " + sb.toString());
    }
}