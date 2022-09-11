package vehicles;

import pcc.stdin;

public class Plane
    extends Vehicle
{
    int     wingSpan;

    public Plane(String[] args)
    {
    	super(args);
    	
        Integer     wSpan;

        if (args.length != 5)
        	throw new RuntimeException("new plane requires name, nEngines, wingSpan");
        setNEngines(args[3]);
        wSpan = stdin.parseInteger(args[4]);
        if (wSpan == null)
        	throw new RuntimeException("wingspan must be a number");
        else if (wSpan <= 0)
        	throw new RuntimeException("wingSpan must be a positive number");
        wingSpan = wSpan;
    }

    public String topSpeed()
    {
        return String.format("plane speed for %s: %.2f mph%n", name, wingSpan * 4.5);
    }
    
    public String toString()
    {
        return String.format("plane%n    wing span: %d%n", wingSpan) + super.toString();
    }
}
