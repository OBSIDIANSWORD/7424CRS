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
	
	/* The instance variables below are for the Pythagorean Theorem to be used in this app. 
	 * 
	 */
	
	float xArrayPythagNumberA;

	float xArrayPythagNumberB;
	
	float xArrayAnswerC;
	
	/* The "pythagorasSquareRoot" variables refer to the result obtained by square rooting 
	 * "pythagorasSquareRootA" and "pythagorasSquareRootB" respectively.
	 * 
	 */
	
	/* "pythagorasSquareRootA" and "pythagorasSquareRootB" are doubles, because Math.sqrt only
	 * outputs doubles as the product of the calculation, not floats, unless specifically casted for.
	 * Furthermore, in this instance, we do not want the result to be casted from a double to a float
	 * for reasons of avoiding imprecision.
	 * 
	 */
	double pythagorasSquareRootA;
	
	double pythagorasSquareRootB;

	float yArrayPythagNumberA;

	float yArrayPythagNumberB;

	float yArrayAnswerC;
	
	//End of Pythagorean Theorem Variables.


	float x = 0;

	float y = 0;

	float deltax[] = {SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT};

	float deltay[] = {SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT, -SPEED_FLOAT, SPEED_FLOAT};
	
	public float[] getXCirclesArrayCoOrdinates(int xCount, int yCount) {
		
		
		float[] aFloatArray = new float[1];
		
		float[] xCountTempStorage = new float[5];
		
		for (int i = 0; i < xCountTempStorage.length; i++) {
			
			xCountTempStorage[i] = circlesArrayX[xCount];
				
				pythagorasCollisionDetection();
				
			}
			
		/* "aFloat" is only a temporary variable,
		 *  instituted to stop compile errors for the time being.
		 */
		return xCountTempStorage[i];
	}
		
		/* Need to have an if statement in this accessor saying that if the distance of "X"[i] is 
		 * bigger than "Y"[i], then do something.
		 */

		//return aFloatArray; //However instead of aFloatArray[]
		//Return (instead) a result that makes them bounce off one another.
	
	public float[] getYCirclesArrayCoOrdinates(int yCount, int xCount) {
		
		
		float[] yCountTempStorage = new float[5];
		
		for (int i = 0; i < yCountTempStorage.length; i++) {
			yCountTempStorage[i] = circlesArrayY[yCount];
			
			//Should say "if circlesArrayY[yCount] < coOrdDistance && < RADIUS (of both circles).
			//then bounce the y co-ordinate ball away from the x co-ordinate ball.
			
			if (circlesArrayY[yCount] <  circlesArrayX[xCount]) {
			deltay[i] = deltay[i] * -1;
		}
		
	}
		
		return yCountTempStorage[i]; //However instead of aFloatArray[]
		//Return (instead) a result that makes them bounce off one another.
}
	
	//Collision detection things begin below this line.
	
	public void pythagorasCollisionDetection() {
		
		/*
		 * These for loops correspond to Part C: "Use a nested for loop to..."
		 */
		
		for (int i = 0; i < circlesArrayX.length && i < circlesArrayY.length; i++) {
			
			circlesArrayX.getXCirclesArrayCoOrdinates();
			circlesArrayY.getYCirclesArrayCoOrdinates();
		
		
		/*
		 * The for loop below is "Part Two" of Part C. i.e. using Pythagoras to calculate the
		 * distance between each circle. Above this comment is "Part One".
		 */
		
		
		for (int xCount = 0; xCount < circlesArrayX.length; xCount++) {
			
			xArrayPythagNumberA = circlesArrayX[xCount] * circlesArrayX[xCount];
			
			System.out.println("The value of xArrayPythagA is: " + xArrayPythagNumberA);
			
			xArrayPythagNumberB = circlesArrayX[xCount] * circlesArrayX[xCount];
			
			xArrayAnswerC = xArrayPythagNumberB + xArrayPythagNumberA;
			
			pythagorasSquareRootA = Math.sqrt(xArrayAnswerC);
			
			//Nest the x and y search loops. X comes before Y.
			
		for (int yCount = 0; yCount < circlesArrayY.length; yCount++) {
			
			yArrayPythagNumberA = circlesArrayY[yCount] * circlesArrayY[yCount];
			
			yArrayPythagNumberB = circlesArrayY[yCount] * circlesArrayY[yCount];
			
			yArrayAnswerC = yArrayPythagNumberB + yArrayPythagNumberA;
			
			pythagorasSquareRootB = Math.sqrt(yArrayAnswerC);
		}
	}		
}			
			
			/*The two sets of numbers should match.
			*If they don't something is wrong, and needs to be corrected.
			*If so, set "xCount" to "0" in between statement executions?
			*
			* i.e statement1;
			* 
			* xCount = 0;
			* 
			* statement2;  <---- Like this block of code.
			*
			*(the three lines above this one).
			*/
			
			System.out.println("The value of xArrayPythagB is: " + xArrayPythagNumberB);
			System.out.println("This text is here so I can see the value of xArrayPythagB via a breakpoint");
				
				for (int yCount = 0; yCount < circlesArrayY.length;yCount++) {
					
					//circlesArrayY[yCount].getYCirclesArrayCoOrdinates();
					
					//Need to return a float[] to stop the cannot invoke getxxx on float primitive,
					//because a float[] is an object, not a primitive.
			
		}
				//Check loop bracing to ensure proper operation!
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
			pythagorasCollisionDetection();
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
