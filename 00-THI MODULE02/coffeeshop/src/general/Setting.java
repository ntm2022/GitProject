package general;

import java.util.Date;
//COMMON CONSTANTS
public class Setting {//Read-Only
    public static final String FILE_PATH_ORDERINGS = "orderings.csv";
    public static final String FILE_PATH_RECEIPTS = "receipts.csv";
    public static final String FILE_PATH_STAFFS = "staffs.csv";
    public static final String FILE_PATH_STORAGES = "storages.csv";
    public static final String DATE_FORMAT = "dd-MM-yyyy H:m:s";

    public Setting() {//Singleton
    }
    public static Date trimDate(Date d){//trim H:m:s
        Date result = new Date();
        result.setDate(d.getDate());
        result.setMonth(d.getMonth());
        result.setYear(d.getYear());

        return result;
    }

    //xu ly so CCCD bang REGEX
    public static boolean getCCCD(String cccd){
        /*
        - 03 chữ số đầu tiên là mã tỉnh, thành phố trực thuộc trung ương hoặc mã quốc gia nơi công dân đăng ký khai sinh,
        - 01 chữ số tiếp theo là mã giới tính của công dân.
        - 02 chữ số tiếp theo là mã năm sinh của công dân;
        - 06 chữ số cuối là khoảng số ngẫu nhiên.
         */

        return true;
    }
}
