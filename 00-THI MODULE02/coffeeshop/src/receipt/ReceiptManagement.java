package receipt;

import ordering.OrderingManagement;
import storage.StorageManagement;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static general.Setting.*;

public class ReceiptManagement{
    private List<Receipt> receipts;
    private String filePath = FILE_PATH_RECEIPTS;
    DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    //hien thi danh sach toan bo don hang
    //hien thi thanh tien TOTAL cho moi receipt

    private static ReceiptManagement receiptManagement = new ReceiptManagement();
    public static ReceiptManagement getReceiptManagement(){return receiptManagement;}
    StorageManagement storageManagement = StorageManagement.getStorageManagement();
    OrderingManagement orderingManagement = OrderingManagement.getOrderingManagement();
    private ReceiptManagement() {
        receipts = new ArrayList<>();
        readFromFile();
    }

    public int add(Receipt receipt){
        receipts.add(receipt);
        saveToFile();
        //tru ton kho
        updateStorage(receipt.getReceiptNO());
        //update Storage
        storageManagement.saveToFile();
        return receipt.getReceiptNO();
    }
    public void updateStorage(int receiptNO){
        //(int sku, String name, double quantity, String unit, double importPrice, String supplierInfo, Date createdAt, Date updatedAt)
        int sku, orderID;
        double quantity;

        Map<Integer,Integer> orders = receiptManagement.searchByID(receiptNO).getOrders();

        //orders{orderID=quantity} => sku
        Set<Integer> keys = orders.keySet();
        for(Integer key : keys){
            orderID = key;
            sku = orderingManagement.searchByID(orderID).getSku();
            //storage.quantity - ordering.quantity * orders.quantity
            quantity = storageManagement.searchByID(sku).getQuantity() - orderingManagement.searchByID(orderID).getQuantity() * orders.get(key);
            storageManagement.searchByID(sku).setQuantity(quantity); //đây là mục đích chính của hàm updateStorage()
        }

    }
    public int update(int id, Receipt newReceipt){
        if(searchByID(id)!=null){
            receipts.set(receipts.indexOf(searchByID(id)), newReceipt );
            saveToFile();
            return newReceipt.getReceiptNO();
        }else{
            return 0;
        }
    }
    public boolean remove(int id){
        if(searchByID(id)!=null){
            receipts.remove(searchByID(id));
            saveToFile();
            return true;
        }else{return false;}
    }
    public Receipt searchByID(int id){
        for (Receipt s:receipts){
            if(s.getReceiptNO() == id)
                return s;
        }
        return null;
    }
    public List<Receipt> searchByStaffID(int id){
        List<Receipt> list = new ArrayList<>();
        for (Receipt s:receipts){
            if(s.getStaffID() == id)
                list.add(s);
        }
        return list;
    }
    public List<Receipt> searchByDate(Date createdAt){
        List<Receipt> list = new ArrayList<>();
        Date date1, date2 =null;
        date2 = trimDate(createdAt);

        for (Receipt s:receipts){
            date1 = trimDate(s.getCreatedAt());
            if(date1.equals(date2))
                list.add(s);
        }
        return list;
    }
    public void readFromFile(){
        receipts.clear();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null){
                receipts.add(xuLyLine(line));

            }
            reader.close();
        }catch(Exception e){
            System.out.println("File " + filePath + " rong!");
        }
    }
    public Receipt xuLyLine(String line){
        String[] s1 = line.split("[{]");//trim {
        line = s1[0];
        String[] s2 = s1[1].split("[}]");//trim }
        String sMap = s2[0];//mang orders


        String[] keyValuePairs = sMap.split(",");              //split the string to creat key-value pairs
        Map<Integer,Integer> map = new HashMap<>();

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {
            String[] entry = pair.split("=");                   //split the pairs to get key and value
            map.put(Integer.parseInt(entry[0].trim()), Integer.parseInt(entry[1].trim()));          //add them to the hashmap and trim whitespaces
        }

        String[] result = line.split(",");


        Receipt newReceipt = null;
        //(int receiptNO, int staffID, Date createdAt, Date updatedAt, double total, double cash, double changeMap<Ordering, Integer> orders)
        try {
            newReceipt = new Receipt(Integer.parseInt(result[0]), Integer.parseInt(result[1])
                    , simpleDateFormat.parse(result[2]), simpleDateFormat.parse(result[3])
                    , Double.parseDouble(result[4])
                    , Double.parseDouble(result[5]), Double.parseDouble(result[6])
                    ,map
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newReceipt;
    }
    synchronized void saveToFile(){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            //(int receiptNO, int staffID, Date createdAt, Date updatedAt, double total, double cash, double change,Map<Ordering, Integer> orderingMap)
            Set<Integer> keys;
            for(Receipt receipt: receipts){
                writer.write(receipt.getReceiptNO() + "," + receipt.getStaffID() + ","
                        + simpleDateFormat.format(receipt.getCreatedAt()) + ","
                        + simpleDateFormat.format(receipt.getUpdatedAt()) + ","
                        + receipt.getTotal() + "," + receipt.getCash() + "," + receipt.getChange() + ","
                        + receipt.getOrders()
                );
                writer.newLine();
            }//end for
            writer.close();
            System.out.println("Saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        readFromFile();//cap nhat receipts
    }

    @Override
    public String toString() {
        String viewAll = "";
        int i = 0;
        for(Receipt receipt: receipts){
            viewAll += "\n**************" +
                       "\n*  Receipt " + ++i + " *"
                     + "\n**************"
                     + "\n" + receipt.toString() + "\n";
        }
        return viewAll;
    }
}
