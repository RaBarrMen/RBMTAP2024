package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage {
    private Scene escena;
    private VBox vcontenedor;
    private GridPane gdpTeclado;
    private TextField txtPantalla;
    private Button [][] arBotones = new Button[5][4];
    private Character[] arEtiquetas ={'c', '%', 'x', 'x', '7', '8', '9', '/', '4', '5', '6', '*', '1', '2', '3', '-', '0', '.', '=', '+'};
    private StringBuilder operacionActual = new StringBuilder();

    public Calculadora() {
        CrearUI();
        this.setTitle("Mi primer calculadora en FX");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        txtPantalla = new TextField("");
        txtPantalla.setEditable(false);
        gdpTeclado = new GridPane();
        CrearTeclado();
        vcontenedor = new VBox(txtPantalla, gdpTeclado);
        vcontenedor.setSpacing(5);
        escena = new Scene(vcontenedor, 200, 200);

        escena.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            char tecla = event.getCharacter().charAt(0);
            if (Character.isDigit(tecla) || tecla == '.' || esOperador(tecla) || tecla == '=') {
                event.consume();
                procesarTecla(tecla);
            }
        });

        escena.getStylesheets()
                .add(getClass().getResource("/estilos/calculadora.css").toString());
    }

    private void CrearTeclado() {
        int pos = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                arBotones[i][j] = new Button(arEtiquetas[pos] + "");
                arBotones[i][j].setPrefSize(50, 50);
                int finalPos = pos;
                arBotones[i][j].setOnAction(event -> procesarTecla(arEtiquetas[finalPos]));

                gdpTeclado.add(arBotones[i][j], j, i);

                if (esOperador(arEtiquetas[pos])) {
                    arBotones[i][j].setId(("color-operador"));
                }
                pos++;
            }
        }
    }

    private boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private void procesarTecla(char tecla) {
        if (tecla == '=') {
            String expresion = operacionActual.toString();
            double resultado = evaluarExpresion(expresion);
            txtPantalla.setText(String.valueOf(resultado));
            operacionActual.setLength(0);
            operacionActual.append(resultado);
        } else if (tecla == 'c') {
            limpiarPantalla();
        } else if (esOperador(tecla)) {
            // Cuando se presiona un operador, actualiza el TextField y reinicia la operación
            operacionActual.setLength(0);
            txtPantalla.setText(tecla + "");
        } else {
            operacionActual.append(tecla);
            txtPantalla.setText(operacionActual.toString());
        }
    }



    private void limpiarPantalla() {
        txtPantalla.clear();
        operacionActual.setLength(0);
    }

    private double evaluarExpresion(String expresion) {
        String[] terminos = expresion.split("(?=[-+*/])|(?<=[-+*/])");

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
                        // Devuelve un valor especial (puedes ajustarlo según tus necesidades)
                        return Double.NaN;  // NaN representa "Not a Number"
                    }
                    break;
                default:
                    txtPantalla.setText("Operador no válido: " + operador);
            }
        }

        return resultado;
    }



}
