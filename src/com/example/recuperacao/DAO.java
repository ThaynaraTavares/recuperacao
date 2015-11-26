package com.example.recuperacao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAO {
	private SQLiteDatabase bd;

	public DAO(Context context) {
		SQL auxBd = new SQL(context);
		bd = auxBd.getWritableDatabase();
	}

	public void inserir(Atributos Atributos) {

		ContentValues valores = new ContentValues();

		valores.put("nome", Atributos.getNome());
		valores.put("titulo", Atributos.getTitulo());
		valores.put("nota", Atributos.getNota());
		valores.put("comentario", Atributos.getComentario());
		bd.insert("tbAvaliacao", null, valores);

	}

	public int consulta() {
		String[] colunas = new String[] { "id" };

		Cursor cursor = bd.query("tbAvaliacao", colunas, null, null, null,
				null, "id");
		int tam = cursor.getCount();
		return tam;

	}

}
