<%-- 
    Document   : home
    Created on : Jan 9, 2022, 2:18:11 PM
    Author     : ahmetsahin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Cookie[] cookies = request.getCookies();
    String usertype = "";
    for (Cookie ck : cookies) {
	if (ck.getName().equals("userType")) {
	    usertype = ck.getValue();
	}
    }

    boolean isUserPersonel = usertype.equals("Personel");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="./bootstrap/bootstrap.jsp" %>
	<style>
	    <%@include file="./css/global.css" %>
	    <%@include file="./css/list.css" %>
	</style>
        <title>Home</title>
    </head>
    <body>
	
	<jsp:include page="/nav.jsp" ></jsp:include> 
	    <div class="w-100 p-3">
	    <jsp:include page="list.jsp" ></jsp:include> 
	    </div>
	<% if (!isUserPersonel) {%>
	<jsp:include page="/modal.jsp"></jsp:include>
	<jsp:include page="/float.jsp"></jsp:include>
	<% }%>
    </body>
</html>
