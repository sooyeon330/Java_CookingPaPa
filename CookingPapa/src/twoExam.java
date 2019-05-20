import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class twoExam extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/2pExam.png");
	ImageIcon exit = new ImageIcon("pic/go_btn.png");
	ImageIcon enter = new ImageIcon("pic/go_btn_pressed.png");
	JPanel panel;
	
	twoExam(JFrame frame, JPanel nextP){
		setLayout(null);
		
		panel = this;
		
		JLabel btn = new JLabel(exit);
		btn.setBounds(800, 600, exit.getIconWidth(), exit.getIconHeight());
		add(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setIcon(enter);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setIcon(exit);
			}
			
			public void mouseClicked(MouseEvent e) {
				frame.add(nextP);
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
