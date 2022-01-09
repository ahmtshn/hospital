<%-- 
    Document   : index
    Created on : Jan 9, 2022, 10:38:51 PM
    Author     : ahmetsahin
--%>
<% 
    Cookie[] cookie = request.getCookies();
    for (Cookie ck : cookie) {
	if (ck.getName().equals("remember")) {
	     response.sendRedirect("/hospital/list");
	     return;
	}
    }
    response.sendRedirect("login.jsp");
%>
