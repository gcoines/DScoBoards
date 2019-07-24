/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components;

import Jannaton.ScoreBoards.Components.Counter;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.UI.Fxml.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author german
 */
public class CounterComponent extends Controller {

    private Component counterComponent;
    @FXML
    private StackPane spCounter;
    @FXML
    private Label lbCounter;

    public CounterComponent() {
    }

    public void initialize() {
//        this.counterComponent = new Component(new Counter());
        //TODO initialize the label value with the Counter value
//        this.spCounter = (StackPane) this.getParent();
//        this.lbCounter = (Label) this.spCounter.getChildrenUnmodifiable().get(0);
//        this.lbCounter.setText(Integer.toString(((Counter)counterComponent.getComponent()).getValue()));
//        this.refreshUI();
    }

    public void initComponent(IScoreBoardPane pane) {
        this.counterComponent = new Component(pane);
    }

    public void setValue(String value){
        ((Counter) counterComponent.getComponent()).setValue(Integer.parseInt(value));
    }
    
    @Override
    public void refreshUI() {
        if (this.lbCounter != null) {
            this.lbCounter.setText(Integer.toString(((Counter) counterComponent.getComponent()).getValue()));
        } else {
            ((Label) this.getParent().lookup("#label")).setText(Integer.toString(((Counter) counterComponent.getComponent()).getValue()));
        }
    }
}
