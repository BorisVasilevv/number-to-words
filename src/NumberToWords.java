import java.util.ArrayList;
import java.util.HashMap;

public class NumberToWords {


    public static String numToWords(int nSum, String gender, String wordCase){
        String genderAndCase = gender + wordCase;
        switch (genderAndCase){
            case "М":
                return "M";
                //break;
            case "С":
                return "С";
                //break;
            case "Т":
                return "Т";
                //break;

            default:
                return "Ошибка, введённый пол или падеж неверен";
        }

        //return "";
    }

    private static final HashMap<String, ArrayList<String>> cases = new HashMap<>(){{
        put("И", new ArrayList<>(){
            {
                add("");
                add("");
                add("");
            }
        });


        put("Р", new ArrayList<>(){
            {
                add("");
                add("");
                add("");
            }
        });

        put("Д", new ArrayList<>(){
            {
                add("");
                add("");
                add("");
            }
        });

        put("В", new ArrayList<>(){
            {
                add("");
                add("");
                add("");
            }
        });

        put("Т", new ArrayList<>(){
            {
                add("");
                add("");
                add("");
            }
        });


        put("П", new ArrayList<>(){
            {
                add("");
                add("");
                add("");
            }
        });


    }};

}
