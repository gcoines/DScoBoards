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
public interface IMenuInfo extends IScoreBoardInfo{
    List<IScoreBoardInfo> getScoreBoardInfos();
    void setScoreBoardInfo(List<IScoreBoardInfo> scoreBoardInfos);
    IConfigurationsInfo getConfigurationsInfo();
    void setConfigurationInfo(IConfigurationsInfo menuInfos);
}
