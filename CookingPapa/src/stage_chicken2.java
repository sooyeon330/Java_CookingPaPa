
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class stage_chicken2 extends JPanel{
	ImageIcon bgimage= new ImageIcon("pic/table.png");
	ImageIcon chicken[] = {new ImageIcon("pic/contain_chicken1.png"),new ImageIcon("pic/contain_chicken2.png"),
			new ImageIcon("pic/contain_chicken3.png"),new ImageIcon("pic/contain_chicken4.png")};
	ImageIcon salt = new ImageIcon("pic/salt.png");
	ImageIcon pepper = new ImageIcon("pic/pepper.png");
	ImageIcon garlic = new ImageIcon("pic/garlic.png");
	
	JPanel panel; 

	int count = 0;
	
	stage_chicken2(JFrame frame){
		setLayout(null);
		
		panel = this;
		
		Time_Limit tm = new Time_Limit(15, panel, frame);
		tm.start();
		
		new pause(panel,tm);
		
		JLabel ingre_chicken = new JLabel(chicken[0]);
		ingre_chicken.setSize(610, 500);
		ingre_chicken.setBounds(210, 210, ingre_chicken.getWidth(), ingre_chicken.getHeight());
		
		JLabel ingre_salt = new JLabel(salt);
		ingre_salt.setSize(119, 224);
		ingre_salt.setBounds(80, 100, ingre_salt.getWidth(), ingre_salt.getHeight());
		
		JLabel ingre_pepper = new JLabel(pepper);
		ingre_pepper.setSize(119, 224);
		ingre_pepper.setBounds(815, 100, ingre_pepper.getWidth(), ingre_pepper.getHeight());
		
		JLabel ingre_garlic = new JLabel(garlic);
		ingre_garlic.setSize(138, 85);
		ingre_garlic.setBounds(450, 60, ingre_garlic.getWidth(), ingre_garlic.getHeight());
		
		add(ingre_salt);
		add(ingre_pepper);
		add(ingre_garlic);
		add(ingre_chicken);
		
		ingre_garlic.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/garlic.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -215 && e.getX() <= 385 && e.getY() >= 184 && e.getY() <= 645 && pause.work) {
					menu.stage3_score += 2;
					count++;
					ingre_chicken.setIcon(chicken[1]);	
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_garlic.setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_salt.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/salt.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= 156 && e.getX() <= 757 && e.getY() >= 141 && e.getY() <= 608 && count==1 && pause.work) {
					menu.stage3_score += 2;
					ingre_chicken.setIcon(chicken[2]);	
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_salt.setVisible(false);
					count++;
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		ingre_pepper.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(pause.work) {
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("pic/pepper.png").getImage(), new Point(31,31),"custom cursor"));
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.getX() >= -583 && e.getX() <= 14 && e.getY() >= 139 && e.getY() <= 605 && count == 2 && pause.work) {
					menu.stage3_score += 2;
					count++;
					ingre_chicken.setIcon(chicken[3]);	
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					ingre_pepper.setVisible(false);
				}else
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); 
			}
		});
		
		
		
		panel.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if(count == 3) {
					panel.setVisible(false);
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
