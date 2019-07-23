/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Components;

import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.ScoreBoardPane;

/**
 *
 * @author german
 */
public class Text extends ScoreBoardPane{

    private String textValue;
            
    public Text(){
        super(EnumScoreBoardPaneType.TEXT);
    }
    
    @Override
    public void addActions() {
        
    }

    @Override
    public void powerOn() {
        this.textValue = "";
    }

    @Override
    public void powerOff() {
        this.textValue = "";
    }

    @Override
    public void reset() {
        
    }
    
    public String getValue(){
        return this.textValue;
    }
    
    public void setValue(String text){
        this.textValue = text;
    }
}
