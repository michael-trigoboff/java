public class Animals
{
	public static void main(String[] args)
	{
		Lizard	lizard = new Lizard("Godzilla");
		Bird	bird = new Bird("Big");
		Bat		bat = new Bat("Dracula");
		
		lizard.print(System.out);
		bird.print(System.out);
		bat.print(System.out);
	}
}
