<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SearchSuccess</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<s:if test="message != ''">
		<h3><s:property value="message"/></h3>
	</s:if>

	<s:iterator value="aryDTO">
		<br>
		<div class="Sbox">
			<img  src='<s:property value="imgurl"/>'><br>
			<div class="textbox">
				<s:property value="cardname"/>|
				<s:property value="cardtype"/>|
				<s:property value="mana"/>
			</div><br>
			<div class="textbox">
				<s:form action="BuyItemAction">
					<select name="count">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select>
					<s:submit value="購入" method="buy"/>
				</s:form>
			</div><br>
		</div>
		<br>
	</s:iterator>






</body>
</html>