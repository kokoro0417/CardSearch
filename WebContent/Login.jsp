<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet" href="css/Style.css">
</head>
<body class="BGC_Glay">
	<div class="hedder">カード検索システム</div><br>
	<div class="LoginFormBox">
		<form action="LoginAction">
			<input type="hidden" value=0 name="user_type">
				ユーザーID<br>
			<input type="text" name="user_id"><br>
				PASS<br>
			<input type="password" name="password"><br>
			<input type="submit" value="会員ログイン">
		</form>

	</div>
	<br>
	<br>

	<div class="LoginFormBox">
		<form action="LoginAction">
			<input type="hidden" value=1 name="user_type">
				管理者ID<br>
			<input type="text" name="user_id"><br>
				管理者PASS<br>
			<input type="password" name="password"><br>
			<input type="submit" value="管理者ログイン">
		</form>
	</div>
	<br>
	<br>
	<div class="AutoLoginButtonBox">
		<form action="LoginAction" class="ButtonCascade">
			<input type="hidden" value=0 name="user_type">
			<input type="hidden" value="taro" name="user_id">
			<input type="hidden" value="123" name="password">
			<input type="submit" value="taro">
		</form>
		<form action="LoginAction" class="ButtonCascade">
			<input type="hidden" value=0 name="user_type">
			<input type="hidden" value="jiro" name="user_id">
			<input type="hidden" value="456" name="password">
			<input type="submit" value="jiro">
		</form>
		<form action="LoginAction" class="ButtonCascade">
			<input type="hidden" value=0 name="user_type">
			<input type="hidden" value="hanako" name="user_id">
			<input type="hidden" value="789" name="password">
			<input type="submit" value="hanako">
		</form>
		<form action="LoginAction" class="ButtonCascade">
			<input type="hidden" value=1 name="user_type">
			<input type="hidden" value="taro" name="user_id">
			<input type="hidden" value="123" name="password">
			<input type="submit" value="管理者taro">
		</form>
	</div>
</body>
</html>