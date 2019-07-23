/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IButtonInfo;
import Jannaton.ScoreBoards.Interfaces.IImageInfo;

/**
 *
 * @author german
 */
public class ButtonInfo implements IButtonInfo{

    private IImageInfo imageInfo;
    
    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.BUTTON;
    }
    
    @Override
    public IImageInfo getImageInfo() {
        return this.imageInfo;
    }

    @Override
    public void setImageInfo(IImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }
}
