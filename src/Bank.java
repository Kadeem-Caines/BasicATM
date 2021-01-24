import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Bank {

   private HashMap<String, Account> accounts = new HashMap<String, Account>();
   private Scanner myObj = new Scanner(System.in);
    private Scanner myObj2 = new Scanner(System.in);
    private Account test=null;



    public void createAccount(){

        int pin=0;
        String name="";
        boolean choosing=true;
        Random rand = new Random();
        String accountNumber = "";


        for (int i = 0; i < 14; i++)
        {
            int n = rand.nextInt(10) + 0;
            accountNumber += Integer.toString(n);
        }

        System.out.println("Let's begin by creating an account");
        System.out.println("First, we'll assign you an account number:" + accountNumber);
        System.out.println("Next, type in your 4 digit pin");

        while(choosing) {

            while (!myObj.hasNextInt()) {
                System.out.println("Input is not a number. Please type in your 4 digit pin");
                myObj.nextLine();
            }

            pin = myObj.nextInt();


            if (String.valueOf(pin).length() != 4) {
                System.out.println("Your Pin must be 4 digits long. Please try again");
            }

            else{
                break;
            }

        }


        System.out.println("Finally, type in your first name");

        while(choosing) {


            name = myObj2.nextLine();

            if(name.matches("[a-zA-Z]+") ){

                if(name.length()<=10){
                    break;
                }

                else{
                    System.out.println("Your name cannot be longer then 10 characters. Please try again");
                }


            }

            else{
                System.out.println("Your name cannot contain a digit. Please try again");
            }


        }

        System.out.println("Processing....");
        System.out.println("The following account info has been created:");
        System.out.println("Account number:" +" "+ accountNumber);
        System.out.println("Account holder:"+ " "+name);
        System.out.println("Please write down your pin in order to remember it");

        accounts.put(accountNumber, new Account(accountNumber,pin,name));

    }

    public void logIn(){

        int pin;
        String accountNumber;
        boolean choosing = true;
        Scanner myObj = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);

        while(choosing) {


            System.out.println("Please enter your information in order to log in or enter just 0 to return to the main menu");
            System.out.println("Account number:");

            while (!myObj.hasNextInt()) {
                System.out.println("Input is not a number. Please enter only number");
                myObj.nextLine();
            }

            accountNumber = myObj.nextLine();

            if(accountNumber.equals("0")){
                System.out.println("Returning to main menu");
                break;
            }

            System.out.println("Pin:");

            while (!myObj2.hasNextInt()) {
                System.out.println("Input is not a number. Please enter only number");
                myObj2.nextLine();
            }

            pin = myObj2.nextInt();

            if(pin==0){
                System.out.println("Returning to main menu");
                break;
            }


            if (accounts.containsKey(accountNumber)) {

                if (accounts.get(accountNumber).getPin() == pin) {

                    test = accounts.get(accountNumber);
                    System.out.println("You've successfully logged in");
                    System.out.println("Welcome" + " " + test.getAccountHolder());
                    break;

                }


            }

            else {
                System.out.println("No account matches the information you've entered. Please try again, or type in simply 0 to go back to main menu");
            }

        }


    }

    public void logOut(){

        System.out.println("You have been successfully logged out");
        this.test=null;
    }


    public void choice(){

        int choice;
        boolean choosing=true;
        int amount;
        Scanner myObj = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);
        Scanner myObj3 = new Scanner(System.in);

        System.out.println("Welcome to the Basic ATM \n \n"+ "Please choose from one of the following options: \n" );

        while (choosing){

            System.out.println("1.Check Balance \n"+ "2.Deposit \n" +"3.Withdrawal \n" +"4.Create an account \n" +"5.Log in \n" +"6.Log out \n" +"0.Quit \n");

            while (!myObj.hasNextInt()) {
                System.out.println("Input is not a number. Please choose one of the options");
                System.out.println("1.Check Balance \n"+ "2.Deposit \n" +"3.Withdrawal \n" +"4.Create an account \n" +"5.Log in \n" +"6.Log out \n" +"0.Quit \n");
                myObj.nextLine();
            }

            choice=myObj.nextInt();

            switch (choice) {
                case 1:

                    if(test==null){
                        System.out.println("Not currently logged in. Please log into an account");
                        break;
                    }

                    System.out.println("Your current balance is:" + test.getBalance());
                    break;

                case 2:
                    while (choosing) {



                        System.out.println("Please enter how much you want to deposit \n");
                        System.out.print("Deposit amount:");

                        while (!myObj2.hasNextInt()) {
                            System.out.println("Input is not a number. Please enter a non negative number \n");
                            System.out.print("Deposit amount:");
                            myObj2.nextLine();
                        }

                        amount = myObj2.nextInt();

                        if(amount<=0){
                            System.out.println("Deposit cannot be 0 or less. Please a number greater than 0");

                        }

                        else{
                            test.deposit(amount);
                            System.out.println("Balance has been updated. Your new balance is:" + " "+ test.getBalance());
                            break;
                        }

                    }
                    break;

                case 3:
                    while (choosing) {

                        System.out.println("Please enter how much you want to withdraw \n");
                        System.out.print("Withdrawal amount:");

                        while (!myObj3.hasNextInt()) {
                            System.out.println("Input is not a number. Please enter a non negative number \n");
                            System.out.print("Withdrawal amount:");
                            myObj3.nextLine();
                        }

                        amount = myObj3.nextInt();

                        if(amount<=0){
                            System.out.println("Withdrawal cannot be 0 or less. Please a number greater than 0 but lower than your current balance");

                        }

                        else if (amount>test.getBalance()){
                            System.out.println("Withdrawal cannot be greater than your balance. Please a number less than your balance");

                        }

                        else{
                            test.withdrawal(amount);
                            System.out.println("Balance has been updated. Your new balance is:" + " "+ test.getBalance());
                            break;
                        }

                    }
                    break;

                case 4:
                    createAccount();
                    break;


                case 5:
                    logIn();
                    break;

                case 6:
                   logOut();
                    break;

                case 0:
                    System.out.println("Thank you and goodbye");
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please choose one of the options ");


            }

        }
}

}
