import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class exam extends JPanel{
	ImageIcon bgimage;
	ImageIcon bgimage1 = new ImageIcon("pic/one.png");
	ImageIcon bgimage2 = new ImageIcon("pic/two.png");
	ImageIcon bgimage3 = new ImageIcon("pic/three.png");
	ImageIcon bgimage4 = new ImageIcon("pic/four.png");
	ImageIcon bgimage5 = new ImageIcon("pic/five.png");
	ImageIcon bgimage6 = new ImageIcon("pic/six.png");
	ImageIcon exit = new ImageIcon("pic/go_btn.png");
	ImageIcon enter = new ImageIcon("pic/go_btn_pressed.png");
	
	JPanel panel;
	
	static int btn_count;
	
	exam(JFrame frame){
		setLayout(null);
		
		panel = this;
		
		
		JLabel button = new JLabel(exit);
		button.setBounds(800, 600, exit.getIconWidth(), exit.getIconHeight());
		add(button);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setIcon(enter);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button.setIcon(exit);
			}
			
			public void mouseClicked(MouseEvent e) {
				if(btn_count == 1) {
					frame.add(new stage_chicken1(frame));
				}
				else if(btn_count == 2) {
					frame.add(new stage_chicken2(frame));
				}
				else if(btn_count == 3) {
					frame.add(new stage_chicken3(frame));
				}
				else if(btn_count == 4) {
					frame.add(new stage_chicken4(frame));
				}
				else if(btn_count == 5) {
					frame.add(new stage_chicken5(frame));
				}
				else {
					frame.add(new stage_chicken6(frame));
				}
				btn_count++;
//				System.out.println("ī��Ʈ : " + btn_count);
				frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		switch(btn_count) {
		case 1: 
			bgimage = bgimage1;
			break;
		case 2: 
			bgimage = bgimage2;
			break;
		case 3: 
			bgimage = bgimage3;
			break;
		case 4: 
			bgimage = bgimage4;
			break;
		case 5: 
			bgimage = bgimage5;
			break;
		case 6: 
			bgimage = bgimage6;
			break;
		default : break;
		}
		
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}