package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class Controller {

    @FXML
    public Label encounter;

    public void onMouseIncrease(){
        Main.counter++;
        encounter.setText(Main.counter + "");
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
}
