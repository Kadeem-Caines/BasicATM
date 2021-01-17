import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

     ATM test = new ATM();
     Account test1 = new Account(545,45435, "this");

     test.Greetings();
     test.Choice(test1);


    }

}

