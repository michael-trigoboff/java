import java.io.PrintStream;

public class Bird
	extends Animal
	implements Flyer
{
	private int		nWings;
	
	public Bird(String name)
	{
		super(name, 2);
		this.nWings = 2;
	}
	
	public int howManyWings()
	{
		return nWings;
	}

	void print(PrintStream out)
	{
		out.print("bird:   ");
		super.print(out);
		out.printf("nWings:%d\n", howManyWings());
	}
}
