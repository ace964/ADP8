/**
 * AdjListGraph
 * Eine Listen-Implementation fuer ein Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class AdjListGraph extends Graph<Knoten> {
	
	public AdjListGraph() {
		
	}
	
	@Override
	public Pos<Knoten>[] gibNachbarn(Pos<Knoten> pos) {
		return pos.gibPos().gibNachbarn();
	}
	
	public Pos<Knoten> fuegeEin(char data) {
		return new Pos<Knoten>(new Knoten(data));
	}

	@Override
	public void verbinde(Pos<Knoten> posAnfang, Pos<Knoten> posEnde, int distanz) {
		posAnfang.gibPos().fuegeNachbarnHinzu(posEnde, distanz);
		posEnde.gibPos().fuegeNachbarnHinzu(posAnfang, distanz);
	}

	@Override
	public int gibDistanz(Pos<Knoten> posAnfang, Pos<Knoten> posEnde) {
		Pos<Knoten>[] nachbarn = posAnfang.gibPos().gibNachbarn();
		int distanzIndex = -1;
		for (int i=0; i < nachbarn.length; i++) {
			if (nachbarn[i] == posEnde) {
				distanzIndex = i;
				break;
			}
		}
		if (distanzIndex == -1) {
			throw new IllegalArgumentException("Knoten nicht verbunden");
		} else {
			return posAnfang.gibPos().gibDistanzen()[distanzIndex];
		}
	}

	@Override
	public char gibData(Pos<Knoten> pos) {
		return pos.gibPos().gibData();
	}

}
