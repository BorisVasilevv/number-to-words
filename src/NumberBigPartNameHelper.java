import enums.WordCaseEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NumberBigPartNameHelper {

    private NumberBigPartNameHelper() {}

    private static final String thousandName = "тысяч";
    private static final String millionName = "миллион";
    private static final String billionName = "миллиард";
    private static final HashMap <WordCaseEnum, String> endingsForThousandSingle = new HashMap<>(){{
        put(WordCaseEnum.NOMINATIVE, "а");
        put(WordCaseEnum.GENITIVE, "и");
        put(WordCaseEnum.DATIVE, "е");
        put(WordCaseEnum.ACCUSATIVE, "у");
        put(WordCaseEnum.INSTRUMENTAL, "ей");
        put(WordCaseEnum.PREPOSITIONAL, "е");
    }};

    private static final HashMap <WordCaseEnum, String> endingsForThousandPlural = new HashMap<>(){{
        put(WordCaseEnum.NOMINATIVE, "и");
        put(WordCaseEnum.GENITIVE, "");
        put(WordCaseEnum.DATIVE, "ам");
        put(WordCaseEnum.ACCUSATIVE, "и");
        put(WordCaseEnum.INSTRUMENTAL, "ами");
        put(WordCaseEnum.PREPOSITIONAL, "ах");
    }};

    private static final HashMap <WordCaseEnum, String> endingsForMiAndBillionSingle= new HashMap<>(){{
        put(WordCaseEnum.NOMINATIVE, "");
        put(WordCaseEnum.GENITIVE, "а");
        put(WordCaseEnum.DATIVE, "у");
        put(WordCaseEnum.ACCUSATIVE, "");
        put(WordCaseEnum.INSTRUMENTAL, "ом");
        put(WordCaseEnum.PREPOSITIONAL, "е");
    }};

    private static final HashMap <WordCaseEnum, String> endingsForMiAndBillionPlural= new HashMap<>(){{
        put(WordCaseEnum.NOMINATIVE, "ы");
        put(WordCaseEnum.GENITIVE, "ов");
        put(WordCaseEnum.DATIVE, "ам");
        put(WordCaseEnum.ACCUSATIVE, "");
        put(WordCaseEnum.INSTRUMENTAL, "амм");
        put(WordCaseEnum.PREPOSITIONAL, "ах");
    }};

    private static final NumberBigPartName[] numberNameBigPart= new NumberBigPartName[]{
            new NumberBigPartName(thousandName, endingsForThousandSingle, endingsForThousandPlural),
            new NumberBigPartName(millionName, endingsForMiAndBillionSingle, endingsForMiAndBillionPlural),
            new NumberBigPartName(billionName, endingsForMiAndBillionSingle, endingsForMiAndBillionPlural)
    };

    public static void appendPartNameToNumbers(ArrayList<String> numbers, WordCaseEnum wordCase){
        if (numbers.size()<=1) return;
        for(int i =1; i<numbers.size(); i++){
            String elem = numbers.get(i);
            String lastPart = Arrays.stream(elem.split(" ")).reduce((first, second) -> second).orElse(null);
            boolean isSingle = lastPart != null && lastPart.contains("од") && !lastPart.contains("одигадцат");
            String elemBigPartName = numberNameBigPart[i-1].getFullName(wordCase, isSingle);
            elem = String.format("%s%s ", elem, elemBigPartName);
            numbers.set(i, elem);
        }
    }

}
