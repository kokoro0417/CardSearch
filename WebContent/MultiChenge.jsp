<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品情報変更画面</title>
</head>
<body>
	<s:if test="message != ''">
		<s:property value="message" escape="false" /><br><br>
	</s:if>
	<form action="MultiChengeAction">
		カード名:(在庫追加/情報変更/商品削除の場合必須項目)<br>
		<select name="cardname">
				<option value="" selected="selected"></option>
				<s:iterator value="aryDTO">
					<option value="<s:property value='cardname'/>"><s:property value="cardname"/></option>
				</s:iterator>
		</select><br>
		変更カード名:(商品追加の場合必須項目)<br>
		<input type="text" name="chenge_cardname"><br>
		マナ・コスト<br>
		<select name="mana">
			<option value=0 label="" selected>
			<option value="6" label="6">
			<option value="8" label="8">
			<option value="9" label="9">
			<option value="10" label="10">
			<option value="11" label="11">
			<option value="12" label="12">
			<option value="13" label="13">
			<option value="14" label="14">
			<option value="15" label="15">
			<option value="16" label="16">
		</select><br>
		色<br>
		<input type="radio" name="color" value="Withe">Withe
		<input type="radio" name="color" value="Blue">Blue
		<input type="radio" name="color" value="Black">Black
		<input type="radio" name="color" value="Red">Red
		<input type="radio" name="color" value="Green">Green
		<input type="radio" name="color" value="Multi">Multi
		<input type="radio" name="color" value="Non Color">Non Color <br>
		カードタイプ<br>
		<input type="radio" name="cardtype" value="Creature">Creature
		<input type="radio" name="cardtype" value="Spell">Spell
		<input type="radio" name="cardtype" value="Support">Support<br>
		金額<br>
		<input type="text" name="price" value=0><br>
		入荷数<br>
		<select name="add_stock">
			<option value="0" label="0" selected>
			<option value="1" label="1">
			<option value="2" label="2">
			<option value="3" label="3">
			<option value="4" label="4">
			<option value="5" label="5">
		</select><br>
		変更属性<br>
		<input type="radio" name="chenge_type" value=0 checked="checked">在庫追加　
		<input type="radio" name="chenge_type" value=1>情報変更　
		<input type="radio" name="chenge_type" value=2>商品追加
		<input type="radio" name="chenge_type" value=3>商品削除<br>
		<input type="submit" value="情報送信">
	</form>
	<br><br>


	<s:form action="LogoutAction">
		<s:submit value="ログアウト"/>
	</s:form>

</body>
</html>