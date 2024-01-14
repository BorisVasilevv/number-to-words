import enums.WordCaseEnum;
import java.util.ArrayList;
import java.util.Stack;

public class NumberToWords {
    private final static int constMaleGenderIndex = 0;
    private final static int constNeuterGenderIndex = 1;
    private final static int constFeminineGenderIndex = 2;

    public static String numToWords(long nSum, String gender, String wordCase) {
        ArrayList<Integer> threeDigitsNumbersArray = numberToThreeDigitsNumbers(nSum);
        Stack<String> wordsOfNumberAndPartNames = new Stack<>();
        WordCaseEnum wordCaseEnumElem = WordCaseEnum.getCaseByLetter(wordCase);
        StringBuilder sb = new StringBuilder();
        for (int i= 0; i<threeDigitsNumbersArray.size();i++) {
            Integer genderIndex;
            if(i==0){
                genderIndex= getGenderIndex(gender);
            } else if(i==1){
                genderIndex=constFeminineGenderIndex;
            } else {
                genderIndex = constMaleGenderIndex;
            }
            int threeDigitsNumber = threeDigitsNumbersArray.get(i);
            String threeDigitPartNumber = NumberBigPartNameGetHelper.getPartNameToThreeDigit(threeDigitsNumber , i ,wordCaseEnumElem);
            wordsOfNumberAndPartNames.push(threeDigitPartNumber);

            String threeDigitToWords = NumberToWordsParseHelper.threeDigitsToWords(threeDigitsNumber, genderIndex, wordCaseEnumElem);
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

    private static Integer getGenderIndex(String gender){
        return switch (gender) {
            case "М" -> constMaleGenderIndex;
            case "С" -> constNeuterGenderIndex;
            case "Ж" -> constFeminineGenderIndex;
            default -> throw new RuntimeException("Illegal gender argument. It was " + gender);
        };
    }
}