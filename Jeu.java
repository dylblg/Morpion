import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Write a description of class Jeu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jeu
{
    //Interface inter = new Interface();

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
        c.setStatutO();
    }

    /**
     * Set le statut de la case à O
     */
    public void setStatutJoueur2(int i)
    {
        Case c = listCase.get(i);
        c.setStatutX();
    }

    public String getStatutClasseCase(int i)
    {
        Case c = listCase.get(i);
        String statut = c.getStatutCase();
        return statut;
    }

    public void gagnant()
    {
        String message = "Vous avez gagné, voulez-vous recommencer ?";
        for (int k=0; Partie.getNombreCaseJouees()<=8; k++)
        {
            if (getStatutClasseCase(0).equals("O") && getStatutClasseCase(1).equals("O") && getStatutClasseCase(2).equals("O"))
            // première ligne
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
            else if (getStatutClasseCase(3).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(5).equals("O"))
            // deuxième ligne
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
            else if (getStatutClasseCase(6).equals("O") && getStatutClasseCase(7).equals("O") && getStatutClasseCase(8).equals("O"))
            // troisième ligne
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
            else if (getStatutClasseCase(0).equals("O") && getStatutClasseCase(3).equals("O") && getStatutClasseCase(6).equals("O"))
            // première colonne
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
            else if (getStatutClasseCase(1).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(7).equals("O"))
            // deuxième colonne
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
            else if (getStatutClasseCase(2).equals("O") && getStatutClasseCase(5).equals("O") && getStatutClasseCase(8).equals("O"))
            // troisième colonne
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
            else if (getStatutClasseCase(0).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(8).equals("O"))
            // première diagonale
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
            else if (getStatutClasseCase(2).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(6).equals("O"))
            // deuxième diagonale
            {
                System.out.println("Il y a un gagnant!");
                break;
            }
        }
    }
}
