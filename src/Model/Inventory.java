package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    // Inventory Members
    private static ObservableList<Part> partsInv = FXCollections.observableArrayList();
    private static ObservableList<Product> productsInv = FXCollections.observableArrayList();

    // ADD
    public static void addPart(Part partToAdd) {
        partsInv.add(partToAdd);
    }
    public static void addProduct(Product productToAdd) {
        productsInv.add(productToAdd);
    }

    // DELETE
    public static void deletePart(Part partToDelete) {
        for (int i = 0; i < partsInv.size(); i++) {
            if (partsInv.get(i) == partToDelete) {
                partsInv.remove(i);
            }
        }
    }
    public static void deleteProduct(Product productToDelete) {
        for (int i = 0; i < productsInv.size(); i++) {
            if (productsInv.get(i) == productToDelete) {
                productsInv.remove(i);
            }
        }
    }

    // UPDATE
    public static void updatePart(Part partToUpdate) {
        for (int i = 0; i < partsInv.size(); i++) {
            if (partsInv.get(i).getPartID() == partToUpdate.getPartID()) {
                partsInv.set(i, partToUpdate);
            }
        }
    }

    public static void updateProduct(Product productToUpdate) {
        for (int i = 0; i < productsInv.size(); i++) {
            if (productsInv.get(i).getProductID() == productToUpdate.getProductID()) {
                productsInv.set(i, productToUpdate);
            }
        }
    }

    // TODO: VERIFY W/ INSTRUCTOR IF THIS IS CORRECT
    // SEARCH/LOOK UP
    public Part searchPart(Part partToSearch) {
        if (!partsInv.isEmpty()) { // only loop if Parts inventory is not empty
            for (int i = 0; i < partsInv.size(); i++) {
                if (partsInv.get(i).getPartID() == partToSearch.getPartID()) {
                    return partsInv.get(i);
                }
            }
        }
        return null;
    }

    public Product searchProduct(Product productToSearch) {
        if (!productsInv.isEmpty()) { // only loop if Products inventory is not empty
            for (int i = 0; i < productsInv.size(); i++) {
                if (productsInv.get(i).getProductID() == productToSearch.getProductID()) {
                    return productsInv.get(i);
                }
            }
        }
        return null;
    }

    // GET ALL
    public static ObservableList<Part> getPartsInv() {
        return partsInv;
    }

    public static ObservableList<Product> getProductsInv() {
        return productsInv;
    }
}
