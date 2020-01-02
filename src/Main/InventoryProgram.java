package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InventoryProgram extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../View_Controller/MainScreen.fxml")); // FXMLLoader loads FXML file containing GUI components
        Scene scene = new Scene(root, 800, 425); // creates Scene using GUI components found within the rootNode (AnchorPane is base layout)
        stage.setScene(scene);
        stage.setTitle("Inventory Management System");
        stage.setResizable(false);
        stage.show();

//        Inventory inv = new Inventory();
//        addTestData(inv);
    }

    // Entry point of execution
    public static void main(String[] args) {
        launch(args);
    }
}

//    void addTestData(Inventory inv) {
//        // adds InHouse parts
//        Part inPart1 = new InHouse(1, "inPart1", 1.99, 10, 5, 100, 101);
//        Part inPart2 = new InHouse(2, "inPart2", 2.99, 20, 5, 100, 102);
//        Part inPart3 = new InHouse(3, "inPart3", 3.99, 30, 5, 100, 103);
//        inv.addPart(inPart1);
//        inv.addPart(inPart2);
//        inv.addPart(inPart3);
//        inv.addPart(new InHouse(4, "inPart4", 4.99, 40, 5, 100, 104));
//        inv.addPart(new InHouse(5, "inPart5", 5.99, 50, 5, 100, 105));
//
//        // adds Outsourced parts
//        Part outPart1 = new Outsourced(6, "outPart1", 6.99, 60, 5, 100, "Company 1");
//        Part outPart2 = new Outsourced(7, "outPart2", 7.99, 70, 5, 100, "Company 2");
//        Part outPart3 = new Outsourced(8, "outPart3", 8.99, 80, 5, 100, "Company 3");
//        inv.addPart(outPart1);
//        inv.addPart(outPart2);
//        inv.addPart(outPart3);
//        inv.addPart(new Outsourced(9, "outPart4", 9.99, 90, 5, 100, "Company 4"));
//        inv.addPart(new Outsourced(10, "outPart5", 10.99, 100, 5, 100, "Company 5"));
//
//        // creates Products, associates some Parts to Products, and injects entire Product into Inventory
//        Product prod1 = new Product(101, "Product 1", 1.99, 10, 5, 100);
//        prod1.addAssociatedPart(inPart1); // associates an InHouse Part with prod1
//        prod1.addAssociatedPart(outPart1); // associates an Outsourced Part with prod1
//        inv.addProduct(prod1); // injects Product (along with associated parts) into Inventory
//        Product prod2 = new Product(102, "Product 2", 2.99, 20, 5, 100);
//        prod2.addAssociatedPart(inPart2);
//        prod2.addAssociatedPart(outPart2);
//        inv.addProduct(prod2);
//        Product prod3 = new Product(103, "Product 3", 3.99, 30, 5, 100);
//        prod3.addAssociatedPart(inPart3);
//        prod3.addAssociatedPart(outPart3);
//        inv.addProduct(prod3);
//    }

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
