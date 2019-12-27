package Model;

public class Outsourced extends Part {

    // Outsourced members
    private String compName;

    // Outsourced constructor (overrides Part's constructor, adding compName)
    public Outsourced(int partID, String partName, double partPrice, int partStock, int partMin, int partMax, String compName) {
        setPartID(partID);
        setPartName(partName);
        setPartPrice(partPrice);
        setPartStock(partStock);
        setPartMin(partMin);
        setPartMax(partMax);
        setCompName(compName);
    }

    // Outsourced getters
    public String getCompName() {
        return compName;
    }

    // Outsourced setters
    public void setCompName(String compName) {
        this.compName = compName;
    }
}
