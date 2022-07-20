public class Account{
    int accountNo;
    int amount;
    String nationalId; // I used a string because a nationalId has 13 digits and an int only has 9

    public Account() {}


    public void deposit(int amount){
        this.amount = this.amount + amount;
        System.out.println(amount + " deposited");
    }

    public void withdraw(int amount) throws NotEnoughMoneyException{
        if(this.amount - amount <= 0)
            throw new NotEnoughMoneyException("Not enough money in the account");
        else{
            this.amount = this.amount - amount;
            System.out.println(amount + " withdrawn");
        }
    }

    public void linkToNationalId(String nationalId) throws InvalidNationalIdException{
        // the national id needs to contain only digits
        if(nationalId.matches("[0-9]+")==false)
            throw new InvalidNationalIdException("The national id contains letters");
        // the first digit must be 1,2,5 or 6
        else if (nationalId.charAt(0)!='1' && nationalId.charAt(0)!='2' && nationalId.charAt(0)!='5' && nationalId.charAt(0)!='6')
          throw new InvalidNationalIdException("The first digit is incorrect");

        else if( (nationalId.charAt(0)=='5' || nationalId.charAt(0)=='6') && nationalId.charAt(1)>'2' || (nationalId.charAt(1)=='2' && nationalId.charAt(2)>'2'))
            throw new InvalidNationalIdException("The year of birth of the national id is incorrect");
        // the month of birth should be lower than 12
        else if(nationalId.charAt(3)>'1' || (nationalId.charAt(3)=='1' && nationalId.charAt(4)>'1'))
            throw new InvalidNationalIdException("The month of birth of the national id is incorrect");
        // the day must be lower then 31 (I didn't verify the month, I assumed that all the months have at most 31 days)
        else if(nationalId.charAt(5)>'3' || (nationalId.charAt(5)=='3' && nationalId.charAt(6)>'1'))
              throw new InvalidNationalIdException("The day of birth of the national id is incorrect");

        else {
            this.nationalId = nationalId;
            System.out.println("The national id has been updated");
        }

    }

}
