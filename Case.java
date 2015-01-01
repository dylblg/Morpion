
/**
 * Write a description of class Case here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Case
{
    private String statutCase;
    //private int statut; pour addition au cas ou

    /**
     * Constructor for objects of class Case
     */
    public Case()
    {
        statutCase = "libre";
        //statut = 0;
    }

    /**
     * Getter de la Case
     */

    public String getStatutCase()
    {
        return statutCase;
    }
    /**
    public int getStatut()
    {
    return statut;
    }
     **/

    /**
     * Setter le statut de la Case à X
     */
    public void setStatutX()
    {
        statutCase = "X";
        //statut = 4;
    }

    /**
     * Setter le statut de la Case à O
     */
    public void setStatutO()
    {
        statutCase = "O";
        //statut = 1;
    }

    public void setStatutLibre()
    {
        statutCase = "libre";
    }
}
