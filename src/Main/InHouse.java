package Main;

public class InHouse extends Part {
    private int machineID;

    // InHouse default constructor
    public InHouse(int partID, String partName, double partPrice, int partStock, int partMin, int partMax) {
        super(partID, partName, partPrice, partStock, partMin, partMax);
    }

    // InHouse constructor
    public void InHouse(int partID, String partName, double partPrice, int partStock, int partMin, int partMax, int machineID) {
        this.partID = partID;
        this.partName = partName;
        this.partPrice = partPrice;
        this.partStock = partStock;
        this.partMin = partMin;
        this.partMax = partMax;
        this.machineID = machineID;
    }

    // InHouse getters
    public int getMachineID() {
        return machineID;
    }

    // InHouse setters
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
