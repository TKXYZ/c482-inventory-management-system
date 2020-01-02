package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    Inventory inv;
    public Button addPartBtn;
    public Button deletePartBtn;
    public Button updatePartBtn;
    public Button searchPartBtn;
    public Button addProductBtn;
    public Button deleteProductBtn;
    public Button updateProductBtn;
    public Button searchProductBtn;
    public TextField partSearchBox;
    public TextField productSearchBox;
    public TableView<Part> partsTable;
    public TableView<Product> productsTable;
    public TableColumn<Part, Integer> partIDCol;
    public TableColumn<Part, String> partNameCol;
    public TableColumn<Part, Integer> partLevelCol;
    public TableColumn<Part, Double> partPriceCol;
    public TableColumn<Product, Integer> productIDCol;
    public TableColumn<Product, String> productNameCol;
    public TableColumn<Product, Integer> productLevelCol;
    public TableColumn<Product, Double> productPriceCol;
    private ObservableList<Part> partInv = FXCollections.observableArrayList();
    private ObservableList<Product> productInv = FXCollections.observableArrayList();
    private ObservableList<Part> partInventorySearch = FXCollections.observableArrayList();
    private ObservableList<Product> productInventorySearch = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Links part table columns to their values
        partIDCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
        partLevelCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partLevel"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));

        // Links product table columns to their values
        productIDCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productID"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        productLevelCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productLevel"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrice"));

        // Populates both tables using ArrayList containing all Parts/Products from predefined methods
        partsTable.getItems().setAll(populatePartsTable());
        productsTable.getItems().setAll(populateProductsTable());
    }

    // Method used to populate Parts table with all Parts from Inventory; returns ArrayList of Parts
    private ArrayList<Part> populatePartsTable() {
        return new ArrayList<Part>(Inventory.getPartsInv());
    }

    // Method used to populate Products table with all Products from Inventory; returns ArrayList of Products
    private ArrayList<Product> populateProductsTable() {
        return new ArrayList<Product>(Inventory.getProductsInv());
    }

    @FXML
    public void addPartBtnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addProductBtnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void deletePartBtnAction(ActionEvent event) {
    }

    @FXML
    public void deleteProductBtnAction(ActionEvent event) {
    }

    @FXML
    public void updatePartBtnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UpdatePart.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void updateProductBtnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UpdateProduct.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void searchPartBtnAction(ActionEvent event) {
        if (!partSearchBox.getText().trim().isEmpty()) {
            partsTable.getItems().setAll(populatePartsTable());
            ObservableList<Part> allParts = Inventory.getPartsInv();

            for (int i = 0; i < Inventory.getPartsInv().size(); i++) {
                Part part = allParts.get(i);
                if (part.getPartName().contains(partSearchBox.getText().trim())) {
                    partInventorySearch.add(part);
                }
            }
            partsTable.setItems(partInventorySearch);
            partsTable.refresh();
        }
    }

    @FXML
    public void searchProductBtnAction(ActionEvent event) {
        if (!productSearchBox.getText().trim().isEmpty()) {
            productsTable.getItems().setAll(populateProductsTable());
            ObservableList<Product> allProducts = Inventory.getProductsInv();

            for (int i = 0; i < Inventory.getProductsInv().size(); i++) {
                Product product = allProducts.get(i);
                if (product.getProductName().contains(productSearchBox.getText().trim())) {
                    productInventorySearch.add(product);
                }
            }
            productsTable.setItems(productInventorySearch);
            productsTable.refresh();
        }
    }

    @FXML
    public void exitBtnAction(ActionEvent event) {
        Platform.exit();
    }
}
