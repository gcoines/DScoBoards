/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.Emulators.Hardware.Interfaces.IPowereable;
import Jannaton.Emulators.Hardware.Interfaces.IReseteable;
import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.ScoreBoards.Interfaces.ScoreBoardPaneAutomaticAction;
import Jannaton.ScoreBoards.Interfaces.ScoreBoardPaneManualAction;
import java.util.ArrayList;

/**
 *
 * @author german
 */
public abstract class ScoreBoardPane implements IScoreBoardPane, IPowereable, IReseteable{
    
    private EnumScoreBoardPaneType type;
    
    private String id;
    
    private ArrayList<ScoreBoardPaneAutomaticAction> automaticActions;
    
    private ArrayList<ScoreBoardPaneManualAction> manualActions;
    
    public ScoreBoardPane(EnumScoreBoardPaneType type){
        this.initialize(type);
    }
    
    private void initialize(EnumScoreBoardPaneType type){
        this.type = type;
        automaticActions = new ArrayList<ScoreBoardPaneAutomaticAction>();
        manualActions = new ArrayList<ScoreBoardPaneManualAction>();
    }
    
    @Override
    public String getId(){
        return this.id;
    }
    
    @Override
    public void setId(String id){
        this.id = id;
    }
    
    @Override
    public EnumScoreBoardPaneType getType() {
        return type; 
    }
    
    @Override
    public void addAutomaticAction(ScoreBoardPaneAutomaticAction action){
        this.automaticActions.add(action);
    }
    
    
    @Override
    public void addManualAction(ScoreBoardPaneManualAction action){
        this.manualActions.add(action);
    }
    
    @Override
    public ArrayList<ScoreBoardPaneAutomaticAction> getAutomaticActions() {
        return this.automaticActions;
    }

    @Override
    public ArrayList<ScoreBoardPaneManualAction> getManualActions() {
        return this.manualActions;
    }
}
