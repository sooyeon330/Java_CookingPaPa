import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Explane_Event {
	 ImageIcon go_btnimg = new ImageIcon("pic/go_btn.png");
	 ImageIcon go_btnedimg = new ImageIcon("pic/go_btn_pressed.png");
	

	 void gobtn_event(Component lb_img,JButton btn) {
		btn.setBounds(800, 600, go_btnimg.getIconWidth(), go_btnimg.getIconHeight());
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setIcon(go_btnedimg);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setIcon(go_btnimg);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lb_img.setVisible(false);
				btn.setVisible(false);			
			}
		});
	}
	void image_crop(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}
}
