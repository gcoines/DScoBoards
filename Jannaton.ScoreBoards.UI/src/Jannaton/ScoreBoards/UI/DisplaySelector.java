 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.UI.Control.DisplaySelectorViewModel;
import Jannaton.ScoreBoards.UI.Control.MenuViewModel;
import Jannaton.UI.Fxml.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

/**
 *
 * @author german
 */
public class DisplaySelector extends Controller {

    private static DisplaySelector instance;
    private DisplaySelectorViewModel viewModel;
    private static Dragboard dragBoard;
    
    @FXML
    ScrollPane scpComponents;
    @FXML
    ScrollPane spScreens;

    public DisplaySelector() {
        super();
        instance = this;
        this.viewModel = new DisplaySelectorViewModel();
    }

    //TODO especializar esto, no debe usar el menuViewModel. Se slucionará cuándo 
    //se encapsule el panel de botones del menu inicial en un control invocable
    @FXML
    private void btnScoreBoardsAction(ActionEvent event) {
        //TODO revisar conversion de ActionEvent fxml a ActionEvent awt
        MenuViewModel.callListener(MenuViewModel.ScoreBoardsButtonListener);
    }

    @FXML
    private void btnDisplaysAction(ActionEvent event) {
        MenuViewModel.callListener(MenuViewModel.DisplaysButtonListener);
    }

    @FXML
    private void btnConfigAction(ActionEvent event) {
        MenuViewModel.callListener(MenuViewModel.ConfigButtonListener);
    }

    @FXML
    private void btnStartAction(ActionEvent event) {
        MenuViewModel.callListener(MenuViewModel.StartButtonListener);
    }

    @FXML
    private void btnBack(ActionEvent event) {
        DisplaySelectorViewModel.callListener(DisplaySelectorViewModel.GoBackButtonListener);
    }

    @FXML
    private void btnDetectDisplays(ActionEvent event) {
        DisplaySelectorViewModel.callListener(DisplaySelectorViewModel.DetectDisplaysButtonListener);
    }

    @FXML
    private void btnAutoasignateDisplays(ActionEvent event) {
        DisplaySelectorViewModel.callListener(DisplaySelectorViewModel.AutoasignateButtonListener);
    }

    public static Controller getInstance() {
        if (instance == null)//TODO ojo siguiente linea
        {
            instance = new DisplaySelector();
        }

        return instance;
    }

    protected static void setDragBoard(Dragboard db){
        dragBoard = db;
    }

    protected static Dragboard getDragBoard(){
        return dragBoard;
    }
    
    @Override
    public void refreshUI() {
        this.fillThumbs();
        this.fillScreens();
    }

    private void fillThumbs() {
        VBox vbThumbs = new VBox(10);
        vbThumbs.getStyleClass().add("vbThumbs");

        //TODO unhardcore next lines
        ArrayList<ImageView> images = new ArrayList<>();
        ArrayList<String> texts = new ArrayList<>();

        images.add(UIMaster.getInstance().getScoreBoardThumb());
        images.add(UIMaster.getInstance().getScoreBoardControlThumb());

        texts.add("MARCADOR");
        texts.add("PANEL DE CONTROL");

        for (int i = 0; i < images.size(); i++) {

            DisplaySelectorThumb thumb = null;
            Parent parent = null;
            try {
                URL location = DisplaySelectorThumb.class.getResource("DisplaySelectorThumb.fxml");

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(location);
                fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

                parent = (Parent) fxmlLoader.load(location.openStream());
                thumb = fxmlLoader.getController();
                thumb.setParent(parent);

                
                thumb.setSatgeIndex(i);
                thumb.setImageView(images.get(i));
                thumb.setText(texts.get(i));
                thumb.refreshUI();
                
                thumb.registerEvents(this);
                
                vbThumbs.getChildren().add(thumb.getParent());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

        this.scpComponents.setContent(vbThumbs);
    }

    private void fillScreens() {
        List<Rectangle2D> screens = UIMaster.getInstance().getAvailableScreens();
        VBox vbThumbs = new VBox(10);
        vbThumbs.getStyleClass().add("vbThumbs");

        for (int i = 0; i < screens.size(); i++) {

            DisplaySelectorScreen screen = null;
            Parent parent = null;
            try {
                URL location = DisplaySelectorScreen.class.getResource("DisplaySelectorScreen.fxml");

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(location);
                fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());

                parent = (Parent) fxmlLoader.load(location.openStream());
                screen = fxmlLoader.getController();
                screen.setParent(parent);
                
                screen.setScreenIndex(i);
                screen.setScreenPrefSize(screens.get(i).getWidth() / 8, screens.get(i).getHeight() / 8);
                screen.refreshUI();
                
                screen.registerEvents();
                
                vbThumbs.getChildren().add(screen.getParent());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        
        this.spScreens.setContent(vbThumbs);
    }
    
}
