enum Location
{
    OUTSIDE		("outside the main entrance of the university"),
    THEATER		("in a lecture theatre"),
    PUB			("in the campus pub"),
    LAB			("in a computing lab"),
    OFFICE		("in the computing admin office"),
    BASEMENT	("in the pub basement");
    
    private String		description;
    private Location[]	neighbors = new Location[Direction.values().length];
    
    Location(String description)
    {
    	this.description = description;
    }

	static		// set up neighbors for the locations
	{
		OUTSIDE.setNeighbors(
				new Direction[] {Direction.SOUTH, Direction.EAST, Direction.WEST},
				new Location[] {THEATER, LAB, PUB});
		
		THEATER.setNeighbors(
				new Direction[] {Direction.NORTH},
				new Location[] {OUTSIDE});
		
		PUB.setNeighbors(
				new Direction[] {Direction.EAST, Direction.DOWN},
				new Location[] {OUTSIDE, BASEMENT});
		
		BASEMENT.setNeighbors(
				new Direction[] {Direction.UP},
				new Location[] {PUB});
		
		LAB.setNeighbors(
				new Direction[] {Direction.WEST, Direction.NORTH},
				new Location[] {OUTSIDE, OFFICE});
		
		OFFICE.setNeighbors(
				new Direction[] {Direction.SOUTH},
				new Location[] {LAB});
	}

	public String toString()
	{
		StringBuilder	sb = new StringBuilder();
		String			newline = System.getProperty("line.separator");
		
		sb.append(description);
		sb.append(".");
		sb.append(newline);
		sb.append("   Exits:");
		for (Direction direction : Direction.values())
			if (neighbors[direction.ordinal()] != null) {
				sb.append(" ");
				sb.append(direction.toString().toLowerCase());
				}
		sb.append(newline);
		
		return sb.toString();
	}

	Location getNeighbor(Direction direction)
	{
		return neighbors[direction.ordinal()];
	}
	
	static Location randomLocation ()
	{
		int		randomIndex = (int) (values().length * Math.random());
		
		return values()[randomIndex];
	}

	void setNeighbors(Direction[] directions, Location[] locations)
	{
    	if (directions.length != locations.length)
    		throw new RuntimeException("Array sizes not equal!");

    	for (int i = 0; i < directions.length; i++)
    		neighbors[directions[i].ordinal()] = locations[i];
    }
}
