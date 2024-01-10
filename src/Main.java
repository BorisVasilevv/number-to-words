import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            long num= sc.nextLong();
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
        }
    }
}