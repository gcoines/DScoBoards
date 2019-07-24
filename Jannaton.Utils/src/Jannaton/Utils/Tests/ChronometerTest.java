/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Tests;

import Jannaton.Utils.Clocks.Chronometer;
import Jannaton.Utils.Clocks.TimmingUtil;

/**
 *
 * @author german
 */
public class ChronometerTest {

    /**
     * @param args the command line arguments
     */
    private static Chronometer chronometer1;
    private static Chronometer chronometer2;
    private static Chronometer chronometer3;
    
    private boolean running;
    
    public static void main(String[] args) {
        // TODO code application logic here
        chronometer1 = new Chronometer(0, 0, 0, 0);
        chronometer2 = new Chronometer(0, 0, 0);
        chronometer3 = new Chronometer(10, 0);
        
//        chronometer1.setChronometerMaxValue(1, 1, 2, 987);
//        chronometer2.setSecondsMaxValue(30);
//        chronometer3.setMinutesMaxValue(1);
        
        chronometer1.start();
        chronometer2.start();
        chronometer3.start();
        
        while(true){
           try{
               Thread.sleep(50);
//               System.out.println(chronometer1.getTime(TimmingUtil.Format.MMSS) + " - " 
//                       + chronometer2.getTime(TimmingUtil.Format.MMSSmm) + " - " 
//                       + chronometer3.getTime(TimmingUtil.Format.SSmm));
               System.out.println(chronometer1.getTime(TimmingUtil.Format.HHMMSSmm));
           } catch(Exception ex){
               System.out.println("error \n");
           }
        }
    }
}
