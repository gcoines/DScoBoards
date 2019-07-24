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
public class DisplaySelectorViewModel extends ViewModel{
    
    private static int selectedScoreBoardIndex = -1;
    
    private static int selectedScreenIndex = -1;
    
    public static ActionListener GoBackButtonListener;
    
    public static ActionListener DetectDisplaysButtonListener;
    
    public static ActionListener AutoasignateButtonListener;   
    
    public static ActionListener ScoreBoardAsignationCompleted;
    
    public static int GetScoreBoardIndex(){
        return selectedScoreBoardIndex;
    }
    
    public static int GetScreenIndex(){
        return selectedScreenIndex;
    }
    
    public static void setScoreBoardIndex(int index){
        selectedScoreBoardIndex = index;
    }
    
    public static void setScreenIndex(int index){
        selectedScreenIndex = index;
    }
}
