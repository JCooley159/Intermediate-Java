public class PlayableCharacter extends Entity {

	public PlayableCharacter(String name) {
		super(name);
		
	}
	
	@Override
	public void addItem(Item item) {
		
		if (isItemAvailable(item)) {
			System.out.println("item already in inventory\n");
		} else {
			super.addItem(item);
		}
		
	}
	
	@Override
	public void removeItem(Item item) {
		
		if (isItemAvailable(item)) {
			super.removeItem(item);
		} else {
			System.out.println("item not in inventory\n");
		}
		
	}
	
	@Override
	public void takeDamage(int hit) {
		
		double rando = Math.random();
		
		if (rando >= 0.0 && rando < 0.2) {
			System.out.println("Damage missed\n");
		} else {
			super.takeDamage(hit);
		}
		
	}
	
	public String getGreeting() {
		return "My life for Aiur!";		
	}
	
	
}
