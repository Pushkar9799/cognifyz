package codsoft;/*TASK 2
        Input: Take marks obtained (out of 100) in each subject.
        Calculate Total Marks: Sum up the marks obtained in all subjects.
        Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
        average percentage.
        Grade Calculation: Assign grades based on the average percentage achieved.
        Display Results: Show the total marks, average percentage, and the corresponding grade to the user
        STUDENT GRADE CALCULATOR

 */


import java.util.Scanner;

public class Task2 {
    //Student calculator
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determine the grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);


    }
}
