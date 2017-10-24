package com.internousdev.cs.util;

public class SQLSupport {


	/**
	 * 検索条件 :比較値
	 *
	 */
	public String SearchCond_Comp(String Column,int SearchMode){
		//条件検索
		//カラム名 = 検索値：完全一致
		//カラム名 >= 数値：数値以上
		//カラム名 != 検索値：検索値でない
		//カラム名 like '検索値%'：前方一致
		//カラム名 like '%検索値'：後方一致
		//カラム名 like '%検索値%：部分一致'
		//カラム名 between 数値A and 数値B：数値A～数値B
		//カラム名 = 検索値 and カラム名 = 検索値：完全複数検索
		//カラム名 = 検索値 or カラム名 = 検索値：複数検索
		String Searchsql = "";
		if(Column.equals(null)||Column.equals("")){
		}else{
			String[] Ary = {Column};
			Searchsql = SearchCond_Comp(Ary,SearchMode);
		}

		return Searchsql;
	}

	/**
	 * 検索条件
	 *
	 */
	public String SearchCond_Comp(String[] Column,int SearchMode){
		//条件検索

		String[] col = Column;
		int ColLen = col.length;

		String Ssql ="";

		switch(SearchMode){
		case 1://カラム名 = 検索値：完全一致
			Ssql=PFSearch(col[0]);
		break;
		case 2://カラム名 = 検索値 and カラム名 = 検索値：完全複数検索
			for(int i=1;i<(ColLen);i++){
				Ssql = Ssql + PFSearch(col[i-1]) +" and";
			}
			Ssql = Ssql + PFSearch(col[ColLen-1]) + ")";
		break;
		case 3://カラム名 = 検索値 or カラム名 = 検索値：複数検索
			for(int i=1;i<(ColLen);i++){
				Ssql = Ssql + PFSearch(col[i-1]) +" or";
			}
			Ssql = Ssql + PFSearch(col[ColLen-1]) + ")";
		break;
		case 4://カラム名 >= 数値：数値以上
		break;
		case 5://カラム名 != 検索値：検索値でない
		break;
		case 6://カラム名 between 数値A and 数値B：数値A～数値B
		break;
		case 7://カラム名 like '検索値%'：前方一致
		break;
		case 8://カラム名 like '%検索値'：後方一致
		break;
		case 9://カラム名 like '%検索値%：部分一致'
		break;

		}


		return Ssql;
	}

	/**
	 * 内部処理用
	 * 完全一致検索文
	 */
	private String PFSearch(String Column){

		//条件検索
		//カラム名 = 検索値：完全一致
		String PFSsql =" "+Column +" = ?";
		return PFSsql;
	}


	/**
	 * 全検索
	 *
	 */
	public String SelectAll(String Table){
		//	テーブル名	カラム名
	String selAll = "SELECT * FROM " + Table ;

	//SELECT * FROM テーブル名：テーブル内全検索
	//SELECT カラム名... FROM テーブル名：指定カラムのみ全検索
	//SELECT * FROM テーブル名 WHERE 検索条件：検索条件にて検索

	return selAll;
	}


	/**
	 * 検索：指定カラム検索
	 *
	 */
	public String Select(String Table,String Column){
						//	テーブル名	カラム名
		String sel1sql ="";
		if(Column.equals(null) || Column.equals("")){
			sel1sql = SelectAll(Table);

		}else{
			String[] col ={Column};
			sel1sql = Select(Table,col);

			//SELECT * FROM テーブル名：テーブル内全検索
			//SELECT カラム名... FROM テーブル名：指定カラムのみ全検索
			//SELECT * FROM テーブル名 WHERE 検索条件：検索条件にて検索
		}

		return sel1sql;
	}


	/**
	 * 検索：指定カラム検索
	 *
	 */
	public String Select(String Table,String[] Column){
		//	テーブル名	カラム名
	String sel2sql= "";


	//SELECT * FROM テーブル名：テーブル内全検索
	//SELECT カラム名... FROM テーブル名：指定カラムのみ全検索
	//SELECT * FROM テーブル名 WHERE 検索条件：検索条件にて検索

	return sel2sql;
	}


	/**
	 * 検索オプション：並び替え
	 *
	 */
	public String SelectOrder(String Column){
		//	テーブル名	カラム名
	String selsql= "";


	//SELECT * FROM テーブル名：テーブル内全検索
	//SELECT カラム名... FROM テーブル名：指定カラムのみ全検索
	//SELECT * FROM テーブル名 WHERE 検索条件：検索条件にて検索

	//並び替えオプション
	//ORDER BY カラム名：指定カラムを軸に昇順
	//ORDER BY カラム名 DESC：指定カラムを軸に降順
	//LIMIT 数値：指定件数のみ表示
	//LIMIT 数値A,数値B：指定行から指定件数表示

	return selsql;
	}


	/**
	 * 検索オプション：集計
	 *
	 */
	public String SelectSum(String Table,String Column){
		//	テーブル名	カラム名
	String selsql= "";


	//SELECT * FROM テーブル名：テーブル内全検索
	//SELECT カラム名... FROM テーブル名：指定カラムのみ全検索
	//SELECT * FROM テーブル名 WHERE 検索条件：検索条件にて検索

	//集計オプション
	//SELECT COUNT(*) FROM テーブル名：データ件数
	//SELECT MAX(カラム名) FROM テーブル名：カラム内の最高値
	//SELECT SUM(カラム名) FROM テーブル名：カラム内の合計値
	//SELECT AVG(カラム名) FROM テーブル名：カラム内の平均値
	//SELECT カラム名A,AVG(カラム名B) FROM テーブル名 GROUP BY カラム名A：カラム名Aの要素ごとの平均値

	return selsql;
	}

	/**
	 * データ挿入：特定のカラムに入れる用
	 * @param Table：テーブル名
	 * @param Column：カラム名
	 * @param ElCount：要素数
	 * @return SQL文
	 */
	public String Insert(String Table,String Column){
		//	テーブル名	カラム名 要素数
		String[] col ={Column};
		String ins1sql = Insert(Table,col,1);

	return ins1sql;
	}

	/**
	 * データ挿入：特定のカラムに入れる用
	 * @param Table：テーブル名
	 * @param Column：カラム名が複数の場合は配列にして入れる
	 * @param ElCount：要素数
	 * @return SQL文
	 */
	public String Insert(String Table,String[] Column,int ElCount){
		//	テーブル名	カラム名 要素数

		String insArysql ="INSERT INTO " + Table + "(";

		String[] col = Column;
		int ColLen = col.length;
		if(ColLen < ElCount){
			ElCount = ColLen;
		}

		for(int i=1;i<(ColLen);i++){
			if(col[i-1].length()>0){
				insArysql = insArysql + " " + col[i-1];
			}
			if(col[i].length()>0 && (i != 1)){
				insArysql = insArysql + " ,";
			}

		}
		insArysql = insArysql + col[ColLen-1] + ")" + ValuesIn(ElCount);

		//INSERT INTO テーブル名(カラム名1,カラム名2....) VALUES(データ1,データ2....)：指定カラムに指定データ登録
		//INSERT INTO テーブル名 VALUES(データ1,データ2...)：全カラムにデータ登録
		//INSERT INTO テーブル名 VALUES(データ1,データ2...),(データ1,データ2...)...：一括登録

	return insArysql;
	}

	/**
	 * データ挿入：全てのカラムに入れる用
	 * @param Table：テーブル名
	 * @param ElCount：要素数
	 * @return SQL文
	 */
	public String InsertAllColumn(String Table,int ElCount){
		//	テーブル名	カラム名

		String insACsql ="INSERT INTO " + Table + ValuesIn(ElCount);

		//INSERT INTO テーブル名 VALUES(データ1,データ2...)：全カラムにデータ登録
		//INSERT INTO テーブル名 VALUES(データ1,データ2...),(データ1,データ2...)...：一括登録

	return insACsql;
	}

	/**
	 * 内部処理用
	 * 要素挿入
	 */
	private String ValuesIn(int ElCount){
		String ValSql = " VALUES(";
		for(int i=1;i<ElCount;i++){
			ValSql = ValSql + " ?, ";
		}
		ValSql = ValSql + " ?);";
		return ValSql;
	}

	public String Update(String Table,String Column){
		//	テーブル名	カラム名
		String updsql ="";

		//UPDATE テーブル名 SET カラム名 = 要素.... WHERE 検索条件；

	return updsql;
	}

	public String Update(String Table,String[] Column){
		//	テーブル名	カラム名
		String updsql ="";

		//UPDATE テーブル名 SET カラム名 = 要素.... WHERE 検索条件；

	return updsql;
	}

	public String Delete(String Table,String Column){
		//	テーブル名	カラム名
		String sql= "";

		//DELETE FROM テーブル名：テーブル内データの削除
		//DELETE FROM テーブル名 WHERE 検索条件：検索条件に一致するものを削除

	return sql;
	}


}
