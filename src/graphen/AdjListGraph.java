package graphen;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * AdjListGraph
 * Eine Listen-Implementation fuer ein Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class AdjListGraph implements Graph {
	
	private List<Knoten> _knoten;
	
	public AdjListGraph() {
		_knoten = new ArrayList<>();
	}
	
	@Override
	public Pos[] gibNachbarn(Pos pos) {
		Set<Knoten> nachbarSet = pos.gibKnoten().gibNachbarn();
		Pos[] nachbarn = new Pos[nachbarSet.size()];
		int i = 0;
		for(Knoten k : nachbarSet)
		{
			nachbarn[i] = new Pos(k);
			i++;
		}
		return nachbarn;
	}
	
	public Pos fuegeEin(int data) {
		Knoten k = new Knoten(data);
		_knoten.add(k);
		return new Pos(k);
	}

	@Override
	public void verbinde(Pos posAnfang, Pos posEnde, int distanz) {
		posAnfang.gibKnoten().fuegeNachbarnHinzu(posEnde.gibKnoten(), distanz);
		posEnde.gibKnoten().fuegeNachbarnHinzu(posAnfang.gibKnoten(), distanz);
	}

	@Override
	public int gibDistanz(Pos posAnfang, Pos posEnde) {
		return posAnfang.gibKnoten().gibDistanz(posEnde.gibKnoten());
	}

	@Override
	public int gibData(Pos pos) {
		return pos.gibKnoten().gibData();
	}

}
