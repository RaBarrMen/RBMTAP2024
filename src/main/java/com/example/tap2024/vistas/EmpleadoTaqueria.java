package com.example.tap2024.vistas;

import com.example.tap2024.models.EmpleadosDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmpleadoTaqueria extends Stage {

    private VBox vbox_prin;
    private ToolBar toolbar_menu;
    private Scene escena;
    private Button button_agregare;
    private TableView<EmpleadosDAO> table_empleado;

    public EmpleadoTaqueria(){
        CrearUI();
        this.setTitle("Taqueria DLV :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        ImageView image_empleado = new ImageView(
                getClass().getResource("/images/emplyee.png").toString()
        );
        image_empleado.setFitHeight(50);
        image_empleado.setFitWidth(50);
        button_agregare = new Button();
        button_agregare.setPrefSize(50,50);
        button_agregare.setGraphic(image_empleado);
        toolbar_menu = new ToolBar(button_agregare);

        CrearTable();
        vbox_prin = new VBox(toolbar_menu, table_empleado);
        escena = new Scene(vbox_prin, 600, 400);

    }

    private void CrearTable() {
        EmpleadosDAO objeto_empleado = new EmpleadosDAO();
        table_empleado = new TableView<EmpleadosDAO>();
        TableColumn<EmpleadosDAO, String> tablecolumn_empleado = new TableColumn<>("Empleado");
        tablecolumn_empleado.setCellValueFactory(new PropertyValueFactory<>("nombre_empleado"));

        TableColumn<EmpleadosDAO, String> tablecolumnrfc_empleado = new TableColumn<>("RFC");
        tablecolumnrfc_empleado.setCellValueFactory(new PropertyValueFactory<>("rfc_empleado"));

        TableColumn<EmpleadosDAO, Float> tablecolumnsueldo_empleado = new TableColumn<>("Sueldo");
        tablecolumnsueldo_empleado.setCellValueFactory(new PropertyValueFactory<>("salario"));

        TableColumn<EmpleadosDAO, String> tablecolumntel_empleado = new TableColumn<>("Telefono");
        tablecolumntel_empleado.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        TableColumn<EmpleadosDAO, String> tablecolumndirecc_empleado = new TableColumn<>("Direccion");
        tablecolumndirecc_empleado.setCellValueFactory(new PropertyValueFactory<>("direccion"));


        //
        table_empleado.getColumns().addAll(tablecolumn_empleado, tablecolumnrfc_empleado,
                tablecolumnsueldo_empleado, tablecolumntel_empleado, tablecolumndirecc_empleado);
        table_empleado.setItems(objeto_empleado.CONSULTAR());
    }
}
