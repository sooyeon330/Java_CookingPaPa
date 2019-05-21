import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class two_buger extends JPanel{	
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard2.png");
	ImageIcon keyimg[] = { new ImageIcon("pic/key1.png"),
							new ImageIcon("pic/key2.png"),
							new ImageIcon("pic/key3.png"),
							new ImageIcon("pic/key4.png")};
	
	public static final int x = 100; //방향키 기본 x좌표
	public static final int y = 100; //방향키 기본 y좌표
	
	two_buger(JFrame frame) {
		setLayout(null);
		
		
		
		JLabel keylb[] = {new JLabel(ImageResize(100, 100, keyimg[0])),
							new JLabel(ImageResize(100, 100, keyimg[1])),
							new JLabel(ImageResize(100, 100, keyimg[2])),
							new JLabel(ImageResize(100, 100, keyimg[3]))};
		
		keylb[0].setBounds(x, 100, 100, 100);
		keylb[1].setBounds(x*2+20, 100, 100, 100);
		keylb[2].setBounds(x*3+40, 100, 100, 100);
		keylb[3].setBounds(x*4+60, 100, 100, 100);
		
		add(keylb[0]);add(keylb[1]);add(keylb[2]);add(keylb[3]);
		
	}
	protected ImageIcon ImageResize(int width, int height,ImageIcon img) {
		Image before = img.getImage();
		Image after = before.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon afterIcon = new ImageIcon(after);
		return afterIcon;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
