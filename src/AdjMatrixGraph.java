import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AdjListGraph
 * Eine Listen-Implementation fuer ein Graphensystem an dem der Dykstra-Algorithmus angewendet werden kann.
 * @author Frederic Dlugi & Maximilian Mang
 *
 */
public class AdjMatrixGraph implements Graph {
	private int[] _data;
	private int[][] _matrix;
	private int _size;
	
	public AdjMatrixGraph() {
		_matrix = new int[15][15];
		_data = new int[15];
		_size = 0;
	}
	
	@Override
	public Pos[] gibNachbarn(Pos pos) {
		List<Pos> nachbarn = new ArrayList<>();
		for(int i = 0; i < _size; i++)
		{
			if(_matrix[pos.gibIndex()][i] != 0)
			{
				nachbarn.add(new Pos(i));
			}
		}
		return nachbarn.toArray(new Pos[nachbarn.size()]);
	}
	
	public Pos fuegeEin(int data) {
		if(_size == _matrix.length)
		{
			vergroessereMatrix();
		}
		_data[_size] = data;
		_size++;
		return new Pos(_size-1);
	}
	
	private void vergroessereMatrix()
	{
		int[][] newMatrix = new int[_matrix.length*2][];
		for(int i = 0; i < _matrix.length; i++)
		{
			if(_matrix[i] != null)
				newMatrix[i] = Arrays.copyOf(_matrix[i], _matrix.length*2);
		}
		_matrix = newMatrix;
		_data = Arrays.copyOf(_data, _matrix.length*2);
	}

	@Override
	public void verbinde(Pos posAnfang, Pos posEnde, int distanz) {
		if(_matrix[posAnfang.gibIndex()] == null)
		{
			_matrix[posAnfang.gibIndex()] = new int[_matrix.length];
		}
		
		if(_matrix[posEnde.gibIndex()] == null)
		{
			_matrix[posEnde.gibIndex()] = new int[_matrix.length];
		}
		
		_matrix[posAnfang.gibIndex()][posEnde.gibIndex()] = distanz;
		_matrix[posEnde.gibIndex()][posAnfang.gibIndex()] = distanz;
	}

	@Override
	public int gibDistanz(Pos posAnfang, Pos posEnde) {
		return _matrix[posAnfang.gibIndex()][posEnde.gibIndex()];
	}

	@Override
	public int gibData(Pos pos) {
		return _data[pos.gibIndex()];
	}

}
