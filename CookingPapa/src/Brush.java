import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class Brush extends JLabel{
	public int xx, yy;
	public Color col = new Color(255,0,0);
	
	public void paint(Graphics g) {
		g.setColor(col);
		g.fillOval(xx-10, yy-10, 20, 20);
	}
}
