class BankAcct
{
    private String name;
    private int acct_id;
    protected double balance;

    public BankAcct (String my_name, int my_id, double my_bal)
    {
        this.name = my_name;
        this.acct_id = my_id;
        this.balance = my_bal;
    }

    public String myName() {return this.name;}
    public int myID() {return this.acct_id;}
    public double myBalance() {return this.balance;}

    public void deposit(double money)
    {
        this.balance +=money;
    }

    public void withdraw(double money)
    {
        if (this.balance < money)
            System.out.println("Insufficient funds!");
        else
            this.balance -= money;
    }

    public String toString()
    {
        return this.name + "'s Account #" + this.acct_id + ":\nbalance: $" + this.balance;
    }
}
