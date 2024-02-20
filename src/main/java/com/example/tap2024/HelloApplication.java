package com.example.tap2024;

import com.example.tap2024.vistas.Calculadora;
import com.example.tap2024.vistas.memorama;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private MenuBar mnbPrincipal;
    private Menu menParcial1, menParcial2, menSalir;
    private MenuItem mitCalculadora, mitmemorama, mitSalir;
    private BorderPane bdpPanel;
    @Override
    public void start(Stage stage) throws IOException {
        CrearMenu();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        bdpPanel =  new BorderPane();
        bdpPanel.setTop(mnbPrincipal);
        Scene scene = new Scene(bdpPanel);
        scene.getStylesheets()
                .add(getClass().getResource("/estilos/main.css").toString());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
    }

    private void CrearMenu() {
        // menu primer parcial
        mitCalculadora = new MenuItem("Calculadora");
        mitmemorama = new MenuItem("Memorama");
        menParcial1 = new Menu("primer parcial");
        menParcial1.getItems().addAll(mitCalculadora, mitmemorama);
        mitCalculadora.setOnAction(event -> new Calculadora());
        mitmemorama.setOnAction(event -> new memorama());

        //menu segundo parcial
        menParcial2 = new Menu("segundo parcial");

        //menu salir
        mitSalir = new MenuItem("Salir");
        menSalir = new Menu("salir");
        menSalir.getItems().add(mitSalir);
        mitSalir.setOnAction(actionEvent -> System.exit(0));

        mnbPrincipal = new MenuBar();
        mnbPrincipal.getMenus().addAll(menParcial1, menParcial2, menSalir);
    }

    public static void main(String[] args) {
        launch();
    }
}