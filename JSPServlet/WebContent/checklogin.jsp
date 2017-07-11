<%@page import="login.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String username =request.getParameter("username");
	String password= request.getParameter("password");
	
	if(username!=null && password!=null)
	{	NguoiDung user = new NguoiDung();
		if(user.checkLogin(username, password)){
			RequestDispatcher rd = request.getRequestDispatcher("showListUser.jsp");
			rd.forward(request, response);
	}
		else{
			response.sendRedirect("login.jsp");
		}
	}
	
%>
</body>
</html>
