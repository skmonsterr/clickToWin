/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclicker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author sKm
 */
public class game extends Canvas implements Runnable, MouseListener {
    
    
    public static final int WIDTH = 640, HEIGHT = 480;
    
    public static int contador = 100;
    
    public static int score = 0;
    
    public Spawner spawner;
    
    
    public game () {
        Dimension dimension = new Dimension(640,480);
        this.setPreferredSize(dimension);
        this.addMouseListener(this);
        
        spawner = new Spawner();
    }
    
    
    public void update() {
       spawner.update();
      if(contador <= 0 ){
          //Game Over --- 
          contador = 100;
      }
        
    }
    
    public void render () {
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
//        g.setColor(Color.white);
//        
//        g.setFont(new Font ("Arial", Font.BOLD,23));
//        
//        g.drawString("Pontos : " + contador, WIDTH/2 - 60, 20);


        g.setColor(Color.green);
        g.fillRect(game.WIDTH/2 - 100 - 60, 20, contador*3, 20);
         g.setColor(Color.white);
        g.drawRect(game.WIDTH/2 - 100 - 60, 20, 300, 20);
        
        
        spawner.render(g);
        bs.show();
        
        
    }
    
    public static void main (String[] args){
        game Game = new game();
        JFrame jframe = new JFrame("Game Clicker");
        jframe.add(Game);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);
        
        
        new Thread(Game).start();
        
        
    }
    
    @Override
    public void run (){
        
        while(true){
            update();
            render();
           try{
               Thread.sleep(1000/60);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
            
        
    }

  
    @Override
    public void mouseClicked(MouseEvent mclicked) {
        System.out.println("Clicado");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
