import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javafx.scene.shape.Circle;
import java.awt.event.*;

/**
 * Write a description of class Interface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interface
{
    String name = "canvas";
    Canvas canv = new Canvas(name, 600, 500, Color.white);
    //private CanvasPane canvas2;
    int xPos = 2;
    int yPos = 2;
    /**
     * Constructor for objects of class Interface
     */
    public Interface()
    {
        // initialise instance variables
        canv.setVisible(true);
        initialiseJeu();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void initialiseJeu()
    {
        canv.setForegroundColor(Color.black);
        canv.drawLine(200,0,200,500); //x1, y1, x2, y2
        canv.drawLine(400,0,400,500);
        canv.drawLine(0,167,600,167);
        canv.drawLine(0,334,600,334);
        curseur(xPos, yPos);
        ajoutCroix();
    }

    public void deplaceCurseur() {
        canv.frame.addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT && xPos<203){
                        xPos+=200;
                        curseur(xPos,yPos);
                        canv.erase();
                        initialiseJeu();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_LEFT && xPos>200){
                        xPos-=200;
                        curseur(xPos,yPos);
                        canv.erase();
                        initialiseJeu();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_UP && yPos>166){
                        yPos-=167;
                        curseur(xPos,yPos);
                        canv.erase();
                        initialiseJeu(); 
                    }
                    if(e.getKeyCode() == KeyEvent.VK_DOWN && yPos<203){
                        yPos+=167;
                        curseur(xPos,yPos);
                        canv.erase();
                        initialiseJeu(); 
                    }
                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void keyTyped(KeyEvent e) {

                }

            });

    }

    public void curseur(int xPos, int yPos)
    {

        canv.setForegroundColor(Color.red);
        canv.Rectangle(xPos, yPos, 194, 161);

    }

    public void ajoutCroix()
    {
        int xPos1 = 60 ;
        int yPos1 = 40 ;
        int xPos2 = 140;
        int yPos2 = 40;               
        canv.setForegroundColor(Color.blue);
        canv.drawLine(xPos1,yPos1,xPos1+80,yPos1+80);
        canv.drawLine(xPos1+1,yPos1,xPos1+81,yPos1+80);
        canv.drawLine(xPos1+2,yPos1,xPos1+82,yPos1+80);
        canv.drawLine(xPos1+3,yPos1,xPos1+83,yPos1+80);
        canv.drawLine(xPos1+4,yPos1,xPos1+84,yPos1+80);
        canv.drawLine(xPos1+5,yPos1,xPos1+85,yPos1+80);
        canv.drawLine(xPos2,yPos2,xPos2-80,yPos2+80);
        canv.drawLine(xPos2+1,yPos2,xPos2-79,yPos2+80);
        canv.drawLine(xPos2+2,yPos2,xPos2-78,yPos2+80);
        canv.drawLine(xPos2+3,yPos2,xPos2-77,yPos2+80);
        canv.drawLine(xPos2+4,yPos2,xPos2-76,yPos2+80);
        canv.drawLine(xPos2+5,yPos2,xPos2-75,yPos2+80);

    }

    public void ajoutCercle()
    {
        int xPos = 60 ;
        int yPos = 40 ;              
        canv.setForegroundColor(Color.red);
        canv.fillCircle(xPos,yPos,80);
    }

}

