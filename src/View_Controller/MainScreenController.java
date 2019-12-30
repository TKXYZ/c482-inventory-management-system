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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// MainScreenController sits behind the Main Screen and Controls Events
public class MainScreenController {

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
    private ObservableList<Part> partInventory = FXCollections.observableArrayList();
    private ObservableList<Product> productInventory = FXCollections.observableArrayList();
    private ObservableList<Part> partInventorySearch = FXCollections.observableArrayList();
    private ObservableList<Product> productInventorySearch = FXCollections.observableArrayList();

//    // MainScreenController Constructor; NOT SURE WHY THIS CRASHES APP
//    public MainScreenController(Inventory inv) {
//        this.inv = inv;
//    }

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        generatePartsTable();
//        generateProductsTable();
//    }
//
//    private void generatePartsTable() {
//        partInventory.setAll(inv.getAllParts());
//
//        TableColumn<Part, Double> costCol = formatPrice();
//        partsTable.getColumns().addAll(costCol);
//
//        partsTable.setItems(partInventory);
//        partsTable.refresh();
//    }
//
//    private void generateProductsTable() {
//        productInventory.setAll(inv.getAllProducts());
//
//        TableColumn<Product, Double> costCol = formatPrice();
//        productsTable.getColumns().addAll(costCol);
//
//        productsTable.setItems(productInventory);
//        productsTable.refresh();
//    }

    @FXML
    public void addPartBtnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene scene = new Scene(root);
        // Gets the Stage information; must create new stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // casting to Node, then to Stage
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
            partInventorySearch.clear();
            for (Part p : inv.getAllParts()) {
                if (p.getPartName().contains(partSearchBox.getText().trim())) {
                    partInventorySearch.add(p);
                }
            }
            partsTable.setItems(partInventorySearch);
            partsTable.refresh();
        }
    }

    @FXML
    public void searchProductBtnAction(ActionEvent event) {
        if (!productSearchBox.getText().trim().isEmpty()) {
            productInventorySearch.clear();
            for (Product p : inv.getAllProducts()) {
                if (p.getProductName().contains(productSearchBox.getText().trim())) {
                    productInventorySearch.add(p);
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
