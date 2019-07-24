/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Control;

import Jannaton.UI.Control.ViewModel;
import java.awt.event.ActionListener;

/**
 *
 * @author german
 */
public class MenuViewModel extends ViewModel{
    
    //Listeners
    public static ActionListener DisplaysButtonListener;
    
    public static ActionListener ConfigButtonListener;
    
    public static ActionListener ScoreBoardsButtonListener;
    
    public static ActionListener StartButtonListener;
    
    public static ActionListener ResetTextListener;
    
    //Functions
    public String setTextListener(String objectId){
        //TODO resolve with translation system
        switch(objectId){
            case "btnScoreBoards":
                return "1. SELECCIONAR DEPORTE";
            case "btnDisplays":
                return "2. SELECCIONAR PANTALLAS";
            case "btnConfig":
                return "3. CONFIGURAR";
            case "btnStart":
                return "4. EMPEZAR";
            default:
                return "";
        }
    }
    
    public String resetTextListener(){
        //TODO resolve with translation system
        return "";
    }
    
}
