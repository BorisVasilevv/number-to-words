import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        System.out.println("Мужской род");
        System.out.print("И ");
        System.out.println(NumberToWords.numToWords(num, "М", "И"));
        System.out.print("Р ");
        System.out.println(NumberToWords.numToWords(num, "М", "Р"));
        System.out.print("Д ");
        System.out.println(NumberToWords.numToWords(num, "М", "Д"));
        System.out.print("В ");
        System.out.println(NumberToWords.numToWords(num, "М", "В"));
        System.out.print("Т ");
        System.out.println(NumberToWords.numToWords(num, "М", "Т"));
        System.out.print("П ");
        System.out.println(NumberToWords.numToWords(num, "М", "П"));

        System.out.println("Средний род");
        System.out.print("И ");
        System.out.println(NumberToWords.numToWords(num, "С", "И"));
        System.out.print("Р ");
        System.out.println(NumberToWords.numToWords(num, "С", "Р"));
        System.out.print("Д ");
        System.out.println(NumberToWords.numToWords(num, "С", "Д"));
        System.out.print("В ");
        System.out.println(NumberToWords.numToWords(num, "С", "В"));
        System.out.print("Т ");
        System.out.println(NumberToWords.numToWords(num, "С", "Т"));
        System.out.print("П ");
        System.out.println(NumberToWords.numToWords(num, "С", "П"));

        System.out.println("Женский род");
        System.out.print("И ");
        System.out.println(NumberToWords.numToWords(num, "Ж", "И"));
        System.out.print("Р ");
        System.out.println(NumberToWords.numToWords(num, "Ж", "Р"));
        System.out.print("Д ");
        System.out.println(NumberToWords.numToWords(num, "Ж", "Д"));
        System.out.print("В ");
        System.out.println(NumberToWords.numToWords(num, "Ж", "В"));
        System.out.print("Т ");
        System.out.println(NumberToWords.numToWords(num, "Ж", "Т"));
        System.out.print("П ");
        System.out.println(NumberToWords.numToWords(num, "Ж", "П"));
    }
}