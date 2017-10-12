<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
</head>
<body>

<form action="SearchAction">
	カード名<br>
	<select name="cardname">
	<option value="" label="" selected>
	<option value="Stalwart Aven" label="Stalwart Aven">
	<option value="Day_s Undoing" label="Day_s Undoing">
	<option value="Infernal Scarring" label="Infernal Scarring">
	</select><br>
	マナ・コスト<br>
	<select name="mana">
	<option value="" label="" selected>
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
	<br>
	カードタイプ<br>
	<select name="cardtype">
	<option value="" label="" selected>
	<option value="Creature" label="Creature">
	<option value="Spell" label="Spell">
	<option value="Support" label="Support">
	</select>
	<br>
	<br>
	<br>
	<br>
	<input type="submit" value="検索">

</form>

</body>
</html>