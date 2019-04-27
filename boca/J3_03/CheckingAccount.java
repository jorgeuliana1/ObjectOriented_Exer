import java.util.Locale;

public class CheckingAccount {

    private double balance = 0.0;
    private double tax;

    CheckingAccount() {
        setTax(0.005);
    }

    public void addToBalance(double value) throws NegativeMoneyValueException {
        if(value < 0)
            throw new NegativeMoneyValueException((float)value);
        balance += value;
        printBalance();
    }

    public void takeFromBalance(double value) throws YouDontHaveException, NegativeMoneyValueException {

        if(value < 0)
            throw new NegativeMoneyValueException((float)value);

        if(balance >= value * (1 + getTax()))
            balance -= value * (1 + getTax());
        else
            throw new YouDontHaveException((float)balance, (float)value);

        printBalance();
    }

    public double getBalance() {
        return balance;
    }

    private void printBalance() {
        System.out.printf(new Locale("pt", "BR"), "R$ %.2f\n", balance);
    }

    protected void setTax(double val) {
        tax = val;
    }

    public double getTax() {
        return tax;
    }

} 
