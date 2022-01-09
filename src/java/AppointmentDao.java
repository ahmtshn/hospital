/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import models.Appointment;

/**
 *
 * @author ahmetsahin
 */
public class AppointmentDao {

    public List<Appointment> getAppointmentList(String tckn) {
	ResultSet rs = null;
	Database db = new Database();
	db.loadDriver();

	Connection connection = db.getConnection();

	List<Appointment> list = new ArrayList<>();

	String sql = "SELECT * FROM hastane.appointments WHERE personelTckn='" + tckn + "' OR patientTckn='" + tckn + "'";

	try {
	    PreparedStatement ps = connection.prepareStatement(sql);
	    rs = ps.executeQuery();

	    while (rs.next()) {

		Appointment ap = new Appointment();
		ap.setAppointmentId(rs.getString("appointmentId"));
		ap.setPersonelTckn(rs.getString("personelTckn"));
		ap.setPatientTckn(rs.getString("patientTckn"));
		ap.setPersonelName(rs.getString("personelName"));
		ap.setPatientName(rs.getString("patientName"));
		ap.setAppointmentDate(rs.getString("appointmentDate"));
		ap.setAppointmentStatus(rs.getBoolean("appointmentStatus"));
		ap.setAppointmentNotes(rs.getString("appointmentNotes"));

		list.add(ap);
	    }
	    rs.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return list;
    }

    public boolean updateStatus(String appointmentId) {
	boolean success = false;
	Database db = new Database();
	db.loadDriver();

	Connection connection = db.getConnection();

	String sql = "UPDATE hastane.appointments SET appointmentStatus=true WHERE appointmentId='" + appointmentId + "'";

	try {
	    PreparedStatement ps = connection.prepareStatement(sql);
	    success = ps.executeUpdate() > 0;
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return success;
    }

    public boolean deleteAppointment(String appointmentId) {
	boolean success = false;
	Database db = new Database();
	db.loadDriver();

	Connection connection = db.getConnection();

	String sql = "DELETE FROM hastane.appointments WHERE appointmentId='" + appointmentId + "'";
	try {
	    PreparedStatement ps = connection.prepareStatement(sql);
	    success = ps.executeUpdate() > 0;

	} catch (SQLException ex) {
	    Logger.getLogger(AppointmentDao.class.getName()).log(Level.SEVERE, null, ex);
	}
	return success;
    }

    public boolean createAppointment(String personelTckn, String appointmentDate, models.User user) {
	boolean success = false;
	Database db = new Database();
	db.loadDriver();

	ResultSet rs = null;

	Connection connection = db.getConnection();

	String sql = "SELECT name FROM hastane.users WHERE tckn='" + personelTckn + "'";
	try {
	    PreparedStatement ps = connection.prepareStatement(sql);
	    rs = ps.executeQuery();
	    rs.next();
	    String appointmentId = UUID.randomUUID().toString();
	    String personelName = rs.getString("name");
	    String patientName = user.getName();
	    String patientTckn = user.getTckn();
	    boolean appointmentStatus = false;

	    rs.close();

	    String createSql = "insert into hastane.appointments (appointmentId, personelTckn, patientTckn,personelName, patientName, appointmentDate, appointmentStatus, appointmentNotes)"
		    + "values('" + appointmentId + "','" + personelTckn + "','" + patientTckn + "', '" + personelName + "', '" + patientName + "','" + appointmentDate + "',false,'')";

	    ps = connection.prepareStatement(createSql);

	    success = ps.executeUpdate() > 0;

	} catch (SQLException ex) {
	    Logger.getLogger(AppointmentDao.class.getName()).log(Level.SEVERE, null, ex);
	}
	return success;
    }

}
