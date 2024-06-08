/*Task: Palindrome Checker
Description: Implement a program that checks
whether a given word or phrase is a palindrome. A
palindrome is a word or phrase that reads the
same forwards and backward, ignoring spaces and
punctuation.
Skills: String manipulation, loops, conditional
statements.

 */

package Level1;

import java.util.Scanner;

public class Task2 {
    public static boolean isPalindrome(String s) {

            String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            int left = 0;
            int right = cleaned.length() - 1;


            while (left < right) {
                if (cleaned.charAt(left) != cleaned.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a word or phrase:");
            String input = sc.nextLine();

            if (isPalindrome(input)) {
                System.out.println("The input is a palindrome.");
            } else {
                System.out.println("The input is not a palindrome.");
            }
        }
    }


