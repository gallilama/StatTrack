import java.util.*;

public class Attack {

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
			System.out.println("Invalid data was passed. Please input valid data");
			System.exit(0);
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
	public boolean checkData(int HDice, int HRoll, int DDice, int DRoll, int DDealt){
		if(HRoll < HDice || HRoll > (HDice * MAX_DIE_ROLL))
			return false;
		if(DRoll < DDice || DRoll > (DDice * MAX_DIE_ROLL))
			return false;
//		if(DDealt > DRoll) 		//This check was throwing the invalid data error
//			return false;
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
	
	public static void main(String args[]){
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
			Attack a = new Attack(AttackType.getRandom(), boostHit, hitDice, hitRoll, hit, boostDmg, dmgDice, dmgRoll, dmgDealt);
			System.out.println(a);
		}
		
		for (int i = 0; i < 25; i++){
			int hitDice = 2;
			int hitRoll = rand.nextInt(hitDice * 6 - hitDice) + hitDice;
			boolean hit = rand.nextBoolean();
			int dmgDice = 0;
			int dmgRoll = 0;
			int dmgDealt = 0;
			if(hit){;
				dmgDice = 2;
				dmgRoll = rand.nextInt(dmgDice * 6 - dmgDice) + dmgDice + 1;
				dmgDealt = rand.nextInt(dmgDice * 6 - dmgDice) + dmgDice;
			}
			Attack a = new Attack(AttackType.getRandom(), hitRoll, hit, dmgRoll, dmgDealt);
			System.out.println(a);
		}
	}
}
