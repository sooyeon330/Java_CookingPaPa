
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class stage_chicken5 extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/fry.png");
	ImageIcon rawChicken = new ImageIcon("pic/raw_chicken.png");
	ImageIcon fryChicken = new ImageIcon("pic/fry_chicken.png");
	ImageIcon failChicken = new ImageIcon("pic/fry_chicken_fail.png");
	ImageIcon change[] = {new ImageIcon("pic/range_gas.png"), new ImageIcon("pic/range_gas2.png")};
	
	JPanel panel;
	
	int i, x, y;
	int xx, yy;
	static int count = 0;
	int count2 = 0;
	boolean on = false; 
	static boolean yes = false;
	
	
	stage_chicken5(JFrame frame){
		count2 = 0;
		setLayout(null);
		
		panel = this;
		
		Time_Limit tm = new Time_Limit(40, panel, frame);
		tm.start();
		
		Timing t = new Timing(panel, frame);
		new pause(panel, t, tm);
		
		
		JLabel[] ingre_raw = new JLabel[6];
		JLabel[] ingre_fry = new JLabel[6];
		JLabel button = new JLabel(change[0]);
		
		for(i=0; i<6; i++) {
			ingre_raw[i] = new JLabel(rawChicken);
			ingre_fry[i] = new JLabel(failChicken);
		}
		
		for(i=1; i<=6; i++) {
			ingre_raw[i-1].setBounds(150+x,300+y,126,105);
			add(ingre_raw[i-1]);
			if(i % 2 == 0) y += 80;
			if(i % 2 == 0) x = 0;
			else x = 120;
		}
		
		for(i=1; i<=6; i++) {
			ingre_fry[i-1].setBounds(130+xx,290+yy,160,115);
			panel.add(ingre_fry[i-1]);
			if(i % 2 == 0) yy += 80;
			if(i % 2 == 0) xx = 0;
			else xx = 120;
			ingre_fry[i-1].setVisible(false);
		}
		
		button.setBounds(600, 620, 93, 93);
		add(button);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pause.work) {
					on = !on;
					if(on) i = 1; else i = 0;
					button.setIcon(change[i]);
				}
			}
		});
		
		ingre_raw[0].addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/raw_chicken.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 359 && e.getX() <= 819 && e.getY() >= -201 && e.getY() <= 25 && on && pause.work) {
					menu.stage3_score += 3;
					count++;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_raw[0].setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_raw[1].addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/raw_chicken.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 248 && e.getX() <= 693 && e.getY() >= -201 && e.getY() <= 25 && on && pause.work) {
					menu.stage3_score += 3;
					count++;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_raw[1].setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_raw[2].addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/raw_chicken.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 369 && e.getX() <= 812 && e.getY() >= -286 && e.getY() <= -57 && on && pause.work) {
					menu.stage3_score += 3;
					count++;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_raw[2].setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_raw[3].addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/raw_chicken.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 245 && e.getX() <= 697 && e.getY() >= -279 && e.getY() <= -61 && on && pause.work) {
					menu.stage3_score += 3;
					count++;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_raw[3].setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_raw[4].addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/raw_chicken.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 367 && e.getX() <= 816 && e.getY() >= -362 && e.getY() <= -140 && on && pause.work) {
					menu.stage3_score += 3;
					count++;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_raw[4].setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_raw[5].addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/raw_chicken.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 245 && e.getX() <= 695 && e.getY() >= -362 && e.getY() <= -140 && on && pause.work) {
					menu.stage3_score += 3;
					count++;
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_raw[5].setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if(count == 6) {
					t.start();
					count++;
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		frame.requestFocusInWindow();
		frame.addKeyListener(new KeyListener() {
				
			@Override
			public void keyTyped(KeyEvent e) {}
				
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
				
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE && count2 < 6 && count == 7) {
					ingre_fry[count2].setVisible(true);
					if(Timing.x >=460 && Timing.x <=500) {
						menu.stage3_score += 4;
						ingre_fry[count2].setIcon(fryChicken);
					}
					count2++;
				}
				if(count2 == 6) {
					frame.removeKeyListener(this);
					Timing.stopFlag = true;
					Time_Limit.complete = true;
					count = 0;
					frame.add(new exam(frame));
					frame.remove(panel);
					frame.repaint();
					frame.revalidate();
				}
			}
		});
}
		
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
