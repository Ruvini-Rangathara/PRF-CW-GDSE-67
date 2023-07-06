import java.util.Scanner;

public class Main {

    static String username = "Ruvini";
    static String password = "1234";

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        loadLoginPage();

    }

    private static void loadLoginPage() {
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("+|                           LOGIN PAGE                           |");
        System.out.println("+-----------------------------------------------------------------+");

        System.out.print("User Name : ");
        String inputted_username = input.next();

        String inputted_password = null;

        while (!inputted_username.equals(username)){
            System.out.println("User name invalid. please try again!");
            System.out.print("\nUser Name : ");
            inputted_username = input.next();
        }

        while (!inputted_password.equals(password)){
            System.out.println("Password is incorrect. please try again!");
            System.out.print("\nPassword : ");
            inputted_password = input.next();
        }

    }


}