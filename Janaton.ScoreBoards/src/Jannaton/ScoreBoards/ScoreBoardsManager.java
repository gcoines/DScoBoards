/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.IComponentInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import Jannaton.ScoreBoards.Interfaces.IStyleInfo;
import Jannaton.ScoreBoards.Interfaces.IStylesInfo;

/**
 *
 * @author german
 */
public class ScoreBoardsManager {
    
    private static ScoreBoardsManager instance;
    
    private ScoreBoardsManager(){
        
    }
    
    public static ScoreBoardsManager getInstance(){
        if(instance == null)
            instance = new ScoreBoardsManager();
        
        return instance;
    }
    
    public IScoreBoard createScoreBoard(){
        return new ScoreBoard();
    }
    
}
