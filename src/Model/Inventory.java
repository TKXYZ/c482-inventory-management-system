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

    // DELETE (by ID)
    public boolean deletePart(int partToDelete) {
        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getPartID() == partToDelete) {
                allParts.remove(i);
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean deleteProduct(int productToDelete) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getProductID() == productToDelete) {
                allProducts.remove(i);
            } else {
                return false;
            }
        }
        return true;
    }

    // UPDATE
    public void updatePart(Part partToUpdate) {
        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getPartID() == partToUpdate.getPartID()) {
                allParts.set(i, partToUpdate);
                break;
            }
        }
    }
    public  void updateProduct(Product productToUpdate) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getProductID() == productToUpdate.getProductID()) {
                allProducts.set(i, productToUpdate);
                break;
            }
        }
    }

    // SEARCH (by ID)
    public Part searchPart(int partToSearch) {
        if (!allParts.isEmpty()) {
            for (int i = 0; i < allParts.size(); i++) {
                if (allParts.get(i).getPartID() == partToSearch) {
                    return allParts.get(i);
                }
            }
        }
        return null;
    }
    public Product searchProduct(int productToSearch) {
        if (!allProducts.isEmpty()) {
            for (int i = 0; i < allProducts.size(); i++) {
                if (allProducts.get(i).getProductID() == productToSearch) {
                    return allProducts.get(i);
                }
            }
        }
        return null;
    }

    // GET ALL
    public ArrayList<Part> getAllParts() {
        return allParts;
    }

    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }

    // GET SIZE
    public int partListSize() {
        return allParts.size();
    }

    public int productListSize() {
        return allProducts.size();
    }
}
