import java.util.Scanner;

public class Main {

    static String username = "Ruvini";
    static String password = "1234";

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//        loadLoginPage();

        dashboard();
    }

    private static void loadLoginPage() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                                LOGIN PAGE                                |");
        System.out.println("+---------------------------------------------------------------------------+");

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

        dashboard();

    }

    private static void dashboard() {

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                   WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Change the credentials", "[2] Supplier Manage");
        System.out.printf("%-48s%-48s\n", "[3] Stock Manage", "[4] Logout");
        System.out.println("[5] Exit the system ");

        int option=0;
        do{
            System.out.print("\nEnter an option to continue > ");
            option = input.nextInt();
        }while (!(option>0 && option<6));
        
        
        switch (option){
            case 1 : changeTheCredentials();
            case 2 : supplierManage();
            case 3 : stockManage();
            case 4 : logout();
            case 5 : exitTheSystem();
        }

    }

    private static void exitTheSystem() {

    }

    private static void logout() {
        
    }

    private static void stockManage() {
        
    }

    private static void supplierManage() {
        
    }

    private static void changeTheCredentials() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                            CREDENTIAL MANAGE                             |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.print("Please enter the user name to verify it's you : ");
        String inputted_username = input.next();

        while(!inputted_username.equals(username)){
            System.out.println("Invalid user name. Try again!\n");
            System.out.print("Please enter the user name to verify it's you : ");
            inputted_username = input.next();
            System.out.println();
        }

        System.out.println("Hey "+username);

        System.out.print("Enter your current password : ");
        String inputted_password = input.next();

        while(!inputted_password.equals(password)){
            System.out.println("Incorrect password. Try again!\n");
            System.out.print("Enter your current password : ");
            inputted_password = input.next();
            System.out.println();
        }

        System.out.print("Enter your new password : ");
        inputted_password = input.next();
        password=inputted_password;

        System.out.println("Password changed successfully! Do you want to go home page (Y/N) : ");
        String answer = input.next();

        if(answer.equals("y") || answer.equals("Y")){
            dashboard();
        }
    }


}