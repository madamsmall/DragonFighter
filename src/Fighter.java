/**
 * This is the Player OBJECT
 * Use this object to give the player specific traits, and create as many different ones as you like!
 */
class Fighter{
	private String name;
	private int maxHealth;
	private int currentHealth;
	private int baseAttackDamage = 15; // these would be better if they were random, don't you think? A range? yes...
	private int specialAttackDamage = 25;
	private boolean isAlive = true;

	// TODO -- other abilities? What about a cooldown on the special attack for a few turns? Can heal? Can evade? Has
	// spell resistances? Randomized stats?

	/**
	 * Default random fighter. Can set attributes later if desired.
	 */
	Fighter(){
		this.name          = "Lank";
		this.maxHealth     = 50;
		this.currentHealth = maxHealth;
	}

	/**
	 * Custom fighter
	 * @param fighterName The name of the fighter
	 * @param fighterMaxHealth How much health do they have
	 */
	Fighter(String fighterName, int fighterMaxHealth){
		this.name          = fighterName;
		this.maxHealth     = fighterMaxHealth;
		this.currentHealth = this.maxHealth;
	}

	// Interact with this Fighter with these methods

	/**
	 * Fighter attacks the Dragon!
	 * @return the total damage the fighter is doing to our dragon
	 */
	int attack(){
		int attackTotal = this.baseAttackDamage;

		// Flavor text! If the user doesn't know what's going on, it isn't much of a game.
		System.out.println(this.name + " attacks for " + attackTotal + " damage. Take that!");

		return attackTotal;
	}

	/**
	 * Fighter attacks the Dragon -- but SPECIAL!
	 * @return the total damage the fighter is doing to our dragon
	 */
	int specialAttack(){
		int attackTotal = this.specialAttackDamage;

		// Flavor text! If the user doesn't know what's going on, it isn't much of a game.
		System.out.println(this.name + " special attacks for " + attackTotal + " damage. Take that!");

		return attackTotal;
	}

	/**
	 * Attack the Fighter! The fighter's health is reduced by the incoming attack amount.
	 * @param damage How much damage should this fighter take?
	 */
	void takeDamage(int damage){
		this.currentHealth -= damage;

		// every hit might kill him right? Better check
		if(this.currentHealth <= 0){
			this.isAlive = false;
		}

		// TODO could the dragon do anything else here (if he's alive)? What if he had the ability to dodge or parry
		// before he took that hit?

		// TODO we need flavor text! Could hard code it like we did in the attack method, or could have a List of
		// flavor texts we choose from to keep it fresh, etc
		System.out.println();
		System.out.print(this.name + " took " + damage + " damage!");
		if(!this.isAlive){
			System.out.println(this.name + " died!");
		}
		else{
			System.out.println(" They only have " + this.currentHealth + " health left!");
		}
	}

	/**
	 * Announce the Hero as he comes in. Epic!
	 * Customizable based on attributes, or randomize it, anything goes.
	 */
	void doIntro(){
		System.out.println();
		System.out.println("The hero " + this.name + " approaches a dark cave, he has no business here");
	}

	boolean isAlive(){
		return this.isAlive;
	}

	String getFighterName(){
		return name;
	}

	void setFighterName(String fighterName){
		this.name = fighterName;
	}
}
