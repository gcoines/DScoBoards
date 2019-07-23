/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards;

import Jannaton.ScoreBoards.Components.Chronometer;
import Jannaton.ScoreBoards.Components.Counter;
import Jannaton.ScoreBoards.Components.Image;
import Jannaton.ScoreBoards.Components.Text;
import Jannaton.ScoreBoards.Components.Timer;
import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;

/**
 *
 * @author german
 */
public class ScoreBoardPanesManager {

    private static ScoreBoardPanesManager instance;

    private ScoreBoardPanesManager() { }

    public static ScoreBoardPanesManager getInstance() {
        if (instance == null) {
            instance = new ScoreBoardPanesManager();
        }

        return instance;
    }

    public IScoreBoardPane createPane(EnumScoreBoardPaneType type) {
        //TODO implement the rest of the cases
        switch (type) {
            case COUNTER:
                return new Counter();
            case TEXT:
                return new Text();
            case TEXT_CARRUSEL:
                
            case CHRONOMETER:
                return new Chronometer();
            case TIMER:
                return new Timer();
            case VIDEO_PLAYER:
                
            case IMAGE:
                return new Image();
            //TODO implement new cases
        }
        return null;
    }
}
