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
public class ScoreBoardSelectorViewModel  extends ViewModel{
    
    //TODO it should contain a Sport list or something like that
    
    public static ActionListener GoBackButtonListener;
    
    public static ActionListener BasketballButtonListener;
    
    public static ActionListener FootballButtonListener;
    
    //TODO implement generic buttonlisteners to allow multisports configuration
    //depending butons behaviours
    
    //Functions
    public String setTextListener(String objectId){
        //TODO resolve with translation system
        switch(objectId){
            case "btnBasketball":
                return "1. BALONCESTO";
            case "btnFootball":
                return "2. FÚTBOL";
            case "btnTennis":
                return "3. TENNIS";
            case "btnRugby":
                return "4. RUGBY";
            default:
                return "";
        }
    }
    
    public String resetTextListener(){
        //TODO resolve with translation system
        return "";
    }
}
