/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jannaton.ScoreBoards.UI.Components.Interfaces;

import Jannaton.ScoreBoards.Interfaces.IScoreBoardPane;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author german
 */
public interface IComponent {
    
    IScoreBoardPane getComponent();
    
    int getColumnIndex();
    
    void setColumnIndex(int columnIndex);
    
    int getRowIndex();
    
    void setRowIndex(int rowIndex);
    
    Point getPosition();
    
    void setPosition(int x, int y);
    
    Dimension getDimension();
    
    void setDimension(int with, int height);
    
}
