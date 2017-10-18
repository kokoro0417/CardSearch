<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カード追加確認画面</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
	<s:if test="message != ''">
		<h3><s:property value="message"/></h3>
	</s:if>
<div class="Sbox">
			<div class="textbox">
				カード名：<s:property value="cardname"/><br>
				色		：<s:property value="color"/><br>
				マナ	：<s:property value="mana"/><br>
				カード種：<s:property value="cardtype"/><br>
				価格	：<s:property value="price"/>円<br>
				在庫数	：<s:property value="card_stock"/><br>
				<form action="CardAddDoneAction"><input type="submit" value="OK"></form>　
				<form action="CardAddCansellAction"><input type="submit" value="キャンセル"></form>
			</div><br>
		</div>
</body>
</html>