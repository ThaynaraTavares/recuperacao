package com.example.recuperacao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class Splash extends Activity implements Runnable {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		
		Handler SplashScren = new Handler();
		SplashScren.postDelayed(Splash.this, 3000);
	}
	
	public void run(){
		startActivity(new Intent(Splash.this, MainActivity.class));
		finish();
	}

}