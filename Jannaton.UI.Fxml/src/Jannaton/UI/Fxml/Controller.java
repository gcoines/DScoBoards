/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.UI.Fxml;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

/**
 *
 * @author german
 */
public abstract class Controller {

    private Parent controllerFxml;
    private Stage stage;
    private String componentId;

    public Controller() {
    }

    public String getId(){
        return this.componentId;
    }
    
    public void setId(String componentId) {
        this.componentId = componentId;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void setParent(Parent parent) {
        this.controllerFxml = parent;
    }
//        

    public Parent getParent() {
        return this.controllerFxml;
    }

    public WritableImage getThumbnail(String cssURL){
        WritableImage wi = null;
        if(this.controllerFxml != null){
            Stage stage = new Stage();
            Scene scene = new Scene(controllerFxml);
            scene.getStylesheets().add(cssURL);
            stage.setScene(scene);
            stage.show();
            wi = scene.snapshot(null);
            scene.setRoot(new Parent(){});   
            stage.close();
        }
        
        return wi;
    }

    public ImageView getThumbnail(String cssURL, double width, double height){
        ImageView ivThumb = null;
        WritableImage wi = null;
        if(this.controllerFxml != null){
            Stage stage = new Stage();
            Scene scene = new Scene(controllerFxml);
            scene.getStylesheets().add(cssURL);
            stage.setScene(scene);
            stage.show();
            wi = scene.snapshot(null);
            ivThumb = new ImageView(wi);
            
            ivThumb.setFitWidth((width));
            ivThumb.setFitHeight((height));
            ivThumb.setPreserveRatio(true);
            
            scene.setRoot(new Parent(){});   
            stage.close();
            
        }
        
        
        return ivThumb;
    }
    
    private void setStageDimension(double width, double height) {
        this.stage.setWidth(width);
        this.stage.setHeight(height);
    }

    public void setStageMinDimension(Rectangle2D bounds) {
        if (this.stage != null) {
            //TODO invest why in MAC OS there's no way to mantain the scoreboard being shown correctly when other stage have the fullScreen
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setMinWidth(bounds.getWidth());
            stage.setMinHeight(bounds.getHeight());
        }
    }

    private void setStageDimension(Rectangle2D bounds) {
        this.stage.setX(bounds.getMinX());
        this.stage.setY(bounds.getMinY());
        this.setStageDimension(bounds.getWidth(), bounds.getHeight());
    }

    @FXML
    public abstract void refreshUI();
    
    public void hide() {
        this.stage.hide();
    }

    public void show() {
        this.stage.show();
    }
}
