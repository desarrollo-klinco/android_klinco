package com.mx.klinco.android;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private long splashDelay = 6000; // variable con 6 segundos

	protected ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);

		//
		TimerTask task = new TimerTask() {
			@Override
			public void run() {

				Intent mainIntent = new Intent().setClass(MainActivity.this,
						MenuActivity.class);
				startActivity(mainIntent);
				finish();// Eliminamos la actividad de la Pila

			}
		};

		Timer timer = new Timer(); // Creamos objeto Timer
		timer.schedule(task, splashDelay);// En el schedule agregamos la tarea y
											// el tiempo
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

}
