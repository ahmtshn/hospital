<%-- 
    Document   : login
    Created on : Jan 9, 2022, 1:40:44 AM
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
        <title>Login</title>
    </head>
    <body>
        <div class="container-fluid d-flex flex-column justify-content-center align-items-center">
	    <form action="login" class="form-container">
		<h3>Giriş Yap</h3>
		<input value="" maxlength="11" type="text" name="tckn" placeholder="Tc kimlik no" />
		<input value="" type="password" name="password" placeholder="Şifre" />
		<select name="userType" class="userTypeSelect">
		    <option class="firstOption" disabled selected>Kullanıcı Tipi</option>
		    <option >Personel</option>
		    <option>Hasta</option>
		</select>
		<div class="d-flex flex-direction-row align-items-center mt-2 mb-2" >
		    <input name="remember" id="check" type="checkbox" />Beni Hatırla
		</div>
		<input class="submitButton" type="submit" value="Giriş Yap" />
		<input onclick="window.location.href = 'signup.jsp'" class="submitButton" type="button" value="Kayıt Ol" />
	    </form>
	</div>
    </body>
</html>
