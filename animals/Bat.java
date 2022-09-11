import java.io.PrintStream;

public class Bat
	extends Animal
	implements Flyer, Crawler
{
	private int		nWings;
	private int		nLegs;
	
	public Bat(String name)
	{
		super(name, 2);
		this.nWings = 2;
		this.nLegs = 4;
	}
	
	public int howManyWings()
	{
		return nWings;
	}

	public int howManyLegs()
	{
		return nLegs;
	}

	void print(PrintStream out)
	{
		out.print("bat:    ");
		super.print(out);
		out.printf("nWings:%d nLegs:%d\n", howManyWings(), howManyLegs());
	}
}
