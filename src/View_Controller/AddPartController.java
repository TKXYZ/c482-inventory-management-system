package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
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

public class AddPartController implements Initializable {
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

    // Constructor
    public AddPartController(Inventory inv) {
        this.inv = inv;
    }

    @Override public void initialize(URL url, ResourceBundle rb) {
        // Defaults to In-House Radio and MachineID TextField visible
        inHouseRadio.setSelected(true);
        machineHBox.setVisible(true);
        compHBox.setVisible(false);
    }

    @FXML public void partRadioToggle(ActionEvent event) {
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
            /*
                Parsing important in forms because all data passed in are Strings
                Parses the String input from TextFields in order to assign to respective primitives and use in constructor
            */
            int id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText(); // no need to parse; text input already a String
            double price = Double.parseDouble(priceTextField.getText());
            int inv = Integer.parseInt(invTextField.getText());
            int max = Integer.parseInt(maxTextField.getText());
            int min = Integer.parseInt(minTextField.getText());
            // machineID or compName will be parsed later

            // Error Handling
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
                /*
                    Creates new Parts (using respective constructors) and adds to partInv depending on which Radio was toggled
                    machineID or compName will be parsed depending on which Radio was toggled
                */
                if (inHouseRadio.isSelected()) {
                    int machineID = Integer.parseInt(machineIDTextField.getText());
                    InHouse newInHousePart = new InHouse(id, name, price, inv, min, max, machineID);
                    Inventory.addPart(newInHousePart);
                }

                if (outsourcedRadio.isSelected()) {
                    String compName = compNameTextField.getText();
                    Outsourced newOutsourcedPart = new Outsourced(id, name, price, inv, min, max, compName);
                    Inventory.addPart(newOutsourcedPart);
                }
                backToMain(event);
            }
        } catch (Exception e) {
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
}
