import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javafx.scene.shape.Circle;
import java.awt.event.*;

/**
 * Write a description of class Jeu here.
 * 
 * @authors Belgy Dylan and Gerosa Arnaud 
 * @version (a version number or a date)
 */
public class Jeu
{
    //Interface inter = new Interface();

    private ArrayList<Case> listCase;
    Interface inter = new Interface();

    //Pour setter les cases a occupé
    private int j=0;

    /**
     * Constructor for objects of class Jeu
     */
    public Jeu()
    {
        inter.canv.setVisible(true);
        listCase = new ArrayList<Case>();
        for(int i=0; i<9; i++){
            Case c = new Case();
            listCase.add(c);
        }

        String joueur1 = JOptionPane.showInputDialog("Entrez le nom du joueur 1");
        inter.partie.setNomJoueur1(joueur1);

        String joueur2 = JOptionPane.showInputDialog("Entrez le nom du joueur 2");
        inter.partie.setNomJoueur2(joueur2);
        inter.initialiseVariable();
        inter.messageAcceuil();
        dessineJeu();
    }

    public void dessineJeu()
    {
        inter.initialiseJeu(inter.xPosCurs, inter.yPosCurs);
        deplaceCurseur();
        gagnant();
    }

    public void recommenceJeu()
    {

        for(int i=0; i<9; i++){

            Case c = listCase.get(i);
            c.setStatutLibre();
        }
        inter.reinitialiseJeu();
        inter.initialiseVariable();
        inter.initialiseJeu(inter.xPosCurs, inter.yPosCurs);
        j=0;
<<<<<<< HEAD
=======
        deplaceCurseur();
>>>>>>> FETCH_HEAD
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
        for (int k=0; inter.partie.getNombreCaseJouees()<=8; k++)
        {
            if (getStatutClasseCase(0).equals("O") && getStatutClasseCase(1).equals("O") && getStatutClasseCase(2).equals("O"))
            // première ligne
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }
            else if (getStatutClasseCase(3).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(5).equals("O"))
            // deuxième ligne
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }
            else if (getStatutClasseCase(6).equals("O") && getStatutClasseCase(7).equals("O") && getStatutClasseCase(8).equals("O"))
            // troisième ligne
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }
            else if (getStatutClasseCase(0).equals("O") && getStatutClasseCase(3).equals("O") && getStatutClasseCase(6).equals("O"))
            // première colonne
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }
            else if (getStatutClasseCase(1).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(7).equals("O"))
            // deuxième colonne
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }
            else if (getStatutClasseCase(2).equals("O") && getStatutClasseCase(5).equals("O") && getStatutClasseCase(8).equals("O"))
            // troisième colonne
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }
            else if (getStatutClasseCase(0).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(8).equals("O"))
            // première diagonale
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }
            else if (getStatutClasseCase(2).equals("O") && getStatutClasseCase(4).equals("O") && getStatutClasseCase(6).equals("O"))
            // deuxième diagonale
            {
                afficheGagnant(true);
                inter.setComptVict(1);
                break;
            }    

            if (getStatutClasseCase(0).equals("X") && getStatutClasseCase(1).equals("X") && getStatutClasseCase(2).equals("X"))
            // première ligne
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
            else if (getStatutClasseCase(3).equals("X") && getStatutClasseCase(4).equals("X") && getStatutClasseCase(5).equals("X"))
            // deuxième ligne
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
            else if (getStatutClasseCase(6).equals("X") && getStatutClasseCase(7).equals("X") && getStatutClasseCase(8).equals("X"))
            // troisième ligne
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
            else if (getStatutClasseCase(0).equals("X") && getStatutClasseCase(3).equals("X") && getStatutClasseCase(6).equals("X"))
            // première colonne
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
            else if (getStatutClasseCase(1).equals("X") && getStatutClasseCase(4).equals("X") && getStatutClasseCase(7).equals("X"))
            // deuxième colonne
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
            else if (getStatutClasseCase(2).equals("X") && getStatutClasseCase(5).equals("X") && getStatutClasseCase(8).equals("X"))
            // troisième colonne
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
            else if (getStatutClasseCase(0).equals("X") && getStatutClasseCase(4).equals("X") && getStatutClasseCase(8).equals("X"))
            // première diagonale
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
            else if (getStatutClasseCase(2).equals("X") && getStatutClasseCase(4).equals("X") && getStatutClasseCase(6).equals("X"))
            // deuxième diagonale
            {
                afficheGagnant(false);
                inter.setComptVict(2);
                break;
            }
        }
    } 

    /**
     * Méthode deplaceCurseur qui permet de déplacer le curseur a l'aide 
     * d'un KeyListener.
     */

    public void deplaceCurseur() {

        inter.canv.frame.addKeyListener(new KeyListener()
            {

                @Override
                public void keyPressed(KeyEvent e) {

                    /**
                     * VK_RIGHT est l'evemenement de la touche droite du clavier
                     * on se deplace donc en x de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT && inter.xPosCurs<205)
                    {
                        inter.canv.eraseRect(inter.xPosCurs, inter.yPosCurs, 193, 160);
                        inter.xPosCurs+=201;

                        j++;
                        inter.xPosCroix1 += 201;
                        inter.xPosCroix2 += 201;
                        inter.xPosCercle += 201; 
                        inter.initialiseJeu(inter.xPosCurs, inter.yPosCurs);
                    }

                    /**
                     * VK_LEFT est l'evemenement de la touche gauche du clavier
                     * on se deplace donc en x de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_LEFT && inter.xPosCurs>200)
                    {
                        inter.canv.eraseRect(inter.xPosCurs, inter.yPosCurs, 193, 160);

                        inter.xPosCurs-=201;
                        j--;

                        inter.xPosCroix1 -= 201;
                        inter.xPosCroix2 -= 201;
                        inter.xPosCercle -= 201;

                        inter.initialiseJeu(inter.xPosCurs, inter.yPosCurs);
                    }

                    /**
                     * VK_UP est l'evemenement de la touche haut du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_UP && inter.yPosCurs>166)
                    {

                        inter.canv.eraseRect(inter.xPosCurs, inter.yPosCurs, 193, 160);
                        inter.yPosCurs -= 168;

                        j-=3;
                        inter.yPosCroix1 -= 168;
                        inter.yPosCercle -= 168; 

                        inter.initialiseJeu(inter.xPosCurs, inter.yPosCurs);

                    }

                    /**
                     * VK_DOWN est l'evemenement de la touche bas du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_DOWN && inter.yPosCurs<203)
                    {

                        inter.canv.eraseRect(inter.xPosCurs, inter.yPosCurs, 193, 160);
                        inter.yPosCurs += 168;
                        j+=3;
                        inter.yPosCroix1 += 168;
                        inter.yPosCercle += 168;
                        inter.initialiseJeu(inter.xPosCurs, inter.yPosCurs);
                    }

                    /**
                     * Si on appuie sur entrée et que c'est le tour du joueur 1 (red)
                     * alors on dessine un cercle
                     */
                    if(e.getKeyCode() == KeyEvent.VK_ENTER && inter.getRed() && 
                    getStatutClasseCase(j)=="libre")
                    {
                        inter.ajoutCercle(inter.xPosCercle, inter.yPosCercle);
                        setStatutJoueur1(j);
                        //On passe son tour
                        inter.setInverseRed();
                        inter.partie.incNombreCaseJouees();
<<<<<<< HEAD

=======
                     
>>>>>>> FETCH_HEAD
                    }
                    /**
                     * Si on appuie sur entrée et que c'est le tour du joueur 2 (!red)
                     * alors on dessine une croix
                     */
                    else if(e.getKeyCode() == KeyEvent.VK_ENTER && !inter.getRed() && 
                    getStatutClasseCase(j)=="libre")
                    {
                        inter.ajoutCroix(inter.xPosCroix1, inter.yPosCroix1, inter.xPosCroix2, inter.yPosCroix1);
                        setStatutJoueur2(j);
                        //On passe son tour
                        inter.setInverseRed();
                        inter.partie.incNombreCaseJouees();
<<<<<<< HEAD

=======
                        
>>>>>>> FETCH_HEAD
                    }
                }

                @Override
                public void keyReleased(KeyEvent arg0) {

                }

                @Override
                public void keyTyped(KeyEvent e) {

                }

            }
        );

        int xPos = 2;
        int yPos = 2;
        inter.canv.setForegroundColor(Color.red);
        //canv.Rectangle(xPos, yPos, 194, 161);
        inter.canv.rectangle(xPos, yPos, 194, 161);

    }

    public void afficheGagnant(boolean joueur1)
    {
        if(joueur1){
<<<<<<< HEAD
            JOptionPane.showMessageDialog(null,
            "C'est "+inter.partie.getNomJoueur1()+" qui a gagné !"
            , "Victoire !", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(!joueur1)
        {
            JOptionPane.showMessageDialog(null,
            "C'est "+inter.partie.getNomJoueur2()+" qui a gagné !"
            , "Victoire !", JOptionPane.INFORMATION_MESSAGE);
=======
            inter.canv.setForegroundColor(Color.red);
            inter.canv.setFont(new Font("palatino", Font.BOLD, 50));
            inter.canv.drawString(inter.partie.getNomJoueur1()+message1, 60, 60);
        }
        else if(!joueur1)
        {
            inter.canv.setForegroundColor(Color.blue);
            inter.canv.setFont(new Font("palatino", Font.BOLD, 50));
            inter.canv.drawString(inter.partie.getNomJoueur2()+message1, 60, 60); 
>>>>>>> FETCH_HEAD
        }
        recommenceJeu();
    }    

}
