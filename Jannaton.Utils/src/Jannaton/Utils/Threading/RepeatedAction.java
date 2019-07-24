/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Utils.Threading;

import Jannaton.Utils.Threading.Interfaces.IAction;

/**
 *
 * @author german
 */
public class RepeatedAction extends Thread {

    private int deltaMilliseconds;
    private IAction action;

    public RepeatedAction(int deltaMilliseconds, IAction action) {
        if (deltaMilliseconds > 0) {
            this.deltaMilliseconds = deltaMilliseconds;
        }

        this.action = action;
    }

    @Override
    public void run() {
        try {
            while (!this.isInterrupted()) {
                if (this.action != null) {
                    this.action.execute();
                    sleep(this.deltaMilliseconds);
                } else {
                    this.interrupt();
                }
            }
        } catch (Exception e) {
        }

    }
}
