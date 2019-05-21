
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Time_Limit extends Thread{
	private int i;
	JPanel myPanel = new JPanel();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	boolean stopFlag = false;
	static boolean complete = false;
	int num = 0;

	Time_Limit(int i, JPanel myPanel, JFrame frame){
		this.i = i;
		this.myPanel = myPanel;
		this.frame = frame;
		label.setOpaque(true);
		label.setFont(new Font("돋움",Font.BOLD,15).deriveFont(40.0f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 150, 100);
		label.setBackground(Color.WHITE);
		
	}
	
	Time_Limit(int i, JPanel myPanel, JFrame frame, int num){
		this.i = i;
		this.num = num;
		this.myPanel = myPanel;
		this.frame = frame;
		label.setOpaque(true);
		label.setFont(new Font("font/A吗户B.TTF",Font.BOLD,15).deriveFont(40.0f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		if(num == 1) label.setBounds(450, 300, 150, 100);
		else label.setBounds(0, 0, 150, 100);
		label.setBackground(Color.WHITE);
		
	}
	
	@Override
	public void run() {
		while(!stopFlag) {
			if(i <= 5) label.setForeground(Color.RED);
			label.setText(Integer.toString(i) + "초");
		//	System.out.println(i);
			myPanel.add(label);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
			if(complete) {
				stopFlag= true;
				complete = false;
			}
			if(i == -1) {
				stopFlag = true; 
				if(num == 1) {
					frame.add(new twoResult(frame));
					num = 0;
				}
				else if(num == 2) {
					frame.add(new result(frame, menu.stage3_score));
					num = 0;
				}
				else {
					frame.add(new exam(frame));
				}
				frame.remove(myPanel);
				frame.repaint();
				frame.revalidate(); 
			}
		}
	}
}
