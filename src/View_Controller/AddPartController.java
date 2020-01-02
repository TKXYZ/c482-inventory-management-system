package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AddPartController {

    @FXML public Button saveBtn;
    @FXML public Button cancelBtn;
    @FXML public RadioButton inHouseRadio;
    @FXML public RadioButton outsourcedRadio;
    @FXML public ToggleGroup partType;
    @FXML public TextField idTextField;
    @FXML public TextField nameTextField;
    @FXML public TextField invTextField;
    @FXML public TextField priceTextField;
    @FXML public TextField maxTextField;
    @FXML public TextField minTextField;
    @FXML public TextField machineIDTextField;
    @FXML public TextField compNameTextField;

    // Used to go back to MainScreen
    private void backToMain(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML // if In-House selected, only show machine ID text field; else only show company names text field
    public void partRadioToggle(ActionEvent event) {
        if (inHouseRadio.isSelected()) {
            machineIDTextField.setVisible(true);
            compNameTextField.setVisible(false);
        } else {
            machineIDTextField.setVisible(false);
            compNameTextField.setVisible(true);
        }
    }

    @FXML
    public void saveBtnAction(ActionEvent event) {
        try {
            // Parses everything in order to assign to respective variables
            int partID = Integer.parseInt(idTextField.getText());
            String partName = nameTextField.getText();
            int partStock = Integer.parseInt(invTextField.getText());
            double partPrice = Double.parseDouble(priceTextField.getText());
            int partMax = Integer.parseInt(maxTextField.getText());
            int partMin = Integer.parseInt(minTextField.getText());

            if (partMin < partMax) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Minimum must be less than the maximum allowed.");
            } else if (partStock > partMax || partStock < partMin) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Stock must be in between the minimum and maximum.");
            } else {
                if (inHouseRadio.isSelected()) {
                    int machineID = Integer.parseInt(machineIDTextField.getText());
                    InHouse newInHousePart = new InHouse(partID, partName, partPrice, partStock, partMin, partMax, machineID);
                    Inventory.addPart(newInHousePart);
                } else {
                    String compName = compNameTextField.getText();
                    Outsourced newOutsourcedPart = new Outsourced(partID, partName, partPrice, partStock, partMin, partMax, compName);
                    Inventory.addPart(newOutsourcedPart);
                }
                // after Saving, goes back to MainScreen
                backToMain(event);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Please verify that all values are correct.");
        }
    }

    @FXML
    public void cancelBtnAction(ActionEvent event) throws Exception {
        backToMain(event);
    }
}
