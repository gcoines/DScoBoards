/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

import java.util.List;

/**
 *
 * @author german
 */
public interface IScoreBoard {
    
    void powerOn();
    
    void powerOff();
    
    String getName();
    
    void setName(String name);
    
    IScoreBoardUIInfo getUiIinfo();
    
    void setUiIinfo(IScoreBoardUIInfo uiInfo);
    
    IScoreBoardPane getPaneById(String id);
    
    List<IScoreBoardPane> getPanes();
    
    void setPanes(List<IScoreBoardPane> panes);
    //TODO review next functions. Have to be here? or accesible via every Pane?
    List<ScoreBoardPaneAction> getPanesActions();
}
