/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IComponentInfo extends IScoreBoardInfo{
    /**
     *
     * @return The component type, wich has to correspond to a ScoreBoardPane type
     */
    EnumScoreBoardPaneType getPaneType();
    /**
     *
     * @param type The component type, wich has to correspond to a ScoreBoardPane type
     */
    void setType(EnumScoreBoardPaneType type);
    /**
     *
     * @return String containing the ComponentInfo instance id 
     */
    String getID();
    /**
     *
     * @param id The ComponentInfo instance id
     */
    void setId(String id);
    /**
     *
     * @return The column at wich the Component is located
     */
    int getColumnIndex();
    /**
     *
     * @param columnIndex The column at wich the Component have to be located
     */
    void setColumnIndex(int columnIndex);
    /**
     *
     * @return The row at wich the Component is located
     */
    int getRowIndex();
    /**
     *
     * @param rowIndex The row at wich the Component have to be located
     */
    void setRowIndex(int rowIndex);
    /**
     *
     * @return The columns number a Component expands.
     */
    int getColumnSpan();
    /**
     *
     * @param columnSpan The columns number a Component have to expand.
     */
    void setColumnSpan(int columnSpan);
    /**
     *
     * @return The rows number a Component expands.
     */
    int getRowSpan();
    /**
     *
     * @param rowSpan The rows number a Component have to expand.
     */
    void setRowSpan(int rowSpan);
    /**
     *
     * @return The style id reference for that component
     */
    String getStyle();
    /**
     *
     * @param styleId The style id reference that component should have
     */
    void setStyle(String styleId);
    /**
     *
     * @return The file name for that component (only for local files)
     */
    String getFileName();
    /**
     *
     * @param fileName The file name reference that component should have
     */
    void setFileName(String fileName);
    /**
     *
     * @return The text for that component 
     */
    String getText();
    /**
     *
     * @param text The text reference that component should have
     */
    void setText(String text);
}
