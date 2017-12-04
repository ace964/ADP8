import java.util.Arrays;

/**
 * AdjListGraph
 * Eine Listen-Implementation fuer ein Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class AdjMatrixGraph extends Graph<Integer> {
	private int[][] _matrix;
	private int _index;
	
	public AdjMatrixGraph() {
		_matrix = new int[0][0];
		int _index = 0;
	}
	
	@Override
	public Pos<Integer>[] gibNachbarn(Pos<Integer> pos) {
		return null;
	}
	
	public Pos<Integer> fuegeEin(char data) {
		if (_index == _matrix.length) {
			int[][] neueMatrix = new int[_matrix.length+1][_matrix.length+1];
			
			Arrays.fill(neueMatrix, -1); //initialize with -1
			
			for (int i=0; i<_matrix.length; i++) {
				for(int j=0; j<_matrix.length; j++) {
					neueMatrix[i][j] = _matrix[i][j];
				}
			}
			_matrix = neueMatrix;
		}
		_index++;
	}

	@Override
	public void verbinde(Pos<Integer> posAnfang, Pos<Integer> posEnde, int distanz) {
		
	}

	@Override
	public int gibDistanz(Pos<Integer> posAnfang, Pos<Integer> posEnde) {
		return 0;
	}

	@Override
	public char gibData(Pos<Integer> pos) {
		return 0;
	}

}
