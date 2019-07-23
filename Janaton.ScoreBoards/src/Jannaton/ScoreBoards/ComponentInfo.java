/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IComponentInfo;

/**
 *
 * @author german
 */
public class ComponentInfo implements IComponentInfo{

    private EnumScoreBoardPaneType type;
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
        return EnumUIInfoPropertyType.COMPONENT;
    }

    @Override
    public EnumScoreBoardPaneType getPaneType() {
        return this.type;
    }

    @Override
    public void setType(EnumScoreBoardPaneType type) {
        this.type = type;
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
        return this.fileName;
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
