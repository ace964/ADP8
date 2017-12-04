/**
 * Graph
 * Eine Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public abstract class Graph<posType> {
	public Graph() {
		
	}
	
	abstract Pos<posType>[] gibNachbarn(Pos<posType> pos);
	
	@SuppressWarnings("unchecked")
	public Pos<posType>[] erstelleTestGraph() {
		Pos<posType> pos0 = fuegeEin('A');
		Pos<posType> pos1 = fuegeEin('B');
		Pos<posType> pos2 = fuegeEin('C');
		Pos<posType> pos3 = fuegeEin('D');
		Pos<posType> pos4 = fuegeEin('E');
		Pos<posType> pos5 = fuegeEin('F');
		Pos<posType> pos6 = fuegeEin('G');
		
		verbinde(pos0,pos1,4);
		verbinde(pos0,pos6,5);
		verbinde(pos0,pos5,10);
		
		verbinde(pos1,pos2,7);
		verbinde(pos1,pos6,2);
		
		verbinde(pos2,pos3,12);
		verbinde(pos2,pos6,1);
		
		verbinde(pos3,pos4,3);
		
		verbinde(pos4,pos5,3);
		verbinde(pos4,pos6,8);
		
		verbinde(pos5,pos6,4);
		return new Pos[] {pos0, pos1, pos2, pos3, pos4, pos5, pos6}; //gebe start pos zurueck
	}
	
	public abstract  Pos<posType> fuegeEin(char data);
	
	public abstract void verbinde(Pos<posType> posAnfang, Pos<posType> posEnde, int distanz);
	
	public abstract int gibDistanz(Pos<posType> posAnfang, Pos<posType> posEnde);
	
	public abstract char gibData(Pos<posType> pos);
}
