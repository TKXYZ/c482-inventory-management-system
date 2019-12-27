package Model;

import java.util.ArrayList;

public class Product {

    // Product members
    private int productID;
    private String productName;
    private double productPrice;
    private int productStock;
    private int productMin;
    private int productMax;
    private ArrayList<Part> associatedParts = new ArrayList<>(); // Parts associated with a product

    // Product constructor
    public Product(int productID, String productName, double productPrice, int productStock, int productMin, int productMax) {
        setProductID(productID);
        setProductName(productName);
        setProductPrice(productPrice);
        setProductStock(productStock);
        setProductMin(productMin);
        setProductMax(productMax);
    }

    // Product getters
    public int getProductID() {
        return productID;
    }
    public String getProductName() {
        return productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public int getProductStock() {
        return productStock;
    }
    public int getProductMin() {
        return productMin;
    }
    public int getProductMax() {
        return productMax;
    }

    // Product setters
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    public void setProductMin(int productMin) {
        this.productMin = productMin;
    }
    public void setProductMax(int productMax) {
        this.productMax = productMax;
    }

    // Methods for Parts that associate with Products
    public void addAssociatedPart(Part associatedPartToAdd) {
        associatedParts.add(associatedPartToAdd);
    }

    public boolean deleteAssociatedPart (Part associatedPartToDelete) {
        for (int i = 0; i < associatedParts.size(); i++) {
            if (associatedParts.get(i) == associatedPartToDelete) {
                associatedParts.remove(i);
                return true;
            }
        }
        return false;
    }

    public Part getAssociatedParts(int associatedPartToSearch) {
        for (int i = 0; i < associatedParts.size(); i++) {
            if (associatedParts.get(i).getPartID() == associatedPartToSearch) {
                return associatedParts.get(i);
            }
        }
        return null;
    }
}
