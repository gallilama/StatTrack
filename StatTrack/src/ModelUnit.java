import java.util.ArrayList;
import java.util.Random;

/**
 * @author kylehoff
 * Class to Store a model or Unit's name, status, and attack pool
 */
public class ModelUnit {

	public String name = "Untitled";
	public String destroyedMessage = "The model is destroyed and cannot make attacks";
	public ArrayList<Attack> attacks = new ArrayList<Attack>();
	public boolean destroyed = false;
	public int meleeAttacks = 0;
	public int rangedAttacks = 0;
	public int magicAttacks = 0;
	public int minHitDieRolled = -1;
	public int maxHitDieRolled = -1;
	public int minDmgDieRolled = -1;
	public int maxDmgDieRolled = -1;
	
	
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
	 * Determine the minimum and maximum dice rolled to hit and to damage
	 * @param HDice number of dice rolled to hit
	 * @param hit if the model was hit or not
	 * @param DDice number of dice rolled to damage
	 */
	public void getMinMaxRolls(int HDice, boolean hit, int DDice){
		if(minHitDieRolled == -1)
			minHitDieRolled = HDice;
		else if(minHitDieRolled > HDice)
			minHitDieRolled = HDice;
		if(maxHitDieRolled == -1)
			maxHitDieRolled = HDice;
		else if(maxHitDieRolled < HDice)
			maxHitDieRolled = HDice;
		
		if(hit){
			if(minDmgDieRolled == -1)
				minDmgDieRolled = HDice;
			else if(minDmgDieRolled > HDice)
				minDmgDieRolled = HDice;
			if(maxDmgDieRolled == -1)
				maxDmgDieRolled = HDice;
			else if(maxDmgDieRolled < HDice)
				maxDmgDieRolled = HDice;
		}
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
		
		getMinMaxRolls(HDice, H, DDice);
		
		attacks.add(new Attack(AttackType.MELEE,BHit, HDice, HRoll, H,
				BDmg, DDice, DRoll, DDealt));
		meleeAttacks++;
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
		rangedAttacks++;
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
		magicAttacks++;
	}
	
	@Override
	public String toString() {
		String str = String.format("%-15s\n %-18s %-18s %-18s\n %-18d %-18d %-18d",
				name, "Melee Attacks", "Ranged Attacks", "Magic Attacks",
				meleeAttacks, rangedAttacks, magicAttacks);
		return str;
	}

	public static void main(String[] args){
		
		ModelUnit caster = new ModelUnit();
//		System.out.println(caster.name);
		System.out.println(caster);
		
		Random rand = new Random();
		
		for(int i = 0; i < 25; i++){
			boolean boostHit = rand.nextBoolean();
			int hitDice = rand.nextInt(1) + 2;
			if(boostHit)
				hitDice++;
			int hitRoll = rand.nextInt(hitDice * 6 - hitDice) + hitDice;
			boolean hit = rand.nextBoolean();
			boolean boostDmg = false;
			int dmgDice = 0;
			int dmgRoll = 0;
			int dmgDealt = 0;
			if(hit){
				boostDmg = rand.nextBoolean();
				dmgDice = rand.nextInt(2) + 2;
				if(boostDmg)
					dmgDice++;
				dmgRoll = rand.nextInt(dmgDice * 6 - dmgDice) + dmgDice + 1;
				dmgDealt = rand.nextInt(dmgDice * 6 - dmgDice) + dmgDice;
			}
			AttackType t = AttackType.getRandom();
			if(t.equals(AttackType.MELEE))
				caster.meleeAttack(boostHit, hitDice, hitRoll,
						hit, boostDmg, dmgDice, dmgRoll, dmgDealt);
			else if(t.equals(AttackType.RANGED))
				caster.rangedAttack(boostHit, hitDice, hitRoll,
						hit, boostDmg, dmgDice, dmgRoll, dmgDealt);
			else if(t.equals(AttackType.MAGIC))
				caster.magicAttack(boostHit, hitDice, hitRoll,
						hit, boostDmg, dmgDice, dmgRoll, dmgDealt);
		}
//		System.out.println(caster.meleeAttacks);
//		System.out.println(caster.rangedAttacks);
//		System.out.println(caster.magicAttacks);
		System.out.println(caster);
		caster.destroyed();
		caster.magicAttack(false, 2, 7, true, false, 2, 12, 16);
	}
}
