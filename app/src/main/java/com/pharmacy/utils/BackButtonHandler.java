package com.pharmacy.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class BackButtonHandler {
    private static BackButtonHandler instance;
    private Stack<Scene> sceneStack;
    private Stage primaryStage;

    private BackButtonHandler(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.sceneStack = new Stack<>();
    }

    public static BackButtonHandler getInstance(Stage primaryStage) {
        if (instance == null) {
            instance = new BackButtonHandler(primaryStage);
        }
        return instance;
    }

    public void pushScene(Scene scene) {
        sceneStack.push(scene);
    }

    public void goBack() {
        if (!sceneStack.isEmpty()) {
            Scene previousScene = sceneStack.pop();
            primaryStage.setScene(previousScene);
        }
    }
}
