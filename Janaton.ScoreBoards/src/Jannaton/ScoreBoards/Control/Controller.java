/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Control;

import Jannaton.ScoreBoards.Files.ScoreBoardsLoader;
import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author german
 */
public class Controller {
    /*
     * This class will act as the controller for the UIMaster from the 
     * Jannaton.ScoreBoards.UI package.
     * 
     * It's responsible of ScoreBoard States, and for mapping ScoreBoard actions
     * to ScoreBoardControllerPane, App, key, Mouse, or other devices event mappings.
     */

    private static Controller instance;
    private IScoreBoard scoreBoard;
    private HashMap<Integer, Integer> scoreBoardsToScreens;

    private Controller() {
        this.scoreBoardsToScreens = new HashMap<Integer, Integer>();
    }

    public static Controller getInstace() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    //TODO include a boolean parameter to allow available Scoreboards to refresh.
    public ArrayList<IScoreBoard> getAvailableScoreBoards() {
        return ScoreBoardsLoader.getInstance().getAvailables();
    }

    public IScoreBoard getSelectedScoreBoard() {
        return this.scoreBoard;
    }

    public boolean setAvailableScoreBoard(int index) {
        try {
            this.scoreBoard = getAvailableScoreBoards().get(index);
        } catch (Exception e) {
            return false;
        } finally {
            return true;
        }
    }

    public HashMap<Integer, Integer> getScoreBoardsToScreens(){
        return this.scoreBoardsToScreens;
    }
    
    public void setScoreBoardToScreen(int scoreBoardIndex, int screenIndex) {
        this.scoreBoardsToScreens.put(scoreBoardIndex, screenIndex);
    }
}
