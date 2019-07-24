/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components;

import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import Jannaton.ScoreBoards.ScoreBoardPane;
import Jannaton.ScoreBoards.UI.Components.Interfaces.IComponent;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author german
 */
//TODO evaluate if this class should be abstract and especialized
public class Component implements IComponent {
    
    private IScoreBoardPane component;
    private int columnIndex;
    private int rowIndex;
    private int minX;
    private int minY;
    private int width;
    private int height;
    
    public Component(IScoreBoardPane component){
        this.component = component;
    }
    
    @Override
    public IScoreBoardPane getComponent(){
        return this.component;
    }
    
    @Override
    public int getColumnIndex() {
        return this.columnIndex;
    }

    @Override
    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    @Override
    public int getRowIndex() {
        return this.rowIndex;
    }

    @Override
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
    
    @Override
    public Point getPosition(){
        return new Point(this.minX, this.minY);
    }
    
    @Override
    public void setPosition(int x, int y){
        this.minX = x;
        this.minY = y;
    }
    
    @Override
    public Dimension getDimension(){
        return new Dimension(this.width, this.height);
    }
    
    @Override
    public void setDimension(int width, int height){
        this.width = width;
        this.width = height;
    }

    
}
