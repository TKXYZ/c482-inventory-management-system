package View_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController {

    @FXML public Button addProductBtn, deleteProductBtn, productSearchBtn, saveBtn, cancelBtn;
    @FXML public TextField productSearchBox;

    public void addProductBtnAction(ActionEvent event) {
    }

    public void deleteProductBtnAction(ActionEvent event) {
    }

    public void productSearchBtnAction(ActionEvent event) {
    }

    public void saveBtnAction(ActionEvent event) {
    }

    public void cancelBtnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
