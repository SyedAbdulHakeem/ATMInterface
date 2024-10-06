import java.util.Scanner;

public class ATMinterface {
    // Method to take integer input with limits
    public static int takeIntegerInput(int limit) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while (true) {
            try {
                input = sc.nextInt();
                if (input >= 1 && input <= limit) {
                    return input;
                } else {
                    System.out.println("Choose a number between 1 to " + limit);
                }
            } catch (Exception e) {
                System.out.println("Enter only integer values.");
                sc.next(); // Clear the invalid input
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("*******WELCOME TO GOVARDHAN ATM INTERFACE*******");
        System.out.println("1. Register \n2. Exit");
        System.out.print("Choose one option: ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("\n1. Login \n2. Exit");
                System.out.print("Enter your choice: ");
                int ch = takeIntegerInput(2);

                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("*******WELCOME BACK " + b.name + "*******");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
                            System.out.print("Enter your choice: ");
                            int c = takeIntegerInput(6);

                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice! Please choose a valid option.");
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
