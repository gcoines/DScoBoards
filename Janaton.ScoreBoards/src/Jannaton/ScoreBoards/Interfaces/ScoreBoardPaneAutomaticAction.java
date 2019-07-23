/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface ScoreBoardPaneAutomaticAction extends ScoreBoardPaneAction{
    
    void start();
    
    void pause();
    
    void resume();
    
    void stop();
}
