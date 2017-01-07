package naveen.mukesh.mnsa.ballzone;






import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class One extends Activity  {
	Button b1,b2,b3,b4;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent i1=new Intent(One.this,AboutGame.class);
				startActivity(i1);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				Intent i2=new Intent(One.this,Level.class);
				startActivity(i2);
			}
		});
		b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i3=new Intent(One.this,AboutUs.class);
				startActivity(i3);
			}
		});
		
	}
	
}
