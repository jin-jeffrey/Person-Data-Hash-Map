package homework6;

public class Person {
	private int age;
	private double height,weight;
	private String name;
	private String gender;
	
	public Person(int a, double h, double w, String n, String g) {
		age = a;
		height = h;
		weight = w;
		name = n;
		gender = g;
	}

	//getters
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	
	//setters
	public void setAge(int a) {
		age = a;
	}
	public void setHeight(double h) {
		height = h;
	}
	public void setWeight(double w) {
		weight = w;
	}
	public void setName(String n) {
		name = n;
	}
	public void setGender(String g) {
		gender = g;
	}
	
	public String toString() { //CHANGE PRINTING TO TABULAR METHOD
		String heightString = ((int)getHeight())/12+" Feet "+((int)getHeight())%12+" Inches";
		if (getHeight()%12>=10) {
			heightString = ((int)getHeight())/12+" Feet "+((int)getHeight())%12+"Inches";
		}
		String weightString = getWeight()+" pounds";
		if (getWeight()<100) {
			weightString=" "+getWeight()+" pounds";
		}
		String nameString = getName();
		if (getName().length()<5) {
			nameString=" "+getName()+" ";
		}
		return String.format("|        %5s        |%5s    |%5s    |  %5s  |  %5s  ", nameString, getAge(), getGender(), heightString, weightString);
	}
}
