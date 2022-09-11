import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Stocks extends HashMap<String, Stock> implements Map<String, Stock> {

	public String toString() {
		StringBuilder	sb = new StringBuilder();
		
		sb.append("----------------------------------------------------------------------------");
		sb.append(System.lineSeparator());
		if (isEmpty()) {
			sb.append("no stocks");
			sb.append(System.lineSeparator());
		}
		else {
			sb.append("symbol  name                                   price       date");
			sb.append(System.lineSeparator());
			sb.append("------  ----                                   -----       ----");
			sb.append(System.lineSeparator());
			for (Stock stock : values()) {
				sb.append(stock);
				sb.append(System.lineSeparator());
			}
		}
		sb.append("----------------------------------------------------------------------------");
		sb.append(System.lineSeparator());
		return sb.toString();
	}
}
