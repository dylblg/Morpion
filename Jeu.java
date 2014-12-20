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

    private ArrayList<Case> listCase;
    
    
    /**
     * Constructor for objects of class Jeu
     */
    public Jeu()
    {
        listCase = new ArrayList<Case>();
        for(int i=0; i<9; i++){
            Case c = new Case();
            listCase.add(c);
        }
    }

    /**
     * Set le statut de la case à X
     */
    public void setStatutJoueur1(int i)
    {
        Case c = listCase.get(i);
        c.setStatutX();
    }
    
     /**
     * Set le statut de la case à O
     */
    public void setStatutJoueur2(int i)
    {
        Case c = listCase.get(i);
        c.setStatutO();
    }
    
    public String getStatutClasseCase(int i)
    {
        Case c = listCase.get(i);
        String statut = c.getStatutCase();
        return statut;
    }
}
