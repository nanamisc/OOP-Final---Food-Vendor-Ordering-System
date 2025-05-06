import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> allOrders = new ArrayList<>();

    public void addOrder(Order order) {
        allOrders.add(order);
        System.out.println("==================================================");
        System.out.println("Order #" + order.getOrderId() + " added to system.");
        System.out.println("==================================================");
    }

    public void viewCurrentOrders() {
        if (allOrders.isEmpty()) {
            System.out.println("==================================================");
            System.out.println("No orders available.");
            System.out.println("==================================================");
            return;
        }
        System.out.println("==================================================");
        System.out.println("ALL CURRENT ORDERS");
        for (Order order : allOrders) {
            order.printOrder();
        }
    }

    public void markOrderStatus(int orderId, int statusOption) {
        if (allOrders.isEmpty()) {
            System.out.println("==================================================");
            System.out.println("No orders available.");
            System.out.println("==================================================");
            return;
        }

        String[] statuses = {"Received", "In Progress", "Ready for Pickup", "Completed"};
        for (Order order : allOrders) {
            if (order.getOrderId() == orderId) {
                if (statusOption >= 1 && statusOption <= statuses.length) {
                    order.setStatus(statuses[statusOption - 1]);
                    System.out.println("==================================================");
                    System.out.println("Order #" + orderId + " status updated to: " + order.getStatus());
                    System.out.println("==================================================");
                } else {
                    System.out.println("Invalid status option.");
                }
                return;
            }
        }
        System.out.println("==================================================");
        System.out.println("Order ID not found.");
        System.out.println("==================================================");
    }

    public void cancelOrder(int orderId) {
        if (allOrders.isEmpty()) {
            System.out.println("==================================================");
            System.out.println("No orders available.");
            System.out.println("==================================================");
            return;
        }

        for (Order order : allOrders) {
            if (order.getOrderId() == orderId) {
                order.setStatus("Canceled");
                System.out.println("==================================================");
                System.out.println("Order #" + orderId + " has been canceled.");
                System.out.println("==================================================");
                return;
            }
        }
        System.out.println("==================================================");
        System.out.println("Order ID not found.");
        System.out.println("==================================================");
    }

    public boolean isEmpty() {
        return allOrders.isEmpty();
    }
}
