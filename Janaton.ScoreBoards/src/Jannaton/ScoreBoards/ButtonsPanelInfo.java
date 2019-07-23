/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IButtonsPanelInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;

/**
 *
 * @author german
 */
public class ButtonsPanelInfo implements IButtonsPanelInfo{

    private ILayoutInfo layoutInfo;
    private IComponentsInfo componentsInfo;
    
    private String id;
    private int columnIndex;
    private int rowIndex;
    private int columnSpan = 1;
    private int rowSpan = 1;
    private String styleId;
    private String fileName;
    private String text;
    
    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.BUTTONS_PANEL;
    }

    @Override
    public ILayoutInfo getLayoutInfo() {
        return this.layoutInfo;
    }

    @Override
    public void setLayoutInfo(ILayoutInfo layoutInfo) {
        this.layoutInfo = layoutInfo;
    }

    @Override
    public IComponentsInfo getComponentsInfo() {
        return this.componentsInfo;
    }

    @Override
    public void setComponentsInfo(IComponentsInfo componentsInfo) {
        this.componentsInfo = componentsInfo;
    }

    @Override
    public EnumScoreBoardPaneType getPaneType() {
        return EnumScoreBoardPaneType.BUTTONS_PANEL;
    }

    @Override
    public void setType(EnumScoreBoardPaneType type) {
        
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getColumnIndex() {
        return this.columnIndex;
    }

    @Override
    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    @Override
    public int getRowIndex() {
        return this.rowIndex;
    }

    @Override
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Override
    public int getColumnSpan() {
        return this.columnSpan;
    }

    @Override
    public void setColumnSpan(int columnSpan) {
        this.columnSpan = columnSpan;
    }

    @Override
    public int getRowSpan() {
        return this.rowSpan;
    }

    @Override
    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    @Override
    public String getStyle() {
        return this.styleId;
    }

    @Override
    public void setStyle(String styleId) {
        this.styleId = styleId;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
    
}
