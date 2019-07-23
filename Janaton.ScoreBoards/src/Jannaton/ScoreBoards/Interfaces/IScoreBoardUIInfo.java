/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IScoreBoardUIInfo {
    
    //TODO complete interface definition
    String getId();
    
    void setId(String id);
    
    ILayoutInfo getLayoutInfo();
    
    IComponentsInfo getComponentsInfo();
    
    IStylesInfo getStyleInfo();
    
    IMenuInfo getMenuInfo();
    
    IControlPanelInfo getControlPanelInfo();
    
    void setLayoutInfo(ILayoutInfo layoutInfo);
    
    void setComponentsInfo(IComponentsInfo componentsInfo);
    
    void setStyleInfo(IStylesInfo sylesInfo);
    
    void setMenuInfo(IMenuInfo menuInfo);
    
    void setControlPanelInfo(IControlPanelInfo controlPanelInfo);
}
