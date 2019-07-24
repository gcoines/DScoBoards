/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Fx;

import Jannaton.Utils.Fx.Interfaces.IAction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 *
 * @author german
 */
public class TimeLineAnimation {
    
    private Timeline timeline;
    private final IAction animationAction;

    public TimeLineAnimation(IAction action, int cycleMilliseconds) {
        this.animationAction = action;
        this.timeline = new Timeline();

        if (action != null) {
            this.timeline.getKeyFrames().add(new KeyFrame(new Duration(cycleMilliseconds),
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            animationAction.execute();
                        }
                    }));
        }

        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public TimeLineAnimation(IAction action, int cycleMilliseconds, int cycleCount) {
        this.animationAction = action;
        this.timeline = new Timeline();

        if (action != null) {
            this.timeline.getKeyFrames().add(new KeyFrame(new Duration(cycleMilliseconds),
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            animationAction.execute();
                        }
                    }));
        }

        if (cycleCount != 0) {
            this.timeline.setCycleCount(cycleCount);
        }
    }
    
    public void play(){
        this.timeline.play();
    }
    
    public void stop(){
        this.timeline.stop();
    }

}
