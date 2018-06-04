import java.util.Scanner;

public class VirtualPetShelterApp {

	static Scanner scanner = new Scanner(System.in);

	static VirtualPet tui = new VirtualPet("Tui", "Is a cute little calico", 30, 30, 30);
	static VirtualPet ditch = new VirtualPet("Ditch", "Is as cunning as a shithouse rat", 10, 40, 15);
	static VirtualPet bluesy = new VirtualPet("Bluesy", "A black and tan mushy cat who loves snuggles", 5, 5, 5);
	static VirtualPet jazzy = new VirtualPet("Jazzy", "Grey tiger hunter who would be great in the barn", 15, 20, 25);
	static VirtualPet nigel = new VirtualPet("Nigel", "A big old ginger cat", 10, 10, 50);

	public static void main(String[] args) {
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Tui", tui);
		testPetShelter.addPet("Ditch", ditch);
		testPetShelter.addPet("Bluesy", bluesy);
		testPetShelter.addPet("Jazzy", jazzy);
		testPetShelter.addPet("Nigel", nigel);

		System.out.println("Welcome to the Pet Shelter!!!");
		VirtualPetShelterApp.petStatus(testPetShelter);
		String mainMenuSelection = mainMenu();
		while (!mainMenuSelection.equalsIgnoreCase("6")) {   // This is my game loop
			VirtualPetShelterApp.actOnUserSelection(mainMenuSelection, testPetShelter);
			mainMenuSelection = mainMenu();
		}
		System.out.println("Thanks for visiting our shelter!");
		scanner.close();
		System.exit(0);
	}

	private static void actOnUserSelection(String optionEntered, VirtualPetShelter testPetShelter) {
		if (optionEntered.equals("1")) {
			testPetShelter.feedAllPets();
			testPetShelter.tick();
			petStatus(testPetShelter);
		} else if (optionEntered.equals("2")) {
			testPetShelter.waterAllPets();
			testPetShelter.tick();
			petStatus(testPetShelter);
		} else if (optionEntered.equals("3")) {
			System.out.println("Which pet would you like to play with?");
			testPetShelter.playWithPet(scanner.nextLine());
			testPetShelter.tick();
			petStatus(testPetShelter);
		} else if (optionEntered.equals("4")) {
			System.out.println("Which pet would you like to adopt today?");
			testPetShelter.adoptPet(scanner.nextLine());
			testPetShelter.tick();
			petStatus(testPetShelter);
		} else if (optionEntered.equals("5")) {
			VirtualPet virtualPet = null;
			System.out.println("What's the pets name?");
			String petName = scanner.nextLine();
			System.out.println("Can you describe the pet please?");
			String description = scanner.nextLine();
			virtualPet = new VirtualPet(petName, description, 10, 10, 10);
			testPetShelter.addPet(petName, virtualPet);
			testPetShelter.tick();
			System.out.println("Thanks for giving us your pet!");
			petStatus(testPetShelter);
		} else {
			System.out.println("\nPlease try again!\n");
		}
	}

	public static String mainMenu() {
		System.out.println("\nWhat would you like to do today?");
		System.out.println("1. Feed the pets");
		System.out.println("2. Water the pets");
		System.out.println("3. Play with a pet");
		System.out.println("4. Adopt a pet");
		System.out.println("5. Give up a pet");
		System.out.println("6. Quit!");
		return scanner.nextLine();
	}

	private static void petStatus(VirtualPetShelter shelter) {
		System.out.println("\nHere's the latest info on our pets wellness . . . . .");
		System.out.println("-----------------------------------------------");
		System.out.println("Name \t|Hunger |Thirst |Happiness\t|Description ");
		System.out.println("-----------------------------------------------");
		for (VirtualPet pet : shelter.getVirtualPets()) {
			System.out.println(pet.name + "\t|" + pet.hunger + "\t|" + pet.thirst + "\t|" + pet.boredom + "\t\t|"
					+ pet.description);
		}
	}
}