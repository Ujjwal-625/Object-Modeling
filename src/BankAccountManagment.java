import java.util.ArrayList;
import java.util.List;

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
            System.out.println(customer.getCustomerName() + " opened an account at " + bankName);
        } else {
            System.out.println(customer.getCustomerName() + " already has an account at " + bankName);
        }
    }

    public String getBankName() {
        return bankName;
    }

    public List<Customer> getCustomers(){
        return customers;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", customers=" + customers +
                '}';
    }
}

class Customer {
    private String customerName;
    private Bank bank;
    private double balance;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.balance = 0.0;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(customerName + " deposited " + amount + ". New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(customerName + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void viewBalance() {
        System.out.println(customerName + "'s balance: " + balance);
    }

    public String getCustomerName() {
        return customerName;
    }

    public Bank getBank(){
        return bank;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", bank=" + (bank != null ? bank.getBankName() : "null") +
                ", balance=" + balance +
                '}';
    }
}

public class BankAccountManagment {
    public static void main(String[] args) {
        Bank bankA = new Bank("City Bank");
        Bank bankB = new Bank("National Bank");

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Charlie");

        bankA.openAccount(customer1);
        customer1.setBank(bankA);
        bankA.openAccount(customer2);
        customer2.setBank(bankA);
        bankB.openAccount(customer3);
        customer3.setBank(bankB);

        customer1.deposit(1000);
        customer2.withdraw(500);
        customer3.deposit(2000);

        customer1.viewBalance();
        customer2.viewBalance();
        customer3.viewBalance();

        System.out.println(bankA);
        System.out.println(bankB);
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
    }
}