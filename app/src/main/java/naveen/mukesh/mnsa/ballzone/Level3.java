package naveen.mukesh.mnsa.ballzone;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.RelativeLayout.LayoutParams;

public class Level3 extends Activity implements SensorEventListener {
	 SensorManager sm;
	 Sensor s;
     int i;
     int ww,wh;
	 PowerManager.WakeLock wl;
	 RelativeLayout rll;
	 ImageView iv,iv1;
	 LayoutParams nlp;
	 Rect r1,r2;
	 boolean cmp;
	Animation an;
	MediaPlayer mp;
	MediaPlayer mp1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level1);
		rll=(RelativeLayout) findViewById(R.id.rll);
		iv1=(ImageView) findViewById(R.id.img1);
		iv=(ImageView) findViewById(R.id.img2);
		sm=(SensorManager) getSystemService(SENSOR_SERVICE);
		s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		i=0;
		
		sm.registerListener(Level3.this,s,SensorManager.SENSOR_DELAY_NORMAL);
		//iv1.setImageResource(R.drawable.dangerb);
		//rll.addView(iv1);
		PowerManager pw=(PowerManager) getSystemService(POWER_SERVICE);
		 wl=pw.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "naveen");
		
		
		r1=new Rect();
		r2=new Rect();
		mp=MediaPlayer.create(Level3.this, R.raw.bomb);
		mp.setLooping(false);
		Bitmap b=BitmapFactory.decodeResource(getResources(), R.drawable.blueball);
		//rll.addView(iv1);
		RemoteViews rv=new RemoteViews(getPackageName(),R.id.imageView1);
		rv.setImageViewBitmap(R.id.rll,b );
		cmp=false;
	  
		 mp1=MediaPlayer.create(Level3.this,R.raw.flourish );
			mp1.start();
		iv1.setScaleType(ImageView.ScaleType.FIT_XY);
		
		nlp=new LayoutParams(90,95);

		nlp.setMargins(20, 0, 0, 0);
		iv1.setLayoutParams(nlp);
		
		
	
			TimerTask tt=new TimerTask() {
	
		public void run() {
			runOnUiThread(new  Runnable() {
				public void run() {
					
					Random ran=new Random();

						LayoutParams olp=(LayoutParams) iv1.getLayoutParams();
						LayoutParams nlp=new LayoutParams(olp.width,olp.height);
						int ny=olp.topMargin+10;
						int nx=olp.leftMargin;
						if (ny>=285) 
				{ny=0;
							rll.removeView(iv1);
							nx=ran.nextInt(200);
							
							
							
						mymethod();
						}
						
						nlp.setMargins(nx, ny, 0,0);
						iv1.setLayoutParams(nlp);
						
					
				
						}});
			
		}
	};
 final Timer t=new Timer();
t.scheduleAtFixedRate(tt, 0, 50);
}
public void mymethod(){
	 int a=0;
		 Random num=new Random();
		 a=num.nextInt(100);
	if (a>0&&a<=10) {
			iv1.setImageResource(R.drawable.bomb);
			cmp=true;
	}
		else if (a>10&&a<=20) {
			iv1.setImageResource(R.drawable.blueball);
			cmp=false;
		}
		else if (a>20&&a<=30) {
			iv1.setImageResource(R.drawable.choclateball);
			cmp=false;
		}
		else if (a>30&&a<=40) {
			iv1.setImageResource(R.drawable.greenball);
		     cmp=false;
			}
		else if (a>40&&a<=50) {
			iv1.setImageResource(R.drawable.seconddanger);
			cmp=true;
		
		}
		else if (a>50&&a<=60) {
			iv1.setImageResource(R.drawable.redball);
			cmp=false;
		}
		else if (a>60&&a<=70) {
			iv1.setImageResource(R.drawable.yelloball);
			cmp=false;
		}
		else if (a>70&&a<=80) {
			iv1.setImageResource(R.drawable.sky);
			cmp=false;
		}
		else if (a>80&&a<=90) {
			iv1.setImageResource(R.drawable.solid);
			cmp=false;
		}
		else {
		iv1.setImageResource(R.drawable.danger3);
					cmp=true;
		}
	rll.addView(iv1);
}


	public void onSensorChanged(SensorEvent ar) {
		int dx=10*(int) ar.values[0]+17;
		//int dy=(int) ar.values[1];
		wh=rll.getHeight()-rll.getPaddingBottom()-rll.getPaddingTop();
		ww=rll.getWidth()-rll.getPaddingLeft()-rll.getPaddingRight();
      LayoutParams olp=(LayoutParams) iv.getLayoutParams();
		LayoutParams nlp=new LayoutParams(olp.width,olp.height);
		int nx=olp.leftMargin-dx;
		//int ny=olp.topMargin+dy;
		if(nx<=-20){
			nx=-5;
		}
		else if (nx>=203) {
			nx=203;
		}

		nlp.setMargins(nx, 350, 0, 0);
		//nlp.setMargins(left, top, right, bottom);
		iv.setLayoutParams(nlp);
	//iv1.getResources();
	 iv1.getHitRect(r1);
			iv.getHitRect(r2);
		if(Rect.intersects(r1, r2)&&cmp){
			mp.start();
		sm.unregisterListener(Level3.this);
			Level3.this.finish();
		}
		else if (Rect.intersects(r1, r2)) {
			wl.acquire();
			i=i+1;;
		}
		else  {
			
			wl.acquire();
		}

	}
		
		
	

	public void onAccuracyChanged(Sensor arg0, int arg1) {
	}
public void onBackPressed() {
		
		AlertDialog.Builder adb=new AlertDialog.Builder(this);
		adb.setTitle("ARE YOU WANT TO EXIT GAME");
		adb.setMessage("YOU CAUGHT"+" "+  i  + "BALLS");
		
		
		adb.setPositiveButton("NO", new AlertDialog.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
			
				arg0.cancel();
				
				
			}
		});
		adb.setNegativeButton("YES",new AlertDialog.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				Level3.this.finish();
			
				
				
			}
		});
		AlertDialog ad=adb.create();
		ad.show();
		
	}
	protected void onStop() {
		mp.stop();
		mp1.stop();
		wl.release();
		sm.unregisterListener( Level3.this);
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		mp.stop();
		mp1.stop();
		sm.unregisterListener( Level3.this);
		super.onDestroy();
	}
	
	
}