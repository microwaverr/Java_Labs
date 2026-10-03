class BankCard {
    private String cardNumber;
    private String holderName;
    private double balance;

    public BankCard(String cardNumber, String holderName, double balance) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getCardNumber() { 
        return cardNumber; 
    }

    public void setCardNumber(String cardNumber) { 
        this.cardNumber = cardNumber; 
    }

    public String getHolderName() { 
        return holderName; 
    }

    public void setHolderName(String holderName) { 
        this.holderName = holderName; 
    }

    public double getBalance() { 
        return balance; 
    }

    public void setBalance(double balance) { 
        this.balance = balance; 
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited: " + amount + ". New balance: " + this.balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: " + amount + ". Remaining balance: " + this.balance);
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public void displayCardInfo() {
        System.out.println("Card Number: " + this.cardNumber + ", Holder: " + this.holderName);
    }
}

class CreditCard extends BankCard {
    private double creditLimit;
    private double interestRate;
    private double currentDebt;

    public CreditCard(String cardNumber, String holderName, double balance, double creditLimit, double interestRate, double currentDebt) {
        super(cardNumber, holderName, balance);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.currentDebt = currentDebt;
    }

    public double getCreditLimit() { 
        return creditLimit; 
    }

    public void setCreditLimit(double creditLimit) { 
        this.creditLimit = creditLimit; 
    }

    public double getInterestRate() { 
        return interestRate; 
    }

    public void setInterestRate(double interestRate) { 
        this.interestRate = interestRate; 
    }

    public double getCurrentDebt() { 
        return currentDebt; 
    }

    public void setCurrentDebt(double currentDebt) { 
        this.currentDebt = currentDebt; 
    }

    public void repayDebt(double amount) {
        if (amount <= this.currentDebt) {
            this.currentDebt -= amount;
            System.out.println("Debt paid: " + amount + ". Remaining debt: " + this.currentDebt);
        } else {
            System.out.println("Amount exceeds current debt.");
        }
    }

    public void increaseLimit(double amount) {
        this.creditLimit += amount;
        System.out.println("Credit limit increased by " + amount + ". New limit: " + this.creditLimit);
    }

    public double calculateInterest() {
        return this.currentDebt * (this.interestRate / 100);
    }
}

class PremiumCreditCard extends CreditCard {
    private double cashbackRate;
    private String HelperPhone;
    private boolean hasVIPAccess;

    public PremiumCreditCard(String cardNumber, String holderName, double balance, double creditLimit, double interestRate, double currentDebt, double cashbackRate, String HelperPhone, boolean hasVIPAccess) {
        super(cardNumber, holderName, balance, creditLimit, interestRate, currentDebt);
        this.cashbackRate = cashbackRate;
        this.HelperPhone = HelperPhone;
        this.hasVIPAccess = hasVIPAccess;
    }

    public double getCashbackRate() { 
        return cashbackRate; 
    }

    public void setCashbackRate(double cashbackRate) { 
        this.cashbackRate = cashbackRate; 
    }

    public String getHelperPhone() { 
        return HelperPhone; 
    }

    public void setHelperPhone(String HelperPhone) { 
        this.HelperPhone = HelperPhone; 
    }

    public boolean getHasVIPAccess() { 
        return hasVIPAccess; 
    }

    public void setHasVIPAccess(boolean hasVIPAccess) { 
        this.hasVIPAccess = hasVIPAccess; 
    }

    public void processCashback(double amount) {
        double cashback = amount * (this.cashbackRate / 100);
        System.out.println("Cashback processed: " + cashback);
        deposit(cashback);
    }

    public void callHelper() {
        System.out.println("Calling Helper service at " + this.HelperPhone);
    }

    public void checkVIPAccess() {
        if (this.hasVIPAccess) {
            System.out.println("VIP access is available.");
        } else {
            System.out.println("No VIP access.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PremiumCreditCard myCard = new PremiumCreditCard("1234-5678-9012", "Ivan Ivanov", 5000.0, 100000.0, 15.0, 0.0, 5.0, "8-800-555-35-35", true);
        
        myCard.displayCardInfo();
        myCard.deposit(1000.0);
        myCard.increaseLimit(50000.0);
        myCard.processCashback(2000.0);
        myCard.callHelper();
    }
}