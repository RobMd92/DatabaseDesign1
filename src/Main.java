

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class Main extends Application {

    public void start(Stage PrimaryStage)throws Exception{

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Scene scene = new Scene(tabPane, 300, 300);

        insertDb woo = new insertDb();
        deleteDb deleteDb = new deleteDb();
        tabPane.getTabs().add(woo);
        tabPane.getTabs().add(deleteDb);

        PrimaryStage.setScene(scene);

        PrimaryStage.show();


        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/frank?serverTimezone=GMT","user","pass");
            Statement statement= con.createStatement();
            // statement.executeUpdate("CREATE TABLE test (id int(10) PRIMARY  KEY ,name VARCHAR(12))");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM test");
            ResultSetMetaData rsmd = rs.getMetaData();
            DatabaseMetaData meta = con.getMetaData();








            int columnsNumber = rsmd.getColumnCount();
            System.out.println(columnsNumber);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}