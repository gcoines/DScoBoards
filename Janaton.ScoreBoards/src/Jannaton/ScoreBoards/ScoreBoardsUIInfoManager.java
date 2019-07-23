/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.*;

/**
 *
 * @author german
 */
public class ScoreBoardsUIInfoManager {
    
    private static ScoreBoardsUIInfoManager instance;
    
    private ScoreBoardsUIInfoManager(){}
    
    public static ScoreBoardsUIInfoManager getInstance(){
        if(instance == null){
            instance = new ScoreBoardsUIInfoManager();
        }
        
        return instance;
    }
    //TODO extract ScoreBoard UI Info functions to Jannaton.ScoreBoards.UI layer
    public IScoreBoardUIInfo createScoreBoardUIInfo(){
        return new ScoreBoardUIInfo();
    }
    
    public ILayoutInfo createLayoutInfo(){
        return new LayoutInfo();
    }
    
    public IColumnInfo createColumnInfo(){
        return new ColumnInfo();
    }
    
    public IRowInfo createRowInfo(){
        return new RowInfo();
    }
    
    public IComponentsInfo createComponentsInfo(){
        return new ComponentsInfo();
    }
    
    public IComponentInfo createComponentInfo(){
        return new ComponentInfo();
    }
    
    public IStylesInfo createStylesInfo(){
        return new StylesInfo();
    }
    
    public IStyleInfo createStyleInfo(){
        return new StyleInfo();
    }
    
    public IBackgroundInfo createBackgroundInfo(){
        return new BackgroundInfo();
    }
    
    public IMenuInfo createMenuInfo(){
        return new MenuInfo();
    }
    
    public IConfigurationsInfo createConfigurationsInfo(){
        return new ConfigurationsInfo();
    }
    
    public IConfigurationInfo createConfigurationInfo(){
        return new ConfigurationInfo();
    }

    public IButtonInfo createButtonInfo(){
        return new ButtonInfo();
    }
    
    public IImageInfo createImageInfo(){
        return new ImageInfo();
    }
    
    public IControlPanelInfo createControlPanelInfo(){
        return new ControlPanelInfo();
    }
    
    public IButtonsPanelInfo createButtonsPanelInfo(){
        return new ButtonsPanelInfo();
    }
}
