import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    private final int orderId;
    private String customerName;
    private String vendorName;
    private List<menuItem> items;
    private double totalPrice;
    private String status;

    public Order(String vendorName, List<menuItem> items, String status) {
        this(vendorName, items, status, "Unknown Customer");
    }

    public Order(String vendorName, List<menuItem> items, String status, String customerName) {
        this.orderId = idGenerator.getAndIncrement();
        this.vendorName = vendorName;
        this.items = new ArrayList<>(items);
        this.status = status;
        this.customerName = customerName;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        double total = 0.0;
        for (menuItem item : this.items) {
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

    public String getCustomerName() {
        return customerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printOrder() {
        System.out.println("==================================================");
        System.out.printf("Order ID   : %d\n", orderId);
        System.out.printf("Customer   : %s\n", customerName);
        System.out.printf("Vendor     : %s\n", vendorName);
        System.out.println("Items Ordered:");
        for (menuItem item : items) {
            System.out.printf("  - %s ($%.2f)\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total      : $%.2f\n", totalPrice);
        System.out.printf("Status     : %s\n", status);
        System.out.println("==================================================");
    }
}
