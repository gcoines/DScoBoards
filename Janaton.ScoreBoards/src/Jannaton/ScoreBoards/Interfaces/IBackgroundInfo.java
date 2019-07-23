/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IBackgroundInfo extends IScoreBoardInfo{
    
    IImageInfo getImageInfo();
    void setImageInfo(IImageInfo imageinfo);
}
