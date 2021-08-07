import java.util.ArrayList;
public class BasicJava {
    public static void main(String[] args) {
        JavaMethods methodTest = new JavaMethods();

        //first
        // int oneTo255 = methodTest.firstMethod();

        //second
        // int printEveryOdd = methodTest.secondMethod();

        //third
        // int sumTo255 = methodTest.thirdMethod();

        //fourth
        // int[] thisArray = {5, 9, 3, 7, 16, 2, 17, 2};
        // int[] iterateArray = methodTest.fourthMethod(thisArray);

        //fifth
        // int[] thisArray = {5, 0, 3, 7, -12, 2, 17, 2};
        // int[] maxNum = methodTest.fifthMethod(thisArray);

        //sixth
        // ArrayList<Integer> oddsTo255 = methodTest.sixthMethod();

        //seventh
        // int[] thisArray = {5, 0, 3, 7, -12, 2, 17, 2, 18};
        // double printAverage = methodTest.seventhMethod(thisArray);

        //eigth
        // int[] thisArray = {5, 0, 3, 7, -12, 2, 17, 2, 18};
        // int countHighs = methodTest.eigthMethod(thisArray, 5);

        //ninth
        int[] thisArray = {5, 0, 3, 7, -12, 2, 17, 2, 18};
        int[] squaredArray = methodTest.ninthMethod(thisArray);


        // System.out.println(oneTo255);
        // System.out.println(printEveryOdd);
        // System.out.println(sumTo255);
        // System.out.println(iterateArray);
        // System.out.println(maxNum);
        // System.out.println(oddsTo255);
        // System.out.println(printAverage);
        // System.out.println(countHighs);
        System.out.println(squaredArray);

    }
}