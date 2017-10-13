<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入画面</title>
</head>
<body>
	<s:if test="bDTO.buyflag">
		<s:property value="message"/><br><br>
		<s:property value="cardname"/><br>
		<s:property value="price"/>円<br>
		<s:property value="buycount"/>枚購入<br>
		合計金額<s:property value="#session.total_price"/>円
	</s:if>
	<s:else>
		<s:property value="message"/>
	</s:else>

<br><br>


	<s:form action="HomeAction">
		<s:submit value="戻る"/>
	</s:form>
</body>
</html>