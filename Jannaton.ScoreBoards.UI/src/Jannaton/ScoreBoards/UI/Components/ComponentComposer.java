/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components;

//import Jannaton.ScoreBoards.Components.Counter;
import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author german
 */
public class ComponentComposer {
    
    private static ComponentComposer instance;
    
    private ComponentComposer(){};
    
    public static ComponentComposer getInstance(){
        if(instance == null)
            instance = new ComponentComposer();
        
        return instance;
    }
    
    private Parent loadComponent(String fileName){
        Parent parent = null;
        try{
            parent = FXMLLoader.load(getClass().getResource(fileName));
        }catch (IOException ex){
            //TODO implement exception reporting
        }finally{
            return parent;
        }
    }
    
    public Parent LoadComponent(EnumScoreBoardPaneType componentType){
        
        Parent parent = null;
        
        switch(componentType){
            case COUNTER:
                parent = this.loadComponent("CounterComponent.fxml");
                break;
        }
        
        return parent;
    }
    
}
