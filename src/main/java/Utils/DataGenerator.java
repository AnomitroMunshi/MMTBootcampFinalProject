package Utils;

public class DataGenerator {
    public static int generateRandomNumber(int minRange, int maxRange) {
        return (int) ((Math.random() * (maxRange - minRange)) + minRange);
    }

    public static String generateRandomString(boolean containsCharacters, boolean containsNumbers,
                                              boolean containsSpecialChar) {
        return null;

    }
}
