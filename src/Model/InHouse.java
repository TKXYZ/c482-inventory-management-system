package Model;

public class InHouse extends Part {

    // InHouse Members
    private int machineID;

    // InHouse Constructor (overrides Part's constructor, adding machineID)
    public InHouse(int partID, String partName, double partPrice, int partStock, int partMin, int partMax, int machineID) {
        this.setPartID(partID);
        this.setPartName(partName);
        this.setPartPrice(partPrice);
        this.setPartStock(partStock);
        this.setPartMin(partMin);
        this.setPartMax(partMax);
        this.setMachineID(machineID);
    }

    // InHouse Getters
    public int getMachineID() {
        return machineID;
    }

    // InHouse Setters
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
