import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pause extends JLabel{
	ImageIcon pBtn = new ImageIcon("pic/pause.png");
	ImageIcon pScreen = new ImageIcon("pic/pause_screen.png");
	
	static boolean work = true;
	
	pause(JPanel panel, Thread t){
		setLayout(null);
		JLabel screen = new JLabel(pScreen);
		screen.setBounds(0, 0, pScreen.getIconWidth(),pScreen.getIconHeight());
		panel.add(screen);
		screen.setVisible(false);
		
		setIcon(pBtn);
		setBounds(933,8,pBtn.getIconWidth(),pBtn.getIconHeight());
		panel.add(this);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(work) {
					t.suspend();
					screen.setVisible(true);
					work = false;
				}
				else {
					t.resume();
					screen.setVisible(false);
					work = true;
				}
			}
		});
	}
	
	pause(JPanel panel, Thread t, Thread t2){
		setLayout(null);
		JLabel screen = new JLabel(pScreen);
		screen.setBounds(0, 0, pScreen.getIconWidth(),pScreen.getIconHeight());
		panel.add(screen);
		screen.setVisible(false);
		
		setIcon(pBtn);
		setBounds(933,8,pBtn.getIconWidth(),pBtn.getIconHeight());
		panel.add(this);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(work) {
					t.suspend();
					t2.suspend();
					screen.setVisible(true);
					work = false;
				}
				else {
					t.resume();
					t2.resume();
					screen.setVisible(false);
					work = true;
				}
			}
		});
	}
}
