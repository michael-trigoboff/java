import java.io.PrintStream;

public class Animal
{
	private String	name;
	private int		nEyes;
	
	public Animal(String name, int nEyes)
	{
		this.name = name;
		this.nEyes = nEyes;
	}
	
	void print(PrintStream out)
	{
		out.printf("name:%s nEyes:%d ", name, nEyes);
	}
}
