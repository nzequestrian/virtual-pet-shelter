
public class VirtualPet {

	public String name; // Class members (Instance variables) This is what I created with testPet.name = "Tui"
	public String description;
	public int hunger;
	public int boredom;
	public int thirst;

	public VirtualPet(String name, String description) { // Constructor with 2 string parameters
		this.name = name;
		this.description = description;
	}

	public VirtualPet(String name, String description, int hunger, int boredom, int thirst) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;    				// This is the 2nd constructor I made
		this.boredom = boredom;
		this.thirst = thirst;
	}

	public void tick() {
		this.hunger += 1;				// Finally a tick that works as it should
		this.boredom += 2;
		this.thirst += 3;
	}

	/*
	 * VirtualPet class In addition to the requirements from last week's project:
	 * include instance variables representing: name (from the above example, this
	 * might be "Tommy") description (from the above example, this might be
	 * "smells like a Stargazer lily fresh with morning dew") include a constructor
	 * that accepts a name and description include a constructor that, in addition
	 * to name and description, accepts default values for the pet's attributes
	 * (hunger, boredom, etc) Do not include a default (zero arguments) constructor.
	 */

}
