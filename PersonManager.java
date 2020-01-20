package homework6;
import java.io.Serializable;
import java.util.*;

public class PersonManager implements Serializable{
	public static void main(String[] args) {
		System.out.println("Starting... \n");
		boolean runProgram = true;
		PersonDataHashMap personMap = new PersonDataHashMap(new HashMap<String,Person>(),"");
		while (runProgram == true) {
			try {
				System.out.println("Menu:");
				System.out.println(" 	(I) - Import from File");
				System.out.println("	(A) - Add Person");
				System.out.println(" 	(R) - Remove Person");
				System.out.println(" 	(G) - Get Info on Person");
				System.out.println(" 	(P) - Print Table");
				System.out.println(" 	(S) - Sort");
				System.out.println(" 	(Q) - Quit");
				Scanner scan = new Scanner (System.in);
				System.out.println("Please select an option: ");
				String userChoice = scan.nextLine().substring(0,1);
				if (userChoice.compareTo("I")==0 || userChoice.compareTo("i")==0) {
					System.out.println("Please enter a location:");
					String l = scan.nextLine();
					personMap = personMap.buildFromFile(l);
					System.out.println("Loading...");
					System.out.println("Person data loaded successfully!");
				}
				if (userChoice.compareTo("A")==0 || userChoice.compareTo("a")==0) {
					System.out.println("Please enter the name of the person:");
					String name = scan.nextLine();
					System.out.println("Please enter the age:");
					int age = Integer.parseInt(scan.nextLine());
					System.out.println("Please enter the sex (M or F):");
					String sex = scan.nextLine().substring(0,1);
					System.out.println("Please enter the height (in inches):");
					double height = Double.parseDouble(scan.nextLine());
					System.out.println("Please enter the weight (in lbs):");
					double weight = Double.parseDouble(scan.nextLine());
					personMap.add(name, new Person(age,height,weight,name,sex));
					System.out.println(name + " has been added to the list!");
				}
				if (userChoice.compareTo("R")==0 || userChoice.compareTo("r")==0) {
					System.out.println("Please enter the name of the person:");
					String name = scan.nextLine();
					personMap.remove(name);
				}
				if (userChoice.compareTo("G")==0 || userChoice.compareTo("g")==0) {
					System.out.println("Please enter the name of the person:");
					String name = scan.nextLine();
					personMap.get(name);
				}
				if (userChoice.compareTo("P")==0 || userChoice.compareTo("p")==0) {
					personMap.printTable();
				}
				if (userChoice.compareTo("S")==0 || userChoice.compareTo("s")==0) {
					System.out.println("Please select by what:");
					System.out.println(" 	(N) - Name");
					System.out.println(" 	(W) - Weight");
					System.out.println(" 	(H) - Height");
					System.out.println("Choose an option:");
					String sortChoice = scan.nextLine().substring(0,1);
					personMap.sort(sortChoice);

				}
				if (userChoice.compareTo("Q")==0 || userChoice.compareTo("q")==0) {
					System.out.println("Sorry to see you go!");
					runProgram = false;
				}
			} catch (Exception e) {
				if (e.getMessage().compareTo("This person doesn't exist")==0) {
					System.out.println(e.getMessage());
				}
				else {
					System.out.println("The input you entered is incorrect. Please try again!");
				}
			}
		}
	}
}
