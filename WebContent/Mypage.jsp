<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>マイページ画面ｓ</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
<s:property value="#session.now_user"/>さんのマイページ
<br>
<br>


<form action="BuyHistryAction">
	<input type="submit" value="購入履歴">
</form>

<br>
<br>


<form action="LogoutAction" target="_top">
	<input type="submit" value="ログアウト">
</form>

</body>
</html>