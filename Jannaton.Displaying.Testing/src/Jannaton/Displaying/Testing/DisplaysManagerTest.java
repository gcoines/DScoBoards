/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Displaying.Testing;

import Jannaton.Displaying.DisplaysManager;

/**
 *
 * @author german
 */
public class DisplaysManagerTest {
    
    public static void main(String[] args){
        DisplaysManager manager = DisplaysManager.getInstance();
        
        manager.detectDisplays();
    }
}
