<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カード追加確認画面</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div class="Sbox">
			<div class="textbox">
				<br>
				<s:if test="ChengeFlag">
				以下のカードを追加します。よろしければOKボタンを押してください。<br><br>
				<table border="1">
				<tr><td>カード名</td><td><s:property value="chenge_cardname"/></td></tr>
				<tr><td>色</td><td><s:property value="color"/></td></tr>
				<tr><td>マナ</td><td><s:property value="mana"/></td></tr>
				<tr><td>カード種</td><td><s:property value="cardtype"/></td></tr>
				<tr><td>価格</td><td><s:property value="price"/>円</td></tr>
				<tr><td>入荷数</td><td><s:property value="add_stock"/></td></tr>
				</table><br>
				<form action="InsertAction"><input type="hidden" value="<s:property value='SearchFlag'/>"><input type="submit" value="OK"></form>　
				</s:if>
				<s:else>
					<s:property value="message" escape="false" /><br>
				</s:else>
				<form action="InsertCansell"><input type="submit" value="キャンセル"></form>
			</div><br>
		</div>
</body>
</html>