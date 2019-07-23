/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IStyleInfo;

/**
 *
 * @author german
 */
public class StyleInfo implements IStyleInfo {

    private EnumUIInfoPropertyType type;
    private String id;
    private String fontSize;
    private String color;

    @Override
    public EnumUIInfoPropertyType getType() {
        return this.type;
    }

    @Override
    public void setType(EnumUIInfoPropertyType type) {
        //TODO throw Exception?
        if (type == EnumUIInfoPropertyType.STYLE
                || type == EnumUIInfoPropertyType.BACKGROUND) {
            this.type = type;
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getFontSize() {
        return this.fontSize;
    }

    @Override
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
