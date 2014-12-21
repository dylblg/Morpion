
/**
 * Write a description of class Case here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Case
{
    private String statutCase;

    /**
     * Constructor for objects of class Case
     */
    public Case()
    {
        statutCase = "libre";
    }

    /**
     * Getter de la Case
     */

    public String getStatutCase()

    {
        return statutCase;
    }

    /**
     * Setter le statut de la Case à X
     */
    public void setStatutX()
    {
        statutCase = "X";
    }

    /**
     * Setter le statut de la Case à O
     */
    public void setStatutO()
    {
        statutCase = "O";
    }
}
