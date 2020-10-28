package com.mart.shinycounter;

import javafx.application.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShinyCounter extends Application {

    static int counter = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("pokeball.png")));

        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("encounter.fxml").openStream());
        Controller controller = fxmlLoader.getController();
        
        Scene mainScene = new Scene(p);

        mainScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER: controller.onMouseIncrease(); break;
                case BACK_SPACE:  controller.onMouseDecrease(); break;
                case R: controller.onMouseReset(); break;
            }

            controller.show();
        });

        primaryStage.setTitle("Pokemon Encounter");
        primaryStage.setScene(mainScene);



        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}