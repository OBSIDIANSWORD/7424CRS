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
	
	float dispX; //The X co-ordinate the circle is seen at onscreen.
	
	float dispY; //The Y co-ordinate the circle is seen at onscreen.
	
	float currentX;
	
	float currentY;
	
	float currX; //The current "x" coordinate being used in the Pythagoras Theorem.
	
	float currY; //The current "y" coordinate being used in the Pythagoras Theorem.
	
	int xCount;

	float xPos = 0;

	float yPos = 0;
	
	/* These "tempStorage" array variables are used to ensure that the contents obtained by the 
	 * respective accessors, are not lost, immediately after being "gotten."
	 */
	

	/* The instance variables below are used for Part E, Challenge Question 1, in regards
	 * to random x and y coordinates. The numbers "One" "Two" and so forth correspond to the amount
	 * of positions available in circlesArrayX and circlesArrayY, respectively. There are five such
	 * positions in each array.
	 * 
	 */
	
	float randomXCoOrdinateOne;
	float randomXCoOrdinateTwo;
	float randomXCoOrdinateThree;
	float randomXCoOrdinateFour;
	float randomXCoOrdinateFive;
	
	float randomYCoOrdinateOne;
	float randomYCoOrdinateTwo;
	float randomYCoOrdinateThree;
	float randomYCoOrdinateFour;
	float randomYCoOrdinateFive;
	
	
	/*
	 * These two arrays below are NOT part of the challenge question. They're placed here,
	 * so that I can use the "randomX" and "randomY" variables just above this comment.
	 */
	
	float[] circlesArrayX = {randomXCoOrdinateOne, randomXCoOrdinateTwo, randomXCoOrdinateThree, randomXCoOrdinateFour, randomXCoOrdinateFive};

	float[] circlesArrayY = {randomYCoOrdinateOne, randomYCoOrdinateTwo, randomYCoOrdinateThree, randomYCoOrdinateFour, randomYCoOrdinateFive};
	
	/* End of Part E, Challenge Question 1 instance variables.
	 * 
	 */
	
	/* The instance variables below are for the Pythagorean Theorem to be used in this app. 
	 * 
	 */
	
	float xArrayPythagNumberA;

	float xArrayPythagNumberB;
	
	float xArrayAnswerC;
	
	/* The "pythagorasSquareRoot" variables refer to the result obtained by square rooting 
	 * "pythagorasSquareRootA" for the circlesXArray, 
	 *  and "pythagorasSquareRootB" for the circlesYArray respectively.
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
	
	
	/* The nested for loops below search through the x and y arrays, and compare their values with
	 * one another.
	 * 
	 */
	
	
	/* The method below seeds random x and y coordinates for the circles, and is a challenge question
	 * response.
	 * 
	 */
	public void seedRandomCircles() {

		randomXCoOrdinateOne = (float)(Math.random()* 180) + 1;
		randomXCoOrdinateTwo = (float)(Math.random()* 180) + 1;
		randomXCoOrdinateThree = (float)(Math.random()* 180) + 1;
		randomXCoOrdinateFour = (float)(Math.random()* 180) + 1;
		randomXCoOrdinateFive = (float)(Math.random()* 180) + 1;
		
		randomYCoOrdinateOne = (float)(Math.random()* 180) + 1;
		randomYCoOrdinateTwo = (float)(Math.random()* 180) + 1;
		randomYCoOrdinateThree = (float)(Math.random()* 180) + 1;
		randomYCoOrdinateFour = (float)(Math.random()* 180) + 1;
		randomYCoOrdinateFive = (float)(Math.random()* 180) + 1;

		for (int i = 0;  i < circlesArrayX.length; i++) {
		circlesArrayX[i] = randomXCoOrdinateOne;
		circlesArrayX[i] = randomXCoOrdinateTwo;
		circlesArrayX[i] = randomXCoOrdinateThree;
		circlesArrayX[i] = randomXCoOrdinateFour;
		circlesArrayX[i] = randomXCoOrdinateFive;
	
   }
		
		
		
	   for (int i = 0; i < circlesArrayY.length; i++) {
		   
		    circlesArrayY[i] = randomYCoOrdinateOne;
			circlesArrayY[i] = randomYCoOrdinateTwo;
			circlesArrayY[i] = randomYCoOrdinateThree;
			circlesArrayY[i] = randomYCoOrdinateFour;
			circlesArrayY[i] = randomYCoOrdinateFive;
		   
	   }
}
	
	/*
	 * This is "Part One" of Part C, where we have to search through both the x and y arrays.
	 */
	
	public void searchThroughArraysForValues() {
		for (int i = 0; i < circlesArrayX.length; i++) {
			 currentX = circlesArrayX[i];
			 currentY = circlesArrayY[i];
		for (int j = 0; j < circlesArrayX.length && j < circlesArrayX.length;  j++) {
			
			float dispX = currentX - circlesArrayX[j];
			float dispY = currentY - circlesArrayY[j];
		 }
		}
	}
	
	//Collision detection things begin below this line.
	
	public void pythagorasCollisionDetection() {
		
		/*
		 * These for loops correspond to Part C: "Use a nested for loop to..."
		 */
		
		
		
		/*
		 * The for loop below is "Part Two" of Part C. i.e. using Pythagoras to calculate the
		 * distance between each circle. Above this comment is "Part One".
		 */
		
		
		for (int count = 0; count < circlesArrayX.length; count++) {
			
			float currX = circlesArrayX[count];
			float currY = circlesArrayY[count];
			
			System.out.println("The value of 'currX' is: " + "and the value of 'currY' is: " + currY);
		}
		
		for (int k = 0; k < circlesArrayX.length; k++) {
			float pointX;
			float pointY;
			
			pointX = circlesArrayX[k];
			pointY = circlesArrayY[k];
			
			float diffX = pointX - currX;
			float diffY = pointY - currY;
			
			//This is calculating pythagoras below.
			Math.sqrt(diffX * diffX + diffY * diffY);
			
			float distance = (float)Math.sqrt(diffX * diffX + diffY * diffY);
		}	
			//Nest the x and y search loops. X comes before Y.
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
			
			//Collision detection things begin below this line.
			pythagorasCollisionDetection();
			
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
