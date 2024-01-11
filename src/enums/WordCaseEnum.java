package enums;

public enum WordCaseEnum {
    NOMINATIVE("И"),
    GENITIVE("Р"),
    DATIVE("Д"),
    ACCUSATIVE("В"),
    INSTRUMENTAL("Т"),
    PREPOSITIONAL("П");
    private final String russianLetter;
    WordCaseEnum(String russianLetter){
        this.russianLetter=russianLetter;
    }

    //public String getRussianLetter(){ return russianLetter;};

    public static WordCaseEnum getCaseByLetter(String russianLetter) throws IllegalArgumentException{
        for (WordCaseEnum wordCase: WordCaseEnum.values()) {
            if(wordCase.russianLetter.equals(russianLetter)) return wordCase;
        }
        throw new IllegalArgumentException("Illegal first russian letter of case");
    }
}
