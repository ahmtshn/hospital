<%-- 
    Document   : profile
    Created on : Jan 9, 2022, 2:35:44 PM
    Author     : ahmetsahin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="../bootstrap/bootstrap.jsp" %>
	<style>
	    <%@include file="../css/global.css" %>
	    <%@include file="../css/list.css" %>
	</style>
        <title>Profile</title>
    </head>
    <body>
	<jsp:include page="./nav.jsp"></jsp:include> 
	    <div class="w-100 p-3">
		<form action="user-update">
		<%
		    models.User user = (models.User) session.getAttribute("currentUser");
		    String name = user.getName();
		    String tckn = user.getTckn();
		    String password = user.getPassword();
		    String userType = user.getUserType();
		%>
		Adınız: <input name="name" type="text" value="<%= name%>" />
		Şifreniz: <input name="password" type="text" value="<%= password%>" />
		TC: <input name="tckn" type="text" value="<%= tckn%>" disabled />
		Kullanıcı Tipi: <input name="userType" type="text" value="<%= userType%>" disabled />
		<input class="submitButton" type="submit" value="Güncelle" />
	    </form>
	</div>
    </body>
</html>
