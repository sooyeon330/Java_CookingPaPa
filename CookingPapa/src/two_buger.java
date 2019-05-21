import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class two_buger extends JPanel{	
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard2.png");
	ImageIcon keyimg[] = { new ImageIcon("pic/key1.png"), // left
							new ImageIcon("pic/key2.png"), // up
							new ImageIcon("pic/key3.png"), //right
							new ImageIcon("pic/key4.png")}; //down
	
	ImageIcon presskeyimg[] = { new ImageIcon("pic/presskey1.png"), // left
							new ImageIcon("pic/presskey2.png"), // up
							new ImageIcon("pic/presskey3.png"), //right
							new ImageIcon("pic/presskey4.png")}; //down
	
	int x = 100; //방향키 기본 x좌표
	public static final int y = 100; //방향키 기본 y좌표
	public static final int w = 70; //방향키 기본  width
	public static final int h = 70; //방향키 기본 height
	
	public static final int left = 0; //방향키 키코드
	public static final int up = 1; //방향키 키코드
	public static final int right = 2; //방향키 키코드
	public static final int down = 3; //방향키 키코드
	
	int k=0;//keyarray에 쓸 인덱스
	two_buger(JFrame frame) {
		setLayout(null);
		
		int rand = (int) (Math.random()*4);
		int keyarray[][] = new int[4][4];//0 : rand, 1 : keyCode()
		
		for(int i=0; i<4; i++) {
			keyimg[i] = ImageResize(w, h, keyimg[i]);
			presskeyimg[i] = ImageResize(w, h, presskeyimg[i]);
		}
		
		JLabel keylb[]= {null,null,null,null}; //up
		
		paintKey(keylb, keyarray, rand);
		
//		keylb[0].setBounds(x, 100, 100, 100);
//		keylb[1].setBounds(x*2+20, 100, 100, 100);
//		keylb[2].setBounds(x*3+40, 100, 100, 100);
//		keylb[3].setBounds(x*4+60, 100, 100, 100);
		
//		add(keylb[0]);add(keylb[1]);add(keylb[2]);add(keylb[3]);
		
		Thread p1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				frame.requestFocusInWindow();
				frame.addKeyListener(new KeyAdapter() {
					
					@Override
					public void keyPressed(KeyEvent e) {
//						System.out.println("keypress");
						keylb[k].setIcon(presskeyimg[keyarray[0][k]]);
						
						if(e.getKeyCode() == keyarray[1][k++]) {
							System.out.println("맞음");
							if(k > 3) {
								k=0;
								removeKey(keylb, keyarray);
								paintKey(keylb, keyarray, rand);
							}
							

						}else {
							System.out.println("틀림");
							k=0;
							removeKey(keylb, keyarray);
							paintKey(keylb, keyarray, rand);
						}
						
					
					}
					@Override
					public void keyReleased(KeyEvent e) {
						keylb[k].setIcon(keyimg[keyarray[0][k]]);
						keylb[k].setIcon(keyimg[keyarray[0][k]]);
						keylb[k].setIcon(keyimg[keyarray[0][k]]);
						keylb[k].setIcon(keyimg[keyarray[0][k]]);
						frame.repaint();
					}
	
				});
			}
		});
		
		p1.start();
		
		

		
		
		
	}
	protected void paintKey(JLabel[] keylb,int[][] array,int rand) { //새로운 키 배열 출력
		System.out.println("painkey");
		for(int i=0; i<4; i++) { //랜덤으로 방향키 출력	
			rand = (int) (Math.random()*4);
			keylb[i]= new JLabel(keyimg[rand]);
			keylb[i].setBounds(x*(i+1), y, 100, 100);
			
			add(keylb[i]); this.repaint();
			array[0][i] = rand;
			array[1][i] = keyCode(rand);
			System.out.println("add"+rand);
			
		}
	}
	protected void removeKey(JLabel[] keylb,int[][] array) { //화면의 키들을 다 지움
		
		this.remove( keylb[0] );
		this.remove( keylb[1] );
		this.remove( keylb[2] );
		this.remove( keylb[3] );
		this.repaint(); 
		
	}
	protected int keyCode (int index) { //rand값에 따라 키 코드 저장해서 후에 맞는지 아닌지 비교함
		switch(index) {
		case left: return 37; 
		case up: return 38; 
		case right: return 39; 
		case down: return 40; 
		}
		return 0;
	}
	protected ImageIcon ImageResize( int width, int height,ImageIcon img) { //이미지 크기 조정
		Image before = img.getImage();
		Image after = before.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return img = new ImageIcon(after);

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
