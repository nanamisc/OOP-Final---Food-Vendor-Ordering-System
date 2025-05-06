import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void browseByCuisine() {
        if (Main.vendorList.isEmpty()) {
            System.out.println("\nNo vendors available.\n");
            return;
        }

        System.out.println("\nAvailable Vendors:");
        for (Vendor v : Main.vendorList) {
            System.out.println("- " + v.getName());
        }
    }

    public void searchVendor(String name) {
        Vendor vendor = getVendorByName(name);
        if (vendor == null) {
            System.out.println("\nVendor not found.\n");
            return;
        }

        List<menuItem> menu = vendor.getMenu();
        if (menu.isEmpty()) {
            System.out.println("\nNo menu items available.\n");
        } else {
            System.out.println("\nMenu for " + vendor.getName() + ":");
            for (menuItem item : menu) {
                System.out.println("- " + item.getName() +
                                   " \nPrice: $" + item.getPrice() +
                                   "\nIngredients: " + item.getIngredients() + "\n");
            }
        }
    }

    public void placeOrder(String vendorName, Scanner scanner) {
        Vendor vendor = getVendorByName(vendorName);
        if (vendor == null) {
            System.out.println("Vendor not found.");
            return;
        }

        searchVendor(vendorName);
        List<menuItem> menu = vendor.getMenu();
        List<menuItem> selectedItems = new ArrayList<>();

        while (true) {
            System.out.print("Enter item name to add (or type 'done' to finish): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) break;

            menuItem matchedItem = searchForItemInMenu(menu, input);

            for (menuItem item : menu) {
                if (item.getName().equalsIgnoreCase(input)) {
                    matchedItem = item;
                    break;
                }
            }

            if (matchedItem != null) {
                selectedItems.add(matchedItem);
                System.out.println(matchedItem.getName() + " added.");
            } else {
                System.out.println("Item not found. Please enter a valid item name.");
            }
        }

        if (selectedItems.isEmpty()) {
            System.out.println("==================================================");
            System.out.println("No items selected. Order cancelled.");
            System.out.println("==================================================");
            return;
        }

        Order newOrder = new Order(vendorName, selectedItems, "Received", this.name);
        orders.add(newOrder);
        Main.orderManager.addOrder(newOrder);
        System.out.println("Order placed! Order details:");
        newOrder.printOrder();
    }

    public void viewOrderStatus(int orderNum) {
        if (orders.isEmpty()) {
            System.out.println("==================================================");
            System.out.println("You have not placed any orders yet.");
            System.out.println("==================================================");
            return;
        }

        Order order = getOrderById(orderNum);

        if (order == null) {
            System.out.println("==================================================");
            System.out.println("Invalid Order Number!");
            System.out.println("==================================================");
            return;
        }

        order.printOrder();
    }

    public menuItem searchForItemInMenu(List<menuItem> menu, String inputItem) {
        for (menuItem item : menu) {
            if (item.getName().equalsIgnoreCase(inputItem)) {
                return item;
            }
        }
        return null;
    }

    public Order getOrderById(int orderNum) {
        for (Order order : this.orders) {
            if (order.getOrderId() == orderNum) {
                return order;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    private Vendor getVendorByName(String name) {
        for (Vendor v : Main.vendorList) {
            if (v.getName().equalsIgnoreCase(name)) {
                return v;
            }
        }
        return null;
    }
}
