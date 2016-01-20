
/**
 * @author kylehoff
 * Class to generate statistics based off of Attack objects stored in the
 * ArmyList object
 */
public class GenStats {

	private final int dieSides = 6;
	
	// CONSTRUCTORS
	
	public GenStats(){}
	
	
	//METHODS
	
	public int genTotalDamageOutput(ModelUnit modUnit){
		int totDmg = 0;
		for(Attack a : modUnit.attacks){
			totDmg += a.dmgDealt;
		}
		return totDmg;
	}
	
	/**
	 * Generate an array of the number of occurrences of all possible hit rolls
	 * @param numDie the number of dice being rolled
	 * @param modUnit the ModelUnit object to track dice roll occurrences of
	 * @return An array of occurrences of hitRolls
	 */
	public int[] genHitRolls(int numDie, ModelUnit modUnit){
		int hitArray[] = new int[numDie * dieSides];
		
		// Go through all attacks made by a model/unit and count the
		// number of occurrences of a specific hit roll 
		for(Attack a: modUnit.attacks){
			if(a.hitRoll < numDie)
				continue;
			else
				hitArray[a.hitRoll]++;
		}
		return hitArray;
	}
	
	/**
	 * Generate an array of the number of occurrences of all possible damage rolls
	 * @param numDie the number of dice being rolled
	 * @param modUnit the ModelUnit object to track dice roll occurrences
	 * @return An array of occurrences of hitRolls
	 */
	public int[] genDmgRolls(int numDie, ModelUnit modUnit){
		int dmgArray[] = new int[numDie * dieSides];
		
		// Go through all attacks made by a model/unit and count the
		// number of occurrences of a specific dmg roll 
		for(Attack a: modUnit.attacks){
			if(a.dmgRoll < numDie)
				continue;
			else
				dmgArray[a.dmgRoll]++;
		}
		return dmgArray;
	}
	
}
