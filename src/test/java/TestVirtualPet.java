import org.junit.Assert;
import org.junit.Test;

class TestVirtualPet {

	/*
	 * VirtualPet class In addition to the requirements from last week's project:
	 * 
	 * include instance variables representing: name (from the above example, this
	 * might be "Tommy") description (from the above example, this might be
	 * "smells like a Stargazer lily fresh with morning dew") include a constructor
	 * that accepts a name and description include a constructor that, in addition
	 * to name and description, accepts default values for the pet's attributes
	 * (hunger, boredom, etc) Do not include a default (zero arguments) constructor.
	 */
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// Created default constructor to create my initial VP class then I removed the
	// default as per the instructions. I commented these tests out because they 
	// require the default constructor.
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// @Test
	// public void testVirtualPetExistsButIsNull() {
	// VirtualPet testPet = null;  // I got an error and it asked me to create the class
	// Assert.assertNull(testPet); // I did not create an instance of the class, so my testPet object is null
	// }
	//
	// @Test
	// public void testVirtualPetExistsButIsNotNull() {
	// VirtualPet testPet = new VirtualPet();   // I got an error and it asked me to create a default constructor
	// Assert.assertNotNull(testPet); 			// Now i have an instance of the class and it is not null
	// }
	//
	// @Test
	// public void testVirtualPetHasName() {
	// VirtualPet testPet = new VirtualPet();
	// testPet.name = "Tui"; //I knew I needed a name for a pet, I got an error eclipse asked me to create the class variable
	// Assert.assertEquals("Tui", testPet.name); // This test passes to true because
	// I set my testPet.name to "Tui"
	// }
	//
	// @Test
	// public void testVirtualPetHasDescription() {
	// VirtualPet testPet = new VirtualPet(); 				// As above
	// testPet.description = "Is a cute little calico";
	// Assert.assertEquals("Is a cute little calico", testPet.description);
	// }

	@Test
	public void testWhenICreateAVirtualPetICanIncludeNameAndDescription() {
		String name = "Tui";
		String description = "Is a cute little calico";
		VirtualPet testPet = new VirtualPet(name, description); // I got an error and eclipse asked me to create a new
		Assert.assertEquals("Tui", testPet.name); 			// constructor for name & description
		Assert.assertEquals("Is a cute little calico", testPet.description);
	}

	@Test
	public void testWhenICreateAVirtualPetICanIncludeNameDescriptionHungerBoredomAndThirst() {
		String name = "Tui";
		String description = "Is a cute little calico";
		int hunger = 0;
		int boredom = 1;
		int thirst = 2;
		VirtualPet testPet = new VirtualPet(name, description, hunger, boredom, thirst); //I got another error for these args,
		Assert.assertEquals("Tui", testPet.name);				// so I created another constructor with the 5 this.args in VP.
		Assert.assertEquals("Is a cute little calico", testPet.description);
		Assert.assertEquals(0, testPet.hunger);
		Assert.assertEquals(1, testPet.boredom);
		Assert.assertEquals(2, testPet.thirst);
	}
	
	@Test
	public void testThatMyTickUpdatesValuesOfPet() {
		String name = "Tui";
		String description = "Is a cute little calico";
		int hunger = 0;
		int boredom = 1;
		int thirst = 2;
		VirtualPet testPet = new VirtualPet(name, description, hunger, boredom, thirst); 
		testPet.tick();
		Assert.assertEquals(1, testPet.hunger);
		Assert.assertEquals(3, testPet.boredom);
		Assert.assertEquals(5, testPet.thirst);
	}

}
