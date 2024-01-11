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

    private static final HashMap <WordCaseEnum, String> endingsForThousandTwoToFour = new HashMap<>(){{
        put(WordCaseEnum.NOMINATIVE, "и");
        put(WordCaseEnum.GENITIVE, "");
        put(WordCaseEnum.DATIVE, "ам");
        put(WordCaseEnum.ACCUSATIVE, "и");
        put(WordCaseEnum.INSTRUMENTAL, "ами");
        put(WordCaseEnum.PREPOSITIONAL, "ах");
    }};

    private static final HashMap <WordCaseEnum, String> endingsForThousandFiveToNine = new HashMap<>(){{
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

    private static final HashMap <WordCaseEnum, String> endingsForMiAndBillionTwoToFour = new HashMap<>(){{
        put(WordCaseEnum.NOMINATIVE, "а");
        put(WordCaseEnum.GENITIVE, "ов");
        put(WordCaseEnum.DATIVE, "ам");
        put(WordCaseEnum.ACCUSATIVE, "а");
        put(WordCaseEnum.INSTRUMENTAL, "амм");
        put(WordCaseEnum.PREPOSITIONAL, "ах");
    }};

    private static final HashMap <WordCaseEnum, String> endingsForMiAndBillionFiveToNine = new HashMap<>(){{
        put(WordCaseEnum.NOMINATIVE, "ов");
        put(WordCaseEnum.GENITIVE, "ов");
        put(WordCaseEnum.DATIVE, "ам");
        put(WordCaseEnum.ACCUSATIVE, "ов");
        put(WordCaseEnum.INSTRUMENTAL, "амм");
        put(WordCaseEnum.PREPOSITIONAL, "ах");
    }};

    private static final NumberBigPartName[] numberNameBigPart= new NumberBigPartName[]{
            new NumberBigPartName(thousandName, endingsForThousandSingle,
                    endingsForThousandTwoToFour,endingsForThousandFiveToNine),
            new NumberBigPartName(millionName, endingsForMiAndBillionSingle,
                    endingsForMiAndBillionTwoToFour,endingsForMiAndBillionFiveToNine),
            new NumberBigPartName(billionName, endingsForMiAndBillionSingle,
                    endingsForMiAndBillionTwoToFour, endingsForMiAndBillionFiveToNine)
    };

    public static String getPartNameToThreeDigit(int threeDigitNumber, int place, WordCaseEnum wordCase){
        if (place<1) return "";
        int lastTwoDigit = threeDigitNumber%100;
        return numberNameBigPart[place-1].getFullName(wordCase, lastTwoDigit);

    }

}
