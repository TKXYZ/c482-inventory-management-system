package Main;

public class Outsourced extends Part {
    private String compName;

    // Outsourced default constructor
    public Outsourced(int partID, String partName, double partPrice, int partStock, int partMin, int partMax) {
        super(partID, partName, partPrice, partStock, partMin, partMax);
    }

    // Outsourced constructor
    public void Outsourced(int partID, String partName, double partPrice, int partStock, int partMin, int partMax, String compName) {
        this.partID = partID;
        this.partName = partName;
        this.partPrice = partPrice;
        this.partStock = partStock;
        this.partMin = partMin;
        this.partMax = partMax;
        this.compName = compName;
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
