import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine();

        Sale[] sales = new Sale[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter customer type (Premium/Gold/Silver/Normal): ");
            String customerType = scanner.nextLine();

            System.out.print("Enter sale date (YYYY-MM-DD): ");
            String saleDate = scanner.nextLine();

            System.out.print("Enter service expense: ");
            double serviceExpense = scanner.nextDouble();

            System.out.print("Enter product expense: ");
            double productExpense = scanner.nextDouble();

            scanner.nextLine();

            Customer customer = new Customer(customerName, customerType);
            sales[i] = new Sale(customer, saleDate);
            sales[i].setServiceExpense(serviceExpense);
            sales[i].setProductExpense(productExpense);
        }

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("\nSale details for Person " + (i + 1) + ":");
            sales[i].displayInfo();
        }

        scanner.close();
    }
}
