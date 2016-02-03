import static org.junit.Assert.*;

import org.junit.*;


public class testAttack {

	@Test
	public void testCheckData() throws Exception {
		Attack a = new Attack(AttackType.MELEE, false, 2, 10, true, false, 2, 6, 2);
		assertTrue("checkData should return true",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
		a.setHitRoll(14);
		assertFalse("checkData should return false",
				a.checkData(a.hitDice, a.hitRoll, a.dmgDice, a.dmgRoll, a.dmgDealt));
	}
}
