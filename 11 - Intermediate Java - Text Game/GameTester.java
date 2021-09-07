
public class GameTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PlayableCharacter pc = new PlayableCharacter("Heroic Champion Francis");
		NonPlayableCharacter npc = new NonPlayableCharacter("Wimpy Shopkeep Laura");
		
		System.out.println(pc.getGreeting());
		System.out.println(pc.toString());
		System.out.println(npc.getGreeting());
		System.out.println(npc.toString());
		
		
		Item sword = new Item("Sword");
		sword.setWeapon();
		Item helmet = new Item("Helmet");
		Item laptop = new Item("Laptop");
		laptop.setWeapon();
		Item pencil = new Item("Pencil");
		
		
		pc.addItem(sword);
		pc.addItem(sword);
		pc.addItem(helmet);
		pc.addItem(laptop);
		pc.removeItem(pencil);
		npc.addItem(helmet);
		npc.addItem(laptop);
		npc.addItem(pencil);
		
		
		System.out.println(pc.toString());
		System.out.println(npc.toString());
		
		
		pc.takeDamage(50);
		System.out.println(pc.toString());
		npc.takeDamage(50);
		System.out.println(npc.toString());
		
		
		pc.takeHealing(45);
		System.out.println(pc.toString());
		npc.takeHealing(45);
		System.out.println(npc.toString());
		
		
	}

}
