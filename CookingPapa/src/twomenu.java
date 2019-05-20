import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class twomenu extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/menu.png");
	ImageIcon ramenimg = new ImageIcon("pic/Ramen.png");
	
	JPanel panel;

	twomenu(JFrame frame){
		setLayout(null);
		panel = this;
		
		add(new back(frame, this, 1)); //뒤로가기버튼
		
		JButton btn_carrot = new JButton(ramenimg);
		JButton btn_radish = new JButton(ramenimg);
//		JButton btn_carrot = new JButton(ramenimg);
		btn_setting(btn_carrot);btn_setting(btn_radish);
		btn_carrot.setBounds(80,250,ramenimg.getIconWidth(),ramenimg.getIconHeight());
		btn_radish.setBounds(420,270,ramenimg.getIconWidth(),ramenimg.getIconHeight());
		add(btn_carrot);add(btn_radish);
		
		btn_carrot.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				frame.add(new twoExam(frame,new two_carrot(frame)));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_carrot.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btn_radish.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				frame.add(new twoExam(frame,new two_radish(frame)));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_carrot.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
	}
	
	void btn_setting(JButton btn) {
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}