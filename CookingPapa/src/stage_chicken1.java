
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class stage_chicken1 extends JPanel{
	int i=0, count = 0;
	int startX, startY, endX, endY;
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard.png");	
	ImageIcon[] chicken = {new ImageIcon("pic/chicken1.png"),new ImageIcon("pic/chicken2.png"),
		new ImageIcon("pic/chicken3.png"),new ImageIcon("pic/chicken4.png")};
	
	JPanel panel;
	
	int score = 0;

	stage_chicken1(JFrame frame){
		setLayout(null);
		panel = this;
		
		Time_Limit tm = new Time_Limit(15, panel, frame);
		tm.start();
		
		new pause(panel,tm);
		
		JLabel ingre_chicken = new JLabel(chicken[i]);
		add(ingre_chicken);
		ingre_chicken.setSize(800, 700);
		ingre_chicken.setBounds(120, -60, ingre_chicken.getWidth(), ingre_chicken.getHeight());
		
		Brush b = new Brush();
		
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				repaint();
				revalidate();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(pause.work) {
				b.xx = e.getX();
				b.yy = e.getY();
				b.printAll(panel.getGraphics());
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();
//				System.out.println(e.getX());
				if(pause.work) {
					if(endY - startY >= 350 && endX - startX <= 50 && startX >= 280 && endX <= 800) {
						i++;
						if(i<=3) ingre_chicken.setIcon(chicken[i]);
					}
					else {
						i = 0;
						ingre_chicken.setIcon(chicken[i]);
					}
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if(i >= 3) {
					i++;
					setVisible(false);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					menu.stage3_score += 5;
					Time_Limit.complete = true;
					frame.add(new exam(frame));
					frame.remove(panel);
					frame.repaint();
					frame.revalidate();
				}
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}

