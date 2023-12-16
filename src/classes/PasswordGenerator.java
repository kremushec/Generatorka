package classes;
import java.util.Random;

/**
 * Генератор паролей.
 */
public class PasswordGenerator {
    /**
     * Строка с английскими строчными символами.
     */
    private static final String ENGLISH_LOWER_CHARS = "abcdefghijklmnopqrstuvwxyz";
    /**
     * Строка с английскими прописными символами.
     */
    private static final String ENGLISH_UPPER_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * Строка с цифрами.
     */
    private static final String DIGITS = "0123456789";
    /**
     * Строка со специальными символами.
     */
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]|,./?<>";
    /**
     * Строка с русскими строчными символами.
     */
    private static final String RUSSIAN_LOWER_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    /**
     * Строка с русскими прописными символами.
     */
    private static final String RUSSIAN_UPPER_CHARS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    /**
     * Массив доступных языков.
     */
    public static final String[] LANGUAGES = { "ru", "en" };
    /**
     * Генерирует пароль заданной длины.
     *
     * @param length             длина пароля
     * @param hasUpper           наличие прописных символов
     * @param hasLower           наличие строчных символов
     * @param languages          использование языков
     * @param hasDigits          наличие цифр
     * @param hasSpecialChars    наличие специальных символов
     * @param additionalDigits   дополнительные цифры
     */
    public static void generatePassword(int length, boolean hasUpper, boolean hasLower, boolean[] languages,
                                        boolean hasDigits, boolean hasSpecialChars, String additionalDigits) {
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        String allowedChars = getAllowedChars(languages, hasUpper, hasLower, hasDigits, hasSpecialChars, additionalDigits);

        try {
            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(allowedChars.length());
                password.append(allowedChars.charAt(randomIndex));
            }
            System.out.println(password);
        }catch (IllegalArgumentException e){
            System.out.println("Вы не выбрали ни одного значения.");
        }
    }

    /**
     * Возвращает строку с допустимыми символами для генерации пароля.**
     * @param languages           использование языков
     * @param hasUpper            наличие прописных символов
     * @param hasLower            наличие строчных символов
     * @param hasDigits           наличие цифр
     * @param hasSpecialChars     наличие специальных символов
     * @param additionalDigits    дополнительные цифры
     * @return                     строка с допустимыми символами
     */
    public static String getAllowedChars(boolean[] languages, boolean hasUpper, boolean hasLower, boolean hasDigits,
                                         boolean hasSpecialChars, String additionalDigits) {
        StringBuilder allowedCharsBuilder = new StringBuilder();

        for (int i = 0; i < languages.length; ++i) {
            if (languages[i]) {
                switch (LANGUAGES[i]) {
                    case "ru":
                        if (hasUpper && hasLower) {
                            allowedCharsBuilder.append(RUSSIAN_LOWER_CHARS);
                            allowedCharsBuilder.append(RUSSIAN_UPPER_CHARS);
                        } else if (hasUpper) {
                            allowedCharsBuilder.append(RUSSIAN_UPPER_CHARS);
                        } else if (hasLower) {
                            allowedCharsBuilder.append(RUSSIAN_LOWER_CHARS);
                        }
                        break;
                    case "en":
                        if (hasUpper && hasLower) {
                            allowedCharsBuilder.append(ENGLISH_LOWER_CHARS);
                            allowedCharsBuilder.append(ENGLISH_UPPER_CHARS);
                        } else if (hasUpper) {
                            allowedCharsBuilder.append(ENGLISH_UPPER_CHARS);
                        } else if (hasLower) {
                            allowedCharsBuilder.append(ENGLISH_LOWER_CHARS);
                        }
                }
            }
        }

        if (hasDigits) {
            if (!additionalDigits.equals("empty")) {
                allowedCharsBuilder.append(additionalDigits);
            } else {
                allowedCharsBuilder.append(DIGITS);
            }
        }
        if (hasSpecialChars) {
            allowedCharsBuilder.append(SPECIAL_CHARS);
        }
        return allowedCharsBuilder.toString();
    }
}