package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.*;
import java.util.Scanner;
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
        saveData();
    }

    public void onMouseDecrease(){
        if(Main.counter >= 1){
            Main.counter--;
            encounter.setText(Main.counter + "");
        }
        saveData();
    }

    public void onMouseReset(){
        Main.counter = 0;
        encounter.setText(Main.counter + "");
        saveData();
    }

    public void show(){
        encounter.setText(Main.counter + "");
    }

    @FXML
    public void initialize() {
        checkForDirectories();
        checkForFile();

        setEncounterNumber();

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


    private void checkForDirectories(){
        File dataDir = new File("encounterData");
        if (!dataDir.exists()) {
            if (dataDir.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }

    private boolean checkForFile(){
        File file = new File("encounterData\\data.txt");

        try {
            if (file.createNewFile()){
                saveData();
                return true;
            }else{
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void saveData(){
        File file = new File("encounterData\\data.txt");
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(Main.counter + "");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setEncounterNumber(){
        if(checkForFile()){
            FileInputStream fis = null;

            try {
                fis = new FileInputStream("encounterData\\data.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            assert fis != null;
            Scanner scanner = new Scanner(fis);
            String firstLine = scanner.nextLine();

            Main.counter = Integer.parseInt(firstLine);
            encounter.setText(Main.counter + "");
        }
    }


}
