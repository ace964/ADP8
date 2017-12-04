/**
 * Pos
 * Position von Daten 
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class Pos {
	Knoten _knoten;
	int _index;
	boolean _isValid;
	
	Pos (Knoten k) {
		_knoten = k;
		_index = -1;
	}
	
	Pos (int i) {
		_knoten = null;
		_index = i;
	}
	
	public boolean isValid() {
		return _isValid;
	}
	
	Knoten gibKnoten() {
		return _knoten;
	}
	
	Knoten gibIndex() {
		return _knoten;
	}
	
	
	public void setValid(boolean state) {
		_isValid = state;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Pos)
		{
			Pos p = (Pos) obj;
			if(p._isValid != _isValid)
			{
				return false;
			}
			if(p._index != _index)
			{
				return false;
			}
			if(p._knoten != _knoten)
			{
				return false;
			}
			return true;
		}
		return false;
	}
	
}
