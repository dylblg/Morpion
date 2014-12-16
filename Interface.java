import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javafx.scene.shape.Circle;

/**
 * Write a description of class Interface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interface
{
    // instance variables - replace the example below with your own
    String name = "canvas";
    Canvas canv = new Canvas(name, 600, 500, Color.black);

    /**
     * Constructor for objects of class Interface
     */
    public Interface()
    {
        // initialise instance variables
        canv.setVisible(true);
        initialiseJeu();
        ajoutCroix();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void initialiseJeu()
    {
        canv.setForegroundColor(Color.white);
        canv.drawLine(200,0,200,500);
        canv.drawLine(400,0,400,500);
        canv.drawLine(0,167,600,167);
        canv.drawLine(0,334,600,334);
    }

    public void curseur()
    {
        int xPos = 80;
        int yPos = 60;
        canv.setForegroundColor(Color.lightGray);
        canv.fillRectangle(xPos, yPos, 40, 40);
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

