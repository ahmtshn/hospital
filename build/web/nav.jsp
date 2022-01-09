<%-- 
    Document   : nav
    Created on : Jan 9, 2022, 12:35:52 PM
    Author     : ahmetsahin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
     style="width: 280px;">

    <span class="fs-4"> <%
	models.User user = (models.User) request.getSession().getAttribute("currentUser");
	if (user.getName() != null) {
	    out.print("<p>" + user.getName() + "</p>");
	} else {
	    out.print("");
	}
	%>
    </span>

    <hr>
    <%
	String path = request.getServletPath();

	String activeNavClassName = "nav-link active";
	String disableNavClassName = "nav-link text-white";
	String appointmentClassName = path.equalsIgnoreCase("/home.jsp") ? activeNavClassName : disableNavClassName;
	String profileClassName = path.equalsIgnoreCase("/profile.jsp") ? activeNavClassName : disableNavClassName;

    %>
    <ul id="navMenu" class="nav nav-pills flex-column mb-auto">
	<li class="nav-item"><a href="/hospital/list" class="<%= appointmentClassName%>" aria-current="page">Randevular</a></li>
	<li><a href="/hospital/profile" class="<%= profileClassName%>" aria-current="page">Bilgilerim</a></li>
	<li><a id="signout" href="/hospital/signout" class="nav-link text-white"> Çıkış Yap </a></li>
    </ul>
    <hr>
</div>



