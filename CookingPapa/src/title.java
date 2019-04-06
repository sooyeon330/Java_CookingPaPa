import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class TitlePanel extends JPanel{
	JButton button1,button2;
	ImageIcon bgimage = new ImageIcon("pic/title.png");
	ImageIcon start = new ImageIcon("pic/start_btn.png");
	ImageIcon start_press = new ImageIcon("pic/start_btn_press.png");
	ImageIcon rank = new ImageIcon("pic/ranking_btn.png");
	ImageIcon rank_press = new ImageIcon("pic/ranking_btn_pressed.png");
	
	JPanel panel;
	
	TitlePanel(JFrame frame) {
		
		setLayout(null);
		 
		panel = this;
		
		JButton secret_btn =new JButton();
		
		button1 = new JButton(start);
		button2 = new JButton(rank);
		
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setIcon(start_press);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button1.setIcon(start); 
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new menu(frame));
		 		frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		button1.setBounds(60,600,200,80);		
		add(button1);
		
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button2.setFocusPainted(false);
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button2.setIcon(rank_press); 
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button2.setIcon(rank); 
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.add(new view_Rank(frame));
		 		frame.remove(panel);
				frame.repaint();
				frame.revalidate();
			}
		});
		button2.setBounds(650,600,350,90);		
		add(button2);
		}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}



public class title {
	static protected JFrame frame = new JFrame();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image img = toolkit.getImage("pic/egg_icon.png");
				frame.setIconImage(img);
				frame.setTitle("Cooking PaPa 쿠킹파파"); 
				frame.setLocation(400, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				TitlePanel title = new TitlePanel(frame);		
				title.setPreferredSize(new Dimension(1024, 720));
				title.setLayout(null);
				
				menu menu = new menu(frame);
				menu.setPreferredSize(new Dimension(1024, 720));
								
				frame.add(title);
			
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}