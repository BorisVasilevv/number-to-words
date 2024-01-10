import enums.WordCaseEnum;

import java.util.HashMap;

public class NumberBigPartName {
    public NumberBigPartName(String name, HashMap<WordCaseEnum, String> endingsSingle, HashMap<WordCaseEnum, String> endingsPlural) {
        this.name = name;
        this.endingsSingle = endingsSingle;
        this.endingsPlural = endingsPlural;
    }

    private String name;
    private HashMap<WordCaseEnum, String> endingsSingle;
    private HashMap<WordCaseEnum, String> endingsPlural;

    public String getFullName(WordCaseEnum wordCase, boolean isSingle) {
        return String.format("%s%s", name ,  isSingle
                                               ?endingsSingle.get(wordCase)
                                               :endingsPlural.get(wordCase));
    }
}
