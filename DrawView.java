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

	/* xCount is used for the circlesXArray in searching it for the purposes of collision detection.
	 * So, when xCount = 0;, we're accessing element nr. [0]'s data by de-referencing it.
	 */
	
	
	int xCount;

	float xPos = 0;

	float yPos = 0;
	
	/* These "tempStorage" array variables are used to ensure that the contents obtained by the 
	 * respective accessors, are not lost, immediately after being "gotten."
	 */
	
	float[] xCountTempStorage;
	
	float[] yCountTempStorage;

	float[] circlesArrayX = {30, 60, 120, 170, 220};

	float[] circlesArrayY = {30, 60, 120, 170, 220};


	float x = 0;

	float y = 0;

	float deltax[] = {SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT};

	float deltay[] = {SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT};
	
	public float[] getXCirclesArrayCoOrdinates(int xCount, int yCount) {
		
		
		float[] aFloatArray = new float[1];
		
		float[] xCountTempStorage = new float[5];
		
		for (int i = 0; i < xCountTempStorage.length; i++) {
			
			xCountTempStorage[i] = circlesArrayX[xCount];
			
			if (circlesArrayX[xCount] > circlesArrayY[yCount]) {
				
				deltax[i] = deltax[i] * -1;
				
			}
			
		}
		/* "aFloat" is only a temporary variable,
		 *  instituted to stop compile errors for the time being.
		 */
		return aFloatArray;
		
		/* Need to have an if statement in this accessor saying that if the distance of "X"[i] is 
		 * bigger than "Y"[i], then do something.
		 */

		//return aFloatArray; //However instead of aFloatArray[]
		//Return (instead) a result that makes them bounce off one another.
		
	}
	
	public float[] getYCirclesArrayCoOrdinates(int yCount, int xCount) {
		
		float aFloat = 0;
		float[] aFloatArray = new float[1];
		
		/* "aFloat" is only a temporary variable,
		 *  instituted to stop compile errors for the time being.
		 */
		
		float[] yCountTempStorage = new float[5];
		
		for (int i = 0; i < xCountTempStorage.length; i++) {
			yCountTempStorage[i] = circlesArrayY[yCount];
			
			//Should say "if circlesArrayY[yCount] < coOrdDistance && < RADIUS (of both circles).
			//then bounce the y co-ordinate ball away from the x co-ordinate ball.
			
			if (circlesArrayY[yCount] <  circlesArrayX[xCount]) {
			deltay[i] = deltay[i] * -1;
		}
		
	}
		
		return aFloatArray; //However instead of aFloatArray[]
		//Return (instead) a result that makes them bounce off one another.
}
	
	//Collision detection things begin below this line.
	
	public void pythagorasCollisionDetection() {
		
		for (int xCount = 0; xCount < circlesArrayX.length; xCount++) {
			
			//circlesArrayX[xCount].getXCirclesArrayCoOrdinates();
			
			//Need to return a float[] to stop the cannot invoke getxxx on float primitive,
			//because a float[] is an object, not a primitive.
		}
		
		for (int yCount = 0; yCount < circlesArrayY.length;yCount++) {
			
			//circlesArrayY[yCount].getYCirclesArrayCoOrdinates();
			
			//Need to return a float[] to stop the cannot invoke getxxx on float primitive,
			//because a float[] is an object, not a primitive.
		}
		
	}

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
			
			//Collision detection things begin below this line.
			
		}
		invalidate();
	}
	
	
		
		// boundary conditions
		
		// TODO alter code so that boundary checks take into consideration the RADIUS constant 
		
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
