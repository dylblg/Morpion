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
    String name = "canvas"; 

    //On crée le Canvas pour s'en servir dans toute la classe
    Canvas canv = new Canvas(name, 600, 560, Color.white);

    //Les PosCurs sont utilisés pour la position du curseur, dans toute la classe
    int xPosCurs = 2;
    int yPosCurs = 2;

    //Les PosCroix sont utilisés pour la position de la croix
    int xPosCroix1 = 60 ;
    int yPosCroix1 = 40 ;
    int xPosCroix2 = 140;
    int yPosCroix2 = 40; 

    //Les PosCercle sont utilisés pour la position de la croix
    int xPosCercle = 40 ;
    int yPosCercle = 25 ;  

    //Ce booléen sert a changer de couleur le curseur en fonction du joueur
    private boolean red = true;

    //On crée l'objet de la classe Partie
    Partie partie = new Partie();

    /**
     * Constructeur de la classe. Appelle les méthode d'initialisation
     */

    public Interface()
    {
        initialiseJeu();
    }

    /**
     * Méthode utilisée pour initialiser le jeu
     */

    public void initialiseJeu()
    {
        canv.setVisible(true);
        canv.setForegroundColor(Color.black);
        canv.drawLine(199,0,199,500); //x1, y1, x2, y2
        canv.drawLine(400,0,400,500);
        canv.drawLine(0,166,600,166);
        canv.drawLine(0,334,600,334);
        canv.drawLine(0,500,600,500);
        
        curseur(xPosCurs, yPosCurs, red);
        
        ajoutCercle(xPosCercle, yPosCercle);
        ajoutCroix(xPosCroix1+200, yPosCroix1, xPosCroix2+200, yPosCroix2);
        
        canv.setForegroundColor(Color.red);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur1(), 10, 540);

        canv.setForegroundColor(Color.blue);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur2(), 300, 540);
    }

    /**
     * Méthode utilisée pour la fin d'une partie, pour effacer tout le canvas
     */

    public void reinitialiseJeu(){
        canv.setVisible(true);
        canv.erase();
        canv.setForegroundColor(Color.black);
        canv.drawLine(198,0,198,500); //x1, y1, x2, y2
        canv.drawLine(400,0,400,500);
        canv.drawLine(0,166,600,166);
        canv.drawLine(0,334,600,334);	
        canv.drawLine(0,500,600,500);

        canv.setForegroundColor(Color.red);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur1(), 10, 540);

        canv.setForegroundColor(Color.blue);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur2(), 300, 540);
    }

    /**
     * Méthode deplaceCurseur qui permet de déplacer le curseur a l'aide 
     * d'un KeyListener.
     */

    public void deplaceCurseur() {
        canv.frame.addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                    
                    /**
                     * VK_RIGHT est l'evemenement de la touche droite du clavier
                     * on se deplace donc en x de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT && xPosCurs<205)
                    {
                        xPosCurs+=201;
                        curseur(xPosCurs,yPosCurs,red);
                        canv.erase();
                        initialiseJeu();
                    }
                    
                    /**
                     * VK_LEFT est l'evemenement de la touche gauche du clavier
                     * on se deplace donc en x de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_LEFT && xPosCurs>200)
                    {
                        xPosCurs-=201;
                        curseur(xPosCurs,yPosCurs, red);
                        canv.erase();
                        initialiseJeu();
                    }
                    
                    /**
                     * VK_UP est l'evemenement de la touche haut du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_UP && yPosCurs>166)
                    {
                        yPosCurs-=168;
                        curseur(xPosCurs,yPosCurs, red);
                        canv.erase();
                        initialiseJeu(); 
                    }
                    
                    /**
                     * VK_DOWN est l'evemenement de la touche bas du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_DOWN && yPosCurs<203)
                    {
                        yPosCurs+=168;
                        curseur(xPosCurs,yPosCurs, red);
                        canv.erase();
                        initialiseJeu(); 
                    }
                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void keyTyped(KeyEvent e) {

                }

            });

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
}

