
/**
 *
 * @author ahmetsahin
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.User;
import database.Database;

public class UserDao {

    public boolean insertUser(User user) throws SQLException {
	boolean success = false;
	try {
	    Database db = new Database();
	    Connection connection = db.getConnection();
	    String sql = "insert into hastane.users values(?,?,?,?)";

	    PreparedStatement ps = connection.prepareStatement(sql);

	    ps.setString(1, user.getName());
	    ps.setString(2, user.getPassword());
	    ps.setString(3, user.getUserType());
	    ps.setString(4, user.getTckn());

	    success = ps.executeUpdate() > 0;

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return success;
    }

    public boolean updateUser(User user) throws SQLException {
	boolean success = false;

	try {
	    Database db = new Database();
	    Connection connection = db.getConnection();
	    String sql = "UPDATE hastane.users SET name='" + user.getName() + "', password='" + user.getPassword() + "' WHERE tckn='" + user.getTckn() + "'";
	    
	    PreparedStatement ps = connection.prepareStatement(sql);
	    success = ps.executeUpdate() > 0;

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return success;
    }

    public User getUser(User user) throws SQLException {
	User dbUser = new User();
	ResultSet rs;
	try {
	    Database db = new Database();
	    Connection connection = db.getConnection();
	    String sql = "SELECT * FROM hastane.users WHERE tckn='" + user.getTckn() + "' AND password='" + user.getPassword() + "' AND userType='" + user.getUserType() + "'";
	    PreparedStatement ps = connection.prepareStatement(sql);
	    rs = ps.executeQuery();

	    if (rs.next()) {

		dbUser.setName(rs.getString("name"));
		dbUser.setPassword(rs.getString("password"));
		dbUser.setTckn(rs.getString("tckn"));
		dbUser.setUserType(rs.getString("userType"));
	    }
	    rs.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return dbUser;
    }

    public List<User> getPersonel() throws SQLException {
	List<User> list = new ArrayList<User>();
	ResultSet rs;
	try {
	    Database db = new Database();
	    Connection connection = db.getConnection();
	    String sql = "SELECT * FROM hastane.users WHERE userType='Personel'";
	    PreparedStatement ps = connection.prepareStatement(sql);
	    rs = ps.executeQuery();

	    while (rs.next()) {
		User dbUser = new User();
		dbUser.setName(rs.getString("name"));
		dbUser.setPassword(rs.getString("password"));
		dbUser.setTckn(rs.getString("tckn"));
		dbUser.setUserType(rs.getString("userType"));
		
		list.add(dbUser);
	    }

	    rs.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return list;
    }

}
