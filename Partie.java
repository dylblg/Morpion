
/**
 * Write a description of class Partie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partie
{
    // instance variables - replace the example below with your own
    private int x;
    private int nombreCaseJouees;
    private String nomJoueur1 = "Joueur 1";
    private String nomJoueur2 = "Joueur 2";

    /**
     * Constructor for objects of class Partie
     */
    public Partie()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * Setter nomJoueur1
     */
    public void setNomJoueur1(String nomJoueur1)
    {
        this.nomJoueur1 = nomJoueur1; 
    }

    /**
     * Getter nomJoueur 1
     */
    public String getNomJoueur1()
    {
        return nomJoueur1; 
    }

    /**
     * Setter nomJoueur 2
     */
    public void setNomJoueur2(String nomJoueur2)
    {
        this.nomJoueur2 = nomJoueur2; 
    }

    /**
     * Getter nomJoueur 2
     */
    public String getNomJoueur2()
    {
        return nomJoueur2; 
    }

    /**
     * Setter nombreCaseJouees
     */
    private void setNombreCaseJouees(int nombreCaseJouees)
    {
        this.nombreCaseJouees = nombreCaseJouees; 
    }
    
    /**
     * Getter nombreCaseJouees
     */
    public int getNombreCaseJouees()
    {
        return nombreCaseJouees; 
    }
}
