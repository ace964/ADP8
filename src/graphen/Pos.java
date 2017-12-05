package graphen;
/**
 * Pos
 * Position von Daten 
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class Pos {
	private Knoten _knoten;
	private int _index;
	private boolean _isValid;
	
	Pos (Knoten k) {
		_knoten = k;
		_index = -1;
		_isValid = true;
	}
	
	Pos (int i) {
		_knoten = null;
		_index = i;
		_isValid = true;
	}
	
	public boolean isValid() {
		return _isValid;
	}
	
	Knoten gibKnoten() {
		return _knoten;
	}
	
	int gibIndex() {
		return _index;
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
	
	@Override
	public int hashCode()
	{
		if(_knoten == null)
		{
			return _index;
		}
		else
		{
			return _knoten.gibData();
		}
	}
	
	
}
