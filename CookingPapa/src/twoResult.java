import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class twoResult extends JPanel{
	ImageIcon bgimage = new ImageIcon("pic/twoResult.png");
	
	twoResult(JFrame frame){
		setLayout(null);
		
		JLabel result = new JLabel();
		result.setFont(new Font("돋움",Font.BOLD,15).deriveFont(80.0f));
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBounds(430, 400, 150, 100);
		add(result);
		add(new back(frame,this));
		
		if(two_carrot.count1 > two_carrot.count2) {
			result.setText("P1");
		}
		else if(two_carrot.count1 == two_carrot.count2){
			result.setText("X");
		}
		else {
			result.setText("P2");
		}
		
		two_carrot.count1 = 0;
		two_carrot.count2 = 0;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgimage.getImage(),0,0,null);
	}
}
