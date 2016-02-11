import static org.junit.Assert.*;

import org.junit.*;

// Kyle, I think you're heading in the right direction.
// I've put some suggestions in Attack.java and testAttack.java.
// - Chris


// I think the standard name for this would be AttackTest, but I'm old and the standards may have changed.
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
    // see how i split this into 2 separate tests
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
	public void testCheckData_InvalidHitDice(){
    // Separating the hit-related tests from the dmg-related tests.

    // When I do negative testing, I often like to start from a valid state
    // I've hinted at using a funciton to help build valid Attack instances.
    Attack a = buildValidAttack();
    
    a.setHitDice(-100);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));

		a.setHitDice(-1);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));

		a.setHitDice(0);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));

    // You've got a lot of duplicate code in this test, and others that can easily be reduced.
    //
    // Create an array of hit dice values you want to test, e.g. [-100, -1, 0]
    // Loop over each element of the array:
    //     a.setHitDice(current_hit_dice_value)
    //     // I'd also put the current_hit_dice_value in your assert message so you know which failed.
    //     assertFalse("checkData should return false",
    //             a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
    //
    // Now you can test n-values without duplicating all the assertion code.
  }

  // you could add support for params here if you wanted.
  protected Attack buildValidAttack() {
    return new Attack(AttackType.MELEE, false, 2, 10, true, false, 2, 6, 2);
    // this assumes it's valid...may decide to check it.
  }

	@Test
	public void testCheckData_InvalidDmgDice(){
    // You can do a similar refactor in this test as above in testCheckData_InvalidHitDice 
		Attack a = new Attack(AttackType.MELEE, false, -100, 5, true, false, 2, 6, 2);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
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
    // same refactor to reduce all those duplicate assertFalse lines of code.
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
