package com.jcasey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View
{
	public static final int RADIUS = 25;
	public static final int DELTA = 4; // TODO change code below to use this constant

	//TODO alter these circle state variables so that they become array variables and hold state on multiple balls
	float x = 0;
	float y = 0;
	
	float deltax = 1;
	float deltay = 1;
	
	int width;
	int height;

	public DrawView(Context context)
	{
		super(context);
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO alter code so that we have multiple bouncing circles
		
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		
		canvas.drawCircle(x, y, RADIUS, paint);
		
		x = x + deltax;
		y = y + deltay;
		
		// boundary conditions
		
		// TODO alter code so that boundary checks take into consideration the RADIUS constant 
		
		if(x > width)
		{
			deltax = -1; // change increment value so that ball bounce off right wall
		}
		
		if(y > height)
		{
			deltay = -1; // change increment value so that ball bounces off bottom wall
		}
		
		// TODO develop other boundary conditions
		
		// force the screen to be redrawn
		invalidate();
	}
	
	// use the onSizeChanged method to keep track of the width and height of the screen
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		width = w;
		height = h;
		super.onSizeChanged(w, h, oldw, oldh);
	}
}