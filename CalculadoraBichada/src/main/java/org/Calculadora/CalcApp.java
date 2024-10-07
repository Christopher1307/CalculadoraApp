package org.Calculadora;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalcApp extends Application {

    private RootController rootController = new RootController();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(new Scene(rootController.getRoot()));
        primaryStage.show();
    }

}
