import enums.WordCaseEnum;

import java.util.ArrayList;
import java.util.Collections;

public class NumberToWords {

    public static String numToWords(long nSum, String gender, String wordCase) {
        ArrayList<Integer> threeDigitsNumbersArray = numberToThreeDigitsNumbers(nSum);
        ArrayList<String> threeDigitWordsArray = new ArrayList<>();
        WordCaseEnum wordCaseEnumElem = WordCaseEnum.getCaseByLetter(wordCase);
        StringBuilder sb = new StringBuilder();
        for (int i= 0; i<=threeDigitsNumbersArray.size();i++) {
            String str = NumberToWordsParseHelper.threeDigitsToWords(threeDigitsNumbersArray.get(i), gender, wordCaseEnumElem);

            threeDigitWordsArray.add(
                    NumberToWordsParseHelper.threeDigitsToWords(threeDigitsNumbersArray.get(i), gender, wordCaseEnumElem));

        }
        NumberBigPartNameHelper.appendPartNameToNumbers(threeDigitWordsArray, wordCaseEnumElem);
        Collections.reverse(threeDigitWordsArray);
//        StringBuilder sb = new StringBuilder();
//        for (String elem:threeDigitWordsArray) {
//            sb.append(elem);
//        }
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