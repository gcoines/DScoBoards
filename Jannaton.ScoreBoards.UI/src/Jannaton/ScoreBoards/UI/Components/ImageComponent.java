/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components;

import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.UI.Fxml.Controller;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author german
 */
public class ImageComponent extends Controller {

    private Component imageComponent;
    @FXML
    StackPane spImage;
    @FXML
    ImageView imgImage;

    public void initComponent(IScoreBoardPane pane) {
        this.imageComponent = new Component(pane);
//        this.imgImage = new Image(new InputStream() {});
    }

    @Override
    public void refreshUI() {

        Image image = new Image(
                ((Jannaton.ScoreBoards.Components.Image) this.imageComponent.getComponent()).getImageFile().toURI().toString(), true);

        if (image != null) {
            this.imgImage.setImage(image);
//            if (this.spImage != null) {
//                this.imgImage.setFitWidth(this.spImage.getWidth());
//                this.imgImage.setFitHeight(this.spImage.getHeight());
//            }
        }
    }
}
