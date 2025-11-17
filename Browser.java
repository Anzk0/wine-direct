public class Browser {

    private int iD;               
    private int yearOfBirth;    
    private String email;         
    private boolean isBuyer;      
    private WineCase wineCase;    
    private Website website;     

    // Constructor for existing buyers (already have an ID)
    public Browser(int yearOfBirth, String email, int iD) {
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.iD = iD;
        this.isBuyer = true;      // Already a buyer
        this.wineCase = null;
        this.website = null;
    }

    // Constructor for new browsers (no ID yet)
    public Browser(int yearOfBirth, String email) {
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.iD = 0;             
        this.isBuyer = false;    
        this.wineCase = null;
        this.website = null;
    }

    // Accessors and Mutators
    public int getiD() { return iD; }
    public void setiD(int iD) { this.iD = iD; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean getIsBuyer() { return isBuyer; }
    public void setBuyerStatus(boolean isBuyer) { this.isBuyer = isBuyer; }

    public WineCase getWineCase() { return wineCase; }
    public void setWineCase(WineCase wineCase) { this.wineCase = wineCase; }

    public Website getWebsite() { return website; }
    public void setWebsite(Website website) { this.website = website; }

    // Calculate age based on current year
    public int getAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - yearOfBirth;
    }

    // Select a wine case (only if browser is a buyer)
    public void selectWineCase(WineCase wineCase) {
        if (!isBuyer) {
            System.out.println("Only registered buyers can select wine.");
            return;
        }

        this.wineCase = wineCase;

        System.out.println("Buyer with ID " + iD + " has selected wine case with reference number "
                + wineCase.getRefNo() + ", " + wineCase.getDescription() + " of "
                + wineCase.getNoOfBottles() + " bottles at £" + wineCase.getPrice());
    }

    // Pay for the wine case via the website
    public void payForWine() {
        if (website != null) {
            website.checkout(this);
        } else {
            System.out.println("Browser is not logged into a website.");
        }
    }

    // Helper method to become a buyer when approved by website
    public void becomeBuyer(int newID) {
        this.iD = newID;
        setBuyerStatus(true); 
        System.out.println("Browser with email " + email + " is now a buyer with ID " + iD);
    }

    // Helper to check if browser is eligible for 10% discount
    public boolean isDiscountEligible() {
        if (website != null) {
            return website.checkHitDiscount();
        }
        return false;
    }
}

