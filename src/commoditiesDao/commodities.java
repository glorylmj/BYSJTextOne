package commoditiesDao;

public class commodities {
    private int ID;
    private String name;
    private  int sales;
    private int inventory;
    private double price;
    private String source;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "commodities{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", sales=" + sales +
                ", inventory=" + inventory +
                ", price=" + price +
                ", source=" + source +
                '}';
    }
}
