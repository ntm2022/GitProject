package staff;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static general.Setting.*;

public class StaffManagement{
    private List<Staff> staffs;
    private String filePath = FILE_PATH_STAFFS;
    DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

    private static StaffManagement StaffManagement = new StaffManagement();
    public static StaffManagement getStaffManagement(){return StaffManagement;}

    private StaffManagement() {
        staffs = new ArrayList<>();
        readFromFile();
    }
    
    public int add(Staff staff){
        staffs.add(staff);
        saveToFile();
        return staff.getStaffID();
    }
    public int update(int id, Staff newStaff){
        if(searchByID(id)!=null){
            staffs.set(staffs.indexOf(searchByID(id)), newStaff );
            saveToFile();
            return newStaff.getStaffID();
        }else{
            return 0;
        }
    }
    public boolean remove(int id){
        if(searchByID(id)!=null){
            staffs.remove(searchByID(id));
            saveToFile();
            return true;
        }else{return false;}
    }
    public Staff searchByID(int id){
        for (Staff s:staffs){
            if(s.getStaffID() == id)
                return s;
        }
        return null;
    }
    public List<Staff> searchByName(String name){
        List<Staff> list = new ArrayList<>();//truong hop co nhieu nhan vien trung ten

        for (Staff s:staffs){
            if(s.getName().equals(name))
                list.add(s);
        }
        return list;
    }
    public Staff searchByCCCD(String cccd){
        for (Staff s:staffs){
            if(s.getCccd().equals(cccd))
                return s;
        }
        return null;
    }
    public void readFromFile(){
        staffs.clear();
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null){
                staffs.add(xuLyLine(line));
            }
            reader.close();
        }catch(Exception e){
            System.out.println("File " + filePath + " rong!");
        }
    }
    public Staff xuLyLine(String line){
        String[] result = line.split(",");

        Staff newStaff = null;
        try {
            newStaff = new Staff(Integer.parseInt(result[0]), result[1], result[2],simpleDateFormat.parse(result[3])
                    , simpleDateFormat.parse(result[4]), simpleDateFormat.parse(result[5]), simpleDateFormat.parse(result[6]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return newStaff;
    }
    synchronized void saveToFile(){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Staff staff: staffs){
                writer.write(staff.getStaffID() + "," + staff.getName() + ","
                        + staff.getCccd() + ","
                        + simpleDateFormat.format(staff.getDoB()) + ","
                        + simpleDateFormat.format(staff.getStartJobDate()) + ","
                        + simpleDateFormat.format(staff.getCreatedAt()) + ","
                        + simpleDateFormat.format(staff.getUpdatedAt())
                );
                writer.newLine();
            }
            writer.close();
            System.out.println("Saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        readFromFile();//cap nhat staffs
    }

    @Override
    public String toString() {
        String viewALL = "";
        for(Staff s: staffs){
            viewALL += s + "\n";
        }
        return viewALL;
    }
}