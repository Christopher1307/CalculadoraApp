package org.Calculadora;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class RootController {

    @FXML
    private VBox buttonBox;

    @FXML
    private VBox calcBox;

    @FXML
    private TextField nameText;

    @FXML
    private BorderPane root;  // Asegúrate de que este elemento coincida con el root en el archivo FXML

    private Calculadora calculadora;

    public RootController() {
        this.calculadora = new Calculadora();  // Inicializamos la calculadora
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculadoraView.fxml"));
            loader.setController(this);
            root = loader.load();  // Cargar el FXML y asignar el root
        } catch (IOException e) {
            e.printStackTrace();  // Imprimir el error en consola
            throw new RuntimeException("No se pudo cargar el archivo FXML", e);  // Manejo de excepciones
        }
    }

    // Método para manejar los clics de los números
    @FXML
    private void handleNumberClick(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();
        char digit = buttonText.charAt(0);
        calculadora.insertar(digit);
        updateDisplay();
    }

    // Método para manejar los clics de operadores (+, -, *, /)
    @FXML
    private void handleOperatorClick(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        char operator = clickedButton.getText().charAt(0);
        calculadora.operar(operator);
        updateDisplay();
    }

    // Método para manejar el botón de "="
    @FXML
    private void handleEqualsClick(javafx.event.ActionEvent event) {
        calculadora.operar(Calculadora.IGUAL);
        updateDisplay();
    }

    // Método para manejar el botón "CE" (borrar todo)
    @FXML
    private void handleClearEntryClick(javafx.event.ActionEvent event) {
        calculadora.borrarTodo();
        updateDisplay();
    }

    // Método para manejar el botón "C" (borrar calculadora)
    @FXML
    private void handleClearClick(javafx.event.ActionEvent event) {
        calculadora.borrar();
        updateDisplay();
    }

    // Método para manejar el botón de insertar coma
    @FXML
    private void handleCommaClick(javafx.event.ActionEvent event) {
        calculadora.insertarComa();
        updateDisplay();
    }

    // Actualizar el valor mostrado en la pantalla
    private void updateDisplay() {
        nameText.setText(calculadora.getPantalla());
    }

    public BorderPane getRoot() {
        return root;
    }
}



