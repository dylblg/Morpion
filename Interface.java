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
    private int xPosCurs = 2;
    private int yPosCurs = 2;

    //Les PosCroix sont utilisés pour la position de la croix
    private int xPosCroix1 = 60 ;
    private int yPosCroix1 = 40 ;
    private int xPosCroix2 = 140;

    //Les PosCercle sont utilisés pour la position de la croix
    private int xPosCercle = 40 ;
    private int yPosCercle = 25 ;  

    //Ce booléen sert a changer de couleur le curseur en fonction du joueur
    private boolean red = true;

    //Ce int permettra de recuperer un objet precis de la liste
    private int i=0;

    //On crée l'objet de la classe Partie
    Partie partie = new Partie();

    //On crée l'objet de la classe Jeu
    Jeu jeu = new Jeu();
    /**
     * Constructeur de la classe. Appelle les méthode d'initialisation
     */

    public Interface()
    {
        demandeNom1();
        demandeNom2();
        initialiseJeu(2, 2, true);   
        deplaceCurseur(); 
    }

    /**
     * Méthode utilisée pour initialiser le jeu
     */

    public void initialiseJeu(int xPosCurs, int yPosCurs, boolean red)
    {
        dessineFond();
        ecrisNomJoueur();
        curseur(xPosCurs, yPosCurs, red);       
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

    /**
     * Ecris le nom des joueurs en bas du jeu.
     */
    public void ecrisNomJoueur(){
        canv.setForegroundColor(Color.red);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur1()+" : ", 10, 540);

        canv.setForegroundColor(Color.blue);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur2()+" : ", 300, 540);
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
                        canv.erase();
                        i++;
                        xPosCroix1 += 201;
                        xPosCroix2 += 201;
                        xPosCercle += 201;
                        initialiseJeu(xPosCurs, yPosCurs, red);
                    }

                    /**
                     * VK_LEFT est l'evemenement de la touche gauche du clavier
                     * on se deplace donc en x de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_LEFT && xPosCurs>200)
                    {
                        xPosCurs-=201;
                        canv.erase();
                        i--;
                        xPosCroix1 -= 201;
                        xPosCroix2 -= 201;
                        xPosCercle -= 201;
                        initialiseJeu(xPosCurs, yPosCurs, red);
                    }

                    /**
                     * VK_UP est l'evemenement de la touche haut du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_UP && yPosCurs>166)
                    {
                        yPosCurs -= 168;
                        canv.erase();
                        i -= 3;
                        yPosCroix1 -= 168;
                        yPosCercle -= 168;
                        initialiseJeu(xPosCurs, yPosCurs, red);
                    }

                    /**
                     * VK_DOWN est l'evemenement de la touche bas du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_DOWN && yPosCurs<203)
                    {
                        yPosCurs += 168;
                        canv.erase();
                        i += 3;
                        yPosCroix1 += 168;
                        yPosCercle += 168;
                        initialiseJeu(xPosCurs, yPosCurs, red);
                    }
                    
                    /**
                     * Si on appuie sur entrée et que c'est le tour du joueur 1 (red)
                     * alors on dessine un cercle
                     */
                    if(e.getKeyCode() == KeyEvent.VK_ENTER && red)
                    {
                        ajoutCercle(xPosCercle, yPosCercle);
                        initialiseJeu(xPosCurs, yPosCurs, red);
                        //On passe son tour
                        red = !red;
                    }
                    /**
                     * Si on appuie sur entrée et que c'est le tour du joueur 2 (!red)
                     * alors on dessine une croix
                     */
                    else if(e.getKeyCode() == KeyEvent.VK_ENTER && !red)
                    {
                        ajoutCroix(xPosCroix1, yPosCroix1, xPosCroix2, yPosCroix1);
                        initialiseJeu(xPosCurs, yPosCurs, red);
                        //On passe son tour
                        red = !red;  
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
        canv.drawThickLine(xPos1, yPos1, xPos1+80, yPos2+80, 10);
        canv.drawThickLine(xPos2, yPos1, xPos2-80, yPos2+80, 10);
    }

    /**
     * Méthode utilisée pour dessiner le cercle du joueur 1
     */

    public void ajoutCercle(int xPos, int yPos)
    {            
        canv.setForegroundColor(Color.red);
        canv.circle(xPos,yPos,110,20);
        //110 est le diametre et 20 l'"epaisseur" du trait
    }

    /**
     * On utilise les JPanel pour demander le nom des joueurs avant de commencer 
     * la partie.
     */

    public void demandeNom1()
    {
        String joueur1 = JOptionPane.showInputDialog("Entrez le nom du joueur 1");
        partie.setNomJoueur1(joueur1);
    }

    public void demandeNom2()
    {
        String joueur2 = JOptionPane.showInputDialog("Entrez le nom du joueur 2");
        partie.setNomJoueur2(joueur2);
    }

}

