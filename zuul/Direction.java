enum Direction
{
	NORTH, EAST, SOUTH, WEST, UP, DOWN;
	
	static Direction parse(String str)
	{
		Direction	direction;
		
		try {
			direction = Direction.valueOf(str.toUpperCase());
	            // use toUpperCase to make program accept command names
	            // no matter what case they are typed in
			}
		catch (IllegalArgumentException e) {
			direction = null;
			}
		
		return direction;
	}
	
}

