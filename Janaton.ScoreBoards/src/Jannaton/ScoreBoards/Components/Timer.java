/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Components;

import Jannaton.ScoreBoards.Components.Interfaces.TimerStartAction;
import Jannaton.ScoreBoards.Components.Interfaces.TimerStopAction;
import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.ScoreBoardPane;
import Jannaton.Utils.Clocks.TimmingUtil;

/**
 *
 * @author german
 */
public class Timer extends ScoreBoardPane {

    private Jannaton.Utils.Clocks.Timer timer;
    
    public Timer() {
        super(EnumScoreBoardPaneType.TIMER);
        this.addActions();
        //TODO externalize that in order to allow the time initialitzation
        this.setTimer(15, 0);
    }
    //TODO implement more initialitzation cases
    public void setTimer(int minutes, int seconds){
        this.timer = new Jannaton.Utils.Clocks.Timer(minutes, seconds, 0);
    }

    public String getTimerValue(TimmingUtil.Format format){
        return this.timer.getTime(format);
    }
    
    @Override
    public void addActions() {
        this.addManualAction(new TimerStartAction() {
//TODO action names have to be translated
            @Override
            public String getActionName() {
                return "Start";
            }

            @Override
            public void startTimer() {
                timer.start();
            }

            @Override
            public void executeAction() {
                this.startTimer();
            }
        });
        
        this.addManualAction(new TimerStopAction() {
//TODO action names have to be translated
            @Override
            public String getActionName() {
                return "Stop";
            }

            @Override
            public void stopTimer() {
                timer.pause();
            }

            @Override
            public void executeAction() {
                this.stopTimer();
            }
        });
    }

    @Override
    public void powerOn() {
        this.setTimer(0, 0);
    }

    @Override
    public void powerOff() {
        this.setTimer(0, 0);
    }

    @Override
    public void reset() {
        this.setTimer(0, 0);
    }
}
