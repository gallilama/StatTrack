
/**
 * @author kylehoff
 * Enum for types of available attacks
 */
public enum AttackType {
	MELEE, RANGED, MAGIC;
	
	public static AttackType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
