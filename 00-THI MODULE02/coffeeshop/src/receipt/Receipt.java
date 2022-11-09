package receipt;

import ordering.OrderingManagement;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Receipt {
    private int receiptNO;
    private int staffID;//nên thêm fields name => có trường hợp >1 cashier. Dữ liệu nhân viên trực ca sẽ lưu trong máy chấm công vân tay
    private Date createdAt;
    private Date updatedAt;
    private double total;
    private double cash;
    private double change; //tien thoi lai
    private Map<Integer,Integer> orders;
    OrderingManagement orderingManagement = OrderingManagement.getOrderingManagement();

    //danh sach orderings va so luong-> toi uu phai tao class rieng vi du: OrderingDetails
    public Receipt() {
    }

    public Receipt(int receiptNO, int staffID, Date createdAt, Date updatedAt, double total, double cash, double change,Map<Integer, Integer> orders) {
        this.receiptNO = receiptNO;
        this.staffID = staffID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.total = total;
        this.cash = cash;
        this.change = change;
        this.orders = orders;
    }
    public int getReceiptNO() {
        return receiptNO;
    }

    public void setReceiptNO(int receiptNO) {
        this.receiptNO = receiptNO;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
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

    public Map<Integer, Integer> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Integer> orders) {
        this.orders = orders;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
    public String ordersToString(Map orders){
        String result, name;
        double price, quantity, total, tax;

        Set<Integer> keys = orders.keySet();
        result = "{";
        int i = 0;
        for(Integer key:keys){
            name = orderingManagement.searchByID(key).getName();
            quantity = Double.parseDouble(orders.get(key) +"");
            price = orderingManagement.searchByID(key).getPrice();
            total = price * quantity;
            tax = orderingManagement.searchByID(key).getTax();

            result += "\nitem " + ++i + "." + name + " = " + quantity + " Đơn giá: " + price + " Thành tiền: " + total + " VAT: " + tax;

        }
        result= result.substring(0,result.length()-1);//phan tu cuoi cung se du dau ","
        result += "\n}";
        return result;
    }

    @Override
    public String toString() {
        return  "\n-receiptNO=" + receiptNO +
                "\n-staffID=" + staffID +
                "\n-createdAt=" + createdAt +
                "\n-updatedAt=" + updatedAt +
                "\n-total=" + total +
                "\n-cash=" + cash +
                "\n-change=" + change +
                "\n-orders=" + ordersToString(orders);
    }
}