package Model;

public class InHouse extends Part {

    // InHouse members
    private int machineID;

    // InHouse constructor (overrides Part's constructor, adding machineID)
    public InHouse(int partID, String partName, double partPrice, int partStock, int partMin, int partMax, int machineID) {
        setPartID(partID);
        setPartName(partName);
        setPartPrice(partPrice);
        setPartStock(partStock);
        setPartMin(partMin);
        setPartMax(partMax);
        setMachineID(machineID);
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
