package Level1;
import java.util.Scanner;
import java.util.Random;
public class Task4 {
        private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
        private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String NUMBERS = "0123456789";
        private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=";

        public static String generatePassword(int length, boolean useNumbers, boolean useLowercase,
                                              boolean useUppercase, boolean useSpecialChars) {
            StringBuilder password = new StringBuilder();
            String chars = "";
            if (useNumbers) {
                chars += NUMBERS;
            }
            if (useLowercase) {
                chars += LOWERCASE_LETTERS;
            }
            if (useUppercase) {
                chars += UPPERCASE_LETTERS;
            }
            if (useSpecialChars) {
                chars += SPECIAL_CHARACTERS;
            }

            Random rand = new Random();
            for (int i = 0; i < length; i++) {
                int randIndex = rand.nextInt(chars.length());
                password.append(chars.charAt(randIndex));
            }
            return password.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Random Password Generator!");
            System.out.print("Enter the desired length of the password: ");
            int length = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Include numbers? (yes/no): ");
            boolean useNumbers = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Include lowercase letters? (yes/no): ");
            boolean useLowercase = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Include uppercase letters? (yes/no): ");
            boolean useUppercase = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Include special characters? (yes/no): ");
            boolean useSpecialChars = scanner.nextLine().equalsIgnoreCase("yes");


            String password = generatePassword(length, useNumbers, useLowercase, useUppercase, useSpecialChars);


            System.out.println("Your random password is: " + password);


        }
    }


