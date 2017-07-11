<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="login.NguoiDung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>DS TÀI KHOẢN</title>
<style>
td{
width: 150px;
}
</style>
</head>
<body>
<%NguoiDung user = new NguoiDung();
ArrayList<NguoiDung> arr = user.getListUser();%>
	
	<form action="addUser.jsp">
	<input type ="submit" value ="Thêm tài khoản">
	</form><br>
	DANH SÁCH TÀI KHOẢN
	<table>
	<thead>
		<tr><td>Tên đăng nhập</td>
		<td>Mật khẩu</td>
		<td>Họ tên</td></tr>
	</thead>
	<tbody>
	<% 
		for(NguoiDung nd: arr){%>
		<tr><td><%=nd.getUsername()%></td>
		<td><%=nd.getPassword()%></td>
		<td><%=nd.getHoTen()%></td>
		<%request.setAttribute("username", nd.getUsername()); %>
		<td><a href="updateUser.jsp?username=${username}">Sửa</a></td>
		<td><a href="deleteUser.jsp?username=${username}" onclick="return confirm('Bạn có chắc chắn muốn xóa ?');">Xóa</a></td>
	<% }%>		
	</tbody>
	</table>
</body>
</html>