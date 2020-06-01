/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclicker;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author sKm
 */

//Construtor Inimigos / retângulos 


public class createRectangleObj extends Rectangle{
    
    
    public Color color;
    
    public int speed = 0;
    
    public int rotation = 0;
    
    public createRectangleObj(int x, int y, int width, int height){
        super(x,y,width,height);
        
        color = new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255));
        
        speed = new Random().nextInt(16-4)+2;
        
    }
    
    public void update(){
        
        x+=speed;
        
        rotation ++;
        if(rotation >= 360){
            rotation = 0;
        }
    }
    
}
