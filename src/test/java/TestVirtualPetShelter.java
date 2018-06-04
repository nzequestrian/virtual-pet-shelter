import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestVirtualPetShelter {
	/*
	 * VirtualPetShelter class include appropriate instance variable(s) to store the
	 * pets who reside at the shelter include methods that: return a Collection of
	 * all of the pets in the shelter return a specific VirtualPet given its name
	 * allow intake of a homeless pet allow adoption of a homeless pet feed all of
	 * the pets in the shelter water all of the pets in the shelter plays (or
	 * performs some other interaction(s)) with an individual pet in the shelter
	 * include a tick method that calls the tick method for each of the pets in the
	 * shelter, updating their needs
	 */
	
	@Test
	public void testVirtualPetShelterExistsButIsNull() { // The first thing I need is a VPS class
		VirtualPetShelter testPetShelter = null;   		//  I got an error eclipse ask to create class
		Assert.assertNull(testPetShelter);				// I did not create a class instance so test was null
	}

	@Test
	public void testVirtualPetShelterExistsButIsNotNull() {  // I need to create instances of the class
		VirtualPetShelter testPetShelter = new VirtualPetShelter(); // I got an error because I didn't have a default constructor
		Assert.assertNotNull(testPetShelter);		// created it and now my object instance "testPetShelter" is not null
	}

	@Test
	public void testVirtualPetShelterHasACollectionOfVirtualPets() {  // I need a collection of pets
		VirtualPetShelter testPetShelter = new VirtualPetShelter();  

		Map<String, VirtualPet> virtualPets = new HashMap<String, VirtualPet>();  // I want a map of VP's
		// Map<Key, Value (instances of virtualPet)> - the key will be the name of pet, the key is assigned to the pets instance
		String pet1 = "Tui"; //this is my first key called "Tui"
		VirtualPet tui = new VirtualPet("Tui", "Is a cute little calico", 30, 30, 30);
		virtualPets.put(pet1, tui);

		String pet2 = "Ditch";
		VirtualPet ditch = new VirtualPet("Ditch", "Is as cunning as a shithouse rat", 10, 40, 15);
		virtualPets.put(pet2, ditch);

		String pet3 = "Blusey";
		VirtualPet bluesy = new VirtualPet("Bluesy", "A black and tan Main coon who is a mushy cat who loves snuggles",
				5, 5, 5);
		virtualPets.put(pet3, bluesy);

		String pet4 = "Jazzy";
		VirtualPet jazzy = new VirtualPet("Jazzy", "Grey tiger who hunter who who be great in the barn", 15, 20, 25);
		virtualPets.put(pet4, jazzy);

		String pet5 = "Nigel";
		VirtualPet nigel = new VirtualPet("Nigel", "A big old ginger cat", 10, 10, 50);
		virtualPets.put(pet5, nigel);

		// Moved the Map/HashMap below to the VirtualPetShelter
		// Map<String, VirtualPet> virtualPets = new HashMap<String, VirtualPet>();
		// Then I created a method in VirtualPetShelter which returned the VirtualPets
		// "Values"

		Collection<VirtualPet> virtualPetCollection = testPetShelter.getVirtualPets(); //Initially got error, eclipse
																			// asked me to create collection in VPS

		Assert.assertNotNull(testPetShelter.virtualPets);//I got error, eclipse asked me to create a HashMap in VPS
		Assert.assertEquals(virtualPetCollection, testPetShelter.virtualPets.values()); //".values() is a Maps 
		                                                                                //way to return a "Collection"
		Assert.assertEquals("Nigel", virtualPets.get(pet5).name); //test value of local HashMap (moved later to VPS)
		Assert.assertEquals(30, virtualPets.get(pet1).hunger);  //test value of local HashMap (moved later to VPS)
		Assert.assertEquals(40, virtualPets.get(pet2).boredom); //test value of local HashMap (moved later to VPS)
		Assert.assertEquals(5, virtualPets.get(pet3).thirst);  //test value of local HashMap (moved later to VPS)
		Assert.assertEquals("Grey tiger who hunter who who be great in the barn", virtualPets.get(pet4).description);
	}
	
	@Test
	public void testAllowIntakeOfAHomelessPet() {					// I need to add pet, got error, 
		VirtualPetShelter testPetShelter = new VirtualPetShelter(); //eclipse ask me to create addPet in VPS																
		testPetShelter.addPet(new String(), new VirtualPet("Rusty", "He doesn't get hungry, he's Dead!", 0, 0, 0));
		Assert.assertEquals(1, testPetShelter.getVirtualPets().size()); // I test # of values (pets) in collection
	}
	
	@Test
	public void testFeedAllThePetsInTheShelter() {
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Rusty", new VirtualPet("Rusty", "He doesn't get hungry, he's Dead!", 5, 0, 0));
		testPetShelter.addPet("Grazer", new VirtualPet("Grazer", "She cant leave.. she's dead too!", 10, 0, 0));
		testPetShelter.feedAllPets(); // I need to feed pets, got error and eclipse asked me to create feedAllPets in VPS
		Assert.assertEquals(2, testPetShelter.virtualPets.get("Rusty").hunger);  // feedAllPets decrements hunger 
		Assert.assertEquals(7, testPetShelter.virtualPets.get("Grazer").hunger); // feedAllPets decrements hunger 
	}
	
	@Test
	public void testWaterAllThePetsInTheShelter() {
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Rusty", new VirtualPet("Rusty", "He doesn't get hungry, he's Dead!", 5, 30, 20));
		testPetShelter.addPet("Grazer", new VirtualPet("Grazer", "She cant leave.. she's dead too!", 10, 20, 30));
		testPetShelter.waterAllPets(); // I need to water pets, got error and eclipse asked me to create waterAllPets in VPS 
		Assert.assertEquals(18, testPetShelter.virtualPets.get("Rusty").thirst); // waterAllPets decrements thirst
		Assert.assertEquals(28, testPetShelter.virtualPets.get("Grazer").thirst); // waterAllPets decrements thirst
	}
	
	@Test
	public void testPlayWithAPetInTheShelter() {
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Rusty", new VirtualPet("Rusty", "He doesn't get hungry, he's Dead!", 5, 30, 20));
		testPetShelter.addPet("Grazer", new VirtualPet("Grazer", "She cant leave.. she's dead too!", 10, 20, 30));
		testPetShelter.playWithPet("Rusty"); // I need to play w/pet, got error and eclipse asked me to create playWithPet in VPS 
		testPetShelter.playWithPet("Grazer");  // playWithPet finds the pet in collection and decrements boredom
		Assert.assertEquals(26, testPetShelter.virtualPets.get("Rusty").boredom); //playWithPet decrements boredom
		Assert.assertEquals(16, testPetShelter.virtualPets.get("Grazer").boredom); //playWithPet decrements boredom

	}

	@Test
	public void testAdoptionOfAShelterPet() { // I need to adopt pet and remove from shelter (collection of VP's)
		VirtualPetShelter testPetShelter = new VirtualPetShelter(); 
		testPetShelter.addPet("Rusty", new VirtualPet("Rusty", "He doesn't get hungry, he's Dead!", 0, 0, 0));
		testPetShelter.addPet("Grazer", new VirtualPet("Grazer", "She cant leave.. she's dead too!", 0, 0, 0));
		testPetShelter.adoptPet("Grazer"); // I created adoptPet, eclipse erred and asked me to create adoptPet in VPS 
		Assert.assertEquals(1, testPetShelter.getVirtualPets().size()); // Pet is now removed from VP's collection
	}
	
	@Test
	public void testTheTickMethodForEachPet() {   // I need a tick to increment to change values of my pets when i interact with them
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Rusty", new VirtualPet("Rusty", "He doesn't get hungry, he's Dead!", 5, 30, 20));
		testPetShelter.addPet("Grazer", new VirtualPet("Grazer", "She cant leave.. she's dead too!", 10, 20, 30));
		testPetShelter.tick(); // I created a tick, eclipse erred and asked me to create tick in VPS
		Assert.assertEquals(32, testPetShelter.virtualPets.get("Rusty").boredom);
		Assert.assertEquals(22, testPetShelter.virtualPets.get("Grazer").boredom);
	}

}
