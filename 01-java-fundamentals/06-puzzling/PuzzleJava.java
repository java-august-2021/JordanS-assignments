import java.util.Random;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class PuzzleJava {

    //Random Array Generator
    public int[] getTenRolls(){
        Random arrayNum = new Random();
        int[] thisArray = new int[10];
        for(int i = 0; i < thisArray.length;i++){
            thisArray[i] = arrayNum.nextInt(20) + 1;
            System.out.println(thisArray[i]);
        }
        return thisArray;
    }

    //getRandomLetter
    public String getRandomLetter(){
        String[] alphabetArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random arrayNum = new Random();
        String letter = alphabetArray[arrayNum.nextInt(25)];
        return letter;
    }


    //generatePassword
    public String generatePassword(){
        String[] alphabetArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String password = "";
        for(int i=0; i < 8; i++){
            Random arrayNum = new Random();
            String letter = alphabetArray[arrayNum.nextInt(25)];
            password = password + letter;
        }
        return password;
    }

    //getNewPasswordSet
    public ArrayList<String> getNewPasswordSet(int arrayLength){
        String[] alphabetArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String password = "";
        ArrayList<String> passwordSet = new ArrayList<String>();
        int counter = 1;
        while(counter <= arrayLength){
            for(int i=0; i < 8; i++){
                Random arrayNum = new Random();
                String letter = alphabetArray[arrayNum.nextInt(25)];
                password = password + letter;
            }
            passwordSet.add(password);
            password = "";
            counter++;
        }
        return passwordSet;
    }
}
