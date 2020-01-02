package Model;

import javafx.collections.ObservableList;

public class Product {

    // Product Members (private b/c nothing will inherit from Product)
    private int productID;
    private String productName;
    private double productPrice;
    private int productStock;
    private int productMin;
    private int productMax;
    private ObservableList<Part> associatedParts; // Parts associated with a Product

    public Product(int productID, String productName, double productPrice, int productStock, int productMin, int productMax, ObservableList<Part> associatedParts) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productMin = productMin;
        this.productMax = productMax;
        this.associatedParts = associatedParts;
    }

    // Product Getters
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

    // Product Setters
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

    // Methods for Parts that are associated with Products
    public void addAssociatedPart(Part associatedPartToAdd) {
        associatedParts.add(associatedPartToAdd);
    }

    public void deleteAssociatedPart(Part associatedPartToDelete) {
        for (int i = 0; i < associatedParts.size(); i++) {
            if (associatedParts.get(i) == associatedPartToDelete) {
                associatedParts.remove(i);
            }
        }
    }

    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }
}
