/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Files;

import Jannaton.ScoreBoards.Interfaces.IComponentInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import Jannaton.ScoreBoards.ScoreBoardPanesManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author german
 */
public class ScoreBoardPanesLoader {

    private static ScoreBoardPanesLoader instance;

    private ScoreBoardPanesLoader() {
    }

    public static ScoreBoardPanesLoader getInstance() {
        if (instance == null) {
            instance = new ScoreBoardPanesLoader();
        }

        return instance;
    }
    
    protected List<IScoreBoardPane> loadScoreBoardPanes(IScoreBoardUIInfo uiInfo){
        List<IScoreBoardPane> panes = new ArrayList<IScoreBoardPane>();
        IComponentsInfo components = uiInfo.getComponentsInfo();
        if(components != null){
            List<IComponentInfo> componentInfos = components.getComponentInfos();
            for(IComponentInfo component : componentInfos){
                panes.add(this.loadScoreBoardPane(component));
            }
        }
        
        return panes;
    }
    
    private IScoreBoardPane loadScoreBoardPane(IComponentInfo componentInfo){
        IScoreBoardPane pane = ScoreBoardPanesManager.getInstance().createPane(componentInfo.getPaneType());
        pane.setId(componentInfo.getID());
        return pane;
    }
}
