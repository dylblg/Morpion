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
    int xPosCurs = 2;
    int yPosCurs = 2;
    int xPosCroix1 = 60 ;
    int yPosCroix1 = 40 ;
    int xPosCroix2 = 140;
    int yPosCroix2 = 40; 
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
        curseur(xPosCurs, yPosCurs);
        ajoutCercle();
        ajoutCroix(xPosCroix1+200, yPosCroix1, xPosCroix2+200, yPosCroix2);
    }

    public void deplaceCurseur() {
        canv.frame.addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT && xPosCurs<203){
                        xPosCurs+=200;
                        curseur(xPosCurs,yPosCurs);
                        canv.erase();
                        initialiseJeu();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_LEFT && xPosCurs>200){
                        xPosCurs-=200;
                        curseur(xPosCurs,yPosCurs);
                        canv.erase();
                        initialiseJeu();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_UP && yPosCurs>166){
                        yPosCurs-=167;
                        curseur(xPosCurs,yPosCurs);
                        canv.erase();
                        initialiseJeu(); 
                    }
                    if(e.getKeyCode() == KeyEvent.VK_DOWN && yPosCurs<203){
                        yPosCurs+=167;
                        curseur(xPosCurs,yPosCurs);
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

    public void ajoutCroix(int xPos1, int yPos1, int xPos2, int yPos2)
    {

        canv.setForegroundColor(Color.blue);
        canv.drawThickLine(xPos1, yPos1, xPos1+80, yPos1+80, 10);
        canv.drawThickLine(xPos2, yPos2, xPos2-80, yPos2+80, 10);
    }

    public void ajoutCercle()
    {
        int xPos = 40 ;
        int yPos = 25 ;              
        canv.setForegroundColor(Color.red);
        canv.circle(xPos,yPos,110,20);
    }

}

