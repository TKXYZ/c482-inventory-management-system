package Main;

import javafx.collections.ObservableList;

public class Product extends Inventory {
    private int productID;
    private String productName;
    private double productPrice;
    private int productStock;
    private int productMin;
    private int productMax;
    private ObservableList<Part> associatedParts;

    // Product constructor
    public Product(int productID, String productName, double productPrice, int productStock, int productMin, int productMax) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productMin = productMin;
        this.productMax = productMax;
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

    public void addAssociatedPart(ObservableList<Part> associatedParts) {
        this.associatedParts = associatedParts;
    }

    public boolean deleteAssociatedPart(ObservableList<Part> associatedParts) {
        return true;
    }

    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }
}