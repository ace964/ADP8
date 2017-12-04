/**
 * Graph
 * Eine Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public interface Graph {
	public abstract Pos[] gibNachbarn(Pos pos);
	
	public abstract  Pos fuegeEin(char data);
	
	public abstract void verbinde(Pos posAnfang, Pos posEnde, int distanz);
	
	public abstract int gibDistanz(Pos posAnfang, Pos posEnde);
	
	public abstract char gibData(Pos pos);
}
