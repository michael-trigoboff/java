import java.io.PrintStream;

public class Lizard
	extends Animal
	implements Crawler
{
	private int		nLegs;
	
	public Lizard(String name)
	{
		super(name, 2);
		this.nLegs = 4;
	}
	
	public int howManyLegs()
	{
		return nLegs;
	}

	void print(PrintStream out)
	{
		out.print("lizard: ");
		super.print(out);
		out.printf("nLegs:%d\n", howManyLegs());
	}
}
