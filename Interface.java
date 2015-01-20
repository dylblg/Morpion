import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javafx.scene.shape.Circle;
import java.awt.event.*;

/**
 * La classe Interface gere tout le graphisme du jeu, ainsi que les interactions
 * telles que le déplacement du curseur, etc.
 * 
 * @author Belgy Dylan and Gerosa Arnaud
 * @version (a version number or a date)
 */
public class Interface
{
    //titre de l'objet Canvas
    String name = "MORPION"; 

    //On crée le Canvas pour s'en servir dans toute la classe
    Canvas canv = new Canvas(name, 600, 560, Color.white);

    //Les PosCurs sont utilisés pour la position du curseur, dans toute la classe
    int xPosCurs;
    int yPosCurs;

    //Les PosCroix sont utilisés pour la position de la croix
    int xPosCroix1;
    int yPosCroix1;
    int xPosCroix2;
    int yPosCroix2; 

    //Les PosCercle sont utilisés pour la position du cercle
    int xPosCercle;
    int yPosCercle;  

    //Ce booléen sert a changer de couleur le curseur en fonction du joueur
    private boolean red;

    //On crée l'objet de la classe Partie
    Partie partie = new Partie();

    //Compteurs de victoires:
    private int compteVict1=0;
    private int compteVict2=0;

    /**
     * Constructeur de la classe. Appelle les méthode d'initialisation
     */

    public Interface()
    {
    }

    public void messageAcceuil()
    {
<<<<<<< HEAD
        JOptionPane.showMessageDialog(null,
            "Pour jouer, utiliser les flèches du clavier et la touche entrée."
        , "How To Play", JOptionPane.INFORMATION_MESSAGE);
    }

=======
        canv.setFont(new Font("palatino", Font.BOLD, 55));
        canv.drawString("Jouez avec les flèches", 20 , 60);
        canv.drawString("et entrée", 20 , 120);
        canv.wait(3000);
        canv.erase();
    }
>>>>>>> FETCH_HEAD
    public void initialiseVariable()
    {
        //Les PosCurs sont utilisés pour la position du curseur, dans toute la classe
        xPosCurs = 2;
        yPosCurs = 2;

        //Les PosCroix sont utilisés pour la position de la croix
        xPosCroix1 = 60 ;
        yPosCroix1 = 40 ;
        xPosCroix2 = 140;
        yPosCroix2 = 40; 

        //Les PosCercle sont utilisés pour la position du cercle
        xPosCercle = 40 ;
        yPosCercle = 25 ;  

        red = true;
    }

    /**
     * Méthode utilisée pour la fin d'une partie, pour effacer tout le canvas
     */

    public void reinitialiseJeu(){
        canv.setVisible(true);
        canv.erase();
    }

    /**
     * Dessine les lignes du jeu de morpion
     */
    public void dessineFond()
    {
        canv.setVisible(true);
        canv.setForegroundColor(Color.black);
        canv.drawLine(199,0,199,500); //x1, y1, x2, y2
        canv.drawLine(400,0,400,500);
        canv.drawLine(0,166,600,166);
        canv.drawLine(0,334,600,334);
        canv.drawLine(0,502,600,502);

    }

    public void initialiseJeu(int xPos,int yPos)

    {

        dessineJoueur1();
        dessineJoueur2();
        dessineFond();
        curseur(xPos, yPos, red);

    }

    /**
     * Méthode pour afficher le curseur en fonction de x et y ainsi que du booléen
     * red. S'il est a false, alors le curseur est bleu (joueur 2)
     */

    public void curseur(int xPos, int yPos, boolean red)
    {

        if(red)
        {
            canv.setForegroundColor(Color.red);
        }
        else {
            canv.setForegroundColor(Color.blue);
        }

        canv.Rectangle(xPos, yPos, 193, 160);

    }

    /**
     * Méthode utilisée pour dessiner la croix du joueur 2
     */

    public void ajoutCroix(int xPos1, int yPos1, int xPos2, int yPos2)
    {

        canv.setForegroundColor(Color.blue);
        canv.drawThickLine(xPos1, yPos1, xPos1+80, yPos1+80, 10);
        canv.drawThickLine(xPos2, yPos2, xPos2-80, yPos2+80, 10);
    }

    /**
     * Méthode utilisée pour dessiner le cercle du joueur 1
     */

    public void ajoutCercle(int xPosCercle, int yPosCercle)
    {            
        canv.setForegroundColor(Color.red);
        canv.circle(xPosCercle,yPosCercle,110,20);
        //110 est le diametre et 20 l'"epaisseur" du trait
    }

    public void dessineJoueur1(){
        canv.setForegroundColor(Color.red);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur1()+" : "+compteVict1, 10, 540);
    }

    public void dessineJoueur2(){

        canv.setForegroundColor(Color.blue);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur2()+" : "+compteVict2, 300, 540);
    }

    public void setComptVict(int y)
    {
        if(y==1)
        {
            compteVict1++; 
        }
        else {
            compteVict2++;
        }
    }

    public boolean getRed()
    {
        return red;
    }

    public void setInverseRed()
    {
        red = !red;
    }
}

