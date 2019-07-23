/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IStyleInfo extends IScoreBoardInfo{
    
    void setType(EnumUIInfoPropertyType type);
    String getId();
    void setId(String id);
    String getFontSize();
    void setFontSize(String fontSize);
    String getColor();
    void setColor(String color);
}
