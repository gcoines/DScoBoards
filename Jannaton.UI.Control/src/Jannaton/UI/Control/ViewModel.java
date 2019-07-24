/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.UI.Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author german
 */
public class ViewModel {
    
    public static ActionListener InitialitzationListener;
    public static ActionListener ModificationListener;
    public static ActionListener ExitListener;
    
    public static void callListener(ActionListener listener){
        if(listener != null)
            listener.actionPerformed(null);
    }
    
    public static void callListener(ActionListener listener, ActionEvent event){
        if(listener != null && event != null)
            listener.actionPerformed(event);
    }
}
