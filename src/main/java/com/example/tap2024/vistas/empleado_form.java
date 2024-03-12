package com.example.tap2024.vistas;

import com.example.tap2024.models.EmpleadosDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class empleado_form extends Stage {
    private TableView<EmpleadosDAO> tableview_empleado;
    private EmpleadosDAO empleado_dao = new EmpleadosDAO();
    String[] arreglo_prompt = {"nombre del empleado", "rfc del empleado", "sueldo del empleado", "telefono del empleado", "Direccion del empleado"};
    private Scene escena;
    private TextField[] arreglo_campos = new TextField[5];
    private Button boton_guardar;
    private VBox vbox_prin;
    public empleado_form(TableView<EmpleadosDAO> table_emp) {
        tableview_empleado = table_emp;
        empleado_dao = new EmpleadosDAO();
        CrearIU();
        this.setTitle("Insertar Usuario");
        this.setScene(escena);
        this.show();
    }

    private void CrearIU() {
        vbox_prin = new VBox();
        vbox_prin.setPadding(new Insets(10));
        vbox_prin.setSpacing(10);
        vbox_prin.setAlignment(Pos.CENTER);
        for (int i = 0; i < arreglo_campos.length; i++) {
            arreglo_campos[i] = new TextField();
            arreglo_campos[i].setPromptText(arreglo_prompt[i]);
            vbox_prin.getChildren().add(arreglo_campos[i]);
        }
        boton_guardar = new Button("Guardar");
        boton_guardar.setOnAction(event -> GuardarEmpleado());

        vbox_prin.getChildren().add(boton_guardar);
        escena = new Scene(vbox_prin, 300, 250);
    }

    private void GuardarEmpleado() {
        empleado_dao.setNombre_empleado(arreglo_campos[0].getText());
        empleado_dao.setRfc_empleado(arreglo_campos[1].getText());
        empleado_dao.setSalario(Float.parseFloat(arreglo_campos[2].getText()));
        empleado_dao.setTelefono(arreglo_campos[3].getText());
        empleado_dao.setDireccion(arreglo_campos[4].getText());
        empleado_dao.INSERTAR();
        tableview_empleado.setItems(empleado_dao.CONSULTAR());
        tableview_empleado.refresh();

        arreglo_campos[0].clear();
        arreglo_campos[1].clear();
        arreglo_campos[2].clear();
        arreglo_campos[3].clear();
        arreglo_campos[4].clear();
    }
}
