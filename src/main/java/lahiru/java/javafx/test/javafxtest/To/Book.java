package lahiru.java.javafx.test.javafxtest.To;

public class Book {
    private String id;
    private String name;
    private String isbm;
    private int qty;

    public Book() {
    }

    public Book(String id, String name, String isbm, int qty, double price) {
        this.id = id;
        this.name = name;
        this.isbm = isbm;
        this.qty = qty;
        this.price = price;
    }

    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbm() {
        return isbm;
    }

    public void setIsbm(String isbm) {
        this.isbm = isbm;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
