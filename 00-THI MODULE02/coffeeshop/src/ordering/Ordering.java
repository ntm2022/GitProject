package ordering;

import java.util.Date;

public class Ordering {
    private int orderID;
    private String name;
    private double price;
    private double quantity;
    private double tax;
    private int sku;
    private boolean isAvailable;
    private Date createdAt;
    private Date updatedAt;

    public Ordering() {
    }

    public Ordering(int orderID, String name, double price, double quantity, double tax, int sku, boolean isAvailable, Date createdAt, Date updatedAt) {
        this.orderID = orderID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
        this.sku = sku;
        this.isAvailable = isAvailable;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "\nOrdering{" +
                "orderID=" + orderID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", tax=" + tax +
                ", sku=" + sku +
                ", isAvailable=" + isAvailable +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ",}";
    }
}