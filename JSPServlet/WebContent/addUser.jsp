<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm tài khoản</title>
</head>
<body>
THÊM TÀI KHOẢN
<form action ="checkAddUser.jsp" method ="post">
Tên đăng nhập: <input type ="text" name ="username"><br>
Mật khẩu : <input type="password" name ="password"><br>
Họ tên: <input type ="text" name ="hoTen"><br>
<input type ="submit" value="Thêm">
</form>

</body>
</html>