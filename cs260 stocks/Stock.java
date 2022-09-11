import java.text.DateFormat;
import java.util.Date;

public class Stock {
	static private DateFormat df = DateFormat.getDateInstance();
	
	private String	symbol;
	private String	name;
	private int		price;
	private Date	date;
	
	public Stock(String symbol, String name, int price, Date date) {
		this.symbol = symbol;
		this.name = name;
		this.price = price;
		this.date = date;
	}
	
	public String toString() {
		StringBuilder	sb = new StringBuilder();
		
		sb.append(String.format("%-8s", symbol));
		sb.append(String.format("%-36s", name));
		sb.append(String.format("%8s", String.format("%d.%02d", price / 100, price % 100)));
		sb.append(String.format("       %s", df.format(date)));
		return sb.toString();
	}
}
