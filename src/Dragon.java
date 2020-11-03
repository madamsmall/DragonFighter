/**
 * This is the Dragon OBJECT
 * Use this object to give the dragon specific traits, and create as many different ones as you like!
 */
class Dragon{

	// descriptors of the dragon, for flavor text and know who you're fighting
	private String color;
	private String name;

	// what kind of dragon is this? Abilities?
	private boolean fireBreathing;
	private int fireDamageModifier = 2;

	// Does he have a lot of heads?
	private boolean hydra;

	// fighting game -- need to be able to take and deal damage -- and die
	private int currentHealth;
	private int maxHealth;
	private int baseDamage;
	private boolean isAlive = true;

	// TODO add as many dragon defining things as you like -- what if the dragon can heal, what if he can fly?
	//  what if the heads grow back and you have to cut them all off twice?? Unlimited options.

	/**
	 * This is the default dragon. If you make one of these, you don't have to decide anything, he gets the normal stuff.
	 * Breaths fire, only has one boring head. Has claws. Woo.
	 */
	Dragon(){
		this.name = "Conrad, the Dragon sent by Cyberlife";
		this.color = "Green";
		this.fireBreathing = true;
		this.hydra = false;

		this.maxHealth = 100;
		this.currentHealth = this.maxHealth;
		this.baseDamage = 10;
	}

	/**
	 * Super Customizable Dragon! You can give him whatever attributes you want. Whatta beast.
	 * @param dragonName What to call this dude
	 * @param color What color is it
	 * @param fireBreathing Can he breath fire?
	 * @param hydra Does he have multiple heads?
	 * @param maxHealth How much health are we working with?
	 * @param baseDamage How hard does he swipe?
	 */
	Dragon(String dragonName, String color, boolean fireBreathing, boolean hydra, int maxHealth, int baseDamage){
		// notice that the items on the left are "this.something". That means they are the class variables.
		// The ones on the right have the same name, but are the input variables. Notice your IDE colors them differently!
		// Better to not have them named the same to avoid bugs in practice.
		this.name = dragonName;
		this.color = color;
		this.fireBreathing = fireBreathing;
		this.hydra = hydra;

		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		this.baseDamage = baseDamage;
	}

	// Interact with this dragon with these methods

	/**
	 * Dragon attacks the fighter! Dragon should choose from his available attacks, and make it happen
	 * @return the total damage the dragon is doing to our fighter
	 */
	public int attack(){
		// TODO what could happen here? Different dragons attack in different ways. They all have claws but some of them
		// can breathe fire or have multiple heads full of teeth! Our dragon is super dumb right now. He always bites.
		// Probably should give him something more interesting to do? Maybe randomize his attack, or make a decision
		// based on his own health?

		int numHeads = 1;
		if(this.isHydra()){
			numHeads = 3;
		}

		int attackTotal = this.baseDamage * numHeads;

		// Flavor text! If the user doesn't know what's going on, it isn't much of a game.
		System.out.println(this.name + " bites for " + attackTotal + " damage. Ouch!");
		// this will print something like, "Targorr the Golden dragon bites for 30 damage. Ouch!"

		return attackTotal;
	}

	/**
	 * Attack the dragon! The dragon's health is reduced by the incoming attack amount.
	 * @param damage How much damage should this dragon take?
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
			System.out.println(" " + this.name + " died!");
		}
		else{
			System.out.println(" He only has " + this.currentHealth + " health left!");
		}
	}

	/**
	 * Announce the dragon as he comes in. Epic!
	 * Customizable based on attributes, or randomize it, anything goes.
	 */
	void doIntro(){
		System.out.println();
		System.out.println("The sky darkens as the massive form of the " + this.color + " dragon '" + this.name + "' approaches.");
		if(isHydra()){
			System.out.println("Three heads turn towards you in unison. He looks angry.");
		}
		if(isFireBreathing()){
			System.out.println("The ground is littered with the burned bodies of previous heroes. This isn't good.");
		}
	}

	// Simple Getters -- find out the stats of this Dragon using these.
	String getName(){
		return this.name;
	}

	boolean isFireBreathing(){
		return this.fireBreathing;
	}

	boolean isHydra(){
		return this.hydra;
	}

	boolean isAlive(){
		return this.isAlive;
	}
}
