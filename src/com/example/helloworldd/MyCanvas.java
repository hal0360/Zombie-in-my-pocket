package com.example.helloworldd;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class MyCanvas extends View {

	private int width;
	private int height;
	private Bitmap zom, bgr;
	private Context cc;
	private int n;

	public MyCanvas(Context c, AttributeSet attrs) {
		super(c, attrs);
        cc = c;
        zom = BitmapFactory.decodeResource(c.getResources(),R.drawable.imp);
		n = 0;
	}

	// override onSizeChanged
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		width = w;
		height = h;
		bgr = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(cc.getResources(),R.drawable.foyer), w, h, true);
	}

	// override onDraw
	@Override
	protected void onDraw(Canvas canvas) {
		int i;
		super.onDraw(canvas);
		canvas.drawBitmap(bgr, 0, 0, null);			
		for(i = 0; i < n; i++){
			canvas.drawBitmap(zom, 30 + i*80, 170, null);		
		}
	}

	public void changeCanvas(int r, int nn) {
		n = nn;
		bgr = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(cc.getResources(),r), width, height, true);
		invalidate();
	}
	
	public void zombie(){
		n = 0;
		invalidate();
	}

}


