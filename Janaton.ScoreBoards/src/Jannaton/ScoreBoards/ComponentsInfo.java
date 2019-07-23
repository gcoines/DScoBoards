/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IComponentInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import java.util.List;

/**
 *
 * @author german
 */
public class ComponentsInfo implements IComponentsInfo{

    private List<IComponentInfo> componentInfos;

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.COMPONENTS;
    }
        
    @Override
    public List<IComponentInfo> getComponentInfos() {
        return this.componentInfos;
    }

    @Override
    public void setComponentInfos(List<IComponentInfo> componentInfos) {
        this.componentInfos = componentInfos;
    }
}
