package com.codegym;
import java.util.Date;

public class StopWatch {
/*    Trường startTime và endTime là private với phương thức getter để trả về giá trị của startTime và endTime.*/
    private Date startTime;
    private Date endTime;

    public Date getStartTime(){return this.startTime;}
    public Date getEndTime(){return this.endTime;}

    /*Phương thức khởi tạo không tham số khởi tạo startTime với thời gian hiện tại của hệ thống.*/
    public StopWatch(){
        this.startTime = new Date();
    }

    /*Phương thức start() để reset startTime về thời gian hiện tại của hệ thống.*/
    public void start(){
        this.startTime = new Date();
    }

    /*Phương thức stop() để thiết đặt endTime về thời gian hiện tại của hệ thống.*/
    public void stop(){
        this.endTime = new Date();
    }

    /*Phương thức getElapsedTime() trả về thời gian đã trôi qua theo số milisecond giây*/
    public long getElapsedTime(){
        /*long estimatedTime = System.currentTimeMillis() - startTime;*/
        return this.endTime.getTime() -this.startTime.getTime();
    }
    /*Vẽ sơ đồ UML cho lớp StopWatch và cài đặt lớp.*/
}
