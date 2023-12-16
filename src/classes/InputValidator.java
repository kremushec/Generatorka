package classes;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Класс, содержащий методы для валидации ввода.
 */
public class InputValidator {
    /**
     * Метод для получения длины пароля от пользователя.
     *
     * @param scanner объект Scanner для чтения ввода пользователя.
     * @return длина пароля, введенная пользователем.
     */
    public static int getPasswordLength(Scanner scanner) {
        int length = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Введите длину пароля: ");
                length = Integer.parseInt(scanner.nextLine());
                if (length <= 0) {
                    System.out.println("Ошибка: введенное значение должно быть положительным числом. ");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введенное значение не является целым числом. ");
            }
        }
        return length;
    }
    /**
     * Проверяет, есть ли верхний регистр в пароле.
     *
     * @param scanner объект класса Scanner для чтения ввода с консоли
     * @return true, если в пароле есть верхний регистр, иначе false
     */
    public static boolean isHasUpper(Scanner scanner) {
        boolean hasUpper = false;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Верхний регистр? (true/false): ");
                hasUpper = scanner.nextBoolean();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода. Повторите ввод.");
                scanner.nextLine();
            }
        }
        return hasUpper;
    }
    /**
     * Проверяет, есть ли верхний регистр в пароле.
     *
     * @param scanner объект класса Scanner для чтения ввода с консоли
     * @return true, если в пароле есть верхний регистр, иначе false
     */
    public static boolean isHasLower(Scanner scanner) {
        boolean hasLower = false;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Нижний регистр? (true/false): ");
                hasLower = scanner.nextBoolean();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода. Повторите ввод.");
                scanner.nextLine();
            }
        }
        return hasLower;
    }
    /**
     * Получает информацию о выбранных языках.
     *
     * @param scanner объект класса Scanner для чтения ввода с консоли
     * @return массив boolean, где true означает выбранный язык, false - не выбранный
     */
    public static boolean[] getLanguages(Scanner scanner) {
        boolean[] languages = new boolean[PasswordGenerator.LANGUAGES.length];

        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Введите количество использованных языков (от 1 до 2): ");
                int languageCount = Integer.parseInt(scanner.next());
                if (languageCount < 1 || languageCount > 2) {
                    throw new IllegalArgumentException("Некорректное количество языков.");
                }

                for (int i = 0; i < languageCount; i++) {
                    int languageNumber = i + 1;
                    System.out.print("Введите язык " + languageNumber + " (ru, en): ");
                    String language = scanner.next();

                    switch (language) {
                        case "ru":
                            languages[0] = true;
                            break;
                        case "en":
                            languages[1] = true;
                            break;
                        default:
                            System.out.println("Выбран неверный язык");
                            i--;
                            break;
                    }
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введенное значение не является числом.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        return languages;
    }
    /**
     * Проверяет, есть ли цифры в пароле.
     *
     * @param scanner объект класса Scanner для чтения ввода с консоли
     * @return true, если в пароле есть цифры, иначе false
     */
    public static boolean isHasDigits(Scanner scanner) {
        boolean hasDigits = false;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Использовать цифры? (true/false): ");
                hasDigits = scanner.nextBoolean();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода. Повторите ввод.");
                scanner.nextLine();
            }
        }
        return hasDigits;
    }
    /**
     * Проверяет, есть ли специальные символы в пароле.
     *
     * @param scanner объект класса Scanner для чтения ввода с консоли
     * @return true, если в пароле есть специальные символы, иначе false
     */
    public static boolean isHasSpecialChars(Scanner scanner) {
        boolean hasSpecialChars = false;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Специальные символы? (true/false): ");
                hasSpecialChars = scanner.nextBoolean();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Неверный формат ввода. Повторите ввод.");
                scanner.nextLine();
            }
        }
        return hasSpecialChars;
    }
    /**
     * Получает дополнительные цифры для пароля.
     *
     * @param scanner объект класса Scanner для чтения ввода с консоли
     * @return строка, содержащая дополнительные цифры для пароля
     */
    public static String getAdditionalDigits(Scanner scanner) {
        System.out.print("Введите цифры для пароля/empty: ");
        String additionalDigits = "";
        boolean isValid = false;

        while (!isValid) {
            try {
                additionalDigits = scanner.next();
                if (!additionalDigits.equals("empty")) {
                    for (int i = 0; i < additionalDigits.length(); i++) {
                        if (!Character.isDigit(additionalDigits.charAt(i))) {
                            throw new IllegalArgumentException("Введите цифры без пробелов.");
                        }
                    }
                }
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.print("Повторите ввод: ");
            }
        }
        return additionalDigits;
    }
}