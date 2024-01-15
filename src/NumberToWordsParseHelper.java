import enums.NumberPartEnum;
import enums.WordCaseEnum;

import java.lang.reflect.Method;
import java.util.HashMap;

public class NumberToWordsParseHelper {

    private final static HashMap<Integer, String> unitsFirstPart = new HashMap<>() {{
        put(1, "од");
        put(2, "дв");
        put(3, "тр");
        put(4, "четыр");
        put(5, "пят");
        put(6, "шест");
        put(7, "сем");
        put(8, "восем");
        put(9, "девят");
    }};

    private final static HashMap<Integer, String> teensFirstPart = new HashMap<>() {{
        put(10, "десят");
        put(11, "одиннадцат");
        put(12, "двенадцат");
        put(13, "тринадцат");
        put(14, "четырнадцат");
        put(15, "пятнадцат");
        put(16, "шестнадцат");
        put(17, "семнадцат");
        put(18, "восемнадцат");
        put(19, "девятнадцат");
    }};

    private final static HashMap<Integer, String> tensFirstPart = new HashMap<>() {{
        put(2, "двадцат");
        put(3, "тридцат");
        put(4, "сорок");
        put(5, "пят");
        put(6, "шест");
        put(7, "сем");
        put(8, "восем");
        put(9, "девявност");
    }};

    private final static HashMap<Integer, String> hundredsFirstPart = new HashMap<>() {{
        put(1, "ст");
        put(2, "дв");
        put(3, "тр");
        put(4, "четыр");
        put(5, "пят");
        put(6, "шест");
        put(7, "сем");
        put(8, "восем");
        put(9, "девят");
    }};

    private final static HashMap<WordCaseEnum, String[]> endingForOne = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, new String[]{"ин", "но", "на"});
        put(WordCaseEnum.GENITIVE, new String[]{"ного", "ного", "ной"});
        put(WordCaseEnum.DATIVE, new String[]{"ному", "ному", "ной"});
        put(WordCaseEnum.ACCUSATIVE, new String[]{"ин", "но", "ну"});
        put(WordCaseEnum.INSTRUMENTAL, new String[]{"ним", "ним", "ной"});
        put(WordCaseEnum.PREPOSITIONAL, new String[]{"ном", "ном", "ной"});
    }};

    private final static HashMap<WordCaseEnum, String[]> endingForTwo = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, new String[]{"a", "а", "е"});
        put(WordCaseEnum.GENITIVE, new String[]{"ух", "ух", "ух"});
        put(WordCaseEnum.DATIVE, new String[]{"ум", "ум", "ум"});
        put(WordCaseEnum.ACCUSATIVE, new String[]{"a", "а", "е"});
        put(WordCaseEnum.INSTRUMENTAL, new String[]{"умя", "умя", "умя"});
        put(WordCaseEnum.PREPOSITIONAL, new String[]{"ух", "ух", "ух"});
    }};

    private final static HashMap<WordCaseEnum, String> endingForThree = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "и");
        put(WordCaseEnum.GENITIVE, "ёх");
        put(WordCaseEnum.DATIVE, "ём");
        put(WordCaseEnum.ACCUSATIVE, "и");
        put(WordCaseEnum.INSTRUMENTAL, "емя");
        put(WordCaseEnum.PREPOSITIONAL, "ёх");
    }};

    private final static HashMap<WordCaseEnum, String> endingForFour = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "е");
        put(WordCaseEnum.GENITIVE, "ёх");
        put(WordCaseEnum.DATIVE, "ём");
        put(WordCaseEnum.ACCUSATIVE, "е");
        put(WordCaseEnum.INSTRUMENTAL, "емя");
        put(WordCaseEnum.PREPOSITIONAL, "ёх");
    }};

    private final static HashMap<WordCaseEnum, String> endingForFromFiveToTwentyAndThirty = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "ь");
        put(WordCaseEnum.GENITIVE, "и");
        put(WordCaseEnum.DATIVE, "и");
        put(WordCaseEnum.ACCUSATIVE, "ь");
        put(WordCaseEnum.INSTRUMENTAL, "ью");
        put(WordCaseEnum.PREPOSITIONAL, "и");
    }};

    private final static HashMap<WordCaseEnum, String> endingForFourty = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "");
        put(WordCaseEnum.GENITIVE, "а");
        put(WordCaseEnum.DATIVE, "а");
        put(WordCaseEnum.ACCUSATIVE, "");
        put(WordCaseEnum.INSTRUMENTAL, "а");
        put(WordCaseEnum.PREPOSITIONAL, "а");
    }};

    //have some same things with endingForFromFiveToTwentyAndThirty
    private final static HashMap<WordCaseEnum, String> endingForTensFromFiftyToEighty = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "ьдесят");
        put(WordCaseEnum.GENITIVE, "идесяти");
        put(WordCaseEnum.DATIVE, "идесяти");
        put(WordCaseEnum.ACCUSATIVE, "ьдесят");
        put(WordCaseEnum.INSTRUMENTAL, "ьюдесятью");
        put(WordCaseEnum.PREPOSITIONAL, "идесяти");
    }};

    private final static HashMap<WordCaseEnum, String> endingForNinetyAndHundred = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "о");
        put(WordCaseEnum.GENITIVE, "а");
        put(WordCaseEnum.DATIVE, "а");
        put(WordCaseEnum.ACCUSATIVE, "о");
        put(WordCaseEnum.INSTRUMENTAL, "а");
        put(WordCaseEnum.PREPOSITIONAL, "а");
    }};

    private final static HashMap<WordCaseEnum, String> endingForTwoHundreds = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "ести");
        put(WordCaseEnum.GENITIVE, "ухсот");
        put(WordCaseEnum.DATIVE, "умстам");
        put(WordCaseEnum.ACCUSATIVE, "ести");
        put(WordCaseEnum.INSTRUMENTAL, "умястами");
        put(WordCaseEnum.PREPOSITIONAL, "ухстах");
    }};

    private final static HashMap<WordCaseEnum, String> endingForThreeHundreds = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "иста");
        put(WordCaseEnum.GENITIVE, "ёхсот");
        put(WordCaseEnum.DATIVE, "ёмстам");
        put(WordCaseEnum.ACCUSATIVE, "иста");
        put(WordCaseEnum.INSTRUMENTAL, "ёмястами");
        put(WordCaseEnum.PREPOSITIONAL, "ёхстах");
    }};

    private final static HashMap<WordCaseEnum, String> endingForFourHundreds = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "еста");
        put(WordCaseEnum.GENITIVE, "ёхсот");
        put(WordCaseEnum.DATIVE, "ёмстам");
        put(WordCaseEnum.ACCUSATIVE, "еста");
        put(WordCaseEnum.INSTRUMENTAL, "ёмястами");
        put(WordCaseEnum.PREPOSITIONAL, "ёхстах");
    }};

    //have some same things with endingForFromFiveToTwentyAndThirty
    private final static HashMap<WordCaseEnum, String> endingForFromFiveToNineHundreds = new HashMap<>() {{
        put(WordCaseEnum.NOMINATIVE, "ьсот");
        put(WordCaseEnum.GENITIVE, "исот");
        put(WordCaseEnum.DATIVE, "истам");
        put(WordCaseEnum.ACCUSATIVE, "ьсот");
        put(WordCaseEnum.INSTRUMENTAL, "ьюстами");
        put(WordCaseEnum.PREPOSITIONAL, "истах");
    }};

    private final static HashMap<NumberPartEnum, Method> methodWithEndingsByNumberPart =
            new HashMap<>() {{
                try {
                    put(NumberPartEnum.UNITS, NumberToWordsParseHelper.class.getDeclaredMethod(
                            "getSuitableEndingMapToUnits", int.class));
                    put(NumberPartEnum.TEENS, NumberToWordsParseHelper.class.getDeclaredMethod(
                            "getSuitableEndingMapToTeens", int.class));
                    put(NumberPartEnum.TENS, NumberToWordsParseHelper.class.getDeclaredMethod(
                            "getSuitableEndingMapToTens", int.class));
                    put(NumberPartEnum.HUNDREDS, NumberToWordsParseHelper.class.getDeclaredMethod(
                            "getSuitableEndingMapToHundreds", int.class));
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }};


    public static String threeDigitsToWords(Integer number, Integer genderIndex, WordCaseEnum wordCase) {
        StringBuilder sb = new StringBuilder();
        int firstDigit = number / 100;
        sb.append(parsePartOfNumberToWord(firstDigit, NumberPartEnum.HUNDREDS, genderIndex, wordCase));

        int lastTwoDigit = number % 100;
        if (firstDigit != 0 && lastTwoDigit != 0) {
            sb.append(" ");
        }

        if (lastTwoDigit >= 10 && lastTwoDigit <= 19) {
            sb.append(parsePartOfNumberToWord(lastTwoDigit, NumberPartEnum.TEENS, genderIndex, wordCase));
        } else {
            int middleDigit = lastTwoDigit / 10;
            sb.append(parsePartOfNumberToWord(middleDigit, NumberPartEnum.TENS, genderIndex, wordCase));
            if (middleDigit != 0) {
                sb.append(" ");
            }
            int lastDigit = lastTwoDigit % 10;
            sb.append(parsePartOfNumberToWord(lastDigit, NumberPartEnum.UNITS, genderIndex, wordCase));
        }
        return sb.toString();
    }

    private static String parsePartOfNumberToWord(int numberLessTwenty, NumberPartEnum numberPart,
                                                  Integer genderIndex, WordCaseEnum wordCase) {
        if (numberLessTwenty == 0) return "";
        StringBuilder sb = new StringBuilder();
        try {
            HashMap<Integer, String> wordBeginnings = getSuitableBeginnings(numberPart);
            Method getEnding = methodWithEndingsByNumberPart.get(numberPart);
            HashMap wordEndings = (HashMap) getEnding.invoke(null, numberLessTwenty);
            sb.append(wordBeginnings.get(numberLessTwenty));
            if (numberPart == NumberPartEnum.UNITS && numberLessTwenty >= 1 && numberLessTwenty <= 2) {
                String[] endingArrayByGender = (String[]) wordEndings.get(wordCase);
                sb.append(endingArrayByGender[genderIndex]);
            } else {
                String ending = (String) wordEndings.get(wordCase);
                sb.append(ending);
            }

        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private static HashMap<Integer, String> getSuitableBeginnings(NumberPartEnum numberPart) {
        return switch (numberPart) {
            case UNITS -> unitsFirstPart;
            case TENS -> tensFirstPart;
            case TEENS -> teensFirstPart;
            case HUNDREDS -> hundredsFirstPart;
        };
    }

    private static HashMap<WordCaseEnum, String> getSuitableEndingMapToHundreds(int digit) throws IllegalArgumentException {
        if (digit == 1) {
            return endingForNinetyAndHundred;
        } else if (digit == 2) {
            return endingForTwoHundreds;
        } else if (digit == 3) {
            return endingForThreeHundreds;
        } else if (digit == 4) {
            return endingForFourHundreds;
        } else if (digit >= 5 && digit <= 9) {
            return endingForFromFiveToNineHundreds;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Method getSuitableEndingMapToHundreds accept argument with only one not zero digit, but it was %d", digit));
        }
    }

    private static HashMap<WordCaseEnum, String> getSuitableEndingMapToTens(int digit) throws IllegalArgumentException {
        if (digit == 2 || digit == 3) {
            return endingForFromFiveToTwentyAndThirty;
        } else if (digit == 4) {
            return endingForFourty;
        } else if (digit >= 5 && digit <= 8) {
            return endingForTensFromFiftyToEighty;
        } else if (digit == 9) {
            return endingForNinetyAndHundred;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Method getSuitableEndingMapToTens accept argument with only one digit, " +
                            "not zero and one, because it's another case, but argument was %d", digit));
        }
    }

    private static HashMap<WordCaseEnum, String> getSuitableEndingMapToTeens(int digit) {
        return endingForFromFiveToTwentyAndThirty;
    }

    private static HashMap getSuitableEndingMapToUnits(int digit) {
        if (digit == 1) {
            return endingForOne;
        } else if (digit == 2) {
            return endingForTwo;
        } else if (digit == 3) {
            return endingForThree;
        } else if (digit == 4) {
            return endingForFour;
        } else if (digit >= 5 && digit <= 9) {
            return endingForFromFiveToTwentyAndThirty;
        } else {
            throw new IllegalArgumentException(String.format(
                    "Method getSuitableEndingMapToUnits accept argument with only one digit, " +
                            "not zero, but argument was %d", digit));
        }
    }
}
