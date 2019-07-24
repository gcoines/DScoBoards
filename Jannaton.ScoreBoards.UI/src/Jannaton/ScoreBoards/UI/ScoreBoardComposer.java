/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author german
 */
public class ScoreBoardComposer {
    
    private static ScoreBoardComposer instance;
    
    private ScoreBoardComposer(){
        
    }
    
    public static ScoreBoardComposer getInstance(){
        if(instance == null)
            instance = new ScoreBoardComposer();
        
        return instance;
    }
    
    public ScoreBoard loadScoreBoard(IScoreBoard scoreBoard) throws IOException{
        ScoreBoard scoreboard = (ScoreBoard)ScoreBoard.getInstance(); 
        
        //TODO implement loading process
        Parent parent = (Parent) FXMLLoader.load(getClass().getResource("ScoreBoard.fxml")); 
        scoreboard.setParent(parent);
        scoreboard.composeScoreBoard(scoreBoard);
        
        return scoreboard;
    }
}
