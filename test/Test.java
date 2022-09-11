import java.util.*;

public class Test
{

	public static void main(String[] args)
	{
//		List<Integer> arrList = Arrays.asList(1, 2, 3, 4, 5);
//		List<Integer> intList = new ArrayList<Integer>();
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		
//		for (int i = 1; i <= 5; i++)
//			intList.add(i);
		List<Integer> smallList = intList.subList(1, 3);
		System.out.println(intList);
		smallList.clear();
		System.out.println(intList);
	}

}
