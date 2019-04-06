
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class stage_chicken4 extends JPanel{
	
	ImageIcon bgimage = new ImageIcon("pic/flour.png");
	ImageIcon chicken[] = {new ImageIcon("pic/rolling_chicken1.png"), new ImageIcon("pic/rolling_chicken2.png"),new ImageIcon("pic/rolling_chicken3.png"),
						new ImageIcon("pic/rolling_chicken4.png"),new ImageIcon("pic/rolling_chicken5.png")};
	private int x = 260;
	private int y = 270;
	
	JPanel panel; 
	
	int i = 0;
	int count = 0;
	
	stage_chicken4(JFrame frame){
		setLayout(null);
		
		panel = this;
		
		Time_Limit tm = new Time_Limit(15, panel, frame);
		tm.start();
		
		new pause(panel,tm);
		
		JPanel panel = this;
		
		JLabel confirm = new JLabel();
		confirm.setBounds(512,600,100,154);
		confirm.setFont(new Font("돋움",Font.BOLD,15).deriveFont(50.0f));
		confirm.setText( String.valueOf(count) + "개");
		add(confirm);
		
		JLabel ingre_chicken = new JLabel(chicken[i]);
		ingre_chicken.setSize(92,144);
		ingre_chicken.setBounds(x,y,92,144);
		add(ingre_chicken);
		
		frame.requestFocusInWindow();
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(pause.work && count < 6) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT && x > 260) {
						x -= 100; i++;
					}
					if(e.getKeyCode() == KeyEvent.VK_RIGHT && x < 760) {
						x += 100; i++;
					}
					if(i > 4) {
						i = 0; count++; x = 270;
						menu.stage3_score += 5;
						confirm.setText( String.valueOf(count) + "개");
					}
					ingre_chicken.setIcon(chicken[i]);
					ingre_chicken.setBounds(x,y,92,144);
				}
				if(count == 6) {
					frame.removeKeyListener(this);
					Time_Limit.complete = true;
					frame.add(new exam(frame));
					frame.remove(panel);
					frame.repaint();
					frame.revalidate();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {

				
				
			}
		});
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}


