/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IControlPanelInfo extends IScoreBoardInfo{
    
    ILayoutInfo getLayoutInfo();
    
    void setLayoutInfo(ILayoutInfo layoutInfo);
    
    IComponentsInfo getComponentsInfo();
    
    void setComponentsInfo(IComponentsInfo componentsInfo);
}
