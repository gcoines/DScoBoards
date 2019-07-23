/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IColumnInfo;

/**
 *
 * @author german
 */
public class ColumnInfo implements IColumnInfo{

    private Alignment alignment = Alignment.CENTER;
    
    @Override
    public Alignment getAlignment() {
        return this.alignment;
    }

    @Override
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.COLUMN;
    }
    
}
