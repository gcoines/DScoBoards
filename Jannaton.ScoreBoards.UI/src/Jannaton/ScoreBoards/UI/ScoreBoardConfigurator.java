/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.Interfaces.IConfigurationInfo;
import Jannaton.ScoreBoards.Interfaces.IConfigurationsInfo;
import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.UI.Control.ScoreBoardConfiguratorViewModel;
import Jannaton.UI.Fxml.Controller;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author german
 */
public class ScoreBoardConfigurator extends Controller {

    private static ScoreBoardConfigurator instance;
    private ScoreBoardConfiguratorViewModel viewModel;
    private IConfigurationsInfo configurations;
    private IScoreBoard selected;
    private ScoreBoard scoreboardComponent;
    @FXML
    private VBox vbConfigurator;

    public ScoreBoardConfigurator() {
        super();
        this.instance = this;
        this.viewModel = new ScoreBoardConfiguratorViewModel();
    }

    @FXML
    private void btnBack(ActionEvent event) {
        ScoreBoardConfiguratorViewModel.callListener(ScoreBoardConfiguratorViewModel.GoBackButtonListener);
    }

    @FXML
    private void btnOk(ActionEvent event) {

        ObservableList<Node> hboxes = this.vbConfigurator.getChildren();

        ArrayList<Node> fields = new ArrayList<>();
        
        for(Node hbox : hboxes){
                fields.addAll(((HBox)hbox).getChildren());
        }
        
        for (IConfigurationInfo config : this.configurations.getConfigurationInfos()) {
            for (Node field : fields) {
                if (config.getId().equals(field.getId())) {
                    switch (config.getFieldType()) {
                        case "text":
                            config.setDefault(((TextField) field).getText());
                            break;
                        case "timeAsc":
                            config.setMinValue(((TextField) field).getText());
                            break;
                        case "timeDes":
                            config.setMaxValue(((TextField) field).getText());
                            break;
                        case "numeric":
                            config.setMinValue(((TextField) field).getText());
                            break;
                        case "image":
                            break;
                    }
                    this.scoreboardComponent.setScoreBoardControllerValue(config);
                }
            }
        }

        ScoreBoardConfiguratorViewModel.callListener(ScoreBoardConfiguratorViewModel.OkButtonListener);
    }

    //TODO implement some auto btnActions generation stuff to allow the UI load configuration depending behaviours
    public static Controller getInstance() {
        if (instance == null)//TODO ojo siguiente linea
        {
            instance = new ScoreBoardConfigurator();
        }

        return instance;
    }

    public void setSelectedScoreboard(IScoreBoard selected) {
        this.selected = selected;
    }

    public void setSelectedScoreBoardComponent(ScoreBoard scoreboardComponent) {
        this.scoreboardComponent = scoreboardComponent;
    }

    @Override
    public void refreshUI() {

        this.vbConfigurator.getChildren().clear();

        if (this.selected != null) {
            this.configurations = this.selected.getUiIinfo().getMenuInfo().getConfigurationsInfo();
        }

        for (IConfigurationInfo config : this.configurations.getConfigurationInfos()) {
            Label lbConfig = new Label(config.getFieldName());

            lbConfig.setId("lbConfigField");
            lbConfig.getStyleClass().add("lbConfigField");

            lbConfig.setMinWidth(250);
            
            String fieldType = config.getFieldType();

            Control control = null;

            //TODO unhardcode this
            if (fieldType != null) {
                switch (fieldType) {
                    case "text":
                        control = this.createTextField(config);
                        break;
                    case "timeAsc":
                        control = this.createTimeAscField(config);
                        break;
                    case "timeDes":
                        control = this.createTimeDesField(config);
                        break;
                    case "numeric":
                        control = this.createNumericField(config);
                        break;
                    case "image":
                        break;
                }
                control.setId(config.getId());
                control.getStyleClass().add("configField");
            }


            if (control != null) {

                HBox hbox = new HBox(20);
                
                hbox.setMinHeight(40);
                
                hbox.getChildren().add(lbConfig);
                hbox.getChildren().add(control);

                this.vbConfigurator.getChildren().add(hbox);
            }

        }
    }

    private Control createTextField(IConfigurationInfo config) {
        TextField text = new TextField();
        String defaultValue = config.getDefault();
        if (defaultValue != null) {
            text.setText(defaultValue);
        }
        text.getStyleClass().add("txtConfigField");
        return (Control) text;
    }

    private Control createNumericField(IConfigurationInfo config) {
        TextField text = new TextField();
        String minValue = config.getMinValue();
        if (minValue != null) {
            text.setText(minValue);
        }

        text.getStyleClass().add("numConfigField");

        return (Control) text;
    }

    private Control createTimeAscField(IConfigurationInfo config) {
        TextField text = new TextField();
        String minValue = config.getMinValue();
        if (minValue != null) {
            text.setText(minValue);
        }

        text.getStyleClass().add("timeConfigField");

        return (Control) text;
    }

    private Control createTimeDesField(IConfigurationInfo config) {
        TextField text = new TextField();
        String minValue = config.getMaxValue();
        if (minValue != null) {
            text.setText(minValue);
        }

        text.getStyleClass().add("timeConfigField");

        return (Control) text;
    }
}
