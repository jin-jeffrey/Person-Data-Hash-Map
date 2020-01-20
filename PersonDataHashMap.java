package homework6;
import java.util.*;
import java.io.FileReader;
import java.util.Scanner;

public class PersonDataHashMap extends HeightComparator{
	private HashMap<String,Person> personMap;
	private String location;
	
	public PersonDataHashMap (HashMap h, String l) {
		personMap = h;
		location = l;
	}
	
	public void setHashMap(HashMap<String,Person> m) {
		personMap = m;
	}
	public void setLocation(String l) {
		location = l;
	}
	
	public HashMap getHashMap () {
		return personMap;
	}
	public String getLocation () {
		return location;
	}
	
	public PersonDataHashMap buildFromFile (String location) throws Exception {
		FileReader fr = new FileReader(location);
		Scanner scan = new Scanner (fr);
		scan.nextLine();
		String[] temp = new String[5];
		personMap = new HashMap<String,Person>();
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			temp = line.split(",");
			String name = "";
			String sex = "";
			int age = 0;
			double height = 0;
			double weight = 0;
			for (int i = 0; i<temp.length;i++) {
				String tempStr=temp[i].trim();
				tempStr=tempStr.replaceAll("^\"|\"$","");
				//set correct values to variables
				switch(i) {
				case 0: 
					name=tempStr;
					break;
				case 1:
					sex=tempStr;
					break;
				case 2:
					age=Integer.parseInt(tempStr);
					break;
				case 3: 
					height=Double.parseDouble(tempStr);
					break;
				case 4:
					weight=Double.parseDouble(tempStr);
					break;
				}
			}
			personMap.put(name, new Person(age,height,weight,name,sex));
			personMap.remove("");
		}
		PersonDataHashMap personHash = new PersonDataHashMap(personMap, location);
		return personHash;
	}
	
	public void add(String name, Person newPerson) throws Exception {
		if (personMap.containsKey(name)) {
			throw new Exception ("This person already exists!");
		}
		else {
			personMap.put(name, newPerson);
		}
	}
	
	public void get (String name) throws Exception {
		if (!personMap.containsKey(name)) {
			throw new Exception ("This person doesn't exist");
		}
		else {
			String heightString = ((int)(personMap.get(name).getHeight())/12)+" Feet "+(int)(personMap.get(name).getHeight())%12+" Inches";
			if (personMap.get(name).getHeight()%12>=10) {
				heightString = ((int)personMap.get(name).getHeight())/12+" Feet "+((int)personMap.get(name).getHeight())%12+"Inches";
			}
			String weightString = personMap.get(name).getWeight()+" pounds";
			if (personMap.get(name).getWeight()<100) {
				weightString=personMap.get(name).getWeight()+" pounds";
			}
			System.out.println(personMap.get(name).getName() + " is a " + personMap.get(name).getAge() + " who is " + heightString + " and weighs " + weightString + ".");
		}
	}
	
	public void remove (String name) throws Exception {
		if (!personMap.containsKey(name)) {
			throw new Exception ("This person doesn't exist");
		}
		else {
			personMap.remove(name);
			System.out.println("This person has been removed.");
		}
	}

	public void printTable () {
		System.out.format("|        %5s         | %5s   |  %5s |      %5s       |    %5s   \n", "Name","Age","Gender","Height","Weight");
		System.out.println("===============================================================================");
		for (String k:personMap.keySet()) {
			System.out.println(personMap.get(k).toString());
		}
	}
	
	public void sort (String choice) {
		if (choice.compareTo("H")==0 || choice.compareTo("h") == 0) {
			ArrayList<Person> personList = new ArrayList<Person>();
			for (String x:personMap.keySet()) {
				personList.add(personMap.get(x));
			}
			for (int y=0;y<personList.size()-1;y++) {
				for (int y1=0;y1<personList.size()-1;y1++) {
					if (personList.get(y1).getHeight()>personList.get(y1+1).getHeight()) {
						Person temp = personList.get(y1);
						personList.set(y1,personList.get(y1+1));
						personList.set(y1+1, temp);
						y1-=1;
					}
				}
			}
			System.out.format("|        %5s         | %5s   |  %5s |      %5s       |    %5s   \n", "Name","Age","Gender","Height","Weight");
			System.out.println("===============================================================================");
			for (int z=0;z<personList.size();z++) {
				System.out.println(personList.get(z).toString());
			}
		}
		else if (choice.compareTo("W")==0 || choice.compareTo("w") == 0) {
			ArrayList<Person> personList = new ArrayList<Person>();
			for (String x:personMap.keySet()) {
				personList.add(personMap.get(x));
			}
			for (int y=0;y<personList.size()-1;y++) {
				for (int y1=0;y1<personList.size()-1;y1++) {
					if (personList.get(y1).getWeight()>personList.get(y1+1).getWeight()) {
						Person temp = personList.get(y1);
						personList.set(y1,personList.get(y1+1));
						personList.set(y1+1, temp);
						y1-=1;
					}
				}
			}
			System.out.format("|        %5s         | %5s   |  %5s |      %5s       |    %5s   \n", "Name","Age","Gender","Height","Weight");
			System.out.println("===============================================================================");
			for (int z=0;z<personList.size();z++) {
				System.out.println(personList.get(z).toString());
			}
		}
		else if (choice.compareTo("N")==0 || choice.compareTo("n") == 0) {
			ArrayList<Person> personList = new ArrayList<Person>();
			for (String x:personMap.keySet()) {
				personList.add(personMap.get(x));
			}
			for (int y=0;y<personList.size()-1;y++) {
				for (int y1=0;y1<personList.size()-1;y1++) {
					if (personList.get(y1).getName().compareTo(personList.get(y1+1).getName())>0) {
						Person temp = personList.get(y1);
						personList.set(y1,personList.get(y1+1));
						personList.set(y1+1, temp);
						y1-=1;
					}
				}
			}
			System.out.format("|        %5s         | %5s   |  %5s |      %5s       |    %5s   \n", "Name","Age","Gender","Height","Weight");
			System.out.println("===============================================================================");
			for (int z=0;z<personList.size();z++) {
				System.out.println(personList.get(z).toString());
			}
		}
		else {
			System.out.println("Please double check your choice for sorting!");
		}
	}
}
