<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SearchSuccess</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
	<s:if test="message != ''">
		<s:property value="message"/>
	</s:if>

	<s:iterator value="aryDTO">
		<br>
		<div class="Sbox">
			<s:form action="CartAddAction">
				<img class="cardimg" src='<s:property value="imgurl"/>'><br>
				<table class="Searchbox" border="1">
				<tr><td><s:property value="cardname"/></td></tr>
				</table>
				<table class="Searchbox" border="1">
				<tr><td><s:property value="color"/></td>
				<td><s:property value="mana"/>マナ</td>
				<td><s:property value="cardtype"/></td></tr>
				</table>
				<table class="Searchbox" border="1">
					<tr>
						<td><s:property value="price"/>円</td>
						<td>在庫：<s:property value="card_stock"/></td>

						<s:if test="card_stock > 0">
							<input type="hidden" value='<s:property value="cardname"/>' name="cardname">
							<input type="hidden" value='<s:property value="card_id"/>' name="card_id">
							<input type="hidden" value='<s:property value="price"/>' name="price">
							<td><select name="buycount">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
							</select><input type="submit" value="購入"></td>
						</s:if>

						<s:else>
							<td class="warning">在庫切れ</td>
						</s:else>
					</tr>
				</table><br>
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


</body>
</html>