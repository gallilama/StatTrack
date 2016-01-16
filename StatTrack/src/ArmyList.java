import java.util.ArrayList;

/**
 * @author kylehoff
 * Class to store multiple ModelUnit objects in an ArrayList and operate on
 *  the list.
 */
public class ArmyList {

	public String armyName = "Untitled";
	public ArrayList<ModelUnit> armyList = new ArrayList<ModelUnit>();
	
	
	// CONSTRUCTORS
	
	public ArmyList(){}
	
	public ArmyList(String armyName){
		this.armyName = armyName;
	}
	
	
	// METHODS
	
	public void addModelUnit(String modelUnitName){
		armyList.add(new ModelUnit(modelUnitName));
	}
	
	public void removeModelUnit(int index){
		armyList.remove(index);
	}
	
	public ModelUnit getModelUnit(int index){
		return armyList.get(index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((armyName == null) ? 0 : armyName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArmyList other = (ArmyList) obj;
		if (armyName == null) {
			if (other.armyName != null)
				return false;
		} else if (!armyName.equals(other.armyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String str = "";
		for(ModelUnit m: armyList){
			str += m.name + "\n";
		}
		return str;
	}
	
	public static void main(String[] args){
		ArmyList list = new ArmyList();
		list.addModelUnit("PStryker");
		list.addModelUnit("Storwall");
		list.addModelUnit("Lancer");
		list.addModelUnit("Boomhowlers");
		list.addModelUnit("Tempest Blazers");
		System.out.println(list);
	}
	
}
