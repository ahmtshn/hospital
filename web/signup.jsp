<%-- 
    Document   : signup.jsp
    Created on : Jan 8, 2022, 9:04:01 PM
    Author     : ahmetsahin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="./bootstrap/bootstrap.jsp" %>
	<style>
	    <%@include file="./css/global.css" %>
	</style>

        <title>Kayıt Ol</title>
    </head>
    <body>
	<div class="container-fluid d-flex flex-column justify-content-center align-items-center">
	    <form action="signup" class="form-container">
		<h3>Kayıt Ol</h3>
		<input maxlength="11" type="text" name="tckn" placeholder="Tc kimlik no" />
		<input type="text" name="name" placeholder="Ad soyad" />
		<input type="password" name="password" placeholder="Şifre" />
		<select name="userType" class="userTypeSelect">
		    <option class="firstOption" disabled selected>Kullanıcı Tipi</option>
		    <option>Personel</option>
		    <option>Hasta</option>
		</select> 
		<input class="submitButton" type="submit" value="Kayıt Ol" />
	    </form>
	</div>
    </body>
</html>
