<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入履歴</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>

<s:if test="BuyHistryFlag">
	<br>
	<br>
	<table border="1">
		<tr>
			<td>商品名</td>
			<td>個数</td>
			<td>合計金額</td>
			<td>購入日時</td>
		</tr>
		<s:iterator value="BuyHistry">
			<tr>
				<td><s:property value="cardname"/></td>
				<td><s:property value="total_count"/></td>
				<td><s:property value="total_price"/></td>
				<td><s:property value="datetime"/></td>
			</tr>
		</s:iterator>

	</table>

</s:if>
<s:else>
	購入履歴がありません。
</s:else>
<br>
<br>

<form action="MypageAction">
	<input type="submit" value="マイページ">
</form>

</body>
</html>