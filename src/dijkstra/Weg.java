package dijkstra;
import graphen.Pos;

/**
 * Weg
 * Ein weg der eine Distanz und ein Ziel hat.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class Weg {
	private int _distanz;
	private Pos _ziel;
	
	public Weg(Pos ziel, int distanz) {
		_ziel = ziel;
		_distanz = distanz;
	}

	public Pos gibZiel() {
		return _ziel;
	}


	public int gibDistanz() {
		return _distanz;
	}
	
	public void setzeDistanz(int distanz) {
		_distanz = distanz;
	}

	public void setzeZiel(Pos ziel ) {
		_ziel = ziel;
	}
}
