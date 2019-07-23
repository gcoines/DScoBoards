/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IConfigurationsInfo;
import Jannaton.ScoreBoards.Interfaces.IMenuInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardInfo;
import java.util.List;

/**
 *
 * @author german
 */
public class MenuInfo implements IMenuInfo
{
    private List<IScoreBoardInfo> scoreBoardInfos;
    private IConfigurationsInfo configurationsInfo;

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.MENU;
    }
    
    @Override
    public List<IScoreBoardInfo> getScoreBoardInfos() {
        return this.scoreBoardInfos;
    }

    @Override
    public void setScoreBoardInfo(List<IScoreBoardInfo> scoreBoardInfos) {
        this.scoreBoardInfos = scoreBoardInfos;
    }

    @Override
    public IConfigurationsInfo getConfigurationsInfo() {
        return this.configurationsInfo;
    }

    @Override
    public void setConfigurationInfo(IConfigurationsInfo configurationsInfo) {
        this.configurationsInfo = configurationsInfo;
    }


}
