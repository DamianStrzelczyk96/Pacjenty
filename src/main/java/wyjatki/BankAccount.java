//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package wyjatki;

public class BankAccount {
    private Person owner;
    private Double amount;

    public BankAccount(Person person) {
        this.owner = person;
        this.amount = 0.0D;
    }

    public void deposit(double money) {
        this.amount = this.amount + money;
    }

    public void withdraw(double money) throws InsufficientFundsException {
        if (money > this.amount) {
            throw new InsufficientFundsException();
        } else {
            this.amount = this.amount - money;
        }
    }

    public Double getAmount() {
        return this.amount;
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(new Person("Jakub", "Dąbrowski", "8123456"));
        bankAccount.deposit(100.0D);
        System.out.println(bankAccount.getAmount());

        try {
            bankAccount.withdraw(1000.0D);
        } catch (Exception var3) {
            System.out.println(var3.getMessage());
        }

    }
}
