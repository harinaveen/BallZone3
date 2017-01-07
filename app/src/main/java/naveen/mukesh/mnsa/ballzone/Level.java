package naveen.mukesh.mnsa.ballzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Level extends Activity implements OnClickListener {
Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level);
		b1=(Button) findViewById(R.id.btn1);
		b2=(Button) findViewById(R.id.btn2);
		b3=(Button) findViewById(R.id.btn3);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		
	}
	
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btn1:
			Intent i1=new Intent(Level.this,Level1.class);
			startActivity(i1);
			
			break;

		case R.id.btn2:
			Intent i2=new Intent(Level.this,Level2.class);
			startActivity(i2);
			
			break;
		case R.id.btn3:
			Intent i3=new Intent(Level.this,Level2.class);
			startActivity(i3);
			break;
		}
	}
}
