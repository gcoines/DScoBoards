/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.UI.Control.ScoreBoardSelectorViewModel;
import Jannaton.UI.Fxml.Controller;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author german
 */
public class ScoreBoardSelector extends Controller {
    
    private static ScoreBoardSelector instance;
    private ScoreBoardSelectorViewModel viewModel;
    @FXML private Label bpBottomLabel;
    
    public ScoreBoardSelector(){
        super();
        instance = this;
        this.viewModel = new ScoreBoardSelectorViewModel();
    }
    
    @FXML
    private void highlightOn(MouseEvent event) {
        //TODO revisar conversion de ActionEvent fxml a ActionEvent awt
        StackPane sp = (StackPane)event.getSource();
        Circle highlight = (Circle)sp.getChildren().get(0);
        
        FadeTransition fadeIn = new FadeTransition(new Duration(200), highlight);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1.0);

        fadeIn.play();
    }
        
    @FXML
    private void highlightOff(MouseEvent event) {
        //TODO revisar conversion de ActionEvent fxml a ActionEvent awt
        StackPane sp = (StackPane)event.getSource();
        Circle highlight = (Circle)sp.getChildren().get(0);
        
        FadeTransition fadeIn = new FadeTransition(new Duration(200), highlight);
        fadeIn.setFromValue(1.0);
        fadeIn.setToValue(0);

        fadeIn.play();
    }
    
    @FXML
    private void setLabelText(MouseEvent event) {
        //TODO revisar conversion de ActionEvent fxml a ActionEvent awt
        Button button = (Button)event.getSource();
        String id = button.getId();
        bpBottomLabel.setText(this.viewModel.setTextListener(id));
    }
        
    @FXML
    private void resetLabelText(MouseEvent event) {
        //TODO revisar conversion de ActionEvent fxml a ActionEvent awt 
        bpBottomLabel.setText("");
    }
    
    @FXML
    private void btnBasketballAction(ActionEvent event) {
        ScoreBoardSelectorViewModel.callListener(ScoreBoardSelectorViewModel.BasketballButtonListener);
    }
    
    @FXML
    private void btnFootballAction(ActionEvent event) {
        ScoreBoardSelectorViewModel.callListener(ScoreBoardSelectorViewModel.FootballButtonListener);
    }
    
    @FXML
    private void btnBack(ActionEvent event) {
        ScoreBoardSelectorViewModel.callListener(ScoreBoardSelectorViewModel.GoBackButtonListener);
    }
    
    //TODO implement some auto btnActions generation stuff to allow the UI load configuration depending behaviours
    public static Controller getInstance(){
        if(instance == null)//TODO ojo siguiente linea
            instance = new ScoreBoardSelector();
        
        return instance;
    }

    @Override
    public void refreshUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
