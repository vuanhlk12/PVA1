/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author vuanhlk12
 */
public class LifePlus extends GameObject{

    public LifePlus(int x, int y, Handler handler, ID id) {
        super(x, y, handler, id);
    }
    public synchronized void tick() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);
            if (temp.id == ID.Player) {
                if (this.getRec(0, 0).intersects(temp.getRec(0, 0))) {
                    ((Player) temp).hp += 1;
                    System.out.println("Life remaining: " + ((Player) temp).hp);
                    this.removeits();
                }
            }
        }
    }

    public synchronized void render(Graphics g) {
        if (this.id == ID.LifePlus) {
            Image img = null;
            img = new ImageIcon("img\\lifeplus.png").getImage();
            g.drawImage(img, x, y, 40, 40, null);

        }
    }
}
