package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class memorama extends Stage {

    private Scene escena;
    private VBox vbIni, vbPart;
    private HBox hbIni, hbSecs, hbPart1, hbPart2;
    private GridPane gdpCart;
    private Label lbPar, lbTie, lbPart1, lbPart2, lbPunt1, lbPunt2;
    private TextField txtEnt;
    private Button btnRev;
    int punt1, punt2;
    String stPun1, stPun2;

    public memorama() {
        crearUI();
        this.setTitle("Memorama");
        this.setScene(escena);
        this.show();
    }

    private void crearUI() {
        punt1 = 0;
        stPun1 = (punt1 + "");
        punt2 = 0;
        stPun2 = (punt2 + "");

        lbPar = new Label("Numero de pares");
        lbTie = new Label();

        txtEnt = new TextField();
        txtEnt.setMinWidth(15);

        btnRev = new Button("Revolver");

        hbIni = new HBox(lbPar, txtEnt, btnRev, lbTie);
        hbIni.setSpacing(5);

        lbPart1 = new Label("Participante 1");
        lbPunt1 = new Label(stPun1);

        hbPart1 = new HBox(lbPart1, lbPunt1);
        hbPart1.setSpacing(5);

        lbPart2 = new Label("Participante 2");
        lbPunt2 = new Label(stPun2);

        hbPart2 = new HBox(lbPart2, lbPunt2);
        hbPart2.setSpacing(5);

        vbPart = new VBox(hbPart1, hbPart2);
        vbPart.setSpacing(5);

        gdpCart = new GridPane();
        gdpCart.setMinSize(250, 250);

        hbSecs = new HBox(gdpCart, vbPart);
        hbSecs.setSpacing(5);

        vbIni = new VBox(hbIni, hbSecs);
        vbIni.setSpacing(5);
        escena = new Scene(vbIni, 400, 400);
    }
}