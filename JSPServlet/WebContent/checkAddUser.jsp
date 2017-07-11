<%@page import="login.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String username =request.getParameter("username");
String password= request.getParameter("password");
String hoTen =request.getParameter("hoTen");
	if(username!=null && password!=null){
		NguoiDung user = new NguoiDung();
		if(user.duplicate(username)){
			response.sendRedirect("addUser.jsp");			
		}
		else{
			user.addUser(username,password,hoTen);
 			RequestDispatcher rd = request.getRequestDispatcher("showListUser.jsp");
			rd.forward(request, response);

		}		
	}
	else{
		response.sendRedirect("addUser.jsp");
	}	
%>


</body>
</html>