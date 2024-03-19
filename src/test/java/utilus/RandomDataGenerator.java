package utilus;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class RandomDataGenerator {
    public static String generateName() {
        int lenght = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedCustomerName = RandomStringUtils.random(lenght, useLetters, useNumbers);

        return generatedCustomerName;
    }

    public static String generateComment() {
        int lenght = 14;
        boolean useLetters = true;
        boolean useNumbers = true;
        String generateComment = RandomStringUtils.random(lenght, useLetters, useNumbers);

        return generateComment;
    }

    private static final int PHONE_NUMBER_LENGTH = 10;

    public static String generateRandomPhone() {
        Random random = new Random();
        String chars = "123456789- ()";
        StringBuffer generatedPhoneNumbers = new StringBuffer();

        for (int i = 0; i < PHONE_NUMBER_LENGTH; i++) {
            generatedPhoneNumbers.append(chars.charAt(random.nextInt(chars.length())));
        }
        return generatedPhoneNumbers.toString();

    }
    public static String generateValidApiKay() {
        int lenght = 7;
        boolean useLetters = false;
        boolean useNumbers = true;
        String generateValidApiKay = RandomStringUtils.random(lenght, useLetters, useNumbers);

        return generateValidApiKay;
    }

}
