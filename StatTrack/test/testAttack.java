import static org.junit.Assert.*;

import org.junit.*;

public class testAttack {

	@Test
	public void testCheckData_ValidData(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 10, true, false, 2, 6, 2);
		assertTrue("checkData should return true",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
	}
	
	@Test
	public void testCheckData_InvalidHitAndDmgDice(){
		Attack a = new Attack(AttackType.MELEE, false, -100, 10, true, false, 2, 6, 2);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitDice(-1);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitDice(0);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitDice(1);
		a.setDmgDice(-100);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setDmgDice(-1);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setDmgDice(0);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
	}
	
	@Test
	public void testCheckData_InvalidHitRoll(){
		Attack a = new Attack(AttackType.MELEE, false, 2, -1, true, false, 2, 6, 2);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(0);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(1);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(13);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(20);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(100);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));		
	}
	
	@Test
	public void testCheckData_InvalidDmgRoll(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, -1, 2);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(0);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(1);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(13);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(20);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(100);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
	}
}
