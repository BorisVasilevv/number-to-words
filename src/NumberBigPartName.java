import enums.WordCaseEnum;

import java.util.HashMap;

public class NumberBigPartName {
    public NumberBigPartName(String name,
                             HashMap<WordCaseEnum, String> endingsSingle,
                             HashMap<WordCaseEnum, String> endingsTwoToFour,
                             HashMap<WordCaseEnum, String> endingsFiveToNineAndTeens) {
        this.name = name;
        this.endingsOne = endingsSingle;
        this.endingsTwoToFour = endingsTwoToFour;
        this.endingsFiveToNineAndTeens = endingsFiveToNineAndTeens;
    }

    private final String name;
    private final HashMap<WordCaseEnum, String> endingsOne;
    private final HashMap<WordCaseEnum, String> endingsTwoToFour;
    private final HashMap<WordCaseEnum, String> endingsFiveToNineAndTeens;

    public String getFullName(WordCaseEnum wordCase, int numberLessTwenty ) throws IllegalArgumentException {
        HashMap<WordCaseEnum, String> endings;
        if( numberLessTwenty>=20){
            numberLessTwenty%=10;
        }
        if( numberLessTwenty ==0){
            return name;
        }
        if (numberLessTwenty ==1){
            endings=endingsOne;
        } else if (numberLessTwenty >=2 && numberLessTwenty<=4){
            endings=endingsTwoToFour;
        } else if (numberLessTwenty>=5){
            endings=endingsFiveToNineAndTeens;
        } else {
            throw new RuntimeException("Error in method getFullName in class NumberBigPartName argument was: "+ numberLessTwenty);
        }
        return String.format("%s%s", name,  endings.get(wordCase));

    }
}
