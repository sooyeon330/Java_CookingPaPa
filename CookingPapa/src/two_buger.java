import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class two_buger extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard2.png");
	
	two_buger(JFrame frame) {
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
