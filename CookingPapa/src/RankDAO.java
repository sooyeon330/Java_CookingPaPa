import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RankDAO {
	private static Connection conn = null;
	private static RankDAO rankDAO = null;
	private static final String RANK_TABLE_NAME = "Rank";
	
	private RankDAO() {}
	
	public static void init(Connection c) {
		conn = c;
	}
	 
	public static Rank add(Rank rank,String table_name) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(String.format("INSERT INTO %s VALUES(?, ?)", table_name));
		ps.setString(1, rank.name);
		ps.setInt(2, rank.score);
		int res = ps.executeUpdate();
		ps.close();
		
		return res == 1 ? rank : null;
	}
	
	public static Rank get(String name,String table_name) throws SQLException {
		Rank user = null;
		PreparedStatement ps = conn.prepareStatement(String.format("SELECT * FROM %s WHERE name = ?", table_name));
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			user = new Rank(rs.getString("name"), rs.getInt("score"));
		}
		ps.close();
		rs.close();
		return user;
	}
	 
	public static List<Rank> getLists(String table_name) throws SQLException {
		List<Rank> lst = new ArrayList<>();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(String.format("select * from %s order by score desc limit 5", table_name));
		while(rs.next()) {
			lst.add(new Rank(rs.getString("name"), rs.getInt("score")));
		}
		s.close();
		rs.close();
		return lst;
	}
	
	public static boolean delete(Rank rank) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(String.format("DELETE FROM %s WHERE name = ?", RANK_TABLE_NAME));
		ps.setString(1, rank.name);
		int res = ps.executeUpdate();
		ps.close();
		
		return res == 1 ? true : false;
	}
}
