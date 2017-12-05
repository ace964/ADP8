package graphen;

import java.util.List;

/**
 * Graph
 * Eine Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public interface Graph {
	
	public Pos[] gibNachbarn(Pos pos);
	
	public  Pos fuegeEin(int integer);
	
	public void verbinde(Pos posAnfang, Pos posEnde, int distanz);
	
	public int gibDistanz(Pos posAnfang, Pos posEnde);
	
	public int gibData(Pos pos);
	
	public int gibAnzahlKnoten();
	
	public List<Pos> gibKnoten();
}
