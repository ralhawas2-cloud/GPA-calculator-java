import java.util.Scanner;

public class GPACalculator {

    public static double convertGradeToPoints(String grade) {
        switch (grade.toUpperCase()) {
            case "A+": return 5.0;
            case "A":  return 4.5;
            case "B+": return 4.0;
            case "B":  return 3.5;
            case "C+": return 3.0;
            case "C":  return 2.5;
            case "D+": return 2.0;
            case "D":  return 1.5;
            case "F":  return 0.0;
            default:   return -1;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== GPA Calculator ===");
        System.out.print("Enter number of courses: ");
        int numberOfCourses = input.nextInt();

        double totalPoints = 0;
        int totalHours = 0;

        for (int i = 1; i <= numberOfCourses; i++) {

            System.out.println("\nCourse " + i);

            System.out.print("Enter credit hours: ");
            int hours = input.nextInt();
            input.nextLine(); // clear buffer

            System.out.print("Enter letter grade (A, B+, C, etc.): ");
            String grade = input.nextLine();

            double gradePoints = convertGradeToPoints(grade);

            if (gradePoints == -1) {
                System.out.println("Invalid grade entered. Try again.");
                i--;
                continue;
            }

            totalPoints += gradePoints * hours;
            totalHours += hours;
        }

        double gpa = totalPoints / totalHours;

        System.out.println("\n========================");
        System.out.printf("Your GPA is: %.2f\n", gpa);
        System.out.println("========================");

        input.close();
    }
}
