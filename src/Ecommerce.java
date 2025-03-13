import java.util.ArrayList;
import java.util.List;

class Product {
    String productName;
    int productPrice;

    Product(String productName, int price) {
        this.productName = productName;
        this.productPrice = price;
    }

    void printProductDetails() {
        System.out.println("Name : " + productName);
        System.out.println("productPrice : " + productPrice);
    }
}

class Order {
    private String orderId;
    List<Product> products;

    Order(String orderId) {
        this.orderId = orderId;
        products = new ArrayList<>();
    }

    String getOrderId() {
        return (orderId);
    }

    void addProducts(Product p) {
        products.add(p);
    }
}

class EcomCustomer {
    String name;
    private String customerId;
    List<Order> orders;

    EcomCustomer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        orders = new ArrayList<>();
    }

    void placeOrder(Order o) {
        orders.add(o);
    }

    void printOrderDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println("  Order ID: " + order.getOrderId());
            System.out.println("  Products:");
            for (Product product : order.products) {
                System.out.println("    - " + product.productName + " ($" + product.productPrice + ")");
            }
        }
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("Laptop", 1200);
        Product product2 = new Product("Mouse", 25);
        Product product3 = new Product("Keyboard", 50);

        // Create orders
        Order order1 = new Order("ORD1001");
        order1.addProducts(product1);
        order1.addProducts(product2);

        Order order2 = new Order("ORD1002");
        order2.addProducts(product3);

        // Create customer
        EcomCustomer customer1 = new EcomCustomer("Alice", "CUST001");

        // Place orders
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        // Print customer order details
        customer1.printOrderDetails();
    }
}