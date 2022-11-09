package storage;

import java.util.Date;

public class Storage {
    private int sku;//Stock Keeping Unit
    private String name;
    private double quantity;
    private String unit;
    private double importPrice;//on each units
    private String supplierInfo;
    private Date createdAt;
    private Date updatedAt;

    public Storage(int sku, String name, double quantity, String unit, double importPrice, String supplierInfo, Date createdAt, Date updatedAt) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.importPrice = importPrice;
        this.supplierInfo = supplierInfo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Storage() {
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public String getSupplierInfo() {
        return supplierInfo;
    }

    public void setSupplierInfo(String supplierInfo) {
        this.supplierInfo = supplierInfo;
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

    public void setUpdatedDate(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "\nStorage{" +
                "sku=" + sku +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", importPrice=" + importPrice +
                ", supplierInfo='" + supplierInfo + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ",}";
    }
}
