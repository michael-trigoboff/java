public class Game
{
    private String		version = "v5";
    private Parser		parser;
	private Location	currentLocation;

    public Game()
    {
        parser = new Parser();
    }

	public static void main(String[] args)
	{
		(new Game()).play();
	}

    public void play()
    {
        boolean		finished = false;

    	currentLocation = Location.values()[0];				// start at first Location
        printWelcome();

        while (! finished) {
            UserCommand command = parser.getCommand();
            finished = processCommand(command);
        	}
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.printf("Welcome to the World of Zuul (%s)%n!", version);
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.print("You are ");
        System.out.print(currentLocation);
    }

    private boolean processCommand(UserCommand cmd)
    {
        if(cmd == null) {
            System.out.println("I don't know what you mean...");
            return false;
        	}
        return cmd.getCommand().doCommand(this, cmd);
    }

    void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.print("    ");
		for (GameCommand cmd : GameCommand.values())
			System.out.print(cmd.toString().toLowerCase() + " ");
        System.out.println();
    }

    void goLocation(UserCommand userCmd) 
    {
        if(userCmd.getDirection() == null) {
            // if bad direction, we don't know where to go...
            System.out.println("Go where?");
            return;
        	}

        // try to leave current room
        
        Location nextLocation = currentLocation.getNeighbor(userCmd.getDirection());

        if (nextLocation == null)
            System.out.println("There is no door!");
        else {
        	currentLocation = nextLocation;
            System.out.print("You are ");
            System.out.print(currentLocation);
        	}
    }

    void random()
    {
    	currentLocation = Location.randomLocation();
        System.out.print("You are ");
        System.out.print(currentLocation);
    }

    boolean quit()
    {
    	return true;  // signal that we want to quit
    }
}
