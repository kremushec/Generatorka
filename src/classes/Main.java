package classes;
import java.util.Scanner;
/**
 * Главный класс приложения. Содержит метод для генерации пароля с помощью заданных параметров.
 */
public class Main {
    /**
     * Метод для запуска приложения.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = InputValidator.getPasswordLength(scanner);
        boolean hasUpper = InputValidator.isHasUpper(scanner);
        boolean hasLower = InputValidator.isHasLower(scanner);
        boolean[] languages = new boolean[PasswordGenerator.LANGUAGES.length];
        if (hasUpper || hasLower) {
            languages = InputValidator.getLanguages(scanner);
        }
        boolean hasDigits = InputValidator.isHasDigits(scanner);
        boolean hasSpecialChars = InputValidator.isHasSpecialChars(scanner);
        String additionalDigits = "";
        if (hasDigits) {
            additionalDigits = InputValidator.getAdditionalDigits(scanner);
        }

        long startTime = System.currentTimeMillis();
        PasswordGenerator.generatePassword(length, hasUpper, hasLower, languages, hasDigits, hasSpecialChars, additionalDigits);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Время генерации: " + elapsedTime + " мс");
        scanner.close();
    }


}