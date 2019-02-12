/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author ratman305
 */
public class TableroJuego extends JPanel
{
    Pelota pelota = new Pelota(0, 0);
    Raqueta rq1 = new Raqueta(10, 200);
    Raqueta rq2 = new Raqueta(800 - 10 - Raqueta.ANCHO, 200);
    
    public TableroJuego()
    {
        setBackground(Color.BLACK);        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        dibujar(g2);
        actualizar();
    }
    
    public void dibujar(Graphics2D g)
    {
        g.fill(pelota.getPelota());
        g.fill(rq1.getRaqueta());
        g.fill(rq2.getRaqueta());
       
    }
    
    public void actualizar()
    {
        pelota.mover(getBounds());
        rq1.moverR1(getBounds());
        rq2.moverR2(getBounds());
    }
    
    public void iterarJuego()
    {
     while(true)
     {
         repaint();
         try 
         {
             Thread.sleep(6);
         } catch (InterruptedException ex) {
             Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    }
}
