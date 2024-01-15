import enums.WordCaseEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class NumberToWords {
    private final static int constMaleGenderIndex = 0;
    private final static int constNeuterGenderIndex = 1;
    private final static int constFeminineGenderIndex = 2;

    private final static HashMap<WordCaseEnum, String> zeroVariant = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "ноль");
        put(WordCaseEnum.GENITIVE, "ноля");
        put(WordCaseEnum.DATIVE, "нолю");
        put(WordCaseEnum.ACCUSATIVE, "ноль");
        put(WordCaseEnum.INSTRUMENTAL, "нолём");
        put(WordCaseEnum.PREPOSITIONAL, "ноле");
    }};

    public static String numToWords(long number, String gender, String wordCase) {
        if (number >= 1_000_000_000_000L) {
            throw new RuntimeException("number is to big or negative, " +
                    "method numToWords works with number from 0 to 999999999999 (from zero to trillion), but it was " + number);
        }

        WordCaseEnum wordCaseEnumElem = WordCaseEnum.getCaseByLetter(wordCase);
        StringBuilder sb = new StringBuilder();
        if (number == 0) {
            return zeroVariant.get(wordCaseEnumElem);
        }
        if (number < 0) {
            number = -number;
            sb.append("минус ");
        }

        ArrayList<Integer> threeDigitsNumbersArray = numberToThreeDigitsNumbers(number);
        Stack<String> wordsOfNumberAndPartNames = new Stack<>();
        for (int i = 0; i < threeDigitsNumbersArray.size(); i++) {
            Integer genderIndex;
            if (i == 0) {
                genderIndex = getGenderIndex(gender);
            } else if (i == 1) {
                genderIndex = constFeminineGenderIndex;
            } else {
                genderIndex = constMaleGenderIndex;
            }
            int threeDigitsNumber = threeDigitsNumbersArray.get(i);
            String threeDigitPartNumber = NumberBigPartNameGetHelper.getPartNameToThreeDigit(threeDigitsNumber, i, wordCaseEnumElem);
            wordsOfNumberAndPartNames.push(threeDigitPartNumber);

            String threeDigitToWords = NumberToWordsParseHelper.threeDigitsToWords(threeDigitsNumber, genderIndex, wordCaseEnumElem);
            wordsOfNumberAndPartNames.push(threeDigitToWords);
        }
        while (!wordsOfNumberAndPartNames.empty()) {
            sb.append(wordsOfNumberAndPartNames.pop());
            sb.append(" ");
        }
        return sb.toString();
    }

    public static ArrayList<Integer> numberToThreeDigitsNumbers(long number) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (number > 0) {
            int lastDigits = (int) (number % 1000);
            arr.add(lastDigits);
            number /= 1000;
        }
        return arr;
    }

    private static Integer getGenderIndex(String gender) {
        return switch (gender) {
            case "М" -> constMaleGenderIndex;
            case "С" -> constNeuterGenderIndex;
            case "Ж" -> constFeminineGenderIndex;
            default -> throw new RuntimeException("Illegal gender argument. It was " + gender);
        };
    }
}