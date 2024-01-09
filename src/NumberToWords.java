import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NumberToWords {

    public static String numToWords(int nSum, String gender, String wordCase) {
        ArrayList<Integer> threeDigitsNumbersArray = numberToThreeDigitsNumbers(nSum);
        String wordsWithoutThousandsMillions = NumberToWordsParseHelper.ThreeDigitsToWords(nSum, gender, wordCase);
        return wordsWithoutThousandsMillions;
    }

    public static ArrayList<Integer> numberToThreeDigitsNumbers(int number){
        ArrayList<Integer> arr = new ArrayList<>();
        while (number>0){
            int lastDigits = number%1000;
            arr.add(lastDigits);
            number/=1000;
        }
        Collections.reverse(arr);
        return arr;
    }
}