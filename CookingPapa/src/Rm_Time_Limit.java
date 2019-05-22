
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Rm_Time_Limit extends Thread{
	ImageIcon burnpotimg = new ImageIcon("pic/burn_pot.png");
	
	private int i;
	JPanel myPanel = new JPanel();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	boolean stopFlag = false;
	static boolean complete = false;
	int num = 0;

	Rm_Time_Limit(int i, JPanel myPanel, JFrame frame){
		this.i = i;
		this.myPanel = myPanel; 
		this.frame = frame;
		label.setOpaque(true);
		label.setFont(new Font("돋움",Font.BOLD,15).deriveFont(40.0f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 150, 100);
		label.setBackground(Color.WHITE);
		
	}
	
	@Override
	public void run() {
		while(!stopFlag) {
			try {
				if(i>-1) {					
					label.setForeground(Color.RED);
					label.setText(Integer.toString(i) + "초");
		//			System.out.println(i);
					myPanel.add(label);
					Thread.sleep(1000);
					i--;	
				}			 
				else {
					stopFlag=true;
					stage_ramen.pot.setIcon(burnpotimg);
					sleep(500);
//					this.stop();		
					menu.stage1_score=0;
					stage_ramen.printcnt++;
					myPanel.removeAll();
					myPanel.repaint();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
