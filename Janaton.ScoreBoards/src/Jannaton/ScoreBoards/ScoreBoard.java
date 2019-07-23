/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.Emulators.Hardware.Interfaces.IPowereable;
import Jannaton.Emulators.Hardware.Interfaces.IReseteable;
import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import Jannaton.ScoreBoards.Interfaces.ScoreBoardPaneAction;
import Jannaton.ScoreBoards.Interfaces.ScoreBoardPaneAutomaticAction;
import Jannaton.ScoreBoards.Interfaces.ScoreBoardPaneManualAction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author german
 */
public class ScoreBoard implements IScoreBoard, IPowereable, IReseteable{
    
    private String name;
    private List<IScoreBoardPane> panes;
    private IScoreBoardUIInfo uiInfo;
    
    public ScoreBoard(){
        this.name = "";
        this.panes = new ArrayList<IScoreBoardPane>();
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public IScoreBoardPane getPaneById(String id) {
        if(this.panes != null && id != null){
            for(IScoreBoardPane pane : this.panes){
                if(id.equals(pane.getId())){
                    return pane;
                }
            }
        }
        return null;
    }
    
    @Override
    public List<IScoreBoardPane> getPanes(){
        return this.panes;
    }
    
    @Override
    public void setPanes(List<IScoreBoardPane> panes) {
        this.panes = panes;
    }
    
    @Override
    public List<ScoreBoardPaneAction> getPanesActions(){
        List<ScoreBoardPaneAction> actions = new ArrayList<ScoreBoardPaneAction>();
        for(IScoreBoardPane pane : panes){
            ArrayList<ScoreBoardPaneAutomaticAction> automaticActions = 
                new ArrayList<ScoreBoardPaneAutomaticAction>();
            ArrayList<ScoreBoardPaneManualAction> manualActions = pane.getManualActions();
            actions.addAll(automaticActions);
            actions.addAll(manualActions);
        }
        
        return actions;
    }
    
    public List<ScoreBoardPaneAutomaticAction> getAutoActions(){
        ArrayList<ScoreBoardPaneAutomaticAction> automaticActions = 
                new ArrayList<ScoreBoardPaneAutomaticAction>();
        for(IScoreBoardPane pane : this.panes){
             automaticActions.addAll(pane.getAutomaticActions());
        }
        return automaticActions;
    }
    
    public List<ScoreBoardPaneManualAction> getManualActions(){
        ArrayList<ScoreBoardPaneManualAction> actions = 
                new ArrayList<ScoreBoardPaneManualAction>();
        for(IScoreBoardPane pane : this.panes){
             actions.addAll(pane.getManualActions());
        }
        return actions;
    }
    
    @Override
    public void powerOn(){
        for(IScoreBoardPane pane : panes){
            ((ScoreBoardPane)pane).powerOn();
        }
    }
    
    @Override
    public void powerOff(){
        for(IScoreBoardPane pane : panes){
            ((ScoreBoardPane)pane).powerOff();
        }
    }
    
    @Override
    public void reset(){
        for(IScoreBoardPane pane : panes){
            ((ScoreBoardPane)pane).reset();
        }
    }

    @Override
    public IScoreBoardUIInfo getUiIinfo() {
        return this.uiInfo;
    }

    @Override
    public void setUiIinfo(IScoreBoardUIInfo uiInfo) {
        this.uiInfo = uiInfo;
    }


}
