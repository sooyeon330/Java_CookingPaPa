import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class back extends JLabel{
	ImageIcon stop = new ImageIcon("pic/back.png");
	
	back(JFrame frame, JPanel myPanel){

		setLayout(null);
		
		setIcon(stop);
		setBounds(930,10,stop.getIconWidth(),stop.getIconHeight());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exam.btn_count = 0;
				stage_ramen.printcnt=0;
				make_eggroll.printcnt=0;
				frame.add(new menu(frame));
				frame.remove(myPanel);
//				myPanel.setVisible(false);
				frame.repaint(); 
				frame.revalidate();
			}
		});
	}
	
	back(JFrame frame, JPanel myPanel, int i){

		setLayout(null);
		
		setIcon(stop);
		setBounds(930,10,stop.getIconWidth(),stop.getIconHeight());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exam.btn_count = 0;
				frame.add(new TitlePanel(frame));
				frame.remove(myPanel);
				frame.repaint();
				frame.revalidate();
			}
		});
	}

}
