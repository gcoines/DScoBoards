/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Displaying.Fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author german
 */
public class ScreenIndicatorUI implements Initializable {
    
    private static int screensCounter = 0;
    private int screenIndicator = 0;
    
    @FXML
    private Label label;
    
    @FXML
    private void hideAll(){
        ScreensManager.getInstance().hideDisplays();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        screensCounter++;
        this.screenIndicator = screensCounter;
        this.label.setText(Integer.toString(screenIndicator));
        this.label.setFont(Font.font("Verdana", 60));
    }    
    
    public static void resetCounter(){
        screensCounter = 0;
    }
}
