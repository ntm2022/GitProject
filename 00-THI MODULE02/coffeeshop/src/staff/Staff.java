package staff;

import java.util.Date;

public class Staff {
    private int staffID;
    private String name;
    private String cccd;
    private Date doB;
    private Date startJobDate;
    private Date createdAt;
    private Date updatedAt;

    public Staff() {
    }

    public Staff(int staffID, String name, String cccd, Date doB, Date startJobDate, Date createdAt, Date updatedAt) {
        this.staffID = staffID;
        this.name = name;
        this.cccd = cccd;
        this.doB = doB;
        this.startJobDate = startJobDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public Date getStartJobDate() {
        return startJobDate;
    }

    public void setStartJobDate(Date startJobDate) {
        this.startJobDate = startJobDate;
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

    @Override
    public String toString() {
        return "\nStaff{" +
                "\nstaffID=" + staffID +
                "\n fullName='" + name + '\'' +
                "\n cccd='" + cccd + '\'' +
                "\n doB=" + doB +
                "\n startJobDate=" + startJobDate +
                "\n createdAt=" + createdAt +
                "\n updatedAt=" + updatedAt +
                "\n}";
    }
}