/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.IControlPanelInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;

/**
 *
 * @author german
 */
public class ControlPanelInfo implements IControlPanelInfo{

    private ILayoutInfo layoutInfo;
    private IComponentsInfo componentsInfo;
    
    @Override
    public ILayoutInfo getLayoutInfo() {
        return this.layoutInfo;
    }

    @Override
    public void setLayoutInfo(ILayoutInfo layoutInfo) {
        this.layoutInfo = layoutInfo;
    }

    @Override
    public IComponentsInfo getComponentsInfo() {
        return this.componentsInfo;
    }

    @Override
    public void setComponentsInfo(IComponentsInfo componentsInfo) {
        this.componentsInfo = componentsInfo;
    }

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.CONTROL_PANEL;
    }
    
}
