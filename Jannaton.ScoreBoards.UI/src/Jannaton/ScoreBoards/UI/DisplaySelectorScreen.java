/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.UI.Fxml.Controller;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author german
 */
public class DisplaySelectorScreen extends Controller {

    private int stageIndex;
    @FXML
    private HBox hbScreen;
    @FXML
    private StackPane spScreen;
    @FXML
    private ImageView ivScreen;
    @FXML
    private Label lbScreen;
    @FXML
    private VBox vbScreen; 
    @FXML
    private Label lbScreenName;
    
    private ArrayList<String> screenNames = new ArrayList<>();

    public void setScreenName(String name) {
        boolean contains = false;
        for(String screenName : screenNames){
            if(name.equals(screenName)){
                contains = true;
            }
        }
        if(!contains){
            screenNames.add(name);
            Label lb = new Label(name);
            lb.getStyleClass().add("lbThumb");
            this.vbScreen.getChildren().add(lb);
        }   
    }

    //TODO implement this
    public void setImage(Image image){
//        this.ivScreen.setImage(image);
    }
    
    public void setScreenIndex(int index) {
        this.stageIndex = index;
        this.lbScreen.setText(Integer.toString(index + 1));
    }

    public void setScreenPrefSize(double widht, double height) {
        this.spScreen.setPrefSize(widht, height);
    }


    @Override
    public void refreshUI() {
    }

    public void registerEvents() {

        final DisplaySelectorScreen instance = this;
        final Parent parent = this.getParent();
        
        parent.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");
                
                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != parent &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.ANY);
                }
                
                event.consume();
            }
        });
        
        parent.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                System.out.println("DragEntered!");
                Dragboard db = event.getDragboard();

                if (db.hasString()) {
                    instance.setScreenName(db.getHtml());
                }
                if (db.hasImage()) {
                    instance.setImage(db.getImage());
                }
                event.consume();
            }
        });

        parent.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
//                ivScreen.setImage(null);
                
                System.out.println("DragExited!");
//                parent.setScreenName("");

                event.consume();
            }
        });

        parent.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("DragDropped!");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                
                if (db.hasString() && db.hasHtml()) {
                    instance.setScreenName(db.getHtml());
                    event.setDropCompleted(true);
                }

                //TODO asignar en UIController indices de pantallas
                Jannaton.ScoreBoards.Control.Controller controller = Jannaton.ScoreBoards.Control.Controller.getInstace();
                controller.setScoreBoardToScreen(Integer.parseInt(db.getString()), stageIndex);
                
                event.consume();
            }
        });
    }
}
