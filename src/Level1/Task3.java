
/*Task: Student Grade Calculator
        Description: create a program that
        calculates and displays the average grade of
        a student. Prompt the user to enter the
        number of grades to be entered, and then
        input each grade. Calculate the average and
        display it to the user.
        Skills: Loops, arrays, basic arithmetic
        operations.

 */

package Level1;

  import java.util.Scanner;

    public class Task3 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            System.out.println("Enter the number of grades to be entered:");
            int numGrades = sc.nextInt();


            double[] grades = new double[numGrades];


            for (int i = 0; i < numGrades; i++) {
                System.out.println("Enter grade " + (i + 1) + ":");
                grades[i] = sc.nextDouble();
            }


            double sum = 0;
            for (int i = 0; i < numGrades; i++) {
                sum += grades[i];
            }
            double average = sum / numGrades;


            System.out.printf("The average grade is: %.2f\n", average);
        }
    }

