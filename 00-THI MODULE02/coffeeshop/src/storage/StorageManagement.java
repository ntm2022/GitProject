package storage;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static general.Setting.*;

public class StorageManagement{
    private List<Storage> storages;
    private String filePath = FILE_PATH_STORAGES;
    DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    private static storage.StorageManagement storageManagement = new StorageManagement();
    public static StorageManagement getStorageManagement(){return storageManagement;}

    private StorageManagement() {
        storages = new ArrayList<>();
        readFromFile();
    }

    public int add(Storage storage){
        storages.add(storage);
        saveToFile();
        return storage.getSku();
    }
    public int update(int sku, Storage newStorage){
        if(searchByID(sku)!=null){
            storages.set(storages.indexOf(searchByID(sku)), newStorage );
            saveToFile();
            return newStorage.getSku();
        }else{
            return 0;
        }
    }
    public boolean remove(int sku){
        if(searchByID(sku)!=null){
            storages.remove(searchByID(sku));
            saveToFile();
            return true;
        }else{return false;}
    }
    public Storage searchByID(int sku){
        for (Storage s:storages){
            if(s.getSku() == sku)
                return s;
        }
        return null;
    }
    public Storage searchByName(String name){
        for (Storage s:storages){
            if(s.getName().equals(name))
                return s;
        }
        return null;
    }

    public List<Storage> searchWarnings(){
        List<Storage> list = new ArrayList<>();
        for (Storage s:storages){
            if(s.getQuantity() <= 2)
                list.add(s);
        }
        return list;
    }
    public void readFromFile(){
        storages.clear();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null){
                storages.add(xuLyLine(line));
            }
            reader.close();
        }catch(Exception e){
            System.out.println("File " + filePath + " rong!");
        }
    }
    public Storage xuLyLine(String line){
        String[] result = line.split(",");

        Storage newStorage = null;
        //(int sku, String name, double quantity, String unit, double importPrice, String supplierInfo, Date createdAt, Date updatedAt)
        try {
            newStorage = new Storage(Integer.parseInt(result[0]), result[1], Double.parseDouble(result[2]),result[3]
                    , Double.parseDouble(result[4]), result[5], simpleDateFormat.parse(result[6]) , simpleDateFormat.parse(result[7]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newStorage;
    }
    public synchronized void saveToFile(){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Storage storage: storages){
                writer.write(storage.getSku() + "," + storage.getName() + ","
                        + storage.getQuantity() + "," + storage.getUnit() + ","
                        + storage.getImportPrice() + "," + storage.getSupplierInfo() + ","
                        + simpleDateFormat.format(storage.getCreatedAt()) + "," + simpleDateFormat.format(storage.getUpdatedAt())
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

    @Override
    public String toString() {
        String viewALL = "";
        for(Storage s: storages){
            viewALL += s + "\n";
        }
        return viewALL;
    }
}