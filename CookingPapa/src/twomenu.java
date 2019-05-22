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
	ImageIcon carrotimg = new ImageIcon("pic/menu_carrot.png");
	ImageIcon radishimg = new ImageIcon("pic/menu_radish.png");
	
	JPanel panel;

	twomenu(JFrame frame){
		setLayout(null);
		panel = this;
		
		add(new back(frame, this, 1)); //뒤로가기버튼
		
		JButton btn_carrot = new JButton(carrotimg);
		JButton btn_radish = new JButton(radishimg);
		JButton btn_buger = new JButton(radishimg);
		
		btn_setting(btn_carrot);btn_setting(btn_radish);btn_setting(btn_buger);
		
		btn_carrot.setBounds(100,300,carrotimg.getIconWidth(),carrotimg.getIconHeight());
		btn_radish.setBounds(300,250,radishimg.getIconWidth(),radishimg.getIconHeight());
		btn_buger.setBounds(650,250,radishimg.getIconWidth(),radishimg.getIconHeight());
		
		add(btn_carrot);add(btn_radish);add(btn_buger);
		
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
		btn_buger.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				frame.add(new _1_bugerFrame(frame));
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