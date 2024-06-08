package Level2;

import java.util.Scanner;

public class Task2 {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Password Strength Checker!");
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();

            checkPasswordStrength(password);

            scanner.close();
        }

        private static void checkPasswordStrength(String password) {
            int length = password.length();
            boolean hasLower = false;
            boolean hasUpper = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for (char c : password.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    hasLower = true;
                } else if (Character.isUpperCase(c)) {
                    hasUpper = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (isSpecialCharacter(c)) {
                    hasSpecial = true;
                }
            }

            System.out.println("Password Analysis:");
            System.out.println("Length: " + length);
            System.out.println("Contains lowercase letters: " + (hasLower ? "Yes" : "No"));
            System.out.println("Contains uppercase letters: " + (hasUpper ? "Yes" : "No"));
            System.out.println("Contains numbers: " + (hasDigit ? "Yes" : "No"));
            System.out.println("Contains special characters: " + (hasSpecial ? "Yes" : "No"));

            if (length >= 8 && hasLower && hasUpper && hasDigit && hasSpecial) {
                System.out.println("Password strength: Strong");
            } else if (length >= 6 && ((hasLower && hasUpper) || (hasLower && hasDigit) || (hasUpper && hasDigit))) {
                System.out.println("Password strength: Medium");
            } else {
                System.out.println("Password strength: Weak");
            }
        }

        private static boolean isSpecialCharacter(char c) {
            return "!@#$%^&*()-_+=<>?/{}~|".indexOf(c) >= 0;
        }
    }

