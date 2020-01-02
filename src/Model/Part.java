package Model;

public abstract class Part {

    // Part Members (protected b/c InHouse and Outsourced will inherit from Part)
    protected int partID;
    protected String partName;
    protected double partPrice;
    protected int partStock;
    protected int partMin;
    protected int partMax;

    // Part Getters
    public int getPartID() {
        return partID;
    }
    public String getPartName() {
        return partName;
    }
    public double getPartPrice() {
        return partPrice;
    }
    public int getPartStock() {
        return partStock;
    }
    public int getPartMin() {
        return partMin;
    }
    public int getPartMax() {
        return partMax;
    }

    // Part Setters
    public void setPartID(int partID) {
        this.partID = partID;
    }
    public void setPartName(String partName) {
        this.partName = partName;
    }
    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }
    public void setPartStock(int partStock) {
        this.partStock = partStock;
    }
    public void setPartMin(int partMin) {
        this.partMin = partMin;
    }
    public void setPartMax(int partMax) {
        this.partMax = partMax;
    }
}
