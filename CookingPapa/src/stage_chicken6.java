
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class stage_chicken6 extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/table.png");
	ImageIcon chicken[] = {new ImageIcon("pic/shake_chicken1.png"), new ImageIcon("pic/shake_chicken2.png")};
	
	JPanel panel;
	
	int count;
	int startX, endX, startY, endY;
	
	stage_chicken6(JFrame frame){
		setLayout(null);
		
		panel = this;
		
		Time_Limit tm = new Time_Limit(30, panel, frame,2);
		tm.start();
		
		new pause(panel,tm);
		
		JLabel ingre_chicken = new JLabel(chicken[0]);
		
		ingre_chicken.setSize(610, 500);
		ingre_chicken.setBounds(210, 150, ingre_chicken.getWidth(), ingre_chicken.getHeight());
		add(ingre_chicken);
		
		Brush b = new Brush();
		
		ingre_chicken.addMouseMotionListener(new MouseMotionListener() {
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
				b.printAll(ingre_chicken.getGraphics());
				}
			}
		});
	
			
		ingre_chicken.addMouseListener(new MouseListener() {
				
			@Override
			public void mouseReleased(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();
				
				if(pause.work) {
					if(endX + startX >= 400 && endY + startY >= 500) count++;
						
					if(count == 10) {
						ingre_chicken.setIcon(chicken[1]);
						menu.stage3_score += 5;
						Time_Limit.complete = true;
						frame.add(new result(frame,menu.stage3_score));
						frame.remove(panel);
						frame.repaint();
						frame.revalidate(); 
					}
				}
			}
				
				@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
				
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}