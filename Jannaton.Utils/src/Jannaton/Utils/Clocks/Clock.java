/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Clocks;

import java.util.Calendar;

/**
 *
 * @author german
 */
public class Clock extends TimmingUtil{

    public Clock(){
        super();
    }
    
    /*
     * This function returns the current time in the format hh:mm:ss
     */
    @Override
    public String getTime(Format format) {
        this.getCalendar().setTimeInMillis(System.currentTimeMillis());
        
        this.setMillisecondsValue(this.getCalendar().get(Calendar.MILLISECOND));
        this.setSecondsValue(this.getCalendar().get(Calendar.SECOND));
        this.setMinutesValue(this.getCalendar().get(Calendar.MINUTE));
        this.setHoursValue(this.getCalendar().get(Calendar.HOUR_OF_DAY));
        
        return super.getTime(format);
    }
}
