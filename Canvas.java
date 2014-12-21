import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Classe Canvas - une classe qui permet un dessin graphique 
 * simple sur un fond.
 * 
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 *
 * @version 2008.03.30
 */

public class Canvas
{
    public JFrame frame;
    public CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;

    /**
     * Cr√©e un Canvas avec une hauteur, une largeur et une couleur par d√©faut de l'arri√®re-plan 
     * (300, 300, blanc).
     * @param title  titre qui doit appara√Ætre dans le cadre Canvas     
     */
    public Canvas(String title)
    {
        this(title, 300, 300, Color.white);        
    }

    /**
     * Cr√©e un Canvas avec une couleur par d√©faut pour l'arri√®re-plan (blanc).
     * @param title  titre qui doit appara√Ætre dans le cadre Canvas
     * @param width  largeur souhait√©e du fond
     * @param height  hauteur souhait√©e pour le fond
     */
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Cr√©e un Canvas.
     * @param title  titre qui doit appara√Ætre dans le cadre Canvas
     * @param width  largeur souhait√©e du fond
     * @param height  hauteur souhait√©e pour le fond
     * @param bgClour  couleur d'arri√®re-plan souhait√©e pour le fond
     */
    public Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();

    }

    /**
     * D√©finit la visibilit√© du fond et am√®ne le fond au premier plan de l'√©cran
     * lorsqu'il est visible. Cette m√©thode peut aussi √™tre utilis√©e pour amener un fond
     * d√©j√† visible √† l'avant des autres fen√™tres.
     * @param visible  valeur bool√©enne repr√©sentant la visibilit√© souhait√©e du
     * fond (true ou false) 
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // premi√®re fois : instancie l'image hors √©cran et la remplit 
            // de la couleur de l'arri√®re-plan
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    /**
     * Fournit des informations sur la visibilit√© du Canvas.
     * @return  true si le fond est visible, false autrement
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    /**
     * Dessine le contour d'une forme donn√©e sur le fond.
     * @param  shape  l'objet forme √† dessiner sur le fond
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }

    /**
     * Remplit les dimensions internes d'une forme donn√©e avec la couleur 
     * donn√©e du premier plan sur le fond.
     * @param  shape  l'objet forme √† remplir 
     */
    public void fill(Shape shape)
    {
        graphic.fill(shape);
        canvas.repaint();
    }

    /**
     * Remplit les dimensions internes du cercle donn√© avec la couleur
     * donn√©e du premier plan du fond.
     */
    public void fillCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        fill(circle);
    }
   
    public void circle(int xPos, int yPos, int diameter, int thickness)
    {
        fillCircle(xPos, yPos, diameter);
        setForegroundColor(Color.white);
        fillCircle(xPos+thickness/2, yPos+thickness/2, diameter-thickness);
    }

    /**
     * Remplit les dimensions internes du rectangle donn√© avec la couleur actuelle
     * du fond. C'est une m√©thode pratique. Un effet similaire 
     * peut √™tre obtenu avec la m√©thode fill.
     */
    public void fillRectangle(int xPos, int yPos, int width, int height)
    {
        fill(new Rectangle(xPos, yPos, width, height));
    }

    /**
     * Méthode qui crée un rectangle non plein
     */
    public void Rectangle(int xPos, int yPos, int width, int height)
    {
        setVisible(true);
        graphic.setStroke(new BasicStroke(5));
        graphic.drawRect(xPos, yPos, width, height);
    }
    
    public void eraseRect(int xPos, int yPos, int width, int height)
    {
        setVisible(true);
        setForegroundColor(Color.white);
        graphic.setStroke(new BasicStroke(5));
        graphic.drawRect(xPos, yPos, width, height);
    }

    /**
     * Efface la totalit√© du fond.
     */
    public void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Efface les dimensions internes du cercle donn√©. Il s'agit d'une
     * m√©thode pratique. Un effet similaire peut √™tre obtenu avec
     * la m√©thode erase.
     */
    public void eraseCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        erase(circle);
    }

    /**
     * Efface les dimensions internes du rectangle donn√©. Il s'agit d'une
     * m√©thode pratique. Un effet similaire peut √™tre obtenu avec
     * la m√©thode erase.
     */
    public void eraseRectangle(int xPos, int yPos, int width, int height)
    {
        erase(new Rectangle(xPos, yPos, width, height));
    }

    /**
    Efface l'int√©rieur d'une forme donn√©e √† l'√©cran.
     * @param  shape  l'objet forme √† effacer
     */
    public void erase(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // efface en remplissant avec la couleur d'arri√®re-plan
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Efface le contour d'une forme donn√©e √† l'√©cran.
     * @param  shape  l'objet forme √† effacer
     */
    public void eraseOutline(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // efface en dessinant la couleur d'arri√®re-plan
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Dessine une image sur le fond.
     * @param  image   l'objet Image √† afficher
     * @param  x       coordonn√©e x pour le placement de l'Image 
     * @param  y       coordonn√©e y pour le placement de l'Image 
     * @return  renvoie une valeur bool√©enne indiquant si l'image a √©t√©  
     *          compl√®tement charg√©e
     */
    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    /**
     * Dessine un String sur le fond.
     * @param  text   le String √† afficher
     * @param  x      coordonn√©e x pour le placement du texte
     * @param  y      coordonn√©e y pour le placement du texte
     */
    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    /**
     * Efface un String du fond.
     * @param  text     le String √† afficher
     * @param  x        coordonn√©e x pour le placement du texte
     * @param  y        coordonn√©e y pour le placement du texte
     */
    public void eraseString(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    /**
     * Dessine un trait sur le fond.
     * @param  x1   coordonn√©e x du d√©but de ligne 
     * @param  y1   coordonn√©e y du d√©but de ligne
     * @param  x2   coordonn√©e x de fin de ligne 
     * @param  y2   coordonn√©e y de fin de ligne
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.setStroke(new BasicStroke(3));
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    public void drawThickLine(int x1, int y1, int x2, int y2, int thickness)
    {
        graphic.setStroke(new BasicStroke(thickness));
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    /**
     * D√©finit la couleur de premier plan du fond.
     * @param  newColor   la nouvelle couleur du premier plan du fond 
     */
    public void setForegroundColor(Color newColor)
    {
        graphic.setColor(newColor);
    }

    /**
     * Renvoie la couleur actuelle du premier plan.
     * @return   la couleur du premier plan du fond 
     */
    public Color getForegroundColor()
    {
        return graphic.getColor();
    }

    /**
     * D√©finit la couleur d'arri√®re-plan du fond.
     * @param  newColor   la nouvelle couleur d'arri√®re-plan du fond
     */
    public void setBackgroundColor(Color newColor)
    {
        backgroundColor = newColor;   
        graphic.setBackground(newColor);
    }

    /**
     * Renvoie la couleur actuelle du fond
     * @return   la couleur d'arri√®re-pland du fond
     */
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    /**
     * change la police actuelle utilis√©e sur le fond
     * @param  newFont   nouvelle police √† utiliser pour la sortie de String 
     */
    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    /**
     * Renvoie la police actuelle du fond.
     * @return     la police actuellement utilis√©e
     **/
    public Font getFont()
    {
        return graphic.getFont();
    }

    /**
     * D√©finit la taille du fond.
     * @param  width    nouvelle largeur
     * @param  height   nouvelle hauteur 
     */
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    /**
     * Renvoie la taille du fond.
     * @return     Les dimensions actuelles du fond
     */
    public Dimension getSize()
    {
        return canvas.getSize();
    }

    /**
     * Attend un nombre sp√©cifi√© de millisecondes avant de se terminer.
     * Ceci fournit une mani√®re simple de sp√©cifier un petit d√©lai qui peut √™tre
     * utilis√© pour produire des animations.
     * @param  milliseconds  le nombre
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignore l'exception pour le moment
        }
    }
    
    public void rectangle(int xPos, int yPos, int width, int height)
    {
        Rectangle rect = new Rectangle(xPos, yPos, width, height);
        graphic.setStroke(new BasicStroke(5)); 
    }

    /************************************************************************
     * Classe CanvasPane imbriqu√©e - le composant r√©el du fond contenu dans 
     * le cadre Canvas. Il s'agit essentiellement d'un JPanel avec une capacit√© accrue 
     * pour actualiser l'image qui y est dessin√©e.
     */
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
