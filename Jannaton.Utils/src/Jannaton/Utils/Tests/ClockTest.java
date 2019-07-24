/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Tests;

import Jannaton.Utils.Clocks.Clock;
import Jannaton.Utils.Clocks.TimmingUtil;

/**
 *
 * @author german
 */
public class ClockTest {

    private static Clock clock1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        clock1 = new Clock();
        
        while(true){
           try{
               Thread.sleep(900);
               System.out.println(clock1.getTime(TimmingUtil.Format.HHMMSSmm) + " - " 
                       + clock1.getTime(TimmingUtil.Format.HHMMSS) + " - " 
                       + clock1.getTime(TimmingUtil.Format.HHMM) + " - " 
                       + clock1.getTime(TimmingUtil.Format.MMSSmm) + " - " 
                       + clock1.getTime(TimmingUtil.Format.MMSS) + " - " 
                       + clock1.getTime(TimmingUtil.Format.SSmm));
           } catch(Exception ex){
               System.out.println("error \n");
           }
        }
    }
}
