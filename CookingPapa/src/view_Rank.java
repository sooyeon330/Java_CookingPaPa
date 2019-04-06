import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Ramen_Rank extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/rank_ramen.png");
	public Ramen_Rank(List<Rank> ranks) {
//		setLayout(null);
		setLayout(new GridLayout(7, 1));
		setSize(new Dimension(1024, 720));
		add(new JLabel());
		add(new JLabel("\t\t NAME \t\t SCORE\t\t"));
		int count=1;
		for(Rank s : ranks) {
			String texts = String.format("%d \t\t\t %s \t %d",count, s.name, s.score);
			add(new JLabel(texts));
			count++;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimg.getImage(), 0, 0, null);
	}
}
class Egg_Rank extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/rank_eggroll.png");
	public Egg_Rank(List<Rank> ranks) {
//		setLayout(null);
		setLayout(new GridLayout(7, 1));
		setSize(new Dimension(1024, 720));
		add(new JLabel());
		add(new JLabel("\t\t NAME \t\t SCORE\t\t"));
		int count=1;
		for(Rank s : ranks) {
			String texts = String.format("%d \t %s \t %d",count, s.name, s.score);
			add(new JLabel(texts));
			count++;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimg.getImage(), 0, 0, null);
	}
}
class Chicken_Rank extends JPanel{
	ImageIcon bgimg = new ImageIcon("pic/rank_chicken.png");
	public Chicken_Rank(List<Rank> ranks) {
//		setLayout(null);
		setLayout(new GridLayout(7, 1));
		setSize(new Dimension(1024, 720));
		add(new JLabel());
		add(new JLabel("\t\t NAME \t\t SCORE\t\t"));
		int count=1;
		for(Rank s : ranks) {
			String texts = String.format("%d \t %s \t %d",count, s.name, s.score);
			add(new JLabel(texts));
			count++;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bgimg.getImage(), 0, 0, null);
	}
}

 class view_Rank extends JPanel{
	public Ramen_Rank rm_rank = null;
    public Egg_Rank egg_rank = null;
    public Chicken_Rank ck_rank = null;
    JButton btn1,btn2,btn3;
	public view_Rank(JFrame frame) {
		setLayout(null);
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:CookingPapa.db");
		
			RankDAO.init(conn);
	       
	       List<Rank> rm_ranks = RankDAO.getLists("Ramen_Rank");
	       List<Rank> egg_ranks = RankDAO.getLists("Egg_Rank");
	       List<Rank> chicken_ranks = RankDAO.getLists("Chicken_Rank");
	       
	       rm_rank = new Ramen_Rank(rm_ranks);
	       egg_rank = new Egg_Rank(egg_ranks);
	       ck_rank = new Chicken_Rank(chicken_ranks);
	       
	       btn1 = new JButton("rm");
	       btn2 = new JButton("egg");
	       btn3 = new JButton("chicken");
	       
	        add(new back(frame, this,0));
	       add(btn1);add(btn2); add(btn3);
	       add(rm_rank);add(egg_rank); add(ck_rank);
	      
	       rm_rank.setVisible(true);
	       egg_rank.setVisible(false);
	       ck_rank.setVisible(false);
	       
	       btn1.setBounds(0, 0, 100, 50);
	       btn2.setBounds(110, 0, 100, 50);
	       btn3.setBounds(220, 0, 100, 50);
	       
	       btn1.addMouseListener(new MouseAdapter() {
	    	   @Override
	    	public void mouseClicked(MouseEvent e) {
	    		   rm_rank.setVisible(true);
					egg_rank.setVisible(false);
					ck_rank.setVisible(false);
	    	}
	       });
	       btn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rm_rank.setVisible(false);
					egg_rank.setVisible(true);
					ck_rank.setVisible(false);
			}});
	       btn3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					rm_rank.setVisible(false);
					egg_rank.setVisible(false);
					ck_rank.setVisible(true);
			}});
			
       } catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
 

