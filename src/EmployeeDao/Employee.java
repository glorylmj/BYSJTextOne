package EmployeeDao;

public class Employee {
    private String ID;
    private String ename;
    private String esales;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsales() {
        return esales;
    }

    public void setEsales(String esales) {
        this.esales = esales;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", ename='" + ename + '\'' +
                ", esales='" + esales + '\'' +
                '}';
    }
}
