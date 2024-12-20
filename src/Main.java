import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final String VALID_STR = "абвгдежзийклмнопрстуфхцчшщыюяАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЮЯ -";

    public static void main(String[] args) {
        String alfabet = "абвгд";
        for (int i = 0; i < alfabet.length(); i++) {
            System.out.println(alfabet.charAt(i) + " - " + (int)alfabet.charAt(i));
        }
        String text = "привет";
        for (int i = 0; i < text.length(); i++) {
            System.out.println((int)text.charAt(i));
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО (фамилия имя отчество):");
        String input = scanner.nextLine();

        // Регулярное выражение для проверки формата ФИО
        String regex = "^[А-ЯЁ][а-яёА-ЯЁ\\-]*\\s[А-ЯЁ][а-яёА-ЯЁ\\-]*\\s[А-ЯЁ][а-яёА-ЯЁ\\-]*$";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(input).matches()) {
                    String[] parts = input.split("\\s+");
                    System.out.println("Фамилия: " + parts[0]);
                    System.out.println("Имя: " + parts[1]);
                    System.out.println("Отчество: " + parts[2]);
        } else {
                    System.out.println("Введенная строка не является ФИО");
        }
        

        System.out.println("Введите ФИО:");
        String input2 = new Scanner(System.in).nextLine().trim();
        boolean isValid = true;
        int spaseCount = 0;

        for (int i = 0; i < input2.length(); i++) {
            if (!VALID_STR.contains(String.valueOf(input2.charAt(i)))) {
                System.out.println("строка не валидна!!!");
                isValid = false;
                break;
            }
            if (input2.charAt(i) == ' '){
                spaseCount++;
            }
        }
        if (isValid && spaseCount == 2){
            System.out.println("Имя: " + input2.substring(0, input2.indexOf(" ")).trim());
            System.out.println("Фамилия: " + input2.substring(input2.indexOf(" "), input2.lastIndexOf(" ")).trim());
            System.out.println("Отчество: " + input2.substring(input2.lastIndexOf(" ")).trim());
        }else{
            System.out.println("Введенная строка не является ФИО!");
        }
        scanner.close();
    }
}

