import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfNumbers;
        int[] numbers;

        System.out.print("Enter the number of numbers to input: ");
        numberOfNumbers = scanner.nextInt();

        numbers = new int[numberOfNumbers];

        for (int i = 0; i < numberOfNumbers; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nEntered numbers:");
        for (int i = 0; i < numberOfNumbers; i++) {
            System.out.println(numbers[i]);
        }
    }
}