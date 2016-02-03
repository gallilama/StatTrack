import java.util.*;
public class StatTrackDriver {

	Scanner scan = new Scanner(System.in);
	ArrayList<ArmyList> Lists = new ArrayList<ArmyList>();
	
	// CONSTRUCTORS
	
	public StatTrackDriver(){
		openingScreenView();
	}
	
	
	// METHODS
	
	/**
	 * Load up view for the application
	 */
	public void openingScreenView(){
		System.out.println("StatTrack\n");
		System.out.println("B - Build an army list\n"
				+ "V - View army lists\n"
				+ "Q - Quit");

		String input = scan.next();

		while(!input.equalsIgnoreCase("q")){	// while the input is not quit keep scanning items
			if(input.equalsIgnoreCase("b"))
				listBuilderView();
			else if(input.equalsIgnoreCase("v"))
				viewListsView();
			input = scan.next();
		}
	}
	
	/**
	 * List builder view for application
	 */
	public void listBuilderView(){
		System.out.println("Enter the name of this list.\n");
		String listName = scan.nextLine();
		listName = scan.nextLine();
		ArmyList list = new ArmyList(listName);
		Lists.add(list);
		String addModUnit = "";
		System.out.println("Add models and units to the list. Type \"Done\" to finish\n\n");
		addModUnit = scan.nextLine();
		System.out.println(list.armyName);
		while(!addModUnit.equalsIgnoreCase("DONE")){
			list.addModelUnit(addModUnit);
			System.out.println(addModUnit);
			addModUnit = scan.nextLine();
		}
		openingScreenView();
	}
	
	/**
	 * List viewer view
	 */
	public void viewListsView(){
		int index = 1;
		for(ArmyList l: Lists){
			System.out.println(index + " - " + l.armyName);
			index++;
		}
		index = scan.nextInt() - 1;
		armyView(index);
	}
	
	/**
	 * List view
	 * @param index the index of the list to view
	 */
	public void armyView(int index){
		
	}
	
	/**
	 * make attack view
	 * @param index the index of the ModelUnit making attacks
	 */
	public void attackView(int index){
		
	}
	
	/**
	 * Exit the system
	 */
	public void quit(){
		System.exit(0);
	}
	
	public static void main(String[] args){
		StatTrackDriver driver = new StatTrackDriver();
	}
	
}
