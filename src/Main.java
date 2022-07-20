public class Main {
    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.deposit(100);
        //account.withdraw(200); // Throws exception
        account.withdraw(50);
        account.linkToNationalId("5051028743245"); // This one is correct
        //account.linkToNationalId("5021028743gf5"); // It contains letters
        //account.linkToNationalId("3021028743245"); // The first digit is incorrect
        //account.linkToNationalId("6451028743245"); // The year of birth is incorrect
        //account.linkToNationalId("1022528743245"); // The month of birth is incorrect
        //account.linkToNationalId("6020637743245"); // The day of birth is incorrect
    }
}
