import java.util.*;
public class StatTrackDriver {

	public static void main(String[] args){
		
		ArrayList<ArmyList> Lists = new ArrayList<ArmyList>();
		
		// Print opening messages
		System.out.println("Welcome to StatTrack!\n");
		System.out.println("B - Build an army list\n"
				+ "V - View army lists");

		Scanner scan = new Scanner(System.in);
		
		// If build lists option if selected
		if(scan.next().toUpperCase().equals("B")){
			System.out.println("Enter the name of this list.\n");
			String listName = scan.next();
			ArmyList list = new ArmyList(listName);
			String addModUnit = "y";
			while(addModUnit.equalsIgnoreCase("y")){
				System.out.println("Would you like to add a Model/Unit to this list?\n"
						+ "y = yes, n = no\n");
				addModUnit = scan.next();
				if(addModUnit.equalsIgnoreCase("n"))
					continue;
				
				System.out.println("Enter the name of the model or unit to add.\n");
				list.addModelUnit(scan.next());	
				System.out.println(list);
			}
		}
		// If view lists option is selected
		else if(scan.next().toUpperCase().equals("V")){
			for(ArmyList l: Lists){
				System.out.println(l.armyName);
			}
		}
	}
	
}
