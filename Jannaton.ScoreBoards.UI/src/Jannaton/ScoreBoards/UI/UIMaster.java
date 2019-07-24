/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.Displaying.Fx.ScreensManager;
import Jannaton.ScoreBoards.Interfaces.IScoreBoard;
import Jannaton.ScoreBoards.UI.Control.DisplaySelectorViewModel;
import Jannaton.ScoreBoards.UI.Control.MenuViewModel;
import Jannaton.ScoreBoards.UI.Control.ScoreBoardConfiguratorViewModel;
import Jannaton.ScoreBoards.UI.Control.ScoreBoardSelectorViewModel;
import Jannaton.ScoreBoards.UI.Interfaces.EnumUIStates;
import Jannaton.UI.Fxml.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author german
 */
public class UIMaster {

    private Jannaton.ScoreBoards.Control.Controller controller;
    private Stage mainStage;
    private List<Stage> availableStages;
    private List<Controller> availableControllers;
    private static UIMaster instance;
    private EnumUIStates uiState = EnumUIStates.NONE;
    private EnumUIStates lastUiState = EnumUIStates.NONE;
    private Menu menu;
    private ScoreBoardSelector scoreBoardSelector;
    private ScoreBoardConfigurator scoreBoardConfigurator;
    private DisplaySelector displaySelector;
    private ScoreBoard scoreboard;
    private ScoreBoardControl control;

    private UIMaster() {
        this.controller = Jannaton.ScoreBoards.Control.Controller.getInstace();
        this.controller.getAvailableScoreBoards();
    }

    public static UIMaster getInstance() {
        if (instance == null) {
            instance = new UIMaster();
        }

        return instance;
    }

    public void Initialize(Stage mainStage, Parent menu, Parent scoreBoardSelector, Parent scoreBoardConfigurator, Parent displaySelector) {

        this.initializeScreens();

        this.mainStage = this.availableStages.get(0);
        //First Screen gets the main screen dimension as min width and height values
//        Rectangle2D rect = ScreensManager.getInstance().getMainScreenResolution();
//        this.mainStage.setMinWidth(rect.getWidth());
//        this.mainStage.setMinHeight(rect.getHeight());

        //TODO resolve fullScreenDragandDrop problems
        this.mainStage.setFullScreen(true);

        this.initializeControllers(menu, scoreBoardSelector, scoreBoardConfigurator, displaySelector);

        this.initializeViewModelEvents();

        changeUiStates(EnumUIStates.MENU);
    }

    //Initialization functions
    private void initializeControllers(Parent menu, Parent scoreBoardSelector, Parent scoreBoardConfigurator,
            Parent displaySelector) {

        this.menu = (Menu) Menu.getInstance();
        this.menu.setParent(menu);

        this.scoreBoardSelector = (ScoreBoardSelector) ScoreBoardSelector.getInstance();
        this.scoreBoardSelector.setParent(scoreBoardSelector);

        this.scoreBoardConfigurator = (ScoreBoardConfigurator) ScoreBoardConfigurator.getInstance();
        this.scoreBoardConfigurator.setParent(scoreBoardConfigurator);

        this.displaySelector = (DisplaySelector) DisplaySelector.getInstance();
        this.displaySelector.setParent(displaySelector);
    }

    private void initializeViewModelEvents() {

        //Menu View Model Events
        MenuViewModel.ScoreBoardsButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuScoreBoardsButtonAction();
            }
        };

        MenuViewModel.ConfigButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuConfigButtonAction();
            }
        };

        MenuViewModel.DisplaysButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDisplaysButtonAction();
            }
        };

        MenuViewModel.StartButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuStartButtonAction();
            }
        };

        MenuViewModel.ExitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuExitButtonAction();
            }
        };


        //ScoreBoard Selector View Model Events
        ScoreBoardSelectorViewModel.GoBackButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardSelectorGoBackButtonAction();
            }
        };

        //TODO implement some auto buttonListeners implementation
        ScoreBoardSelectorViewModel.BasketballButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardSelectorBasketballButtonAction();
            }
        };

        ScoreBoardSelectorViewModel.FootballButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardSelectorFootballButtonAction();
            }
        };

        //Displays Selector View Model Events
        ScoreBoardConfiguratorViewModel.OkButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardConfiguratorOkButtonAction();
            }
        };

        ScoreBoardConfiguratorViewModel.GoBackButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardConfiguratorGoBackButtonAction();
            }
        };

        //Displays Selector View Model Events
        DisplaySelectorViewModel.DetectDisplaysButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplaySelectorDetectDisplaysButtonAction();
            }
        };

        DisplaySelectorViewModel.AutoasignateButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplaySelectorAutoasignateDisplaysButtonAction();
            }
        };

        DisplaySelectorViewModel.ScoreBoardAsignationCompleted = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplaySelectorScoreBoardAsignationCompletedButtonAction();
            }
        };

        DisplaySelectorViewModel.GoBackButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplaySelectorGoBackButtonAction();
            }
        };
    }

    private void initializeScreens() {
        this.availableStages = ScreensManager.getInstance().getScreensStages(true);

//        this.configureStage(this.mainStage, ScreensManager.getInstance().getScreensStages(true).get(0));
    }

    private void configureStage(Stage target, Stage source) {
        target.setWidth(source.getWidth());
        target.setHeight(source.getHeight());
    }

    protected List<Rectangle2D> getAvailableScreens() {
        return ScreensManager.getInstance().getScreensResolution();
    }

    //Transition stages fuctions
    private void changeUiStates(EnumUIStates state) {

        this.lastUiState = this.uiState;

        this.uiState = state;

        this.activateTransition(state);
    }

    private void activateTransition(EnumUIStates state) {

        switch (state) {
            case NONE:

                break;

            case MENU:
                this.changeStage(this.menu, 0, false, true);
                break;

            case SCOREBOARDSELECTOR:
                this.changeStage(this.scoreBoardSelector, 0, false, true);
                break;

            case DISPLAYSELECTOR:
                //TODO UI refresh have to be done in the show method from the Controller class
                this.changeStage(this.displaySelector, 0, false, true);
                this.displaySelector.refreshUI();
                break;

            case SCOREBOARDCONFIGURATION:
                this.changeStage(this.scoreBoardConfigurator, 0, false, true);
                this.scoreBoardConfigurator.setSelectedScoreboard(this.controller.getSelectedScoreBoard());
                this.scoreBoardConfigurator.setSelectedScoreBoardComponent(this.scoreboard);
                this.scoreBoardConfigurator.refreshUI();
                break;
            case SCOREBOARDSHOWING:
                if (this.availableStages.size() > 1) {
                    this.showScoreBoards(false, false);
                } else {
                    this.showScoreBoards(true, false);
                }
                break;
        }
    }

    private void showScoreBoards(boolean newStage, boolean fullScreen) {
        HashMap<Integer, Integer> scoreboardsToScreens = this.controller.getScoreBoardsToScreens();

        if (scoreboardsToScreens != null && !scoreboardsToScreens.isEmpty()) {
            for (Integer scoreBoardIndex : scoreboardsToScreens.keySet()) {
                this.changeStage(this.availableControllers.get(scoreBoardIndex),
                        scoreboardsToScreens.get(scoreBoardIndex),
                        newStage, fullScreen);
            }
        }

    }

    //TODO place all available Stages in same Array, with index starting at zero
    private void changeStage(Controller controller, int screenIndex, boolean newStage, boolean fullScreen) {

        Stage stage;
        Scene scene;

        if (!newStage) {

            stage = this.availableStages.get(screenIndex);
            scene = stage.getScene();

            if (scene == null) {
                scene = new Scene(controller.getParent(), stage.getWidth(), stage.getHeight());

                scene.getStylesheets().add(getClass().getResource("Themes/Original/main.css").toExternalForm());
            } else {
                scene.setRoot(controller.getParent());
            }

        } else {
            stage = new Stage();

            scene = controller.getParent().getScene();

            if (scene == null) {
                scene = new Scene(controller.getParent());

                scene.getStylesheets().add(getClass().getResource("Themes/Original/main.css").toExternalForm());
            }
            
            this.mainStage.toBack();
            stage.toFront();
        }


        stage.setScene(scene);
        //TODO revisar esto
        stage.setFullScreen(fullScreen);

        stage.show();
    }

    private void changeMainScene(Controller controller) {
        //TODO La siguiente linea seria para recalcular la dimension de la pantalla 
//        Rectangle2D bounds = ScreensManager.getInstance().getMainScreenResolution();
        Scene scene = this.mainStage.getScene();
        if (scene == null) {
            scene = new Scene(controller.getParent(), this.mainStage.getWidth(), this.mainStage.getHeight());
            //TODO el path de los estilo tendra que ser modificado dinamicamente, o accedido mediante una
            //propiedad modificable.
            scene.getStylesheets().add(getClass().getResource("Themes/Original/main.css").toExternalForm());

            this.mainStage.setScene(scene);
        } else {
            this.mainStage.getScene().setRoot(controller.getParent());
        }
//        this.mainStage.sizeToScene();
        //TODO revisar esto
        if (!this.mainStage.isFullScreen()) {
            //TODO resolve fullScreenDragandDrop problems
            this.mainStage.setFullScreen(true);
        }
        this.mainStage.show();
    }

    //TODO implement next function to allow a Controller to be shown at the 
    //availableStage index selected 
    private void changeAvailableStage(int stageIndex, Controller controller) {
        if (this.availableStages != null) {
            //This is needed in case of non second displays exists in the system
            if (this.availableStages.size() > 0) {
                Stage stage = this.availableStages.get(stageIndex);
                if (stage != null) {
                    Scene scene = stage.getScene();
                    if (scene == null) {
                        if (controller != null) {
                            scene = new Scene(controller.getParent());
                            scene.getStylesheets().add(getClass().getResource("Themes/Original/main.css").toExternalForm());
                            stage.setScene(scene);

                            if (!stage.isFullScreen()) {
                                stage.setFullScreen(true);
                            }

                            stage.show();
                            //TODO unify showing method. UIMaster controller, or Controller controlled
//                        controller.setStage(stage);
//                        controller.setStageMinDimension(ScreensManager.getInstance().getScreenResolution(1)); 
//                        controller.show();
                        } else {
                            this.changeMainScene(this.scoreBoardSelector);
                        }
                    } else if (controller != null) {
                        stage.getScene().setRoot(controller.getParent());

                        if (!stage.isFullScreen()) {
                            stage.setFullScreen(true);
                        }
                        stage.show();
                        //TODO unify showing method. UIMaster controller, or Controller controlled
//                    controller.setStage(stage);
//                        controller.setStageMinDimension(ScreensManager.getInstance().getScreenResolution(1)); 
//                        controller.show();
                    }


                } else {
                    //TODO report stage error
                }
                //in case single display on the system:
            } else {
                //TODO this is not best place to do that
                //load windowed mode
                this.mainStage.setFullScreen(false);

                Scene scene = new Scene(controller.getParent());

                scene.getStylesheets().add(getClass().getResource("Themes/Original/main.css").toExternalForm());

                Stage stage = new Stage();
                stage.setScene(scene);

                stage.show();
            }
        }
        //TODO else report error
    }

    //ActionEvent invocations
    protected void MenuDisplaysButtonAction() {
        this.changeUiStates(EnumUIStates.DISPLAYSELECTOR);
    }

    protected void MenuConfigButtonAction() {
        this.changeUiStates(EnumUIStates.SCOREBOARDCONFIGURATION);
    }

    protected void MenuScoreBoardsButtonAction() {
        this.changeUiStates(EnumUIStates.SCOREBOARDSELECTOR);
    }

    protected void MenuStartButtonAction() {
        this.changeUiStates(EnumUIStates.SCOREBOARDSHOWING);
    }

    protected void MenuExitButtonAction() {
        System.exit(0);
    }

    protected void ScoreBoardSelectorBasketballButtonAction() {
        //TODO the buttonActions have to be abstracted, 
        //in order to allow dinamyc loading and not that hardcoded index selection
        this.selectScoreBoard(0);
//TODO decide wich Screen should be shown
        this.changeUiStates(EnumUIStates.MENU);
    }

    protected void ScoreBoardSelectorFootballButtonAction() {

        this.selectScoreBoard(1);
//TODO decide wich Screen should be shown         
        this.changeUiStates(EnumUIStates.MENU);
    }

    protected void ScoreBoardSelectorConfigurationButtonAction() {
        this.changeUiStates(EnumUIStates.SCOREBOARDCONFIGURATION);
    }

    protected void ScoreBoardSelectorGoBackButtonAction() {
        this.changeUiStates(EnumUIStates.MENU);
    }

    protected void ScoreBoardConfiguratorOkButtonAction() {
        this.changeUiStates(EnumUIStates.MENU);
    }

    protected void ScoreBoardConfiguratorGoBackButtonAction() {
        this.changeUiStates(EnumUIStates.SCOREBOARDSELECTOR);
    }

    protected void DisplaySelectorDetectDisplaysButtonAction() {
        this.displayDetectionTransition();
    }

    protected void DisplaySelectorAutoasignateDisplaysButtonAction() {
        //TODO implement autoasignate logic
    }

    protected void DisplaySelectorScoreBoardAsignationCompletedButtonAction() {
        //TODO implement autoasignate logic
        this.controller.setScoreBoardToScreen(DisplaySelectorViewModel.GetScoreBoardIndex(),
                DisplaySelectorViewModel.GetScreenIndex());
    }

    protected void DisplaySelectorGoBackButtonAction() {
        this.changeUiStates(EnumUIStates.MENU);
    }

    //Helper Functions
    private void displayDetectionTransition() {
        try {
            this.mainStage.hide();
            ScreensManager.getInstance().detectDisplays();
        } catch (Exception ex) {
            //TODO implement exception reporting
        } finally {
            mainStage.show();
        }
    }

    private void selectScoreBoard(int selectedIndex) {
        this.controller.setAvailableScoreBoard(selectedIndex);

        IScoreBoard selected = this.controller.getSelectedScoreBoard();

        //TODO study if the FXML loading can be done at the app initialitzation 
        //at Initializer class to avoid try catch handling here
        try {
            this.scoreboard = ScoreBoardComposer.getInstance().loadScoreBoard(selected);
            this.control = ScoreBoardControlComposer.getInstance().loadScoreBoardControl(this.scoreboard, selected);

            this.availableControllers = new ArrayList<>();
            this.availableControllers.add(this.scoreboard);
            this.availableControllers.add(this.control);
        } catch (Exception ex) {
            //TODO report error
            System.out.println("Error loading scoreboard");
        }
    }

    protected ImageView getScoreBoardThumb() {
        if (this.scoreboard != null) {
            //TODO unhardcore aspect ratio
            double aspect = 9d / 16d;
            double width = this.mainStage.getMinWidth() / 5;
            double height = width * aspect;

            ImageView scoreboardThumb = this.scoreboard.getThumbnail(getClass().getResource("Themes/Original/main.css").toExternalForm(),
                    width, height);

            return scoreboardThumb;
        }
        return null;
    }

    protected ImageView getScoreBoardControlThumb() {
        if (this.control != null) {
            //TODO unhardcore aspect ratio
            double aspect = 9d / 16d;
            double width = this.mainStage.getMinWidth() / 5;
            double height = width * aspect;

            ImageView scoreboardThumb = this.control.getThumbnail(getClass().getResource("Themes/Original/main.css").toExternalForm(),
                    width, height);

            return scoreboardThumb;
        }
        return null;
    }
}
