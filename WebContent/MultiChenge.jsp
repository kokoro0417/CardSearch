<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品情報変更画面</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body class="BGC_Glay">
	<s:if test="message != ''">
		<s:property value="message" escape="false" /><br><br>
	</s:if>
	<form action="MultiChengeAction">
		<table border="1" class="ChengeForm">
		<tr><td>カード名:(在庫追加/情報変更/商品削除時必須)<br>
		<select name="cardname">
				<option value="" selected="selected"></option>
				<s:iterator value="aryDTO">
					<option value="<s:property value='cardname'/>"><s:property value="cardname"/></option>
				</s:iterator>
		</select>
		</td></tr>
		</table>
		<table border="1" class="ChengeForm">
		<tr><td>変更カード名:(追加時必須)<br>
		<input type="text" name="chenge_cardname">
		</td><td>マナ・コスト<br>
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
		</select>
		</td></tr>
		</table>
		<table border="1" class="ChengeForm">
		<tr><td>色<br>
		<input type="radio" name="color" value="Withe"><img class="manaimg" src="srcimg/manawhite.png">白
		<input type="radio" name="color" value="Blue"><img class="manaimg" src="srcimg/manablue.png">青
		<input type="radio" name="color" value="Black"><img class="manaimg" src="srcimg/manablack.png">黒
		<input type="radio" name="color" value="Red"><img class="manaimg" src="srcimg/manared.png">赤
		<input type="radio" name="color" value="Green"><img class="manaimg" src="srcimg/managreen.png">緑
		<input type="radio" name="color" value="Multi">多色
		<input type="radio" name="color" value="Non Color"><img class="manaimg" src="srcimg/manacolorless.png">無色
		</td></tr>
		</table>
		<table border="1" class="ChengeForm">
		<tr><td>カードタイプ<br>
		<input type="radio" name="cardtype" value="Creature">クリーチャー<br>
		<input type="radio" name="cardtype" value="Spell">呪文<br>
		<input type="radio" name="cardtype" value="Support">サポート
		</td><td>金額<br>
		<input type="text" name="price" value=0>
		</td><td>
		入荷数<br>
		<select name="add_stock">
			<option value="0" label="0" selected>
			<option value="1" label="1">
			<option value="2" label="2">
			<option value="3" label="3">
			<option value="4" label="4">
			<option value="5" label="5">
		</select>
		</td></tr>
		</table><br>

		<table border="1" class="ChengeForm">
		<tr><td>変更属性<br>
		<input type="radio" name="chenge_type" value=0 checked="checked">在庫追加　
		<input type="radio" name="chenge_type" value=1>情報変更<br>
		<input type="radio" name="chenge_type" value=2>商品追加　
		<input type="radio" name="chenge_type" value=3>商品削除
		</td><td><input type="submit" value="情報送信">
		</td></tr>
		</table>
	</form>

	<br><br>


	<s:form action="LogoutAction">
		<s:submit value="ログアウト"/>
	</s:form>

</body>
</html>