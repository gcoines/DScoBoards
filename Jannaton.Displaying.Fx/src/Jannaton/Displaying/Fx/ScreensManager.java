/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.Displaying.Fx;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author german
 */
public class ScreensManager{
    
    //Atributtes
    private static ScreensManager instance;
    private ArrayList<Stage> detectionStages = new ArrayList<>();
    
    //Constructors
    private ScreensManager(){
    
    }
    
    //Services
    public static ScreensManager getInstance(){
        if(instance == null){
            instance = new ScreensManager();
        }
        
        return instance;
    }
    
    public ObservableList<Screen> getScreens(){
        return Screen.getScreens();
    }
    
    public Rectangle2D getMainScreenResolution(){
        return this.getScreensResolution().get(0);
    }
    
    public Rectangle2D getScreenResolution(int index){
        return this.getScreensResolution().get(index);
    }
    
    public ArrayList<Rectangle2D> getScreensResolution(){
        ObservableList<Screen> screens = this.getScreens();
        ArrayList<Rectangle2D> resolutions = new ArrayList<>();
        for(Screen screen : screens ){
            resolutions.add(screen.getBounds());
        }
        return resolutions;
    }
    
    public ArrayList<Stage> getScreensStages(boolean includeMain){
        int i = 0;
        
        if(!includeMain){
            i = 1;
        }
        
        ArrayList<Rectangle2D> screensBounds = this.getScreensResolution();
        ArrayList<Stage> stages = new ArrayList<>(screensBounds.size() - i);
        
        for(;i < screensBounds.size(); i++){
            Rectangle2D bounds = screensBounds.get(i);
            Stage stage = new Stage(StageStyle.UNDECORATED);

            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            stage.setMinWidth(bounds.getWidth());
            stage.setMinHeight(bounds.getHeight());
            
            stage.setResizable(false);
            
            stage.setFullScreen(true);

            stages.add(stage);
        }
        return stages;
    }
    
    public void detectDisplays() throws Exception{
        ArrayList<Rectangle2D> screensBounds = this.getScreensResolution();
        detectionStages = new ArrayList<>(screensBounds.size());
        for(int i = 0; i < screensBounds.size(); i++){
            Rectangle2D bounds = screensBounds.get(i);

            Stage stage = new Stage(StageStyle.UNDECORATED);

//            System.out.println(bounds.getMinX());
//            System.out.println(bounds.getMinY());
//            System.out.println(bounds.getWidth());
//            System.out.println(bounds.getHeight());

//            double x = bounds.getMinX();
//            double y = bounds.getMinY();
//            
////            stage.setX(x < 0 ? -x : x);
////            stage.setY(y < 0 ? -y : y);
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setMinWidth(bounds.getWidth());
            stage.setMinHeight(bounds.getHeight());

            Parent parent = FXMLLoader.load(getClass().getResource("ScreenIndicatorUI.fxml"));

            Scene scene = new Scene(parent, bounds.getWidth(), bounds.getHeight());
//System.out.println(scene.getX());
//System.out.println(scene.getY());
            stage.setScene(scene);

            stage.setFullScreen(true);

            detectionStages.add(stage);

        }

        for(int i = 0; i < detectionStages.size(); i++){
            if(i < detectionStages.size() - 1){
                detectionStages.get(i).show();
            }else{
                detectionStages.get(i).showAndWait();
            }
        }
        
    }
    
    public void hideDisplays(){
        for(Stage stage : detectionStages){
            stage.hide();
        }
        
        ScreenIndicatorUI.resetCounter();
    }
}
