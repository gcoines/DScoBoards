/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IRowInfo extends IScoreBoardInfo{
    /**
     * Defines the possible column alignments
     */
    static enum Alignment { TOP, MIDDLE, BOTTOM };
    
    IRowInfo.Alignment getAlignment();
    
    void setAlignment(IRowInfo.Alignment alignment);
}
