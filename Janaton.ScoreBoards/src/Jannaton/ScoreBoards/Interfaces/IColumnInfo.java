/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IColumnInfo extends IScoreBoardInfo{
    
    /**
     * Defines the possible column alignments
     */
    static enum Alignment { LEFT, CENTER, RIGHT };
    
    Alignment getAlignment();
    
    void setAlignment(Alignment alignment);
}
