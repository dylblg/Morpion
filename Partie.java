
/**
 * Write a description of class Partie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partie
{
    // instance variables - replace the example below with your own
    private static int nombreCaseJouees;
    private String nomJoueur1 = "Joueur 1";
    private String nomJoueur2 = "Joueur 2";

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
    public static int getNombreCaseJouees()
    {
        return nombreCaseJouees; 
    }
    
    /**
     *  Incrémente nombreCaseJouees
     *
     */
    public void incNombreCaseJouees()
    {
        nombreCaseJouees = nombreCaseJouees+1;
    }
}
