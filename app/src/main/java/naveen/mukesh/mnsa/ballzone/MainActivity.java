package naveen.mukesh.mnsa.ballzone;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Timer t1 = new Timer();
		TimerTask tt = new TimerTask() {
			public void run() {
				Intent i1 = new Intent(MainActivity.this, One.class);
				startActivity(i1);
				MainActivity.this.finish();
			}
		};
		t1.schedule(tt, 1500);
	}
}
