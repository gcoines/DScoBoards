/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components;

import Jannaton.ScoreBoards.Components.Text;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.UI.Fxml.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author german
 */
public class TextComponent extends Controller {

    private Component textComponent;
    
    @FXML
    private StackPane spText;
    
    @FXML
    private Label lbText;
    
    public TextComponent(){
        
    }
    
    public void initialize(){
//        this.textComponent = new Component(new Text());
        //TODO resolve field initialitzation
//        this.lbText.setText(((Text)textComponent.getComponent()).getValue());
//        this.lbText.setText("Test Text");
//        this.refreshUI();
    }
    
    public void initComponent(IScoreBoardPane pane){
        this.textComponent = new Component(pane);
    }

    public void setText(String text){
        ((Text)this.textComponent.getComponent()).setValue(text);
    }
    
    @Override
    public void refreshUI() {
        this.lbText.setText(((Text)this.textComponent.getComponent()).getValue());
    }
}
