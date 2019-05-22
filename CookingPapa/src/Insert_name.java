import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

 class insert_Dialog extends JDialog{
	 String nikname;
	public static Connection conn = null;
	private static final String Ramen_TABLE_NAME = "Ramen_Rank";
	private static final String Egg_TABLE_NAME = "Egg_Rank";
	private static final String Chicken_TABLE_NAME = "Chicken_Rank";
	public insert_Dialog(int stage, int score) {
		setLayout(null);
		setPreferredSize(new Dimension(300, 200));
		setLocation(500, 500);
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:CookingPapa.db");
			RankDAO.init(conn);
	
			nikname = JOptionPane.showInputDialog("닉네임을 입력해주세요");
	//		System.out.println(nikname);
			
			Rank rank= new Rank(nikname, score);
			
			switch(stage) {
				case 1: RankDAO.add(rank,Ramen_TABLE_NAME); break;
				case 2: RankDAO.add(rank,Egg_TABLE_NAME); break;
				case 3: RankDAO.add(rank,Chicken_TABLE_NAME); break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
 
class insert_name extends JPanel{
	
	public insert_name(int stage,int score) {
	
		insert_Dialog dialog = new insert_Dialog(stage, score);
	}
}



