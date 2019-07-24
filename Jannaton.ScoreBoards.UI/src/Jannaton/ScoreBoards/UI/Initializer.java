package Jannaton.ScoreBoards.UI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author german
 */
public class Initializer extends Application {
    
    private Parent menuParent;
    private Parent scoreBoardSelectorParent;
    private Parent scoreBoardConfiguratorParent;
    private Parent displaySelectorParent;
    
    public static void main(String[] args){
        launch(Initializer.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.loadFXMLs();
        //TODO review if the main Stage have to be the applicaction one, or the main one obtained by ScreenManager
        UIMaster.getInstance().Initialize(stage, menuParent, scoreBoardSelectorParent, 
                scoreBoardConfiguratorParent, displaySelectorParent);
        
        //TODO initialize rest of screens with diferent Stage instances in order 
        //to show the App logo until another things have to be shown in them.
    }
    
    private void loadFXMLs() throws IOException{
        
        menuParent = (Parent) FXMLLoader.load(getClass().getResource("Menu.fxml"));
        scoreBoardSelectorParent = (Parent) FXMLLoader.load(getClass().getResource("ScoreBoardSelector.fxml"));
        scoreBoardConfiguratorParent = (Parent) FXMLLoader.load(getClass().getResource("ScoreBoardConfigurator.fxml"));
        displaySelectorParent = (Parent) FXMLLoader.load(getClass().getResource("DisplaySelector.fxml"));
        
    }
    
}
