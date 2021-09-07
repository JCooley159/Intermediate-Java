
public class NonPlayableCharacter extends Entity {

		public NonPlayableCharacter(String name) {
			super(name);
			
		}
		
		
		@Override
		public void takeDamage(int hit) {
			
			super.takeDamage(0);			
		}
		
		@Override
		public void takeHealing(int hit) {
			
			super.takeHealing(0);			
		}
		
		public String getGreeting() {
			return "Greeting! At your service.";		
		}
		
		
}

