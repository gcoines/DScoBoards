/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components;

import Jannaton.ScoreBoards.Components.Chronometer;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.UI.Fxml.Controller;
import Jannaton.Utils.Clocks.TimmingUtil;
import Jannaton.Utils.Fx.Interfaces.IAction;
import Jannaton.Utils.Fx.TimeLineAnimation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author german
 */
public class ChronometerComponent extends Controller {

    private Component chronometerComponent;
    private TimeLineAnimation animation;
    
    @FXML
    private StackPane spChrometer;
    
    @FXML
    private Label lbChronometer;
    
    public ChronometerComponent(){
        
    }
    
    public void initialize(){
        this.animation = new TimeLineAnimation(new IAction() {

            @Override
            public void execute() {
                refreshUI();
            }
        }, 100);
        this.animation.play();
    }
    
    public void initComponent(IScoreBoardPane pane) {
        this.chronometerComponent = new Component(pane);
    }
    
    public void setTime(String time){
        int minutes = Integer.parseInt(time.split("m")[0]);
        int seconds = Integer.parseInt(time.split("m")[1].split("s")[0]);
        this.setTime(minutes, seconds);
    }
    
    public void setTime(int minutes, int seconds){
        ((Chronometer)this.chronometerComponent.getComponent()).setChronometer(0, minutes, seconds, 0);
    } 
    
    @Override
    public void refreshUI() {
        this.lbChronometer.setText(((Chronometer)chronometerComponent.getComponent()).getChronometerValue(TimmingUtil.Format.MMSS));
    }

      
}
