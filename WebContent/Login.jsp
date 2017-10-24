<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ログイン画面</title>
	</head>
	<body>
		<form action="LoginAction">
			<input type="hidden" value=0 name="user_type">
				ユーザーID<br>
			<input type="text" name="user_id"><br>
				PASS<br>
			<input type="password" name="password"><br>
			<input type="submit" value="会員ログイン">
		</form>
		<form action="LoginAction">
			<input type="hidden" value=0 name="user_type">
			<input type="hidden" value="taro" name="user_id">
			<input type="hidden" value="123" name="password">
			<input type="submit" value="taro">
		</form>
		<form action="LoginAction">
			<input type="hidden" value=0 name="user_type">
			<input type="hidden" value="jiro" name="user_id">
			<input type="hidden" value="456" name="password">
			<input type="submit" value="jiro">
		</form>
		<form action="LoginAction">
			<input type="hidden" value=0 name="user_type">
			<input type="hidden" value="hanako" name="user_id">
			<input type="hidden" value="789" name="password">
			<input type="submit" value="hanako">
		</form>
	<br>
	<br>

		<form action="LoginAction">
			<input type="hidden" value=1 name="user_type">
				管理者ID<br>
			<input type="text" name="user_id"><br>
				管理者PASS<br>
			<input type="password" name="password"><br>
			<input type="submit" value="管理者ログイン">
		</form>
		<form action="LoginAction">
			<input type="hidden" value=1 name="user_type">
			<input type="hidden" value="taro" name="user_id">
			<input type="hidden" value="123" name="password">
			<input type="submit" value="管理者taro">
		</form>


	<br>
	<br>
		<form action="TestAction">
			<input type="text" name="Table" value="carddata"><br>
			<input type="text" name="InsCol1" value="cardname">
			<input type="text" name="InsCol2" value="color">
			<input type="text" name="InsCol3" value="cardtype"><br>
			<select name="ElCount">
			<option value="1" label="1" selected>
			<option value="2" label="2">
			<option value="3" label="3">
			<option value="4" label="4">
			<option value="5" label="5">
		</select><br>
			<input type="submit" value="ActionTest">
		</form>
	</body>
</html>