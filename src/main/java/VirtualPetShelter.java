import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	/*
	 * Create a main method that…
	 * 
	 * implements a game loop. asks for user input. writes output to the console.
	 * calls VirtualPetShelter's tick method after each interaction Available user
	 * interface actions should include (at minimum)… feeding all the pets watering
	 * all the pets playing with an individual pet, which should display a list of
	 * pet names and descriptions, allowing a user to select one allow adoption of a
	 * pet, which should display a list of pet names and descriptions, allowing a
	 * user to select one allow intake of a pet, prompting the user for the pet's
	 * information, requiring the user to (at minimum) specify name and description
	 * (Hint: you can use tab characters ("\t") to align console output in columns.)
	 */

	public Map<String, VirtualPet> virtualPets = new HashMap<String, VirtualPet>(); // Declared and Initialized an
																			// HashMap<String,VP> called virtualPets

	public VirtualPetShelter() {
	}

	public Collection<VirtualPet> getVirtualPets() {
		return virtualPets.values();
	}

	public void addPet(String name, VirtualPet virtualPet) {
		virtualPets.put(name, virtualPet);
	}

	public void adoptPet(String name) {
		ArrayList<String> petName = new ArrayList<String>();
		for (VirtualPet pet : getVirtualPets()) {
			petName.add(pet.name);
		}
		if (petName.contains(name)) {
			virtualPets.remove(name);
			System.out.println("\nYay, you adopted " + name);
		} else {
			System.out.println("\nName does not exist!");
		}
	}

	public void feedAllPets() {
		for (VirtualPet pet : virtualPets.values()) {
			pet.hunger -= 3;
		}
		System.out.println("\nThanks for feeding all the pets!");
	}

	public void waterAllPets() {
		for (VirtualPet pet : virtualPets.values()) {
			pet.thirst -= 2;
		}
		System.out.println("\nThanks for watering the pets!");
	}

	public void playWithPet(String name) {
		ArrayList<String> petName = new ArrayList<String>();
		for (VirtualPet pet : getVirtualPets()) {
			petName.add(pet.name);
		}
		if (petName.contains(name)) {
			virtualPets.get(name).boredom -= 4;
			System.out.println("\nYay, you played with " + name);
		} else {
			System.out.println("\nName does not exist! Select a name from the list!");
		}
	}

	public void tick() {
		for (VirtualPet pet : virtualPets.values()) {//go through each pet and call tick
			pet.tick();//I need to update values of each pet, I need a tick in VP
		}
	}
}
