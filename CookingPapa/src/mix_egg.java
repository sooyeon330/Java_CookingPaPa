import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class mix_egg extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/table.png");
	ImageIcon mixball_img = new ImageIcon("pic/mixball1.png");
	ImageIcon mixball2_img = new ImageIcon("pic/mixball2.png");
	ImageIcon eggimg = new ImageIcon("pic/Egg.png");
	ImageIcon gageimg = new ImageIcon("pic/gage.png");
	ImageIcon brokenegg = new ImageIcon("pic/broken_egg.png");
	ImageIcon checkimg = new ImageIcon("pic/check_egg.png");
	ImageIcon checkbrokenimg = new ImageIcon("pic/check_broken_egg.png");
	ImageIcon go_btnimg = new ImageIcon("pic/go_btn.png");
	moving move = new moving(eggimg);
	
	JPanel ck_panel = new JPanel();
	JLabel mixball = new JLabel(mixball_img);
	JLabel gage = new JLabel(gageimg);
	
	JLabel[] check = {new JLabel(checkimg),new JLabel(checkimg),new JLabel(checkimg)};

	public static final int FRAME_RATE = 30;
	public static final int FPS = 1000 / FRAME_RATE;
	Thread thread;
	JFrame frame; 
	JPanel panel;
	int i=0,count=0;
	boolean repeat=true;
	public mix_egg(JFrame frame) {
		count=0;
		
		final int MIDDLE = gageimg.getIconWidth()/2;		
		setLayout(null);
		
		this.frame = frame;
		this.panel = this;

		ck_panel.setBounds(700,500,300,100);		
//		ck_panel.setBounds(700,500,checkimg.getIconWidth()*3+20,checkimg.getIconHeight()+10);
		while(i<3)  {
			check[i].setBounds(0,0,eggimg.getIconWidth(),eggimg.getIconHeight());
			ck_panel.add(check[i++]);
		}
		
		mixball.setBounds(0, 0, mixball_img.getIconWidth(), mixball_img.getIconHeight());
		gage.setBounds(100,50,gageimg.getIconWidth(),gageimg.getIconHeight());
		
		add(gage);add(mixball); add(ck_panel);
		
		frame.requestFocusInWindow();	
		
		move.setBounds(100,50,gageimg.getIconWidth(),170);
	//	System.out.println("moving");
		frame.add(move);
		
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while(repeat) {
						long start = System.currentTimeMillis();
						// 寃뚯엫 濡쒖쭅
						move.logic();
						move.setVisible(false);
						move.repaint();
						move.setVisible(true);
						long end = System.currentTimeMillis();
						long elapsed = (end - start); // 寃뚯엫 濡쒖쭅 + 洹몃━湲� 泥섎━ �떆媛�
						
						if(elapsed < FPS) {
							Thread.sleep(FPS - elapsed);
						}
						frame.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								if(e.getKeyCode()==KeyEvent.VK_SPACE) {
									try {
										egg_keyevent(e);
										
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									} 
									
								}
//								else System.out.println("�뒪�럹�씠�뒪瑜� �늻瑜댁꽭�슂");
								
							}
						});
						
					}//while
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	
	}

	int score=0; 
	void egg_keyevent(KeyEvent e) throws InterruptedException {
		
		if(move.mx>=390 && move.mx<=490) { //5�젏
			score+=100;
			egg_event(); if(count==3) donecount(score);
		}else if(move.mx>=290 && move.mx<=600){//2�젏
			score+=50;
			egg_event(); if(count==3) donecount(score);
		}else if (move.mx>=90 && move.mx<=800){//0�젏
			score+=20;
			egg_event(); if(count==3) donecount(score);
		}
	}
	void egg_event() throws InterruptedException {
		check[count++].setIcon(checkbrokenimg); 
		Thread.sleep(300);
		move.mx=0;
	}
	
	void donecount(int score) throws InterruptedException {
//		System.out.println(menu.stage2_score);
		menu.stage2_score+=score/3;
		
		mixball.setIcon(mixball2_img);
		thread.join(500);
		frame.remove(move);
		frame.remove(panel);
		frame.repaint();
		frame.add(new make_eggroll(frame));
		repeat=false;
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimg.getImage(),0,0,null);
	}

}
