import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class result extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/result.png");
	
	result(JFrame frame, int score){
		setLayout(null);
		JButton rankbtn = new JButton("등록");
		JLabel view = new JLabel();
		view.setText(Integer.toString(score));
		view.setFont(new Font("돋움",Font.BOLD,15).deriveFont(120.0f));
		view.setBounds(480, 300, 300, 200);
		add(view);
		
		rankbtn.setBounds(500, 500, 150, 100);
		add(rankbtn);
		rankbtn.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				add(new insert_name(3,score));
			}
		});
		
		add(new back(frame,this));
		menu.stage1_score = 0; 
		menu.stage2_score = 0;
		menu.stage3_score = 0;
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
