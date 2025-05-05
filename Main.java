import java.util.*;
public class Main {
    public static void main (String args[]){    
        Scanner scanner= new Scanner(System.in);

        System.out.println("\n=== Welcome to the Vendor Menu Management System ===");
        System.out.println("Enter your vendor name:");
        String vendorName = scanner.nextLine();
        Vendor vendor = new Vendor(vendorName);
        // displays choices 
        while (true) {

            System.out.println("1. Create Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Edit Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.print("Choose an option: ");
            int choice= scanner.nextInt();
            scanner.nextLine();


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
            

            }else{

            }
            
        }
        
    }
}
