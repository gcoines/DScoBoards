/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author german
 */
public class ScoreBoardControlComposer {
    
    private static ScoreBoardControlComposer instance;
    
    private ScoreBoardControlComposer(){
        
    }
    
    public static ScoreBoardControlComposer getInstance(){
        if(instance == null){
            instance = new ScoreBoardControlComposer();
        }
        
        return instance;
    }
    
        
    public ScoreBoardControl loadScoreBoardControl(ScoreBoard controller, IScoreBoard scoreboard) throws IOException{
        ScoreBoardControl control = (ScoreBoardControl)ScoreBoardControl.getInstance(); 
        
        //TODO implement loading process
        Parent parent = (Parent) FXMLLoader.load(getClass().getResource("ScoreBoardControl.fxml")); 
        control.setParent(parent);
        control.composeControl(controller, scoreboard);
        
        return control;
    }
}
