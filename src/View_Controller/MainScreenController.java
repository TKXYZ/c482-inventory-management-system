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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    public TextField partSearchTextField;
    public TextField productSearchTextField;
    public TableView<Part> partsTable;
    public TableView<Product> productsTable;
    public TableColumn<Part, Integer> partIDCol;
    public TableColumn<Part, String> partNameCol;
    public TableColumn<Part, Double> partPriceCol;
    public TableColumn<Part, Integer> partLevelCol;
    public TableColumn<Product, Integer> productIDCol;
    public TableColumn<Product, String> productNameCol;
    public TableColumn<Product, Double> productPriceCol;
    public TableColumn<Product, Integer> productLevelCol;
//    private ObservableList<Part> partInv = FXCollections.observableArrayList();
//    private ObservableList<Product> productInv = FXCollections.observableArrayList();
//    private ObservableList<Part> partInvSearch = FXCollections.observableArrayList();
//    private ObservableList<Product> productInvSearch = FXCollections.observableArrayList();

    // MainScreen constructor accepts Inventory object
    public MainScreenController(Inventory inv) {
        this.inv = inv;
    }

    @Override public void initialize(URL url, ResourceBundle rb) {
        /*
            CellValueFactory used to populate individual columns.
        */

        // Links part table columns to their respective values
        partIDCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<Part, Double>("partPrice"));
        partLevelCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partLevel"));

        // Links product table columns to their respective values
        productIDCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productID"));
        productNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory<Product, Double>("productPrice"));
        productLevelCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productLevel"));

        // Populates both tables using predefined method
        partsTable.getItems().setAll(generatePartsTable());
        productsTable.getItems().setAll(generateProductsTable());
    }

    @FXML public void addPartBtnAction(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPart.fxml"));
            AddPartController controller = new AddPartController(inv);
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    @FXML public void addProductBtnAction(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
            AddProductController controller = new AddProductController(inv);
            loader.setController(controller);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }

    @FXML public void deletePartBtnAction(ActionEvent event) {
        // Prevents deletion of non-existent Parts
        if (partsTable.getSelectionModel().getSelectedItem() != null && partsTable.getItems() != null) {
            Part partToDelete = partsTable.getSelectionModel().getSelectedItem();
            Inventory.deletePart(partToDelete);
            partsTable.getItems().setAll(generatePartsTable());
            partsTable.refresh();

            // Also deletes associated Parts from Inventory
            for (int i = 0; i < Inventory.getAllProducts().size(); i++) {
                if (Inventory.getAllProducts().get(i).getAssociatedParts().contains(partToDelete)) {
                    Inventory.getAllProducts().get(i).deleteAssociatedPart(partToDelete);
                }
            }
        }
    }

    @FXML public void deleteProductBtnAction(ActionEvent event) {
        // Prevents deletion of non-existent Products
        if (productsTable.getSelectionModel().getSelectedItem() != null && productsTable.getItems() != null) {
            Product productToDelete = productsTable.getSelectionModel().getSelectedItem();

            // Denies deletion if Product has associated Parts
            if (!productToDelete.getAssociatedParts().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR: Product has Associated Parts");
                alert.setContentText("Cannot delete product because it has parts associated with it.");
            } else {
                Inventory.deleteProduct(productToDelete);
                productsTable.getItems().setAll(generateProductsTable());
                productsTable.refresh();
            }
        }
    }

    @FXML public void updatePartBtnAction(ActionEvent event) throws Exception {
        // Prevents updating non-existent Parts
        if (partsTable.getSelectionModel().getSelectedItem() != null) {
            UpdatePartController.setPartToUpdate(partsTable.getSelectionModel().getSelectedItem());

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdatePart.fxml"));
                UpdatePartController controller = new UpdatePartController(inv);
                loader.setController(controller);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                System.out.print(e.toString());
            }
        }
    }

    @FXML public void updateProductBtnAction(ActionEvent event) throws Exception {
        // Prevents updating non-existent Products
        if (productsTable.getSelectionModel().getSelectedItem() != null) {
            UpdateProductController.setProductToUpdate(productsTable.getSelectionModel().getSelectedItem());

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateProduct.fxml"));
                UpdateProductController controller = new UpdateProductController(inv);
                loader.setController(controller);
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (Exception e) {
                System.out.print(e.toString());
            }
        }
    }

    @FXML public void searchPartBtnAction(ActionEvent event) {
        String search = partSearchTextField.getText();

        if (search.isEmpty()) {
            partsTable.getItems().setAll(generatePartsTable());
        } else {
            ObservableList<Part> match = FXCollections.observableArrayList();

            for (int i = 0; i < Inventory.getAllParts().size(); i++) {
                if (Inventory.getAllParts().get(i).getPartName().toLowerCase().contains(search.toLowerCase())) {
                    match.add((Inventory.getAllParts().get(i)));
                }
            }
            partsTable.getItems().setAll(match);
        }
    }

    @FXML public void searchProductBtnAction(ActionEvent event) {
        String search = productSearchTextField.getText();

        if (search.isEmpty()) {
            productsTable.getItems().setAll(generateProductsTable());
        } else {
            ObservableList<Product> match = FXCollections.observableArrayList();

            for (int i = 0; i < Inventory.getAllProducts().size(); i++) {
                if (Inventory.getAllProducts().get(i).getProductName().toLowerCase().contains(search.toLowerCase())) {
                    match.add(Inventory.getAllProducts().get(i));
                }
            }
            productsTable.getItems().setAll(match);
        }
    }

    @FXML public void exitBtnAction(ActionEvent event) {
        Platform.exit();
    }

    private List<Part> generatePartsTable() {
        ArrayList<Part> list = new ArrayList<>();

        for (int i = 0; i < Inventory.getAllParts().size(); i++) {
            list.add(Inventory.getAllParts().get(i));
        }
        return list;
    }

    private List<Product> generateProductsTable() {
        ArrayList<Product> list = new ArrayList<>();

        for (int i = 0; i < Inventory.getAllProducts().size(); i++) {
            list.add(Inventory.getAllProducts().get(i));
        }
        return list;
    }
//    // Video Pt. 2: 12:10
//    private <T> TableColumn<T, Double> formatPrice() {
//        TableColumn<T, Double> costCol = new TableColumn<>("price");
//        costCol.setCellValueFactory(new PropertyValueFactory<>("price"));
//        // Format as currency
//        costCol.setCellValueFactory((TableColumn<T, Double> column) -> {
//            return new TableCell<T, Double>() {
//                @Override
//                protected void updateItem(Double item, boolean empty) {
//                    if (!empty) {
//                        setText("$" + String.format("%10.2f", item));
//                    }
//                }
//            };
//        };
//        return costCol;
//    }
}
