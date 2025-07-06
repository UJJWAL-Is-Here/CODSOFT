import java.util.Scanner;

public class StudentGradeCalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== STUDENT GRADE CALCULATOR ===\n");
        
        // Input: Get number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        // Array to store marks for each subject
        int[] marks = new int[numSubjects];
        
        // Input: Get marks for each subject
        System.out.println("\nEnter marks obtained (out of 100) for each subject:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            
            // Validate input
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks! Please enter marks between 0-100: ");
                marks[i] = scanner.nextInt();
            }
        }
        
        // Calculate Total Marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        
        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Grade Calculation
        String grade = calculateGrade(averagePercentage);
        
        // Display Results
        System.out.println("\n=== RESULTS ===");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        // Display grade breakdown
        System.out.println("\n=== GRADE SCALE ===");
        System.out.println("A+: 90-100%");
        System.out.println("A:  80-89%");
        System.out.println("B+: 70-79%");
        System.out.println("B:  60-69%");
        System.out.println("C+: 50-59%");
        System.out.println("C:  40-49%");
        System.out.println("D:  30-39%");
        System.out.println("F:  Below 30%");
        
        scanner.close();
    }
    
    // Method to calculate grade based on average percentage
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B+";
        } else if (percentage >= 60) {
            return "B";
        } else if (percentage >= 50) {
            return "C+";
        } else if (percentage >= 40) {
            return "C";
        } else if (percentage >= 30) {
            return "D";
        } else {
            return "F";
        }
    }
}
