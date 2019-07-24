package Jannaton.Displaying;


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author german
 */
public class DisplaysManager {
    
    //Atributes
    private static DisplaysManager instance;
    
    //Constructors
    private DisplaysManager(){
        
    }
    
    //Services
    public static DisplaysManager getInstance(){
        if(instance == null)
            instance = new DisplaysManager();
        
        return instance;
    }
    
    public GraphicsDevice[] getDisplays(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        if(ge != null)
            return ge.getScreenDevices();
        else
            return new GraphicsDevice[0];
    }
    
    public Dimension getMainDisplayResolution(){
        return this.getDisplaysResolutions()[0];
    }
    
    public Dimension[] getDisplaysResolutions(){
        GraphicsDevice[] screenDevices = this.getDisplays();
        Dimension[] resolutions = new Dimension[screenDevices.length];
        for(int i = 0; i < screenDevices.length; i++){
            DisplayMode displayMode = screenDevices[i].getDisplayMode();
            if(displayMode != null)
                resolutions[i] = new Dimension(displayMode.getWidth(), displayMode.getHeight());
            else
                resolutions[i] = new Dimension(0, 0);
        }
        return resolutions;
    }
    
    public void detectDisplays(){
        GraphicsDevice[] screenDevices = this.getDisplays();
        JFrame[] jFrames = new JFrame[screenDevices.length];
        for(int i = 0; i < screenDevices.length; i++){
            GraphicsDevice screenDevice = screenDevices[i];
            
            JFrame jf = new JFrame(screenDevice.getDefaultConfiguration());            
                      
            jf.setUndecorated(true);
            
            jf.setBackground(Color.black);  
            
            JLabel lb = new JLabel(Integer.toString(i + 1), SwingConstants.CENTER);
            lb.setPreferredSize(jf.getMaximumSize());
            lb.setBackground(Color.black);
            lb.setForeground(Color.orange);
            lb.setFont(new Font("Arial", Font.BOLD, 330));
            
            jf.add(lb, BorderLayout.CENTER);
            
            screenDevice.setFullScreenWindow(jf);
            
            jFrames[i] = jf;
        }
        try{
            for(JFrame jframe : jFrames)
                jframe.setVisible(true);
            
            Thread.sleep(4000);
            
            for(JFrame jframe : jFrames){
                jframe.setVisible(false);
                jframe.dispose();
            }
            
        }catch(Exception ex){};
    }
    
//    public void previewScoreBoard(){
//        
//    }
    
//    public void assignScoreBoard(){
//        
//    }
    
//    public void previewAssignedScoreBoard(){
//        
//    }
        
    public void startShowing(){
        
    }
}
