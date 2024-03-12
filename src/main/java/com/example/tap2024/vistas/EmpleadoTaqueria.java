package com.example.tap2024.vistas;

import com.example.tap2024.componentes.ButtonCell;
import com.example.tap2024.models.EmpleadosDAO;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class EmpleadoTaqueria extends Stage {

    private Panel panel_principal;
    private BorderPane border_prin;
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
        button_agregare.setOnAction(event -> new empleado_form(table_empleado));
        button_agregare.setPrefSize(50,50);
        button_agregare.setGraphic(image_empleado);
        toolbar_menu = new ToolBar(button_agregare);

        CrearTable();
        border_prin = new BorderPane();
        border_prin.setTop(toolbar_menu);
        border_prin.setCenter(table_empleado);

        panel_principal = new Panel("Taqueria los Tilines");
        panel_principal.getStyleClass().add("panel-primary");
        panel_principal.setBody(border_prin);

        escena = new Scene(panel_principal, 700, 400);
        escena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
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

        TableColumn<EmpleadosDAO, String> table_editar = new TableColumn<EmpleadosDAO, String>("Editar");
        table_editar.setCellFactory(
                new Callback<TableColumn<EmpleadosDAO, String>, TableCell<EmpleadosDAO, String>>() {
                    @Override
                    public TableCell<EmpleadosDAO, String> call(TableColumn<EmpleadosDAO, String> empleadosDAOStringTableColumn) {
                        return new ButtonCell(1);
                    }
                }
        );

        TableColumn<EmpleadosDAO, String> table_eliminar = new TableColumn<EmpleadosDAO, String>("Eliminar");
        table_eliminar.setCellFactory(
                new Callback<TableColumn<EmpleadosDAO, String>, TableCell<EmpleadosDAO, String>>() {
                    @Override
                    public TableCell<EmpleadosDAO, String> call(TableColumn<EmpleadosDAO, String> empleadosDAOStringTableColumn) {
                        return new ButtonCell(2);
                    }
                }
        );


        //
        table_empleado.getColumns().addAll(tablecolumn_empleado, tablecolumnrfc_empleado,
                tablecolumnsueldo_empleado, tablecolumntel_empleado, tablecolumndirecc_empleado, table_editar, table_eliminar);
        table_empleado.setItems(objeto_empleado.CONSULTAR());
    }
}
