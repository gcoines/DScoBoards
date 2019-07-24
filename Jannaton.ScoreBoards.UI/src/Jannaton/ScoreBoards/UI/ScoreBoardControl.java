/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.Interfaces.IButtonsPanelInfo;
import Jannaton.ScoreBoards.Interfaces.IColumnInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentInfo;
import Jannaton.ScoreBoards.Interfaces.IComponentsInfo;
import Jannaton.ScoreBoards.Interfaces.IControlPanelInfo;
import Jannaton.ScoreBoards.Interfaces.ILayoutInfo;
import Jannaton.ScoreBoards.Interfaces.IRowInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.ScoreBoards.Interfaces.IScoreBoardUIInfo;
import Jannaton.ScoreBoards.Interfaces.ScoreBoardPaneManualAction;
import Jannaton.ScoreBoards.UI.Components.ImageComponent;
import Jannaton.UI.Fxml.Controller;
import Jannaton.Utils.Files.FileManager;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author german
 */
public class ScoreBoardControl extends Controller {

    private static ScoreBoardControl instance;
    private static ScoreBoard scoreBoardUI;
    @FXML
    private StackPane spScoreBoardControl;
    @FXML
    private GridPane gpScoreBoardControl;

    protected static Controller getInstance() {
        if (instance == null) {
            instance = new ScoreBoardControl();
        }

        return instance;
    }

    private void initializeFields() {
        this.spScoreBoardControl = (StackPane) this.getParent();
//        this.spScoreBoard.setMinHeight(this.getStage().getMinHeight());
//        this.spScoreBoard.setMaxHeight(this.getStage().getMaxHeight());
        List<Node> nodes = this.getParent().getChildrenUnmodifiable();
        for (Node node : nodes) {
            if (node.getId().equals("gpScoreBoardControl")) {
                this.gpScoreBoardControl = (GridPane) node;
            }
        }
        this.gpScoreBoardControl.getColumnConstraints().clear();
        this.gpScoreBoardControl.getRowConstraints().clear();
    }

    public void composeControl(ScoreBoard scoreBoardController, IScoreBoard scoreboard) {
        this.initializeFields();
        if (scoreboard != null) {
            this.composeGrid(scoreboard);
        }
        if (scoreBoardController != null) {
            scoreBoardUI = scoreBoardController;
        }
    }

    //TODO implement the composition with the ControlPanelInfo
    private void composeGrid(IScoreBoard scoreboard) {
        IScoreBoardUIInfo uiInfo = scoreboard.getUiIinfo();
        IControlPanelInfo controlPanelInfo = uiInfo.getControlPanelInfo();

        ILayoutInfo layout;
        IComponentsInfo components;

        if (controlPanelInfo != null) {
            layout = controlPanelInfo.getLayoutInfo();
            components = controlPanelInfo.getComponentsInfo();
        } else {
            layout = uiInfo.getLayoutInfo();
            components = uiInfo.getComponentsInfo();
        }

        if (layout != null) {
            this.addLayoutConstraints(layout);
        }
        if (components != null) {
            for (IComponentInfo component : components.getComponentInfos()) {
                //TODO implement adding depending on component type
                switch (component.getPaneType()) {
                    case BUTTONS_PANEL:
                        this.addButtonPads(scoreboard, component);
                        break;
                    case IMAGE:
                        this.addImage(component);
                        break;
                }


            }
        }
    }

    private void addLayoutConstraints(ILayoutInfo layout) {
        List<IColumnInfo> columns = layout.getColumnsInfo();
        if (columns != null) {
            for (IColumnInfo column : columns) {
                //TODO implement column attributes logic
                ColumnConstraints colConstraints = new ColumnConstraints();
                colConstraints.setPercentWidth(100 / columns.size());

                this.gpScoreBoardControl.getColumnConstraints().add(colConstraints);
            }
        }
        List<IRowInfo> rows = layout.getRowsInfo();
        if (rows != null) {

            for (IRowInfo row : rows) {
                //TODO implement column attributes logic
                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setPercentHeight(100 / rows.size());

                this.gpScoreBoardControl.getRowConstraints().add(rowConstraints);
            }
        }

    }

    //TODO specialize this method depending on the component type
    private void addButtonPads(IScoreBoard scoreboard, IComponentInfo componentInfo) {
        List<IScoreBoardPane> panes = scoreboard.getPanes();
        for (final IScoreBoardPane pane : panes) {
            if (pane.getId().equals(componentInfo.getID())) {
                final ArrayList<ScoreBoardPaneManualAction> manualActions =
                        pane.getManualActions();

                GridPane gp = new GridPane();
                gp.getStyleClass().add("gpButtonsPane");

                ILayoutInfo layoutInfo = null;
                IComponentsInfo componentsInfo = null;

                layoutInfo = ((IButtonsPanelInfo) componentInfo).getLayoutInfo();
                if (layoutInfo != null) {
                    List<IColumnInfo> columns = layoutInfo.getColumnsInfo();
                    if (columns != null) {
                        for (IColumnInfo column : columns) {
                            //TODO implement column attributes logic
                            ColumnConstraints colConstraints = new ColumnConstraints();
                            colConstraints.setPercentWidth(100 / columns.size());

                            gp.getColumnConstraints().add(colConstraints);
                        }
                    }
                    List<IRowInfo> rows = layoutInfo.getRowsInfo();
                    if (rows != null) {

                        for (IRowInfo row : rows) {
                            //TODO implement column attributes logic
                            RowConstraints rowConstraints = new RowConstraints();
                            rowConstraints.setPercentHeight(100 / rows.size());

                            gp.getRowConstraints().add(rowConstraints);
                        }
                    }

                    componentsInfo = ((IButtonsPanelInfo) componentInfo).getComponentsInfo();
                    for (IComponentInfo comp : componentsInfo.getComponentInfos()) {
                        for (int i = 0; i < manualActions.size(); i++) {
                            String actionName = manualActions.get(i).getActionName();
                            if (comp.getText().equals(actionName)) {
                                final int j = i;
                                Button button = new Button(manualActions.get(i).getActionName());
                                button.getStyleClass().add("btButtonsPane");
                                button.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent t) {
                                        manualActions.get(j).executeAction();
                                        scoreBoardUI.getScoreBoardControllers().get(pane.getId()).refreshUI();
                                    }
                                });

                                StackPane spButton = new StackPane();
                                spButton.getChildren().add(button);
                                gp.add(spButton, comp.getColumnIndex(), comp.getRowIndex(), comp.getColumnSpan(), comp.getRowSpan());
                            }
                        }
                    }
                } else {
                    int size = manualActions.size();
                    
                    for (int i = 0; i < size; i++) {
                        //TODO implement column attributes logic
                        ColumnConstraints colConstraints = new ColumnConstraints();
                        colConstraints.setPercentWidth(100 / size);

                        gp.getColumnConstraints().add(colConstraints);
                    }

                    RowConstraints rowConstraints = new RowConstraints();
                    rowConstraints.setPercentHeight(100);

                    gp.getRowConstraints().add(rowConstraints);

                    for (int i = 0; i < size; i++) {
                        final int j = i;
                        Button button = new Button(manualActions.get(i).getActionName());
                        button.getStyleClass().add("btButtonsPane");
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                manualActions.get(j).executeAction();
                                scoreBoardUI.getScoreBoardControllers().get(pane.getId()).refreshUI();
                            }
                        });
//TODO add the buttons taking care about the ComponentInfo contained at IButtonsPaneInfo
                        StackPane spButton = new StackPane();
                        spButton.getChildren().add(button);
                        gp.add(spButton, i, 0);
                    }
                }

                this.gpScoreBoardControl.add(gp, componentInfo.getColumnIndex(), componentInfo.getRowIndex(),
                        componentInfo.getColumnSpan(), componentInfo.getRowSpan());

            }
        }
    }

    private void addImage(IComponentInfo componentInfo) {
        //TODO clean that.
        IScoreBoardPane pane = this.createImage(componentInfo);

        ImageComponent image = null;
        Parent parent = null;
        try {
            URL location = ImageComponent.class.getResource("ImageComponent.fxml");

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
            System.out.println("Error adding image: " + ex.getMessage());
        }

        this.gpScoreBoardControl.add(parent, componentInfo.getColumnIndex(),
                componentInfo.getRowIndex(), componentInfo.getColumnSpan(),
                componentInfo.getRowSpan());
    }

    private IScoreBoardPane createImage(IComponentInfo componentInfo) {
        Jannaton.ScoreBoards.Components.Image pane = new Jannaton.ScoreBoards.Components.Image();

        try {
            //TODO configure the Themes/[namespace] in order to load it dinamically
            InputStream input = this.getClass().getResourceAsStream("Themes/Original/img/" + 
                    componentInfo.getFileName());
            
            File file = FileManager.createFile(input, componentInfo.getFileName());
            
            pane.setImageFile(file);
            
        } catch (Exception e) {
            System.out.println("Error loading image " + componentInfo.getFileName());
        }

        return pane;
    }

    @Override
    public void refreshUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
