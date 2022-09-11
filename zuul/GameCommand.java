enum GameCommand
{
	GO		{ boolean doCommand (Game game, UserCommand userCmd) { game.goLocation(userCmd); return false;}	},
	HELP	{ boolean doCommand (Game game, UserCommand userCmd) { game.printHelp(); return false; }		},
	QUIT	{ boolean doCommand (Game game, UserCommand userCmd) { return game.quit(); }					},
	RANDOM	{ boolean doCommand (Game game, UserCommand userCmd) { game.random(); return false; }			};
	
	abstract boolean doCommand(Game game, UserCommand userCmd);

	static GameCommand parse(String str)
	{
		GameCommand		cmd;
		
		try {
			cmd = GameCommand.valueOf(str.toUpperCase());
	            // use toUpperCase to make program accept command names
	            // no matter what case they are typed in
			}
		catch (IllegalArgumentException e) {
			cmd = null;
			}
		
		return cmd;
	}
	
}
