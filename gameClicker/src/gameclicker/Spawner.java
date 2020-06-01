/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclicker;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author sKm
 */
public class Spawner {

    public int timer = 0;
    public List<createRectangleObj> rectangles = new ArrayList<createRectangleObj>();

    public void update() {
        timer++;
        if (timer % 60 == 0) {
            rectangles.add(new createRectangleObj(0, new Random().nextInt(480 - 40), 40, 40));
        }

        for (int i = 0; i < rectangles.size(); i++) {

            createRectangleObj current = rectangles.get(i);

            rectangles.get(i).update();

            if (current.x > game.WIDTH) {
                rectangles.remove(current);
                game.contador--;
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < rectangles.size(); i++) {
            createRectangleObj current = rectangles.get(i);
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(Math.toRadians(current.rotation),current.x+current.width/2, current.y+current.height/2);
            g2.setColor(current.color);
            g2.fillRect(current.x, current.y, current.width, current.height);
            g2.rotate(Math.toRadians(-current.rotation),current.x+current.width/2, current.y+current.height/2);
            
        }
    }
}
