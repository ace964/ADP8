/**
 * Knoten
 * Eine Containerklasse für ein Datum 
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class Knoten {
	private char _data;
	private Pos<Knoten>[] _nachbarn;
	private int[] _distanzen;
	int _index = 0;
	
	@SuppressWarnings("unchecked")
	public Knoten(char data) {
		_data = data;
		_nachbarn = new Pos[0];
		_distanzen = new int[0];
	}
	
	public Pos<Knoten>[] gibNachbarn() {
		return _nachbarn;
	}
	
	public char gibData() {
		return _data;
	}
	
	public int[] gibDistanzen() {
		return _distanzen;
	}
	
	@SuppressWarnings("unchecked")
	public void fuegeNachbarnHinzu(Pos<Knoten> pos, int distanz) {
		if (_index == _nachbarn.length) {
			Pos<Knoten>[] neueNachbarn = new Pos[_nachbarn.length+1];
			int[] neueDistanzen = new int[_nachbarn.length+1];
			for (int i=0; i<_nachbarn.length; i++) {
				neueNachbarn[i] = _nachbarn[i];
				neueDistanzen[i] = _distanzen[i];
			}
			_nachbarn = neueNachbarn;
			_distanzen = neueDistanzen;
		}
		_distanzen[_index] = distanz;
		_nachbarn[_index] = pos;
		_index++;
	}
}

