
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;

/**
 *
 * @author ahmetsahin
 */
public class AppointmentsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try (PrintWriter out = response.getWriter()) {
	    /* TODO output your page here. You may use following sample code. */
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlet Appointments</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>Servlet Appointments at " + request.getContextPath() + "</h1>");
	    out.println("</body>");
	    out.println("</html>");
	}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String action = request.getServletPath();
	switch (action) {
	    case "/list":
		getAppointmentList(request, response);
		break;
	    case "/update":
		updateAppointment(request, response);
		break;
	    case "/create":
		create(request, response);
		break;
	    case "/delete":
		delete(request, response);
		break;
	    default:
		break;
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	this.doGet(request, response);
    }

    public void getAppointmentList(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();

	User user = (User) session.getAttribute("currentUser");
	String tckn = user.getTckn();
	String userType = user.getUserType();

	AppointmentDao ad = new AppointmentDao();
	List<models.Appointment> list = ad.getAppointmentList(tckn);
	request.setAttribute("list", list);

	// if user patient, get personel list
	if (userType.equals("Hasta")) {
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/personel-list");
	    dispatcher.forward(request, response);
	    return;
	}

	RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
	dispatcher.forward(request, response);
    }

    public void updateAppointment(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String appointmentId = request.getParameter("appointmentId");
	AppointmentDao ad = new AppointmentDao();

	boolean isSuccess = ad.updateStatus(appointmentId);
	if (isSuccess) {
	    response.sendRedirect("/hospital/list");
	}

    }

    public void create(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String date = request.getParameter("date");
	String personelTckn = request.getParameter("personelTckn");

	AppointmentDao ad = new AppointmentDao();

	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("currentUser");

	boolean isSuccess = ad.createAppointment(personelTckn, date, user);
	if (isSuccess) {
	    response.sendRedirect("/hospital/list");
	}

    }

    public void delete(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String appointmentId = request.getParameter("appointmentId");

	AppointmentDao ad = new AppointmentDao();

	boolean isSuccess = ad.deleteAppointment(appointmentId);

	if (isSuccess) {
	    response.sendRedirect("/hospital/list");
	}

    }

}
