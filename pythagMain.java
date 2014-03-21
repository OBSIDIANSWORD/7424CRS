public class pythagMain {
	
	//I just need to copy this program, but replace it with the appropriate variable names in the assignment.
	
	public static void main (String args[]) {
		
		float x[] = {10, 12, 20, 25, 30};
		float y[] = {5, 3, 15, 5, 10};
		
		for (int i = 0; i < x.length; i++) {
			float currX = x[i];
			float currY = y[i];
			//The above is dereferencing in regards to arrays. I am taking the value at that location
			//and putting it into either currX or currY.
			
		for (int j = 0; j < x.length; j++) {
			float pointX;
			float pointY;
			
			pointX = x[j];
			pointY = y[j];
			
			float diffX = pointX - currX;
			float diffY = pointY - currY;
			
			//This is calculating pythagoras below.
			Math.sqrt(diffX * diffX + diffY * diffY);
			
			float distance = (float)Math.sqrt(diffX * diffX + diffY * diffY);
			
			
			
			System.out.println("("+currX+","+currY+")"+"("+pointX+","+pointY+")"+"distance="+distance);
		}
		}
	}

}
