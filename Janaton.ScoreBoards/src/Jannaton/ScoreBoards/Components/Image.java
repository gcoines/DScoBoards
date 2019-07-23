/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.Components;

import Jannaton.ScoreBoards.Interfaces.EnumScoreBoardPaneType;
import Jannaton.ScoreBoards.ScoreBoardPane;
import java.io.File;

/**
 *
 * @author german
 */
public class Image extends ScoreBoardPane{

    File imageFile;
    
    public Image(){
        super(EnumScoreBoardPaneType.IMAGE);
    }
    
    public File getImageFile(){
        return this.imageFile;
    }
    
    public void setImageFile(File imgFile){
        this.imageFile = imgFile;
    }
    
    @Override
    public void addActions() {
        
    }

    @Override
    public void powerOn() {
        
    }

    @Override
    public void powerOff() {
        
    }

    @Override
    public void reset() {
        
    }
    
}
