import java.util.HashMap;
import java.util.Map;

public class NumberToWordsParseHelper {
    private final static int maleGenderIndex = 0;
    private final static int neuterGenderIndex = 1;
    private final static int feminineGenderIndex = 2;

    private final static HashMap<Integer, String> unitsFirstPart = new HashMap<>(){{
        put(1,"од");
        put(2, "дв");
        put(3, "тр");
        put(4, "четыр");
        put(5, "пят");
        put(6, "шест");
        put(7, "сем");
        put(8, "восем");
        put(9, "девят");
    }};

    private final static HashMap<Integer, String> teensFirstPart = new HashMap<>(){{
        put(10, "десят");
        put(11, "одигадцат");
        put(12, "двенадцат");
        put(13, "тринадцат");
        put(14, "четырнадцат");
        put(15, "пятнадцат");
        put(16, "шестнадцат");
        put(17, "семнадцат");
        put(18, "восемнадцат");
        put(19, "девятнадцат");
    }};

    private final static HashMap<Integer, String> tensFirstPart = new HashMap<>(){{
        put(2, "двадцат");
        put(3, "тридцат");
        put(4, "сорок");
        put(5, "пят");
        put(6, "шест");
        put(7, "сем");
        put(8, "восем");
        put(9, "девявност");
    }};

    private final static HashMap<Integer, String> hundredsFirstPart = new HashMap<>(){{
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

    private final static HashMap<String, String[]> endingForOne =new HashMap<>(){{
        put("И", new String[]{"ин","но","на"});
        put("Р", new String[]{"ного","ного","ной"});
        put("Д", new String[]{"ному","ному","ной"});
        put("В", new String[]{"ин","но","ну"});
        put("Т", new String[]{"ним","ним","ной"});
        put("П", new String[]{"ном","ном","ной"});
    }};

    private final static HashMap<String, String[]> endingForTwo =new HashMap<>(){{
        put("И", new String[]{"a","а","е"});
        put("Р", new String[]{"ух","ух","ух"});
        put("Д", new String[]{"ум","ум","ум"});
        put("В", new String[]{"a","а","е"});
        put("Т", new String[]{"умя","умя","умя"});
        put("П", new String[]{"ух","ух","ух"});
    }};

    private final static HashMap<String, String> endingForThree =new HashMap<>(){{
        put("И", "и");
        put("Р", "ёх");
        put("Д", "ём");
        put("В", "и");
        put("Т", "емя");
        put("П", "ёх");
    }};

    private final static HashMap<String, String> endingForFour =new HashMap<>(){{
        put("И", "е");
        put("Р", "ёх");
        put("Д", "ём");
        put("В", "е");
        put("Т", "емя");
        put("П", "ёх");
    }};

    private final static HashMap<String, String> endingForFromFiveToTwentyAndThirty =new HashMap<>(){{
        put("И", "ь");
        put("Р", "и");
        put("Д", "и");
        put("В", "ь");
        put("Т", "ью");
        put("П", "и");
    }};

    private final static HashMap<String, String> endingForFourty =new HashMap<>(){{
        put("И", "");
        put("Р", "а");
        put("Д", "а");
        put("В", "");
        put("Т", "а");
        put("П", "а");
    }};

    //have some same things with endingForFromFiveToTwentyAndThirty
    private final static HashMap<String, String> endingForTensFromFiftyToEighty =new HashMap<>(){{
        put("И", "ьдесят");
        put("Р", "идесяти");
        put("Д", "идесяти");
        put("В", "ьдесят");
        put("Т", "ьюдесятью");
        put("П", "идесяти");
    }};

    private final static HashMap<String, String> endingForNinetyAndHundred =new HashMap<>(){{
        put("И", "о");
        put("Р", "а");
        put("Д", "а");
        put("В", "о");
        put("Т", "а");
        put("П", "а");
    }};

    private final static HashMap<String, String> endingForTwoHundreds =new HashMap<>(){{
        put("И", "ести");
        put("Р", "ухсот");
        put("Д", "умстам");
        put("В", "ести");
        put("Т", "умястами");
        put("П", "ухстах");
    }};

    private final static HashMap<String, String> endingForThreeHundreds =new HashMap<>(){{
        put("И", "иста");
        put("Р", "ёхсот");
        put("Д", "ёмстам");
        put("В", "иста");
        put("Т", "ёмястами");
        put("П", "ёхстах");
    }};

    private final static HashMap<String, String> endingForFourHundreds =new HashMap<>(){{
        put("И", "еста");
        put("Р", "ёхсот");
        put("Д", "ёмстам");
        put("В", "еста");
        put("Т", "ёмястами");
        put("П", "ёхстах");
    }};

    //have some same things with endingForFromFiveToTwentyAndThirty
    private final static HashMap<String, String> endingForFromFiveToNineHundreds =new HashMap<>(){{
        put("И", "ьсот");
        put("Р", "исот");
        put("Д", "истам");
        put("В", "ьсот");
        put("Т", "ьюстами");
        put("П", "истах");
    }};

    public static String ThreeDigitsToWords(Integer number, String gender, String wordCase){
        StringBuilder sb = new StringBuilder();
        int firstDigit = number/100;
        if (firstDigit!=0){
            sb.append(hundredsFirstPart.get(firstDigit));
            try {
                HashMap endings = getSuitableEndingMapToHundreds(firstDigit);
                sb.append(endings.get(wordCase));
                sb.append(" ");
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e.getMessage());
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }


        int lastTwoDigit = number%100;
        if (lastTwoDigit>=10 && lastTwoDigit<=19){
            sb.append(teensFirstPart.get(lastTwoDigit));
            sb.append(endingForFromFiveToTwentyAndThirty.get(wordCase));
        }
        else {
            int secondDigit=lastTwoDigit/10;
            int lastDigit = lastTwoDigit%10;
        }
        return sb.toString();
    }

    private static HashMap getSuitableEndingMapToHundreds(int digit) throws IllegalArgumentException {
        if (digit==1){
            return endingForNinetyAndHundred;
        } else if (digit==2) {
            return endingForTwoHundreds;
        } else if (digit==3) {
            return endingForThreeHundreds;
        } else if (digit==4) {
            return endingForFourHundreds;
        } else if (digit>=5 && digit<=9) {
            return endingForFromFiveToNineHundreds;
        } else{
            throw new IllegalArgumentException(String.format(
                    "Method getSuitableEndingMapToHundreds accept argument with only one digit, but was %d", digit));
        }
    }
}