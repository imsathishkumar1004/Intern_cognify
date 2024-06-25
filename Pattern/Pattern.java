import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Our Pattern Printing Program");
        while (true) {
            System.out.println("\n\nSelect the pattern type:");
            System.out.println("1: Left Pyramid");
            System.out.println("2: Right Pyramid");
            System.out.println("3: Diamond");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();

            if (choice == 4) {
                break;
            }

            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();

            switch (choice) {
                case 1:
                    LeftPyramid(rows);
                    break;
                case 2:
                    RightPyramid(rows);
                    break;
                case 3:
                    Diamond(rows);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }

    public static void LeftPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void RightPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = rows - i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void Diamond(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = rows - i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            for (int l = i - 1; l >= 1; l--) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows - i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            for (int l = i - 1; l >= 1; l--) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
}
