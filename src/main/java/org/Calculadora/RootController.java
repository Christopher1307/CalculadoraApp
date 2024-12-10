package org.Calculadora;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RootController {

    @FXML
    private Button ceroButton;

    @FXML
    private Button unoButton;

    @FXML
    private Button dosButton;

    @FXML
    private Button tresButton;

    @FXML
    private Button cuatroButton;

    @FXML
    private Button cincoButton;

    @FXML
    private Button seisButton;

    @FXML
    private Button sieteButton;

    @FXML
    private Button ochoButton;

    @FXML
    private Button nueveButton;

    @FXML
    private Button sumarButton;

    @FXML
    private Button restarButton;

    @FXML
    private Button multiplicarButton;

    @FXML
    private Button dividirButton;

    @FXML
    private Button acButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button decimalButton;

    @FXML
    private Button igualButton;

    @FXML
    private TextField displayTextField;

    private Calculadora calc;

    public RootController() {
        calc = new Calculadora();
    }

    @FXML
    public void initialize() {
        displayTextField.textProperty().bind(calc.pantallaProperty());
    }

    @FXML
    void handleNumberInput(ActionEvent event) {
        Button btn = (Button) event.getSource();
        calc.insertar(btn.getText().charAt(0));
    }

    @FXML
    void handleOperation(ActionEvent event) {
        Button btn = (Button) event.getSource();
        char operador = btn.getText().charAt(0);
        calc.operar(operador);
    }

    @FXML
    void handleClear(ActionEvent event) {
        calc.borrar();
    }

    @FXML
    void handleClearEntry(ActionEvent event) {
        calc.borrarTodo();
    }

    @FXML
    void handleDecimal(ActionEvent event) {
        calc.insertarComa();
    }

    @FXML
    void handleEquals(ActionEvent event) {
        calc.operar(Calculadora.IGUAL);
    }
}


