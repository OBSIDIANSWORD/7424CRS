package com.jcasey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View
{
	public static final int RADIUS = 25;

	public static final int SPEED = 4; // TODO change code below to use this constant

	//This conversion is needed to prevent an error involving placing a float into a float*[]*.

	float SPEED_FLOAT = (float)SPEED;



	//TODO alter these circle state variables so that they become array variables and hold state on multiple balls


	int width;

	int height;


	float xPos = 0;

	float yPos = 0;


	float[] circlesArrayX = {30, 60, 120, 170, 220};

	float[] circlesArrayY = {30, 60, 120, 170, 220};


	float x = 0;

	float y = 0;

	float deltax[] = {SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT};

	float deltay[] = {SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT};

	public DrawView(Context context)

	{

	super(context);

	}


	@Override

	protected void onDraw(Canvas canvas)

	{

	// TODO alter code so that we have multiple bouncing circles


		for (int i = 0; i < circlesArrayX.length; i++) {
	
	
			Paint arrayPaint = new Paint();
		
			arrayPaint.setColor(Color.BLUE);
		
			canvas.drawCircle(circlesArrayX[i], circlesArrayY[i], RADIUS, arrayPaint);
		
			//The code below does this: Dereferences value from the array, and adds itself to itself i.e. itself + itself + deltax or deltay.
			circlesArrayX[i] = circlesArrayX[i] + deltax[i];
		
			circlesArrayY[i] = circlesArrayY[i] + deltay[i];
			
			if(circlesArrayX[i] > width || circlesArrayX[i] < 0)
				
				//So in the line below, this is what is happening: I am changing direction (moving away from wall) By adding negative speed, I keep
				//the speed value, but move in the opposite direction. In other words a positive * a negative = a negative, which is causing 
				//my balls to move away from the wall.
			{
				deltax[i] = deltax[i] * -1; // change increment value so that ball bounce off right wall
				
			}
			
			if(circlesArrayY[i] > height || circlesArrayY[i] < 0)
				
				//So in the line below, this is what is happening: I am changing direction (moving away from wall) By adding negative speed, I keep
				//the speed value, but move in the opposite direction. In other words a positive * a negative = a negative, which is causing 
				//my balls to move away from the wall.
			{
				deltay[i] = deltay[i] * -1; // change increment value so that ball bounce off right wall
				
			}
			
			//Is in invalidate() in the wrong place? The circles appear on screen but do not move (again..)
			
	
		}
		invalidate();
	}
	
		
		// boundary conditions
		
		// TODO alter code so that boundary checks take into consideration the RADIUS constant 
		
	
	//Move the condition below into the for loop above, below the first condition, when done.
		/*
		if(circlesArrayY[i] > height + RADIUS)
		{
			deltay = -deltay[i]; // change increment value so that ball bounces off bottom wall
		}
		*/
		// TODO develop other boundary conditions
		
		// force the screen to be redrawn.
	// use the onSizeChanged method to keep track of the width and height of the screen
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		width = w;
		height = h;
		super.onSizeChanged(w, h, oldw, oldh);
	}
}