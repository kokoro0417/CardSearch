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
<%-- 	<s:if test="message != ''">
		<h3><s:property value="message"/></h3>
	</s:if> --%>
	<div class="Sbox">
		<div class="textbox">
			<s:if test="SearchFlag">
			カード名：<s:property value="cardname"/><br>
			入庫数	：<s:property value="add_stock"/><br>
			<form action="StockAction"><input type="hidden" value="<s:property value='SearchFlag'/>"><input type="submit" value="OK"></form>　
			</s:if>
			<s:else>
				<s:property value="message" escape="false" /><br>
			</s:else>
			<form action="StockCansell"><input type="submit" value="キャンセル"></form>
		</div><br>
	</div>
</body>
</html>