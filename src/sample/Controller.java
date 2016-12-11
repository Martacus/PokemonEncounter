package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class Controller {

    Timer t = new Timer( );

    @FXML
    public Label encounter;

    int seconds = 0;

    @FXML
    public Label secondsLabel;

    public void onMouseIncrease(){
        Main.counter++;
        encounter.setText(Main.counter + "");

        seconds = 0;
        setSecondsText();
    }

    public void onMouseDecrease(){
        if(Main.counter >= 1){
            Main.counter--;
            encounter.setText(Main.counter + "");
        }
    }

    public void onMouseReset(){
        Main.counter = 0;
        encounter.setText(Main.counter + "");
    }

    public void show(){
        encounter.setText(Main.counter + "");
    }

    @FXML
    public void initialize() {
        t.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        seconds++;
                        setSecondsText();
                    }
                });
            }
        }, 0, 1000);
    }

    void setSecondsText(){
        secondsLabel.setText(seconds + "");
    }


}
