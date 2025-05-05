import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    private final int orderId;
    private String vendorName;
    private List<menuItem> items;
    private double totalPrice;
    private String status;

    public Order(String vendorName, List<menuItem> items, String status) {
        this.orderId = idGenerator.getAndIncrement(); // assign unique ID
        this.vendorName = vendorName;
        this.items = new ArrayList<>(items);
        this.status = status;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double total = 0.0;
        for(menuItem item: this.items){
            total += item.getPrice();
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public List<menuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Vendor: " + vendorName);
        for (menuItem item : items) {
            System.out.println("  - " + item.getName() + " ($" + item.getPrice() + ")");
        }
        System.out.printf("Total: $%.2f\n", totalPrice);
        System.out.println("Status: " + status);
        System.out.println("-------------------------");
    }
}
