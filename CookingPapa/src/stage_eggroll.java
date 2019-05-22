import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;


public class stage_eggroll extends JPanel{

	int i=0,j=0;
	int count=3;
	ImageIcon bgimage = new ImageIcon("pic/cuttingboard.png");
	ImageIcon resultimg = new ImageIcon("pic/result.png");
	ImageIcon explaneimg = new ImageIcon("pic/eggroll_explane.png");
	ImageIcon[] ingrediantimg = {new ImageIcon("pic/onion1.png"),new ImageIcon("pic/onion2.png"),new ImageIcon("pic/onion3.png"),new ImageIcon("pic/onion4.png"),
							  new ImageIcon("pic/papprica1.png"),new ImageIcon("pic/papprica2.png"),new ImageIcon("pic/papprica3.png"),new ImageIcon("pic/papprica4.png"),
							  new ImageIcon("pic/carret1.png"),new ImageIcon("pic/carret2.png"),new ImageIcon("pic/carret3.png"),new ImageIcon("pic/carret4.png")};		
	ImageIcon go_btnimg = new ImageIcon("pic/go_btn.png");
	ImageIcon heartimg = new ImageIcon("pic/heart.png");
	ImageIcon broken_heartimg = new ImageIcon("pic/broken_heart.png");
	
	JLabel[] heart = {new JLabel(heartimg),new JLabel(heartimg),new JLabel(heartimg)};
	
	boolean start=false, check=false;
	JPanel panel = this;
	JFrame frame;
	public stage_eggroll(JFrame frame) {
		setLayout(null);
		this.frame = frame;
		
		JLabel lb_ingrediant = new JLabel(ingrediantimg[0]);
		JLabel lb_explane = new JLabel(explaneimg);
		
		JButton gobtn = new JButton(go_btnimg);
		Explane_Event btnevent = new Explane_Event();
		
		btnevent.gobtn_event(lb_explane, gobtn);
		btnevent.image_crop(gobtn);
		add(gobtn);
		
		JPanel heart_panel = new JPanel();
		heart_panel.setBounds(0,0,heartimg.getIconWidth()*3+20,heartimg.getIconHeight()+10);
		while(j<3)  {
			heart[j].setBounds(0,0,100,100);
			heart_panel.add(heart[j++]);
		}
		
		setbounds_img(lb_explane); 
		add(lb_explane); 
		add(heart_panel);
		
		
		
	
		ingrediant_crop(lb_ingrediant, ingrediantimg);
//		frame.add(make_egg);
		
		addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				if (count==0) {menu.stage2_score+=100; setVisible(false);frame.add(new mix_egg(frame));}
				
				if(i >= ingrediantimg.length-1) {
					setVisible(false);
					try {
						Thread.sleep(150);
						frame.add(new mix_egg(frame));
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
				}
			}
			
		});
		
	
	}
			
	  void ingrediant_crop(JLabel lb,ImageIcon[] img) { 
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("pic/knife.png").getImage(), new Point(31,31),"custom cursor"));
		setbounds_img(lb); add(lb);

		Brush b = new Brush();
				
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
					b.xx=e.getX();
					b.yy=e.getY();
					b.repaint();  
					b.printAll(lb.getGraphics());
			}
		});

		addMouseListener(new MouseAdapter() {	
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getX()>500 && e.getX()<700) start=true; 
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {				
					if(start==true && e.getX()>300 && e.getX()<700) {
						i++;
						if(i<img.length) lb.setIcon(img[i]);
						
					} else {
						heart[--count].setIcon(broken_heartimg);
//						count++;
						if(count<=3) { menu.stage2_score+=20;}
						else if(count==3) {menu.stage2_score+=50;}
						
						if(i>7) i=8; 
						else if(i>3) i=4;
						else i=0;
						repaint();
						lb.setIcon(img[i]);						
					}  
			}
			
			
		});
	}//ingre_crop

	void setbounds_img(Component c) {
		 int img_width = explaneimg.getIconWidth();
		 int img_height = explaneimg.getIconHeight();
		c.setBounds(0, 0, img_width, img_height);		
	}
	@Override
	protected void paintComponent(Graphics g) {		
		 g.drawImage(bgimage.getImage(),0,0,null); 
	}
}



