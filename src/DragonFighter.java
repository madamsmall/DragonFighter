import java.util.Scanner;

/**
 * The main class for DragonFighter text based combat. Controls the game loop, interaction with the player, and objects
 * needed to play.
 */
public class DragonFighter{

    private Fighter fighter;
    private Dragon dragon;

    /**
     * The main method, this is where the application starts. We could put all of our stuff in here, but we wont --
     * the reason not to is to avoid having to make all of our methods "static". Having to use static means you can't
     * have multiple objects -- and we want multiple dragons!
     * @param args command line arguments. We wont use them but this is standard.
     */
    public static void main(String[] args) {
        // Creating an instance of our game, and starting it
        DragonFighter dragonFighter = new DragonFighter();
        // this just starts up our game loop, which we store in the play method (to get out of this static method)
        dragonFighter.play();
    }

    /**
     * The game loop. This is where we get user input and apply it repeatedly until the game comes to an end. Either
     * the user prevails, or the dragon does.
     * // TODO there is no error handling in user input. Add it once the program works!
     */
    private void play(){
        // TODO welcome flavor text?
        System.out.println();

        // set up the player and opponent!
        this.createCompetitors();

        Scanner reader = new Scanner(System.in);

        // game loop!
        boolean gameOver = false;
        while(!gameOver){ // keep doing this stuff until the game is over
            // we will always let the player attack first, but this could be randomized
            System.out.println(); // blank line for better readability
            System.out.println("Time to attack! Choose your attack: ");
            System.out.println("1. Normal Attack");
            System.out.println("2. Special Attack");

            int choice = reader.nextInt();
            switch(choice){
                case 1:
                    dragon.takeDamage(fighter.attack());
                    break;
                case 2:
                    dragon.takeDamage(fighter.specialAttack());
                    break;
                default:
                    System.out.println("Not a valid choice! Too bad...");
            }

            // Dragon hits back (if he's alive)! Pretty boring stuff right now...
            if(!this.dragon.isAlive()){ // dragon dead?
                break; // get out of this while loop
            }

            System.out.println();
            System.out.println("The Dragon roars and counter attacks!");
            this.fighter.takeDamage(dragon.attack());

            // Did either of them die? if not, this loop goes again.
            if(!this.fighter.isAlive()){ // player dead?
                gameOver = true;
            }
        }

        // game over stuff
        System.out.println();
        System.out.println("Game over!");
        String winner;
        if(this.fighter.isAlive()){
            winner = this.fighter.getFighterName();
        }
        else{
            winner = this.dragon.getName();
        }
        System.out.println(winner + " Wins!!");

        //TODO either give them the option to play again (another loop), or exit. For now, we exit.
        System.exit(0);

    }

    /**
     * Collect user preferences for setup
     */
    private void createCompetitors(){
        // Get input from the user to set up
        Scanner reader = new Scanner(System.in);

        // Reading data using readLine
        this.fighter = new Fighter();

        System.out.println("Enter your name, fighter!");
        this.fighter.setFighterName(reader.nextLine());

        System.out.println();
        System.out.println("Welcome " + this.fighter.getFighterName() + "! Lets battle a dragon!");

        System.out.println("Do you want a default dragon, or custom?  (d for default, any key for custom)");
        if(reader.nextLine().equalsIgnoreCase("d")){
            // here's how to get a custom response
            System.out.println();
            System.out.println("A good old fashioned random dragon!");
            this.dragon = new Dragon();
        }
        else{ // user selected anything but 'd' -- let them decide everything
            System.out.println();
            System.out.println("Custom Dragon, sweet! Let's set this puppy up:");
            System.out.println("What color is this Dragon?");
            // here's how to get a simple string
            String color = reader.nextLine();

            System.out.println("Does the dragon breathe fire? y/n");
            // here's how to get a boolean
            boolean fireBreathing = false;
            if(reader.nextLine().equalsIgnoreCase("y")){
                fireBreathing = true;
            }

            // here's how to get a number
            System.out.println("How many hit points does the dragon have?");
            int maxHealth = reader.nextInt();

            // TODO -- ask the user anything else we need and replace these!
            String dragonName = "";
            boolean hydra = false;
            int baseDamage = 10;

            this.dragon = new Dragon(dragonName, color, fireBreathing, hydra, maxHealth, baseDamage);
        }

        // Introduce them!
        this.fighter.doIntro();
        this.dragon.doIntro();
    }
}
