package naveen.mukesh.mnsa.ballzone;

import java.util.Random;

import android.app.Activity;

import android.os.Bundle;

import android.widget.TextView;

public class HighScore extends Activity {
static int i=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_score);
		TextView tv=(TextView) findViewById(R.id.textView1);
		
		
	}
}
