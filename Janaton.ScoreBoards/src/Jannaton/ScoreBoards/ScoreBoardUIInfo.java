/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.IControlPanelInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;
import Jannaton.ScoreBoards.Interfaces.IMenuInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import Jannaton.ScoreBoards.Interfaces.IStylesInfo;

/**
 *
 * @author german
 */
public class ScoreBoardUIInfo implements IScoreBoardUIInfo{

    private String id;
    private ILayoutInfo layoutInfo;
    private IComponentsInfo componentsInfo;
    private IStylesInfo stylesInfo;
    private IMenuInfo menuInfo;
    private IControlPanelInfo controlPanelInfo;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public ILayoutInfo getLayoutInfo() {
        return this.layoutInfo;
    }

    @Override
    public IComponentsInfo getComponentsInfo() {
        return this.componentsInfo;
    }

    @Override
    public IStylesInfo getStyleInfo() {
        return this.stylesInfo;
    }

    @Override
    public IMenuInfo getMenuInfo() {
        return this.menuInfo;
    }

    @Override
    public IControlPanelInfo getControlPanelInfo() {
        return this.controlPanelInfo;
    }

    @Override
    public void setLayoutInfo(ILayoutInfo layoutInfo) {
        this.layoutInfo = layoutInfo;
    }

    @Override
    public void setComponentsInfo(IComponentsInfo componentsInfo) {
        this.componentsInfo = componentsInfo;
    }

    @Override
    public void setStyleInfo(IStylesInfo stylesInfo) {
        this.stylesInfo = stylesInfo;
    }

    @Override
    public void setMenuInfo(IMenuInfo menuInfo) {
        this.menuInfo = menuInfo;
    }

    @Override
    public void setControlPanelInfo(IControlPanelInfo controlPanelInfo) {
        this.controlPanelInfo = controlPanelInfo;
    }
}
