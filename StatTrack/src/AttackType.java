
public enum AttackType {
	MELEE, RANGE, MAGIC;
	
	public static AttackType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
