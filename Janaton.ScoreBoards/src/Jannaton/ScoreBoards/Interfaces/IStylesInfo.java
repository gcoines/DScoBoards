/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

import java.util.List;

/**
 *
 * @author german
 */
public interface IStylesInfo extends IScoreBoardInfo{
    
    List<IScoreBoardInfo> getScoreBoardStyleInfos();
    void setScoreBoardStylesInfo(List<IScoreBoardInfo> scoreBoardStyleInfos);
    List<IStyleInfo> getStyleInfos();
    void setStylesInfo(List<IStyleInfo> styleInfos);
}
