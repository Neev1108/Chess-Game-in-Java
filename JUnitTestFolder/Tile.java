package chess;

/** 
 * This class creates the 
 * tiles for the Chess Game 
 */

public class Tile {
	private int x;
	private int y;
	private String color;
	

		
	/** 
	 * The accessor method 
	 * to get the color of the tile
	 * @return Color of the tile
	 */
	public String getColor() 
    { 
        return this.color; 
    } 
	
	/** 
	 * The mutator method 
	 * to get the color of the tile
	 * @param color The Color of the tile
	 */
  
    public void setColor(String color) 
    { 
        this.color = color; 
    } 
    
    /** 
     * The accessor method 
	 * to get the X coordinate of the Tile
	 * @return X coordinate of the tile
	 */
    public int getX() 
    { 
        return this.x; 
    } 
   

    /**
     * The mutator method 
	 * to get the color of the tile
     * @param x The X coordinate passed to the method
     */
   
    public void setX(int x) 
    { 
        this.x = x; 
    } 
    
    /**
     *  The accessor method 
   	 * to get the y coordinate of the Tile
   	 * @return y coordinate of the tile
   	 */
    public int getY() 
    { 
        return this.y; 
    } 
  
    /**
     * The mutator method 
	 * to set the y coordinate of the tile
     * @param y The Y coordinate passed to the method
     */
    public void setY(int y) 
    { 
        this.y = y; 
    }
    /**
     * Method checks if the number of rows is equal to the number of columns
     * @param X1 The start row of the matrix
     * @param Y1 The start column of the matrix
     * @return The boolean value after checking the number of rows to the number of columns
     */
    public boolean isValid(int X1, int Y1) {
    	if(X1 != Y1)
            return false; //X and Y should always be equal
    	else
    		return true;
    	    	
    }

}
	

