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
public interface IConfigurationsInfo extends IScoreBoardInfo{
    
    IConfigurationInfo getConfigurationInfoById(String id);
    List<IConfigurationInfo> getConfigurationInfos();
    void setConfigurationInfos(List<IConfigurationInfo> configurationInfos);
}
