/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

import java.util.List;

/**
 *
 * @author german
 */
public interface ILayoutInfo extends IScoreBoardInfo {
    
    List<IColumnInfo> getColumnsInfo();
    
    void setColumnsInfo(List<IColumnInfo> columnInfos);
    
    List<IRowInfo> getRowsInfo();
    
    void setRowsInfo(List<IRowInfo> rowInfos);
}
