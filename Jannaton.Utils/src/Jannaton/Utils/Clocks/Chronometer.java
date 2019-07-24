/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Clocks;

/**
 *
 * @author german
 */
public class Chronometer extends TimmingUtil {

    public Chronometer(int hours, int minutes, int seconds, int milliseconds) {
        super(hours, minutes, seconds, milliseconds);
    }

    public Chronometer(int minutes, int seconds, int milliseconds) {
        super(minutes, seconds, milliseconds);
    }

    public Chronometer(int seconds, int milliseconds) {
        super(seconds, milliseconds);
    }

    @Override
    public String getTime(Format format) {
        if (this.isRunning()) {
            this.calculateDiff();
        } else {
            this.addDiff();
        }
        return super.getTime(format);
    }

    public boolean isChronometerMaxValueReached(int hoursRest, int minutesRest, int secondsRest, int millisecondsRest) {
        return (this.isHoursMaxReached() && this.isMinutesMaxReached() &&
                this.isMinutesMaxReached() && this.isSecondsMaxReached());
        
//        return ((this.getHoursValue()) >= this.getHoursMaxValue()
//                && (this.getMinutesValue()) >= this.getMinutesMaxValue()
//                && (this.getSecondsValue()) >= this.getSecondsMaxValue()
//                && (this.getMillisecondsValue()) >= this.getMillisecondsMaxValue());
    }

    public void setChronometerMaxValue(int hour, int minute, int second, int millisecond) {
        this.setHoursMaxValue(hour > 0 ? hour : 0);
        this.setMinutesMaxValue(minute > 0 ? minute : 0);
        this.setSecondsMaxValue(second > 0 ? second : 0);
        this.setMillisecondsMaxValue(millisecond > 0 ? millisecond : 0);
    }

    private void calculateDiff() {

        long beforeTime = this.getCalendar().getTimeInMillis();

        this.getCalendar().setTimeInMillis(System.currentTimeMillis());

        long afterTime = this.getCalendar().getTimeInMillis();

        long millisecondsPassed = afterTime - beforeTime;
        long secondsPassed = 0;
        long minutesPassed = 0;
        long hoursPassed = 0;

        int hours = this.getHoursValue();
        int minutes = this.getMinutesValue();
        int seconds = this.getSecondsValue();
        int milliseconds = this.getMillisecondsValue();

        int millisecondsRest = 0;
        int secondsRest = 0;
        int minutesRest = 0;
        int hoursRest = 0;
        /*
         * Algorithm
         */
        //TODO have to stop the increasing when the maximum chrono value is reached
        if (this.isRunningMilliseconds()) {
            millisecondsRest = (int) (millisecondsPassed % this.getDeltaMilliseconds());

            if ((milliseconds + millisecondsRest) < this.getDeltaMilliseconds()) {
                milliseconds = milliseconds + millisecondsRest;
            } else if ((milliseconds + millisecondsRest) >= this.getDeltaMilliseconds()) {
                milliseconds = 0 + ((millisecondsRest + milliseconds) - this.getDeltaMilliseconds());
                this.setPassingSeconds(true);
//                    secondsPassed++;
            }
//            else if (this.getMillisecondsMaxValue() > 0) {
//                milliseconds = this.getMillisecondsMaxValue();
//                this.setRunningMilliseconds(false);
//            } else {
//                milliseconds = 0;
//                this.setRunningMilliseconds(false);
//            }
        }
        /*
         * else{
         *      milliseconds = milliseconds
         * }
         */

        if (this.isRunningSeconds()) {

            if (this.isPassingSeconds()) {
                secondsPassed++;
                this.setPassingSeconds(false);
            }

            secondsPassed += (int) (millisecondsPassed / this.getDeltaMilliseconds());

            secondsRest = (int) (secondsPassed % this.getDeltaSeconds());

            if ((seconds + secondsRest) < this.getDeltaSeconds()) {
                seconds = seconds + secondsRest;
            } else if ((seconds + secondsRest) >= this.getDeltaSeconds()) {
                    seconds = 0 + ((seconds + secondsRest) - this.getDeltaSeconds());
                    this.setPassingMinutes(true);
//                    minutesPassed++;
//                else if (this.getSecondsMaxValue() > 0) {
//                    seconds = this.getSecondsMaxValue();
//                    this.setRunningSeconds(false);
//                } else {
//                    seconds = 0;
//                    this.setRunningSeconds(false);
//                }
            }
        }

        if (this.isRunningMinutes()) {

            if (this.isPassingMinutes()) {
                minutesPassed++;
                this.setPassingMinutes(false);
            }

            minutesPassed += (int) (secondsPassed / this.getDeltaSeconds());

            minutesRest = (int) (minutesPassed % this.getDeltaMinutes());

            if ((minutes + minutesRest) < this.getDeltaMinutes()) {
                minutes = minutes + minutesRest;
            } else if ((minutes + minutesRest) >= this.getDeltaMinutes()) {
                minutes = 0 + ((minutes + minutesRest) - this.getDeltaMinutes());
                this.setPassingHours(true);
//                    hoursPassed++;
            } 
//            else {
//                minutes = 0;
//                this.setRunningMinutes(false);
//            }
        }

        if (this.isRunningHours()) {

            if (this.isPassingHours()) {
                hoursPassed++;
                this.setPassingHours(false);
            }

            hoursPassed += (int) (minutesPassed / this.getDeltaMinutes());

            hoursRest = (int) (hoursPassed % this.getDeltaHours());

            if ((hours + hoursRest) < this.getDeltaHours()) {
                hours = hours + hoursRest;
            } else if ((hours + hoursRest) >= this.getDeltaHours()) {
                hours = 0 + ((hours + hoursRest) - this.getDeltaHours());
                //this.setDaysPassing(true);
                ////daysPassed++;
            } 
//            else {
//                hours = 0;
//                this.setRunningHours(false);
//            }
        }
        /*
         * End of algorithm
         */

        if (!this.isChronometerMaxValueReached(hoursRest, minutesRest, secondsRest, millisecondsRest)) {
            this.setMillisecondsValue(milliseconds);
            this.setSecondsValue(seconds);
            this.setMinutesValue(minutes);
            this.setHoursValue(hours);
        } else {
            this.setMillisecondsValue(this.getMillisecondsMaxValue());
            this.setSecondsValue(this.getSecondsMaxValue());
            this.setMinutesValue(this.getMinutesMaxValue());
            this.setHoursValue(this.getHoursMaxValue());
            this.pause();
        }

    }

    private void addDiff() {

        this.getCalendar().setTimeInMillis(System.currentTimeMillis());

    }
}
