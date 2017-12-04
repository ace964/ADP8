import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Knoten
 * Eine Containerklasse für ein Datum 
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class Knoten {
	private char _data;
	private Map<Knoten, Integer> _nachbarn;
	
	public Knoten(char data) {
		_data = data;
		_nachbarn = new HashMap<>();
	}
	
	public Set<Knoten> gibNachbarn() {
		return _nachbarn.keySet();
	}
	
	public char gibData() {
		return _data;
	}
	
	public int gibDistanz(Knoten k)
	{
		if(_nachbarn.containsKey(k))
		{
			return _nachbarn.get(k);
		}
		else
		{
			throw new IllegalArgumentException("Knoten ist kein Nachbar");
		}
	}
	
	public void fuegeNachbarnHinzu(Knoten pos, int distanz) {
		_nachbarn.put(pos, distanz);
	}
}

