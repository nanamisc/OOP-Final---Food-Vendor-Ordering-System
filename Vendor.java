import java.io.*;
import java.util.*;

public class Vendor {
    private String name;
    private List<menuItem> menu;//list that holds menuitems
    public Vendor(String name){
        this.name=name;
        this.menu=new ArrayList<>();

    }
    
    public void createMenu(List<menuItem> items){
        menu=items;
        System.out.print("New Menu Created for " + name);

    }

    public void addItem(menuItem item){
        menu.add(item);
        System.out.println("New item has been added to " + name + "'s menu.");

    }

    public void editItem(String itemName, double newPrice, String newIngredients) {
        for (int i = 0; i < menu.size(); i++) {
            menuItem item = menu.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setPrice(newPrice);
                item.setIngredients(newIngredients);
                System.out.println("Item has been updated.");
                return;
            }
        }
        System.out.println("Item does not exist");
    }

    public void deleteItem(String itemName){
        for (int i = 0; i < menu.size(); i++) {
            menuItem item = menu.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                menu.remove(i);
                System.out.println("Item has been deleted from the menu");
                return;
            }
        }
        System.out.println("Item does not exist");

    }
}
