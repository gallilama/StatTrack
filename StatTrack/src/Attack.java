import java.util.*;

/**
 * @author kylehoff
 * Class to store dice roll and specifc data for any type of attack
 */
public class Attack implements Comparable{

	public AttackType attackType;
	public boolean hit = false;				// Did this attack hit its target
	public boolean boostHit = false;		// Was this attack boosted to hit the target
	public int hitDice = 2;					// Number of dice rolled to hit target
	public int hitRoll = 0;					// Sum of the result of hitDice	
	public boolean boostDmg = false;		// Was this attack boosted to damage the target
	public int dmgDice = 2;					// Number of dice rolled to damage the target
	public int dmgRoll = 0;					// Sum of the result of dmgDice
	public int dmgDealt = 0;				// Damage dealt to target
	private final int MAX_DIE_ROLL = 6;		// Maximum roll for one die
	
	
	//CONSTRUCTORS
	
	public Attack(){}
	
	// Used for standard 2D6 attack roll and damage rolls
	public Attack(AttackType AType, int HRoll, boolean H, int DRoll, int DDealt){
		attackType = AType;
		hitRoll = HRoll;
		hit = H;
		dmgRoll = DRoll;
		dmgDealt = DDealt;
		
//		if(!checkData(hitDice, HRoll, dmgDice, DRoll, DDealt)){
//			System.out.println("Invalid data was passed. Please input valid data");
//			System.exit(0);
//		}
	}
	
	//Used for charge attacks, boosted attacks, and attack with additional dice
	public Attack(AttackType AType, boolean BHit, int HDice, int HRoll, boolean H,
			boolean BDmg, int DDice, int DRoll, int DDealt){
		
		if(!checkData(HDice, HRoll, DDice, DRoll, DDealt)){
			//throw new InvalidInputException("Invalid data was passed. Please input valid data");
//			System.out.println("Invalid data was passed. Please input valid data");
//			System.exit(0);
		}
			
		attackType = AType;
		boostHit = BHit;
		hitDice = HDice;
		hitRoll = HRoll;
		hit = H;
		boostDmg = BDmg;
		dmgDice = DDice;
		dmgRoll = DRoll;
		dmgDealt = DDealt;
	}

	
	//METHODS
	
	/**
	 * Verifies that the inputed data is valid based on dice math
	 * @param HDice number of dice rolled to hit
	 * @param HRoll sum of the result of HDice
	 * @param DDice number of dice rolled to damage
	 * @param DRoll sum of the result of DDice
	 * @param DDealt DRoll minus enemy model's armor value
	 * @return
	 */
  // I think you should reconsider this function's arguments.
  // This funciton is not a static funciton, you've put it in the Attack class, and it's operating
  // concepts that seem related to Attack attributes (e.g. Attack.hitDice).
  // Could it take no arguments, and look at the attributes of an actual instance of Attack?
  // 
  // Something doesn't feel right:
  // Attack a = new Attack(..);  // I create an object
  // a.setHitDice(2);            // I set object properties
  // a.checkData(a.hitDice, ..); // I then have to pass object properties back into itself...
  //
  // Versus
  // Attack a = new Attack(..);  // I create an object
  // a.setHitDice(2);            // I set object properties
  // a.checkData();              // checkData knows what object properties to use in its logic. 
	public boolean checkData(int HDice, int HRoll, int DDice, int DRoll, int DDealt){
		if(HRoll < 1 || DDice < 1)
			return false;
		if(HRoll < HDice || HRoll > (HDice * MAX_DIE_ROLL))
			return false;
		if(DRoll < DDice || DRoll > (DDice * MAX_DIE_ROLL))
			return false;
		return true;
	}
	
	public void setAttackType(AttackType a){
		attackType = a;
	}
	
	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public void setBoostHit(boolean boostHit) {
		this.boostHit = boostHit;
	}

	public void setHitDice(int hitDice) {
		this.hitDice = hitDice;
	}

	public void setHitRoll(int hitRoll) {
		this.hitRoll = hitRoll;
	}

	public void setBoostDmg(boolean boostDmg) {
		this.boostDmg = boostDmg;
	}

	public void setDmgDice(int dmgDice) {
		this.dmgDice = dmgDice;
	}

	public void setDmgRoll(int dmgRoll) {
		this.dmgRoll = dmgRoll;
	}

	public void setDmgDealt(int dmgDealt) {
		this.dmgDealt = dmgDealt;
	}

	@Override
	public String toString() {
		String str = String.format("%-10s %-10b %-9d %-9d  %-7b %-10b %-9d %-9d %-10d",
				attackType, boostHit, hitDice, hitRoll, hit, boostDmg, dmgDice, dmgRoll, dmgDealt);
	
		return str;
	}
	
	
	// MAIN for testing
	
  // You should replace this with Unit Tests, a separate class to run integration tests, or both.
	public static void main(String args[]) throws Exception{
		Random rand = new Random();
		
		ArrayList<Attack> attacks = new ArrayList<Attack>();

		
		for(int i = 0; i < 20; i++){
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
			Attack a = new Attack(AttackType.getRandom(), boostHit, hitDice, hitRoll, hit, boostDmg, dmgDice, dmgRoll, dmgDealt);
			attacks.add(a);
			//System.out.println(a);
		}
		
		
//		for (int i = 0; i < 7; i++){
//			int hitDice = 2;
//			int hitRoll = rand.nextInt(hitDice * 6 - hitDice) + hitDice;
//			boolean hit = rand.nextBoolean();
//			int dmgDice = 0;
//			int dmgRoll = 0;
//			int dmgDealt = 0;
//			if(hit){;
//				dmgDice = 2;
//				dmgRoll = rand.nextInt(dmgDice * 6 - dmgDice) + dmgDice + 1;
//				dmgDealt = rand.nextInt(dmgDice * 6 - dmgDice) + dmgDice;
//			}
//			Attack a = new Attack(AttackType.getRandom(), hitRoll, hit, dmgRoll, dmgDealt);
//			attacks.add(a);
//			//System.out.println(a);
//		}
		
		System.out.println(AttackType.MELEE.ordinal());
		System.out.println(AttackType.RANGED.ordinal());
		System.out.println(AttackType.MAGIC.ordinal());
		System.out.println();
		
		for(Attack a: attacks){
			System.out.println(a);
		}
		
		System.out.println();
		
		Collections.sort(attacks);
		
		for(Attack a: attacks){
			System.out.println(a);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attack other = (Attack) obj;
		if (attackType != other.attackType)
			return false;
		if (boostDmg != other.boostDmg)
			return false;
		if (boostHit != other.boostHit)
			return false;
		if (dmgDealt != other.dmgDealt)
			return false;
		if (dmgDice != other.dmgDice)
			return false;
		if (dmgRoll != other.dmgRoll)
			return false;
		if (hit != other.hit)
			return false;
		if (hitDice != other.hitDice)
			return false;
		if (hitRoll != other.hitRoll)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		Attack newAttack = (Attack) arg0;
		if(this.equals(newAttack))	// If equal
			return 0;
		
		// AttackType 1
		if(attackType.compareTo(newAttack.attackType) > 0)
			return -1;
		else if(attackType.compareTo(newAttack.attackType) < 0)
			return 1;
		// Hit 2
		if(!hit && newAttack.hit)
			return -1;
		else if(hit && !newAttack.hit)
			return 1;
		// HitDice 3
		if(hitDice < newAttack.hitDice)
			return -1;
		else if(hitDice > newAttack.hitDice)
			return 1;		
		// BoostHit 4
		if(!boostHit && newAttack.boostHit)
			return -1;
		else if(boostHit && !newAttack.boostHit)
			return 1;
		// HitRoll 5
		if(hitRoll < newAttack.hitRoll)
			return -1;
		else if (hitRoll > newAttack.hitRoll)
			return 1;
		// DmgDice 6
		if(dmgDice < newAttack.dmgDice)
			return -1;
		else if (dmgDice > newAttack.dmgDice)
			return 1;
		// BoostDmg 7
		if(!boostDmg && newAttack.boostDmg)
			return -1;
		else if(boostDmg && !newAttack.boostDmg)
			return 1;
		// DmgRoll 8
		if(dmgRoll < newAttack.dmgRoll)
			return -1;
		else if (dmgRoll > newAttack.dmgRoll)
			return 1;
		// DmgDealt 9
		if(dmgDealt < newAttack.dmgDealt)
			return -1;
		else if (dmgDealt > newAttack.dmgDealt)
			return 1;
		//Equal
		return 0;
	}
}
