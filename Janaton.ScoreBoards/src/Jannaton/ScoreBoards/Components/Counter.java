/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Components;

import Jannaton.ScoreBoards.Components.Interfaces.CounterAction;
import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.ScoreBoardPane;

/**
 *
 * @author german
 */
public class Counter extends ScoreBoardPane{
    
    private int countValue;
    
    public Counter(){
        super(EnumScoreBoardPaneType.COUNTER);
        this.addActions();
    }

    @Override
    public void powerOn() {
        this.countValue = 0;
    }

    @Override
    public void powerOff() {
        this.countValue = 0;
    }

    @Override
    public void reset() {
        this.countValue = 0;
    }

    @Override
    public final void addActions() {
        this.addManualAction(new CounterAction() {

            @Override
            public String getActionName() {
                return "+ 1";
            }

            @Override
            public int countValue() {
                return countValue++;
            }

            
            @Override
            public void executeAction() {
                this.countValue();
            }


        });
        
        this.addManualAction(new CounterAction() {

            @Override
            public String getActionName() {
                return "- 1";
            }

            @Override
            public int countValue() {
                return countValue--;
            }

            @Override
            public void executeAction() {
                this.countValue();
            }
        });
            
        this.addManualAction(new CounterAction() {

            @Override
            public String getActionName() {
                return "+ 2";
            }

            @Override
            public int countValue() {
                return countValue+=2;
            }
            
            @Override
            public void executeAction() {
                this.countValue();
            }
        });
        
        this.addManualAction(new CounterAction() {

            @Override
            public String getActionName() {
                return "- 2";
            }

            @Override
            public int countValue() {
                return countValue-=2;
            }
            
            @Override
            public void executeAction() {
                this.countValue();
            }
        });
        
        this.addManualAction(new CounterAction() {

            @Override
            public String getActionName() {
                return "+ 3";
            }

            @Override
            public int countValue() {
                return countValue+=3;
            }
            
            @Override
            public void executeAction() {
                this.countValue();
            }
        });
        
        this.addManualAction(new CounterAction() {

            @Override
            public String getActionName() {
                return "- 3";
            }

            @Override
            public int countValue() {
                return countValue-=3;
            }
            
            @Override
            public void executeAction() {
                this.countValue();
            }
        });
    }
    
    public void setValue(int value){
        this.countValue = value;
    }
    
    public int getValue(){
        return this.countValue;
    }
}
