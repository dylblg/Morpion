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
    int xPosCurs = 2;
    int yPosCurs = 2;

    //Les PosCroix sont utilisés pour la position de la croix
    int xPosCroix1 = 60 ;
    int yPosCroix1 = 40 ;
    int xPosCroix2 = 140;
    int yPosCroix2 = 40; 

    //Les PosCercle sont utilisés pour la position du cercle
    int xPosCercle = 40 ;
    int yPosCercle = 25 ;  

    //Ce booléen sert a changer de couleur le curseur en fonction du joueur
    private boolean red = true;

    //On crée l'objet de la classe Partie
    Partie partie = new Partie();

    private int i=0;

    Jeu jeu = new Jeu();

    /**
     * Constructeur de la classe. Appelle les méthode d'initialisation
     */

    public Interface()
    {
        /**
         * On utilise les JPanel pour demander le nom des joueurs avant de commencer 
         * la partie.
         */
        String joueur1 = JOptionPane.showInputDialog("Entrez le nom du joueur 1");
        partie.setNomJoueur1(joueur1);

        String joueur2 = JOptionPane.showInputDialog("Entrez le nom du joueur 2");
        partie.setNomJoueur2(joueur2);

        canv.setVisible(true);

        dessineJoueur1();
        dessineJoueur2();
        dessineFond();
        initialiseJeu(xPosCurs, yPosCurs);
        deplaceCurseur();
        jeu.gagnant();
    }

    /**
     * Méthode utilisée pour la fin d'une partie, pour effacer tout le canvas
     */

    public void reinitialiseJeu(){
        canv.setVisible(true);
        canv.erase();
        dessineJoueur1();
        dessineJoueur2();
        dessineFond();
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
     * Méthode deplaceCurseur qui permet de déplacer le curseur a l'aide 
     * d'un KeyListener.
     */

    public void deplaceCurseur() {
        canv.frame.addKeyListener(new KeyListener()
            {

                @Override
                public void keyPressed(KeyEvent e) {

                    /**
                     * VK_RIGHT est l'evemenement de la touche droite du clavier
                     * on se deplace donc en x de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT && xPosCurs<205)
                    {
                        canv.eraseRect(xPosCurs, yPosCurs, 193, 160);
                        xPosCurs+=201;
                        i++;
                        xPosCroix1 += 201;
                        xPosCroix2 += 201;
                        xPosCercle += 201; 
                        initialiseJeu(xPosCurs, yPosCurs);
                    }

                    /**
                     * VK_LEFT est l'evemenement de la touche gauche du clavier
                     * on se deplace donc en x de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_LEFT && xPosCurs>200)
                    {
                        canv.eraseRect(xPosCurs, yPosCurs, 193, 160);

                        xPosCurs-=201;

                        i--;
                        xPosCroix1 -= 201;
                        xPosCroix2 -= 201;
                        xPosCercle -= 201;

                        initialiseJeu(xPosCurs, yPosCurs);
                    }

                    /**
                     * VK_UP est l'evemenement de la touche haut du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_UP && yPosCurs>166)
                    {

                        canv.eraseRect(xPosCurs, yPosCurs, 193, 160);
                        yPosCurs -= 168;
                        i -= 3;
                        yPosCroix1 -= 168;
                        yPosCercle -= 168; 

                        initialiseJeu(xPosCurs, yPosCurs);

                    }

                    /**
                     * VK_DOWN est l'evemenement de la touche bas du clavier
                     * on se deplace donc en y de la taille de la case
                     */
                    if(e.getKeyCode() == KeyEvent.VK_DOWN && yPosCurs<203)
                    {

                        canv.eraseRect(xPosCurs, yPosCurs, 193, 160);
                        yPosCurs += 168;
                        i += 3;
                        yPosCroix1 += 168;
                        yPosCercle += 168;
                        initialiseJeu(xPosCurs, yPosCurs);
                    }

                    /**
                     * Si on appuie sur entrée et que c'est le tour du joueur 1 (red)
                     * alors on dessine un cercle
                     */
                    if(e.getKeyCode() == KeyEvent.VK_ENTER && red && 
                    jeu.getStatutClasseCase(i)=="libre")
                    {
                        ajoutCercle(xPosCercle, yPosCercle);
                        jeu.setStatutJoueur1(i);
                        //On passe son tour
                        red = !red;
                        partie.incNombreCaseJouees();
                    }
                    /**
                     * Si on appuie sur entrée et que c'est le tour du joueur 2 (!red)
                     * alors on dessine une croix
                     */
                    else if(e.getKeyCode() == KeyEvent.VK_ENTER && !red && 
                    jeu.getStatutClasseCase(i)=="libre")
                    {
                        ajoutCroix(xPosCroix1, yPosCroix1, xPosCroix2, yPosCroix1);
                        jeu.setStatutJoueur2(i);
                        //On passe son tour
                        red = !red;
                        partie.incNombreCaseJouees();
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
        canv.setForegroundColor(Color.red);
        //canv.Rectangle(xPos, yPos, 194, 161);
        canv.rectangle(xPos, yPos, 194, 161);

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
        canv.drawString(partie.getNomJoueur1()+" : ", 10, 540);
    }

    public void dessineJoueur2(){

        canv.setForegroundColor(Color.blue);

        canv.setFont(new Font("palatino", Font.BOLD, 32));
        canv.drawString(partie.getNomJoueur2()+" : ", 300, 540);
    }

    public void deplacement()
    {
        //graphic.setLocation(201, 0);
    }
}

