
public class WineCase {
    private String refNo;
    private String description;
    private int noOfBottles;
    private double price;

    public WineCase(String refNo, String description, int noOfBottles, double price) {
        this.refNo = refNo;
        this.description = description;
        this.noOfBottles = noOfBottles;
        this.price = price;
    }

    public String getRefNo() { return refNo; }
    public String getDescription() { return description; }
    public int getNoOfBottles() { return noOfBottles; }
    public double getPrice() { return price; }
}
