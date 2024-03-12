package com.example.tap2024.componentes;

import com.example.tap2024.models.EmpleadosDAO;
import com.example.tap2024.vistas.empleado_form;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<EmpleadosDAO, String> {
    Button boton_celda;
    int opc;
    public ButtonCell(int opc){
        this.opc = opc;
        String texto_boton = (opc == 1) ? "Editar" : "Eliminar"; 
        boton_celda = new Button(texto_boton);
        boton_celda.setOnAction(event -> AccionBoton(opc));
    }

    private void AccionBoton(int opc) {
        if(opc == 1){
            //para editar
            new empleado_form();
        } else {
            //para eliminar
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty){
            this.setGraphic(boton_celda);
        }
    }
}
