import static org.junit.Assert.*;

import org.junit.*;

public class testAttack {

	// Test checkData Method
	
	@Test
	public void testCheckData_ValidData(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 10, true, false, 2, 6, 2);
		assertTrue("checkData should return true",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
	}
	
	@Test
	public void testCheckData_InvalidHitAndDmgDice(){
		Attack a = new Attack(AttackType.MELEE, false, -100, 5, true, false, 2, 6, 2);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitDice(-1);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitDice(0);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitDice(2);
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
		Attack a = new Attack(AttackType.MELEE, false, -1, 6, true, false, 2, 6, 2);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setDmgRoll(0);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setDmgRoll(1);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setDmgRoll(13);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setDmgRoll(20);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setDmgRoll(100);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
	}
	
	// Test equals method
	
	@Test
	public void testEquals_EqualAndNotEqual(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		assertTrue(a.equals(b));
		b.setAttackType(AttackType.RANGED);
		assertFalse(a.equals(b));
		
	}
	
	// Test compareTo method
	
	// Less than
	
	@Test
	public void testCompareTo_LessThan_AttackTye(){
		Attack a = new Attack(AttackType.RANGED, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}

	@Test
	public void testCompareTo_LessThan_BoostHit(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, true, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	@Test
	public void testCompareTo_LessThan_HitDice(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 3, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	@Test
	public void testCompareTo_LessThan_HitRoll(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 8, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	@Test
	public void testCompareTo_LessThan_Hit(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, false, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 8, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	@Test
	public void testCompareTo_LessThan_BoostDmg(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 8, true, true, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	@Test
	public void testCompareTo_LessThan_DmgDice(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 3, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	@Test
	public void testCompareTo_LessThan_DmgRoll(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 8, 2);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	public void testCompareTo_LessThan_DmgDealt(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 6);
		int result = a.compareTo(b);
		assertEquals(result, -1);
	}
	
	// Greater than
	
	@Test
	public void testCompareTo_GreaterThan_AttackTye(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MAGIC, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}

	@Test
	public void testCompareTo_GreaterThan_BoostHit(){
		Attack a = new Attack(AttackType.MELEE, true, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	@Test
	public void testCompareTo_GreaterThan_HitDice(){
		Attack a = new Attack(AttackType.MELEE, false, 3, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	@Test
	public void testCompareTo_GreaterThan_HitRoll(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 8, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	@Test
	public void testCompareTo_GreaterThan_Hit(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, false, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	@Test
	public void testCompareTo_GreaterThan_BoostDmg(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, true, 2, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	@Test
	public void testCompareTo_GreaterThan_DmgDice(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 3, 6, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	@Test
	public void testCompareTo_GreaterThan_DmgRoll(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 8, 2);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 2);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	public void testCompareTo_GreaterThan_DmgDealt(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 8);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 6);
		int result = a.compareTo(b);
		assertEquals(result, 1);
	}
	
	//Equals
	
	@Test
	public void testCompareTo_Equal(){
		Attack a = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 6);
		Attack b = new Attack(AttackType.MELEE, false, 2, 6, true, false, 2, 6, 6);
		int result = a.compareTo(b);
		assertEquals(result, 0);
		}
	
}
