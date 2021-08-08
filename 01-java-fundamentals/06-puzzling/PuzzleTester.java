import java.util.Random;
import java.util.ArrayList;

public class PuzzleTester {
    public static void main(String[] args) {
        PuzzleJava methodTest = new PuzzleJava();

        //getTenRolls
        // int[] randomOneToTwenty = methodTest.getTenRolls();


        //getRandomLetter
        // String randomLetter = methodTest.getRandomLetter();

        //generatePassword
        // String concatPassword = methodTest.generatePassword();

        //getNewPasswordSet
        ArrayList<String> eightPasswords = methodTest.getNewPasswordSet(5);

        // System.out.println(randomOneToTwenty);
        // System.out.println(randomLetter);
        // System.out.println(concatPassword);
        System.out.println(eightPasswords);
    }
}
