import java.util.ArrayList;

public class JavaMethods {

    // Write a method that prints all the numbers from 1 to 255
    public int firstMethod() {
        int i = 1;
        while (i < 255) {
            System.out.println(i);
            i++;
        }
        return i;
    }

    // Write a method that prints all the odd numbers from 1 to 255.
    public int secondMethod() {
        int i = 1;
        while (i < 255) {
            if(i%2==1) {
                System.out.println(i);
                i++;
            } else {
                i++;
            }
        }
        return i;
    }

    //Sum to 255
    public int thirdMethod() {
        int i = 0;
        int sum = 0;
        while (i <= 255) {
            sum += i;
            i++;
        }
        return sum;
    }

    // iterate through each member of the array and print each value
    public int[] fourthMethod(int[] thisArray) {
        for(int num : thisArray) {
            System.out.println(num);
            num++;
        }
        return thisArray;
    }

    // print the maximum value in the array
    public int[] fifthMethod(int[] thisArray) {
        int maxNum = 0;
        for(int num : thisArray) {
            if(num > maxNum){
                maxNum = num;
                num++;
            }
        }
        System.out.println(maxNum);
        return thisArray;
    }

    //Array of odd numbers
    public ArrayList<Integer> sixthMethod(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 1; i <= 255; i++){
            if(i%2 == 1){
                y.add(i);
            }
        }
        return y;
    }

    //Print Average of Array
    public double seventhMethod(int[] thisArray){
        double totalSum = 0.0;
        double divider = thisArray.length;
        for(double num : thisArray){
            totalSum += num;
        }
        double averageArray = (totalSum / divider);
        return averageArray;
    }
    //Print total count of numbers in an array higher than a given number
    public int eigthMethod(int[] thisArray, int num){
        int count = 0;
        for(int number : thisArray){
            if(number > num){
                count += 1;
            }
        }
        return count;
    }
    //square the values of an array
    public int[] ninthMethod(int[] thisArray){
        for(int num : thisArray){
            num = num*num;
            System.out.println(num);
        }
        return thisArray;
    }
    
}
