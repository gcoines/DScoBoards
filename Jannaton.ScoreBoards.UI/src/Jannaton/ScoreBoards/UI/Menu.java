package Jannaton.ScoreBoards.UI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Jannaton.ScoreBoards.UI.Control.MenuViewModel;
import Jannaton.UI.Fxml.Controller;
import javafx.animation.FadeTransition;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
/**
 *
 * @author german
 */
public class Menu extends Controller{
    
    private static Menu instance;
    private MenuViewModel viewModel;
    @FXML private Label bpBottomLabel;
    
    
    public Menu(){
//        super();
        this.viewModel = new MenuViewModel();
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
    private void btnScoreBoardsAction(ActionEvent event) {
        //TODO revisar conversion de ActionEvent fxml a ActionEvent awt
        MenuViewModel.callListener(MenuViewModel.ScoreBoardsButtonListener);
    }
    
    @FXML
    private void btnDisplaysAction(ActionEvent event) {
        MenuViewModel.callListener(MenuViewModel.DisplaysButtonListener);
    }
    
    @FXML
    private void btnConfigAction(ActionEvent event) {
        MenuViewModel.callListener(MenuViewModel.ConfigButtonListener);
    }
    
    @FXML
    private void btnStartAction(ActionEvent event) {
        MenuViewModel.callListener(MenuViewModel.StartButtonListener);
    }
    
    @FXML
    private void btnExitAction(ActionEvent event) {
        MenuViewModel.callListener(MenuViewModel.ExitListener);
    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Menu();
        }
        
        return instance;
    }    

    @Override
    public void refreshUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
