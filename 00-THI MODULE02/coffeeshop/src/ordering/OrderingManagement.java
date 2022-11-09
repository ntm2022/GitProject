package ordering;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static general.Setting.*;

public class OrderingManagement{
    private List<Ordering> orderings;
    private String filePath = FILE_PATH_ORDERINGS;
    DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    private static OrderingManagement orderingManagement = new OrderingManagement();
    public static OrderingManagement getOrderingManagement(){return orderingManagement;}

    private OrderingManagement() {
        orderings = new ArrayList<>();
        readFromFile();
    }
    public Ordering searchByID(int id){
        for (Ordering s:orderings){
            if(s.getOrderID() == id)
                return s;
        }
        return null;
    }
    public List<Ordering> searchByName(String name){
        List<Ordering> list = new ArrayList<>();
        for (Ordering s:orderings){
            if(s.getName().contains(name))
                list.add(s);
        }
        return list;
    }
    public Ordering searchByDate(Date createdAt){
        for (Ordering s:orderings){
            if(trimDate(s.getCreatedAt()).equals(trimDate(createdAt)))
                return s;
        }
        return null;
    }
    public int add(Ordering ordering){
        orderings.add(ordering);
        saveToFile();
        return ordering.getOrderID();
    }
    public int update(int id, Ordering newOrdering){
        if(searchByID(id)!=null){
            orderings.set(orderings.indexOf(searchByID(id)), newOrdering );
            saveToFile();
            return newOrdering.getOrderID();
        }else{
            return 0;
        }
    }
    public boolean remove(int id){
        if(searchByID(id)!=null){
            orderings.remove(searchByID(id));
            saveToFile();
            return true;
        }else{return false;}
    }
    public List<Ordering> top3(List<Ordering> sortedList){
        List<Ordering> top3 = new ArrayList<>();
        int size = sortedList.size();
        top3.add(sortedList.get(0));
        top3.add(sortedList.get(1));
        top3.add(sortedList.get(2));
        //hoac co the sap xep TANG DAN roi lay 03 phan tu CUOI bang addAll(list, size - 4)

        return top3;
    }
    public List<Ordering> sortByPrice(boolean isUp){
        List<Ordering> list = new ArrayList<>();
        //clone
        for(Ordering o:orderings){
            list.add(o);
        }
        //sort theo Price
        if(isUp){
            list.sort(Comparator.comparingDouble(Ordering::getPrice));//TANG DAN
        }else{
            list.sort(Comparator.comparingDouble(Ordering::getPrice).reversed());//GIAM DAN
        }

        return list;
    }
    public List<Ordering> sortByAvailable(boolean isUp){
        List<Ordering> list = new ArrayList<>();
        //clone
        for(Ordering o:orderings){
            list.add(o);
        }
        //sort theo Price
        if(isUp){
            list.sort(Comparator.comparing(Ordering::isAvailable));//TANG DAN
        }else{
            list.sort(Comparator.comparing(Ordering::isAvailable).reversed());//GIAM DAN
        }

        return list;
    }
    synchronized void saveToFile(){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Ordering ordering: orderings){
                writer.write(ordering.getOrderID() + "," + ordering.getName() + ","
                        + ordering.getPrice() + "," + ordering.getQuantity() + "," + ordering.getTax() + ","
                        + ordering.getSku() + "," + ordering.isAvailable() + ","
                        + simpleDateFormat.format(ordering.getCreatedAt()) + ","
                        + simpleDateFormat.format(ordering.getUpdatedAt())
                );
                writer.newLine();
            }
            writer.close();
            System.out.println("Saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        readFromFile();//cap nhat storages
    }
    public void appendToFile(){

    }
    public void readFromFile(){
        orderings.clear();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null){
                orderings.add(xuLyLine(line));
            }
            reader.close();
        }catch(Exception e){
            System.out.println("File " + filePath + " rong!");
        }
    }
    public Ordering xuLyLine(String line){
        String[] result = line.split(",");

        Ordering newOrdering = null;
        //(int orderID, String name, double price, double quantity, double tax, int sku, boolean isAvailable, Date createdAt, Date updatedAt)
        try {
            newOrdering = new Ordering(Integer.parseInt(result[0]), result[1], Double.parseDouble(result[2])
                    , Double.parseDouble(result[3]), Double.parseDouble(result[4]), Integer.parseInt(result[5]), Boolean.parseBoolean(result[6])
                    , simpleDateFormat.parse(result[7]), simpleDateFormat.parse(result[8])
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newOrdering;
    }
    public List<Ordering> getAvailableOrderings(){
        return null;
    }
    public List<Ordering> getNotOrderings(){
        return null;
    }

    public String toString() {
        String viewALL = "";
        for(Ordering s: orderings){
            viewALL += s + "\n";
        }
        return viewALL;
    }
}
