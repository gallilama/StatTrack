
/**
 * @author kylehoff
 * Enum for types of available attacks
 */
public enum AttackType {
	MAGIC, RANGED, MELEE;
	
	public static AttackType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
