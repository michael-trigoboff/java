package vehicles;

import pcc.stdin;

public class Boat
    extends Vehicle
{
    int     length;

    public Boat(String[] args)
    {
    	super(args);
    	
        Integer     lgth;

        if (args.length != 5)
        	throw new RuntimeException("new boat requires name, nEngines, length");
        setNEngines(args[3]);
        lgth = stdin.parseInteger(args[4]);
        if (lgth == null)
        	throw new RuntimeException("length must be a number");
        else if (lgth <= 0)
        	throw new RuntimeException("length must be a positive number");
        length = lgth;
    }

    public String topSpeedStr()
    {
        return String.format("boat speed for %s: %.2f knots%n", name, 1.34 * Math.sqrt(length));
    }

    public String toString()
    {
    	StringBuilder	str = new StringBuilder();
    	
        str.append("boat" + String.format("%n"));
        str.append("    length: " + length + String.format("%n"));
        str.append(super.toString());
        
        return str.toString();
    }
}