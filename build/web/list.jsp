<%-- 
    Document   : list
    Created on : Jan 9, 2022, 3:43:28 AM
    Author     : ahmetsahin
--%>
<%@page import="models.Appointment"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%> <%@ page language="java"%>



<table>
    <thead>
    <th>#</th>
    <th>Doktor</th>
    <th>Hasta</th>
    <th>Hasta TC</th>
    <th>Tarih</th>
    <th>Durum</th>
    <th>Action</th>
</thead>
<tbody>

    <%
	int i = 1;
	List<Appointment> list = (List) request.getAttribute("list");

	Cookie[] cookies = request.getCookies();
	String usertype = "";
	for (Cookie ck : cookies) {
	    if (ck.getName().equals("userType")) {
		usertype = ck.getValue();
	    }
	}

	boolean isUserPersonel = usertype.equals("Personel");

	String buttonName = isUserPersonel ? "Tamamla" : "İptal";
	String action = isUserPersonel ? "update" : "delete";

    %>

    <%		for (Appointment appointment : list) {


    %>
<form action="<%=action%>">
    <input type="hidden" name="appointmentId" value="<%= appointment.getAppointmentId()%>" />
    <tr>
	<td><%=i++%></td>
	<td><%=appointment.getPersonelName()%></td>
	<td><%=appointment.getPatientName()%></td>
	<td><%=appointment.getPatientTckn()%></td>
	<td><%=appointment.getAppointmentDate()%></td>
	<td><% if (appointment.isAppointmentStatus()) {
		out.print("Tamamlandı");
	    } else {
		out.print("Aktif");
	    }
	    %></td>
	    <% if (!appointment.isAppointmentStatus()) {%>
	<td>
	    <input class="listButton" value="<%= buttonName%>" type="submit" />

	</td>
	<%} %>

    </tr>
</form>
<%
    }
%>

</tbody>
</table>

