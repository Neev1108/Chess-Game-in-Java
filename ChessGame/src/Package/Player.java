package Package;

import java.util.List;


/**
* @author      Neeval Kumar
* 
*/
public class Player {
	/** Player Name 
	 */
	private String name;
	
	/**
	 * List of the players pieces, will get a set of 16 pieces
	 * @postcondition size() <= 16
	 */
	private List<Piece> pieces;
	
	
	/**
	 * Constructor for Player class
	 * @param name
	 * @precondition name < 32 characters
	 */ Player(String name){
			this.name = name;
		}
	 
	 
	/**
	 * Method to let a player do his/her turn. Will interact with game to do this.
	 *  
	 */
	 public void doTurn() 
	 {	
	 }
	 
	 /** Accessor and Mutator methods to get and set names 
	  * */
	 
	 public String getName() {
		 return this.name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 
	
	

}
