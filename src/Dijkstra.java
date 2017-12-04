/**
 * Dykstra
 * Ein Dykstra-Algorithmus, der ein Graphensystem benutzt
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
	public static void main(String[] args) {
		AdjListGraph listenGraph = new AdjListGraph();
		Pos<Knoten>[] alleKnoten = listenGraph.erstelleTestGraph();
		zeigeKuerzesteWegeNach(alleKnoten[6], listenGraph);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void zeigeKuerzesteWegeNach(Pos zielPos, Graph graphInstanz) {
		Map<Pos, Integer> kuerzesteWege = new HashMap<Pos, Integer>();
		Map<Pos, Pos> kuerzesterWegUeber = new HashMap<Pos, Pos>();
		
		
		Pos[] nachbarn = graphInstanz.gibNachbarn(zielPos);
		Map<Pos, Integer> aktuelleWege = new HashMap<Pos, Integer>();
		Map<Pos, Pos> wegUeber = new HashMap<Pos, Pos>();
		for (Pos nachbarPos: nachbarn) {
			int distanz = graphInstanz.gibDistanz(zielPos, nachbarPos);
			aktuelleWege.put(nachbarPos, distanz);
			wegUeber.put(nachbarPos, zielPos);
		}
		
		kuerzesteWege.put(zielPos, 0);
		kuerzesterWegUeber.put(zielPos, zielPos);
		
		while(!aktuelleWege.isEmpty()) {
			Pos dichtester = gibDichtestePos(aktuelleWege);
			int dichtesteDistanz = aktuelleWege.get(dichtester);
			kuerzesteWege.put(dichtester, dichtesteDistanz);
			kuerzesterWegUeber.put(dichtester, wegUeber.get(dichtester));
			
			for (Pos nachbarPos : graphInstanz.gibNachbarn(dichtester)) {
				if (! kuerzesteWege.containsKey(nachbarPos)) { //nachbar ist ziel oder schon bearbeitet
					if (!aktuelleWege.containsKey(nachbarPos)) { //nachbar ist noch nicht erfasst
						int distanzUeberKuerzesten = graphInstanz.gibDistanz(nachbarPos, dichtester) + dichtesteDistanz;
						aktuelleWege.put(nachbarPos, distanzUeberKuerzesten) ;
						wegUeber.put(nachbarPos, dichtester) ;
					} else { //nachbar ist erfasst und wird ueberprueft
						int distanzUeberKuerzesten = graphInstanz.gibDistanz(nachbarPos, dichtester) + dichtesteDistanz;
						if (distanzUeberKuerzesten < aktuelleWege.get(nachbarPos)) {
							aktuelleWege.remove(nachbarPos);
							wegUeber.remove(nachbarPos);
							aktuelleWege.put(nachbarPos, distanzUeberKuerzesten);
							wegUeber.put(nachbarPos, dichtester);
						}
					}
				}
			}
			
			
			aktuelleWege.remove(dichtester);
			wegUeber.remove(dichtester);
		}
		
		for (Map.Entry<Pos, Integer> eintrag : kuerzesteWege.entrySet()) {
			char ausgangspunkt = graphInstanz.gibData(eintrag.getKey());
			char ueber = graphInstanz.gibData(kuerzesterWegUeber.get(eintrag.getKey()));
			System.out.println(ausgangspunkt + ": " + eintrag.getValue() + " ueber: " + ueber);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static Pos gibDichtestePos(Map<Pos, Integer> aktuelleWege) {
		Map.Entry<Pos, Integer> aktuellerWeg = null;
		for (Map.Entry<Pos, Integer> eintrag : aktuelleWege.entrySet()) {
			if (aktuellerWeg == null) aktuellerWeg = eintrag;
			if (aktuellerWeg.getValue() > eintrag.getValue()) aktuellerWeg = eintrag;
		}
		return aktuellerWeg.getKey();
	}
}
