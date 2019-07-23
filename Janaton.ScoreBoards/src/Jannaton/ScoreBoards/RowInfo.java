/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IRowInfo;

/**
 *
 * @author german
 */
public class RowInfo implements IRowInfo{

    private Alignment alignment = Alignment.MIDDLE;

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.ROW;
    }
    
    
    @Override
    public Alignment getAlignment() {
        return this.alignment;
    }

    @Override
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }
}
