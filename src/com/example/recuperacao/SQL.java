package com.example.recuperacao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQL extends SQLiteOpenHelper {

	public static final String tbAvaliacao = "tbAvaliacao";

	public static final int versao = 1;

	public static final int BD_versao = 1;

	public static final String BD = "creat table usuario( id "
			+ "integer primary key autoincrement,"
			+ "avaliador text not null, titulo text not null"
			+ "nota text not null, comentario text not null)";

	public SQL(Context context) {
		super(context, tbAvaliacao, null, versao);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// db = data base
		db.execSQL(BD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
