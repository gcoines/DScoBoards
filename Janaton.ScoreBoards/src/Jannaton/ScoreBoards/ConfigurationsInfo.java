/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Interfaces.EnumUIInfoPropertyType;
import Jannaton.ScoreBoards.Interfaces.IConfigurationInfo;
import Jannaton.ScoreBoards.Interfaces.IConfigurationsInfo;
import java.util.List;

/**
 *
 * @author german
 */
public class ConfigurationsInfo implements IConfigurationsInfo{

    private List<IConfigurationInfo> configurationInfos;
    
    @Override
    public IConfigurationInfo getConfigurationInfoById(String id) {
        IConfigurationInfo info = null;
        
        if(id != null && this.configurationInfos != null){
            for(IConfigurationInfo config : this.configurationInfos){
                if(id.equals(config.getId())){
                    info = config;
                    break;
                }
            }
        }
        
        return info;
    }
    
    @Override
    public List<IConfigurationInfo> getConfigurationInfos() {
        return this.configurationInfos;
    }

    @Override
    public void setConfigurationInfos(List<IConfigurationInfo> configurationInfos) {
        this.configurationInfos = configurationInfos;
    }

    @Override
    public EnumUIInfoPropertyType getType() {
        return EnumUIInfoPropertyType.CONFIGURATIONS;
    }

    
}
