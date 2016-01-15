import java.util.ArrayList;

/**
 * @author kylehoff
 * Class to Store a model or Unit's name, status, and attack pool
 */
public class ModelUnit {

	public String name = "Untitled";
	public String destroyedMessage = "The model is destroyed and cannot make attacks";
	public ArrayList<Attack> attacks = new ArrayList<Attack>();
	public boolean destroyed = false;
	
	
	// CONSTRUCTORS
	
	public ModelUnit(){}
	
	public ModelUnit(String name){
		this.name = name;
	}
	
	
	// METHODS
	
	/**
	 * Set the model's status to destroyed
	 */
	public void destroyed(){
		destroyed = true;
	}
	
	public boolean isDestroyed(){
		if(destroyed)
			return true;
		return false;
	}
	
	/**
	 * Create a melee attack and add it to the attacks arrayList
	 */
	public void meleeAttack(boolean BHit, int HDice, int HRoll,
			boolean H, boolean BDmg, int DDice, int DRoll, int DDealt){
		
		if(isDestroyed()){	//If destroyed print message and do not make attack
			System.out.println(destroyedMessage);
			return;
		}
		
		attacks.add(new Attack(AttackType.MELEE,BHit, HDice, HRoll, H,
				BDmg, DDice, DRoll, DDealt));
	}
	
	/**
	 * Create a ranged attack and add it to the attacks arrayList
	 */
	public void rangedAttack(boolean BHit, int HDice, int HRoll,
			boolean H, boolean BDmg, int DDice, int DRoll, int DDealt){
		
		if(isDestroyed()){	//If destroyed print message and do not make attack
			System.out.println(destroyedMessage);
			return;
		}
		
		attacks.add(new Attack(AttackType.RANGED,BHit, HDice, HRoll, H,
				BDmg, DDice, DRoll, DDealt));
	}
	
	/**
	 * Create a magic attack and add it to the attacks arrayList
	 */
	public void magicAttack(boolean BHit, int HDice, int HRoll,
			boolean H, boolean BDmg, int DDice, int DRoll, int DDealt){
		
		if(isDestroyed()){	//If destroyed print message and do not make attack
			System.out.println(destroyedMessage);
			return;
		}
		
		attacks.add(new Attack(AttackType.MAGIC,BHit, HDice, HRoll, H,
				BDmg, DDice, DRoll, DDealt));
	}
}
