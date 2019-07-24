/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Tests;

import Jannaton.Utils.Clocks.Timer;
import Jannaton.Utils.Clocks.TimmingUtil;

/**
 *
 * @author german
 */
public class TimerTest {

    /**
     * @param args the command line arguments
     */
    private static Timer timer1;
    private static Timer timer2;
    private static Timer timer3;
    
    private boolean running;
    
    public static void main(String[] args) {
        // TODO code application logic here
        timer1 = new Timer(1, 0, 0, 0);
        timer2 = new Timer(1, 0, 0);
        timer3 = new Timer(10, 0);
        
        timer1.start();
        timer2.start();
        timer3.start();
        
        while(true){
           try{
               Thread.sleep(500);
               System.out.println(timer1.getTime(TimmingUtil.Format.MMSS) + " - " 
                       + timer2.getTime(TimmingUtil.Format.MMSSmm) + " - " 
                       + timer3.getTime(TimmingUtil.Format.SSmm));
           } catch(Exception ex){
               System.out.println("error \n");
           }
        }
    }
}
