<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート観覧画面</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
<form action="BuyItemAction">
	<table>
			<tr>
			<td>商品名</td>
			<td>個数</td>
			<td>金額</td>
			<td>合計金額</td>
		</tr>
		<s:iterator value="CartArray">
			<tr>
				<td><s:property value="cardname"/></td>
				<td><s:property value="count"/></td>
				<td><s:property value="price"/></td>
				<td><s:property value="total_price"/></td>
			</tr>
			</s:iterator>
	</table>
	<input type="submit" value="購入">
</form>


<form action="SearcHomeAction" target="_self">
	<input type="submit" value="戻る">
</form>

</body>
</html>