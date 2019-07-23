/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IImageInfo;

/**
 *
 * @author german
 */
public class ImageInfo implements IImageInfo{

    private String fileName;
    
    @Override
    public String getImageFileName() {
        return this.fileName;
    }

    @Override
    public void setImageFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.IMAGE;
    }
    
}
