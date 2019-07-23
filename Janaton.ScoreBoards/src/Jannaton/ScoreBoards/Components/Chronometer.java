/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Components;

import Jannaton.ScoreBoards.Components.Interfaces.ChronometerStartAction;
import Jannaton.ScoreBoards.Components.Interfaces.ChronometerStopAction;
import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.ScoreBoardPane;
import Jannaton.Utils.Clocks.TimmingUtil;

/**
 *
 * @author german
 */
public class Chronometer extends ScoreBoardPane{

    private Jannaton.Utils.Clocks.Chronometer chronometer;
    
    public Chronometer() {
        super(EnumScoreBoardPaneType.CHRONOMETER);
        this.addActions();
        //TODO externalize that in order to allow the time initialitzation
        this.setChronometer(0, 0, 0, 0);
    }
    
    //TODO implement more initialitzation cases
    public void setChronometer(int hours, int minutes, int seconds, int milliseconds){
        this.chronometer = new Jannaton.Utils.Clocks.Chronometer(hours, minutes, seconds, milliseconds);
    }
    
    public String getChronometerValue(TimmingUtil.Format format){
        return this.chronometer.getTime(format);
    }
    
    @Override
    public void addActions() {
        this.addManualAction(new ChronometerStartAction() {

            @Override
            public void startChronometer() {
                chronometer.start();
            }

            @Override
            public void executeAction() {
                this.startChronometer();
            }

            @Override
            public String getActionName() {
                return "Start";
            }
        });
        
        this.addManualAction(new ChronometerStopAction() {

            @Override
            public void stopChronometer() {
                chronometer.pause();
            }

            @Override
            public void executeAction() {
                this.stopChronometer();
            }

            @Override
            public String getActionName() {
                return "Stop";
            }
        });
    }

    @Override
    public void powerOn() {
//        this.chronometer.setChronometer(0, 0);
    }

    @Override
    public void powerOff() {
//        this.setChronometer(0, 0);
    }

    @Override
    public void reset() {
//        this.setChronometer(0, 0);
    }
    
}
