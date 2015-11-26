package com.example.recuperacao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class MainActivity extends Activity {
	private Atributos atributos = new Atributos();
	private EditText nomeEt;
	private EditText tituloEt;
	private EditText notaEt;
	private EditText comentarioEt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button avaliar = (Button) findViewById(R.id.avaliar);
		Button consulta = (Button) findViewById(R.id.comitar);

		avaliar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				nomeEt = (EditText) findViewById(R.id.nome);
				tituloEt = (EditText) findViewById(R.id.titulo);
				notaEt = (EditText) findViewById(R.id.nota);
				comentarioEt = (EditText) findViewById(R.id.comentario);

				atributos.setNome(nomeEt.getText().toString());
				atributos.setTitulo(tituloEt.getText().toString());
				atributos.setNota(notaEt.getText().toString());
				atributos.setComentario(comentarioEt.getText().toString());

				DAO bd = new DAO(MainActivity.this);
				bd.inserir(atributos);

			}
		});
		consulta.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Notificacao();
			}
		});

	}

	protected void Notificacao() {

		DAO bd = new DAO(MainActivity.this);

		int notificationId = 001;

		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
				MainActivity.this)
				.setSmallIcon(R.drawable.ifpb)
				.setContentTitle("*Número de avaliações*")
				.setContentText("*Realizadas" + bd.consulta() + " avaliações!*");

		NotificationManagerCompat notificationManager = NotificationManagerCompat
				.from(MainActivity.this);

		notificationManager.notify(notificationId, notificationBuilder.build());

	}

}
