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
public abstract class TimmingUtil {

    public static enum Format {

        HHMMSSmm, HHMMSS, HHMM, MMSSmm, MMSS, SSmm
    };
    private Calendar calendar;
    private int hoursValue;
    private int minutesValue;
    private int secondsValue;
    private int millisecondsValue;
    private int hoursMaxValue = -1;
    private int minutesMaxValue = -1;
    private int secondsMaxValue = -1;
    private int millisecondsMaxValue = -1;
    private int deltaHours = 24;
    private int deltaMinutes = 60;
    private int deltaSeconds = 60;
    private int deltaMilliseconds = 1000;
    private boolean passingHours = false;
    private boolean passingMinutes = false;
    private boolean passingSeconds = false;
    private boolean passingMilliseconds = false;
    private boolean runningHours = false;
    private boolean runningMinutes = false;
    private boolean runningSeconds = false;
    private boolean runningMilliseconds = false;
    private boolean running = false;

    /**
     * Constructor defining the 4 filds of the TimmingUtil
     *
     * @param hours
     * @param minutes
     * @param seconds
     * @param milliseconds
     */
    protected TimmingUtil(int hours, int minutes, int seconds, int milliseconds) {
        this.hoursValue = hours >= 0 ? hours : 0;
        this.minutesValue = minutes >= 0 ? minutes : 0;
        this.secondsValue = seconds >= 0 ? seconds : 0;
        this.millisecondsValue = milliseconds >= 0 ? milliseconds : 0;
        this.runningHours = true;
        this.runningMinutes = true;
        this.runningSeconds = true;
        this.runningMilliseconds = true;
        this.calendar = Calendar.getInstance();
    }

    protected TimmingUtil(int minutes, int seconds, int milliseconds) {
        this.minutesValue = minutes >= 0 ? minutes : 0;
        this.secondsValue = seconds >= 0 ? seconds : 0;
        this.millisecondsValue = milliseconds >= 0 ? milliseconds : 0;
        this.runningMinutes = true;
        this.runningSeconds = true;
        this.runningMilliseconds = true;
        this.calendar = Calendar.getInstance();
    }

    protected TimmingUtil(int seconds, int milliseconds) {
        this.secondsValue = seconds >= 0 ? seconds : 0;
        this.millisecondsValue = milliseconds >= 0 ? milliseconds : 0;
        this.runningSeconds = true;
        this.runningMilliseconds = true;
        this.calendar = Calendar.getInstance();
    }

    protected TimmingUtil() {
        this.calendar = Calendar.getInstance();
    }

    protected int getHoursValue() {
        return this.hoursValue;
    }

    protected int getMinutesValue() {
        return this.minutesValue;
    }

    protected int getSecondsValue() {
        return this.secondsValue;
    }

    protected int getMillisecondsValue() {
        return this.millisecondsValue;
    }

    protected void setHoursValue(int hours) {
        this.hoursValue = hours;
    }

    protected void setMinutesValue(int minutes) {
        this.minutesValue = minutes;
    }

    protected void setSecondsValue(int seconds) {
        this.secondsValue = seconds;
    }

    protected void setMillisecondsValue(int milliseconds) {
        this.millisecondsValue = milliseconds;
    }

    public int getHoursMaxValue() {
        return this.hoursMaxValue;
    }

    protected void setHoursMaxValue(int hoursMaxValue) {
        this.hoursMaxValue = hoursMaxValue;
    }

    public int getMinutesMaxValue() {
        return this.minutesMaxValue;
    }

    protected void setMinutesMaxValue(int minutesMaxValue) {
        this.minutesMaxValue = minutesMaxValue;
    }

    public int getSecondsMaxValue() {
        return this.secondsMaxValue;
    }

    protected void setSecondsMaxValue(int secondsMaxValue) {
        this.secondsMaxValue = secondsMaxValue;
    }

    public int getMillisecondsMaxValue() {
        return this.millisecondsMaxValue;
    }

    protected void setMillisecondsMaxValue(int millisecondsMaxValue) {
        this.millisecondsMaxValue = millisecondsMaxValue;
    }

    public boolean isMillisecondsMaxReached() {
        if (this.getMillisecondsMaxValue() < 0){
            return false;
        } else {
            return this.getMillisecondsValue() >= this.getMillisecondsMaxValue();
        }
    }

    public boolean isSecondsMaxReached() {
        if(this.getSecondsMaxValue() < 0){
            return false;
        } else {
            return this.getSecondsValue() >= this.getSecondsMaxValue();
        }
    }

    public boolean isMinutesMaxReached() {
        if(this.getMinutesMaxValue() < 0){
            return false;
        } else {
            return this.getMinutesValue() >= this.getMinutesMaxValue();
        }
    }

    public boolean isHoursMaxReached() {
        if (this.getHoursMaxValue() < 0) {
            return false;
        } else {
            return this.getHoursValue() >= this.getHoursMaxValue();
        }
    }

    protected int getDeltaHours() {
        return this.deltaHours;
    }

    protected int getDeltaMinutes() {
        return this.deltaMinutes;
    }

    protected int getDeltaSeconds() {
        return this.deltaSeconds;
    }

    protected int getDeltaMilliseconds() {
        return this.deltaMilliseconds;
    }

    protected Calendar getCalendar() {
        return this.calendar;
    }

    public void setDeltaMilliseconds(int dMilliseconds) {
        this.deltaMilliseconds = dMilliseconds;
    }

    public void setDeltaSeconds(int dSeconds) {
        this.deltaSeconds = dSeconds;
    }

    public void setDeltaMinutes(int dMinutes) {
        this.deltaMinutes = dMinutes;
    }

    public boolean isPassingHours() {
        return passingHours;
    }

    public void setPassingHours(boolean passingHours) {
        this.passingHours = passingHours;
    }

    public boolean isPassingMinutes() {
        return passingMinutes;
    }

    public void setPassingMinutes(boolean passingMinutes) {
        this.passingMinutes = passingMinutes;
    }

    public boolean isPassingSeconds() {
        return passingSeconds;
    }

    public void setPassingSeconds(boolean passingSeconds) {
        this.passingSeconds = passingSeconds;
    }

    public boolean isPassingMilliseconds() {
        return passingMilliseconds;
    }

    public void setPassingMilliseconds(boolean passingMilliseconds) {
        this.passingMilliseconds = passingMilliseconds;
    }

    public boolean isRunningHours() {
        return runningHours;
    }

    public void setRunningHours(boolean runningHours) {
        this.runningHours = runningHours;
    }

    public boolean isRunningMinutes() {
        return runningMinutes;
    }

    public void setRunningMinutes(boolean runningMinutes) {
        this.runningMinutes = runningMinutes;
    }

    public boolean isRunningSeconds() {
        return runningSeconds;
    }

    public void setRunningSeconds(boolean runningSeconds) {
        this.runningSeconds = runningSeconds;
    }

    public boolean isRunningMilliseconds() {
        return runningMilliseconds;
    }

    public void setRunningMilliseconds(boolean runningMilliseconds) {
        this.runningMilliseconds = runningMilliseconds;
    }

    protected boolean isRunning() {
        return this.running;
    }

    public void start() {
        this.running = true;
    }

    public void pause() {
        this.running = false;
    }

    /**
     *
     * @param timeFormat
     * @return
     */
    public String getTime(Format timeFormat) {
        String time = "";

        switch (timeFormat) {
            case HHMMSSmm:
                time = this.formatOutput(Calendar.HOUR) + ":" + this.formatOutput(Calendar.MINUTE)
                        + ":" + this.formatOutput(Calendar.SECOND) + ":" + this.formatOutput(Calendar.MILLISECOND);
                break;
            case HHMMSS:
                time = this.formatOutput(Calendar.HOUR) + ":" + this.formatOutput(Calendar.MINUTE)
                        + ":" + this.formatOutput(Calendar.SECOND);
                break;
            case HHMM:
                time = this.formatOutput(Calendar.HOUR) + ":" + this.formatOutput(Calendar.MINUTE);
                break;
            case MMSSmm:
                time = this.formatOutput(Calendar.MINUTE) + ":" + this.formatOutput(Calendar.SECOND)
                        + ":" + this.formatOutput(Calendar.MILLISECOND);
                break;
            case MMSS:
                time = this.formatOutput(Calendar.MINUTE) + ":" + this.formatOutput(Calendar.SECOND);
                break;
            case SSmm:
                time = this.formatOutput(Calendar.SECOND) + ":" + this.formatOutput(Calendar.MILLISECOND);
                break;
        }

        return time;
    }

    protected String formatOutput(int calendarField) {
        String formatted = "";
        switch (calendarField) {
            //TODO calculate the string dinamicaly depending on the delta value.
            //have to be calculated using recursivity.
            case Calendar.MILLISECOND:
                if (this.millisecondsValue < this.deltaMilliseconds) {
                    if (this.millisecondsValue >= 100) {
                        formatted = Integer.toString(this.millisecondsValue);
                    } else if (this.millisecondsValue >= 10) {
                        formatted = "0" + Integer.toString(this.millisecondsValue);
                    } else if (this.millisecondsValue >= 0) {
                        formatted = "00" + Integer.toString(this.millisecondsValue);
                    } else {
                        formatted = "000";
                    }
                } else {
                    formatted = "000";
                }
                break;

            case Calendar.SECOND:
                if (this.secondsValue < this.deltaSeconds) {
                    if (this.secondsValue >= 10) {
                        formatted = Integer.toString(this.secondsValue);
                    } else if (this.secondsValue >= 0) {
                        formatted = "0" + Integer.toString(this.secondsValue);
                    } else {
                        formatted = "00";
                    }
                } else {
                    formatted = "00";
                }
                break;

            case Calendar.MINUTE:
                if (this.minutesValue < this.deltaMinutes) {
                    if (this.minutesValue >= 10) {
                        formatted = Integer.toString(this.minutesValue);
                    } else if (this.minutesValue >= 0) {
                        formatted = "0" + Integer.toString(this.minutesValue);
                    } else {
                        formatted = "00";
                    }
                } else {
                    formatted = "00";
                }
                break;

            case Calendar.HOUR:
                if (this.hoursValue < this.deltaHours) {
                    if (this.hoursValue >= 10) {
                        formatted = Integer.toString(this.hoursValue);
                    } else if (this.hoursValue >= 0) {
                        formatted = "0" + Integer.toString(this.hoursValue);
                    } else {
                        formatted = "00";
                    }
                } else {
                    formatted = "00";
                }
                break;

        }
        return formatted;
    }
}
