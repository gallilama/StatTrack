
public class ModelUnit {

	String name = "Untitled";
	Attack[] attacks = new Attack[50];
	
	
	// CONSTRUCTORS
	
	public ModelUnit(){}
	
	public ModelUnit(String name){
		this.name = name;
	}
	
	
	// METHODS
	
	/**
	 * Create a melee attack and add it to the attacks array
	 */
	public void meleeAttack(){
		
	}
	
	/**
	 * Create a ranged attack and add it to the attacks array
	 */
	public void rangedAttack(){
		
	}
	
	/**
	 * Create a magic attack and add it to the attacks array
	 */
	public void magicAttack(){
		
	}
	
	/**
	 * Double the size of the attacks array
	 */
	private void doubleAttacks(){
		
	}
	
	/**
	 * Check to see if the attacks array is full
	 * @return true if the array is full
	 */
	private boolean isfull(){
		return false;
	}
}
