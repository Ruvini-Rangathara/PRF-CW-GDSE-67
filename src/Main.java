import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String username = "Ruvini";
    static String password = "1234";

    static String[][] supplier_array = new String[0][2];


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
        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                   |");
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
        clearConsole();
        System.exit(0);
    }

    private static void logout() {
        clearConsole();
        loadLoginPage();
    }

    private static void stockManage() {
        clearConsole();
    }

    private static void changeTheCredentials() {
        clearConsole();

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


    private static void supplierManage() {
        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                             SUPPLIER MANAGE                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Add supplier", "[2] Update supplier");
        System.out.printf("%-48s%-48s\n", "[3] Delete supplier", "[4] View suppliers");
        System.out.printf("%-48s%-48s\n", "[5] Search supplier", "[6] Home Page");

        int option=0;
        do{
            System.out.print("\nEnter an option to continue > ");
            option = input.nextInt();
        }while (!(option>0 && option<6));


        switch (option){
            case 1 : addSupplier();
            case 2 : updateSupplier();
            case 3 : deleteSupplier();
            case 4 : viewSuppliers();
            case 5 : searchSupplier();
            case 6 : homepage();
        }
    }

    private static void homepage() {
    }

    private static void searchSupplier() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                              SEARCH SUPPLIER                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String option = "y";
        while (option.equals("y") || option.equals("Y")){
            System.out.print("Supplier ID : ");
            String inputted_supplier_id = input.next();

            boolean validity = checkSupplierValidity(inputted_supplier_id);

            while (!validity){
                System.out.println("Can't find supplier id. Try again!\n");
                System.out.print("Supplier ID : ");
                inputted_supplier_id = input.next();
                validity = checkSupplierValidity(inputted_supplier_id);
            }

            String name = getSupplierName(inputted_supplier_id);
            System.out.println("Supplier Name : "+name);

            System.out.print("Found Successfully! Do you want to find another supplier (Y/N) : ");
            option = input.next();

        }
        clearConsole();
        supplierManage();

    }

    private static void viewSuppliers() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                              VIEW SUPPLIERS                               |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.println("+----------------------+----------------------+");
        System.out.printf("|%-22s|%-22s|\n", "SUPPLIER ID", "SUPPLIER NAME");
        System.out.println("+----------------------+----------------------+");

        for (int i = 0; i < supplier_array.length; i++) {
            System.out.printf("|%-22s|%-22s|\n", supplier_array[i][0], supplier_array[i][1]);
        }
        System.out.println("+----------------------+----------------------+");

        System.out.print("Do you want to go supplier manage page (Y/N) : ");
        String option = input.next();

        if(option.equals("y") || option.equals("Y")){
            clearConsole();
            supplierManage();
        }

    }

    private static void deleteSupplier() {
        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                             DELETE SUPPLIER                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String option = "y";
        while (option.equals("y") || option.equals("Y")){
            System.out.print("Supplier ID : ");
            String inputted_supplier_id = input.next();
            boolean valid = checkSupplierValidity(inputted_supplier_id);

            while(!valid){
                System.out.println("Can't find supplier id. Try again!\n");
                System.out.print("Supplier ID : ");
                inputted_supplier_id = input.next();
                valid = checkSupplierValidity(inputted_supplier_id);
                System.out.println();
            }

            String[][] temp = new String[supplier_array.length][2];

            for (int i = 0; i < supplier_array.length; i++) {
                if(inputted_supplier_id.equals(supplier_array[i][0])){
                    continue;
                }
                temp[i][0] = supplier_array[i][0];
                temp[i][1] = supplier_array[i][1];
            }
            supplier_array=temp;

            System.out.print("Deleted successfully! Do you want to delete another supplier (Y/N) : ");
            option = input.next();
        }

        clearConsole();
        supplierManage();

    }

    private static void updateSupplier() {
        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                             UPDATE SUPPLIER                              |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String option = "y";
        while (option.equals("y") || option.equals("Y")){
            System.out.print("Supplier ID : ");
            String inputted_supplier_id = input.next();
            boolean valid = checkSupplierValidity(inputted_supplier_id);

            while(!valid){
                System.out.println("Can't find supplier id. Try again!\n");
                System.out.print("Supplier ID : ");
                inputted_supplier_id = input.next();
                System.out.println();
                valid = checkSupplierValidity(inputted_supplier_id);
            }

            String supplier_name = getSupplierName(inputted_supplier_id);
            System.out.println("Supplier Name : "+supplier_name);

            System.out.println("Enter the new supplier Name : ");
            String inputted_supplier_name = input.next();

            for (int i = 0; i < supplier_array.length; i++) {
                if(inputted_supplier_id.equals(supplier_array[i][0])){
                    supplier_array[i][1]=inputted_supplier_name;
                }
            }
            System.out.print("Updated successfully! Do you want to update another supplier (Y/N) : ");
            option = input.next();
        }

        clearConsole();
        supplierManage();

    }

    private static String getSupplierName(String inputtedSupplierId) {
        for (int i = 0; i < supplier_array.length; i++) {
            if(supplier_array[i][0].equals(inputtedSupplierId)){
                return supplier_array[i][1];
            }
        }
        return null;
    }

    private static void addSupplier() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("+|                               ADD SUPPLIER                               |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String option = "y";
        while (option.equals("y") || option.equals("Y")){
            System.out.print("Supplier ID : ");
            String inputted_supplier_id = input.next();
            boolean valid = checkSupplierValidity(inputted_supplier_id);

            while(valid){
                System.out.print("Already exists. Try another supplier id!");
                inputted_supplier_id = input.next();
                valid = checkSupplierValidity(inputted_supplier_id);
                System.out.println();
            }

            System.out.print("Supplier Name : ");
            String inputted_supplier_name = input.next();

            supplier_array = extendSupplierArray(supplier_array);
            supplier_array[supplier_array.length-1][0] = inputted_supplier_id;
            supplier_array[supplier_array.length-1][1] = inputted_supplier_name;

            System.out.print("Added successfully! Do you want to add another supplier (Y/N) : ");
            option = input.next();
            System.out.println();
        }
        clearConsole();
        supplierManage();
    }

    private static String[][] extendSupplierArray(String[][] supplier_array) {
        String[][] temp = new String[supplier_array.length+1][2];
        for (int i = 0; i < supplier_array.length; i++) {
            temp[i][0] = supplier_array[i][0];
            temp[i][1] = supplier_array[i][1];
        }
        return temp;
    }

    private static boolean checkSupplierValidity(String inputtedSupplierId) {
        for (int i = 0; i < supplier_array.length; i++) {
            if(supplier_array[i][0].equals(inputtedSupplierId)){
                return true;
            }
        }
        return false;
    }


















    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
//handle the exception
            System.err.println(e.getMessage());
        }
    }
}