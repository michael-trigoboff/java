import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Driver {
	private static SimpleDateFormat		dateFormat = new SimpleDateFormat("MMM dd, yyyy");
	private static Stocks				stocks = new Stocks();


	public static void addStock(String symbol, String name, int price, String date) {
		try {
			stocks.put(symbol, new Stock(symbol, name, price, dateFormat.parse(date)));
			System.out.println("added " + symbol);
		}
		catch (ParseException pe) {
			System.out.println("bad date string for stock " + symbol);
		}
	}
	
	public static void searchStock(String symbol) {
		if (stocks.containsKey(symbol))
			System.out.println("found " + symbol);
		else
			System.out.println(symbol + " not found");
	}
	
	public static void removeStock(String symbol) {
		if (stocks.remove(symbol) != null)
			System.out.println("removed " + symbol);
		else
			System.out.println(symbol + " not removed");
	}
	
	public static void main(String[] args) {
		System.out.println(stocks);
		searchStock("IBM");
		addStock("IBM", "International Business Machines", 2573, "May 23, 1967");
		System.out.println();
		System.out.println(stocks);
		searchStock("IBM");
		removeStock("IBM");
		searchStock("IBM");
		removeStock("IBM");
		addStock("MLT", "MLT Software, Inc.", 800, "Apr 18, 1988");
		addStock("IBM", "International Business Machines", 2573, "May 23, 1967");
		addStock("XRX", "Xerox", 1892, "Jun 1, 1980");
		addStock("US:BA", "Boeing", 6407, "Dec 14, 1993");
		addStock("GD", "General Dynamics", 7281, "Oct 24, 2006");
		addStock("AAPL", "Apple Computer, Inc.", 2308, "May 1, 1980");
		addStock("AAPL", "Apple Computer, Inc.", 2308, "May 1, 1980");
		addStock("GE", "General Electric", 1948, "Mar 22, 1987");
		addStock("ATT", "American Telephone & Telegraph", 20, "May 10, 1998");
		System.out.println();
		System.out.println(stocks);
		searchStock("ATT");
		removeStock("AAPL");
		removeStock("AAPL");
		searchStock("ATT");
		removeStock("US:BA");
		searchStock("GE");
		removeStock("GE");
		searchStock("ATT");
		addStock("AAPL", "Apple Computer, Inc.", 2308, "May 1, 1980");
		addStock("GE", "General Electric", 1948, "Mar 22, 1987");
		addStock("US:BA", "Boeing", 6407, "Dec 14, 1993");
		System.out.println();
		System.out.println(stocks);
	}
}
