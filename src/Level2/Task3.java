package Level2;

import java.util.Scanner;

public class Task3 {



        private static final int SHIFT_KEY = 3; // Simple Caesar cipher shift

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the File Encryption/Decryption Program!");
            System.out.print("Do you want to encrypt or decrypt a file? (enter 'encrypt' or 'decrypt'): ");
            String choice = scanner.nextLine().toLowerCase();

            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();

            System.out.print("Enter the output file path: ");
            String outputFilePath = scanner.nextLine();

            try {
                if (choice.equals("encrypt")) {
                    encryptFile(filePath, outputFilePath);
                    System.out.println("File encrypted successfully. Saved to: " + outputFilePath);
                } else if (choice.equals("decrypt")) {
                    decryptFile(filePath, outputFilePath);
                    System.out.println("File decrypted successfully. Saved to: " + outputFilePath);
                } else {
                    System.out.println("Invalid choice. Please enter 'encrypt' or 'decrypt'.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            scanner.close();
        }

        private static void encryptFile(String filePath, String outputFilePath) throws IOException {
            processFile(filePath, outputFilePath, true);
        }

        private static void decryptFile(String filePath, String outputFilePath) throws IOException {
            processFile(filePath, outputFilePath, false);
        }

        private static void processFile(String filePath, String outputFilePath, boolean isEncrypt) throws IOException {
            File inputFile = new File(filePath);
            File outputFile = new File(outputFilePath);

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String processedLine = isEncrypt ? encrypt(line) : decrypt(line);
                    writer.write(processedLine);
                    writer.newLine();
                }
            }
        }

        private static String encrypt(String input) {
            return shiftString(input, SHIFT_KEY);
        }

        private static String decrypt(String input) {
            return shiftString(input, -SHIFT_KEY);
        }

        private static String shiftString(String input, int shift) {
            StringBuilder result = new StringBuilder();
            for (char c : input.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base + shift + 26) % 26 + base);
                }
                result.append(c);
            }
            return result.toString();
        }
    }


