package Main;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InventoryProgram extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Creates a new Inventory
        Inventory inv = new Inventory();
        // Adds test data into Inventory
        addTestData(inv);

        // Uses FXMLLoader to load MainScreen.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/MainScreen.fxml"));
        // Creates controller for MainScreen.fxml; passing inv as param to controller's constructor
        View_Controller.MainScreenController controller = new View_Controller.MainScreenController(inv);
        // Links loader and controller
        loader.setController(controller);

        // Creates window and sets scene
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 425);
        stage.setScene(scene);
        stage.setTitle("Inventory Management System");
        stage.setResizable(false);
        stage.show();
    }

    void addTestData(Inventory inv) {
        // Adds InHouse Parts to Inventory (has machineID)
        Part inPart1 = new InHouse(1, "In-Part 1", 10.00, 10, 100, 1, 101);
        Part inPart2 = new InHouse(2, "In-Part 2", 20.00, 20, 100, 1, 102);
        Part inPart3 = new InHouse(3, "In-Part 3", 30.00, 30, 100, 1, 103);
        Part inPart4 = new InHouse(4, "In-Part 4", 40.00, 40, 100, 1, 104);
        Part inPart5 = new InHouse(5, "In-Part 5", 50.00, 50, 100, 1, 105);
        Inventory.addPart(inPart1);
        Inventory.addPart(inPart2);
        Inventory.addPart(inPart3);
        Inventory.addPart(inPart4);
        Inventory.addPart(inPart5);
        // Adds Outsourced Parts to Inventory (has compName)
        Part outPart1 = new Outsourced(6, "Out-Part 1", 60.00, 60, 100, 1, "Company 1");
        Part outPart2 = new Outsourced(7, "Out-Part 2", 70.00, 70, 100, 1, "Company 2");
        Part outPart3 = new Outsourced(8, "Out-Part 3", 80.00, 80, 100, 1, "Company 3");
        Part outPart4 = new Outsourced(9, "Out-Part 4", 90.00, 90, 100, 1, "Company 4");
        Part outPart5 = new Outsourced(10, "Out-Part 5", 100.00, 100, 100, 1, "Company 5");
        Inventory.addPart(outPart1);
        Inventory.addPart(outPart2);
        Inventory.addPart(outPart3);
        Inventory.addPart(outPart4);
        Inventory.addPart(outPart5);
        // Creates Products, associates some Parts to Products (using custom methods), and adds Product into Inventory
        Product prod1 = new Product(101, "Product 1", 100.00, 10, 100, 1);
        prod1.addAssociatedPart(inPart1);
        prod1.addAssociatedPart(outPart1);
        Inventory.addProduct(prod1);
        Product prod2 = new Product(102, "Product 2", 200.00, 20, 100, 1);
        prod2.addAssociatedPart(inPart2);
        prod2.addAssociatedPart(outPart2);
        Inventory.addProduct(prod2);
        Product prod3 = new Product(103, "Product 3", 300.00, 30, 100, 1);
        prod3.addAssociatedPart(inPart3);
        prod3.addAssociatedPart(outPart3);
        Inventory.addProduct(prod3);
    }
}

/* ----- Notes -----
    start() is main entry point for all JavaFX applications.
    Stage is top-level container representing a window; Scene is the container for all content displayed within the window.
        Tip: Set scene width and height when creating it.
            Scene scene = new Scene(rootNode, 800, 425);
    Parent signals the base class for all nodes that have children in the scene graph.
        Handles all hierarchical scene graph operations (adding/removing child nodes).
    FXML is an XML-based language that provides the structure for building a UI separate from the  application logic of our code.
        It includes code for setting up application main class and for defining the stage and scene, so we must link it to this .java file.
        In this case, the rootNode (MainScreen.fxml) includes an AnchorPane layout.
    FXMLLoader class responsible for loading the FXML file and returning the resulting object graph.
        Parent rootNode = FXMLLoader.load(getClass().getResource("../View_Controller/MainScreen.fxml"));

    Assigning an fx:id to an element creates a variable in the doc's namespace, so you can refer to it from somewhere else.
    @FXML used to tag non-public controller member variables and handler methods for use by FXML markup.
 */
