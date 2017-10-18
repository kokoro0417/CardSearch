<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>
</head>
<body>
	<s:if test="message != ''">
		<s:property value="message"/><br><br>
	</s:if>

	<form action="StockAction">
		カード名(完全一致)<br>
<!-- 		<input type="text" name="cardname"> -->
		<select name="cardname">
				<option value="" selected="selected"></option>
				<option value="Stalwart Aven">Stalwart Aven</option>
				<option value="Day_s Undoing">Day_s Undoing</option>
				<option value="Infernal Scarring">Infernal Scarring</option>
				<option value="Avaricious Dragon">Avaricious Dragon</option>
				<option value="Gaea_s Revenge">Gaea_s Revenge</option>
				<option value="Thunderclap Wyvernn">Thunderclap Wyvern</option>
		</select>
		<input type="hidden" name="SearchCheck" value="1">
		<br>
		入荷数<br>
		<select name="add_stock">
		<option value="1" label="1" selected>
		<option value="2" label="2">
		<option value="3" label="3">
		<option value="4" label="4">
		<option value="5" label="5">
		</select>
		<br>
		<input type="submit" value="在庫追加">
	</form>
<br><br>
	<form action="CardAddAction">
		入荷カード名<br>
		<input type="text" name="cardname"><br>
		マナ・コスト<br>
		<select name="mana">
			<option value="6" label="6" selected>
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
		<input type="radio" name="color" value="Withe" checked="checked">Withe
		<input type="radio" name="color" value="Blue">Blue
		<input type="radio" name="color" value="Black">Black
		<input type="radio" name="color" value="Red">Red
		<input type="radio" name="color" value="Green">Green
		<input type="radio" name="color" value="Multi">Multi
		<input type="radio" name="color" value="Non Color">Non Color <br>
		カードタイプ<br>
		<input type="radio" name="cardtype" value="Creature" checked="checked">Creature
		<input type="radio" name="cardtype" value="Spell">Spell
		<input type="radio" name="cardtype" value="Support">Support<br>
		金額<br>
		<input type="text" name="price"><br>
		入荷数<br>
		<select name="card_stock">
			<option value="0" label="0" selected>
			<option value="1" label="1">
			<option value="2" label="2">
			<option value="3" label="3">
			<option value="4" label="4">
			<option value="5" label="5">
		</select><br>
		<input type="submit" value="新規追加">
	</form>
		<br><br>

	<s:form action="AdminPageChengeAction">
		<input type="hidden" name="chengeflag" value="1">
		<s:submit value="新商品追加"/>
	</s:form>
		<br><br>

	<s:form action="AdminPageChengeAction">
		<input type="hidden" name="chengeflag" value="2">
		<s:submit value="情報変更"/>
	</s:form>
	<br><br>

	<s:form action="LogoutAction">
		<s:submit value="戻る"/>
	</s:form>

</body>
</html>