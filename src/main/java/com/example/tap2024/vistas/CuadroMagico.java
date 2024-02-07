package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CuadroMagico extends Stage {

    private Scene scene;
    public CuadroMagico(){
        this.setTitle("Cuadro magico");
        this.setScene(new Scene(new Button("Da click")));
        this.show();
    }

    private void CreateUI(){
        scene = new Scene(new Button("Da click"));
    }

}
