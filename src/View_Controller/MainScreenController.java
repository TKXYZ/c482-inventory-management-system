package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController {

    // Class Member Declarations
    Inventory inv;

    @FXML
    public Button addPartBtn;
    @FXML
    public Button addProductBtn;
    @FXML
    public Button deletePartBtn;
    @FXML
    public Button deleteProductBtn;
    @FXML
    public Button updatePartBtn;
    @FXML
    public Button updateProductBtn;
    @FXML
    public Button searchPartBtn;
    @FXML
    public Button searchProductBtn;
    @FXML
    public TextField partSearchBox;
    @FXML
    public TextField productSearchBox;
    @FXML
    public TableView partsTable;
    @FXML
    public TableView productsTable;
    private ObservableList<Part> partInventory = FXCollections.observableArrayList();
    private ObservableList<Product> productInventory = FXCollections.observableArrayList();
    private ObservableList<Part> partsInventorySearch = FXCollections.observableArrayList();
    private ObservableList<Product> productsInventorySearch = FXCollections.observableArrayList();

    // MainScreenController constructor
    public MainScreenController(Inventory inv) {
        this.inv = inv;
    }

    // initializes MainScreenController Class
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generatePartsTable;
        generateProductsTable;
    }

    public void generatePartsTable() {
        partInventory.setAll(inv.getAllParts());

        TableColumn<Part, Double> costCol = formatPrice();
        partsTable.getColumns().addAll(costCol);

        partsTable.setItems(partInventory);
        partsTable.refresh();
    }

    public void generateProductsTable() {
        productInventory.setAll(inv.getAllProducts());

        TableColumn<Product, Double> costCol = formatPrice();
        productsTable.getColumns().addAll(costCol);

        productsTable.setItems(productInventory);
        productsTable.refresh();
    }

    // Event Handlers
    @FXML
    public void addPartBtnEvent(MouseEvent mouseEvent) {
    }

    @FXML
    public void addProductBtnEvent(MouseEvent mouseEvent) {
    }

    @FXML
    public void deletePartBtnEvent(MouseEvent mouseEvent) {
    }

    @FXML
    public void deleteProductBtnEvent(MouseEvent mouseEvent) {
    }

    @FXML
    public void updatePartBtnEvent(MouseEvent mouseEvent) {
    }

    @FXML
    public void updateProductBtnEvent(MouseEvent mouseEvent) {
    }

    @FXML
    public void searchPartBtnEvent(MouseEvent mouseEvent) {
    }

    @FXML
    public void searchProductBtnEvent(MouseEvent mouseEvent) {
    }
}
