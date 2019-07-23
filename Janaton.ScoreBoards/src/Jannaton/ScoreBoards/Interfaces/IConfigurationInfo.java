/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Interfaces;

/**
 *
 * @author german
 */
public interface IConfigurationInfo extends IScoreBoardInfo{
    
    String getId();
    void setId(String componentId);
    String getFieldType();
    void setFieldType(String fieldName);
    String getFieldName();
    void setFieldName(String fieldName);
    String getMinValue();
    void setMinValue(String minValue);
    String getMaxValue();
    void setMaxValue(String maxValue);
    String getDefault();
    void setDefault(String defaultValue);
}
