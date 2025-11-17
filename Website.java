import java.util.Random;

public class Website {

    private String name;
    private int hits;        // number of buyers who logged in
    private double salesTotal;

    // Constructor
    public Website(String name) {
        this.name = name;
        this.hits = 0;
        this.salesTotal = 0.0;
    }

    // Accessors and Mutators
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHits() { return hits; }
    public void setHits(int hits) { this.hits = hits; }

    public double getSalesTotal() { return salesTotal; }
    public void setSalesTotal(double salesTotal) { this.salesTotal = salesTotal; }

    // Buyer logs in
    public void buyerLogin(Browser browser) {
        hits++; // increment number of hits
        browser.setWebsite(this); // link browser to this website
        System.out.println(name + " welcomes buyer " + browser.getiD() + ", you are now logged in.");
    }

    // New browser becomes buyer
    public void becomeBuyer(Browser browser) {
        if (browser.getAge() >= 18) {
            // assign random ID
            Random rand = new Random();
            int newID = rand.nextInt(9000) + 1000; // 1000-9999
            browser.becomeBuyer(newID);
            buyerLogin(browser);
        } else {
            System.out.println("Browser with email " + browser.getEmail() + " is not old enough to buy wine.");
        }
    }

    // Checkout process
    public void checkout(Browser browser) {
        WineCase selectedWine = browser.getWineCase();
        if (selectedWine == null) {
            System.out.println("No wine case selected. Cannot complete checkout.");
            return;
        }

        double price = selectedWine.getPrice();
        // Apply discount if eligible
        if (checkHitDiscount()) {
            price = price * 0.9; // 10% discount
            System.out.println("Congratulations! Buyer " + browser.getiD() + " receives a 10% discount.");
        }

        salesTotal += price;

        System.out.println("Buyer " + browser.getiD() + " has successfully purchased wine case "
                + selectedWine.getRefNo() + " for £" + price);

        // Clear browser's website reference to log them out
        browser.setWebsite(null);
        browser.setWineCase(null);
    }

    // Check if current buyer gets 10% discount
    public boolean checkHitDiscount() {
        return hits % 10 == 0;
    }
}
