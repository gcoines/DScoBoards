/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jannaton.displaying.fx.testing;

import Jannaton.Displaying.Fx.ScreensManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author german
 */
public class JannatonDisplayingFxTesting extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(JannatonDisplayingFxTesting.class, args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try{
        ScreensManager.getInstance().detectDisplays();
        }catch(Exception ex){}
    }
}
