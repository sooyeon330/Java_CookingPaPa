import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tutorial1 extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard.png");
	ImageIcon ingre_c[] = {new ImageIcon("pic/carret1.png"), new ImageIcon("pic/carret2.png")};
	ImageIcon exam1 = new ImageIcon("pic/exam1.png");
	ImageIcon exam2 = new ImageIcon("pic/exam1-2.png");
	ImageIcon exit = new ImageIcon("pic/go_btn.png");
	ImageIcon enter = new ImageIcon("pic/go_btn_pressed.png");
	
	JPanel panel;
	
	int startX, startY, endX, endY;
	
	tutorial1(JFrame frame){
		setLayout(null);
		
		panel = this;
		
		JLabel ingre = new JLabel(ingre_c[0]);
		JLabel exam = new JLabel(exam1);
		JLabel line = new JLabel(exam2);
		JLabel btn = new JLabel(exit);
		
		ingre.setBounds(5, 80, ingre_c[1].getIconWidth(), ingre_c[1].getIconHeight());
		exam.setBounds(10, 10, exam1.getIconWidth(), exam1.getIconHeight());
		line.setBounds(420, 160, exam2.getIconWidth(), exam2.getIconHeight());
		btn.setBounds(800, 600, exit.getIconWidth(), exit.getIconHeight());
		
		add(line); add(ingre); add(exam);
		
		Brush b = new Brush();
		
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				repaint();
				revalidate();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				b.xx = e.getX();
				b.yy = e.getY();
				b.printAll(panel.getGraphics());
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				endX = e.getX();
				endY = e.getY();
				
				if(endY - startY >= 250 && endX - startX <= 40 && startX >= 380 && endX <= 600 ) {
					ingre.setIcon(ingre_c[1]);
					line.setVisible(false);
					add(btn);
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
		});
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new tutorial2(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setIcon(exit);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setIcon(enter);
			}
		});
		
	}	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
