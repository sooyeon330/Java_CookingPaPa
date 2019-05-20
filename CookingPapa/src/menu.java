import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class menu extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/menu.png");
	ImageIcon ramenimg = new ImageIcon("pic/Ramen.png");
	ImageIcon eggrollimg = new ImageIcon("pic/EggRoll.png");
	ImageIcon chikenimg = new ImageIcon("pic/Chiken.png");
	ImageIcon tutorial = new ImageIcon("pic/tutorial_btn.png");
	ImageIcon tutorial_press = new ImageIcon("pic/tutorial_btn_press.png");
	
	JPanel panel;
	static int stage1_score = 0;
	static int stage2_score = 0; 
	static int stage3_score = 0;
	public static final int RAMEN = 1;

	menu(JFrame frame){
		setLayout(null);
		panel = this;
		
		add(new back(frame, this, 1));
		
		JButton btn1 = new JButton(ramenimg);
		JButton btn2 = new JButton(eggrollimg);
		JButton btn3 = new JButton(chikenimg);
		
		btn1.setBounds(80,250,ramenimg.getIconWidth(),ramenimg.getIconHeight());
		btn2.setBounds(420,270,eggrollimg.getIconWidth(),eggrollimg.getIconHeight());
		btn3.setBounds(700,250,chikenimg.getIconWidth(),chikenimg.getIconHeight());
		btn_setting(btn1);btn_setting(btn2);btn_setting(btn3);
		
		add(btn1);
		add(btn2);
		add(btn3);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.add(new stage_ramen(frame));
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.add(new stage_eggroll(frame));
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exam.btn_count++;
				frame.add(new exam(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		
		
		JButton button3 = new JButton(tutorial);

		btn_setting(button3);
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button3.setIcon(tutorial_press);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button3.setIcon(tutorial);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new tutorial1(frame));
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		button3.setBounds(700,600,300,80);		
		add(button3);
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