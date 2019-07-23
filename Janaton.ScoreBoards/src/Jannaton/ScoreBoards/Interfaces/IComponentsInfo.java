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
public interface IComponentsInfo extends IScoreBoardInfo{
    List<IComponentInfo> getComponentInfos();
    void setComponentInfos(List<IComponentInfo> componentInfos);
}
