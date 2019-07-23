/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IColumnInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;
import Jannaton.ScoreBoards.Interfaces.IRowInfo;
import java.util.List;

/**
 *
 * @author german
 */
public class LayoutInfo implements ILayoutInfo{

    private List<IColumnInfo> columnsInfo;
    private List<IRowInfo> rowsInfo;
    
    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.LAYOUT;
    }
    
    @Override
    public List<IColumnInfo> getColumnsInfo() {
        return this.columnsInfo;
    }

    @Override
    public void setColumnsInfo(List<IColumnInfo> columnInfos) {
        this.columnsInfo = columnInfos;
    }

    @Override
    public List<IRowInfo> getRowsInfo() {
        return this.rowsInfo;
    }

    @Override
    public void setRowsInfo(List<IRowInfo> rowInfos) {
        this.rowsInfo = rowInfos;
    }
}
