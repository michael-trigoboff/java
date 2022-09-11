public class LineEndings {
	// the official newline character(s), defined by the local operating system 
	static final String newlineOS = System.getProperty("line.separator");

	public static void main (String[] args)
	{	
		System.out.printf("line.separator|%s|%n", newlineOS);	// 0x0D, 0x0A, 0x0D, 0x0A
		System.out.printf("line.separator|%s|\n", newlineOS);	// 0x0D, 0x0A, 0x0A
	}
}
