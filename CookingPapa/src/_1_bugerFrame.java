import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class _1_bugerFrame extends JPanel{
	
	public _1_bugerFrame(JFrame frame) {
		this.setLayout(new GridLayout(1,2));
		JPanel panel1 = new _1_bugerTestpanel(frame);
		JPanel panel2 = new _1_bugerTestpanel2(frame);
		
		panel1.setSize(new Dimension(this.WIDTH/2, 720));
		panel2.setSize(new Dimension(this.WIDTH/2, 720));
		
		
		add(panel1);
		add(panel2);
	}
}
