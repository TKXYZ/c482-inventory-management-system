package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdatePartController implements Initializable {
    Inventory inv;
    @FXML public Button saveBtn;
    @FXML public Button cancelBtn;
    @FXML public ToggleGroup partType;
    @FXML public RadioButton inHouseRadio;
    @FXML public RadioButton outsourcedRadio;
    @FXML public TextField idTextField;
    @FXML public TextField nameTextField;
    @FXML public TextField priceTextField;
    @FXML public TextField invTextField;
    @FXML public TextField maxTextField;
    @FXML public TextField minTextField;
    @FXML public TextField machineIDTextField;
    @FXML public TextField compNameTextField;
    @FXML public HBox machineHBox;
    @FXML public HBox compHBox;
    // Part that'll be updated
    private static Part partToUpdate = null;

    // Constructor
    public UpdatePartController(Inventory inv) {
        this.inv = inv;
    }

    public static void setPartToUpdate(Part partToUpdate) {
        UpdatePartController.partToUpdate = partToUpdate; // Similar to "this." but references UpdatePartController's partToUpdate
    }

    @Override public void initialize(URL url, ResourceBundle rb) {
        generateTextFields();
    }

    @FXML  public void partRadioToggle(ActionEvent event) {
        if (inHouseRadio.isSelected()) {
            machineHBox.setVisible(true);
            compHBox.setVisible(false);
        }

        if (outsourcedRadio.isSelected()) {
            compHBox.setVisible(true);
            machineHBox.setVisible(false);
        }
    }

    @FXML public void saveBtnAction(ActionEvent event) {
        try {
            int id = partToUpdate.getPartID(); // Part that'll be updated
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int inv = Integer.parseInt(invTextField.getText());
            int max = Integer.parseInt(maxTextField.getText());
            int min = Integer.parseInt(minTextField.getText());

            if (min > max) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error: Minimum");
                alert.setContentText("Min amount cannot be greater than the max allowed.");
                alert.show();
            } else if (inv < min || inv > max ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error: Inventory");
                alert.setContentText("Inventory must be in between min and max allowed.");
                alert.show();
            } else {

                // Creates new Part to REPLACE current Part in Inventory depending on which Radio was toggled
                if (inHouseRadio.isSelected()) {
                    int machineID = Integer.parseInt(machineIDTextField.getText());
                    InHouse replacementInHousePart = new InHouse(id, name, price, inv, min, max, machineID);
                    Inventory.deletePart(partToUpdate);
                    Inventory.addPart(replacementInHousePart);
                }

                if (outsourcedRadio.isSelected()) {
                    String compName = compNameTextField.getText();
                    Outsourced replacementOutsourcedPart = new Outsourced(id, name, price, inv, min, max, compName);
                    Inventory.deletePart(partToUpdate);
                    Inventory.addPart(replacementOutsourcedPart);
                }

                // After updating, go back to main screen
                backToMain(event);
            }
        } catch (Exception e) { // catches any exceptions that may arise
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Values");
            alert.setContentText("Please verify that all values are valid.");
            alert.show();
        }
    }

    @FXML public void cancelBtnAction(ActionEvent event) throws Exception {
        backToMain(event);
    }

    private void backToMain(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        MainScreenController controller = new MainScreenController(inv);

        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void generateTextFields() {
        if (partToUpdate instanceof InHouse) {
            InHouse part = (InHouse)partToUpdate; // casting partToUpdate to more-specific InHouse Part (broad to narrow)
            idTextField.setText(String.valueOf(part.getPartID()));
            nameTextField.setText(part.getPartName());
            priceTextField.setText(String.valueOf(part.getPartPrice()));
            invTextField.setText(String.valueOf(part.getPartInv()));
            maxTextField.setText(String.valueOf(part.getPartMax()));
            minTextField.setText(String.valueOf(part.getPartMin()));
            // InHouse Parts have a machine ID attached
            machineIDTextField.setText(String.valueOf(part.getMachineID()));

            // Only show elements related to InHouse
            inHouseRadio.setSelected(true);
            machineHBox.setVisible(true);
            compHBox.setVisible(false);
        }

        if (partToUpdate instanceof Outsourced) {
            Outsourced part = (Outsourced)partToUpdate; // casting partToUpdate to more-specific Outsourced Part (broad to narrow)
            idTextField.setText(String.valueOf(part.getPartID()));
            nameTextField.setText(part.getPartName());
            priceTextField.setText(String.valueOf(part.getPartPrice()));
            invTextField.setText(String.valueOf(part.getPartInv()));
            maxTextField.setText(String.valueOf(part.getPartMax()));
            minTextField.setText(String.valueOf(part.getPartMin()));
            // Outsourced Parts have a company name attached
            compNameTextField.setText(String.valueOf(part.getCompName()));

            // Only show elements related to Outsourced
            outsourcedRadio.setSelected(true);
            compHBox.setVisible(true);
            machineHBox.setVisible(false);
        }
    }
}
