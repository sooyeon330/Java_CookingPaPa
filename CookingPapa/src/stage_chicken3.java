
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class stage_chicken3 extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/table.png");
	ImageIcon[] sauce = {new ImageIcon("pic/sauce1.png"),new ImageIcon("pic/sauce2.png"), new ImageIcon("pic/sauce3.png"),
							new ImageIcon("pic/sauce4.png"),new ImageIcon("pic/sauce5.png"), new ImageIcon("pic/sauce6.png")};
	ImageIcon ketchup = new ImageIcon("pic/ketchup.png");
	ImageIcon kochujang = new ImageIcon("pic/kochujang.png");
	ImageIcon water = new ImageIcon("pic/water.png");
	ImageIcon soy_sauce = new ImageIcon("pic/soy_sauce.png");
	 
	JPanel panel;
	
	int count = 0;
	static int count2 = 0;
	boolean clear = false;
	int startX, startY, endX, endY;
	
	stage_chicken3(JFrame frame){
		setLayout(null);
		
		panel = this;
		
		Time_Limit tm = new Time_Limit(30, panel, frame);
		tm.start();
		
		new pause(panel,tm);
		
		JLabel ingre_sauce = new JLabel(sauce[0]);
		ingre_sauce.setSize(615, 475);
		ingre_sauce.setBounds(210, 210, ingre_sauce.getWidth(), ingre_sauce.getHeight());

		JLabel ingre_ketchup = new JLabel(ketchup);
		ingre_ketchup.setSize(191, 146);
		ingre_ketchup.setBounds(90, 80, ingre_ketchup.getWidth(), ingre_ketchup.getHeight());
		
		JLabel ingre_kochujang = new JLabel(kochujang);
		ingre_kochujang.setSize(191, 146);
		ingre_kochujang.setBounds(310, 40, ingre_kochujang.getWidth(), ingre_kochujang.getHeight());
		
		JLabel ingre_water = new JLabel(water);
		ingre_water.setSize(191, 146);
		ingre_water.setBounds(520, 40, ingre_water.getWidth(), ingre_water.getHeight());
		
		JLabel ingre_soysauce = new JLabel(soy_sauce);
		ingre_soysauce.setSize(191, 146);
		ingre_soysauce.setBounds(750, 80, ingre_soysauce.getWidth(), ingre_soysauce.getHeight());
		
		add(ingre_water); add(ingre_ketchup); add(ingre_soysauce); add(ingre_kochujang); add(ingre_sauce);
		
		ingre_water.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/water.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -294 && e.getX() <= 313 && e.getY() >= 188 && e.getY() <= 650 && pause.work) {
					menu.stage3_score += 3;
					count++;
					ingre_sauce.setIcon(sauce[1]);	
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_water.setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_soysauce.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/soy_sauce.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -523 && e.getX() <= 84 && e.getY() >= 148 && e.getY() <= 611 && count == 1 && pause.work) {
					menu.stage3_score += 3;
					count++;
					ingre_sauce.setIcon(sauce[2]);	
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_soysauce.setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_ketchup.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/ketchup.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 139 && e.getX() <= 744 && e.getY() >= 149 && e.getY() <= 613 && count==2 && pause.work) {
						menu.stage3_score += 3;	
						count++;
						ingre_sauce.setIcon(sauce[3]);	
						setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						ingre_ketchup.setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_kochujang.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/kochujang.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -80 && e.getX() <= 521 && e.getY() >= 190 && e.getY() <= 656 && count==3 && pause.work) {
					menu.stage3_score += 3;
					ingre_sauce.setIcon(sauce[4]);	
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_kochujang.setVisible(false);
					clear = true;
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		
		Brush b = new Brush();
			
		ingre_sauce.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				repaint();
				revalidate();
			}
				
			@Override
			public void mouseDragged(MouseEvent e) {
				if(clear && pause.work) {
				b.xx = e.getX();
				b.yy = e.getY();
				b.printAll(ingre_sauce.getGraphics());
				}
			}
		});
	
			
		ingre_sauce.addMouseListener(new MouseAdapter() {
				
			@Override
			public void mouseReleased(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();
				System.out.println(e.getY());
				if(pause.work) {
					if(endX + startX >= 400 && endY + startY >= 500) count2++;
						
					if(count2 >= 5) {
						ingre_sauce.setIcon(sauce[5]);
					}
				}
			}
				
				@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
		});
		
		
		ingre_sauce.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if(count2 >= 5) {
					setVisible(false);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					count2 = 0;
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