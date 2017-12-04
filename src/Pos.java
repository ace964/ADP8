/**
 * Pos
 * Position von Daten 
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class Pos<E> {
	E _Pos;
	boolean _isValid;
	
	public Pos (E o) {
		if (o instanceof Knoten | o instanceof Integer) {
			_Pos = o;
			_isValid = true;
		} else {
			throw new IllegalArgumentException("Position not integer or container");
		}
	}
	
	public boolean isValid() {
		return _isValid;
	}
	
	public E gibPos() {
		return _Pos;
	}
	
	public void setValid(boolean state) {
		_isValid = state;
	}
}
