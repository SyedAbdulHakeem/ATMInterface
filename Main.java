import java.util.Scanner;

class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";

    // Register method
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name: ");
        this.name = sc.nextLine();
        System.out.println("Enter your Username: ");
        this.userName = sc.nextLine();
        System.out.println("Enter your Password: ");
        this.password = sc.nextLine();
        System.out.println("Enter your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("Registration Successful. Please log in to your Bank Account.");
    }

    // Login method
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your Username: ");
            String inputUsername = sc.nextLine();
            if (inputUsername.equals(userName)) {
                System.out.println("Enter your Password: ");
                String inputPassword = sc.nextLine();
                if (inputPassword.equals(password)) {
                    System.out.println("Login Successful.");
                    return true;
                } else {
                    System.out.println("Incorrect Password.");
                }
            } else {
                System.out.println("Username not found.");
            }
        }
    }

    // Withdraw method
    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Amount to Withdraw: ");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            transactions++;
            balance -= amount;
            System.out.println("Withdrawal Successful.");
            transactionHistory += amount + " Rs Withdrawn\n";
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    // Deposit method
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Amount to Deposit: ");
        float amount = sc.nextFloat();
        if (amount <= 10000f) {
            transactions++;
            balance += amount;
            System.out.println("Deposit Successful.");
            transactionHistory += amount + " Rs Deposited\n";
        } else {
            System.out.println("Sorry. The limit is 10000 Rs.");
        }
    }

    // Transfer method
    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.println("Enter Amount to Transfer: ");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            if (amount <= 50000f) {
                transactions++;
                balance -= amount;
                System.out.println("Successfully Transferred to " + recipient);
                transactionHistory += amount + " Rs Transferred to " + recipient + "\n";
            } else {
                System.out.println("Sorry. The limit is 50000 Rs.");
            }
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Balance: " + balance + " Rs");
    }

    // Transaction history method
    public void transHistory() {
        if (transactions == 0) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:\n" + transactionHistory);
        }
    }
}

