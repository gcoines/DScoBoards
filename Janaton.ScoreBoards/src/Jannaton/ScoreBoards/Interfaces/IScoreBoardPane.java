/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

import java.util.ArrayList;

/**
 *
 * @author german
 */
public interface IScoreBoardPane {
    
    EnumScoreBoardPaneType getType();
    
    String getId();
    
    void setId(String id);
    
    void addActions();
    
    void addAutomaticAction(ScoreBoardPaneAutomaticAction action);
    
    void addManualAction(ScoreBoardPaneManualAction action);
    
    ArrayList<ScoreBoardPaneAutomaticAction> getAutomaticActions();
    
    ArrayList<ScoreBoardPaneManualAction> getManualActions();
    
}
