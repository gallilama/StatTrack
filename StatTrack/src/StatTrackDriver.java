import java.util.*;
public class StatTrackDriver {

	Scanner scan = new Scanner(System.in);
	ArrayList<ArmyList> Lists = new ArrayList<ArmyList>();
	
	// CONSTRUCTORS
	
	public StatTrackDriver(){
		openingScreenView();
	}
	
	
	// METHODS
	
	public void openingScreenView(){
		System.out.println("StatTrack\n");
		System.out.println("B - Build an army list\n"
				+ "V - View army lists\n"
				+ "Q - Quit");
		
		String input = scan.next();
		
		if(input.equalsIgnoreCase("b"))
			listBuilderView();
		else if(input.equalsIgnoreCase("v"))
			viewListsView();
		else if(input.equalsIgnoreCase("q"))
			quit();
	}
	
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
		while(!addModUnit.equals("DONE")){
			list.addModelUnit(addModUnit);
			System.out.println(addModUnit);
			addModUnit = scan.nextLine();
		}
		openingScreenView();
	}
	
	public void viewListsView(){
		int index = 1;
		for(ArmyList l: Lists){
			System.out.println(index + " - " + l.armyName);
			index++;
		}
		index = scan.nextInt() - 1;
		armyView(index);
	}
	
	public void armyView(int index){
		
	}
	
	public void quit(){
		System.exit(0);
	}
	
	public static void main(String[] args){
		StatTrackDriver driver = new StatTrackDriver();
	}
	
}
