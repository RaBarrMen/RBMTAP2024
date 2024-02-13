package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage {
    private Scene escena;
    private VBox vcontenedor;
    private GridPane gdpTeclado;
    private TextField txtPantalla;
    private Button [][] arBotones = new Button[4][4];
    private Character[] arEtiquetas ={'7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};

    public Calculadora() {
        CrearUI();
        this.setTitle("Mi primer calculadora en FX");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        txtPantalla = new TextField("");
        gdpTeclado = new GridPane();
        CrearTeclado ();
        vcontenedor = new VBox(txtPantalla, gdpTeclado);
        vcontenedor.setSpacing(5);
        escena = new Scene(vcontenedor, 200, 200);

    }

    private void CrearTeclado() {
        int pos = 0;
        char simbolo;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arBotones[i][j] = new Button(arEtiquetas[pos]+"");
                arBotones[i][j].setPrefSize(50,50);
                int finalPos = pos;
                arBotones[i][j].setOnAction(event -> setValue(arEtiquetas[finalPos]));
                gdpTeclado.add(arBotones[i][j],j,i);
                pos++;
            }
        }
    }

    private void setValue(char simbolo) {
        txtPantalla.appendText(simbolo+"");

    }

    /*private void setValue(char simbolo) {
        if (simbolo == '=') {
            try {
                String expresion = txtPantalla.getText();
                double resultado = evaluarExpresion(expresion);
                txtPantalla.setText(String.valueOf(resultado));
            } catch (Exception e) {
                txtPantalla.setText("Error");
            }
        } else {
            txtPantalla.appendText(simbolo + "");
        }
    }

    private double evaluarExpresion(String expresion) {
        String[] terminos = expresion.split("(?=[-+* /])|(?<=[-+* /])");

        double resultado = Double.parseDouble(terminos[0]);

        for (int i = 1; i < terminos.length; i += 2) {
            char operador = terminos[i].charAt(0);
            double siguienteNumero = Double.parseDouble(terminos[i + 1]);

            switch (operador) {
                case '+':
                    resultado += siguienteNumero;
                    break;
                case '-':
                    resultado -= siguienteNumero;
                    break;
                case '*':
                    resultado *= siguienteNumero;
                    break;
                case '/':
                    if (siguienteNumero != 0) {
                        resultado /= siguienteNumero;
                    } else {
                        throw new ArithmeticException("División por cero no permitida.");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Operador no válido: " + operador);
            }
        }

        return resultado;
    } */


}
