import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String username = "Ruvini";
    static String password = "1234";

    static String[][] supplier_array = new String[0][2];

    static String[][] category_array = new String[0][2];

    static String[][] item_array = new String[0][6];


    public static void main(String[] args) {
//        loadLoginPage();

        dashboard();
    }

    private static void loadLoginPage() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                                LOGIN PAGE                                 |");
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
        System.out.println("|                 WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                   |");
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
        System.out.println("|                             SUPPLIER MANAGE                               |");
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
        clearConsole();
        dashboard();
    }

    private static void searchSupplier() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                               SEARCH SUPPLIER                              |");
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
        System.out.println("|                              VIEW SUPPLIERS                               |");
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
        System.out.println("|                              DELETE SUPPLIER                              |");
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
        System.out.println("|                              UPDATE SUPPLIER                              |");
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



    //-------------------------- stock manage --------------------------------
    private static void stockManage() {
        clearConsole();


        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                              STOCK MANAGE                                 |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Manage Item Categories", "[2] Add Item");
        System.out.printf("%-48s%-48s\n", "[3] Get Items Supplier wise", "[4] View Items");
        System.out.printf("%-48s%-48s\n", "[5] Rank Items Per Unit Price", "[6] Home Page");

        int option=0;
        do{
            System.out.print("\nEnter an option to continue > ");
            option = input.nextInt();
        }while (!(option>0 && option<6));


        switch (option){
            case 1 : manageItemCategories();
            case 2 : addItem();
            case 3 : getItemSupplierWise();
            case 4 : viewItems();
            case 5 : rankItemsPerUnitPrice();
            case 6 : homepage();
        }
    }

    private static void rankItemsPerUnitPrice() {
    }

    private static void viewItems() {
        
    }

    private static void getItemSupplierWise() {
        
    }

    private static void addItem() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                                ADD ITEM                                   |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String main_option = "y";
        while(main_option.equals("y") || main_option.equals("Y")){
            boolean hasItemCategory = !(category_array.length == 0);
            if(!hasItemCategory){
                System.out.println("OOPS! It seems that you don't have any item categories in the system.");
                System.out.print("Do you want to add a new item category (Y/N) : ");
                String option = input.next();
                if(option.equals("y") || option.equals("Y")){
                    addNewItemCategory();
                }else{
                    clearConsole();
                    stockManagement();
                }
            }else{
                boolean hasSupplier = !(supplier_array.length == 0);
                if(!hasSupplier){
                    System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
                    System.out.print("Do you want to add a new supplier (Y/N) : ");
                    String option = input.next();

                    if(option.equals("y") || option.equals("Y")){
                        addNewItemCategory();
                    }else{
                        clearConsole();
                        stockManagement();
                    }
                }
            }

            System.out.print("Item Code : ");
            String inputted_item_code = input.next();

            showSupplierList();

            System.out.print("Enter the supplier number : ");
            String inputted_supplier_number = input.next();

            showItemCategories();

            System.out.print("Enter the category number : ");
            String inputted_category_number = input.next();

            System.out.print("\nDescription : ");
            String inputted_description = input.next();

            System.out.print("\nUnit Price : ");
            String inputted_unit_price = input.next();

            System.out.print("\nQty On Hand : ");
            String inputted_qty_on_hand = input.next();

            item_array = incrementItemArray();

            item_array[item_array.length-1][0] = inputted_item_code;
            item_array[item_array.length-1][1] = inputted_description;
            item_array[item_array.length-1][2] = inputted_unit_price;
            item_array[item_array.length-1][3] = inputted_qty_on_hand;
            item_array[item_array.length-1][4] = inputted_category_number;
            item_array[item_array.length-1][5] = inputted_supplier_number;

            System.out.print("Added successfully! Do you want add another item (Y/N) : ");
            main_option = input.next();
        }

        stockManagement();
    }

    private static String[][] incrementItemArray() {
        String[][] temp = new String[item_array.length+1][6];
        for (int i = 0; i < item_array.length; i++) {
            for (int j = 0; j < item_array[0].length; j++) {
                temp[i][j] = item_array[i][j];
            }
        }
        return temp;
    }

    private static void showItemCategories() {
        System.out.println("\nItem Categories : ");
        System.out.println("+----------------------+----------------------+");
        System.out.printf("|%-22s|%-22s|\n", "#","CATEGORY NAME");
        System.out.println("+----------------------+----------------------+");

        for (int i = 0; i < item_array.length; i++) {
            System.out.printf("|%-22s|%-22s|\n",i+1, supplier_array[i][1]);
        }
        System.out.println("+----------------------+----------------------+");

    }

    private static void showSupplierList() {
        System.out.println("\nSupplier List : ");
        System.out.println("+----------------------+----------------------+----------------------+");
        System.out.printf("|%-22s|%-22s|%-22s|\n", "#","SUPPLIER ID", "SUPPLIER NAME");
        System.out.println("+----------------------+----------------------+----------------------+");

        for (int i = 0; i < supplier_array.length; i++) {
            System.out.printf("|%-22s|%-22s|%-22s|\n",i+1, supplier_array[i][0], supplier_array[i][1]);
        }
        System.out.println("+----------------------+----------------------+----------------------+");

    }

    private static void manageItemCategories() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                          MANAGE ITEM CATEGORY                             |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        System.out.printf("%-48s%-48s\n", "[1] Add New Item Category", "[2] Delete Item Category");
        System.out.printf("%-48s%-48s\n", "[3] Update Item Category", "[4] Stock Management");

        int option=0;
        do{
            System.out.print("\nEnter an option to continue > ");
            option = input.nextInt();
        }while (!(option>0 && option<4));


        switch (option){
            case 1 : addNewItemCategory();
            case 2 : deleteItemCategory();
            case 3 : updateItemCategory();
            case 4 : stockManagement();
        }

    }

    private static void stockManagement() {
        clearConsole();
        stockManage();
    }

    private static void updateItemCategory() {

    }

    private static void deleteItemCategory() {
//        clearConsole();
//
//        System.out.println("+---------------------------------------------------------------------------+");
//        System.out.println("|                           DELETE ITEM CATEGORY                            |");
//        System.out.println("+---------------------------------------------------------------------------+\n");
//
//        String option = "y";
//        while (option.equals("y") || option.equals("Y")){
//            System.out.print("Supplier ID : ");
//            String inputted_supplier_id = input.next();
//            boolean valid = checkSupplierValidity(inputted_supplier_id);
//
//            while(!valid){
//                System.out.println("Can't find supplier id. Try again!\n");
//                System.out.print("Supplier ID : ");
//                inputted_supplier_id = input.next();
//                valid = checkSupplierValidity(inputted_supplier_id);
//                System.out.println();
//            }
//
//            String[][] temp = new String[supplier_array.length][2];
//
//            for (int i = 0; i < supplier_array.length; i++) {
//                if(inputted_supplier_id.equals(supplier_array[i][0])){
//                    continue;
//                }
//                temp[i][0] = supplier_array[i][0];
//                temp[i][1] = supplier_array[i][1];
//            }
//            supplier_array=temp;
//
//            System.out.print("Deleted successfully! Do you want to delete another supplier (Y/N) : ");
//            option = input.next();
//        }
//
//        clearConsole();
//        supplierManage();
    }

    private static void addNewItemCategory() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                             ADD ITEM CATEGORY                             |");
        System.out.println("+---------------------------------------------------------------------------+\n");

        String option = "y";

        while (option.equals("y") || option.equals("Y")){
            System.out.print("Enter the new item category : ");
            String inputted_category = input.next();

            boolean validity = checkCategoryValidity(inputted_category);
            if(!validity){
                String category_number = String.valueOf(category_array.length+1);
                category_array =  incrementCategoryArray();

                category_array[category_array.length-1][0] = category_number;
                category_array[category_array.length-1][1] = inputted_category;

            }

            System.out.print("Added successfully! Do you want to add another category (Y/N) : ");
            option = input.next();
            System.out.println();
        }

    }

    private static String[][] incrementCategoryArray() {
        String[][] temp = new String[category_array.length+1][2];
        for (int i = 0; i < category_array.length; i++) {
            temp[i][0] = category_array[i][0];
            temp[i][1] = category_array[i][1];
        }
        return temp;
    }

    private static boolean checkCategoryValidity(String inputtedCategory) {
        for (int i = 0; i < category_array.length; i++) {
            if(category_array[i][1].equals(inputtedCategory)){
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