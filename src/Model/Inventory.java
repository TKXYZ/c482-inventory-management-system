package Model;

import java.util.ArrayList;

public class Inventory {

    // Inventory members
    private ArrayList<Part> allParts;
    private ArrayList<Product> allProducts;

    // Inventory constructor
    public Inventory() {
        allParts = new ArrayList<>();
        allProducts = new ArrayList<>();
    }

    // ADD
    public void addPart(Part partToAdd) {
        if (partToAdd != null) {
            allParts.add(partToAdd);
        }
    }
    public void addProduct(Product productToAdd) {
        if (productToAdd != null) {
            allProducts.add(productToAdd);
        }
    }

    // DELETE
    public boolean deletePart(Part partToDelete) {
        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i) == partToDelete) {
                allParts.remove(i);
                break;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean deleteProduct(Product productToDelete) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i) == productToDelete) {
                allProducts.remove(i);
                break;
            } else {
                return false;
            }
        }
        return true;
    }

    // UPDATE
    public void updatePart(Part partToUpdate) {
        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i) == partToUpdate) {
                allParts.set(i, partToUpdate);
                break;
            }
        }
    }
    public  void updateProduct(Product productToUpdate) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i) == productToUpdate) {
                allProducts.set(i, productToUpdate);
                break;
            }
        }
    }

    // LOOKUP
    public Part searchPart(Part partToSearch) {
        if (!allParts.isEmpty()) {
            for (int i = 0; i < allParts.size(); i++) {
                if (allParts.get(i) == partToSearch) {
                    return allParts.get(i);
                }
            }
        }
        return null;
    }
    public Product searchProduct(Product productToSearch) {
        if (!allProducts.isEmpty()) {
            for (int i = 0; i < allProducts.size(); i++) {
                if (allProducts.get(i) == productToSearch) {
                    return allProducts.get(i);
                }
            }
        }
        return null;
    }

    // SEARCH
    public ArrayList<Part> searchPart(String partToSearch) {

    }
    public ArrayList<Product> searchProduct(String productToSearch) {

    }

    // GETALL
    public ArrayList<Part> getAllParts() {
        return allParts;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }
}
