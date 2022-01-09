<%-- 
    Document   : float
    Created on : Jan 9, 2022, 6:48:46 PM
    Author     : ahmetsahin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .float-button {
	width: 70px;
	height: 70px;
	position: absolute;
	right: 30px;
	bottom: 30px;
	border: none;
	background-color: green !important;
	border-radius: 45px;
	font-size: 24px;
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	z-index: 1;
	cursor: pointer;
    }
</style>
<button onclick="openModal()" class="float-button">+</button>

<script type="text/javascript">
    function openModal() {
	document.getElementById("appointmentModal").style.display = "flex";
    }
</script>