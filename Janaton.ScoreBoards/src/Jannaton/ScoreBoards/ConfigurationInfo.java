/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IConfigurationInfo;

/**
 *
 * @author german
 */
public class ConfigurationInfo implements IConfigurationInfo{

    private String componentId;
    private String fieldType;
    private String fieldName;
    private String minValue;
    private String maxValue;
    private String defaultValue;
    
    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.CONFIGURATION;
    }
    
    @Override
    public String getId() {
        return this.componentId;
    }

    @Override
    public void setId(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String getFieldName() {
        return this.fieldName;
    }

    @Override
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String getMinValue() {
        return this.minValue;
    }

    @Override
    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    @Override
    public String getMaxValue() {
        return this.maxValue;
    }

    @Override
    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String getDefault() {
        return this.defaultValue;
    }

    @Override
    public void setDefault(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String getFieldType() {
        return this.fieldType;
    }

    @Override
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

}
