/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components;

import Jannaton.ScoreBoards.Components.Timer;
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
public class TimerComponent extends Controller {

    private Component timerComponent;
    private TimeLineAnimation animation;
    
    @FXML
    private StackPane spTimer;
    
    @FXML
    private Label lbTimer;
    
    public TimerComponent(){
        
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
        this.timerComponent = new Component(pane);
    }
    
    public void setTime(String time){
        int minutes = Integer.parseInt(time.split("m")[0]);
        int seconds = Integer.parseInt(time.split("m")[1].split("s")[0]);
        this.setTime(minutes, seconds);
    }
    
    public void setTime(int minutes, int seconds){
        ((Timer)this.timerComponent.getComponent()).setTimer(minutes, seconds);
    } 
    
    @Override
    public void refreshUI() {
        this.lbTimer.setText(((Timer)timerComponent.getComponent()).getTimerValue(TimmingUtil.Format.MMSS));
    }
}
