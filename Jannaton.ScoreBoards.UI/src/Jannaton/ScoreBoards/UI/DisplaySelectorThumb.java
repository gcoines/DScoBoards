/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI;

import Jannaton.ScoreBoards.UI.Control.DisplaySelectorViewModel;
import Jannaton.UI.Fxml.Controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author german
 */
public class DisplaySelectorThumb extends Controller {

    private int stageIndex;
    @FXML
    private HBox hbThumb;
    @FXML
    private ImageView ivThumb;
    @FXML
    private Label lbThumb;

    private Controller displaySelector;
    
    @FXML
    protected void hbMouseClick() {
        System.out.println("Mouse Clicked");
        DisplaySelectorViewModel.setScoreBoardIndex(stageIndex);
        
    }
    
    @FXML
    protected void hbDragDone() {
    }

    public void setSatgeIndex(int index) {
        this.stageIndex = index;
    }

    public void setImageView(ImageView image) {
        this.ivThumb.setImage(image.getImage());

        this.ivThumb.setFitWidth(image.getFitWidth());
        this.ivThumb.setFitHeight(image.getFitHeight());
    }

    public void setText(String text) {
        this.lbThumb.setText(text);
    }

    public ImageView getImageView(){
        return this.ivThumb;
    }
    
    public String getText() {
        return this.lbThumb.getText();
    }

    public int getStageIndex() {
        return this.stageIndex;
    }

    @Override
    public void refreshUI() {
    }

    public void registerEvents(Controller controller) {

        final DisplaySelector displaySelector = (DisplaySelector) controller;
        final DisplaySelectorThumb instance = this;
        final Parent parent = this.getParent();
        
        parent.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                System.out.println("MouseDragged!");
                
                ImageCursor cursor = new ImageCursor(instance.getImageView().getImage(), 50, 50);
                
//                displaySelector.getParent().setCursor(cursor);
            }
        });
        
        parent.setOnMouseDragReleased(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                System.out.println("MouseDragReleased!");
                
//                displaySelector.getParent().setCursor(Cursor.DEFAULT);
            }
        });
        
        parent.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("DragDetected!");
                /* allow any transfer mode */
                Dragboard db = parent.startDragAndDrop(TransferMode.ANY);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                
                content.putImage(instance.getImageView().getImage());
                
                content.putString(Integer.toString(instance.getStageIndex()));
                content.putHtml(instance.getText());
                db.setContent(content);
                
                
                DisplaySelector.setDragBoard(db);
                event.consume();
            }
        });

        parent.setOnDragDone(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                
                System.out.println("DragDone!");
                
//                displaySelector.getParent().setCursor(Cursor.DEFAULT);
                event.consume();
            }
        });
        
    }
}
