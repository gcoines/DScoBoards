/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Files;

import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.ScoreBoards.ScoreBoardsManager;
import Jannaton.Utils.Xml.XmlManager;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author german
 */
public class ScoreBoardsLoader {

    private static ScoreBoardsLoader instance;
    private Document xDocument;
    private ArrayList<IScoreBoard> available;

    private ScoreBoardsLoader() {
        available = new ArrayList<IScoreBoard>();
        try {
            //TODO study if externalize this piece of code will be a better option.
            xDocument = XmlManager.getInstance().loadDocument(this.getClass().getResourceAsStream("scoreboards.xml"));
            this.loadAvailableScoreBoards();
        } catch (Exception ex) {
            //TODO report error
            System.out.println(ex.getMessage());
        }
    }

    public static ScoreBoardsLoader getInstance() {
        if (instance == null) {
            instance = new ScoreBoardsLoader();
        }

        return instance;
    }

    //TODO include a boolean parameter to allow available Scoreboards to refresh.
    public ArrayList<IScoreBoard> getAvailables() {
        return this.available;
    }

    private void loadAvailableScoreBoards() {
        if (xDocument != null) //TODO report error
        {
            NodeList scoreBoards = xDocument.getElementsByTagName("scoreboard");

            if (scoreBoards != null) {
                int lenght = scoreBoards.getLength();
                for (int i = 0; i < lenght; i++) {
                    Node scoreBoard = scoreBoards.item(i);
                    IScoreBoard target = this.loadScoreBoard(scoreBoard);
                    this.available.add(target);
                }
            }
        } else{
            //TODO report loading error
        }
    }

    private IScoreBoard loadScoreBoard(Node source) {
        IScoreBoard target = ScoreBoardsManager.getInstance().createScoreBoard();

        String name = XmlManager.getAttributeByNameValue(source, "name");
        target.setName(name);

        String sport = XmlManager.getAttributeByNameValue(source, "sport");

        target.setUiIinfo(UIInfosLoader.getInstance().convert(source));

        //TODO implement target components adding from the UIInfo
        List<IScoreBoardPane> panes = ScoreBoardPanesLoader.getInstance().loadScoreBoardPanes(target.getUiIinfo());

        target.setPanes(panes);
        
        return target;
    }
}
