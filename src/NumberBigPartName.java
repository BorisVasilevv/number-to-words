import enums.WordCaseEnum;

import java.util.HashMap;

public class NumberBigPartName {
    public NumberBigPartName(String name,
                             HashMap<WordCaseEnum, String> endingsSingle,
                             HashMap<WordCaseEnum, String> endingsTwoToFour,
                             HashMap<WordCaseEnum, String> endingsFiveToNine) {
        this.name = name;
        this.endingsOne = endingsSingle;
        this.endingsTwoToFour = endingsTwoToFour;
        this.endingsFiveToNine = endingsFiveToNine;
    }

    private String name;
    private HashMap<WordCaseEnum, String> endingsOne;
    private HashMap<WordCaseEnum, String> endingsTwoToFour;
    private HashMap<WordCaseEnum, String> endingsFiveToNine;

    public String getFullName(WordCaseEnum wordCase, boolean isSingle) {
        return String.format("%s%s", name ,  isSingle
                                               ? endingsOne.get(wordCase)
                                               : endingsTwoToFour.get(wordCase));
    }
}
