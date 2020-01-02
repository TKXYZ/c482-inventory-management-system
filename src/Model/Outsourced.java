package Model;

public class Outsourced extends Part {

    // Outsourced Members
    private String compName;

    // Outsourced Constructor (overrides Part's constructor, adding compName)
    public Outsourced(int partID, String partName, double partPrice, int partStock, int partMin, int partMax, String compName) {
        this.setPartID(partID);
        this.setPartName(partName);
        this.setPartPrice(partPrice);
        this.setPartStock(partStock);
        this.setPartMin(partMin);
        this.setPartMax(partMax);
        this.setCompName(compName);
    }

    // Outsourced Getters
    public String getCompName() {
        return compName;
    }

    // Outsourced Setters
    public void setCompName(String compName) {
        this.compName = compName;
    }
}
