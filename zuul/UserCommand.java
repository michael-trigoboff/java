public class UserCommand
{
	private GameCommand		cmd;
	private Direction	dir;
	
	UserCommand(GameCommand cmd, String word2)
	{
		this.cmd = cmd;
		if (word2 != null)
			if (cmd == GameCommand.GO)
				try {
					dir = Direction.valueOf(word2.toUpperCase());
				} catch (IllegalArgumentException e) {
					dir = null;
				}
	}

	public GameCommand getCommand()
	{
		return cmd;
	}

	public Direction getDirection()
	{
		return dir;
	}
}
