<%-- 
    Document   : modal
    Created on : Jan 9, 2022, 6:53:57 PM
    Author     : ahmetsahin
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="appointmentModal" class="customModal">

    <div class="p-50 inner-container w-90">
	<h3>Randevu Oluştur</h3>
	<form action="create">
	    <select name="personelTckn">
		<%
		    int i = 1;
		    List<models.User> list = (List) request.getAttribute("personelList");

		%>

		<%		for (models.User user : list) {


		%>
		<option value='<%= user.getTckn() %>'><%= user.getName()%></option>
		<% }%>
	    </select>
	    <input type="date" name="date" />
	    <input onclick="closeModal()" class="submitButton" type="submit" value="Randevu Al" />
	    <input onclick="closeModal()" class="submitButton" type="button" value="Vazgeç" />
	</form>
    </div>

</div>
	    
<script type="text/javascript">
    function closeModal() {
	document.getElementById("appointmentModal").style.display = "none";
    }
</script>

<style>
    .customModal {
	position: absolute;
	width: 100%;
	height: 100%;
	display: none;
	align-items: center;
	justify-content: center;
	background-color: rgba(0,0,0,0.3);
	border-radius: 20px
    }
    .inner-container {
	background-color: #fff;
	padding: 50px;
	border-radius: 30px;
    }
</style>
