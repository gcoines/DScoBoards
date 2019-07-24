/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.Interfaces.IColumnInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.IConfigurationInfo;
import Jannaton.ScoreBoards.Interfaces.IConfigurationsInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;
import Jannaton.ScoreBoards.Interfaces.IMenuInfo;
import Jannaton.ScoreBoards.Interfaces.IRowInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import Jannaton.ScoreBoards.Interfaces.IStyleInfo;
import Jannaton.ScoreBoards.Interfaces.IStylesInfo;
import Jannaton.ScoreBoards.UI.Components.ChronometerComponent;
import Jannaton.ScoreBoards.UI.Components.CounterComponent;
import Jannaton.ScoreBoards.UI.Components.ImageComponent;
import Jannaton.ScoreBoards.UI.Components.TextComponent;
import Jannaton.ScoreBoards.UI.Components.TimerComponent;
import Jannaton.UI.Fxml.Controller;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author german
 */
public class ScoreBoard extends Controller {

    private static ScoreBoard instance;
    private HashMap<String, Controller> scoreBoardPaneControllers;
    @FXML
    private StackPane spScoreBoard;
    @FXML
    private GridPane gpScoreBoard;

    protected static Controller getInstance() {
        if (instance == null) {
            instance = new ScoreBoard();
        }

        return instance;
    }

    private void initializeFields() {
        this.scoreBoardPaneControllers = new HashMap<>();
        this.spScoreBoard = (StackPane) this.getParent();
//        this.spScoreBoard.setMinHeight(this.getStage().getMinHeight());
//        this.spScoreBoard.setMaxHeight(this.getStage().getMaxHeight());
        List<Node> nodes = this.getParent().getChildrenUnmodifiable();
        for (Node node : nodes) {
            if (node.getId().equals("gpScoreBoard")) {
                this.gpScoreBoard = (GridPane) node;
            }
        }
        this.gpScoreBoard.getColumnConstraints().clear();
        this.gpScoreBoard.getRowConstraints().clear();
    }

    protected void composeScoreBoard(IScoreBoard scoreBoard) {
        this.initializeFields();
        if (scoreBoard != null) {
            this.composeGrid(scoreBoard);
        }
    }

    private void composeGrid(IScoreBoard scoreBoard) {
        IScoreBoardUIInfo uiInfo = scoreBoard.getUiIinfo();
        if (uiInfo != null) {
            String id = uiInfo.getId();
            if (id != null && id != "") {
                this.spScoreBoard.setId(id);
            }
            ILayoutInfo layout = uiInfo.getLayoutInfo();
            if (layout != null) {
                this.addLayoutConstraints(layout);
            }
            IComponentsInfo components = uiInfo.getComponentsInfo();
            if (components != null) {
                for (IComponentInfo component : components.getComponentInfos()) {
                    this.addComponent(uiInfo, component, scoreBoard.getPaneById(component.getID()));
                }
            }
            IStylesInfo styles = uiInfo.getStyleInfo();
            if (styles != null) {
//            for(IStyleInfo style : styles.getScoreBoardStyleInfos()){
//                //TODO process scoreBoard styles
//            }
                for (IStyleInfo style : styles.getStyleInfos()) {
                    //TODO implement 
                }
            }
            IMenuInfo menu = uiInfo.getMenuInfo();
            if (menu != null) {
                //TODO implement
            }
        } else {
            //TODO report ERROR
        }
    }

    private void addLayoutConstraints(ILayoutInfo layout) {
        List<IColumnInfo> columns = layout.getColumnsInfo();
        if (columns != null) {
            for (IColumnInfo column : columns) {
                //TODO implement column attributes logic
                ColumnConstraints colConstraints = new ColumnConstraints();
                colConstraints.setPercentWidth(100 / columns.size());

                this.gpScoreBoard.getColumnConstraints().add(colConstraints);
            }
        }
        List<IRowInfo> rows = layout.getRowsInfo();
        if (rows != null) {

            for (IRowInfo row : rows) {
                //TODO implement column attributes logic
                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setPercentHeight(100 / rows.size());

                this.gpScoreBoard.getRowConstraints().add(rowConstraints);
            }
        }

    }

    //TODO implement IConfigurationInfo adding
    private IConfigurationInfo getConfigInfo(IScoreBoardUIInfo uiInfo, IComponentInfo componentInfo) {
        IConfigurationInfo configurationInfo = null;
        if (uiInfo != null) {
            IMenuInfo menu = uiInfo.getMenuInfo();
            if (menu != null) {
                IConfigurationsInfo configurationsInfo = menu.getConfigurationsInfo();
                if (configurationsInfo != null) {
                    configurationInfo = configurationsInfo.getConfigurationInfoById(componentInfo.getID());

                }
            }
        }
        return configurationInfo;
    }

    private void addComponent(IScoreBoardUIInfo uiInfo, IComponentInfo componentInfo, IScoreBoardPane pane) {
        switch (componentInfo.getPaneType()) {
            case COUNTER:
                this.addController(this.addCounter(componentInfo, pane));
                break;
            case TEXT:
                IConfigurationInfo configInfo = this.getConfigInfo(uiInfo, componentInfo);
                if (configInfo != null) {
                    this.addController(this.addText(configInfo, componentInfo, pane));
                } else {
                    this.addController(this.addText(componentInfo, pane));
                }
                break;
            case TIMER:
                this.addController(this.addTimer(componentInfo, pane));
                break;
            case CHRONOMETER:
                this.addController(this.addChronometer(componentInfo, pane));
                break;
            case IMAGE:
                this.addController(this.addImage(componentInfo, pane));
                break;
        }
    }

    private void addController(Controller controller) {
        if (controller != null) {
            this.scoreBoardPaneControllers.put(controller.getId(), controller);
        }
    }

    private Controller addCounter(IComponentInfo componentInfo, IScoreBoardPane pane) {
        //TODO clean that.
        CounterComponent counter = null;
        Parent parent = null;
        try {
            URL location = CounterComponent.class.getResource("CounterComponent.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            parent = (Parent) fxmlLoader.load(location.openStream());
            counter = fxmlLoader.getController();
            counter.setParent(parent);
            counter.setId(componentInfo.getID());
            counter.initComponent(pane);
            counter.refreshUI();
        } catch (Exception ex) {
        }

        this.gpScoreBoard.add(counter.getParent(), componentInfo.getColumnIndex(), componentInfo.getRowIndex(),
                componentInfo.getColumnSpan(), componentInfo.getRowSpan());

        return counter;
    }

    private Controller addText(IComponentInfo componentInfo, IScoreBoardPane pane) {
        //TODO clean that.
        TextComponent text = null;
        Parent parent = null;
        try {
            URL location = TextComponent.class.getResource("TextComponent.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            //TODO initialize TExt component with IConfiguration default value field
            parent = (Parent) fxmlLoader.load(location.openStream());
            text = fxmlLoader.getController();
            text.setParent(parent);
            text.setId(componentInfo.getID());
            text.initComponent(pane);
            text.refreshUI();
//            text.initialize();
        } catch (Exception ex) {
            //TODO logg error
            System.out.println("Error loading Text\n" + ex.getLocalizedMessage());
        }

        this.gpScoreBoard.add(parent, componentInfo.getColumnIndex(), componentInfo.getRowIndex());
        return text;
    }

    private Controller addText(IConfigurationInfo configInfo, IComponentInfo componentInfo, IScoreBoardPane pane) {
        //TODO clean that.
        TextComponent text = null;
        Parent parent = null;
        try {
            URL location = TextComponent.class.getResource("TextComponent.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            //TODO initialize TExt component with IConfiguration default value field
            parent = (Parent) fxmlLoader.load(location.openStream());
            text = fxmlLoader.getController();
            text.setParent(parent);
            text.setId(componentInfo.getID());
            text.initComponent(pane);
            text.setText(configInfo.getDefault());
            text.refreshUI();
//            text.initialize();
        } catch (Exception ex) {
            //TODO logg error
            System.out.println("Error loading Text\n" + ex.getLocalizedMessage());
        }

        this.gpScoreBoard.add(parent, componentInfo.getColumnIndex(), componentInfo.getRowIndex());
        return text;
    }

    private Controller addTimer(IComponentInfo componentInfo, IScoreBoardPane pane) {
        //TODO clean that.
        TimerComponent timer = null;
        Parent parent = null;
        try {
            URL location = TimerComponent.class.getResource("TimerComponent.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            parent = (Parent) fxmlLoader.load(location.openStream());
            timer = fxmlLoader.getController();
            timer.setParent(parent);
            timer.setId(componentInfo.getID());
            timer.initComponent(pane);
            timer.refreshUI();
//            timer.initialize();
        } catch (Exception ex) {
        }

        this.gpScoreBoard.add(parent, componentInfo.getColumnIndex(), componentInfo.getRowIndex());
        return timer;
    }

    private Controller addChronometer(IComponentInfo componentInfo, IScoreBoardPane pane) {
        //TODO clean that.
        ChronometerComponent chronometer = null;
        Parent parent = null;
        try {
            URL location = TimerComponent.class.getResource("ChronometerComponent.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            parent = (Parent) fxmlLoader.load(location.openStream());
            chronometer = fxmlLoader.getController();
            chronometer.setParent(parent);
            chronometer.setId(componentInfo.getID());
            chronometer.initComponent(pane);
            chronometer.refreshUI();
//            timer.initialize();
        } catch (Exception ex) {
        }

        this.gpScoreBoard.add(parent, componentInfo.getColumnIndex(), componentInfo.getRowIndex());
        return chronometer;
    }

    private Controller addImage(IComponentInfo componentInfo, IScoreBoardPane pane) {
        //TODO clean that.
        ImageComponent image = null;
        Parent parent = null;
        try {
            URL location = TimerComponent.class.getResource("ImageComponent.fxml");

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

            parent = (Parent) fxmlLoader.load(location.openStream());
            image = fxmlLoader.getController();
            image.setParent(parent);
            image.setId(componentInfo.getID());
            image.initComponent(pane);
            image.refreshUI();
//            timer.initialize();
        } catch (Exception ex) {
        }

        this.gpScoreBoard.add(parent, componentInfo.getColumnIndex(), componentInfo.getRowIndex());
        return image;
    }

    public void setScoreBoardControllerValue(IConfigurationInfo configInfo) {
        Controller controller = this.scoreBoardPaneControllers.get(configInfo.getId());

        //TODO change this for an IComponent type
        switch (configInfo.getFieldType()) {
            case "text":
                ((TextComponent) controller).setText(configInfo.getDefault());
                break;
            case "timeAsc":
                ((ChronometerComponent) controller).setTime(configInfo.getMinValue());
                break;
            case "timeDes":
                ((TimerComponent) controller).setTime(configInfo.getMaxValue());
                break;
            case "numeric":
                ((CounterComponent) controller).setValue(configInfo.getMinValue());
                break;
            case "image":
                break;
        }
        this.refreshUI();
    }

    protected HashMap<String, Controller> getScoreBoardControllers() {
        return this.scoreBoardPaneControllers;
    }

    @Override
    public void refreshUI() {
        for (Controller controller : this.scoreBoardPaneControllers.values()) {
            controller.refreshUI();
        }
    }
}
