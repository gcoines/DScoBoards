/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Clocks;

/**
 *
 * @author german
 */
public class Timer extends TimmingUtil {

    public Timer(int hours, int minutes, int seconds, int milliseconds) {
        super(hours, minutes, seconds, milliseconds);
    }

    public Timer(int minutes, int seconds, int milliseconds) {
        super(minutes, seconds, milliseconds);
    }

    public Timer(int seconds, int milliseconds) {
        super(seconds, milliseconds);
    }

    @Override
    public String getTime(Format format) {
        if (this.isRunning()) {
            this.calculateDiff();
        }else{
            this.addDiff();
        }
        return super.getTime(format);
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

        /*
         * Algorithm
         */
        if (this.isRunningMilliseconds()
                && (this.getMillisecondsValue() > 0 || (this.getSecondsValue() != 0
                || this.getMinutesValue() != 0 || this.getHoursValue() != 0))) {
            int millisecondsRest = (int) (millisecondsPassed % this.getDeltaMilliseconds());

            if (millisecondsRest < milliseconds) {
                milliseconds = milliseconds - millisecondsRest;
            } else if (millisecondsRest > 0) {
                if (this.getSecondsValue() > 0 || this.getMinutesValue() > 0 || this.getHoursValue() > 0) {
                    milliseconds = (this.getDeltaMilliseconds()) - (millisecondsRest - milliseconds);
                    this.setPassingSeconds(true);
//                    secondsPassed++;
                } else {
                    milliseconds = 0;
                    this.setRunningMilliseconds(false);
                }
            }
        }
        /*
         * else{
         *      milliseconds = milliseconds
         * }
         */

        if (this.isRunningSeconds()
                && (this.getSecondsValue() > 0 || (this.getMinutesValue() != 0
                || this.getHoursValue() != 0))) {

            if (this.isPassingSeconds() && milliseconds < this.getDeltaMilliseconds()) {
                secondsPassed++;
                this.setPassingSeconds(false);
            }

            secondsPassed += (int) (millisecondsPassed / this.getDeltaMilliseconds());

            int secondsRest = (int) (secondsPassed % this.getDeltaSeconds());

            if (secondsRest < seconds) {
                seconds = seconds - secondsRest;
            } else if (secondsRest > 0) {
                if (this.getMinutesValue() > 0 || this.getHoursValue() > 0) {
                    seconds = (this.getDeltaSeconds()) - (secondsRest - seconds);
                    this.setPassingMinutes(true);
//                    minutesPassed++;
                } else {
                    seconds = 0;
                    this.setRunningSeconds(false);
                }
            }
        }

        if (this.isRunningMinutes() && (this.getMinutesValue() > 0 || this.getHoursValue() != 0)) {

            if (this.isPassingMinutes() && seconds < this.getDeltaSeconds()) {
                minutesPassed++;
                this.setPassingMinutes(false);
            }

            minutesPassed += (int) (secondsPassed / this.getDeltaSeconds());

            int minutesRest = (int) (minutesPassed % this.getDeltaMinutes());

            if (minutesRest < minutes) {
                minutes = minutes - minutesRest;
            } else if (minutesRest > 0) {
                if (this.getHoursValue() > 0) {
                    minutes = (this.getDeltaMinutes()) - (minutesRest - minutes);
                    this.setPassingHours(true);
//                    hoursPassed++;
                } else {
                    minutes = 0;
                    this.setRunningMinutes(false);
                }
            }
        }

        if (this.isRunningHours() && this.getHoursValue() > 0) {

            if (this.isPassingHours() && minutes < this.getDeltaMinutes()) {
                hoursPassed++;
                this.setPassingHours(false);
            }

            hoursPassed += (int) (minutesPassed / this.getDeltaMinutes());

            int hoursRest = (int) (hoursPassed % this.getDeltaHours());

            if (hoursRest < hours) {
                hours = hours - hoursRest;
            } else if (hoursRest > 0) {
                hours = (this.getDeltaHours()) - (hoursRest - hours);
                //this.setDaysPassing(true);
                ////daysPassed++;
            } else {
                hours = 0;
                this.setRunningHours(false);
            }
        }
        /*
         * End of algorithm
         */

        this.setMillisecondsValue(milliseconds);
        this.setSecondsValue(seconds);
        this.setMinutesValue(minutes);
        this.setHoursValue(hours);

    }

    private void addDiff(){

        this.getCalendar().setTimeInMillis(System.currentTimeMillis());

    }
}
