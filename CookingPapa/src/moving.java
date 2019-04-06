import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class moving extends JPanel {
//	private BufferedImage img;
	ImageIcon image;
	JLabel img;
	// translate
	private boolean translateReverse = false;
	protected double currentYDelta = 0.0;
	private int translationSpeed = 10;
	private double translationMax;
	
	protected double mx;	

	public moving(ImageIcon image) {
		setLayout(null);
		this.image = image;
		img = new JLabel(image);

	}
	
	public void logic() {
		if(translateReverse) {
			currentYDelta += translationSpeed;
			if(currentYDelta >= translationMax) translateReverse = false;
		} else {
			currentYDelta -= translationSpeed;
			if(currentYDelta <= -translationMax) translateReverse = true;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		translationMax = 370;
		
		AffineTransform at = new AffineTransform();		
		// 4. 최종적으로 이미지의 중점 위치 지정 (이 경우 캔버스의 중앙으로 이동)
		at.translate(getWidth() / 2 + currentYDelta, (getHeight() / 2));
		mx = at.getTranslateX(); 
		// 1. 먼저 이미지의 좌상단이 0, 0에 위치하므로 이미지 사이즈의 반 만큼 이동하여 원점(0, 0)에 이미지의 중앙이 위치하도록 함!
		at.translate(-image.getIconWidth() / 2, -image.getIconHeight() / 2 );
        // 최종적으로 이미지 그리기
		g2d.drawImage(image.getImage(), at, null);
	}


}