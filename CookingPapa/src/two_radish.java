import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class two_radish extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard2.png");
	ImageIcon[] radish = {new ImageIcon("pic/radish1.png"),new ImageIcon("pic/radish2.png"),
			new ImageIcon("pic/radish3.png"),new ImageIcon("pic/radish4.png")};
	int i = 0, j = 0;
	static int count1 = 0;
	static int count2 = 0;
	
	two_radish(JFrame frame){
		setLayout(null);
		
		Time_Limit t= new Time_Limit(16, this, frame, 1);
		t.start();
		
		JLabel radish1 = new JLabel(radish[i]);
		JLabel radish2 = new JLabel(radish[j]);
		
		JLabel one_count = new JLabel(count1 + "개");
		JLabel two_count = new JLabel(count2 + "개");
		
		radish1.setBounds(-50, -100, radish[0].getIconWidth() + 100, radish[0].getIconHeight() + 30);
		radish2.setBounds(-50, 280, radish[0].getIconWidth() + 100, radish[0].getIconHeight() + 30);
		one_count.setBounds(980, 2, 100, 100);
		two_count.setBounds(980, 350, 100, 100);
		
		add(radish1);add(radish2);add(one_count);add(two_count);
		
		frame.requestFocusInWindow();
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					i++;
					if(i == 4) {
						i = 0;count1++;
						one_count.setText(count1 + "개");
					}
					radish1.setIcon(radish[i]);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					j++;
					if(j == 4) {
						j = 0;count2++;
						two_count.setText(count2 + "개");
					}
					radish2.setIcon(radish[j]);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}

}
