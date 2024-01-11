import enums.WordCaseEnum;
import java.util.ArrayList;
import java.util.Stack;

public class NumberToWords {

    public static String numToWords(long nSum, String gender, String wordCase) {
        ArrayList<Integer> threeDigitsNumbersArray = numberToThreeDigitsNumbers(nSum);
        Stack<String> wordsOfNumberAndPartNames = new Stack<>();
        WordCaseEnum wordCaseEnumElem = WordCaseEnum.getCaseByLetter(wordCase);
        StringBuilder sb = new StringBuilder();
        for (int i= 0; i<threeDigitsNumbersArray.size();i++) {
            int threeDigitsNumber = threeDigitsNumbersArray.get(i);
            String threeDigitPartNumber = NumberBigPartNameGetHelper.getPartNameToThreeDigit(threeDigitsNumber , i ,wordCaseEnumElem);
            wordsOfNumberAndPartNames.push(threeDigitPartNumber);
            String threeDigitToWords = NumberToWordsParseHelper.threeDigitsToWords(threeDigitsNumber, gender, wordCaseEnumElem);
            wordsOfNumberAndPartNames.push(threeDigitToWords);
        }
        while (!wordsOfNumberAndPartNames.empty()){
            sb.append(wordsOfNumberAndPartNames.pop());
            sb.append(" ");
        }
        return sb.toString();
    }

    public static ArrayList<Integer> numberToThreeDigitsNumbers(long number){
        ArrayList<Integer> arr = new ArrayList<>();
        while (number>0){
            int lastDigits = (int)(number%1000);
            arr.add(lastDigits);
            number/=1000;
        }
        return arr;
    }
}