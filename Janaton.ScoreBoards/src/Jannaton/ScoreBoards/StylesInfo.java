/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardInfo;
import Jannaton.ScoreBoards.Interfaces.IStyleInfo;
import Jannaton.ScoreBoards.Interfaces.IStylesInfo;
import java.util.List;

/**
 *
 * @author german
 */
public class StylesInfo implements IStylesInfo{

    private List<IScoreBoardInfo> scoreBoardStyleInfos;
    private List<IStyleInfo> styleInfos;

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.STYLES;
    }
    
    @Override
    public List<IScoreBoardInfo> getScoreBoardStyleInfos() {
        return this.scoreBoardStyleInfos;
    }

    @Override
    public void setScoreBoardStylesInfo(List<IScoreBoardInfo> scoreBoardStyleInfos) {
        this.scoreBoardStyleInfos = scoreBoardStyleInfos;
    }
    
    @Override
    public List<IStyleInfo> getStyleInfos() {
        return this.styleInfos;
    }

    @Override
    public void setStylesInfo(List<IStyleInfo> styleInfos) {
        this.styleInfos = styleInfos;
    }
}
