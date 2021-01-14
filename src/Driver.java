import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        int balance=0;
        int choice;
        int amount;
        boolean choosing=true;
        Scanner myObj = new Scanner(System.in);
        Scanner myObj2 = new Scanner(System.in);
        Scanner myObj3 = new Scanner(System.in);

        System.out.println("Welcome to the Basic ATM \n \n"+ "Please choose from one of the following options: \n" );

        while (choosing){

            System.out.println("1.Check Balance \n"+ "2.Deposit \n" +"3.Withdrawal \n" +"0.Quit \n");

            while (!myObj.hasNextInt()) {
                System.out.println("Input is not a number. Please choose one of the options");
                System.out.println("1.Check Balance \n"+ "2.Deposit \n" +"3.Withdrawal \n" +"0.Quit \n");
                myObj.nextLine();
            }

            choice=myObj.nextInt();

            if(choice == 1 || choice==2 || choice==3 || choice==0){

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is:" + balance);
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
                                continue;
                            }

                            else{
                                balance += amount;
                                System.out.println("Balance has been updated. Your new balance is:" + " "+ balance);
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
                                continue;
                            }

                            else if (amount>balance){
                                System.out.println("Withdrawal cannot be greater than your balance. Please a number less than your balance");
                                continue;
                            }

                            else{
                                balance -= amount;
                                System.out.println("Balance has been updated. Your new balance is:" + " "+ balance);
                                break;
                            }

                        }
                        break;

                    case 0:
                        System.out.println("Thank you and goodbye");
                        System.exit(0);
                    default:
                        // code block
                        break;
                }

            }

            else{
                System.out.println("Invalid input. Please choose one of the options ");
                continue;
            }




        }


    }

}
