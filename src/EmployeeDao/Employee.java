package EmployeeDao;

public class Employee {
    private String ID;
    private String username;
    private int esales;
    private String comname;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getEsales() {
        return esales;
    }

    public void setEsales(int esales) {
        this.esales = esales;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", esales='" + esales + '\'' +
                ", comname='" + comname + '\'' +
                '}';
    }
}
