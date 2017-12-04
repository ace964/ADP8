/**
 * Dykstra
 * Ein Dykstra-Algorithmus, der ein Graphensystem benutzt
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
	public void Dijkstra() {
		
	}
	
	public void zeigeKuerzesteWegeNach(Pos zielPos, Graph graphInstanz) {
		Map<Pos, Weg> kuerzesteWege = new HashMap<Pos, Weg>();
		
		
		Pos[] nachbarn = graphInstanz.gibNachbarn(zielPos);
		Map<Pos, Weg> aktuelleWege = new HashMap<Pos, Weg>();
		for (Pos nachbarPos: nachbarn) {
			int distanz = graphInstanz.gibDistanz(zielPos, nachbarPos);
			aktuelleWege.put(nachbarPos, new Weg(zielPos,distanz));
		}
		
		kuerzesteWege.put(zielPos, new Weg(zielPos,0));
		
		while(!aktuelleWege.isEmpty()) {
			Pos dichtester = gibDichtestePos(aktuelleWege);
			int dichtesteDistanz = aktuelleWege.get(dichtester).gibDistanz();
			kuerzesteWege.put(dichtester, new Weg(aktuelleWege.get(dichtester).gibZiel(),dichtesteDistanz));
			
			for (Pos nachbarPos : graphInstanz.gibNachbarn(dichtester)) {
				if (! kuerzesteWege.containsKey(nachbarPos)) { //nachbar ist ziel oder schon bearbeitet
					if (!aktuelleWege.containsKey(nachbarPos)) { //nachbar ist noch nicht erfasst
					
						int distanzUeberKuerzesten = graphInstanz.gibDistanz(nachbarPos, dichtester) + dichtesteDistanz;
						aktuelleWege.put(nachbarPos, new Weg(dichtester, distanzUeberKuerzesten)) ;
					
					} else { //nachbar ist erfasst und wird ueberprueft
						
						int distanzUeberKuerzesten = graphInstanz.gibDistanz(nachbarPos, dichtester) + dichtesteDistanz;
						if (distanzUeberKuerzesten < aktuelleWege.get(nachbarPos).gibDistanz()) {
							aktuelleWege.get(nachbarPos).setzeDistanz(distanzUeberKuerzesten);
							aktuelleWege.get(nachbarPos).setzeZiel(dichtester);
						}
					}
				}
			}
			
			
			aktuelleWege.remove(dichtester);
		}
		
		//Ergebnisausgabe
		for (Map.Entry<Pos, Weg> eintrag : kuerzesteWege.entrySet()) {
			char ausgangspunkt = graphInstanz.gibData(eintrag.getKey());
			char ueber = graphInstanz.gibData(eintrag.getValue().gibZiel());
			System.out.println(ausgangspunkt + ": " + eintrag.getValue().gibDistanz() + " ueber: " + ueber);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private Pos gibDichtestePos(Map<Pos, Weg> aktuelleWege) {
		Map.Entry<Pos, Weg> aktuellerWeg = null;
		for (Map.Entry<Pos, Weg> eintrag : aktuelleWege.entrySet()) {
			if (aktuellerWeg == null) aktuellerWeg = eintrag;
			if (aktuellerWeg.getValue().gibDistanz() > eintrag.getValue().gibDistanz()) aktuellerWeg = eintrag;
		}
		return aktuellerWeg.getKey();
	}
}
