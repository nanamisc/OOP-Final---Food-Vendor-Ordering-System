import java.util.*;
public class Main {

    public static List<Vendor> vendorList = new ArrayList<>();

    public static void main (String args[]){    
        Scanner scanner= new Scanner(System.in);
        while (true) {
            System.out.println("Choose your role: (1) Vendor or (2) Customer or (3) Exit?");
            int roleChoice = scanner.nextInt();
            scanner.nextLine();

            if (roleChoice == 1) {
                runVendorInterface(scanner);
            } else if (roleChoice == 2) {
                runCustomerInterface(scanner);
            } else if (roleChoice == 3) {
                System.out.println("Thank you! Exiting the system.");
                break;
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        } 
    }

    public static void runVendorInterface(Scanner scanner) {
        System.out.println("\n=== Welcome to the Vendor Menu Management System ===");
        System.out.println("Enter your vendor name:");
        String vendorName = scanner.nextLine();
        Vendor vendor = new Vendor(vendorName);
        boolean exists = false;
        for(Vendor v: vendorList) {
            if(v.getName().equals(vendorName)) {
                exists = true;
                break;
            }
        }
        if(!exists) {
            vendorList.add(vendor);
        }
        // displays choices 
        while (true) {

            System.out.println("1. Create Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Edit Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a number between 1-5");
                continue;
            }


            if (choice==1){//create menu
                System.out.println("How many items do you want to add to the new menu?");
                int numItems= scanner.nextInt();
                scanner.nextLine();
                List <menuItem> newMenu=new ArrayList<>();
                for(int i=0; i<numItems;i++ ){
                    System.out.println("What is the name of the item?");
                    String itemName=scanner.nextLine();
                    System.out.println("What is the price of the item?");
                    double price=scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("What are the ingredients of the menu item?");
                    String ingredients=scanner.nextLine();
                    newMenu.add(new menuItem(itemName,price,ingredients));

                }
                vendor.createMenu(newMenu);

            }else if( choice==2){ //add item
                    System.out.println("What is the name of the item you want to add?");
                    String itemName=scanner.nextLine();
                    System.out.println("What is the price of the item you want to add?");
                    double price=scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("What are the ingredients of the menu item you want to add?");
                    String ingredients=scanner.nextLine();
                    vendor.addItem(new menuItem(itemName,price,ingredients));

            }else if( choice==3){//edit item
                    System.out.println("What is the name of the item you want to edit?");
                    String itemName=scanner.nextLine();
                    System.out.println("What is the price you want to switch to?");
                    double price=scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("What are the new ingredients?");
                    String ingredients=scanner.nextLine();
                    vendor.editItem(itemName,price,ingredients);

            }else if( choice==4){//delete item
                System.out.print("Enter the name of the item you want to delete: ");
                String name = scanner.nextLine();
                vendor.deleteItem(name);       

            } else if(choice == 5) {
                break;

            } else {
                System.out.println("Invalid choice! Please enter a number between 1-5");
            }          
        }
    }

    public static void runCustomerInterface(Scanner scanner) {
        System.out.println("\n=== Welcome to the Food Vendor Ordering System ===");
        System.out.println("Enter your name:");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName);
        while (true) {

            System.out.println("1. Browse by Cuisine");
            System.out.println("2. Search for Vendor");
            System.out.println("3. Order from Vendor");
            System.out.println("4. View Order Status");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a number between 1-5");
                continue;
            }

            if(choice == 1) {
                customer.browseByCuisine();
            } else if(choice == 2) {
                System.out.print("Enter vendor name to search: ");
                String vendorName = scanner.nextLine();
                customer.searchVendor(vendorName);
            } else if(choice == 3) {
                System.out.print("Enter vendor name to order from: ");
                String vendorName = scanner.nextLine();
                customer.placeOrder(vendorName, scanner);
            } else if(choice == 4) {
                System.out.print("Enter order number to view status: ");
                String order = scanner.nextLine();
                int orderNum;
                try {
                    orderNum = Integer.parseInt(order);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid order number!");
                    continue;
                }
                customer.viewOrderStatus(orderNum);
            } else if(choice == 5) {
                System.out.println("Thank you for using the Food Vendor Ordering System!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter a number between 1-5");
            }
        }

    }
}
