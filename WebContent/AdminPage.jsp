<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>
</head>
<body>

	<s:form action="AdminPageChengeAction">
		<input type="hidden" name="chengeflag" value="1">
		<s:submit value="新商品追加"/>
	</s:form>
		<br><br>

	<s:form action="AdminPageChengeAction">
		<input type="hidden" name="chengeflag" value="2">
		<s:submit value="情報変更"/>
	</s:form>
	<br><br>

	<s:form action="LogoutAction">
		<s:submit value="戻る"/>
	</s:form>

</body>
</html>