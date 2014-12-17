import java.util.ArrayList;

/**
 * Write a description of class Jeu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jeu
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<Case> listCase;
    
    /**
     * Constructor for objects of class Jeu
     */
    public Jeu()
    {
        listCase = new ArrayList<Case>();
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
