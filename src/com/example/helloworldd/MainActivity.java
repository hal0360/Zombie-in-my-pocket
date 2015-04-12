package com.example.helloworldd;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private MyCanvas customCanvas;
	private game g;
	private TextView info, info1, att;
	private ImageView img;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
        g = new game();
		customCanvas = (MyCanvas) findViewById(R.id.nigger);
		info = (TextView) findViewById(R.id.info1);
		info1 = (TextView) findViewById(R.id.info2);
		att = (TextView) findViewById(R.id.textView1);
		img = (ImageView) findViewById(R.id.imageView1);
		img.setVisibility(View.INVISIBLE); 
	}

	public void north(View v) {
		
		if(g.go_north() && g.zombie() <= 0){
			
			img.setImageResource(g.draw_card());
			img.setVisibility(View.VISIBLE);
			customCanvas.changeCanvas(g.image(), g.zombie());
			info.setText("You are in " + g.name());
			
			info1.setText(g.zombie() + " zombies in this room");
						
			img.postDelayed(new Runnable() {
			        public void run() {
			        	img.setVisibility(View.INVISIBLE);        	
			        	
			    }
			}, 2000);
			
		}
		else{
			info1.setText("It has zombie or blocked");
		}
	}
	
	public void east(View v) {
		if(g.go_east() && g.zombie() <= 0){
			img.setImageResource(g.draw_card());
			img.setVisibility(View.VISIBLE);
			customCanvas.changeCanvas(g.image(), g.zombie());
			info.setText("You are in " + g.name());
			
			info1.setText(g.zombie() + " zombies in this room");
			img.postDelayed(new Runnable() {
			        public void run() {
			        	img.setVisibility(View.INVISIBLE);
			    }
			}, 2000);
		}
		else{
			info1.setText("It has zombie or blocked");
		}
	}
	
	public void west(View v) {
		if(g.go_west() && g.zombie() <= 0){
			img.setImageResource(g.draw_card());
			img.setVisibility(View.VISIBLE);
			customCanvas.changeCanvas(g.image(), g.zombie());
			info.setText("You are in " + g.name());
			
			info1.setText(g.zombie() + " zombies in this room");
			img.postDelayed(new Runnable() {
			        public void run() {
			        	img.setVisibility(View.INVISIBLE);
			    }
			}, 2000);
		}
		else{
			info1.setText("It has zombie or blocked");
		}
	}
	
	public void south(View v) {
		if(g.go_south() && g.zombie() <= 0){
			img.setImageResource(g.draw_card());
			img.setVisibility(View.VISIBLE);
			customCanvas.changeCanvas(g.image(), g.zombie());
			info.setText("You are in " + g.name());
			
			info1.setText(g.zombie() + " zombies in this room");
			img.postDelayed(new Runnable() {
			        public void run() {
			        	img.setVisibility(View.INVISIBLE);
			    }
			}, 2000);
		}
		else{
			info1.setText("It has zombie or blocked");
		}
	}
	
	public int attack(View v){
		if(g.zombie() == 0){
			info1.setText("No zombie to kill");
			return 1;
		}
		if(g.kill()){
			new AlertDialog.Builder(this)
	           .setMessage("You died. Game over")
	           .setCancelable(false)
	           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   finish();
	               }
	           })
	           .show();
		}
		else{
			att.setText("Health: " + g.hp());
			info1.setText("zombie defeated");
			
		}
		customCanvas.zombie();
		return 1;
	}
}
