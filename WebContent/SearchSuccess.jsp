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
			<s:form action="BuyItemAction">
				<img  src='<s:property value="imgurl"/>'><br>
				<div class="textbox">
					<s:property value="cardname"/>|
					<s:property value="price"/>円|
					在庫：<s:property value="card_stock"/>
				</div><br>
				<div class="textbox">
				<s:if test="card_stock > 0">
					<input type="hidden" value='<s:property value="cardname"/>' name="cardname">
					<input type="hidden" value='<s:property value="card_id"/>' name="card_id">
					<input type="hidden" value='<s:property value="price"/>' name="price">
					<select name="buycount">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select>
					<input type="submit" value="購入">

				</s:if>
				<s:else>
					在庫切れです。
				</s:else>
				</div><br>
			</s:form>
		</div>
		<br>
	</s:iterator>

	<br>
	<br>
	<br>
	<s:form action="SearcHomeAction">
		<s:submit value="戻る"/>
	</s:form>

	<s:form action="CartAddAction">
		<input type="submit" value="カートに入れる">
	</s:form>






</body>
</html>